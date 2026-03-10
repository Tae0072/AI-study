# Root Context

## 목적

Spring Boot 기반의 블로그 만들기 프로젝트의 최상위 디렉토리.
프로젝트의 빌드 설정, 의존성 관리, 그리고 AI/개발자 전용 가이드 문서를 포함한다.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `AI-GUIDE.md` | AI 에이전트가 이 프로젝트에서 행동해야 하는 핵심 원칙 (Workflow 중심) |
| `build.gradle` | 프로젝트 의존성 및 빌드 설정 (Spring Boot 3.3.4, Java 21) |
| `settings.gradle` | 프로젝트 이름 및 모듈 구성 |
| `README.md` | 프로젝트 기본 개요 및 실행 방법 |
| `GEMINI.md` | Gemini CLI 전용 설정 및 지침 |

## 하위 디렉토리

- `.ai/` - AI 전용 컨벤션, 스킬, 프로젝트 맥락 정보 관리.
- `.person/` - 개발자의 설계(Workflow) 및 수동 관리 작업 목록.
- `src/` - 실제 애플리케이션 소스 코드 (Java, Resources).
- `gradle/` - Gradle Wrapper 관련 설정.

## AI 작업 지침

- **Context Loading**: 작업을 시작할 때 반드시 `AI-GUIDE.md`를 읽어야 함.
- **Workflow First**: `.person/workflow/`에 정의된 설계를 코드로 옮기는 작업을 우선함.
- **Build System**: `build.gradle` 수정 시 의존성 충돌에 주의할 것.

## 의존성

- **Core**: Spring Boot Starter Web, Data JPA, Mustache, Validation.
- **DB**: H2 (In-Memory).
- **Tool**: Lombok, DevTools.
