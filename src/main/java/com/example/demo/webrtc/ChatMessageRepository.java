package com.example.demo.webrtc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    // 필요한 쿼리 메소드를 여기에 추가
}


