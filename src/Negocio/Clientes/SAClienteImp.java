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
	public Integer altaClienteSA(TransferCliente tCliente) {
		Integer result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();
		try {
			transaccion.start();
			DAOCliente dao = FactoriaDAO.getInstance().getDAOCliente();
			TransferCliente cliente = null;
			// Comprobar si el cliente no existe 
			cliente = dao.consultarClienteDAO(tCliente.getDNI());
			//si el cliente no existe se crea
			if (cliente == null ) {
				result = dao.altaClienteDAO(tCliente);
			}
			 //cliente existe y no esta activo
			else if(cliente != null && cliente.getActivo() == false) {
				//para modificar un cliente, es necesario tener el id del cliente
				//cuando se da de alta a un cliente, no se pone el id, el id del cliente se obtiene al hacer el read del dao cliente
				tCliente.setID(cliente.getID());
				result = dao.modificarClienteDAO(tCliente);
			}
			//Si el cliente existe y esta activo no hace nada, entoces result es NULL--> rollback
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
	public Integer bajaClienteSA(Integer id) {
		Integer result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();
		try {
			transaccion.start();
			TransferCliente cliente = null;
			DAOCliente daoCliente = FactoriaDAO.getInstance().getDAOCliente();
			cliente = daoCliente.consultarClienteDAO(id) ;
			//Si el cliente existe y esta activo -->se da de baja
			if (cliente != null && cliente.getActivo()) {
				result = daoCliente.bajaClienteDAO(id);
			}
			//Si el cliente existe y no esta activo--> no se hace nada rollback
			//Si el cliente no existe-->nose hace nada rollback
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
			DAOCliente daoCliente = FactoriaDAO.getInstance().getDAOCliente();
			TransferCliente cliente = null;
			cliente = daoCliente.consultarClienteDAO(datos.getDNI()) ;
			
			//Si el cliente existe y esta activo -->modifica
			if (cliente != null && cliente.getActivo()==true) {
				result = daoCliente.modificarClienteDAO(datos);
			}
			//Si el cliente no existe ->rollback
			//Si el cliente existe y no esta activo-->rollback

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
	public TransferCliente consultarClienteSA(Integer id) {
		TransferCliente result = null;

		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();
			DAOCliente dao = FactoriaDAO.getInstance().getDAOCliente();
			result = dao.consultarClienteDAO(id);
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