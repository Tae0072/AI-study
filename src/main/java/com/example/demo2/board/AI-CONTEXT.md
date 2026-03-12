<!-- Parent: ../AI-CONTEXT.md -->

# com.example.demo2.board

## 목적

게시글 작성, 조회, 수정, 삭제(CRUD) 및 게시판 기능을 담당하는 도메인 패키지.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `Board.java` | 게시글 엔티티 (`board_tb`) |
| `BoardController.java` | SSR 기반 게시판 화면(목록, 상세, 작성폼) 처리 |
| `BoardService.java` | 게시글 관련 비즈니스 로직 및 DTO 변환 |
| `BoardRepository.java` | Board 엔티티에 대한 JPA 레포지토리 |
| `BoardRequest.java` | 게시글 저장(`Save`), 수정(`Update`) 요청 DTO |
| `BoardResponse.java` | 게시글 목록/상세 조회 응답 DTO (`Max`, `Min`, `Detail`) |

## AI 작업 지침

- **LAZY Loading**: Board와 User, Reply 간의 연관관계는 반드시 `FetchType.LAZY`를 유지한다.
- **DTO 규칙**: Service 레이어에서 Entity를 DTO로 변환하여 반환하며, 응답 DTO는 `BoardResponse` 내부의 명명 규칙(`Max`, `Min`, `Detail`)을 따른다.
- **Transaction**: 쓰기 메서드(`save`, `update`, `delete`)에는 개별적으로 `@Transactional`을 선언한다.

## 의존성

- 내부: `com.example.demo2.user`, `com.example.demo2.reply`, `_core/utils/Resp.java`
- 외부: Spring Data JPA, Lombok
