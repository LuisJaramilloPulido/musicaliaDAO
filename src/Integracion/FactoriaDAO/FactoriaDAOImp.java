/**
 * 
 */
package Integracion.FactoriaDAO;

import Integracion.Clientes.DAOCliente;
import Integracion.Clientes.DAOClienteImp;
import Integracion.Productos.DAOProducto;
import Integracion.Productos.DAOProductoImp;
import Integracion.Ventas.DAOVenta;
import Integracion.Ventas.DAOVentaImp;


public class FactoriaDAOImp extends FactoriaDAO {

	// Evitamos que se pueda acceder al constructor desde fuera
	protected FactoriaDAOImp() {}

	
	private DAOCliente daoCliente;
	
	private DAOVenta daoVenta;
	
	private DAOProducto daoProducto;


	
	@Override
	public DAOCliente getDAOCliente() {
		if (daoCliente == null) {
			daoCliente = new DAOClienteImp();
		}

		return daoCliente;
	}

	
	@Override
	public DAOVenta getDAOVenta() {
		if (daoVenta == null) {
			daoVenta = new DAOVentaImp();
		}

		return daoVenta;
	}

	@Override
	public DAOProducto getDAOProducto() {
		if (daoProducto == null) {
			daoProducto = new DAOProductoImp();
		}

		return daoProducto;
	}
}