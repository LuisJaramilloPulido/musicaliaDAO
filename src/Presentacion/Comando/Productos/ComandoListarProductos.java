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

import java.util.List;


public class ComandoListarProductos implements Comando {
	
	@Override
	public RespuestaComando ejecutar(Object datos) {
		SAProducto saProducto = FactoriaSA.getInstance().getSAProducto();

		List<TransferProducto> result = saProducto.listarProductosSA();

		RespuestaComando respuestaComando = new RespuestaComando();
		if (result != null) {
			respuestaComando.setEvento(IDEvento.EVENTO_LISTAR_PRODUCTOS);
			respuestaComando.setDatos(result);
		}
		else {
			respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
		}

		return respuestaComando;
	}
}