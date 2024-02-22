package com.pj.comtroller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.pj.utils.SendHttpUtils;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Title: SsoClientTestController
 * @Author 蟑螂恶霸
 * @Package com.pj.comtroller
 * @Date 2024/2/22 10:10
 * @description:
 */
@RequestMapping("/test")
@RestController
public class SsoClientTestController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/isLogin")
    public SaResult isLogin() throws IOException {
        //String urlRedirect = "http://127.0.0.1:9000/sso/doLogin?name=sa&pwd=123456&back=" + request.getRequestURI();
        String urlRedirect = "http://127.0.0.1:9000/sso/doLogin?back=" + request.getRequestURI();
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "sa");
        hashMap.put("pwd", "123456");
        return SendHttpUtils.sendHttpPost(restTemplate, urlRedirect, hashMap, HttpMethod.GET);
    }
}
