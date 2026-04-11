package com.symplifica.clients_message.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.symplifica.clients_message.model.Cuota;
import com.symplifica.clients_message.repository.CuotaRepository;

@Service
public class ResporteClientesJob {

	
	private final EmailService emailService;
	private final CuotaRepository cuotaRepository;
	
	public ResporteClientesJob(CuotaRepository cuotaRepository,EmailService emailService) {
		this.cuotaRepository = cuotaRepository;
		this.emailService=emailService;
	}

	public void runCutasJob() {
		List<Cuota> titles = cuotaRepository.obtenerCuotasActivasDelMes();
		
		for (Cuota cuota : titles) {
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("nombre", cuota.getCredito().getUsuario().getNombre());
			map.put("numeroCuota", cuota.getNumerocuota());
			map.put("fechaPago", cuota.getFecha_pago());
			map.put("valorCuota", cuota.getValor_cuota());
			
			String correo ="esteban_-456@hotmail.com";
			String path = "src/main/resources/templates/recordatorio_pago.html";
			String subjec ="Tu proxima fecha de pago";
			try {
				emailService.sendEmail(map, path,correo,subjec);
				System.out.println("Mail enviado");
			} catch (Exception e) {
				System.out.println("Email no enviado " + e.getMessage());
			}
		}
	}
	
}
