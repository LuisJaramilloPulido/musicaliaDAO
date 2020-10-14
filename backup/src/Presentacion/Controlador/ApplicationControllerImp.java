/**
 * 
 */
package Presentacion.Controlador;

import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Comando.FactoriaComando.FactoriaComando;
import Presentacion.despachador.Dispatcher;


public class ApplicationControllerImp extends ApplicationController {

	// Evitamos que se pueda acceder al constructor desde fuera
	protected ApplicationControllerImp() {}

	@Override
	public RespuestaComando handleRequest(IDEvento evento, Object datos) {
		Comando comando = FactoriaComando.getInstance().nuevoComando(evento);

		RespuestaComando respuestaComando = null;
		if (comando != null) {
			respuestaComando = comando.ejecutar(datos);
		}

		if (respuestaComando != null) {
			Dispatcher.getInstance().crearVista(respuestaComando.getEvento(), respuestaComando.getDatos());
		}
		else {
			Dispatcher.getInstance().crearVista(evento, null);
		}

		return respuestaComando;
	}

}