package com.wolfman.spring_ai_mall_order_mcp_server;

import com.wolfman.spring_ai_mall_order_mcp_server.service.OpenOrderService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiMallOrderMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiMallOrderMcpServerApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider weatherTools(OpenOrderService openMeteoService){
		return MethodToolCallbackProvider.builder().toolObjects(openMeteoService).build();
	}

}
