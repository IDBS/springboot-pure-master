package com.pj.comtroller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: UserController
 * @Author 蟑螂恶霸
 * @Package com.pj.comtroller
 * @Date 2024/2/5 15:54
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            log.info("token:{}", StpUtil.getTokenValue());
            log.info("TokenTimeout:{}", StpUtil.getTokenTimeout());
            log.info("TokenInfo:{}", StpUtil.getTokenInfo());
            return "登录成功";
        }
        return "登录失败";
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/logout
    @RequestMapping("logout")
    public String logout() {
        StpUtil.logout();
        return "当前会话注销登录";
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        log.info("token:{}", StpUtil.getTokenValue());
        log.info("TokenTimeout:{}", StpUtil.getTokenTimeout());
        log.info("TokenInfo:{}", StpUtil.getTokenInfo());
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/checkLogin
    @RequestMapping("checkLogin")
    public void checkLogin() {
        StpUtil.checkLogin();
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/loginDevice
    @RequestMapping("loginDevice")
    public String loginDevice() {
        // 定义私钥和公钥
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAO+wmt01pwm9lHMdq7A8gkEigk0XKMfjv+4IjAFhWCSiTeP7dtlnceFJbkWxvbc7Qo3fCOpwmfcskwUc3VSgyiJkNJDs9ivPbvlt8IU2bZ+PBDxYxSCJFrgouVOpAr8ar/b6gNuYTi1vt3FkGtSjACFb002/68RKUTye8/tdcVilAgMBAAECgYA1COmrSqTUJeuD8Su9ChZ0HROhxR8T45PjMmbwIz7ilDsR1+E7R4VOKPZKW4Kz2VvnklMhtJqMs4MwXWunvxAaUFzQTTg2Fu/WU8Y9ha14OaWZABfChMZlpkmpJW9arKmI22ZuxCEsFGxghTiJQ3tK8npj5IZq5vk+6mFHQ6aJAQJBAPghz91Dpuj+0bOUfOUmzi22obWCBncAD/0CqCLnJlpfOoa9bOcXSusGuSPuKy5KiGyblHMgKI6bq7gcM2DWrGUCQQD3SkOcmia2s/6i7DUEzMKaB0bkkX4Ela/xrfV+A3GzTPv9bIBamu0VIHznuiZbeNeyw7sVo4/GTItq/zn2QJdBAkEA8xHsVoyXTVeShaDIWJKTFyT5dJ1TR++/udKIcuiNIap34tZdgGPI+EM1yoTduBM7YWlnGwA9urW0mj7F9e9WIQJAFjxqSfmeg40512KP/ed/lCQVXtYqU7U2BfBTg8pBfhLtEcOg4wTNTroGITwe2NjL5HovJ2n2sqkNXEio6Ji0QQJAFLW1Kt80qypMqot+mHhS+0KfdOpaKeMWMSR4Ij5VfE63WzETEeWAMQESxzhavN1WOTb3/p6icgcVbgPQBaWhGg==";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDvsJrdNacJvZRzHauwPIJBIoJNFyjH47/uCIwBYVgkok3j+3bZZ3HhSW5Fsb23O0KN3wjqcJn3LJMFHN1UoMoiZDSQ7PYrz275bfCFNm2fjwQ8WMUgiRa4KLlTqQK/Gq/2+oDbmE4tb7dxZBrUowAhW9NNv+vESlE8nvP7XXFYpQIDAQAB";

// 文本
        String text = "Sa-Token 一个轻量级java权限认证框架";

// 使用公钥加密
        String ciphertext = SaSecureUtil.rsaEncryptByPublic(publicKey, text);
        System.out.println("公钥加密后：" + ciphertext);

// 使用私钥解密
        String text2 = SaSecureUtil.rsaDecryptByPrivate(privateKey, ciphertext);
        System.out.println("私钥解密后：" + text2);

        return "当前登录设备：" + StpUtil.getLoginDevice();
    }




}