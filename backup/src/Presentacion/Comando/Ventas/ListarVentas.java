/**
 * 
 */
package Presentacion.Comando.Ventas;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Ventas.SAVenta;
import Negocio.Ventas.TransferVenta;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.RespuestaComando;

import java.util.List;


public class ListarVentas implements Comando {
	
	@Override
	public RespuestaComando ejecutar(Object datos) {
		SAVenta saVenta = FactoriaSA.getInstance().getSAVenta();

		List<TransferVenta> result = saVenta.listarVentasSA();

		RespuestaComando respuestaComando = new RespuestaComando();
		if (result != null) {
			respuestaComando.setEvento(IDEvento.EVENTO_LISTAR_VENTAS);
			respuestaComando.setDatos(result);
		}
		else {
			respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
		}

		return respuestaComando;
	}
}