package com.langchain4j.demo.controller;

import com.langchain4j.demo.service.Assistant;
import com.langchain4j.demo.service.StreamingAssistant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AssistantController {

    private final Assistant assistant;
    private final StreamingAssistant streamingAssistant;

    public AssistantController(Assistant assistant,  StreamingAssistant streamingAssistant) {
        this.assistant = assistant;
        this.streamingAssistant = streamingAssistant;
    }

    @GetMapping(value = "/assistant")
    public String assistant(
            @RequestParam(value="sessionId") String sessionId,
            @RequestParam(value="message", required = false, defaultValue= "Hello") String message) {
        return assistant.chat(sessionId, message);
    }

    @GetMapping(value = "/streamingAssistant", produces = "text/event-stream")
    public Flux<String> streamingAssistant(
            @RequestParam(value="sessionId") String sessionId,
            @RequestParam(value="message", required = false, defaultValue = "Hello") String message) {
        return streamingAssistant.chatStream(sessionId, message);
    }
}
