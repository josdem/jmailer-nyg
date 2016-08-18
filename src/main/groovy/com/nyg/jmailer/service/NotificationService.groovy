package com.nyg.jmailer.service

import com.nyg.jmailer.command.Command

interface NotificationService {

  Boolean sendNotification(Command command)

}

