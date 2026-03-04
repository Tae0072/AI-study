package com.example.demo2.reply;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2._core.utils.Resp;
import com.example.demo2.user.User;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReplyController {

    private final ReplyService replyService;
    private final HttpSession session;

    @PostMapping("/reply")
    public ResponseEntity<?> save(@RequestBody ReplyRequest.SaveDTO requestDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new RuntimeException("인증되지 않았습니다");
        }
        ReplyResponse.DetailDTO responseDTO = replyService.댓글쓰기(requestDTO, sessionUser);
        return Resp.ok(responseDTO);
    }
}
