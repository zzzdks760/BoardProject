package com.board.board.repository;

import com.board.board.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // 조회수를 올렸는데 board/update의 시간이 수정되는 기이한 현상을 보완해줌
    @Transactional
    @Modifying
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
    void updateHits(@Param("id") Long id);

    Page<BoardEntity> findByboardTitleContaining(String searchKeyword, Pageable pageable);
}
