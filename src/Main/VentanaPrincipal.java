package Main;

import java.awt.Color;
import Presentacion.Clientes.ClienteGUI;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.ApplicationController;
import Presentacion.Productos.ProductoGUI;
import Presentacion.Ventas.VentasGUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;




public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private ClienteGUI clienteGUI;
	private ProductoGUI productoGUI;
	private VentasGUI ventasGUI;

	public VentanaPrincipal() {
		init();
	}

	private void init() {
		this.setForeground(new Color(0, 204, 153));
		this.setTitle("Proyecto Individual");
		this.setBackground(Color.WHITE);
		this.setBounds(100, 100, 833, 669);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 817, 630);
		this.getContentPane().add(tabbedPane);
		
		//Clientes
		clienteGUI = new ClienteGUI();
		JPanel panelClientes = clienteGUI.getPanelCliente();
		tabbedPane.addTab("Clientes", null, panelClientes, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);

		//Productos
		productoGUI = new ProductoGUI();
		JPanel panelProductos = productoGUI.getPanelProducto();
		tabbedPane.addTab("Productos", null, panelProductos, "");
		tabbedPane.setForegroundAt(1, Color.BLACK);
		
		//Ventas
		ventasGUI = new VentasGUI();
		JPanel panelVentas = ventasGUI.getPanelVentasGUI();
		tabbedPane.addTab("Ventas", null, panelVentas, null);

	}

	public void actualizar(IDEvento evento, Object datos) {
		switch (evento) {
		case EVENTO_MAIN:
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_CLIENTES, null);
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_PRODUCTOS, null);
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_VENTAS, null);
			break;
		
		case EVENTO_MODIFICAR_CLIENTE:
		case EVENTO_ALTA_CLIENTE:
		case EVENTO_BAJA_CLIENTE:
		case EVENTO_CONSULTAR_CLIENTE:
		case EVENTO_LISTAR_CLIENTES:
			clienteGUI.actualizar(evento, datos);
			break;
		
		case EVENTO_ALTA_PRODUCTO:
		case EVENTO_BAJA_PRODUCTO:
		case EVENTO_MODIFICAR_PRODUCTO:
		case EVENTO_CONSULTAR_PRODUCTO:
		case EVENTO_LISTAR_PRODUCTOS:
			productoGUI.actualizar(evento, datos);
			break;
		case EVENTO_LISTAR_VENTAS:
		case EVENTO_CONSULTAR_PRODUCTO_VENTA:
		case EVENTO_CERRAR_VENTA:
		case EVENTO_MOSTRAR_CLIENTE_VENTA:
		case EVENTO_QUERY:
			ventasGUI.actualizar(evento, datos);
			break;
		default:
			break;
		
		}
	}
}
