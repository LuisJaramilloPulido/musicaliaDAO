/**
 *
 */
package Presentacion.Productos;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import Negocio.Productos.TransferProducto;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.ApplicationController;

public class PanelProducto extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField_idProducto;
	private JTextField textField_nombreProducto;
	private JTextField textField_precioProducto;
	private JTextField textField_categoriaProducto;
	private JList<String> JListProductos;
	private JButton botonAltaProducto;
	private JButton botonModificarProducto;
	private JButton botonCargarProducto;
	private JButton botonBajaProducto;
	private JLabel lblListaDeProductos;
	private JScrollPane scrollPaneProducto;
	private JTextField textFieldStock;

	public PanelProducto() {

		initGUI();
		setProductoActionListeners();
	}

	public void initGUI() {
		this.setToolTipText("");
		this.setBackground(SystemColor.control);
		this.setLayout(null);

		// Id
		JLabel label_idProducto = new JLabel("ID");
		label_idProducto.setToolTipText("");
		label_idProducto.setForeground(Color.BLACK);
		label_idProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_idProducto.setBounds(40, 13, 69, 55);
		this.add(label_idProducto);

		textField_idProducto = new JTextField();
		textField_idProducto.setColumns(10);
		textField_idProducto.setBounds(144, 31, 165, 20);
		this.add(textField_idProducto);

		// Nombre
		JLabel labelNombreProducto = new JLabel("Nombre");
		labelNombreProducto.setToolTipText("");
		labelNombreProducto.setForeground(Color.BLACK);
		labelNombreProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNombreProducto.setBounds(40, 53, 69, 55);
		this.add(labelNombreProducto);

		textField_nombreProducto = new JTextField();
		textField_nombreProducto.setColumns(10);
		textField_nombreProducto.setBounds(144, 73, 165, 20);
		this.add(textField_nombreProducto);

		// Precio
		JLabel labelPrecio = new JLabel("Precio");
		labelPrecio.setToolTipText("");
		labelPrecio.setForeground(Color.BLACK);
		labelPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPrecio.setBounds(40, 96, 69, 55);
		this.add(labelPrecio);

		textField_precioProducto = new JTextField();
		textField_precioProducto.setColumns(10);
		textField_precioProducto.setBounds(144, 116, 165, 20);
		this.add(textField_precioProducto);

		// Categoria
		JLabel labelCategoria = new JLabel("Categoria");
		labelCategoria.setToolTipText("");
		labelCategoria.setForeground(Color.BLACK);
		labelCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCategoria.setBounds(40, 144, 85, 55);
		this.add(labelCategoria);

		textField_categoriaProducto = new JTextField();
		textField_categoriaProducto.setColumns(10);
		textField_categoriaProducto.setBounds(144, 164, 165, 20);
		this.add(textField_categoriaProducto);

		// Stock
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStock.setBounds(40, 212, 56, 16);
		add(lblStock);

		textFieldStock = new JTextField();
		textFieldStock.setBounds(144, 206, 165, 22);
		add(textFieldStock);
		textFieldStock.setColumns(10);

		// Botones
		botonAltaProducto = new JButton("Alta Producto");
		botonAltaProducto.setBounds(398, 53, 133, 39);
		this.add(botonAltaProducto);

		botonModificarProducto = new JButton("Modificar Producto");
		botonModificarProducto.setBounds(582, 53, 156, 39);
		this.add(botonModificarProducto);

		botonBajaProducto = new JButton("Baja Producto");
		botonBajaProducto.setBounds(398, 177, 133, 39);
		this.add(botonBajaProducto);

		botonCargarProducto = new JButton("Cargar Producto");
		botonCargarProducto.setBounds(582, 177, 133, 39);
		this.add(botonCargarProducto);

		lblListaDeProductos = new JLabel("Lista de Productos");
		lblListaDeProductos.setToolTipText("");
		lblListaDeProductos.setForeground(Color.BLACK);
		lblListaDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeProductos.setBounds(40, 277, 174, 39);
		this.add(lblListaDeProductos);

		scrollPaneProducto = new JScrollPane();
		scrollPaneProducto.setBounds(40, 329, 269, 192);
		this.add(scrollPaneProducto);

		JListProductos = new JList<>();
		scrollPaneProducto.setViewportView(JListProductos);
	}

	private void setProductoActionListeners() {
		botonAltaProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = textField_nombreProducto.getText();
					Float precio = Float.valueOf(textField_precioProducto.getText());
					String categoria = textField_categoriaProducto.getText();
					Integer stock = Integer.valueOf(textFieldStock.getText());
					if (nombre.equals("") || precio < 0 || categoria.equals("") || stock < 0)
						throw new Exception();
					TransferProducto tProducto = new TransferProducto(nombre,precio,categoria,stock);
					ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_ALTA_PRODUCTO, tProducto);
					textField_idProducto.setText("");
					textField_nombreProducto.setText("");
					textField_precioProducto.setText("");
					textField_categoriaProducto.setText("");
					textFieldStock.setText("");
				
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Los datos del producto son invalidos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

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
				try {
					Integer idProducto = Integer.valueOf(textField_idProducto.getText());
					if(idProducto < 0) {
						throw new Exception();
					}
					String nombre = textField_nombreProducto.getText();
					Float precio = Float.valueOf(textField_precioProducto.getText());
					String categoria = textField_categoriaProducto.getText();
					Integer stock = Integer.valueOf(textFieldStock.getText());
					if (nombre.equals("") || precio < 0 || categoria.equals("") || stock < 0)
						throw new Exception();
					
					TransferProducto producto = new TransferProducto(idProducto,nombre,precio, categoria,stock);
					ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_MODIFICAR_PRODUCTO, producto);
					
				}
				 catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Los datos del producto son invalidos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
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

	void altaProducto(Object datos) {

		textField_idProducto.setText(datos.toString());
	}

	void bajaProducto() {
		textField_idProducto.setText(null);
		textField_nombreProducto.setText(null);
		textField_categoriaProducto.setText(null);
		textField_precioProducto.setText(null);
	}

	public void consultarProducto(TransferProducto producto) {

		textField_idProducto.setText(producto.getID().toString());
		textField_nombreProducto.setText(producto.getNombre());
		textField_categoriaProducto.setText(producto.getCategoria());
		textField_precioProducto.setText(producto.getPrecio().toString());
		textFieldStock.setText(producto.getStock().toString());
	}

	public void listarProducto(List<TransferProducto> productos) {
		JListProductos.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public int getSize() {
				return productos.size();
			}

			public String getElementAt(int i) {
				return productos.get(i).toString();
			}
		});
	}
}