package com.shousi.shousiaiagent.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.rag.Query;
import org.springframework.ai.rag.preretrieval.query.expansion.MultiQueryExpander;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyMultiQueryExpanderDemo {

    private final ChatClient.Builder chatClientBuilder;

    public MyMultiQueryExpanderDemo(ChatModel dashboardChatModel) {
        this.chatClientBuilder = ChatClient.builder(dashboardChatModel);
    }

    public List<Query> expand(String query) {
        MultiQueryExpander multiQueryExpander = MultiQueryExpander.builder()
                .chatClientBuilder(chatClientBuilder)
                .numberOfQueries(3)
                .build();
        List<Query> expand = multiQueryExpander.expand(new Query(query));
        return expand;
    }
}
