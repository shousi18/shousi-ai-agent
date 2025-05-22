package com.shousi.shousiaiagent.controller;

import cn.hutool.core.lang.UUID;
import com.shousi.shousiaiagent.app.LoveApp;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Resource
    private LoveApp loveApp;

    @GetMapping("/ai/search")
    public String searchMerchantInfo(String goodName) {
        String uuid = UUID.randomUUID().toString();
        return loveApp.doChatWithServiceTools("请帮我搜索商品名称为" + goodName + "的问题信息，不需要其他的信息", uuid);
    }
}
