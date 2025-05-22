package com.shousi.shousiaiagent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.ai.autoconfigure.vectorstore.pgvector.PgVectorStoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {PgVectorStoreAutoConfiguration.class})
@MapperScan("com.shousi.shousiaiagent.mapper")
public class ShousiAiAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShousiAiAgentApplication.class, args);
    }

}
