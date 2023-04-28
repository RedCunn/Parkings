package es.daw.poo.util;

import java.util.ArrayList;
import es.daw.poo.model.Parking;
import es.daw.poo.model.Plaza;
import es.daw.poo.model.TipoVehiculo;

public class UtilParkingApp {

	private ArrayList<Parking> parkings;

	public UtilParkingApp(ArrayList<Parking> parkings) {
		this.parkings = parkings;
	}

	public void imprimirInformeGeneral() {
		parkings.forEach(p -> System.out.println(p));
	}

	public void imprimirInformeParking(int index) {
		System.out.println(parkings.get(index));
	}

	public int obtener_plazasTotalesCiudad() {

		int total_plazas_ciu = 0;

		for (Parking park : parkings) {
			for (Plaza plaza : park.getPlazas()) {
				total_plazas_ciu += plaza.getNum_plazas();
			}
		}

		return total_plazas_ciu;
	}

	public int obtener_plazasTotalesPorTipoVehiculoEnCiudad(TipoVehiculo tipo) {
		int total_plazas_tipo_vehi = 0;

		for (Parking park : parkings) {
			for (Plaza plaza : park.getPlazas()) {
				if (plaza.getTipovehiculo().equals(tipo)) {
					total_plazas_tipo_vehi += plaza.getNum_plazas();
				}
			}
		}

		return total_plazas_tipo_vehi;
	}

	public int obtener_plazasTipoVehiculoParking(TipoVehiculo tipo, Parking parking) {
		int plazas_tipo_vehi_parking = 0;

		for (Parking park : parkings) {
			if (park.getNombre().equals(parking.getNombre())) {
				for (Plaza plaza : park.getPlazas()) {
					if (plaza.getTipovehiculo().equals(tipo)) {
						plazas_tipo_vehi_parking += plaza.getNum_plazas();
					}
				}
			}
		}

		return plazas_tipo_vehi_parking;
	}

	public void intercambiarPlazasParking(TipoVehiculo tipo1, TipoVehiculo tipo2, Parking parking) {

		int numplazas1 = 0;
		int numplazas2 = 0;

		for (Plaza plaza : parking.getPlazas()) {

			if (plaza.getTipovehiculo().equals(tipo1)) {
				numplazas1 = plaza.getNum_plazas();
			}

			if (plaza.getTipovehiculo().equals(tipo2)) {
				numplazas2 = plaza.getNum_plazas();
			}

		}

		for (Plaza plaza : parking.getPlazas()) {

			if (plaza.getTipovehiculo().equals(tipo1)) {
				plaza.setNum_plazas(numplazas2);
			}

			if (plaza.getTipovehiculo().equals(tipo2)) {
				plaza.setNum_plazas(numplazas1);
			}

		}
	}

}
