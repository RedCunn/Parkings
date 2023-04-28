package es.daw.poo.model;

public class ConfiguracionParking {

	private int plazas_coche;
	private int plazas_moto;
	private int plazas_furgoneta;
	private int plazas_camion;
	
	public ConfiguracionParking(int plazas_coche, int plazas_moto, int plazas_furgoneta, int plazas_camion) {
		this.plazas_coche = plazas_coche;
		this.plazas_moto = plazas_moto;
		this.plazas_furgoneta = plazas_furgoneta;
		this.plazas_camion = plazas_camion;
	}

	public int getPlazas_coche() {
		return plazas_coche;
	}

	public int getPlazas_moto() {
		return plazas_moto;
	}

	public int getPlazas_furgoneta() {
		return plazas_furgoneta;
	}

	public int getPlazas_camion() {
		return plazas_camion;
	}

	
}
