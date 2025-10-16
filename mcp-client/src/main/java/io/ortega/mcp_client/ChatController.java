package io.ortega.mcp_client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public String chat(@RequestBody ChatRequest chatRequest) {
        return chatService.chat(chatRequest.message());
    }

}
