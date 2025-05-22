package com.shousi.shousiaiagent.advisor;

import com.shousi.shousiaiagent.tools.*;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolRegistration {

    @Value("${searchapi.api-key}")
    private String searchApiKey;

    @Bean
    public ToolCallback[] allTools() {
        FileOperationTool fileOperationTool = new FileOperationTool();
        PDFGenerationTool pdfGenerationTool = new PDFGenerationTool();
        WebSearchTool webSearchTool = new WebSearchTool(searchApiKey);
        ResourceDownloadTool resourceDownloadTool = new ResourceDownloadTool();
        WebScrapingTool webScrapingTool = new WebScrapingTool();
        WeatherTools weatherTools = new WeatherTools();
        return ToolCallbacks.from(
                fileOperationTool,
                pdfGenerationTool,
                webSearchTool,
                resourceDownloadTool,
                webScrapingTool,
                weatherTools
        );
    }

    @Bean
    public ToolCallback[] serviceTools(SearchViolateMerchantInfoTool searchViolateMerchantInfoTool) {
        return ToolCallbacks.from(
                searchViolateMerchantInfoTool
        );
    }
}
