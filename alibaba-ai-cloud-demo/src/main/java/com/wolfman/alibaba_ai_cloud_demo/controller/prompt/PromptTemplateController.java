package com.wolfman.alibaba_ai_cloud_demo.controller.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ai/prompt-template")
public class PromptTemplateController {

    private final ChatClient chatClient;

    @Value("classpath:/prompts/joke-prompt.st")
    private Resource jokeResource;

    public PromptTemplateController(ChatClient.Builder builder) {

        this.chatClient = builder.build();
    }

    @GetMapping("/prompt")
    public AssistantMessage completion(@RequestParam(value = "adjective", defaultValue = "有趣") String adjective,
                                       @RequestParam(value = "topic", defaultValue = "奶牛") String topic) {
        PromptTemplate promptTemplate = new PromptTemplate(jokeResource);
        Prompt prompt = promptTemplate.create(Map.of("adjective", adjective, "topic", topic));
        return chatClient.prompt(prompt).call().chatResponse().getResult().getOutput();
    }

}
