package com.nyg.jmailer.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired

import com.nyg.jmailer.service.EmailerService

@RestController
class IndexController {

  @Autowired
  EmailerService emailerService

  @RequestMapping("/")
  String index(){
    emailerService.sendEmail()
  }

}
