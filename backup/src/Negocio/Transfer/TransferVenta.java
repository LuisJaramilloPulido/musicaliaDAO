/**
 *
 */
package Negocio.Transfer;

import java.util.List;


public class TransferVenta {
	
	private Integer IDVenta;
	
	private Integer IDCliente;
	
	private List<TransferLineaVenta> lineaVentas;

	
	public Integer getIDCliente() {
		return this.IDCliente;
	}

	
	public void setIDCliente(Integer IDCliente) {
		this.IDCliente = IDCliente;
	}

	
	public Integer getIDVenta() {
		return this.IDVenta;
	}

	
	public void setIDVenta(Integer IDVenta) {
		this.IDVenta = IDVenta;
	}

	
	public List<TransferLineaVenta> getLineaVentas() {
		return this.lineaVentas;
	}

	
	public void setLineaVentas(List<TransferLineaVenta> lineaVentas) {
		this.lineaVentas = lineaVentas;
	}


	@Override
	public String toString() {
		return "idVenta "+ IDVenta + "   : " + "idCliente  " + IDCliente;
	}

}