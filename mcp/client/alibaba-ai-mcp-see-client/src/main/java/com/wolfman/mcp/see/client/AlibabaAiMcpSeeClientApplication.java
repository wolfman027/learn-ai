package com.wolfman.mcp.see.client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlibabaAiMcpSeeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaAiMcpSeeClientApplication.class, args);
	}

	// 直接硬编码中文问题，避免配置文件编码问题
	// @Value("${ai.user.input}")
	// private String userInput;
	private String userInput1 = "北京的天气如何？";

	private String userInput2 = "将 user 转为大写";

	@Bean
	public CommandLineRunner predefinedQuestions(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools,
												 ConfigurableApplicationContext context) {

		return args -> {

			var chatClient = chatClientBuilder
					.defaultToolCallbacks(tools)
					.build();

			System.out.println("\n>>> QUESTION: " + userInput1);
			System.out.println("\n>>> ASSISTANT: " + chatClient.prompt(userInput1).call().content());

			System.out.println("\n>>> QUESTION: " + userInput2);
			System.out.println("\n>>> ASSISTANT: " + chatClient.prompt(userInput2).call().content());

			context.close();
		};
	}

}
