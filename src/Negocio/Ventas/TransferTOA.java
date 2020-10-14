package Negocio.Ventas;

import Negocio.Clientes.TransferCliente;

public class TransferTOA {
	
	private TransferVenta transferVenta;
	private TransferCliente transferCliente;
	
	public TransferTOA(TransferVenta v,TransferCliente c ) {
		this.transferVenta= v;
		this.transferCliente=c;
	}
	public TransferTOA(int id ) {
		
	}
	
	public TransferVenta getVenta() {
		return this.transferVenta;
	}
	
	public TransferCliente getCliente() {
		return this.transferCliente;
	}
	
	
	@Override
	public String toString() {
		return "idVenta "+ transferVenta.getIDVenta()  + " idCliente "+  transferCliente.getNombre()+ " " + transferCliente.getApellido();
	}
}
