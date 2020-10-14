/**
 * 
 */
package Integracion.Ventas;

import java.util.List;

import Negocio.Ventas.TransferVenta;


public interface DAOVenta {
	
	public Integer crearVentaDAO(TransferVenta datos);
	public List<TransferVenta> listarVentasDAO();
	public TransferVenta consultarVentaDAO(Integer idVenta);
}