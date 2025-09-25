package com.langchain4j.demo.controller;

import com.langchain4j.demo.service.AssistantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AssistantController {

    public final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @GetMapping(value = "/assistant")
    public String assistant(String chatId, String userMessage) {
        return assistantService.chat(chatId, userMessage);
    }

    @GetMapping(value = "/strramingAssistant", produces = "text/event-stream")
    public Flux<String> streamingAssistant(String chatId, String userMessage) {
        return assistantService.chatStream(chatId, userMessage);
    }
}
