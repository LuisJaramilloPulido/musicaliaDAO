/**
 * 
 */
package Negocio.Productos;


public class TransferProducto {
	
	private Integer id;
	private String nombre;
	private Float precio;
	private String categoria;
	
	private boolean activo;
	private Integer stock;
	
	public TransferProducto() {
		
	}
	
	public TransferProducto (String nombre,float precio, String categoria, Integer stock){
		this.nombre=nombre;
		this.precio=precio;
		this.categoria = categoria;
		this.stock= stock;
	}
	
	public TransferProducto (Integer id,String nombre,float precio, String categoria, Integer stock){
		this.id= id;
		this.nombre=nombre;
		this.precio=precio;
		this.categoria = categoria;
		this.stock= stock;
	}
	
	public String getCategoria() {
		return this.categoria;
	}

	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	public Integer getID() {
		return this.id;
	}

	public void setID(Integer ID) {
		this.id = ID;
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
	
	public Boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	public Integer getStock() {
		return this.stock;
	}
	
	public void setStock(Integer stock) {
		 this.stock=stock;
	}
	
	@Override
	public String toString() {
		return id + ": " + nombre + ", " + categoria + ": " + precio + " € "+" stock: " +stock + " activo: " + activo;
	}
}