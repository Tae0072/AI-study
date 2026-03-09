-- 유저 더미 데이터
INSERT INTO user_tb (username, password, email, zipcode, address, detail_address, created_at) VALUES ('ssar', '1234', 'ssar@gmail.com', '12345', '부산시 해운대구', '101호', NOW());
INSERT INTO user_tb (username, password, email, zipcode, address, detail_address, created_at) VALUES ('cos', '1234', 'cos@gmail.com', '54321', '서울시 강남구', '202호', NOW());

-- 게시글 더미 데이터
INSERT INTO board_tb (title, content, user_id, created_at) VALUES ('첫 번째 게시글', '안녕하세요. ssar의 첫 번째 글입니다.', 1, NOW());
INSERT INTO board_tb (title, content, user_id, created_at) VALUES ('두 번째 게시글', '안녕하세요. ssar의 두 번째 글입니다.', 1, NOW());
INSERT INTO board_tb (title, content, user_id, created_at) VALUES ('세 번째 게시글', '안녕하세요. cos의 첫 번째 글입니다.', 2, NOW());