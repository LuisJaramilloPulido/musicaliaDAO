/**
 * 
 */
package Integracion.Query;

import java.util.List;

import Negocio.Productos.TransferProducto;

public interface QueryVenta {
	
	public List<TransferProducto> execute(TransferQuery datos);
}