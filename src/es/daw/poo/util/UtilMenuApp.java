package es.daw.poo.util;

import java.util.ArrayList;
import java.util.Scanner;

import es.daw.poo.model.Parking;
import es.daw.poo.model.TipoVehiculo;

public class UtilMenuApp {
	
	private ArrayList<Parking> parkings;
	private Scanner input = new Scanner(System.in);
	
	
	
	public UtilMenuApp(ArrayList<Parking> parkings) {
		super();
		this.parkings = parkings;
	}

	public void imprimirMenuInicio() {
		System.out.println("__________________________________________________________________");
		System.out.println("");
		System.out.println("         PARKINGS DE ALCALÁ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
		System.out.println("         ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬CONCEJALÍA DE TURISMOS");
		System.out.println("");
		System.out.println("         / Ayuntamiento de Alcalá de Henares /");
		System.out.println("__________________________________________________________________");
		System.out.println("");
		System.out.println("\t1. Ver Parkings");
		System.out.println("\t2. Consultar plazas de aparcamiento");
		System.out.println("------------------------------------------------------------------");
		System.out.println("\t\t -- [CERRAR APLICACION]");
		System.out.println("__________________________________________________________________");
	}

	public void imprimirMenuParkings() {

		System.out.println("__________________________________________________________________");
		System.out.println("");
		System.out.println("         PARKINGS DE ALCALÁ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
		System.out.println("         ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬CONCEJALÍA DE TURISMOS");
		System.out.println("");
		System.out.println("         / Ayuntamiento de Alcalá de Henares /");
		System.out.println("__________________________________________________________________");
		System.out.println("");
		parkings.forEach(p->System.out.println("\t" + parkings.indexOf(p) + ". " + p.getNombre()));
		System.out.println("------------------------------------------------------------------");
		System.out.println("\t * INFORME GENERAL");
		System.out.println("\t # [INTERCAMBIAR PLAZAS DE PARKING]");
		System.out.println("\t + [ORDENAR PLAZAS DE PARKING]");
		System.out.println("------------------------------------------------------------------");
		System.out.println("\t\t .. VOLVER");
		System.out.println("\t\t -- [CERRAR APLICACION]");
		System.out.println("__________________________________________________________________");
	}

	public void imprimirMenuPlazas() {
		System.out.println("__________________________________________________________________");
		System.out.println("");
		System.out.println("         PARKINGS DE ALCALÁ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
		System.out.println("         ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬CONCEJALÍA DE TURISMOS");
		System.out.println("");
		System.out.println("         / Ayuntamiento de Alcalá de Henares /");
		System.out.println("__________________________________________________________________");
		System.out.println("");
		System.out.println("\t1. Número de plazas totales en Alcalá");
		System.out.println("\t2. Número de plazas totales por tipo de vehículo en Alcalá");
		System.out.println("\t3. Número de plazas totales por Parking");
		System.out.println("\t4. Número de plazas en Parking por tipo de vehículo");
		System.out.println("------------------------------------------------------------------");
		System.out.println("\t\t .. VOLVER");
		System.out.println("\t\t -- [CERRAR APLICACION]");
		System.out.println("__________________________________________________________________");
	}
	
	public int seleccionarParking() {
		int selection = 0;
		int index = 1;
		for (Parking park : parkings) {
			System.out.println(index + ". " + park.getNombre());
			index++;
		}
		System.out.println("\t\tSelecciona Parking: ");
		selection = input.nextInt();

		return selection -1;
	}

	public int seleccionarVehiculo() {
		int selectiontype = 0;
		int index = 1;
		for (TipoVehiculo tipo : TipoVehiculo.values()) {
			System.out.println(index + ". " + tipo);
			index++;
		}
		selectiontype = input.nextInt();

		return selectiontype -1 ;
	}

}
