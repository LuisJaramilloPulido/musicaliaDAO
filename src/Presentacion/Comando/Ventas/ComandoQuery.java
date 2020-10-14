package Presentacion.Comando.Ventas;


import java.util.List;
import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Productos.TransferProducto;
import Integracion.Query.TransferQuery;
import Negocio.Ventas.SAVenta;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.RespuestaComando;

public class ComandoQuery implements Comando {

	@Override
	public RespuestaComando ejecutar(Object datos) {
		SAVenta queryVenta  = FactoriaSA.getInstance().getSAVenta();
		List<TransferProducto> result = queryVenta.mostrarProductosEnVentaMayoresPrecioSA((TransferQuery)datos);
		RespuestaComando respuestaComando = new RespuestaComando();
		if (result != null) {
			respuestaComando.setEvento(IDEvento.EVENTO_QUERY);
			respuestaComando.setDatos(result);
		}
		else {
			respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
		}

		return respuestaComando;
		
	}

}
