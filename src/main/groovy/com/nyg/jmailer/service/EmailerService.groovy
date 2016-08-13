package com.nyg.jmailer.service

import org.springframework.stereotype.Service
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.nyg.jmailer.exception.EmailerException

@Service
class EmailerService {

  Logger logger = LoggerFactory.getLogger(this.class)

  def sendEmail(){
    log.info 'Throwing an exception'
    throw new EmailerException()
  }

}
