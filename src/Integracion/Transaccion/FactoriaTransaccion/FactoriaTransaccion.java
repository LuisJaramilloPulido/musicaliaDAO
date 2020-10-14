/**
 * 
 */
package Integracion.Transaccion.FactoriaTransaccion;

import Integracion.Transaccion.Transaccion;


public abstract class FactoriaTransaccion {
	
	private static class SingletonHelper {
		
		private static final FactoriaTransaccion INSTANCE = new FactoriaTransaccionImp();
	}

	
	public static FactoriaTransaccion getInstance() {
		return SingletonHelper.INSTANCE;
	}

	
	public abstract Transaccion nuevaTransaccion();
}