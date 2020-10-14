/**
 * 
 */
package Negocio.Transfer;


public class TransferProducto {
	
	private Integer ID;
	
	private String nombre;
	
	private String categoria;
	
	private Float precio;

	
	public String getCategoria() {
		return this.categoria;
	}

	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	
	public String getNombre() {
		return this.nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public Float getPrecio() {
		return this.precio;
	}

	
	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return ID + ": " + nombre + ", " + categoria + ": " + precio + " €";
	}
}