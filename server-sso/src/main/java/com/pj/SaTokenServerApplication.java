package com.pj;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title: SaTokenServerApplication
 * @Author 蟑螂恶霸
 * @Package com.pj
 * @Date 2024/2/5 15:52
 * @description:
 */
@SpringBootApplication
public class SaTokenServerApplication {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(SaTokenServerApplication.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }
}

