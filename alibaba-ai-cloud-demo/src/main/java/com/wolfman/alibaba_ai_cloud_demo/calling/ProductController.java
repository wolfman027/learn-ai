package com.wolfman.alibaba_ai_cloud_demo.calling;

import com.wolfman.alibaba_ai_cloud_demo.calling.product.ProductServiceImpl;
import com.wolfman.alibaba_ai_cloud_demo.calling.tool.WeatherTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/product")
public class ProductController {

    private final ChatClient chatClient;

    public ProductController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                    你是电商智能客服助手，可以根据用户提供的商品ID获取详细详情信息。
                    当用户询问商品详情时，请先确认商品ID。
                    可以根据商品ID查询商品详情。
                """)
                .defaultTools(new ProductServiceImpl())
                .build();
    }

    @GetMapping("/chat")
    public String simpleChat(@RequestParam(value = "query") String query) {
        return chatClient.prompt(query)
//                .tools(new ProductServiceImpl())
                .call().content();
    }

}
