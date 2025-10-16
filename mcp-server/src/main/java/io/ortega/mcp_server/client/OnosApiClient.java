package io.ortega.mcp_server.client;

import io.ortega.mcp_server.config.OnosFeignConfig;
import io.ortega.mcp_server.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "onos-api-client",
        url = "${mcp-server.onos-controller.url}",
        configuration = OnosFeignConfig.class
)
public interface OnosApiClient {


    @GetMapping(value = "/onos/v1/devices")
    DeviceListResponse getDevices();

    @GetMapping(value = "/onos/v1/devices/{deviceId}")
    DeviceResponse getDevice(@PathVariable("deviceId") String deviceId);

    @GetMapping(value = "/onos/v1/hosts")
    HostListResponse getHosts();

    @GetMapping(value = "/onos/v1/hosts/{hostId}")
    HostResponse getHost(@PathVariable("hostId") String hostId);

    @GetMapping(value = "/onos/v1/applications")
    ApplicationListResponse getApplications();


}
