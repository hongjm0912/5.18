package com.example._18.controller;

import com.example._18.entity.BoardEntity;
import com.example._18.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@CrossOrigin(origins = "*")
public class BoardController {

    private final BoardService boardService;

    // 1. 글 등록 기능 (POST)
    @PostMapping("/register")
    public ResponseEntity<String> registerPost(@RequestBody BoardEntity boardEntity) {
        try {
            boardService.savePost(boardEntity);
            return ResponseEntity.ok("글이 성공적으로 등록되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("등록 중 오류가 발생했습니다.");
        }
    }

    // 2. 특정 위치번호로 글 조회 기능 (GET)
    @GetMapping("/{position}")
    public ResponseEntity<BoardEntity> getPost(@PathVariable Integer position) {
        BoardEntity post = boardService.getPostByPosition(position);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 3. 전체 블록 상태 확인용 - 모든 글 목록 조회
    @GetMapping("/list")
    public List<BoardEntity> getAllPosts() {
        return boardService.findAll();
    }
}