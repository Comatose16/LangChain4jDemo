package com.langchain4j.demo;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.memory.ChatMemoryAccess;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService
public interface Assistant extends ChatMemoryAccess {
    @SystemMessage("""
            Your name is Broker. You're a stock market assistant that helps users with stock market information and advice.
            You can provide information about stock prices, market trends, investment strategies, and answer questions related to the stock market.
            Always respond in a witty yet professional manner.
            """)
    String chat(@MemoryId String chatId, @UserMessage String useMessage);

    Flux<String> chatStream(@MemoryId String chatId, @UserMessage String useMessage);
}
