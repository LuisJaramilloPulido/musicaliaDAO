/**
 * 
 */
package Negocio.Productos;
import Integracion.FactoriaDAO.FactoriaDAO;
import Integracion.Productos.DAOProducto;
import Integracion.Transaccion.TManager.TManager;
import Integracion.Transaccion.Transaccion;
import java.util.List;


public class SAProductoImp implements SAProducto {
	
	@Override
	public Integer altaProductoSA(TransferProducto tProducto) {
		// Comprobar datos de producto?
		Integer result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();
			DAOProducto daoProducto = FactoriaDAO.getInstance().getDAOProducto();
			TransferProducto producto = null;
			//al dar de alta un producto en un principio no tiene id, entonces se consulta por nombre y categoria
			producto= daoProducto.consultarProductoDAO(tProducto.getNombre(), tProducto.getCategoria());
			
			//Si el producto no existe entonces se crea
			if (producto == null) {
				result = daoProducto.altaProductoDAO(tProducto);
			}
			// Si el producto existe y no esta activo -> se reactiva
			else if(producto !=null && !producto.getActivo()) {
				//para modificar un producto, es necesario tener el id del producto
				//cuando se da de alta un producto, no se pone el id,
				//por lo tanto es necesario obtenerlo del transferProducto del read del dao
				tProducto.setID(producto.getID());
				result= daoProducto.modificarProductoDAO(tProducto);
			}
			//si el producto existe y esta activo-> no hace nada rollback

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
	public Integer bajaProductoSA(Integer id) {
		Integer result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();
			DAOProducto daoProducto = FactoriaDAO.getInstance().getDAOProducto();
			TransferProducto producto=null;
			producto= daoProducto.consultarProductoDAO(id);
			//Si el producto existe y esta activo -->se da de baja
			if(producto !=null && producto.getActivo()) {
				result = daoProducto.bajaProductoDAO(id);
			}
			//Si el producto existe y no esta activo--> no se hace nada rollback
			//Si el producto no existe-->no se hace nada rollback
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
			DAOProducto daoProducto = FactoriaDAO.getInstance().getDAOProducto();
			TransferProducto producto = null;
			producto = daoProducto.consultarProductoDAO(datos.getID());
			// Si el producto existe y esta activo -->modifica
			if (producto != null && producto.getActivo()) {
				result = daoProducto.modificarProductoDAO(datos);
			}
			// Si el producto no existe->rollback
			// Si el producto existe y no esta activo (no se puede modificar)-->rollback

			if (result != null) {
				transaccion.commit();
			} else {
				transaccion.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();

			result = null;
		}
		transactionManager.eliminaTransaccion();
		return result;
	}

	
	@Override
	public TransferProducto consultarProductoSA(Integer id) {
		TransferProducto result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();
		try {
			transaccion.start();
			DAOProducto dao = FactoriaDAO.getInstance().getDAOProducto();
			result = dao.consultarProductoDAO(id);
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