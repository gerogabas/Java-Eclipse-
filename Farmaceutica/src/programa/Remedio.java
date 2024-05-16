package programa;

import java.awt.Image;
import java.time.LocalDateTime;

public class Remedio {
	private int id;
	private String marca, droga;
	private Integer dosis, lote, cant;
	private LocalDateTime vencimiento;
	private Image img;
	private boolean recetado, dadoDeBaja;
	
	public Remedio(int id, String marca, String droga, Integer dosis, Integer cant, Integer lote, LocalDateTime vencimiento, Image img, boolean recetado) {
		super();
		this.id = id;
		this.marca = marca;
		this.droga = droga;
		this.dosis = dosis;
		this.cant = cant;
		this.lote = lote;
		this.vencimiento = vencimiento;
		this.img = img;
		this.recetado = recetado;
		dadoDeBaja = false;
	}

	public void darBajaLote() {
		dadoDeBaja = true;
	}
	
	public boolean hayDisponible(int cantidad) {
		if(dadoDeBaja == false)
		{
			if(vencimiento.isAfter(LocalDateTime.now())
			{
				if(cantidad >= cant)
				{
					return true;
				}
				//else return false;
				else throw new Exception("No hay suficientes");
			}
			//else return false;
			else throw new Exception("Esta vencido");
		}
		//else return false;
		else throw new Exception("Fue dado de baja");
	}
	
	public void vender(int cantidad) {
		if(hayDisponible(cant))
			cant = cant-cantidad;
	}
	
	@Override
	public String toString() {
		return "Remedio [marca=" + marca + ", droga=" + droga + "]";
	}

	public int getId() {
		return id;
	}
	public String getMarca() {
		return marca;
	}
	public String getDroga() {
		return droga;
	}
	public Integer getDosis() {
		return dosis;
	}
	public Integer getLote() {
		return lote;
	}
	public LocalDateTime getVencimiento() {
		return vencimiento;
	}
	public Image getImg() {
		return img;
	}

}
