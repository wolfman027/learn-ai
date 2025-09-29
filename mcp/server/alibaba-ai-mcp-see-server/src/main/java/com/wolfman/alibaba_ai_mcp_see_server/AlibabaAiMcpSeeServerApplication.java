package com.wolfman.alibaba_ai_mcp_see_server;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlibabaAiMcpSeeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaAiMcpSeeServerApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider weatherTools(OpenMeteoService openMeteoService){
		return MethodToolCallbackProvider.builder().toolObjects(openMeteoService).build();
	}

}
