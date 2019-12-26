package com.root.service;

import java.util.Calendar;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.root.dao.CornTriggerQuartzMapper;
import com.root.entity.CornTriggerQuartz;
import com.root.tasks.WorkOrderJob;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;


    @Service
	public class JobServiceImpl {
	 
	    @Autowired
	    private Scheduler scheduler;
	 
	    @Autowired
	    private CornTriggerQuartzMapper cornTriggerQuartzMapper;
	 
	 
	    /**
	     * 新建一个任务
	     *
      */
/*	    
public String updateJob(CornTriggerQuartz cornTriggerQuartz) throws SchedulerException  {
	 
	        if(cornTriggerQuartz.getQuartzTime().before(new Date())){
	            return "cron time must be after now";
	        }
	//        cornTriggerQuartz.setQuartzTime(DateUtil.afterTime(new Date(), Calendar.MINUTE,2));
	        cornTriggerQuartz.setQuartzTime();
	        String quartzStr = DateUtil.transfToQuartzStr(cornTriggerQuartz.getQuartzTime());
	        //校验定时器数据格式，表达式格式不正确
	        if (!CronExpression.isValidExpression(quartzStr)) {
	            return "Illegal cron expression";
	        }
	 
	        JobDetail jobDetail=null;
	        //构建job信息
	        if(WorkOrderJob.class.getSimpleName().equals(cornTriggerQuartz.getJobGroup())) {
	            jobDetail = JobBuilder.newJob(WorkOrderJob.class)
	                    .withIdentity(cornTriggerQuartz.getJobName(), cornTriggerQuartz.getJobGroup()).build();
	        }
	 
	        if(jobDetail == null){
	            throw new SchedulerException("暂无构建的对象");
	        }
	 
	        //表达式调度构建器(即任务执行的时间,不立即执行)
	        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
	                        .cronSchedule(quartzStr)
	                        .withMisfireHandlingInstructionDoNothing();
	 
	        //按新的cronExpression表达式构建一个新的trigger
	        CronTrigger trigger = TriggerBuilder.newTrigger()
	                    .withIdentity(cornTriggerQuartz.getJobName(), cornTriggerQuartz.getJobGroup())
	                    .startAt(cornTriggerQuartz.getQuartzTime())
	                    .withSchedule(scheduleBuilder).build();
	 
	        //传递参数
	        if(ObjectUtil.StringIsNotNull(cornTriggerQuartz.getInvokeParam())) {
	         //   trigger.getJobDataMap().put(Commons.Quartz.workorder.getInvokeParamKey(),cornTriggerQuartz.getInvokeParam());
	        }
	 
	        TriggerKey triggerKey = TriggerKey.triggerKey(cornTriggerQuartz.getJobName(),cornTriggerQuartz.getJobGroup());
	        //如果存在则修改，不存在则插入
	        if(scheduler.checkExists(jobDetail.getKey()) && scheduler.checkExists(triggerKey)){
	            scheduler.rescheduleJob(triggerKey, trigger);
	        }else{
	            scheduler.scheduleJob(jobDetail, trigger);
	        }
	 
	        if(ObjectUtil.StringIsNotNull(cornTriggerQuartz.getUuid())){
	            cornTriggerQuartzMapper.updateById(cornTriggerQuartz);
	        }else{
	            cornTriggerQuartzMapper.insert(cornTriggerQuartz);
	        }
	 
	        return "success";
	    }
	 
	 */
	    /**
	     * 删除某个任务
	     * @return
	     * @throws SchedulerException
	     */
	    public String  deleteJob(String jobGroupName,String jobName) throws SchedulerException {
	        JobKey jobKey = new JobKey(jobName, jobGroupName);
	        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
	        if (jobDetail == null ) {
	            return "jobDetail is null";
	        }else if(!scheduler.checkExists(jobKey)) {
	            return "jobKey is not exists";
	        }else {
	            scheduler.deleteJob(jobKey);
	            return "success";
	        }
	       }
	    
    }
