package io.ortega.mcp_server.tool;

import io.ortega.mcp_server.client.OnosApiClient;
import io.ortega.mcp_server.dto.HostListResponse;
import io.ortega.mcp_server.dto.HostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostTool {

    private final OnosApiClient client;

    @Tool(name = "Get all known end-station hosts", description = "Get all known end-station hosts and their details")
    public String getHosts() {
        HostListResponse hostListResponse = client.getHosts();

        StringBuilder result = new StringBuilder();
        for (HostResponse hostResponse : hostListResponse.getHosts()) {
            result.append(hostResponse.toString()).append("\n");
        }

        return result.toString();
    }

    @Tool(name = "Get a specific end-station hosts", description = "Get a specific end-station host details by id")
    public String getHostById(
            @ToolParam(description = "Host id") String id
    ) {
        HostResponse hostResponse = client.getHost(id);
        return hostResponse.toString();
    }
}
