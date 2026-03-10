<!-- Parent: ../AI-CONTEXT.md -->

# src/main/java/com/example/demo2/_core Context

## 목적

도메인에 종속되지 않는 공통 유틸리티, 예외 처리기, 필터 등을 보관한다.

## 하위 디렉토리

- `utils/` - 프로젝트 전역에서 사용하는 유틸리티 클래스 (`Resp.java` 등).

## AI 작업 지침

- **Convention**: 모든 REST API의 응답은 이곳의 `Resp.java`를 사용하도록 강제함.
- **Core First**: 도메인 코드보다 핵심 인프라 코드를 수정할 때는 사이드 이펙트를 면밀히 검토할 것.
