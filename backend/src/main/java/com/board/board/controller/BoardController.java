package com.board.board.controller;

import com.board.board.dto.BoardDTO;
import com.board.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class BoardController {

    private final BoardService boardService;

    // 게시글작성
    @PostMapping("board/write")
    public String write(@RequestParam BoardDTO boardDTO) {
        System.out.println("boardDTO = " + boardDTO);
        return boardService.save(boardDTO);
    }

    // 전체 게시글조회
    @GetMapping("board/boardList")
    public List<BoardDTO> findAll(Model model) {
        // DB에서 전체 게시글 테이터를 가져와서 board/boardList로 넘겨준다.
        return boardService.findAll();
    }
}
