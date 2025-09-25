package com.langchain4j.demo;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService
public interface Assistant {

    String chat(@MemoryId String chatId, @UserMessage String useMessage);

    Flux<String> chatStream(@MemoryId String chatId, @UserMessage String useMessage);
}
