package com.shousi.shousiaiagent.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebScrapingToolTest {

    @Test
    void scrapeWeb() {
        WebScrapingTool webScrapingTool = new WebScrapingTool();
        String url = "https://cn.bing.com/images/search?q=bing&form=HDRSC2&first=1";
        String result = webScrapingTool.scrapeWeb(url);
        System.out.println(result);
        assertNotNull(result);
    }
}