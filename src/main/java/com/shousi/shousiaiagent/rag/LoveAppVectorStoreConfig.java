package com.shousi.shousiaiagent.rag;

import jakarta.annotation.Resource;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoveAppVectorStoreConfig {

    @Resource
    private LoveAppDocumentLoader loveAppDocumentLoader;

    @Resource
    private MyTokenTextSplitter myTokenTextSplitter;

    @Resource
    private MyKeyWordEnricher myKeyWordEnricher;

    /**
     * 本地向量数据库
     * @param dashboardEmbeddingModel
     * @return
     */
    @Bean
    VectorStore loadAppVectorStore(EmbeddingModel dashboardEmbeddingModel) {
        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(dashboardEmbeddingModel).build();
        // 加载文档
        List<Document> documentList = loveAppDocumentLoader.loadMarkdownDocuments();
        // 自主切分文档
//        List<Document> splitCustomizedDocumentList = myTokenTextSplitter.splitCustomized(documentList);
        // 使用 AI 自动提取元信息关键词
//        List<Document> enrichDocumentList = myKeyWordEnricher.enrichDocuments(documentList);
        // 转换为向量保存到向量数据库中
        simpleVectorStore.doAdd(documentList);
        return simpleVectorStore;
    }
}
