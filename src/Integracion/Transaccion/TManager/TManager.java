/**
 * 
 */
package Integracion.Transaccion.TManager;

import Integracion.Transaccion.Transaccion;


public abstract class TManager {
	private static class SingletonHelper {
		
		private static final TManager INSTANCE = new TManagerImp();
	}

	
	public static TManager getInstance() {
		return SingletonHelper.INSTANCE;
	}

	
	public abstract Transaccion nuevaTransaccion();

	
	public abstract Transaccion getTransaccion();

	
	public abstract void eliminaTransaccion();
}