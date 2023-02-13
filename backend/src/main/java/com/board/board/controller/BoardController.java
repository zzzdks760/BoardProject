package com.board.board.controller;

import com.board.board.dto.BoardDTO;
import com.board.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class BoardController {

    private final BoardService boardService;

    // 게시글작성
    @PostMapping("board/write")
    public String write(@RequestBody BoardDTO boardDTO) {
        System.out.println("boardDTO = " + boardDTO);
        return boardService.save(boardDTO);
    }

    // 전체 게시글조회
    @GetMapping("board/boardList")
    public List<BoardDTO> findAll(Model model) {
        // DB에서 전체 게시글 테이터를 가져와서 board/boardList로 넘겨준다.
        return boardService.findAll();
    }

    // 게시글수정(수정버튼 클릭시)
    //GetMapping으로 줘야하는지 체크

    // 게시글수정(수정완료시)
    @PostMapping("board/update")
    public String update(@RequestBody BoardDTO boardDTO) {
        System.out.println("boardDTO = " + boardDTO);
        return boardService.update(boardDTO);
    }

    // 게시글 삭제
    @PostMapping("board/delete/{id}")
    public String delete(@PathVariable Long id) {
        return boardService.delete(id);
    }

    @PostMapping("board/hit/{id}")
    public String updateHits(@PathVariable Long id) {
        return boardService.updateHits(id);
    }

}
