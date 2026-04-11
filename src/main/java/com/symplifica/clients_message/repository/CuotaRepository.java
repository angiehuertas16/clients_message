package com.symplifica.clients_message.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.symplifica.clients_message.model.Cuota;
import com.symplifica.clients_message.service.JobRunrJobView;

@Repository
public interface CuotaRepository extends JpaRepository<Cuota, Integer> {

	@Query(value = """
			SELECT *
			FROM cuotas c
			WHERE c.activo = true
			AND c.fecha_pago >= date_trunc('month', CURRENT_DATE) + interval '1 month'
			AND c.fecha_pago < date_trunc('month', CURRENT_DATE) + interval '2 month'
			""", nativeQuery = true)
	List<Cuota> obtenerCuotasActivasDelMes();

	@Query(value = """
			SELECT id,
			       jobsignature AS jobName,
			       state,
			       createdat
			FROM jobrunr_jobs
			ORDER BY createdat DESC
				        """, nativeQuery = true)
	List<JobRunrJobView> obtenerLogsJobs();

}