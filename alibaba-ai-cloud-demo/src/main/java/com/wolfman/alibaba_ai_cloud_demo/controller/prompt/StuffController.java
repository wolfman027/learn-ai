package com.wolfman.alibaba_ai_cloud_demo.controller.prompt;

import com.wolfman.alibaba_ai_cloud_demo.entity.Completion;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//使用以下上下文来回答最后的问题。
//如果你不知道答案，就说你不知道，不要试图编造答案。
//
//        {context}
//
//问题: {question}
//有用的答案：

@RestController
@RequestMapping("/example/ai")
public class StuffController {

    private final ChatClient chatClient;

    @Value("classpath:/docs/bailian.md")
    private Resource docsToStuffResource;

    @Value("classpath:/prompts/qa-prompt.st")
    private Resource qaPromptResource;

    @Autowired
    public StuffController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping(value = "/stuff")
    public Completion completion(@RequestParam(value = "message", defaultValue = "给我推荐一款百炼系列的手机？") String message,
                                 @RequestParam(value = "stuffit", defaultValue = "false") boolean stuffit) {
        PromptTemplate promptTemplate = new PromptTemplate(qaPromptResource);
        Map<String, Object> map = new HashMap<>();
        map.put("question", message);
        if (stuffit) {
            map.put("context", docsToStuffResource);
        } else {
            map.put("context", "");
        }
        return new Completion(chatClient.prompt(promptTemplate.create(map)).call().content());
    }

}
