package com.nyg.jmailer.advice

import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

import com.nyg.jmailer.exception.BusinessException

@Aspect
@Component
class AfterThrowingAdvice {

  @AfterThrowing(pointcut = "execution(* com.nyg.jmailer.service..**.*(..))", throwing = "ex")
  void doRecoveryActions(RuntimeException ex) {
    println "Wrapping exception ${ex.message}"
    throw new BusinessException(ex.getMessage(), ex)
  }

}
