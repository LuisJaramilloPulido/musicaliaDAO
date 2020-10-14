/**
 * 
 */
package Presentacion.Ventas;

import java.util.List;
import Negocio.Productos.TransferProducto;
import Negocio.Ventas.TransferTOA;
import Negocio.Ventas.TransferVenta;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.ApplicationController;

public class VentasGUI {

	private PanelVenta panelVenta;

	public VentasGUI() {
		this.panelVenta = new PanelVenta();
	}

	public PanelVenta getPanelVentasGUI() {
		return panelVenta;
	}

	public void setPanelVentasGUI(PanelVenta panelVentasGUI) {

		this.panelVenta = panelVentasGUI;

	}

	public void actualizar(IDEvento evento, Object datos) {
		switch (evento) {

		case EVENTO_LISTAR_VENTAS:
			@SuppressWarnings("unchecked")
			final List<TransferVenta> ventas = (List<TransferVenta>) datos;
			panelVenta.listarVentas(ventas);
			break;
		case EVENTO_CONSULTAR_PRODUCTO_VENTA: {
			TransferProducto producto = (TransferProducto) datos;
			panelVenta.consultarProductoVenta(producto);
		}
			break;
		case EVENTO_CERRAR_VENTA:
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_VENTAS, null);
			break;
		case EVENTO_MOSTRAR_CLIENTE_VENTA:

			TransferTOA toaVentaCliente = (TransferTOA) datos;
			panelVenta.mostrarClienteVenta(toaVentaCliente);
			break;

		case EVENTO_QUERY:

			//TOAVentaCliente toaVentaCliente = (TOAVentaCliente) datos;
			final List<TransferProducto> productos = (List<TransferProducto>) datos;
			panelVenta.mostrarQuery(productos);
			break;
		default:
			break;
		}

	}
}