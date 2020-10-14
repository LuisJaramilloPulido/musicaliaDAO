package Negocio.Ventas;
import Integracion.Clientes.DAOCliente;
import Integracion.FactoriaDAO.FactoriaDAO;
import Integracion.FactoriaQuery.FactoriaQuery;
import Integracion.Productos.DAOProducto;
import Integracion.Query.QueryVenta;
import Integracion.Query.TransferQuery;
import Integracion.Transaccion.TManager.TManager;
import Integracion.Transaccion.Transaccion;
import Integracion.Ventas.DAOVenta;
import Negocio.Clientes.TransferCliente;
import Negocio.Productos.TransferProducto;



import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class SAVentaImp implements SAVenta {
	
	@Override
	public Integer crearVentaSA(TransferVenta tVenta) {
		Integer result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();
		boolean continuar=true;
		try {
			transaccion.start();
			// obtengo los metodos de integracion DAOVenta
			DAOVenta daoVenta = FactoriaDAO.getInstance().getDAOVenta();
			// obtengo el transferCliente
			DAOCliente daoCliente = FactoriaDAO.getInstance().getDAOCliente();
			DAOProducto daoProducto = FactoriaDAO.getInstance().getDAOProducto();
			TransferCliente tCliente = daoCliente.consultarClienteDAO(tVenta.getIDCliente());
			Collection<LineaVenta> carrito = tVenta.getCarrito();
			// Compruebo que el cliente existe y esta activo
			if (tCliente != null && tCliente.getActivo()) {
				Iterator<LineaVenta> itCarrito = carrito.iterator();
				while (itCarrito.hasNext() && continuar) {
					LineaVenta lineaVenta = itCarrito.next();
					int idProducto = lineaVenta.getIdProducto();
					int cantidad = lineaVenta.getCantidad();// cantidad del producto en el carrito
					// Obtengo el transferProducto
					TransferProducto tProducto = daoProducto.consultarProductoDAO(idProducto);
					if (tProducto != null && tProducto.getActivo()) {
						// obtenemos el stock
						int stock = tProducto.getStock();
						//lineaVenta.setPrecio(tProducto.getPrecio());
						if (stock > 0) {
							if (cantidad <= stock) {
								tProducto.setStock(stock - cantidad);
								daoProducto.modificarProductoDAO(tProducto);
								double precioActualDeLaVenta = tVenta.getPrecioTotal();
								tVenta.setPrecioTotal((float) (precioActualDeLaVenta + tProducto.getPrecio() * cantidad));
							}
							else {
								continuar=false;
							}
						}
						else
							continuar=false;
					}
					else
						continuar=false;
				}
				if(continuar) {
					result = daoVenta.crearVentaDAO(tVenta);
				}
			
				if (result != null) {
					transaccion.commit();
				} 
				else {
					transaccion.rollback();
				}
			}
		} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();

			result = null;
		}
		transactionManager.eliminaTransaccion();
		return result;
	}

	@Override
	public TransferTOA EnsambladorObjetosTransfererencia(Integer idVenta) {
		// TODO Auto-generated method stub
		TransferTOA result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();
		try {
			transaccion.start();
			DAOVenta daoVenta = FactoriaDAO.getInstance().getDAOVenta();
			TransferVenta tVenta = daoVenta.consultarVentaDAO(idVenta);
			//Compruebo que la venta exista
			if (tVenta!=null) {
				DAOCliente daoCliente = FactoriaDAO.getInstance().getDAOCliente();
				//Si la venta existe, entonces el cliente existe y no hace falta aplicar la regla de negocio
				TransferCliente tCliente = daoCliente.consultarClienteDAO(tVenta.getIDCliente());
				result= new TransferTOA(tVenta,tCliente);
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
	public List<TransferProducto> mostrarProductosEnVentaMayoresPrecioSA(TransferQuery tQuery) {
		List<TransferProducto> result = null;
		TManager transactionManager = TManager.getInstance();
		Transaccion transaccion = transactionManager.nuevaTransaccion();

		try {
			transaccion.start();
			DAOVenta daoVenta = FactoriaDAO.getInstance().getDAOVenta();
			TransferVenta tVenta = daoVenta.consultarVentaDAO(tQuery.getIdVenta());
			//Comprobar que venta existe
			if(tVenta !=null) {
				QueryVenta query = FactoriaQuery.getInstance().getQueryVenta();
				result = query.execute(tQuery);
			}
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

	
	
}