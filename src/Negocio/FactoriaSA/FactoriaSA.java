/**
 * 
 */
package Negocio.FactoriaSA;

import Negocio.Clientes.SACliente;
import Negocio.Ventas.SAVenta;
import Negocio.Productos.SAProducto;


public abstract class FactoriaSA {
	private static class SingletonHelper {
		
		private static final FactoriaSA INSTANCE = new FactoriaSAImp();
	}

	
	public static FactoriaSA getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public abstract SACliente getSACliente();


	public abstract SAVenta getSAVenta();

	
	public abstract SAProducto getSAProducto();

}