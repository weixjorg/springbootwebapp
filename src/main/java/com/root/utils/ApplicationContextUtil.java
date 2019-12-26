package com.root.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import lombok.Getter;
import lombok.Setter;

/**
 * spring 容器中获取注入的bean 实例
 * @author  fangh
 */
@Getter
@Setter
public class ApplicationContextUtil implements ApplicationContextAware {
 
    /** 用于保存ApplicationContext的引用，set方式注入*/
    private static ApplicationContext applicationContext = null ;
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContexts) throws BeansException {
        applicationContext = applicationContexts;
    }
 
    /**
     * 获取spring容器中属性
     * @param cls t
     * @return
     */
    public static <T> T getBean(Class<T> cls){
        return applicationContext.getBean(cls);
    }
}
