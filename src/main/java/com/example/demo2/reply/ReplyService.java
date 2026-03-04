package com.example.demo2.reply;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo2.board.Board;
import com.example.demo2.board.BoardRepository;
import com.example.demo2.user.User;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public ReplyResponse.DetailDTO 댓글쓰기(ReplyRequest.SaveDTO requestDTO, User user) {
        Board board = boardRepository.findById(requestDTO.getBoardId())
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다"));

        Reply reply = Reply.builder()
                .comment(requestDTO.getComment())
                .user(user)
                .board(board)
                .build();

        replyRepository.save(reply);
        return new ReplyResponse.DetailDTO(reply);
    }
}
