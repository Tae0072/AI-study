# PROJECT_CONTEXT

## 1. 프로젝트 개요
- **프로젝트 명**: demo2 (블로그 만들기 프로젝트)
- **목표**: Spring Boot와 JPA를 활용하여 게시글, 댓글, 사용자 관리가 가능한 블로그 시스템을 구축한다.

## 2. 전체 아키텍처
- **패키지 구조**: 도메인 기반 플랫 구조 (Domain-based Flat Structure)
  - `_core/`: 전역 공통 유틸리티 및 예외 처리 (`Resp.java` 등)
  - `{domain}/`: 각 도메인(Board, User, Reply 등)별로 Entity, Controller, Service, Repository, DTO 파일을 한 곳에 모아 관리
- **계층 구조**:
  - **Presentation Layer**: Mustache를 이용한 SSR(`@Controller`) 및 REST API(`@RestController`) 분리 운영
  - **Service Layer**: 비즈니스 로직 처리 및 DTO 변환 담당 (`@Transactional(readOnly = true)` 기본 적용)
  - **Persistence Layer**: Spring Data JPA를 사용한 데이터 접근 (`Integer` PK, `LAZY` 전략 준수)

## 3. 기술 스택
- **언어**: Java 21
- **프레임워크**: Spring Boot 4.0.3
- **데이터베이스**: H2 (In-memory)
- **ORM**: Spring Data JPA (Hibernate)
- **템플릿 엔진**: Mustache (SSR)
- **빌드 도구**: Gradle
- **주요 라이브러리**: Lombok, H2-Console

## 4. 핵심 규칙 (Core Rules)
- **응답 방식**: 모든 REST API는 `_core/utils/Resp.java`를 통해 공통된 형식으로 응답한다.
- **성능 최적화**: OSIV(`false`)를 비활성화하고, 모든 연관관계는 `LAZY`로 설정하여 지연 로딩을 강제한다.
- **데이터 전달**: Controller에 Entity를 절대 노출하지 않으며, 반드시 Service 레이어에서 생성된 DTO를 사용한다.
- **인증/인가**: 기본적으로 `HttpSession`을 사용하여 세션 기반 인증을 구현한다.
- **프론트엔드**: Vanilla CSS와 JavaScript(async/await fetch)를 기본으로 하며, 복잡한 로직이 아니면 표준 HTML 폼 제출 방식을 우선한다.
