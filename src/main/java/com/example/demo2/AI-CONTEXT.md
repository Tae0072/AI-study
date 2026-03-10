<!-- Parent: ../../AI-CONTEXT.md -->

# src/main/java/com/example/demo2 Context

## 목적

블로그 서비스의 핵심 비즈니스 로직 및 엔티티를 포함하는 소스 코드의 메인 패키지.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `Demo2Application.java` | Spring Boot 애플리케이션의 엔트리 포인트 |

## 하위 디렉토리 (도메인 기반 플랫 구조)

- `_core/` - 도메인 무관 공통 유틸리티 (응답 래퍼 `Resp.java` 등).
- `user/` - 회원 관련 엔티티, 컨트롤러(SSR/API), 서비스, 레포지토리, DTO.
- `board/` - 게시글 관련 비즈니스 로직.
- `reply/` - 댓글 관련 비즈니스 로직.

## AI 작업 지침

- **Domain Flat Structure**: 패키지를 레이어로 나누지 말고, 항상 해당 도메인 폴더 내에 모든 파일을 배치한다.
- **Separation of Concerns**: SSR 컨트롤러와 REST API 컨트롤러는 반드시 별도 파일로 분리한다.
- **Lombok Usage**: `@Data`는 내부 static class(DTO)에서만 사용하며, Entity는 명시적인 `@Builder`와 생성자를 사용한다.

## 의존성

- **Internal**: `_core/utils/Resp.java` (모든 API 응답에 사용).
- **External**: Spring Data JPA, Hibernate, Lombok.
