package io.ortega.mcp_server.tool;

import io.ortega.mcp_server.client.OnosApiClient;
import io.ortega.mcp_server.dto.DeviceListResponse;
import io.ortega.mcp_server.dto.DeviceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DeviceTool {

    private final OnosApiClient client;

    @Tool(
            name = "List all network devices",
            description = "Retrieves a list of all infrastructure devices discovered by the ONOS controller, " +
                    "including details such as device ID, type, manufacturer, software version, and ports."
    )
    public String getDevices() {
        DeviceListResponse deviceListResponse = client.getDevices();

        StringBuilder result = new StringBuilder();
        for (DeviceResponse deviceResponse : deviceListResponse.getDevices()) {
            result.append(deviceResponse.toString()).append("\n");
        }

        return result.toString();
    }


    @Tool(
            name = "Get network device details by ID",
            description = "Retrieves detailed information about a specific network device from the ONOS controller " +
                    "based on its unique device ID. The details include device type, ports, manufacturer, and software version."
    )
    public String getDeviceById(
            @ToolParam(description = "Unique identifier of the network device") String id
    ) {
        DeviceResponse deviceResponse = client.getDevice(id);
        return deviceResponse.toString();
    }
}
