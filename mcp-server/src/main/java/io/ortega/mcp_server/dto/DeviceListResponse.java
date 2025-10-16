package io.ortega.mcp_server.dto;

import lombok.Data;

import java.util.Collection;

@Data
public class DeviceListResponse {
    private Collection<DeviceResponse> devices;
}
