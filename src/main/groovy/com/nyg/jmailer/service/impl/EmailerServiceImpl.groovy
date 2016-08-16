package com.nyg.jmailer.service.impl

import org.springframework.stereotype.Service
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.nyg.jmailer.service.EmailerService
import com.nyg.jmailer.command.MessageCommand
import com.nyg.jmailer.exception.EmailerException

@Service
class EmailerServiceImpl implements EmailerService {

  Logger log = LoggerFactory.getLogger(this.class)

  def sendEmail(MessageCommand command){
    log.info 'Sending email ${command.email}'
    messageService.message(command)
  }

}
