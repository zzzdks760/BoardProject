package com.board.board.controller;

import com.board.board.dto.BoardDTO;
import com.board.board.service.BoardService;
import com.board.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

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

    // 게시글 조회수
    @PostMapping("board/hit/{id}")
    public String updateHits(@PathVariable Long id) {
        return boardService.updateHits(id);
    }

    // 페이징처리
    // /board/paging?page=1
    @GetMapping("/board/paging")
    public Page<BoardDTO> paging(@PageableDefault(page = 1)Pageable pageable, Model model, String searchKeyword) {
//        pageable.getPageNumber();

        if (searchKeyword == null) {
            Page<BoardDTO> boardList = boardService.paging(pageable);
        } else {
            Page<BoardDTO> boardList = boardService.boardSearchList(searchKeyword, pageable);
        }


        Page<BoardDTO> boardList = boardService.paging(pageable);
        int blockLimit = 3;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 ~~
        int endPage = ((startPage + blockLimit - 1) < boardList.getTotalPages()) ? startPage + blockLimit - 1 : boardList.getTotalPages();

        // page 갯수 20개
        // 현재 사용자가 3페이지
        // 1 2 3
        // 현재 사용자가 7페이지
        // 7 8 9
        // 보여지는 페이지 갯수 3개
        // 총 페이지 갯수 8개
        model.addAttribute("boardList", boardList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return boardList;

    }

//    @PostMapping("board/commentsList")
//    public BoardDTO findById(@RequestBody Long id){
//        return boardService.findById(id);
//        /* 댓글 목록 가져오기 */
////        return commentService.findAll(id);
//    }

//    @PostMapping("board/search")
//    public Page<BoardDTO> boardSearchList(String searchKeyword, Pageable pageable) {
//        boardService.boardSearchList(searchKeyword);
//    }

}
