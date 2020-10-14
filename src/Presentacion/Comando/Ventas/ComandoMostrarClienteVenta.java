package Presentacion.Comando.Ventas;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Ventas.SAVenta;
import Negocio.Ventas.TransferTOA;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.RespuestaComando;

public class ComandoMostrarClienteVenta implements Comando {

	@Override
	public RespuestaComando ejecutar(Object datos) {
		SAVenta saVenta = FactoriaSA.getInstance().getSAVenta();
		TransferTOA result = saVenta.EnsambladorObjetosTransfererencia((Integer) datos);

		RespuestaComando respuestaComando = new RespuestaComando();
		if (result != null) {
			respuestaComando.setEvento(IDEvento.EVENTO_MOSTRAR_CLIENTE_VENTA);
			respuestaComando.setDatos(result);
		} else {
			respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
		}
		return respuestaComando;
	}

}
