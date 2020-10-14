/**
 * 
 */
package Negocio.Productos;

import Integracion.FactoriaDAO.FactoriaDAO;
import Integracion.Productos.DAOProducto;
import Integracion.Transaccion.TManager.TManager;
import Integracion.Transaccion.Transaccion;

import java.util.ArrayList;
import java.util.List;


public class SAProductoImp implements SAProducto {
	
	@Override
	public Integer altaProductoSA(TransferProducto datos) {
		// Comprobar datos de producto?

		Integer result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOProducto dao = FactoriaDAO.getInstance().getDAOProducto();

			// Comprobar si el producto no existe
			if (dao.consultarProductoDAO(datos.getNombre(), datos.getCategoria()) == null) {
				result = dao.altaProductoDAO(datos);
			}

			if (result != null) {
				transaccion.commit();
			} else {
				transaccion.rollback();
			}
		}
		catch (Exception e) {
			e.printStackTrace();

			result = null;
		}

		transactionManager.eliminaTransaccion();

		return result;
	}

	
	@Override
	public Integer bajaProductoSA(Integer datos) {
		Integer result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOProducto dao = FactoriaDAO.getInstance().getDAOProducto();
			result = dao.bajaProductoDAO(datos);

			if (result != null) {
				transaccion.commit();
			}
			else {
				transaccion.rollback();
			}
		}
		catch (Exception e) {
			e.printStackTrace();

			result = null;
		}

		transactionManager.eliminaTransaccion();

		return result;
	}

	
	@Override
	public Integer modificarProductoSA(TransferProducto datos) {
		Integer result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOProducto dao = FactoriaDAO.getInstance().getDAOProducto();
			result = dao.modificarProductoDAO(datos);

			if (result != null) {
				transaccion.commit();
			}
			else {
				transaccion.rollback();
			}
		}
		catch (Exception e) {
			e.printStackTrace();

			result = null;
		}

		transactionManager.eliminaTransaccion();

		return result;
	}

	
	@Override
	public TransferProducto consultarProductoSA(Integer datos) {
		TransferProducto result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOProducto dao = FactoriaDAO.getInstance().getDAOProducto();
			result = dao.consultarProductoDAO(datos);

			transaccion.commit();
		}
		catch (Exception e) {
			e.printStackTrace();

			result = null;
		}

		transactionManager.eliminaTransaccion();

		return result;
	}

	
	@Override
	public List<TransferProducto> listarProductosSA() {
		List<TransferProducto> result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOProducto dao = FactoriaDAO.getInstance().getDAOProducto();

			result = dao.listarProductosDAO();

			transaccion.commit();
		}
		catch (Exception e) {
			e.printStackTrace();

			result = null;
		}

		transactionManager.eliminaTransaccion();

		return result;
	}

}