package com.symplifica.clients_message.componentjob;

import org.jobrunr.scheduling.JobScheduler;
import org.springframework.stereotype.Component;
import com.symplifica.clients_message.service.NoticiasJob;

@Component
public class JobSchedulerConfig {

	public JobSchedulerConfig(JobScheduler jobScheduler,
			NoticiasJob noticiasJob) {
		jobScheduler.
		scheduleRecurrently("noticias-job", "0 0 * * *",
				() -> noticiasJob.runNoticiasJob());
	}
}