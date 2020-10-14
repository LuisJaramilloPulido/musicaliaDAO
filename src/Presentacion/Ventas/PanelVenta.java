/**
 * 
 */
package Presentacion.Ventas;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Negocio.Productos.TransferProducto;
import Integracion.Query.TransferQuery;
import Negocio.Ventas.LineaVenta;
import Negocio.Ventas.TransferTOA;
import Negocio.Ventas.TransferVenta;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.ApplicationController;

public class PanelVenta extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_idClienteVenta;
	private JTextField textField_idProductoVenta;
	private JTextField textField_nombreProductoVenta;
	private JTextField textField_precioProductoVenta;
	private JTextField textField_idVenta;
	private JList<String> JListLineaVentas;
	private JList<String> JListVentas;
	private JButton btnCargarProductoVenta;
	private JButton btnQuitarProductoVenta;
	private JButton btnAgregarProductoVenta;
	private JButton btnCerrarVenta;
	private JButton btnMostrarClienteVenta;
	private JButton btnQuery;
	Map<Integer, LineaVenta> mapa = new HashMap<>();
	private JLabel lblCarritoDeCompra;
	private JScrollPane scrollPane_1;
	
	
	

	public PanelVenta() {
		initGUI();
		setVentaActionListeners();

	}

	public void initGUI() {
		this.setBackground(SystemColor.control);
		this.setLayout(null);

		JLabel lblIdproductoVentas = new JLabel("IDProducto");
		lblIdproductoVentas.setToolTipText("");
		lblIdproductoVentas.setForeground(Color.BLACK);
		lblIdproductoVentas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdproductoVentas.setBounds(40, 57, 110, 55);
		this.add(lblIdproductoVentas);

		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setToolTipText("");
		lblNombre_2.setForeground(Color.BLACK);
		lblNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre_2.setBounds(40, 92, 85, 55);
		this.add(lblNombre_2);

		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setToolTipText("");
		lblPrecio_1.setForeground(Color.BLACK);
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio_1.setBounds(40, 125, 110, 55);
		this.add(lblPrecio_1);

		JLabel labelIdclienteVentas = new JLabel("IDCliente");
		labelIdclienteVentas.setToolTipText("");
		labelIdclienteVentas.setForeground(Color.BLACK);
		labelIdclienteVentas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelIdclienteVentas.setBounds(40, 160, 96, 55);
		this.add(labelIdclienteVentas);
		
		JLabel lblIdventa = new JLabel("IDVenta");
		lblIdventa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdventa.setBounds(40, 212, 56, 16);
		add(lblIdventa);

		textField_idProductoVenta = new JTextField();
		textField_idProductoVenta.setColumns(10);
		textField_idProductoVenta.setBounds(146, 74, 165, 20);
		this.add(textField_idProductoVenta);

		textField_nombreProductoVenta = new JTextField();
		textField_nombreProductoVenta.setColumns(10);
		textField_nombreProductoVenta.setBounds(146, 109, 165, 20);
		this.add(textField_nombreProductoVenta);

		textField_precioProductoVenta = new JTextField();
		textField_precioProductoVenta.setColumns(10);
		textField_precioProductoVenta.setBounds(146, 142, 165, 20);
		this.add(textField_precioProductoVenta);

		textField_idClienteVenta = new JTextField();
		textField_idClienteVenta.setColumns(10);
		textField_idClienteVenta.setBounds(148, 177, 165, 20);
		this.add(textField_idClienteVenta);
		
		textField_idVenta = new JTextField();
		textField_idVenta.setBounds(148, 209, 163, 22);
		add(textField_idVenta);
		textField_idVenta.setColumns(10);

		btnCargarProductoVenta = new JButton("Cargar Producto");
		btnCargarProductoVenta.setBounds(409, 66, 133, 39);
		this.add(btnCargarProductoVenta);

		btnAgregarProductoVenta = new JButton("Agregar Producto");
		btnAgregarProductoVenta.setBounds(593, 66, 149, 39);
		this.add(btnAgregarProductoVenta);

		btnQuitarProductoVenta = new JButton("Quitar Producto");
		btnQuitarProductoVenta.setBounds(409, 123, 133, 39);
		this.add(btnQuitarProductoVenta);

		btnCerrarVenta = new JButton("Cerrar Venta");
		btnCerrarVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCerrarVenta.setBounds(593, 123, 149, 39);
		this.add(btnCerrarVenta);
		
		btnMostrarClienteVenta = new JButton("mostrar ClienteVenta");
		btnMostrarClienteVenta.setBounds(409, 176, 165, 39);
		add(btnMostrarClienteVenta);
		
		btnQuery = new JButton("query");
		btnQuery.setBounds(593, 175, 149, 40);
		add(btnQuery);

		lblCarritoDeCompra = new JLabel("Carrito de Compra");
		lblCarritoDeCompra.setToolTipText("");
		lblCarritoDeCompra.setForeground(Color.BLACK);
		lblCarritoDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarritoDeCompra.setBounds(40, 288, 174, 39);
		this.add(lblCarritoDeCompra);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(409, 328, 316, 181);
		this.add(scrollPane);

		JListVentas = new JList();
		scrollPane.setViewportView(JListVentas);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 340, 271, 169);
		this.add(scrollPane_1);

		JListLineaVentas = new JList();
		scrollPane_1.setViewportView(JListLineaVentas);

		JListLineaVentas.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return 0;
			}

			public String getElementAt(int i) {
				return null;
			}
		});

		JLabel lblListaDeVentas = new JLabel("Lista de Ventas");
		lblListaDeVentas.setToolTipText("");
		lblListaDeVentas.setForeground(Color.BLACK);
		lblListaDeVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeVentas.setBounds(405, 282, 174, 39);
		this.add(lblListaDeVentas);

		JLabel lblVentas = new JLabel("");
		lblVentas.setIcon(new ImageIcon("p.jpg"));
		lblVentas.setBounds(0, 0, 812, 602);
		this.add(lblVentas);
	}

	private void setVentaActionListeners() {
		// TODO Auto-generated method stub
		btnCargarProductoVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idProducto = null;
				try {
					idProducto = Integer.valueOf(textField_idProductoVenta.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_CONSULTAR_PRODUCTO_VENTA, idProducto);
			}
		});
		btnAgregarProductoVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idProducto = null;
				Float precio = null;

				try {
					idProducto = Integer.valueOf(textField_idProductoVenta.getText());
					precio = Float.valueOf(textField_precioProductoVenta.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "Producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (mapa.containsKey(idProducto)) {
					LineaVenta lineaVenta = mapa.get(idProducto);
					Integer cantidad = lineaVenta.getCantidad();
					cantidad += 1;

					lineaVenta.setCantidad(cantidad);
					lineaVenta.setPrecio(precio * cantidad);

					actualizarLineasVentas();
				} else {
					LineaVenta lineaVenta = new LineaVenta();
					lineaVenta.setIdProducto(idProducto);
					lineaVenta.setPrecio(precio);
					lineaVenta.setCantidad(1);

					mapa.put(idProducto, lineaVenta);

					actualizarLineasVentas();
				}
			}
		});

		btnQuitarProductoVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idProducto = null;
				Float precio = null;
				try {
					idProducto = Integer.valueOf(textField_idProductoVenta.getText());
					precio = Float.valueOf(textField_precioProductoVenta.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "Producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (mapa.containsKey(idProducto)) {
					LineaVenta lineaVenta = mapa.get(idProducto);
					Integer cantidad = lineaVenta.getCantidad();

					cantidad -= 1;

					if (cantidad == 0) {
						mapa.remove(idProducto);
					} else {
						lineaVenta.setCantidad(cantidad);
						lineaVenta.setPrecio(precio * cantidad);
					}

					actualizarLineasVentas();
				}
			}
		});

		btnCerrarVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idCliente = null;
				try {
					idCliente = Integer.valueOf(textField_idClienteVenta.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de cliente invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				float precioTotal = 0;
			
				List<LineaVenta> carrito = new ArrayList<>(mapa.values());
				/*
				for(LineaVenta p: carrito) {
					precioTotal = precioTotal + p.getPrecio();
				}*/
				TransferVenta transferVenta = new TransferVenta(idCliente,precioTotal,carrito);
				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_CERRAR_VENTA, transferVenta);
				
			}
		});
		
		btnMostrarClienteVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Integer idVenta = Integer.valueOf(textField_idVenta.getText());
					if (idVenta < 0)
						throw new Exception();
					// TOAVentaCliente tToa = new TOAVentaCliente(idVenta);
					ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_MOSTRAR_CLIENTE_VENTA, idVenta);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "id de venta no existe", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		
		btnQuery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Integer idVenta = Integer.valueOf(textField_idVenta.getText());
					float precio= Float.valueOf(textField_precioProductoVenta.getText());
					if (idVenta < 0 || precio <0)
						throw new Exception();
					TransferQuery tQuery= new TransferQuery(idVenta,precio);
					ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_QUERY, tQuery);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "argumentos no validos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		

	}

	// lo escribe en el panel lista donde se muestra la linea de venta
	private void actualizarLineasVentas() {
		final List<LineaVenta> productos = new ArrayList<>(mapa.values());
		JListLineaVentas.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return productos.size();
			}

			public String getElementAt(int i) {
				return productos.get(i).toString();
			}
		});
	}
	
	
	void consultarProductoVenta(TransferProducto producto) {
		
		textField_nombreProductoVenta.setText(producto.getNombre());
		textField_precioProductoVenta.setText(producto.getPrecio().toString());
		btnAgregarProductoVenta.setEnabled(true);
		btnQuitarProductoVenta.setEnabled(true);
	}
	
	void listarVentas( List<TransferVenta> ventas) {
		
		JListVentas.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return ventas.size();
			}

			public String getElementAt(int i) {
				return ventas.get(i).toString();
			}
		});
	}

	public void mostrarClienteVenta(TransferTOA toaVentaCliente) {
		// TODO Auto-generated method stub
		
		JListVentas.setModel(new AbstractListModel<String>() {
			
			public int getSize() {
				return 1;
			}

			public String getElementAt(int i) {
				return toaVentaCliente.toString();
			}
		});
		
		
	}
	
void mostrarQuery( List<TransferProducto> productos) {
		
		JListVentas.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return productos.size();
			}

			public String getElementAt(int i) {
				return productos.get(i).toString();
			}
		});
	}
	
	
}