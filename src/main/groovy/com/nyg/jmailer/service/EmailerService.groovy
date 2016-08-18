package com.nyg.jmailer.service

import com.nyg.jmailer.command.Command

interface EmailerService {

  def sendEmail(Command command)

}
