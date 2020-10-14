/**
 * 
 */
package Negocio.Clientes;

import Integracion.Clientes.DAOCliente;
import Integracion.FactoriaDAO.FactoriaDAO;
import Integracion.Transaccion.TManager.TManager;
import Integracion.Transaccion.Transaccion;

import java.util.List;


public class SAClienteImp implements SACliente {
	
	@Override
	public Integer altaClienteSA(TransferCliente datos) {
		Integer result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();
			DAOCliente dao = FactoriaDAO.getInstance().getDAOCliente();
			TransferCliente cliente = null;
			cliente = dao.consultarClienteDAO(datos.getDNI());
			// Comprobar si el cliente no existe 
			if (cliente == null ) {
				result = dao.altaClienteDAO(datos);
			}
			 //cliente existe y no esta activo
			else if(cliente != null && cliente.getActivo() == false)
				result = dao.modificarClienteDAO(datos);
			
			//Si el cliente esta activo no hace nada, entoces result es NULL
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
	public Integer bajaClienteSA(Integer datos) {
		Integer result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();
			
			
			DAOCliente dao = FactoriaDAO.getInstance().getDAOCliente();
			
			//El cliente existe y este activo y tengo que crear campo activo
			if (dao.consultarClienteDAO(datos) != null) {
				result = dao.bajaClienteDAO(datos);
			}
			

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
	public Integer modificarClienteSA(TransferCliente datos) {
		Integer result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOCliente dao = FactoriaDAO.getInstance().getDAOCliente();
			if (dao.consultarClienteDAO(datos.getID()) != null) {
				result = dao.modificarClienteDAO(datos);
			}
			

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
	public TransferCliente consultarClienteSA(Integer datos) {
		TransferCliente result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOCliente dao = FactoriaDAO.getInstance().getDAOCliente();
			result = dao.consultarClienteDAO(datos);

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
	public List<TransferCliente> listarClientesSA() {
		List<TransferCliente> result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();

			DAOCliente dao = FactoriaDAO.getInstance().getDAOCliente();

			result = dao.listarClientesDAO();

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