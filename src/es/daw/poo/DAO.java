package es.daw.poo;

import java.util.ArrayList;

import es.daw.poo.model.ConfiguracionParking;
import es.daw.poo.model.Parking;

public class DAO {

	private final ArrayList<Parking> parks = new ArrayList<>();

	public DAO() {
		
		ConfiguracionParking paloma = new ConfiguracionParking(35, 18, 12, 0);
			parks.add(new Parking("La Paloma", paloma));
		ConfiguracionParking mercado = new ConfiguracionParking(25, 20, 0, 5);
			parks.add(new Parking("El Mercado", mercado));
		ConfiguracionParking lucas = new ConfiguracionParking(32, 15, 10, 0);
			parks.add(new Parking("San Lucas", lucas));
		ConfiguracionParking obispado = new ConfiguracionParking(47, 25, 15, 10);
			parks.add(new Parking("Obispado", obispado));
	}

	public ArrayList<Parking> select(){
		return (ArrayList<Parking>)parks.clone();
	}
}
