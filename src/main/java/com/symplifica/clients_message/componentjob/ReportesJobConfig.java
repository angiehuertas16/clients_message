package com.symplifica.clients_message.componentjob;

import org.jobrunr.scheduling.JobScheduler;
import org.springframework.stereotype.Component;

import com.symplifica.clients_message.service.ResporteClientesJob;

@Component
public class ReportesJobConfig {

    public ReportesJobConfig(JobScheduler jobScheduler, ResporteClientesJob resporteclientesjob) {
        jobScheduler.scheduleRecurrently(
            "reportes-job",
            "0 59 23 * * *",
            resporteclientesjob::runCutasJob
        );
    }

}