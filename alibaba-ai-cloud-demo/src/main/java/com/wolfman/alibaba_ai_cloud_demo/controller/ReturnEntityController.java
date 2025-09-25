package com.wolfman.alibaba_ai_cloud_demo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ai/entity")
public class ReturnEntityController {

    private final ChatClient chatClient;

    // 构造方法注入 ChatClient.Builder，用于构建 ChatClient 实例
    public ReturnEntityController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public record ActorFilms(String actor, List<String> films) {

    }

    @GetMapping("/movies")
    public ActorFilms movies(@RequestParam(value = "input") String input) {
        return this.chatClient.prompt()
                .user(input)
                .call()
                .entity(ActorFilms.class);
    }

    @GetMapping("/movies2")
    public List<ActorFilms> movies2(@RequestParam(value = "input") String input) {
        return this.chatClient.prompt()
                .user(input)
                .call()
                .entity(new ParameterizedTypeReference<List<ActorFilms>>() {});
    }

}