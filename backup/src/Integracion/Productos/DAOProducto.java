/**
 * 
 */
package Integracion.Productos;

import java.util.ArrayList;
import java.util.List;

import Negocio.Productos.TransferProducto;


public interface DAOProducto {
	
	public Integer altaProductoDAO(TransferProducto datos);

	
	public Integer bajaProductoDAO(Integer datos);

	
	public Integer modificarProductoDAO(TransferProducto datos);

	
	public TransferProducto consultarProductoDAO(String nombre, String categoria);

	public TransferProducto consultarProductoDAO(Integer datos);

	
	public List<TransferProducto> listarProductosDAO();
}