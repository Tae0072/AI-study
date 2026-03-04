package com.example.demo2.reply;

import lombok.Data;

public class ReplyResponse {

    @Data
    public static class DetailDTO {
        private Integer id;
        private String comment;
        private String username;

        public DetailDTO(Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.username = reply.getUser().getUsername();
        }
    }
}
