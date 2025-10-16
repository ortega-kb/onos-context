package io.ortega.mcp_server.dto;

import lombok.Data;

import java.util.List;

@Data
public class HostListResponse {
    private List<HostResponse> hosts;
}
