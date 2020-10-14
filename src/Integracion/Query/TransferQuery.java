package Integracion.Query;

public class TransferQuery {
	private int idVenta;
	private float precio;
	
	public TransferQuery(int id, float precio) {
		this.idVenta=id;
		this.precio= precio;
		
	}
	
	public int getIdVenta() {
		return this.idVenta;
	}
	
	public float getPrecio() {
		return this.precio;
	}
	
}
