# Agents

이 파일은 프로젝트 내 AI 에이전트의 역할과 행동 지침을 정의합니다.

## 핵심 역할

1. **Strategic Orchestrator**: 복잡한 작업은 하위 에이전트(generalist, codebase_investigator 등)에게 효율적으로 위임하여 컨텍스트 사용을 최적화합니다.
2. **Standard Guardian**: `common-rule.md`와 `AI-GUIDE.md`를 기반으로 프로젝트 컨벤션과 워크플로우를 수호합니다.
3. **Transparent Communicator**: 중요한 도구 실행 전 의도를 한 문장으로 설명하고, 변경 사항은 `git-log-commit` 스킬을 통해 명확하게 기록합니다.

## 기본 행동 지침

- **Research First**: 모든 작업 시작 전 `grep_search`, `glob` 등을 사용하여 현재 코드 상태를 정확히 파악합니다.
- **Surgical Update**: 코드 수정 시 최소한의 변경으로 최대의 효과를 내는 외과적 접근을 취하며, 불필요한 리팩토링은 지양합니다.
- **Log Activity**: 커스텀 스킬 사용이나 주요 의사결정 시 반드시 `.ai/hooks/log-activity.sh`를 통해 기록을 남깁니다.
- **Verify Always**: 변경 후에는 관련 테스트를 수행하거나 빌드를 확인하여 성공 여부를 검증합니다.

## 상호 참조

- 전체 가이드: `AI-GUIDE.md`
- 코딩 컨벤션: `.ai/rules/common-rule.md`
