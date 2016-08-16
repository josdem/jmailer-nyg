package com.nyg.jmailer.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.nyg.jmailer.service.NotificationService
import com.nyg.jmailer.service.MailService
import com.nyg.jmailer.command.MessageCommand

@Service
class NotificationServiceImpl implements NotificationService {

  @Autowired
  MailService mailService

  @Value('${email.template}')
  String template
  @Value('${email.subject}')
  String subject

  Logger log = LoggerFactory.getLogger(this.class)

  @Override
  Boolean sendNotification(MessageCommand messageCommand) {
    def data = [email:messageCommand.email, subject:subject]
    mailService.sendMailWithTemplate(data, messageCommand.properties, template)
  }

}

