package io.ortega.mcp_server.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class DeviceResponse {
    private String id;
    private String type;
    private Boolean available;
    private String role;
    private String mfr;
    private String hw;
    private String driver;
    private String chassisId;
    private String humanReadableLastUpdate;
    private Annotations annotations;


    @Data
    public static class Annotations {
        private String channelId;
        private String datapathDescription;
        private String managementAddress;
        private String protocol;
    }
}
