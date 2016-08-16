package com.nyg.jmailer.service.impl

import javax.jms.ObjectMessage
import javax.jms.Message
import javax.jms.Session
import javax.jms.JMSException

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.core.MessageCreator
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.nyg.jmailer.service.MessageService
import com.nyg.jmailer.command.MessageCommand

@Service
@EnableJms
class MessageServiceImpl implements MessageService {

  @Autowired
  JmsTemplate jmsTemplate

  Logger log = LoggerFactory.getLogger(this.class)

  void message(final MessageCommand command) {
    MessageCreator messageCreator = new MessageCreator() {

      @Override
      public Message createMessage(Session session) throws JMSException {
        ObjectMessage message = session.createObjectMessage()
        message.setObject(command)
        return message
      }
    }

    log.info 'Sending a new message'
    jmsTemplate.send("destination", messageCreator)
  }
}
