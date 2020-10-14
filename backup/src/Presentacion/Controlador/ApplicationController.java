/**
 * 
 */
package Presentacion.Controlador;

import Presentacion.Comando.Comando.IDEvento;


public abstract class ApplicationController {

    private static class SingletonHelper {
       
        private static final ApplicationController INSTANCE = new ApplicationControllerImp();
    }

	
	public static ApplicationController getInstance() {
		return SingletonHelper.INSTANCE;
	}

	
	public abstract RespuestaComando handleRequest(IDEvento evento, Object datos);

}