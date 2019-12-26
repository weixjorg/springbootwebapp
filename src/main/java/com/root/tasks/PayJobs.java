package com.root.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PayJobs {
	
 
	private static final Logger logger = LoggerFactory.getLogger(PayJobs.class);
 
	public final static long ONE_Minute = 60 * 1000;
 
	@Scheduled(cron = "0 0/5 * * * ?")
	public void queryPayStatus() {
		logger.info("执行定时任务queryPayStatus---start  cron = \"0 0/2 * * * ?");
		logger.info("执行定时任务queryPayStatus---end   cron = \"0 0/2 * * * ?");
	}
 
}
