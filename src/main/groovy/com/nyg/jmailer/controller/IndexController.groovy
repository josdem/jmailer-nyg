package com.nyg.jmailer.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
class IndexController {

  @RequestMapping("/")
  String index(){
    'Hello World!'
  }

}
