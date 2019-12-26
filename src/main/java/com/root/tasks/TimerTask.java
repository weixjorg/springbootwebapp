package com.root.tasks;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
 
/**
 * Created by leo on 2018/1/22.
 * CRON表达式 含义 
“0 0 12 * * ?” 每天中午十二点触发 
“0 15 10 ? * *” 每天早上10：15触发 
“0 15 10 * * ?” 每天早上10：15触发 
“0 15 10 * * ? *” 每天早上10：15触发 
“0 15 10 * * ? 2005” 2005年的每天早上10：15触发 
“0 * 14 * * ?” 每天从下午2点开始到2点59分每分钟一次触发 
“0 0/5 14 * * ?” 每天从下午2点开始到2：55分结束每5分钟一次触发 
“0 0/5 14,18 * * ?” 每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发 
“0 0-5 14 * * ?” 每天14:00至14:05每分钟一次触发 
“0 10,44 14 ? 3 WED” 三月的每周三的14：10和14：44触发 
“0 15 10 ? * MON-FRI” 每个周一、周二、周三、周四、周五的10：15触发

 */
@Component
public class TimerTask {
	static Logger	log	= Logger.getLogger(TimerTask.class);

//	@Resource
//	UserinfoMapper userdao;
	
//	 private Userinfo privateuser;
	private static int flag=0;
	
    @Scheduled(cron = "0/40 * * * * ?")//每5分钟都执行  "0 0/5 * * * ?"
    public void aTask(){
    	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	Map<String,Object> map1=new HashMap<String, Object>();
    	try {
			TimeUnit.SECONDS.sleep(1);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(flag==0) {   	    
    		log.info(sdf.format(DateTime.now().toDate())+"*********aTask任务每5分钟/40秒执行一次,变更flag=1;");
    		flag=1;
        }else {
        	log.info("*********aTask任务执行一次进入测试, 这里什么也不做");

        }
    }
 
        @Scheduled(cron="0/30 * * * * ?")//每6分钟执行一次
		public void bTask(){
		try {
		    TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
		   e.printStackTrace();
		}
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(flag==1) { 
		  log.info(sdf.format(DateTime.now().toDate())+"*********bTask任务6分钟/30秒执行一次进入测试,变更flag=0;");
           flag=0;
		 }
        }
}

