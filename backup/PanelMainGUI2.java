package musicalia;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Negocio.Clientes.TransferCliente;
import Negocio.Productos.TransferProducto;
import Negocio.Ventas.TransferLineaVenta;
import Negocio.Ventas.TransferVenta;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.ApplicationController;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.SystemColor;



public class PanelMainGUI2 {
	private JFrame frameMusicalia;
	//cuadro de texto
	private JTextField textField_IdCliente;
	private JTextField textField_Dni;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido;
	private JTextField textField_Direccion;
	private JTextField textField_idProducto;
	private JTextField textField_nombreProducto;
	private JTextField textField_precioProducto;
	private JTextField textField_categoriaProducto;
	//private JTextField textField_idVenta;
	private JTextField textField_idClienteVenta;
	private JTextField textField_idProductoVenta;
	private JTextField textField_nombreProductoVenta;
	private JTextField textField_precioProductoVenta;
	private JCheckBox checkboxEsSocio;

	//cuadro de listas
	private JList<String> JListClientes;
	private JList<String> JListProductos; 
	private JList<String> JListLineaVentas; 
	private JList<String> JListVentas;

	//Botones
	private JButton botonAltaCliente;
	private JButton botonModificarCliente;
	private JButton botonBajaCliente;
	private JButton botonCargarCliente;
	private JButton botonAltaProducto ;
	private JButton botonModificarProducto;
	private JButton botonCargarProducto;
	private JButton botonBajaProducto;
	private JButton botonCargarProductoVenta;
	private JButton botonQuitarProductoVenta;
	private JButton botonAgregarProductoVenta;
	private JButton botonNuevaVenta;


	Map<Integer, TransferLineaVenta> lineaVentas = new HashMap<>();
	private JLabel lblListaDeClientes;
	private JLabel lblListaDeProductos;
	private JLabel lblCarritoDeCompra;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	/**
	 * Create the application.
	 */
	public PanelMainGUI2() {
		init();

		setClienteActionListeners();
		setProductoActionListeners();
		setVentaActionListeners();
	}

	private void setClienteActionListeners() {
		// TODO Auto-generated method stub
		botonAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferCliente nuevoCliente = new TransferCliente();
				nuevoCliente.setNombre(textField_Nombre.getText());
				nuevoCliente.setApellido(textField_Apellido.getText());
				nuevoCliente.setDNI(textField_Dni.getText());
				nuevoCliente.setDireccion(textField_Direccion.getText());
				nuevoCliente.setSocio(checkboxEsSocio.isSelected());
				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_ALTA_CLIENTE, nuevoCliente);
			}
		});

		botonModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer idCliente = null;
				try {
					idCliente = Integer.valueOf(textField_IdCliente.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de cliente invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				TransferCliente cliente = new TransferCliente();
				cliente.setID(idCliente);
				cliente.setNombre(textField_Nombre.getText());
				cliente.setApellido(textField_Apellido.getText());
				cliente.setDNI(textField_Dni.getText());
				cliente.setDireccion(textField_Direccion.getText());
				cliente.setSocio(checkboxEsSocio.isSelected());

				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_MODIFICAR_CLIENTE, cliente);
			}
		});

		botonBajaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer idCliente = null;
				try {
					idCliente = Integer.valueOf(textField_IdCliente.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de cliente invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_BAJA_CLIENTE, idCliente);
			}
		});

		botonCargarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Integer idCliente = null;
				try {
					idCliente = Integer.valueOf(textField_IdCliente.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de cliente invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_CONSULTAR_CLIENTE, idCliente);
			}

		});
	}




	private void setProductoActionListeners() {
		// TODO Auto-generated method stub

		botonAltaProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Float precio = null;
				try {
					precio = Float.valueOf(textField_precioProducto.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "Precio producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				TransferProducto nuevoProducto = new TransferProducto();
				//nuevoProducto.setID(Integer.valueOf(textField_idProducto.getText()));
				nuevoProducto.setNombre(textField_nombreProducto.getText());
				nuevoProducto.setCategoria(textField_categoriaProducto.getText());
				nuevoProducto.setPrecio(precio);

				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_ALTA_PRODUCTO, nuevoProducto);
			}
		});
		botonBajaProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idProducto = null;
				try {
					idProducto = Integer.valueOf(textField_idProducto.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_BAJA_PRODUCTO, idProducto);
			}
		});
		botonModificarProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idProducto = null;
				try {
					idProducto = Integer.valueOf(textField_idProducto.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				Float precio = null;
				try {
					precio = Float.valueOf(textField_precioProducto.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "Precio producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				TransferProducto producto = new TransferProducto();
				producto.setID(idProducto);
				producto.setNombre(textField_nombreProducto.getText());
				producto.setCategoria(textField_categoriaProducto.getText());
				producto.setPrecio(precio);

				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_MODIFICAR_PRODUCTO, producto);
			}
		});

		botonCargarProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idProducto = null;
				try {
					idProducto = Integer.valueOf(textField_idProducto.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_CONSULTAR_PRODUCTO, idProducto);
			}
		});


	}

	private void setVentaActionListeners() {
		// TODO Auto-generated method stub
		botonCargarProductoVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idProducto = null;
				try {
					idProducto = Integer.valueOf( textField_idProductoVenta.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_CONSULTAR_PRODUCTO_VENTA, idProducto);
			}
		});
		botonAgregarProductoVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idProducto = null;
				Float precio = null;
				
				Map<Integer, TransferLineaVenta> prueba= lineaVentas;
				
				
				try {
					idProducto = Integer.valueOf( textField_idProductoVenta.getText());
					precio = Float.valueOf( textField_precioProductoVenta.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "Producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				if (lineaVentas.containsKey(idProducto)) {
					TransferLineaVenta lineaVenta = lineaVentas.get(idProducto);
					Integer cantidad = lineaVenta.getCantidad();
					cantidad += 1;
					
					
					lineaVenta.setCantidad(cantidad);
					lineaVenta.setPrecio(precio * cantidad);

					actualizarLineasVentas();
				} else {
					TransferLineaVenta lineaVenta = new TransferLineaVenta();
					lineaVenta.setIdProducto(idProducto);
					lineaVenta.setPrecio(precio);
					lineaVenta.setCantidad(1);

					lineaVentas.put(idProducto, lineaVenta);

					actualizarLineasVentas();
				}
			}
		});

		botonQuitarProductoVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idProducto = null;
				Float precio = null;
				try {
					idProducto = Integer.valueOf( textField_idProductoVenta.getText());
					precio = Float.valueOf( textField_precioProductoVenta.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "Producto invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (lineaVentas.containsKey(idProducto)) {
					TransferLineaVenta lineaVenta = lineaVentas.get(idProducto);
					Integer cantidad = lineaVenta.getCantidad();

					cantidad -= 1;

					if (cantidad == 0) {
						lineaVentas.remove(idProducto);
					} else {
						lineaVenta.setCantidad(cantidad);
						lineaVenta.setPrecio(precio * cantidad);
					}

					actualizarLineasVentas();
				}
			}
		});

		botonNuevaVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idCliente = null;
				try {
					idCliente = Integer.valueOf( textField_idClienteVenta.getText());
				} catch (NumberFormatException ignored) {
					JOptionPane.showMessageDialog(null, "ID de cliente invalido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				TransferVenta transferVenta = new TransferVenta();
				transferVenta.setIDCliente(idCliente);

				List<TransferLineaVenta> productos = new ArrayList<>(lineaVentas.values());
				transferVenta.setLineaVentas(productos);

				ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_CERRAR_VENTA, transferVenta);
				/*lineaVentas.clear();
				actualizarLineasVentas();*/
			}
		});

	}

//lo escribe en el panel lista donde se muestra la linea de venta
	private void actualizarLineasVentas() {
		final List<TransferLineaVenta> productos = new ArrayList<>(lineaVentas.values());
		JListLineaVentas.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return productos.size();
			}

			public String getElementAt(int i) {
				return productos.get(i).toString();
			}
		});
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void init() {
		frameMusicalia = new JFrame();
		frameMusicalia.setVisible(true);
		frameMusicalia.setIconImage(Toolkit.getDefaultToolkit().getImage("piano.png"));
		frameMusicalia.setForeground(new Color(0, 204, 153));
		frameMusicalia.setTitle("Musicalia");
		frameMusicalia.setBackground(Color.WHITE);
		frameMusicalia.setBounds(100, 100, 833, 669);
		frameMusicalia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMusicalia.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 817, 630);
		frameMusicalia.getContentPane().add(tabbedPane);
		//Clientes
		JPanel panelClientes = new JPanel();
		panelClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelClientes.setBackground(SystemColor.control);
		tabbedPane.addTab("Clientes", null, panelClientes, null);
		panelClientes.setLayout(null);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setForeground(Color.BLACK);
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNombre.setToolTipText("");
		labelNombre.setBounds(38, 96, 69, 55);
		panelClientes.add(labelNombre);

		textField_IdCliente = new JTextField();
		textField_IdCliente.setBounds(144, 31, 165, 20);
		panelClientes.add(textField_IdCliente);
		textField_IdCliente.setColumns(10);

		JLabel labelApellido = new JLabel("Apellidos");
		labelApellido.setToolTipText("");
		labelApellido.setForeground(Color.BLACK);
		labelApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelApellido.setBounds(38, 144, 85, 55);
		panelClientes.add(labelApellido);

		JLabel labelId = new JLabel("ID");
		labelId.setBackground(Color.LIGHT_GRAY);
		labelId.setToolTipText("");
		labelId.setForeground(Color.BLACK);
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelId.setBounds(40, 11, 69, 55);
		panelClientes.add(labelId);

		JLabel labelDni = new JLabel("DNI");
		labelDni.setToolTipText("");
		labelDni.setForeground(Color.BLACK);
		labelDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDni.setBounds(38, 53, 69, 55);
		panelClientes.add(labelDni);

		JLabel labelDireccion = new JLabel("Direccion");
		labelDireccion.setToolTipText("");
		labelDireccion.setForeground(Color.BLACK);
		labelDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDireccion.setBounds(38, 195, 110, 55);
		panelClientes.add(labelDireccion);

		textField_Dni = new JTextField();
		textField_Dni.setColumns(10);
		textField_Dni.setBounds(144, 73, 165, 20);
		panelClientes.add(textField_Dni);

		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(144, 116, 165, 20);
		panelClientes.add(textField_Nombre);

		textField_Apellido = new JTextField();
		textField_Apellido.setColumns(10);
		textField_Apellido.setBounds(144, 164, 165, 20);
		panelClientes.add(textField_Apellido);

		textField_Direccion = new JTextField();
		textField_Direccion.setColumns(10);
		textField_Direccion.setBounds(144, 215, 165, 20);
		panelClientes.add(textField_Direccion);

		checkboxEsSocio = new JCheckBox("es Socio");
		checkboxEsSocio.setBounds(509, 226, 97, 23);
		panelClientes.add(checkboxEsSocio);

		botonAltaCliente = new JButton("Alta cliente");
		botonAltaCliente.setBounds(398, 53, 133, 39);
		panelClientes.add(botonAltaCliente);

		botonModificarCliente = new JButton("Modificar Cliente");
		botonModificarCliente.setBounds(582, 53, 133, 39);
		panelClientes.add(botonModificarCliente);

		botonBajaCliente = new JButton("Baja cliente");
		botonBajaCliente.setBounds(398, 144, 133, 39);
		panelClientes.add(botonBajaCliente);

		botonCargarCliente = new JButton("Cargar Cliente");		
		botonCargarCliente.setBounds(582, 144, 133, 39);
		panelClientes.add(botonCargarCliente);
		
				scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(38, 340, 271, 171);
				panelClientes.add(scrollPane_2);
				
						JListClientes = new JList<>();
						scrollPane_2.setViewportView(JListClientes);
						
								JLabel labelClientes = new JLabel("");
								scrollPane_2.setColumnHeaderView(labelClientes);
								labelClientes.setIcon(new ImageIcon("p.jpg"));
								labelClientes.setForeground(Color.DARK_GRAY);

		lblListaDeClientes = new JLabel("Lista de Clientes");
		lblListaDeClientes.setToolTipText("");
		lblListaDeClientes.setForeground(Color.BLACK);
		lblListaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeClientes.setBounds(38, 281, 185, 46);
		panelClientes.add(lblListaDeClientes);
		tabbedPane.setBackgroundAt(0, Color.WHITE);

		//Productos
		JPanel panelProductos = new JPanel();
		panelProductos.setToolTipText("");
		panelProductos.setBackground(SystemColor.control);
		tabbedPane.addTab("Productos", null, panelProductos, "");
		tabbedPane.setForegroundAt(1, Color.BLACK);
		panelProductos.setLayout(null);

		JLabel labelPrecio = new JLabel("Precio");
		labelPrecio.setToolTipText("");
		labelPrecio.setForeground(Color.BLACK);
		labelPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPrecio.setBounds(40, 96, 69, 55);
		panelProductos.add(labelPrecio);

		textField_idProducto = new JTextField();
		textField_idProducto.setColumns(10);
		textField_idProducto.setBounds(144, 31, 165, 20);
		panelProductos.add(textField_idProducto);



		JLabel labelCategoria = new JLabel("Categoria");
		labelCategoria.setToolTipText("");
		labelCategoria.setForeground(Color.BLACK);
		labelCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCategoria.setBounds(40, 144, 85, 55);
		panelProductos.add(labelCategoria);

		JLabel label_idProducto = new JLabel("ID");
		label_idProducto.setToolTipText("");
		label_idProducto.setForeground(Color.BLACK);
		label_idProducto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_idProducto.setBounds(40, 11, 69, 55);
		panelProductos.add(label_idProducto);

		JLabel labelNombreProducto = new JLabel("Nombre");
		labelNombreProducto.setToolTipText("");
		labelNombreProducto.setForeground(Color.BLACK);
		labelNombreProducto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNombreProducto.setBounds(40, 53, 69, 55);
		panelProductos.add(labelNombreProducto);

		textField_nombreProducto = new JTextField();
		textField_nombreProducto.setColumns(10);
		textField_nombreProducto.setBounds(144, 73, 165, 20);
		panelProductos.add(textField_nombreProducto);

		textField_precioProducto = new JTextField();
		textField_precioProducto.setColumns(10);
		textField_precioProducto.setBounds(144, 116, 165, 20);
		panelProductos.add(textField_precioProducto);

		textField_categoriaProducto = new JTextField();
		textField_categoriaProducto.setColumns(10);
		textField_categoriaProducto.setBounds(144, 164, 165, 20);
		panelProductos.add(textField_categoriaProducto);

		botonAltaProducto = new JButton("Alta Producto");
		botonAltaProducto.setBounds(398, 53, 133, 39);
		panelProductos.add(botonAltaProducto);

		botonModificarProducto = new JButton("Modificar Producto");
		botonModificarProducto.setBounds(582, 53, 156, 39);
		panelProductos.add(botonModificarProducto);

		botonBajaProducto = new JButton("Baja Producto");
		botonBajaProducto.setBounds(398, 177, 133, 39);
		panelProductos.add(botonBajaProducto);

		botonCargarProducto = new JButton("Cargar Producto");
		botonCargarProducto.setBounds(582, 177, 133, 39);
		panelProductos.add(botonCargarProducto);

		lblListaDeProductos = new JLabel("Lista de Productos");
		lblListaDeProductos.setToolTipText("");
		lblListaDeProductos.setForeground(Color.BLACK);
		lblListaDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeProductos.setBounds(40, 261, 174, 39);
		panelProductos.add(lblListaDeProductos);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(40, 329, 269, 192);
		panelProductos.add(scrollPane_3);

		JListProductos = new JList<>();
		scrollPane_3.setViewportView(JListProductos);

		JLabel labelProductos = new JLabel("");
		labelProductos.setIcon(new ImageIcon("p.jpg"));
		labelProductos.setBounds(0, 0, 812, 602);
		panelProductos.add(labelProductos);

		//Ventas
		JPanel panelVentas = new JPanel();
		panelVentas.setBackground(SystemColor.control);
		tabbedPane.addTab("Ventas", null, panelVentas, null);
		panelVentas.setLayout(null);

		JLabel lblIdproductoVentas = new JLabel("IDProducto");
		lblIdproductoVentas.setToolTipText("");
		lblIdproductoVentas.setForeground(Color.BLACK);
		lblIdproductoVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdproductoVentas.setBounds(40, 57, 110, 55);
		panelVentas.add(lblIdproductoVentas);

		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setToolTipText("");
		lblNombre_2.setForeground(Color.BLACK);
		lblNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre_2.setBounds(40, 105, 85, 55);
		panelVentas.add(lblNombre_2);


		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setToolTipText("");
		lblPrecio_1.setForeground(Color.BLACK);
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio_1.setBounds(40, 154, 110, 55);
		panelVentas.add(lblPrecio_1);

		JLabel labelIdclienteVentas = new JLabel("IDCliente");
		labelIdclienteVentas.setToolTipText("");
		labelIdclienteVentas.setForeground(Color.BLACK);
		labelIdclienteVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelIdclienteVentas.setBounds(40, 201, 96, 55);
		panelVentas.add(labelIdclienteVentas);

		textField_idProductoVenta = new JTextField();
		textField_idProductoVenta.setColumns(10);
		textField_idProductoVenta.setBounds(146, 77, 165, 20);
		panelVentas.add(textField_idProductoVenta);

		textField_nombreProductoVenta = new JTextField();
		textField_nombreProductoVenta.setColumns(10);
		textField_nombreProductoVenta.setBounds(146, 123, 165, 20);
		panelVentas.add(textField_nombreProductoVenta);

		textField_precioProductoVenta = new JTextField();
		textField_precioProductoVenta.setColumns(10);
		textField_precioProductoVenta.setBounds(146, 174, 165, 20);
		panelVentas.add(textField_precioProductoVenta);

		textField_idClienteVenta = new JTextField();
		textField_idClienteVenta.setColumns(10);
		textField_idClienteVenta.setBounds(146, 220, 165, 20);
		panelVentas.add(textField_idClienteVenta);

		botonCargarProductoVenta = new JButton("Cargar Producto");
		botonCargarProductoVenta.setBounds(409, 66, 133, 39);
		panelVentas.add(botonCargarProductoVenta);

		botonAgregarProductoVenta = new JButton("Agregar Producto");
		botonAgregarProductoVenta.setBounds(593, 66, 149, 39);
		panelVentas.add(botonAgregarProductoVenta);

		botonQuitarProductoVenta = new JButton("Quitar Producto");
		botonQuitarProductoVenta.setBounds(409, 123, 133, 39);
		panelVentas.add(botonQuitarProductoVenta);

		botonNuevaVenta = new JButton("Nueva Venta");
		botonNuevaVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonNuevaVenta.setBounds(593, 123, 149, 39);
		panelVentas.add(botonNuevaVenta);

		lblCarritoDeCompra = new JLabel("Carrito de Compra");
		lblCarritoDeCompra.setToolTipText("");
		lblCarritoDeCompra.setForeground(Color.BLACK);
		lblCarritoDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCarritoDeCompra.setBounds(40, 288, 174, 39);
		panelVentas.add(lblCarritoDeCompra);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(409, 328, 316, 181);
		panelVentas.add(scrollPane);

		JListVentas = new JList();
		scrollPane.setViewportView(JListVentas);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 340, 271, 169);
		panelVentas.add(scrollPane_1);

		JListLineaVentas = new JList();
		scrollPane_1.setViewportView(JListLineaVentas);



		JListLineaVentas.setModel(new AbstractListModel<String>() {
			public int getSize() { return 0; }
			public String getElementAt(int i) { return null; }
		});
		
		JLabel lblListaDeVentas = new JLabel("Lista de Ventas");
		lblListaDeVentas.setToolTipText("");
		lblListaDeVentas.setForeground(Color.BLACK);
		lblListaDeVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeVentas.setBounds(405, 282, 174, 39);
		panelVentas.add(lblListaDeVentas);

		JLabel lblVentas = new JLabel("");
		lblVentas.setIcon(new ImageIcon("p.jpg"));
		lblVentas.setBounds(0, 0, 812, 602);
		panelVentas.add(lblVentas);
	}



	public void actualizar(IDEvento evento, Object datos) {
		switch (evento) {
		case EVENTO_MAIN:
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_CLIENTES, null);
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_PRODUCTOS, null);
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_VENTAS, null);
			break;

		case EVENTO_MODIFICAR_CLIENTE:
			// Actualizar id de cliente
			//textField_IdCliente.setText(datos.toString());
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_CLIENTES, null);
			break;	
		case EVENTO_ALTA_CLIENTE:
			// Actualizar id de cliente
			textField_IdCliente.setText(datos.toString());
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_CLIENTES, null);
			break;
		case EVENTO_BAJA_CLIENTE:
			textField_IdCliente.setText(null);
			textField_Nombre.setText(null);
			textField_Apellido.setText(null);
			textField_Dni.setText(null);
			textField_Direccion.setText(null);
			checkboxEsSocio.setSelected(false);
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_CLIENTES, null);
			break;
		case EVENTO_CONSULTAR_CLIENTE:
			TransferCliente cliente = (TransferCliente) datos;

			textField_IdCliente.setText(cliente.getID().toString());
			textField_Nombre.setText(cliente.getNombre());
			textField_Apellido.setText(cliente.getApellido());
			textField_Dni.setText(cliente.getDNI());
			textField_Direccion.setText(cliente.getDireccion());
			checkboxEsSocio.setSelected(cliente.getSocio());

			break;
		case EVENTO_LISTAR_CLIENTES:
			final List<TransferCliente> clientes = (List<TransferCliente>) datos;
			JListClientes.setModel(new AbstractListModel<String>() {
				public int getSize() {
					return clientes.size();
				}

				public String getElementAt(int i) {
					return clientes.get(i).toString();
				}
			});
			break;
		case EVENTO_ALTA_PRODUCTO:
			// Actualizar id de producto
			textField_idProducto.setText(datos.toString());
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_PRODUCTOS, null);
			break;
		case EVENTO_BAJA_PRODUCTO:
			textField_idProducto.setText(null);
			textField_nombreProducto.setText(null);
			textField_categoriaProducto.setText(null);
			textField_precioProducto.setText(null);
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_PRODUCTOS, null);
			break;

		case EVENTO_MODIFICAR_PRODUCTO:
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_PRODUCTOS, null);
			break;
		case EVENTO_CONSULTAR_PRODUCTO: {
			TransferProducto producto = (TransferProducto) datos;

			textField_idProducto.setText(producto.getID().toString());
			textField_nombreProducto.setText(producto.getNombre());
			textField_categoriaProducto.setText(producto.getCategoria());
			textField_precioProducto.setText(producto.getPrecio().toString());
		}
		break;
		case EVENTO_LISTAR_PRODUCTOS:
			@SuppressWarnings("unchecked") final List<TransferProducto> productos = (List<TransferProducto>) datos;
			JListProductos.setModel(new AbstractListModel<String>() {
				public int getSize() {
					return productos.size();
				}

				public String getElementAt(int i) {
					return productos.get(i).toString();
				}
			});
			break;
		case EVENTO_LISTAR_VENTAS:
			@SuppressWarnings("unchecked") final List<TransferVenta> ventas = (List<TransferVenta>) datos;
			JListVentas.setModel(new AbstractListModel<String>() {
				public int getSize() {
					return ventas.size();
				}
				public String getElementAt(int i) {
					return ventas.get(i).toString();
				}
			});
			break;
		case EVENTO_CONSULTAR_PRODUCTO_VENTA: {
			TransferProducto producto = (TransferProducto) datos;

			textField_nombreProductoVenta.setText(producto.getNombre());
			textField_precioProductoVenta.setText(producto.getPrecio().toString());

			botonAgregarProductoVenta.setEnabled(true);
			botonQuitarProductoVenta.setEnabled(true);
		}
		break;
		case EVENTO_CERRAR_VENTA:
			ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_LISTAR_VENTAS, null);
			break;
		}
	}
}
