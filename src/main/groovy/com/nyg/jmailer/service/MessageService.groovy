package com.nyg.jmailer.service

import com.nyg.jmailer.command.MessageCommand

interface MessageService {

  void message(final MessageCommand command)

}
