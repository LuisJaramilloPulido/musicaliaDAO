/**
 * Luis Jaramillo nuevo cambio
 */
package Negocio.Productos;


import java.util.List;


public interface SAProducto {
	
	public Integer altaProductoSA(TransferProducto datos);

	
	public Integer bajaProductoSA(Integer datos);

	
	public Integer modificarProductoSA(TransferProducto datos);

	
	public TransferProducto consultarProductoSA(Integer datos);

	
	public List<TransferProducto> listarProductosSA();
}