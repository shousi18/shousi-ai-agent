package com.shousi.shousiaiagent.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceDownloadToolTest {

    @Test
    void downloadResource() {
        ResourceDownloadTool resourceDownloadTool = new ResourceDownloadTool();
        String result = resourceDownloadTool.downloadResource("https://ts1.tc.mm.bing.net/th/id/R-C.cf91b03bd6e4016e0d6b5d37d50e81bf?rik=fbpPLwci3R0nxw&riu=http%3a%2f%2fwww.bjjyhx.cn%2fupload%2fimages%2f20160506_174536.png&ehk=dZnFFdHVAwQDQCYR4%2fZo4utX%2fVa8bUIByUcO97JCktI%3d&risl=&pid=ImgRaw&r=0", "bing.png");
        System.out.println(result);
        assertNotNull(result);
    }
}