<!-- Parent: ../../../AI-CONTEXT.md -->

# src/main/resources Context

## 목적

애플리케이션의 설정 파일, DB 초기화 스크립트, 그리고 뷰 템플릿(Mustache)을 보관한다.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `application.properties` | 서버 포트, DB 설정, JPA 설정(OSIV=false 필수) 등 포함 |

## 하위 디렉토리

- `db/` - `data.sql` 등 초기 데이터 스크립트.
- `templates/` - SSR을 위한 Mustache 템플릿 파일들.
- `static/` - 정적 리소스 (JS, CSS, Images).

## AI 작업 지침

- **Hard Rules**: `application.properties` 내의 OSIV 설정을 절대 `true`로 변경하지 말 것.
- **Template Separation**: `templates/layout/`의 헤더/푸터를 적극 활용하여 뷰의 재사용성을 높인다.
