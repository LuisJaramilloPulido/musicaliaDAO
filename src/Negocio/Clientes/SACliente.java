/**
 * 
 */
package Negocio.Clientes;

import java.util.List;


public interface SACliente {
	
	public Integer altaClienteSA(TransferCliente datos);

	
	public Integer bajaClienteSA(Integer datos);

	
	public Integer modificarClienteSA(TransferCliente datos);

	
	public TransferCliente consultarClienteSA(Integer datos);

	
	public List<TransferCliente> listarClientesSA();
}