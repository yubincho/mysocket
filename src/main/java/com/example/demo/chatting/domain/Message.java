package com.example.demo.chatting.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;


@NoArgsConstructor
@Data
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long chatId;

    @Column(name = "type", nullable = false)
    private MessageType type;

    @Column(name = "message", nullable = true)
    private String message;

    @Column(name = "room", nullable = false)
    private String room;

    public Message(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    public enum MessageType {
        SERVER, CLIENT
    }

}
