/**
 * 
 */
package Integracion.Transaccion.TManager;

import Integracion.Transaccion.FactoriaTransaccion.FactoriaTransaccion;
import Integracion.Transaccion.Transaccion;

import java.util.concurrent.ConcurrentHashMap;


public class TManagerImp extends TManager {

	// Evitamos que se pueda acceder al constructor desde fuera
	protected TManagerImp() {
		transacciones = new ConcurrentHashMap<>();
	}

	
	private ConcurrentHashMap<Thread, Transaccion> transacciones;

	
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