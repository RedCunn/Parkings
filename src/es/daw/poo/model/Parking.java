package es.daw.poo.model;

import java.util.ArrayList;
import java.util.Objects;


public class Parking{

	private String nombre;
	private ArrayList<Plaza> plazas;
	private ConfiguracionParking configuracion;
	private int numero_total_plazas;

	public Parking(String nombre, ConfiguracionParking configuracion) {
		this.nombre = nombre;
		this.plazas = new ArrayList<>();
		this.configuracion = configuracion;
		inicializarPlazas(configuracion);
		this.numero_total_plazas = obtener_numero_total_plazas();
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Plaza> getPlazas() {
		return plazas;
	}

	public ConfiguracionParking getConfiguracion() {
		return configuracion;
	}

	public int getNumero_total_plazas() {
		return numero_total_plazas;
	}

	private void inicializarPlazas(ConfiguracionParking configuracion) {

		plazas.add(new Plaza(TipoVehiculo.COCHE, configuracion.getPlazas_coche()));
		plazas.add(new Plaza(TipoVehiculo.MOTO, configuracion.getPlazas_moto()));
		plazas.add(new Plaza(TipoVehiculo.FURGONETA, configuracion.getPlazas_furgoneta()));
		plazas.add(new Plaza(TipoVehiculo.CAMION, configuracion.getPlazas_camion()));

	}

	private int obtener_numero_total_plazas() {
		int total = 0;
		
		for (Plaza plaza : plazas) {
			total += plaza.getNum_plazas();
		}
		return total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parking other = (Parking) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Parking ").append(nombre + "\n");
		for (Plaza plaza : plazas) {
			builder.append("\tPlazas para " + plaza.getTipovehiculo() + " : " + plaza.getNum_plazas() + "\n");
		}

		return builder.toString();
	}


}
