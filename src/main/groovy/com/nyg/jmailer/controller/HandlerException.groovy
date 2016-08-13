package com.nyg.jmailer.controller

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Component
class HandlerException implements HandlerExceptionResolver {

  ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
    log.info ex.message
    def data = [:]
    data.message = ex.message
    ModelAndView modelAndView = new ModelAndView('error')
    modelAndView.addObject('data',data)
    modelAndView
  }

}
