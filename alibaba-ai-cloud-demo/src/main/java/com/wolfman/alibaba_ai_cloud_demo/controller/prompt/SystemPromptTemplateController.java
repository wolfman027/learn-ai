package com.wolfman.alibaba_ai_cloud_demo.controller.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ai/system-prompt-template")
public class SystemPromptTemplateController {

    private final ChatClient chatClient;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemResource;

    @Autowired
    public SystemPromptTemplateController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/roles")
    public AssistantMessage generate(@RequestParam(value = "message", defaultValue = "请介绍一下海盗黄金时代的三位著名海盗，以及他们为什么这样做。为每个海盗至少写一句话。") String message,
                                     @RequestParam(value = "name", defaultValue = "Fox") String name,
                                     @RequestParam(value = "voice", defaultValue = "海盗") String voice) {

        UserMessage userMessage = new UserMessage(message);

        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemResource);
        Message systemMessage = systemPromptTemplate.createMessage(Map.of("name", name, "voice", voice));

        return chatClient.prompt(new Prompt(List.of(userMessage, systemMessage))).call().chatResponse().getResult().getOutput();
    }

}
