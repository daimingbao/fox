package cn.com;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.core.QuartzScheduler;
import org.quartz.core.QuartzSchedulerResources;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdScheduler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SchedulerException {

        QuartzSchedulerResources resources = new QuartzSchedulerResources();
        resources.setJMXObjectName("aa");
        QuartzScheduler sched = new QuartzScheduler(resources, 5, 5);
        Scheduler scheduler = new StdScheduler(sched);
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setName("test");
        jobDetail.setJobClass(MyJob.class);
        sched.addJob(jobDetail, true);
        sched.start();
        System.out.println( "Hello World!" );
    }
}
