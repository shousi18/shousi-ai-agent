package com.shousi.shousiaiagent.tools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebSearchToolTest {

    @Value("${searchapi.api-key}")
    private String apiKey;

    @Test
    void searchWeb() {
        WebSearchTool webSearchTool = new WebSearchTool(apiKey);
        String query = "西安推荐的吃饭的饭店";
        String result = webSearchTool.searchWeb(query);
        System.out.println(result);
        assertNotNull(result);
    }
}