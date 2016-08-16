package com.nyg.jmailer.listener

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import javax.jms.Message
import javax.jms.ObjectMessage

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.nyg.jmailer.service.NotificationService

@Component
class JmsMessageListener {

  @Autowired
  NotificationService notificationService

  Logger log = LoggerFactory.getLogger(this.class)

  @JmsListener(destination = "destination", containerFactory = "myJmsContainerFactory")
  public void receiveMessage(Message message) {
    Object command =  ((ObjectMessage) message).getObject()
    log.info "Received ${command.dump()}"
    notificationService.sendNotification(command)
  }

}
