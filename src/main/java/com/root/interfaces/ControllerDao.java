package com.root.interfaces;

import org.springframework.web.servlet.ModelAndView;

public interface ControllerDao<T> {
	  public ModelAndView add(Class<T> T);
	  public ModelAndView update(Class<T> T);	
      public ModelAndView modify(int id); 
      public ModelAndView delete(int id);
      public ModelAndView selectAll();     
      public ModelAndView getOne(int id);
}
