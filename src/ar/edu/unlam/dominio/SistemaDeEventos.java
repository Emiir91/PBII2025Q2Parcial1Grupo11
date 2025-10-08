package ar.edu.unlam.dominio;

import java.util.ArrayList;


public class SistemaDeEventos {
	
	private ArrayList<Evento> eventos;

	public SistemaDeEventos() {
		
		this.eventos = new ArrayList<>();
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public Boolean agregarEvento(Evento eventoNuevo) {
		for (Evento evento : eventos) {
			if(evento.getFecha().equals(eventoNuevo.getFecha())) {
				return false;
			}
		}
		
		return eventos.add(eventoNuevo);
	}

	public Boolean agregarParticipante(Integer id, Persona participante) {

		for (Evento evento : eventos) {
			if (evento.getId().equals(id)) {

				if (evento instanceof Casamiento) {
					return evento.agregarParticipantes(participante);
				}

				if (evento instanceof Conferencia) {
					return evento.agregarParticipantes(participante);
				}

				if (evento instanceof Recital) {
					return evento.agregarParticipantes(participante);
				}

			}

		}

		return false;
	}

	
	

}
