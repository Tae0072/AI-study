package com.example.demo2.user;

import lombok.Data;

/**
 * RULE : Max, Min, Detail DTO이름을 취소, 최대, 상세를 기본으로 한다.
 */
public class UserResponse {

    @Data
    public static class Min {
        private String username;
        private String email;

        public Min(User user) {
            this.username = user.getUsername();
            this.email = user.getEmail();
        }
    }
}
