package com.nyg.jmailer

import javax.jms.ConnectionFactory

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.config.SimpleJmsListenerContainerFactory
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.util.FileSystemUtils

@SpringBootApplication
class JmailerApplication {

  @Value('${email.username}')
  String username
  @Value('${email.password}')
  String password

  @Bean
  JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
    SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory()
    factory.setConnectionFactory(connectionFactory)
    return factory
  }

  @Bean
  JavaMailSenderImpl javaMailSenderImpl(){
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl()
    mailSender.setHost("smtp.gmail.com")
    mailSender.setPort(587)
    mailSender.setUsername(username)
    mailSender.setPassword(password)
    Properties prop = mailSender.getJavaMailProperties()
    prop.put("mail.transport.protocol", "smtp")
    prop.put("mail.smtp.auth", "true")
    prop.put("mail.smtp.starttls.enable", "true")
    prop.put("mail.debug", "true")
    return mailSender
  }

  static void main(String[] args) {
    SpringApplication.run JmailerApplication, args
  }
}
