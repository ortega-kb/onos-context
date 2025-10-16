package io.ortega.mcp_server;

import io.ortega.mcp_server.tool.ApplicationTool;
import io.ortega.mcp_server.tool.DeviceTool;
import io.ortega.mcp_server.tool.HostTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class McpServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider tools(
            DeviceTool deviceTool,
            HostTool hostTool
    ) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(deviceTool)
                .toolObjects(hostTool)
                .build();
    }
}
