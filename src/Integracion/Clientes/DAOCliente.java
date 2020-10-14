/**
 * 
 */
package Integracion.Clientes;

import java.util.ArrayList;
import java.util.List;

import Negocio.Clientes.TransferCliente;


public interface DAOCliente {
	
	public Integer altaClienteDAO(TransferCliente datos);

	
	public Integer bajaClienteDAO(Integer datos);

	
	public Integer modificarClienteDAO(TransferCliente datos);

	
	public TransferCliente consultarClienteDAO(String dni);

	
	public TransferCliente consultarClienteDAO(Integer datos);

	public List<TransferCliente> listarClientesDAO();
}