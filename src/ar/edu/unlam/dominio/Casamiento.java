package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.HashSet;

public class Casamiento extends Evento{

	private Boolean tieneCatering;
	private static final Integer CANTIDAD_PARTICIPANTES = 1;
	private static final Integer EDAD_PERMITIDA = 3;

	public Casamiento(String nombre, LocalDate fecha, String lugar, Boolean tieneCatering) {
		super(nombre, fecha, lugar);
		this.tieneCatering = tieneCatering;
	}

	public Boolean getTieneCatering() {
		return tieneCatering;
	}

	public void setTieneCatering(Boolean tieneCatering) {
		this.tieneCatering = tieneCatering;
	}

	@Override
	public Boolean agregarParticipantes(Persona participante) {

		HashSet<Persona> personas = getParticipantes();
		Integer cantidadPersonas = personas.size();
		
		
		if(cantidadPersonas < Casamiento.CANTIDAD_PARTICIPANTES && participante.getEdad() >= Casamiento.EDAD_PERMITIDA) {
			return personas.add(participante);
		}
		
		return false;
	}
	
	

}
