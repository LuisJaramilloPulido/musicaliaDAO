
package Negocio.Ventas;

import java.util.List;


public class TransferVenta {
	private Integer idVenta;
	private Integer idCliente;
	private float precioTotal;
	private List<LineaVenta> carrito;
	private boolean activo;

	public TransferVenta(){}
	
	
	public TransferVenta(Integer idCliente, float precioTotal, List<LineaVenta> lista ){
		this.idCliente=idCliente;
		this.precioTotal=precioTotal;
		this.carrito=lista;
	}
	
	public Integer getIDCliente() {
		return this.idCliente;
	}

	
	public void setIDCliente(Integer IDCliente) {
		this.idCliente = IDCliente;
	}

	
	public Integer getIDVenta() {
		return this.idVenta;
	}

	
	public void setIDVenta(Integer IDVenta) {
		this.idVenta = IDVenta;
	}

	
	public List<LineaVenta> getCarrito() {
		return this.carrito;
	}

	public void setCarrito(List<LineaVenta>  lista) {
		this.carrito = lista;
	}
	
	public Float getPrecioTotal() {
		return this.precioTotal;
	}
	public void setPrecioTotal(float precio) {
		this.precioTotal=precio;
	}
	
	public Boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	@Override
	public String toString() {
		return "idVenta: " + idVenta + " idCliente:  " + idCliente + "  Total: " + precioTotal;
	}

}