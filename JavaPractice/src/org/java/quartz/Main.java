package org.java.quartz;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.quartzTest();
	}
	
	public void quartzTest() {
		try {
			SchedulerFactory factory = new StdSchedulerFactory();
			Scheduler scheduler = factory.getScheduler();
			scheduler.start();
			
			JobDetail job1 = JobBuilder.newJob(FirstJob.class).withIdentity("first-job", "group1").build();
			
			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(DateBuilder.nextGivenSecondDate(null, 2))
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(4)).build();
			
			scheduler.scheduleJob(job1, trigger1);
			Thread.sleep(10000);
			scheduler.shutdown();
		} catch (Exception e) {
			
		}
	}

}
