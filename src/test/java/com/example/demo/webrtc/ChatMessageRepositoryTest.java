package com.example.demo.webrtc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class ChatMessageRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ChatMessageRepository chatMessageRepository;


    @Test
    void testSaveMessage() {
        ChatMessage message = new ChatMessage("user1", "Hello");

        ChatMessage savedMessage = chatMessageRepository.save(message);

        ChatMessage foundMessage = entityManager.find(ChatMessage.class, savedMessage.getId());

        assertThat(foundMessage.getSender()).isEqualTo(message.getSender());
        assertThat(foundMessage.getContent()).isEqualTo(message.getContent());
    }

}