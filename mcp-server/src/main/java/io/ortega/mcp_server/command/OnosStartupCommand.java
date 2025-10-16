package io.ortega.mcp_server.command;

import io.ortega.mcp_server.tool.DeviceTool;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OnosStartupCommand implements CommandLineRunner {

    private final DeviceTool deviceTool;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(deviceTool.getDevices());
    }
}
