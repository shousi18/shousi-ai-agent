package com.shousi.shousiaiagent.tools;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WebSearchTool {

    private static final String SEARCH_API_URL = "https://www.searchapi.io/api/v1/search";

    private String apiKey;

    public WebSearchTool(String apiKey) {
        this.apiKey = apiKey;
    }

    @Tool(description = "Search the web for information from Baidu Search Engine")
    public String searchWeb(@ToolParam(description = "Query to search for") String query) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("q", query);
        paramMap.put("api_key", apiKey);
        paramMap.put("engine", "baidu");
        try {
            String response = HttpUtil.get(SEARCH_API_URL, paramMap);
            // 取出返回结果的前五条
            JSONObject jsonObject = JSONUtil.parseObj(response);
            JSONArray organicResults = jsonObject.getJSONArray("ads");
            if (organicResults == null) {
                organicResults = jsonObject.getJSONArray("organic_results");
            }
            int size = organicResults.size();
            List<Object> objects;
            if (size > 10) {
                objects = organicResults.subList(0, 10);
            } else {
                objects = organicResults.subList(0, size);
            }
            // 转换成JSON字符串
            return objects.stream().map(item -> {
                JSONObject jsonItem = (JSONObject) item;
                return jsonItem.toString();
            }).collect(Collectors.joining(","));
        } catch (Exception e) {
            return "Error occurred while searching the web.";
        }
    }
}
