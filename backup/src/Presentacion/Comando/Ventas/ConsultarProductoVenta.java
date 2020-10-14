/**
 * 
 */
package Presentacion.Comando.Ventas;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Productos.SAProducto;
import Negocio.Productos.TransferProducto;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.RespuestaComando;


public class ConsultarProductoVenta implements Comando {
	
	@Override
	public RespuestaComando ejecutar(Object datos) {
		SAProducto saProducto = FactoriaSA.getInstance().getSAProducto();

		TransferProducto result = saProducto.consultarProductoSA((Integer) datos);

		RespuestaComando respuestaComando = new RespuestaComando();
		if (result != null) {
			respuestaComando.setEvento(IDEvento.EVENTO_CONSULTAR_PRODUCTO_VENTA);
			respuestaComando.setDatos(result);
		} else {
			respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
		}

		return respuestaComando;
	}
}