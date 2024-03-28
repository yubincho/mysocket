package com.example.demo.chatting.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.demo.chatting.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class SocketService {

    public void sendMessage(String room,String eventName, SocketIOClient senderClient, String message) {
        for (
                SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent(eventName,
                        new Message(Message.MessageType.SERVER, message));
            }
        }
    }
}
