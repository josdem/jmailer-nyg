package com.nyg.jmailer.service

import com.nyg.jmailer.command.Command

interface MessageService {

  void message(final Command command)

}
