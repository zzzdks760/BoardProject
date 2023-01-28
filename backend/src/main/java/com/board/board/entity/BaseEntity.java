package com.board.board.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 매핑정보만 상속받을때
@EntityListeners(AuditingEntityListener.class) // 시간에 대해서 자동으로 값을 넣어주는 기능
@Getter

public class BaseEntity {
    @CreationTimestamp // 생성시 시간정보를 줌
    @Column(updatable = false) // 수정시 관여x
    private LocalDateTime createdTime;

    @UpdateTimestamp // 업데이트시 시간정보 줌
    @Column(insertable = false) // 입력시 관여x
    private LocalDateTime updatedTime;

}
