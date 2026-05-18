package com.example._18.service;

import com.example._18.entity.BoardEntity;
import com.example._18.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final Object positionLock = new Object();

    public void savePost(BoardEntity boardEntity) {
        synchronized (positionLock) {
            boardEntity.setPosition(boardRepository.findMaxPosition() + 1);
            boardRepository.saveAndFlush(boardEntity);
        }
    }

    public BoardEntity getPostByPosition(Integer position) {
        return boardRepository.findByPosition(position)
                .orElse(null);
    }

    public List<BoardEntity> findAll() {
        return boardRepository.findAll();
    }
}