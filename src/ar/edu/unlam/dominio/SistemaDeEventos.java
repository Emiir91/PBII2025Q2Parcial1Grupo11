package ar.edu.unlam.dominio;

import java.time.LocalDate;



public class SistemaDeEventos {
	public Integer buscarEventoEntreFecha(LocalDate fechaInicio, LocalDate fechaFinal) {
		Integer cantidad = 0;
		
		for (Evento evento : eventos) {
			LocalDate fecha = evento.getFecha();
			if((fecha.isAfter(fechaInicio) || fecha.isEqual(fechaInicio)) && (fecha.isBefore(fechaFinal) || fecha.isBefore(fechaFinal))) {
				cantidad++;
			}
		}
		return cantidad;
	}
}
