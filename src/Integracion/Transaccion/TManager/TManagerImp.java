/**
 * 
 */
package Integracion.Transaccion.TManager;

import Integracion.Transaccion.FactoriaTransaccion.FactoriaTransaccion;
import Integracion.Transaccion.Transaccion;

import java.util.concurrent.ConcurrentHashMap;


public class TManagerImp extends TManager {

	private ConcurrentHashMap<Thread, Transaccion> transacciones;
	
	// Evitamos que se pueda acceder al constructor desde fuera
	protected TManagerImp() {
		transacciones = new ConcurrentHashMap<>();
	}
	
	@Override
	public Transaccion nuevaTransaccion() {
		if (transacciones.containsKey(Thread.currentThread())) {
			return transacciones.get(Thread.currentThread());
		}

		Transaccion transaccion = FactoriaTransaccion.getInstance().nuevaTransaccion();
		transacciones.put(Thread.currentThread(), transaccion);

		return transaccion;
	}

	
	@Override
	public Transaccion getTransaccion() {
		return transacciones.get(Thread.currentThread());
	}

	@Override
	public void eliminaTransaccion() {
		transacciones.remove(Thread.currentThread());
	}
}