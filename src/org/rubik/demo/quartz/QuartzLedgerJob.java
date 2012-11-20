package org.rubik.demo.quartz;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 定时调度类。
 */

@Component("quartzLedgerJob")
public class QuartzLedgerJob {

	private static final Logger LOG = LoggerFactory
			.getLogger(QuartzLedgerJob.class);

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job ledgerJob;

	@Autowired
	JobParametersBuilder jobParameterBulider;

	private static long counter = 0l;

	/**
	 * 以任务调度方式执行业务方法
	 * 
	 * @throws Exception
	 */
	public void execute() throws Exception {
		LOG.info("start...");
		StopWatch sw = new StopWatch();
		sw.start();
		/*
		 * Spring Batch Job同一个job instance，成功执行后是不允许重新执行的【失败后是否允许重跑，
		 * 可通过配置Job的restartable参数来控制，默认是true】，如果需要重新执行，可以变通处理，
		 * 添加一个JobParameters构建类,以当前时间作为参数，保证其他参数相同的情况下却是不同的job instance
		 */
		jobParameterBulider.addDate("date", new Date());
		jobLauncher.run(ledgerJob, jobParameterBulider.toJobParameters());
		sw.stop();
		LOG.info("Time elapsed:{},Execute quartz ledgerJob:{}",
				sw.prettyPrint(), ++counter);
	}

	/**
	 * 手动测试
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext-batch.xml");
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job ledgerJob = (Job) context.getBean("ledgerJob");
		JobParametersBuilder jobParameterBulider = (JobParametersBuilder) context
				.getBean("jobParameterBulider");
		jobParameterBulider.addDate("date", new Date());

		LOG.warn("start...");
		StopWatch sw = new StopWatch();
		sw.start();
		jobLauncher.run(ledgerJob, jobParameterBulider.toJobParameters());
		sw.stop();
		LOG.warn("Time elapsed:{},Execute quartz ledgerJob:{}",
				sw.prettyPrint(), ++counter);
	}
}
