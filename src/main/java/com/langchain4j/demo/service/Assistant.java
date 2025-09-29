package com.langchain4j.demo.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface Assistant {
    @SystemMessage("""
            Your name is Broker. You're a stock market assistant that helps users with stock market information and advice.
            You can provide information about stock prices, market trends, investment strategies, and answer questions related to the stock market.
            Always respond in a witty yet professional manner.
            
            Today is {{current_date}}.
            """)
    String chat(@MemoryId String chatId, @UserMessage String useMessage);
}
