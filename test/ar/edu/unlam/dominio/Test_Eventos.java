package ar.edu.unlam.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class Test_Eventos {
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnRecitalExitosamente() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		// Evento evento = new Evento(nombre, fecha, lugar);
		Recital recitalNuevo = new Recital(nombre, fecha, lugar, false, 0); // cambio agregue 2 atributos

		Boolean seAgrego = sistema.agregarEvento(recitalNuevo);

		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnaConferenciaExitosamente() {
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Conferencia conferenciaNueva = new Conferencia(nombre, fecha, lugar, false, false);
		
		Boolean seAgrego = sistema.agregarEvento(conferenciaNueva);

		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnCasamientoExitosamente() {
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnCasamientoQueSupereLaCantidadDeParticipantesProvistas(){
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);

		Integer casamientoId = casamientoNueva.getId();
		
		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(31, "Julieta", 74);
		
		Boolean seAgregoParticipante = sistema.agregarParticipante(casamientoId, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(casamientoId, persona2);

		assertTrue(seAgrego);
		assertTrue(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);

	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroAgregarDosPersonasAlEventoConElMismoDNIyObtenerError(){
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		Integer casamientoId = casamientoNueva.getId();

		
		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(912, "Julieta", 74);
		
		Boolean seAgregoParticipante = sistema.agregarParticipante(casamientoId, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(casamientoId, persona2);

		assertTrue(seAgrego);
		assertTrue(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);

	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroAgregarParticipantesEnUnEventoConIdInventado(){

		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		Integer idInventado = 5;

		
		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(1, "Julieta", 74);
		
		Boolean seAgregoParticipante = sistema.agregarParticipante(idInventado, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(idInventado, persona2);

		assertTrue(seAgrego);
		assertFalse(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);
	}
	
}
