package com.example.demo.webrtc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/chat")   // http://localhost:8080/chat
public class ChatMessageController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @GetMapping
    public String getChatPage() {
        return "chat";
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        log.info("Received message: {}", chatMessage.getContent());
        chatMessageRepository.save(chatMessage); // 메시지를 DB에 저장
        return chatMessage; // 모든 구독자에게 메시지를 브로드캐스트
    }
}
