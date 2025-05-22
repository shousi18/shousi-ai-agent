package com.shousi.shousiaiagent.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class WeatherTools {

    @Tool(description = "Obtain the weather of a specified date in a certain city")
    public String getWeather(@ToolParam(description = "City name") String city,
                             @ToolParam(description = "Date") String date) {
        return "The weather in " + city + " on " + date + " is sunny.";
    }
}
