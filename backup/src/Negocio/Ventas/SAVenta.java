/**
 * 
 */
package Negocio.Ventas;

import java.util.List;

public interface SAVenta {
	
	public Integer altaVentaSA(TransferVenta datos);
	public List<TransferVenta> listarVentasSA();
}