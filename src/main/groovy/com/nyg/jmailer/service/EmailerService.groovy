package com.nyg.jmailer.service

import com.nyg.jmailer.command.MessageCommand

interface EmailerService {

  def sendEmail(MessageCommand command)

}
