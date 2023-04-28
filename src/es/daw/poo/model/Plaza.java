package es.daw.poo.model;

public class Plaza {

	private TipoVehiculo tipovehiculo;
	private int num_plazas;
	
	public Plaza(TipoVehiculo tipovehiculo, int num_plazas) {
		this.tipovehiculo = tipovehiculo;
		this.num_plazas = num_plazas;
	}

	public TipoVehiculo getTipovehiculo() {
		return tipovehiculo;
	}

	public int getNum_plazas() {
		return num_plazas;
	}

	public void setTipovehiculo(TipoVehiculo tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	public void setNum_plazas(int num_plazas) {
		this.num_plazas = num_plazas;
	}
	
	
	
}
