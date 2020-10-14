
package Presentacion.Clientes;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Negocio.Clientes.TransferCliente;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.ApplicationController;

public class PanelCliente extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField_IdCliente;
	private JTextField textField_Dni;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido;
	private JTextField textField_Direccion;
	private JList<String> JListClientes;
	private JLabel lblListaDeClientes;
	private JScrollPane scrollPane_2;
	private JCheckBox checkboxEsSocio;
	private JTextField textFieldSocio;
	private JTextField textFieldActivo;
	// Botones
	private JButton botonAltaCliente;
	private JButton botonModificarCliente;
	private JButton botonBajaCliente;
	private JButton botonCargarCliente;
	private JButton btnLimpiar;

	// Constructor
	public PanelCliente() {

		initGUI();
		setClienteActionListeners();
	}

	public void initGUI() {
		this.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.setBackground(SystemColor.control);
		this.setLayout(null);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setForeground(Color.BLACK);
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNombre.setToolTipText("");
		labelNombre.setBounds(38, 79, 69, 55);
		this.add(labelNombre);

		JLabel labelApellido = new JLabel("Apellidos");
		labelApellido.setToolTipText("");
		labelApellido.setForeground(Color.BLACK);
		labelApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelApellido.setBounds(38, 113, 85, 55);
		this.add(labelApellido);

		JLabel labelId = new JLabel("ID");
		labelId.setBackground(Color.LIGHT_GRAY);
		labelId.setToolTipText("");
		labelId.setForeground(Color.BLACK);
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelId.setBounds(40, 11, 69, 55);
		this.add(labelId);

		JLabel labelDni = new JLabel("DNI");
		labelDni.setToolTipText("");
		labelDni.setForeground(Color.BLACK);
		labelDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDni.setBounds(38, 45, 69, 55);
		this.add(labelDni);

		JLabel labelDireccion = new JLabel("Direccion");
		labelDireccion.setToolTipText("");
		labelDireccion.setForeground(Color.BLACK);
		labelDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDireccion.setBounds(38, 147, 110, 55);
		this.add(labelDireccion);
				
				JLabel lblSocio = new JLabel("Socio");
				lblSocio.setBounds(37, 196, 56, 16);
				add(lblSocio);
				
				JLabel lblActivo = new JLabel("Activo");
				lblActivo.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblActivo.setBounds(38, 229, 56, 16);
				add(lblActivo);
		
				textField_IdCliente = new JTextField();
				textField_IdCliente.setBounds(144, 28, 165, 20);
				this.add(textField_IdCliente);
				textField_IdCliente.setColumns(10);

		textField_Dni = new JTextField();
		textField_Dni.setColumns(10);
		textField_Dni.setBounds(144, 61, 165, 20);
		this.add(textField_Dni);

		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(144, 96, 165, 20);
		this.add(textField_Nombre);

		textField_Apellido = new JTextField();
		textField_Apellido.setColumns(10);
		textField_Apellido.setBounds(144, 130, 165, 20);
		this.add(textField_Apellido);

		textField_Direccion = new JTextField();
		textField_Direccion.setColumns(10);
		textField_Direccion.setBounds(144, 164, 165, 20);
		this.add(textField_Direccion);

		checkboxEsSocio = new JCheckBox("es Socio");
		checkboxEsSocio.setBounds(502, 208, 97, 23);
		this.add(checkboxEsSocio);
		
		textFieldSocio = new JTextField();
		textFieldSocio.setEditable(false);
		textFieldSocio.setBounds(144, 197, 116, 22);
		add(textFieldSocio);
		textFieldSocio.setColumns(10);
		
		textFieldActivo = new JTextField();
		textFieldActivo.setEditable(false);
		textFieldActivo.setBounds(144, 226, 116, 22);
		add(textFieldActivo);
		textFieldActivo.setColumns(10);

		botonAltaCliente = new JButton("Alta cliente");
		botonAltaCliente.setBounds(398, 53, 133, 39);
		this.add(botonAltaCliente);

		botonModificarCliente = new JButton("Modificar Cliente");
		botonModificarCliente.setBounds(582, 53, 133, 39);
		this.add(botonModificarCliente);

		botonBajaCliente = new JButton("Baja cliente");
		botonBajaCliente.setBounds(398, 144, 133, 39);
		this.add(botonBajaCliente);

		botonCargarCliente = new JButton("Cargar Cliente");
		botonCargarCliente.setBounds(582, 144, 133, 39);
		this.add(botonCargarCliente);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(502, 264, 110, 55);
		add(btnLimpiar);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(38, 340, 354, 189);
		this.add(scrollPane_2);

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
		this.add(lblListaDeClientes);
	}

	private void setClienteActionListeners() {
		// TODO Auto-generated method stub
		botonAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = textField_Nombre.getText();
					String apellido = textField_Apellido.getText();
					String dni= textField_Dni.getText();
					String direccion = textField_Direccion.getText();
					Boolean socio= checkboxEsSocio.isSelected();
					if (nombre.equals("") ||apellido.equals("") || dni.equals("")  || direccion.equals(""))
						throw new Exception();
					
					TransferCliente nuevoCliente = new TransferCliente(nombre, apellido, dni,direccion,socio);
					ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_ALTA_CLIENTE, nuevoCliente);
					textField_Nombre.setText("");
					textField_Apellido.setText("");
					textField_Dni.setText("");
					textField_Direccion.setText("");
					checkboxEsSocio.setSelected(false);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Los datos del cliente son invalidos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		botonModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Integer id = Integer.valueOf(textField_IdCliente.getText());
					String nombre = textField_Nombre.getText();
					String apellido = textField_Apellido.getText();
					String dni = textField_Dni.getText();
					String direccion = textField_Direccion.getText();
					Boolean socio = checkboxEsSocio.isSelected();
					if (id < 0 || nombre.equals("") || apellido.equals("") || dni.equals("") || direccion.equals(""))
						throw new Exception();
					TransferCliente nuevoCliente = new TransferCliente(id,nombre, apellido, dni,direccion,socio);
					ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_MODIFICAR_CLIENTE, nuevoCliente);
					textField_IdCliente.setText("");
					textField_Nombre.setText("");
					textField_Apellido.setText("");
					textField_Dni.setText("");
					textField_Direccion.setText("");
					checkboxEsSocio.setSelected(false);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "datos del clientes invalidos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

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
		
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_IdCliente.setText("");
				textField_Nombre.setText("");
				textField_Apellido.setText("");
				textField_Dni.setText("");
				textField_Direccion.setText("");
				checkboxEsSocio.setSelected(false);
				textFieldSocio.setText("");
				textFieldActivo.setText("");
			}
		});
	}

	void bajaCliente() {
		textField_IdCliente.setText(null);
		textField_Nombre.setText(null);
		textField_Apellido.setText(null);
		textField_Dni.setText(null);
		textField_Direccion.setText(null);
		checkboxEsSocio.setSelected(false);
	}

	void altaCliente(Object datos) {
		textField_IdCliente.setText(datos.toString());
	}

	void consultarCliente(TransferCliente cliente) {

		textField_IdCliente.setText(cliente.getID().toString());
		textField_Nombre.setText(cliente.getNombre());
		textField_Apellido.setText(cliente.getApellido());
		textField_Dni.setText(cliente.getDNI());
		textField_Direccion.setText(cliente.getDireccion());
		checkboxEsSocio.setSelected(cliente.getSocio());
		String cadena="";
		if(cliente.getSocio()) cadena= "Si";
		else cadena="No";
		textFieldSocio.setText(cadena);
		if(cliente.getActivo())  cadena= "Si";
		else cadena="No";
		textFieldActivo.setText(cadena);
	}

	void listarclientes(List<TransferCliente> clientes) {
		JListClientes.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			public int getSize() {
				return clientes.size();
			}

			public String getElementAt(int i) {
				return clientes.get(i).toString();
			}
		});
	}
}