package io.ortega.mcp_client;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chat, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chat.defaultToolCallbacks(toolCallbackProvider).build();
    }

    public String chat(String q) {
        PromptTemplate promptTemplate = new PromptTemplate(q);
        return this.chatClient.prompt(promptTemplate.create()).call().content();
    }
}
