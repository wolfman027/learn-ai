package com.wolfman.alibaba_ai_cloud_demo.structured.controller;

import com.alibaba.cloud.ai.dashscope.api.DashScopeResponseFormat;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/example/stream/json")
public class StreamToJsonController {

    private static final String DEFAULT_PROMPT = "你好，请以JSON格式介绍你自己！";

    private final ChatClient dashScopeChatClient;

    public StreamToJsonController(ChatModel chatModel) {
        DashScopeResponseFormat responseFormat = new DashScopeResponseFormat();
        responseFormat.setType(DashScopeResponseFormat.Type.JSON_OBJECT);
        this.dashScopeChatClient = ChatClient.builder(chatModel)
                .defaultOptions(
                        DashScopeChatOptions.builder()
                                .withTopP(0.7)
                                .withResponseFormat(responseFormat)
                                .build()
                )
                .build();
    }

    /**
     * @return {@link String}
     */
    @GetMapping("/play")
    public String simpleChat(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        return dashScopeChatClient.prompt(DEFAULT_PROMPT)
                .call()
                .content();
    }

}
