package com.symplifica.clients_message.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.symplifica.clients_message.repository.CuotaRepository;
import com.symplifica.clients_message.service.JobRunrJobView;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    private final CuotaRepository cuotarepository;

    public JobsController(CuotaRepository cuotarepository) {
        this.cuotarepository = cuotarepository;
    }

    @GetMapping("/logs")
    public List<JobRunrJobView> obtenerLogs() {
        return cuotarepository.obtenerLogsJobs();
    }
}