package com.wolfman.spring_ai_mall_order_mcp_client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiMallOrderMcpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiMallOrderMcpClientApplication.class, args);
	}


	private String userInput = "查询订单ID为ORD20250414001的订单详情";

	@Bean
	public CommandLineRunner predefinedQuestions(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools,
												 ConfigurableApplicationContext context) {

		return args -> {

			var chatClient = chatClientBuilder
					.defaultToolCallbacks(tools)
					.build();

			System.out.println("\n>>> QUESTION: " + userInput);
			System.out.println("\n>>> ASSISTANT: " + chatClient.prompt(userInput).call().content());

			context.close();
		};
	}


}
