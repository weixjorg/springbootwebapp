package com.root.configs;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import com.root.dao.CronMapper;

//@EnableScheduling
//@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
 
	@Resource
	 CronMapper cronMapper;
 
	/**
	 * 执行定时任务.
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(
				// 1.添加任务内容(Runnable)
				() -> {
					// 1.1具体任务
					System.out.println("执行定时任务: " + LocalDateTime.now().toLocalTime());
				},
				// 2.设置执行周期(Trigger)
				triggerContext -> {
					// 2.1 从数据库获取执行周期
					String cron = cronMapper.selectAll().get(0).getCron();
					// 2.2 合法性校验.
					if (StringUtils.isEmpty(cron)) {
						// 根据需求修改
					}
					// 2.3 返回执行周期(Date)
					return new CronTrigger(cron).nextExecutionTime(triggerContext);
				});
	}
}
