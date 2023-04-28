package es.daw.poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import es.daw.poo.model.Parking;
import es.daw.poo.model.TipoVehiculo;
import es.daw.poo.model.TotalPlazasComparator;
import es.daw.poo.util.UtilMenuApp;
import es.daw.poo.util.UtilParkingApp;

public class ParkingApp {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		DAO dao = new DAO();

		ArrayList<Parking> parkings = dao.select();

		UtilParkingApp util = new UtilParkingApp(parkings);
		UtilMenuApp utilmenu = new UtilMenuApp(parkings);
		
		String opcionMenu = "";

		while (!opcionMenu.equals("--")) {
			utilmenu.imprimirMenuInicio();
			opcionMenu = input.next();
			switch (opcionMenu) {
			case "1":
				while (!opcionMenu.equals("--")) {
					utilmenu.imprimirMenuParkings();
					opcionMenu = input.next();

					if (opcionMenu.equals("--")) {
						System.out.println("Encantada.");
						break;
					}
					
					if (opcionMenu.equals("..")) {
						break;
					}

					try {

						if (opcionMenu.equals("*") || opcionMenu.equals("#") || opcionMenu.equals("+")) {
							switch (opcionMenu) {
							case "*":
								util.imprimirInformeGeneral();
								break;
							case "#":
								System.out.println("Introduce el número de parking que quieras modificar: ");
								int selection = utilmenu.seleccionarParking();
								try {
									util.imprimirInformeParking(selection);
									System.out.println("Intercambiar las plazas de...");
									int selectiontype1 = utilmenu.seleccionarVehiculo();
									System.out.println("por las plazas de...");
									int selectiontype2 = utilmenu.seleccionarVehiculo();
									util.intercambiarPlazasParking(TipoVehiculo.values()[selectiontype1],
											TipoVehiculo.values()[selectiontype2], parkings.get(selection));
									System.out.println("Se han intercambiado correctamente las plazas de "
											+ TipoVehiculo.values()[selectiontype1].name() + " por las plazas de "
											+ TipoVehiculo.values()[selectiontype2].name());
									util.imprimirInformeParking(selection);
								} catch (IndexOutOfBoundsException e) {
									System.out.println("Opción inválida.");
								}
								break;
							case "+":
								ArrayList<Parking> clon = (ArrayList<Parking>)parkings.clone();
								Collections.sort(clon, new TotalPlazasComparator());

								clon.forEach(p -> System.out
										.print(p.getNombre() + " [" + p.getNumero_total_plazas() + "] "));

								System.out.println("");
								break;
							}
						} else {
							int index = Integer.parseInt(opcionMenu);
							try {
								util.imprimirInformeParking(index);
							} catch (IndexOutOfBoundsException e) {
								System.out.println("Introduce opción válida.");
							} catch (NullPointerException n) {
								System.out.println("No podemos acceder a los datos del parking [" + index + "]");
							}
						}

					} catch (NumberFormatException e) {
						System.out.println("Introduce una opción de menú válida...");
					}
				}
				break;
			case "2":
				while (!opcionMenu.equals("--")) {
					utilmenu.imprimirMenuPlazas();
					opcionMenu = input.next();

					if (opcionMenu.equals("..")) {
						break;
					}

					switch (opcionMenu) {
					case "1":
						System.out.println("Número de plazas totales en Alcalá: " + util.obtener_plazasTotalesCiudad());
						break;
					case "2":
						System.out.println("Selecciona tipo de vehículo: ");
						int selection = utilmenu.seleccionarVehiculo();

						try {
							TipoVehiculo tipo = TipoVehiculo.values()[selection];
							System.out.println("Plazas totales en ciudad para " + tipo.name() + " -> "
									+ util.obtener_plazasTotalesPorTipoVehiculoEnCiudad(tipo));
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("Número de vehículo incorrecto.");
						}

						break;
					case "3":
						selection = utilmenu.seleccionarParking();
						try {
							System.out.println("Total de plazas en el parking " + parkings.get(selection).getNombre()
									+ " : " + parkings.get(selection).getNumero_total_plazas());
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Opción inválida.");
						}

						break;
					case "4":
						selection = utilmenu.seleccionarParking();
						int selectiontype = utilmenu.seleccionarVehiculo();

						try {
								TipoVehiculo plazatipo = TipoVehiculo.values()[selectiontype];

								System.out.println("Número de plazas en parking " + parkings.get(selection).getNombre()
										+ " para " + plazatipo.name() + " : "
										+ util.obtener_plazasTipoVehiculoParking(plazatipo, parkings.get(selection)));
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Opción inválida.");
						}

						break;
					case "--":
						System.out.println("Encantada.");
						break;
					default:
						System.out.println("Introduce opción válida.");
					}

				}

				break;
			case "--":
				System.out.println("Encantada.");
				break;
			default:
				System.out.println("Opción inválida. Introduzca 1, 2 o -- para salir");
			}
		}

	}

}
