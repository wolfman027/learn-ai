package com.wolfman.alibaba_ai_cloud_demo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/customize")
public class CustomizedChatClientController {
    private final ChatClient chatClient;

    // 构造方法注入 ChatClient.Builder，用于构建 ChatClient 实例
    public CustomizedChatClientController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("你是一个演员，请列出你所参演的电影")
                .build();
    }

    @GetMapping("/movies")
    public String movies(@RequestParam(value = "input") String input) {
        return this.chatClient.prompt()
                .user(input)
                .call()
                .content();
    }


}