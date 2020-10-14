/**
 * 
 */
package Presentacion.Productos;

import java.util.List;

import Negocio.Productos.TransferProducto;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.ApplicationController;

public class ProductoGUI {

	private PanelProducto panelProducto;

	public ProductoGUI() {
		this.panelProducto = new PanelProducto();
	}

	public PanelProducto getPanelProducto() {
		return this.panelProducto;
	}

	public void setPanelProducto(PanelProducto panelProducto) {
		this.panelProducto = panelProducto;
	}

	public void actualizar(IDEvento evento, Object datos) {
		switch (evento) {
		case EVENTO_ALTA_PRODUCTO:
			// Actualizar id de producto
			panelProducto.altaProducto(datos);
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_PRODUCTOS, null);
			break;
		case EVENTO_BAJA_PRODUCTO:
			panelProducto.bajaProducto();
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_PRODUCTOS, null);
			break;

		case EVENTO_MODIFICAR_PRODUCTO:
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_PRODUCTOS, null);
			break;
		case EVENTO_CONSULTAR_PRODUCTO: {
			TransferProducto producto = (TransferProducto) datos;
			panelProducto.consultarProducto(producto);
		}
			break;
		case EVENTO_LISTAR_PRODUCTOS:
			@SuppressWarnings("unchecked")
			final List<TransferProducto> productos = (List<TransferProducto>) datos;
			panelProducto.listarProducto(productos);
			break;
		default:
			break;
		}
	}
}