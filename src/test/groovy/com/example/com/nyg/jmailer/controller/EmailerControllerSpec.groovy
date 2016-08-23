package com.nyg.jmailer.controller

import spock.lang.Specification
import org.springframework.http.HttpStatus

import com.nyg.jmailer.service.EmailerService
import com.nyg.jmailer.command.MessageCommand

class EmailerControllerSpec extends Specification {

  EmailerController controller = new EmailerController()

  EmailerService emailerService = Mock(EmailerService)

  def setup(){
    controller.emailerService = emailerService
  }

  void "should send an email"(){
    given:"A message command"
      def command = new MessageCommand(email:'josdem@email.com', message:'hello from testing')
    when:
      def result = controller.message(command)
    then:
      1 * emailerService.sendEmail(command)
      result.getStatusCode() == HttpStatus.OK
      result.getBody() == "OK"
  }

}
