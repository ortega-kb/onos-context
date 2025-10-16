package io.ortega.mcp_server.dto;

import lombok.Data;

import java.util.List;

public record ApplicationResponse(
        String name,
        Integer id,
        String version,
        String category,
        String description,
        String readme,
        String origin,
        String url,
        String featuresRepo,
        String state,
        List<String> features,
        List<String> permissions,
        List<String> requiredApps
) {
}
