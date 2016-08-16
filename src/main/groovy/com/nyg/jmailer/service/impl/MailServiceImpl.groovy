package com.nyg.jmailer.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.mail.javamail.MimeMessagePreparator
import org.springframework.stereotype.Service
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils
import org.springframework.mail.javamail.JavaMailSenderImpl
import freemarker.template.Configuration
import freemarker.template.Template
import javax.mail.internet.MimeMessage

import com.nyg.jmailer.service.MailService

@Service
class MailServiceImpl implements MailService {

  @Autowired
  JavaMailSenderImpl javaMailSender

  Boolean sendMailWithTemplate(final Map values, final Map model, final String template) {
    MimeMessagePreparator preparator = new MimeMessagePreparator() {
      void prepare(MimeMessage mimeMessage) throws Exception {
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true)
        Template myTemplate = configuration.getTemplate(template)
        message.setTo(values.email)
        message.setSubject(values.subject)
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(myTemplate, model)
        message.setText(text, true)
      }
    }

    this.javaMailSender.send(preparator)
    return true
  }

}
