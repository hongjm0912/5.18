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

    // 1. 글 저장
    public void savePost(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
    }

    // 2. 특정 위치의 글 조회
    public BoardEntity getPostByPosition(Integer position) {
        return boardRepository.findByPosition(position)
                .orElse(null);
    }

    // 3. 모든 글 조회 (이 부분이 문제였습니다!)
    public List<BoardEntity> findAll() {
        return boardRepository.findAll(); // return을 꼭 써주어야 합니다.
    }
}