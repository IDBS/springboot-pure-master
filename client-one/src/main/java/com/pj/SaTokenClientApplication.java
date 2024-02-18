package com.pj;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title: SaTokenClientApplication
 * @Author 蟑螂恶霸
 * @Package com.pj
 * @Date 2024/2/5 15:52
 * @description:
 */
@SpringBootApplication
public class SaTokenClientApplication {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(SaTokenClientApplication.class, args);
        System.out.println("\nSa-Token SSO模式一 Client端启动成功");
    }
}

