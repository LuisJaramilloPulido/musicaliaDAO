
package Presentacion.Clientes;

import java.util.List;

import Negocio.Clientes.TransferCliente;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.ApplicationController;

public class ClienteGUI {

	private PanelCliente panelCliente;

	public ClienteGUI() {
		this.panelCliente = new PanelCliente();
	}

	public PanelCliente getPanelCliente() {
		// begin-user-code
		return panelCliente;
		// end-user-code
	}

	public void setPanelCliente(PanelCliente panelCliente) {
		// begin-user-code
		this.panelCliente = panelCliente;
		// end-user-code
	}

	public void actualizar(IDEvento evento, Object datos) {
		switch (evento) {
		case EVENTO_MODIFICAR_CLIENTE:
			// Actualizar id de cliente
			// textField_IdCliente.setText(datos.toString());
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_CLIENTES, null);
			break;
		case EVENTO_ALTA_CLIENTE:
			// Actualizar id de cliente
			panelCliente.altaCliente(datos);
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_CLIENTES, null);
			break;
		case EVENTO_BAJA_CLIENTE:
			panelCliente.bajaCliente();
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_CLIENTES, null);
			break;
		case EVENTO_CONSULTAR_CLIENTE:
			TransferCliente cliente = (TransferCliente) datos;
			panelCliente.consultarCliente(cliente);
			break;
		case EVENTO_LISTAR_CLIENTES:
			final List<TransferCliente> clientes = (List<TransferCliente>) datos;
			panelCliente.listarclientes(clientes);
			break;
		}

	}
}