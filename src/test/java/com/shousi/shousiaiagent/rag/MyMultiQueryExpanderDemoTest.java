package com.shousi.shousiaiagent.rag;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.ai.rag.Query;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyMultiQueryExpanderDemoTest {

    @Resource
    private MyMultiQueryExpanderDemo myMultiQueryExpanderDemo;

    @Test
    void expand() {
        List<Query> expand = myMultiQueryExpanderDemo.expand("到底谁是向阳256啊？");
        Assertions.assertNotNull(expand);
    }
}