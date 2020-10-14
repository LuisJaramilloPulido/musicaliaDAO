/**
 * 
 */
package Presentacion.Comando.Productos;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Productos.SAProducto;
import Negocio.Productos.TransferProducto;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.RespuestaComando;


public class ComandoModificarProducto implements Comando {
	
	@Override
	public RespuestaComando ejecutar(Object datos) {
		SAProducto saProducto = FactoriaSA.getInstance().getSAProducto();

		Integer result = saProducto.modificarProductoSA((TransferProducto) datos);

		RespuestaComando respuestaComando = new RespuestaComando();
		if (result != null) {
			respuestaComando.setEvento(IDEvento.EVENTO_MODIFICAR_PRODUCTO);
		}
		else {
			respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
		}

		return respuestaComando;
	}
}