/**
 * 
 */
package Integracion.FactoriaDAO;

import Integracion.Clientes.DAOCliente;
import Integracion.Productos.DAOProducto;
import Integracion.Ventas.DAOVenta;

public abstract class FactoriaDAO {
	private static class SingletonHelper {

		private static final FactoriaDAO INSTANCE = new FactoriaDAOImp();
	}

	public static FactoriaDAO getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public abstract DAOCliente getDAOCliente();

	public abstract DAOProducto getDAOProducto();

	public abstract DAOVenta getDAOVenta();
}