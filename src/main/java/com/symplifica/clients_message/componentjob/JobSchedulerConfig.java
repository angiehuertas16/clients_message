package com.symplifica.clients_message.componentjob;

import org.jobrunr.scheduling.JobScheduler;
import org.springframework.stereotype.Component;
import com.symplifica.clients_message.service.NoticiasJob;

import jakarta.annotation.PostConstruct;

@Component
public class JobSchedulerConfig {

	private final JobScheduler jobScheduler;
    private final NoticiasJob noticiasJob;

    public JobSchedulerConfig(JobScheduler jobScheduler, NoticiasJob noticiasJob) {
        this.jobScheduler = jobScheduler;
        this.noticiasJob = noticiasJob;
    }

    @PostConstruct
    public void scheduleJobs() {
        jobScheduler.scheduleRecurrently(
            "noticias-job",
            "0 0 * * * *",
            () -> noticiasJob.runNoticiasJob()
        );
    }

}