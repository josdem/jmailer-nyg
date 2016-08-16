package com.nyg.jmailer.service

import com.nyg.jmailer.command.MessageCommand

interface NotificationService {

  Boolean sendNotification(MessageCommand command)

}

