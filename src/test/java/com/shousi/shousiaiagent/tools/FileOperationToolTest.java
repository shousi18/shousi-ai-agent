package com.shousi.shousiaiagent.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationToolTest {

    @Test
    void readFile() {
        FileOperationTool fileOperationTool = new FileOperationTool();
        String filename = "test.txt";
        String content = fileOperationTool.readFile(filename);
        System.out.println(content);
        Assertions.assertNotNull(content);
    }

    @Test
    void writeFile() {
        FileOperationTool fileOperationTool = new FileOperationTool();
        String filename = "test.txt";
        String content = "This is a test.";
        String result = fileOperationTool.writeFile(filename, content);
        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}