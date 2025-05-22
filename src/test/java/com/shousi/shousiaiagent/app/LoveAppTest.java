package com.shousi.shousiaiagent.app;

import cn.hutool.core.lang.UUID;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoveAppTest {

    @Resource
    private LoveApp loveApp;

    @Test
    void doChat() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是寿司大大";
        String answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        // 第二轮
        message = "我想让另一半（玉米寿司）更爱我";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        // 第三轮
        message = "他和我在一起已经半年了";
        answer = loveApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithReport() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是寿司大大，我想让另一半（玉米寿司）更爱我，但我不知道该怎么做";
        LoveApp.LoveReport loveReport = loveApp.doChatWithReport(message, chatId);
        Assertions.assertNotNull(loveReport);
    }

    @Test
    void doChatWithRag() {
        String chatId = UUID.randomUUID().toString();
        String message = "我目前是单身状态，请问我该怎么提升自己来吸引异性";
        String content = loveApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(content);
    }

    @Test
    void doChatWithRag2() {
        String chatId = UUID.randomUUID().toString();
        String message = "我目前是单身状态，我是一名女生，我的性取向正常，我想要对方男生的职业是一名电竞选手，请你帮我寻找一下合适的人选，并把他的基本信息告诉我";
        String content = loveApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(content);
    }

    @Test
    void doChatWithPgVectorStoreRag3() {
        String chatId = UUID.randomUUID().toString();
        String message = "什么寿司最好吃？";
        String content = loveApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(content);
    }

    @Test
    void doChatWithTools() {
        // 测试联网搜索问题的答案
        testMessage("周末想带女朋友去西安约会，推荐几个适合情侣的小众打卡地？");

        // 测试网页抓取：恋爱案例分析
        testMessage("最近和对象吵架了，看看编程导航网站（https://www.zhihu.com/question/334599077）的其他情侣是怎么解决矛盾的？");

        // 测试资源下载：图片下载
        testMessage("直接下载一张适合做手机壁纸的星空情侣图片为文件");

        // 测试天气：执行代码
        testMessage("帮我看看山西2025年5月22号的天气怎么样");

        // 测试文件操作：保存用户档案
        testMessage("保存我的恋爱档案为文件");

        // 测试 PDF 生成
        testMessage("生成一份‘七夕约会计划’PDF，包含餐厅预订、活动流程和礼物清单");
    }

    private void testMessage(String message) {
        String chatId = UUID.randomUUID().toString();
        String answer = loveApp.doChatWithTools(message, chatId);
        System.out.println(answer);
        Assertions.assertNotNull(answer);
    }

}