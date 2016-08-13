package com.nyg.jmailer.advice

import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.nyg.jmailer.exception.BusinessException

@Aspect
@Component
class AfterThrowingAdvice {

  Logger logger = LoggerFactory.getLogger(this.class)

  @AfterThrowing(pointcut = "execution(* com.nyg.jmailer.service..**.*(..))", throwing = "ex")
  void doRecoveryActions(RuntimeException ex) {
    log.info "Wrapping exception ${ex.message}"
    throw new BusinessException(ex.getMessage(), ex)
  }

}
