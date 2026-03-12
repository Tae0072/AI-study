<!-- Parent: ../AI-CONTEXT.md -->

# com.example.demo2.user

## 목적

사용자 인증 및 회원 관리 기능을 담당하는 도메인 패키지.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `User.java` | 사용자 엔티티 (회원 정보) |
| `UserController.java` | SSR 기반 회원 가입/로그인 화면 및 폼 제출 처리 |
| `UserService.java` | 회원 관련 비즈니스 로직 및 DTO 변환 |
| `UserRepository.java` | User 엔티티에 대한 JPA 레포지토리 |
| `UserRequest.java` | 회원 가입(`Join`), 로그인(`Login`) 등 요청 DTO |
| `UserResponse.java` | 회원 정보 조회용 응답 DTO |

## AI 작업 지침

- **SSR/API 분리**: 현재 SSR만 존재하며, REST API 추가 시 `UserApiController.java`를 생성할 것.
- **DTO 규칙**: `UserRequest.java` 내부의 static class로 기능을 정의하며(Join, Login), `@Data`는 내부 static class에만 사용한다.
- **Service Layer**: `@Transactional(readOnly = true)`를 클래스 레벨에 선언하고, Entity를 Controller로 직접 반환하지 말 것.

## 의존성

- 내부: `_core/utils/Resp.java` (API 응답 시)
- 외부: Spring Data JPA, Lombok, Validation
