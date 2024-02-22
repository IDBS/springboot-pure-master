package com.pj.utils;

import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.bean.BeanUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

/**
 * @Title: SendHttpUtlis
 * @Author 蟑螂恶霸
 * @Package com.pj.utils
 * @Date 2024/2/22 11:34
 * @description:
 */
public class SendHttpUtils {

    /**
     * 发生post请求
     * @param restTemplate
     * @param redirectUrl
     * @param data
     * @param httpMethod
     */
    public static SaResult sendHttpPost(RestTemplate restTemplate, String redirectUrl, Object data, HttpMethod httpMethod){
        HttpHeaders headers = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(redirectUrl);
        ResponseEntity<SaResult> redirectedResponse = restTemplate.exchange(
                builder.build().encode().toUri(),
                httpMethod,
                new HttpEntity<>(data, headers),
                SaResult.class);
        URI redirectUri = redirectedResponse.getHeaders().getLocation();
        return redirectedResponse.getBody();
    }
}
