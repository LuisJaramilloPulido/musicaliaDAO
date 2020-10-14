/**
 * 
 */
package Integracion.Ventas;

import java.util.List;

import Negocio.Ventas.TransferVenta;


public interface DAOVenta {
	
	public Integer altaVentaDAO(TransferVenta datos);
	public List<TransferVenta> listarVentasDAO();
}