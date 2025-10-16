package io.ortega.mcp_server.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationListResponse {
    private List<ApplicationResponse> applications;
}
