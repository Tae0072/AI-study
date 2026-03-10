<!-- Parent: ../AI-CONTEXT.md -->

# .person Context

## 목적

개발자(사용자)가 직접 작성한 작업 목록, 커스텀 룰, 그리고 상세 설계(Workflow)를 보관한다.

## 하위 디렉토리

- `rule/` - 개발자가 선호하는 특정 스타일이나 룰.
- `task/` - 현재 진행 중이거나 예정된 작업 목록 (`task.md`).
- `workflow/` - 특정 기능 구현을 위한 단계별 실행 흐름 설계도.

## AI 작업 지침

- **Highest Priority**: `.person/workflow/`에 정의된 흐름은 AI의 코드 작성 시 가장 우선시되는 설계도이다.
- **Task Tracking**: 작업 완료 후 `task/task.md`를 업데이트하여 진행 상태를 관리함.
