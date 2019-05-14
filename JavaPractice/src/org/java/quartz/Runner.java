package org.java.quartz;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

	private Logger logger = LoggerFactory.getLogger(Runner.class);
	public static void main(String args) {
		Runner runner = new Runner();
		runner.runDemo();
	}
	
	public void runDemo() {
		try {
			SchedulerFactory factory = new StdSchedulerFactory();
			Scheduler scheduler = factory.getScheduler();
			
			JobDetail job1 = JobBuilder.newJob(FirstJob.class).withIdentity("first-job", "group1").build();
			
			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("first-trigger", "group1")
					.startAt(new Date(System.currentTimeMillis())).withSchedule(SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(10).withRepeatCount(4)).build();
			
			scheduler.scheduleJob(job1, trigger1);
			scheduler.start();
		} catch (SchedulerException e) {
			logger.info("Exception "+e);
		}
	}
}
