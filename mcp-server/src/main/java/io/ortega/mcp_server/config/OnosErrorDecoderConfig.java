package io.ortega.mcp_server.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OnosErrorDecoderConfig implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        int status = response.status();

        log.error("ONOS API error {} on method {} with reason {}", status, s, response.reason());

        return switch (status) {
            case 401 -> new RuntimeException("Unauthorized - check your ONOS credentials");
            case 403 -> new RuntimeException("Forbidden - you don't have access to this resource");
            case 404 -> new RuntimeException("Resource not found on ONOS controller");
            case 500 -> new RuntimeException("Internal server error on ONOS");
            default -> defaultDecoder.decode(s, response);
        };

    }
}
