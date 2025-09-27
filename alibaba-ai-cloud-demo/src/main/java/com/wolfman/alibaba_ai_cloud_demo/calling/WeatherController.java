package com.wolfman.alibaba_ai_cloud_demo.calling;

import com.wolfman.alibaba_ai_cloud_demo.calling.tool.WeatherTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final ChatClient dashScopeChatClient;

    public WeatherController(ChatClient.Builder chatClientBuilder) {
        this.dashScopeChatClient = chatClientBuilder
                //.defaultFunctions("weatherFunction")  // 初始化时，使用 function calling
                //.defaultTools(new WeatherToolImpl())  // 初始化时，使用 tool calling
                .build();
    }

    /**
     * 无工具版
     */
    @GetMapping("/chat")
    public String simpleChat(@RequestParam(value = "query", defaultValue = "北京今天的天气") String query) {
        return dashScopeChatClient.prompt(query).call().content();
    }

    /**
     * 调用工具版 - function
     */
    @GetMapping("/chat-function-method")
    public String chatTranslateFunction(@RequestParam(value = "query", defaultValue = "北京今天的天气") String query) {
        return dashScopeChatClient.prompt(query)
//                .functions("weatherFunction") //已弃用，请使用 tools
                .tools("weatherFunction")
                .call().content();
    }


    /**
     * 调用工具版 - method
     */
    @GetMapping("/chat-tool-method")
    public String chatTranslateMethod(@RequestParam(value = "query", defaultValue = "北京今天的天气") String query) {
        return dashScopeChatClient.prompt(query).tools(new WeatherTool()).call().content();
    }
}
