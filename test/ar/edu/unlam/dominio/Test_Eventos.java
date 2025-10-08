package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class Test_Eventos {
	@Test
	public void buscarCuantosEventosSeEncuentranDisponiblesEnUnLapsoDeDosFechas() {
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		LocalDate fechaInicio = LocalDate.of(2025, 10, 1);
		LocalDate fechaFinal = LocalDate.of(2025, 12, 1);
		
		String nombreRecital = "Recital";
		LocalDate fechaRecital = LocalDate.of(2025,10,6);
		String lugarRecital = "Movistar Arena";
		Recital recitalNuevo = new Recital(nombreRecital, fechaRecital,lugarRecital);
		
		String nombreConferencia = "Conferencia";
		LocalDate fechaConferencia = LocalDate.of(2025,11,6);
		String lugarConferencia = "Gran Rex";
		Conferencia conferenciaNueva = new Conferencia(nombreConferencia, fechaConferencia,lugarConferencia);
		
		String nombreCasamiento = "Casamiento";
		LocalDate fechaCasamiento = LocalDate.of(2025,12,6);
		String lugarCasamiento = "Buenos Aires Gala";
		Casamiento casamientoNuevo = new Casamiento(nombreCasamiento, fechaCasamiento,lugarCasamiento, false);
		

		Boolean seAgregoRecital = sistema.agregarEvento(recitalNuevo);
		Boolean seAgregoConferencia = sistema.agregarEvento(conferenciaNueva);
		Boolean seAgregoCasamiento = sistema.agregarEvento(casamientoNuevo);

		
		Integer cantidadEventosEntreFecha = sistema.buscarEventoEntreFecha(fechaInicio, fechaFinal);
		Integer cantidadEventosEntreFechaEsperada = 2;
		
		assertTrue(seAgregoRecital);
		assertTrue(seAgregoConferencia);
		assertTrue(seAgregoCasamiento);
		assertEquals(cantidadEventosEntreFechaEsperada, cantidadEventosEntreFecha);
		
	}
}	

