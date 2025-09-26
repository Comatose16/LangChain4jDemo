package com.langchain4j.demo.controller;

import com.langchain4j.demo.service.AssistantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
public class AssistantController {

    private final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @GetMapping(value = "/assistant")
    public String assistant(String chatId, String userMessage) {
        return assistantService.chat(chatId, userMessage);
    }

    @GetMapping(value = "/streamingAssistant", produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamingAssistant(String chatId, String userMessage) {
        return assistantService.chatStream(chatId, userMessage);
    }
}
