package io.ortega.mcp_server.tool;

import io.ortega.mcp_server.client.OnosApiClient;
import io.ortega.mcp_server.dto.ApplicationListResponse;
import io.ortega.mcp_server.dto.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationTool {

    private final OnosApiClient client;

    @Tool(name = "Get all installed applications", description = "Get all installed applications and their details")
    public String getApplications() {
        ApplicationListResponse applicationListResponse = client.getApplications();

        StringBuilder result = new StringBuilder();
        for (ApplicationResponse applicationResponse: applicationListResponse.getApplications()) {
            result.append(applicationResponse.toString()).append("\n");
        }

        return result.toString();
    }

}
