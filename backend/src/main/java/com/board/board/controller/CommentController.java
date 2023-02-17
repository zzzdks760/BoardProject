package com.board.board.controller;

import com.board.board.dto.CommentDTO;
import com.board.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("board/comments")
    public String save(@RequestBody CommentDTO commentDTO) {
        System.out.println("commentDTO = " + commentDTO);
        Long saveResult = commentService.save(commentDTO);
        if (saveResult != null) {
            // 작성 성공하면 댓글목록을 가져와서 리턴
            // 댓글목록 : 해당 게시글의 댓글 전체(해당게시글 id를 기준으로 댓글전체를 가져옴)
            List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
            return "ok";
        } else {
            return null;
        }
    }
    @PostMapping("board/commentsList")
    public List<CommentDTO> findById(@RequestBody Long id) {
        return commentService.findById(id);
    }
}
