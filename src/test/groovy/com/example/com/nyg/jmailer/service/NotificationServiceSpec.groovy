package com.nyg.jmailer.service

import spock.lang.Specification

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.boot.test.IntegrationTest

import com.nyg.jmailer.command.MessageCommand
import com.nyg.jmailer.JmailerApplication

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = JmailerApplication.class)
@IntegrationTest
class NotificationServiceSpec extends Specification {

  @Autowired
  NotificationService notificationService

  void "should send an email"(){
    given:"A command"
      def command = new MessageCommand(email:'josdem@email.com', message:'Hello from test')
    when:"We send a notification"
      Boolean result = notificationService.sendNotification(command)
    then:"No error"
      result
  }
}
