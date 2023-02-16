package com.board.board.entity;

import com.board.board.dto.CommentDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
public class CommentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String comment;

    /* Board Comment = 1:N (Comment가 Board의 자식이 되게 설정)*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    public static CommentEntity toSaveEntity(CommentDTO commentDTO, BoardEntity boardEntity) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(commentDTO.getComment());
        commentEntity.setBoardEntity(boardEntity);
        return commentEntity;
    }
}
