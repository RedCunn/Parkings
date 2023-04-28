package es.daw.poo.model;

import java.util.Comparator;

public class TotalPlazasComparator implements Comparator<Parking> {

	@Override
	public int compare(Parking p1, Parking p2) {
		return Integer.compare(p2.getNumero_total_plazas(),p1.getNumero_total_plazas());
	}

}
