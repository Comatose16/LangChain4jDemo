package com.langchain4j.demo.service;

import com.langchain4j.demo.Assistant;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AssistantService {

    private final Assistant assistant;

    public AssistantService(Assistant assistant) {
        this.assistant = assistant;
    }

    public String chat(String chatId, String userMessage) {
        return assistant.chat(chatId, userMessage);
    }
    public Flux<String> chatStream(String chatId, String userMessage) {
        return assistant.chatStream(chatId, userMessage);
    }
}
