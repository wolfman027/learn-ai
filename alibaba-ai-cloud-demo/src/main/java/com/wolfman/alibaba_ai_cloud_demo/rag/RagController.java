package com.wolfman.alibaba_ai_cloud_demo.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai/rag")
public class RagController {

    @Autowired
    @Qualifier("ragChatClient")
    private ChatClient chatClient;

    @Autowired
    private VectorStore vectorStore;


    @GetMapping(value = "/chat", produces = "text/plain; charset=UTF-8")
    public String generation(String userInput) {
        // 发起聊天请求并处理响应
        return chatClient.prompt()
                .user(userInput)
                .advisors(new QuestionAnswerAdvisor(vectorStore)) // RAG 知识库
                .call()
                .content();
    }
}