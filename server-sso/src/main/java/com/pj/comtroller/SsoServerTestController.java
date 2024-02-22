package com.pj.comtroller;

import com.pj.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-Token-SSO Server端 Controller
 */
@RestController
@RequestMapping("/test")
public class SsoServerTestController {


    @PostMapping("/redirect")
    public Object redirect(@RequestBody User user) {
        return user;
    }

}

