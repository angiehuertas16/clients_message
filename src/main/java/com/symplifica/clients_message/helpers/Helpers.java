package com.symplifica.clients_message.helpers;

public class Helpers {

	public static double extractQuota(double monto,double plazo,double tasa) {
		double  cabeza =0;
		double cuotasr = 0;
		double cuota = 0;
		if(tasa==0) {
			cuotasr=monto/plazo;
		}else {
			  cabeza = ((tasa /100));
			 cuotasr = (cabeza * monto) / (1-(Math.pow((1+cabeza),-plazo )));
		}
		cuota = Math.round(cuotasr);
		return cuota;
	}
	
}
