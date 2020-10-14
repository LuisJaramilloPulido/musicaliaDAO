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


public class AltaProducto implements Comando {
	
	@Override
	public RespuestaComando ejecutar(Object datos) {
		SAProducto saProducto = FactoriaSA.getInstance().getSAProducto();

		Integer result = saProducto.altaProductoSA((TransferProducto) datos);

		RespuestaComando respuestaComando = new RespuestaComando();
		if (result != null) {
			respuestaComando.setEvento(IDEvento.EVENTO_ALTA_PRODUCTO);
			respuestaComando.setDatos(result);
		}
		else {
			respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
		}

		return respuestaComando;
	}
}