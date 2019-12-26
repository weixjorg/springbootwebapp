package com.root.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WorkOrderJob implements Job {
 
    private static final Logger log = LoggerFactory.getLogger(WorkOrderJob.class);
 
    @Override
    public void execute(JobExecutionContext context)  {
        log.debug("★★★★★★★★★★★"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "定时任务开始★★★★★★★★★★★");
        //获取定时器传输的参数
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        //.....执行业务逻辑
    }
}
