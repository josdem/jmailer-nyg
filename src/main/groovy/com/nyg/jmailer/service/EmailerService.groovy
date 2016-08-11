package com.nyg.jmailer.service

import org.springframework.stereotype.Service
import com.nyg.jmailer.exception.EmailerException

@Service
class EmailerService {

  def sendEmail(){
    println 'Throwing an exception'
    throw new EmailerException()
  }

}
