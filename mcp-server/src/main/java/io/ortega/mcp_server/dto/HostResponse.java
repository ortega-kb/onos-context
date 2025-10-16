package io.ortega.mcp_server.dto;

import lombok.Data;

import java.util.List;

@Data
public class HostResponse {

    private String id;
    private String mac;
    private String vlan;
    private String innerVlan;
    private String outerTpid;
    private Boolean configured;
    private Boolean suspended;
    private List<String> ipAddresses;
    private Locations locations;

    @Data
    public static class Locations {
        private String elementId;
        private String port;
    }
}
