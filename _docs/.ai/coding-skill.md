# 코딩 스킬: Spring Boot & JPA 컨벤션 (demo2)

이 문서는 AI가 프로젝트의 코딩 표준을 준수하기 위한 전문 지침을 제공합니다. 코드를 생성하거나 리팩토링할 때 이 규칙을 엄격히 준수하십시오.

## 1. 시스템 아키텍처 지침
- **패턴**: 계층형 아키텍처 (Controller -> Service -> Repository -> Entity).
- **도메인 패키징**: 도메인별로 컴포넌트를 그룹화합니다 (예: `board`, `user`).
- **Core 패키지**: 유틸리티, 글로벌 예외 처리, 공통 응답 형식을 위해 `_core` 패키지를 사용합니다.

## 2. 엔티티(Entity) 표준
- **명명 규칙**: 항상 `@Table(name = "도메인명_tb")`를 사용합니다.
- **기본 키**: `GenerationType.IDENTITY` 전략과 함께 `Integer id`를 사용합니다.
- **연관 관계**: 
    - 모든 연관 관계에는 반드시 `FetchType.LAZY`를 사용해야 합니다.
    - `@Builder`가 지정된 생성자에 컬렉션 필드(List, Set 등)를 포함하지 마십시오.
- **감사(Audit)**: `@CreationTimestamp`와 `LocalDateTime`을 사용합니다.
- **Lombok**: `@NoArgsConstructor`, `@Data`, `@Builder`를 조합하여 사용합니다.

## 3. DTO 구현 규칙
- **생명주기**: 서비스(Service) 레이어에서 반드시 DTO를 생성해야 합니다. 엔티티를 컨트롤러에 직접 전달하지 마십시오.
- **구조**: `Request` 및 `Response` 클래스 내부의 static 내부 클래스를 사용합니다.
- **명명 규칙**:
    - **Request**: 기능적 명칭을 사용합니다 (`Save`, `Update`, `Login`, `Join`).
    - **Response**: 상세 수준에 따른 명칭을 사용합니다 (`Min`, `Max`, `Detail`).

## 4. 서비스 레이어 로직
- **트랜잭션**:
    - 클래스 레벨에서 `@Transactional(readOnly = true)`를 사용합니다.
    - 쓰기 작업(생성, 수정, 삭제)에는 별도로 `@Transactional`을 사용합니다.
- **메서드 명명**: 도메인 언어를 반영하기 위해 비즈니스 로직에는 **한글 메서드명**을 사용합니다 (예: `회원가입`, `로그인`).
- **의존성 주입**: `final` 필드와 `@RequiredArgsConstructor`를 사용합니다.

## 5. 컨트롤러 및 응답
- **의존성 주입**: 생성자(`final`)를 통해 Service와 `HttpSession`을 주입합니다.
- **API 응답**: 항상 데이터를 `_core.utils.Resp<T>`로 감싸야 합니다.
    - 성공: `Resp.ok(body)`
    - 실패: `Resp.fail(status, message)`

## 6. 금지 사항 (부정 제약 조건)
- `FetchType.EAGER`를 절대 사용하지 마십시오.
- 컨트롤러에서 엔티티를 직접 반환하지 마십시오.
- 필드 주입(Field Injection)을 사용하지 마십시오. 반드시 생성자 주입을 사용하십시오.
- 컨트롤러에 복잡한 로직을 두지 마십시오. 컨트롤러는 얇게 유지해야 합니다.
