package net.bac.sample.service.impl;

import org.springframework.stereotype.Component;

import net.bac.sample.service.HolaMundoService;

/**
 * @author gdiazs
 */
@Component
class HolaMundoServiceImpl implements HolaMundoService{

  @Override
  public String decirHola() {
  
    return "Hola soy: " + HolaMundoServiceImpl.class.getName() ;
  }

}
