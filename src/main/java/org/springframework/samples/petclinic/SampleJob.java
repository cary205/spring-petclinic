package org.springframework.samples.petclinic;

import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class SampleJob extends QuartzJobBean {

	private String name;

	// Invoked if a Job data map entry with that name
	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println(String.format(Thread.currentThread().getName() + " - Start Hello %s!" + new Date(), this.name));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(String.format(Thread.currentThread().getName() + " - End   Hello %s!" + new Date(), this.name));
	}

}