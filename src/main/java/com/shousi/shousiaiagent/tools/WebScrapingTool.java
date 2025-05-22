package com.shousi.shousiaiagent.tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.io.IOException;

public class WebScrapingTool {

    @Tool(description = "Scrape web content from a given URL")
    public String scrapeWeb(@ToolParam(description = "URL to scrape") String url) {
        try {
            Document document = Jsoup.connect(url).get();
            return document.html();
        } catch (IOException e) {
            return "Error connecting to the URL" + e.getMessage();
        }
    }
}
