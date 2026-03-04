# 프로젝트 코드 컨벤션 (Code Convention)

이 문서는 `demo2` 프로젝트의 코드 작성 규칙을 정의합니다. `board` 및 `user` 패키지의 기존 코드를 기반으로 작성되었습니다.

## 1. 프로젝트 구조 및 패키지 설계
- **도메인 중심 패키지**: 각 도메인별로 패키지를 구성합니다. (예: `board`, `user`)
- **계층형 아키텍처**: Entity -> Repository -> Service -> Controller 구조를 따릅니다.
- **공통 모듈**: 공통 유틸리티, 예외 처리 등은 `_core` 패키지에서 관리합니다.

## 2. 엔티티 (Entity) 규칙
- **테이블 명명**: `@Table(name = "도메인명_tb")` 형식을 사용합니다.
- **기본 키**: `Integer id`를 사용하며, 전략은 `GenerationType.IDENTITY`로 설정합니다.
- **연관 관계**:
    - 모든 연관 관계는 지연 로딩(`FetchType.LAZY`)을 원칙으로 합니다.
    - OSIV(Open Session In View)는 `false`로 설정하는 것을 지향합니다.
- **공통 필드**: 생성 시간 등은 `@CreationTimestamp`와 `LocalDateTime`을 사용합니다.
- **Lombok 활용**:
    - `@NoArgsConstructor`, `@Data`, `@Builder`를 기본적으로 사용합니다.
    - **주의**: 컬렉션(List 등) 필드는 `@Builder`가 적용된 생성자에 포함하지 않습니다.

## 3. DTO (Data Transfer Object) 규칙
- **위치 및 구조**: 각 도메인 패키지에 `Request`, `Response` 클래스를 만들고, 내부 static class로 세부 DTO를 정의합니다.
- **책임 분리**: DTO는 **Service 계층**에서 생성합니다. Entity를 Controller까지 전달하지 않고 반드시 DTO로 변환하여 반환합니다.
- **명명 규칙**:
    - **요청(Request)**: 기능명으로 작성합니다. (예: `Save`, `Update`, `Login`, `Join`)
    - **응답(Response)**: 데이터의 상세 수준에 따라 작성합니다. (`Min`(최소), `Max`(최대), `Detail`(상세))

## 4. 서비스 (Service) 규칙
- **트랜잭션 관리**:
    - 클래스 상단에 `@Transactional(readOnly = true)`를 선언하여 기본적으로 조회 전용으로 설정합니다.
    - 등록, 수정, 삭제 등의 데이터 변경이 일어나는 메서드에는 별도로 `@Transactional`을 선언합니다.
- **의존성 주입**: `final` 필드와 `@RequiredArgsConstructor`를 사용하여 생성자 주입을 수행합니다.
- **메서드 명명**: 서비스의 비즈니스 로직을 명확히 드러내기 위해 **한글 메서드명**을 사용할 수 있습니다. (예: `회원가입`, `로그인`)

## 5. 컨트롤러 (Controller) 규칙
- **의존성**: 필요한 Service와 `HttpSession` 등을 `final`로 선언하여 주입받습니다.
- **반환 타입**:
    - 머스테치(Mustache) 템플릿을 사용하는 경우 뷰의 이름을 문자열로 반환합니다.
    - API 응답의 경우 `_core.utils.Resp` 클래스를 사용하여 일관된 형식을 유지합니다.

## 6. 공통 응답 형식 (Resp)
- 모든 API 응답은 아래의 형식을 유지합니다:
    - `status`: HTTP 상태 코드 또는 커스텀 코드 (Integer)
    - `msg`: 응답 메시지 (String)
    - `body`: 실제 데이터 (Generic T)
- `Resp.ok(body)`와 `Resp.fail(status, msg)` 메서드를 통해 응답을 생성합니다.
