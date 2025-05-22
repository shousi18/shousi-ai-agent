package com.shousi.shousiaiagent.tools;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shousi.shousiaiagent.model.entity.Merchant2;
import com.shousi.shousiaiagent.service.Merchant2Service;
import org.springframework.ai.chat.model.ToolContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class SearchViolateMerchantInfoTool {

    private final Merchant2Service merchant2Service;

    // 使用构造函数注入
    public SearchViolateMerchantInfoTool(Merchant2Service merchant2Service) {
        this.merchant2Service = merchant2Service;
    }
    @Tool(description = "The problem that occurred when searching for the goods with the name I specified.")
    public String searchViolateMerchantInfo(@ToolParam(description = "Name of the good") String goodName) {
        QueryWrapper<Merchant2> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("good_name", goodName);
        return merchant2Service.list(queryWrapper).toString();
    }
}
