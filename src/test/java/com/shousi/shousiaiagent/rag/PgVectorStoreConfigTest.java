package com.shousi.shousiaiagent.rag;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class PgVectorStoreConfigTest {

    @Resource
    VectorStore pgVectorStore;

    @Test
    void pgVectorStore() {
        List<Document> documents = List.of(
                new Document("三文鱼寿司是全世界最好吃的寿司！", Map.of("meta1", "meta1")),
                new Document("你中午想吃什么呢？"),
                new Document("贺羿鼎你好帅呀", Map.of("meta2", "meta2")));

        pgVectorStore.add(documents);

        List<Document> results = pgVectorStore.similaritySearch(
                SearchRequest.builder()
                        .query("什么寿司最好吃")
                        .topK(5)
                        .build()
        );

        Assertions.assertNotNull(results);
    }
}