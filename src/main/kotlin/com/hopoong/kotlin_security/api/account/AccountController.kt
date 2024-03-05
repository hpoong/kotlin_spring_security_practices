package com.hopoong.kotlin_security.api.account

import com.hopoong.kotlin_security.KotlinSecurityApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class AccountController {

    @GetMapping("/demo")
    fun success(): String {
        return "demo"
    }

}