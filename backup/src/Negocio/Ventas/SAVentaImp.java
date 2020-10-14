/**
 * 
 */
package Negocio.Ventas;

import Integracion.FactoriaDAO.FactoriaDAO;
import Integracion.Transaccion.TManager.TManager;
import Integracion.Transaccion.Transaccion;
import Integracion.Ventas.DAOVenta;

import java.util.List;


public class SAVentaImp implements SAVenta {
	
	@Override
	public Integer altaVentaSA(TransferVenta datos) {
		Integer result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOVenta dao = FactoriaDAO.getInstance().getDAOVenta();

			result = dao.altaVentaDAO(datos);

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
	public List<TransferVenta> listarVentasSA() {
		List<TransferVenta> result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOVenta dao = FactoriaDAO.getInstance().getDAOVenta();

			result = dao.listarVentasDAO();

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