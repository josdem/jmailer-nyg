package com.nyg.jmailer.controller

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.nyg.jmailer.service.EmailerService
import com.nyg.jmailer.command.MessageCommand

@RestController
class EmailerController {

  @Autowired
  EmailerService emailerService

  Logger log = LoggerFactory.getLogger(this.class)

  @RequestMapping(method = POST, value = "/message", consumes="application/json")
  @ResponseBody
  ResponseEntity<String> message(@RequestBody MessageCommand command){
    log.info "Sending contact email: ${command.email}"
    emailerService.sendEmail(command)
    new ResponseEntity<String>("OK", HttpStatus.OK)
  }

}
