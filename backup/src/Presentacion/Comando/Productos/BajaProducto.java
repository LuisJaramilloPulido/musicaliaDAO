/**
 * 
 */
package Presentacion.Comando.Productos;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Productos.SAProducto;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.RespuestaComando;


public class BajaProducto implements Comando {
	
	@Override
	public RespuestaComando ejecutar(Object datos) {
		SAProducto saProducto = FactoriaSA.getInstance().getSAProducto();

		Integer result = saProducto.bajaProductoSA((Integer) datos);

		RespuestaComando respuestaComando = new RespuestaComando();
		if (result != null) {
			respuestaComando.setEvento(IDEvento.EVENTO_BAJA_PRODUCTO);
		}
		else {
			respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
		}

		return respuestaComando;
	}
}