<!-- Parent: ../AI-CONTEXT.md -->

# com.example.demo2.reply

## 목적

게시글에 대한 댓글 작성 및 삭제 기능을 담당하는 도메인 패키지.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `Reply.java` | 댓글 엔티티 (`reply_tb`) |
| `ReplyController.java` | SSR/Ajax 기반 댓글 처리 (필요시 API 컨트롤러 분리) |
| `ReplyService.java` | 댓글 관련 비즈니스 로직 및 DTO 변환 |
| `ReplyRepository.java` | Reply 엔티티에 대한 JPA 레포지토리 |
| `ReplyRequest.java` | 댓글 저장(`Save`) 요청 DTO |
| `ReplyResponse.java` | 댓글 목록 응답 DTO |

## AI 작업 지침

- **Ajax/SSR**: 댓글은 Ajax를 통한 부분 갱신이 필요할 수 있으며, 이 경우 `@RestController`로 분리하여 구현한다.
- **OSIV=false**: OSIV가 꺼져 있으므로 지연 로딩 시 Service 레이어 내에서 필요한 데이터를 미리 로드하거나 DTO로 변환하여 반환해야 함을 주의할 것.
- **Entity PK**: PK 타입은 `Integer`를 사용한다.

## 의존성

- 내부: `com.example.demo2.user`, `com.example.demo2.board`
- 외부: Spring Data JPA, Lombok
