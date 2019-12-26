package com.root.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduleJobs {
       public final static long SECOND = 1 * 1000;
 //      private UserService userService = SpringContextHelper.getBean("userService");
       /**
        * 配置1小时执行一次  0 0 0/1 * * ?
        */
      @Scheduled(cron = "0 0/3 * * * ?")
       public void cronJob() {
 //      User user = new User();
//        user.setName("lisi");
//          System.out.println("执行爬取任务查询会员lisi："+userService.getUser(user));
//           System.out.println("执行爬取任务查询会员lisi");
    	    System.out.println("========定时任务接收处理成功！！！===========cron = \"0 0/3 * * * ?");
//        HttpExecute.sendGet("http://www.chinawutong.com");
      }

}

