package com.board.board.service;

import com.board.board.dto.BoardDTO;
import com.board.board.entity.BoardEntity;
import com.board.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
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

    // 값이 잘 넘어가는지 확인필요, 안넘어가면 컨트롤러에서 Get으로주는거 만들어서 findById메서드(리턴값 boardDTO로 바꿔야함) 리턴
//    private String findById(Long id) {
//        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
//        if (optionalBoardEntity.isPresent()) {
//            BoardEntity boardEntity = optionalBoardEntity.get();
//            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
//            return "ok";
//        }
//        else {
//            return null;
//        }
//    }

    public String delete(Long id) {
        boardRepository.deleteById(id);
        return "ok";
    }
}
