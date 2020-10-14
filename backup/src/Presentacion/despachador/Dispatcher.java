/**
 * 
 */
package Presentacion.despachador;

import Presentacion.Comando.Comando.IDEvento;


public abstract class Dispatcher {

    private static class SingletonHelper {
        
        private static final Dispatcher INSTANCE = new DispatcherImp();
    }

	
	public static Dispatcher getInstance() {
		return SingletonHelper.INSTANCE;
	}

	
	public abstract void crearVista(IDEvento evento, Object datos);

}