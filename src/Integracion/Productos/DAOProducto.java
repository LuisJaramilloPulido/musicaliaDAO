/**
 * 
 */
package Integracion.Productos;

import java.util.List;

import Negocio.Productos.TransferProducto;


public interface DAOProducto {
	
	public Integer altaProductoDAO(TransferProducto datos);

	
	public Integer bajaProductoDAO(Integer datos);

	
	public Integer modificarProductoDAO(TransferProducto datos);

	
	public TransferProducto consultarProductoDAO(String nombre, String categoria);

	public TransferProducto consultarProductoDAO(Integer id);

	
	public List<TransferProducto> listarProductosDAO();
}