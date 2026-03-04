package com.example.demo2.reply;

import lombok.Data;

public class ReplyRequest {

    @Data
    public static class SaveDTO {
        private String comment;
        private Integer boardId;
    }
}
