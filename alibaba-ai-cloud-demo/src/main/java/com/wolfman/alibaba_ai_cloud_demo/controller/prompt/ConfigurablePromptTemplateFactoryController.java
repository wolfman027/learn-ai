package com.wolfman.alibaba_ai_cloud_demo.controller.prompt;

import com.alibaba.cloud.ai.prompt.ConfigurablePromptTemplate;
import com.alibaba.cloud.ai.prompt.ConfigurablePromptTemplateFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ai/configurable-prompt-template")
public class ConfigurablePromptTemplateFactoryController {

    private final ChatClient chatClient;

    private final ConfigurablePromptTemplateFactory configurablePromptTemplateFactory;

    public ConfigurablePromptTemplateFactoryController(ChatClient.Builder builder, ConfigurablePromptTemplateFactory configurablePromptTemplateFactory) {

        this.chatClient = builder.build();
        this.configurablePromptTemplateFactory = configurablePromptTemplateFactory;
    }

    @GetMapping("/prompt-template")
    public AssistantMessage generate(@RequestParam(value = "author", defaultValue = "鲁迅") String author) {
        ConfigurablePromptTemplate template = configurablePromptTemplateFactory.getTemplate("test-template");
        if (template == null) {
            template = configurablePromptTemplateFactory.create("test-template", "请列出 {author} 最著名的三本书。");
        }
        Prompt prompt;
        if (StringUtils.hasText(author)) {
            prompt = template.create(Map.of("author", author));
        } else {
            prompt = template.create();
        }

        return chatClient.prompt(prompt).call().chatResponse().getResult().getOutput();
    }

}
