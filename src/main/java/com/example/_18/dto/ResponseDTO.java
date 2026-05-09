package com.example._18.dto;

import com.example._18.entity.BoardEntity;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ResponseDTO {
    private String name;
    private String content;
    private Integer position;
    private LocalDateTime createdAt;

    public ResponseDTO(BoardEntity entity) {
        this.name = entity.getName();
        this.content = entity.getContent();
        this.position = entity.getPosition(); // BoardEntity에 position 필드가 있어야 합니다!
        this.createdAt = entity.getCreatedAt();
    }
}

