package com.board.board.service;

import com.board.board.dto.BoardDTO;
import com.board.board.entity.BoardEntity;
import com.board.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public String save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
        return "ok";
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    public String update(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);
        boardRepository.save(boardEntity);
        return "ok";
    }

//    public BoardDTO findById(Long id) {
//        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
//        if (optionalBoardEntity.isPresent()) {
//            BoardEntity boardEntity = optionalBoardEntity.get();
//            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
//            return boardDTO;
//        } else {
//            return null;
//        }
//    }

    public String delete(Long id) {
        boardRepository.deleteById(id);
        return "ok";
    }

    public String updateHits(Long id) {
        boardRepository.updateHits(id);
        return "ok";
    }

    public Page<BoardDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber() - 1; // page ????????? ?????? ?????? 0?????? ??????
        int pageLimit = 3; // ??? ???????????? ????????? ??? ??????
        // ??? ???????????? 3?????? ?????? ???????????? ?????? ????????? id ???????????? ???????????? ??????
        Page<BoardEntity> boardEntities =
                boardRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        System.out.println("boardEntities.getContent() = " + boardEntities.getContent()); // ?????? ???????????? ???????????? ???
        System.out.println("boardEntities.getTotalElements() = " + boardEntities.getTotalElements()); // ?????? ?????????
        System.out.println("boardEntities.getNumber() = " + boardEntities.getNumber()); // DB??? ????????? ????????? ??????
        System.out.println("boardEntities.getTotalPages() = " + boardEntities.getTotalPages()); // ?????? ????????? ??????
        System.out.println("boardEntities.getSize() = " + boardEntities.getSize()); // ??? ???????????? ???????????? ??? ??????
        System.out.println("boardEntities.hasPrevious() = " + boardEntities.hasPrevious()); // ?????? ????????? ?????? ??????
        System.out.println("boardEntities.isFirst() = " + boardEntities.isFirst()); // ??? ????????? ??????
        System.out.println("boardEntities.isLast() = " + boardEntities.isLast()); // ????????? ????????? ??????

        // ??????: id, email, title, createdTime, hits
        Page<BoardDTO> boardDTOS = boardEntities.map(board -> new BoardDTO(board.getId(), board.getMemberEmail(), board.getBoardTitle(), board.getBoardHits(), board.getCreatedTime()));
        return boardDTOS;

    }

    public Page<BoardDTO> boardSearchList(String searchKeyword, Pageable pageable) {

        Page<BoardEntity> boardEntities = boardRepository.findByboardTitleContaining(searchKeyword, pageable);
        Page<BoardDTO> boardDTOPage = boardEntities.map(board -> new BoardDTO(board.getId(), board.getMemberEmail(), board.getBoardTitle(), board.getBoardHits(), board.getCreatedTime()));
        return boardDTOPage;
    }
}
