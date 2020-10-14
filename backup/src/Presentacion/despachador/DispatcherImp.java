
package Presentacion.despachador;

import Presentacion.Comando.Comando.IDEvento;
import musicalia.MainGUI;

import javax.swing.*;


public class DispatcherImp extends Dispatcher {

    private MainGUI mainGUI;

    // Evitamos que se pueda acceder al constructor desde fuera
    protected DispatcherImp() {
        mainGUI = new MainGUI();
    }

   
    @Override
    public void crearVista(IDEvento evento, Object datos) {
        switch (evento) {
            case EVENTO_ERROR:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                break;

            case EVENTO_ALTA_CLIENTE:
                mainGUI.actualizar(evento, datos);
                JOptionPane.showMessageDialog(null, "Cliente creado",
                        "exito", JOptionPane.INFORMATION_MESSAGE);
                break;
            case EVENTO_BAJA_CLIENTE:
                mainGUI.actualizar(evento, datos);
                JOptionPane.showMessageDialog(null, "Cliente dado de baja",
                        "exito", JOptionPane.INFORMATION_MESSAGE);
                break;
            case EVENTO_MODIFICAR_CLIENTE:
            	 mainGUI.actualizar(evento, datos);
                JOptionPane.showMessageDialog(null, "Cliente actualizado",
                        "exito", JOptionPane.INFORMATION_MESSAGE);
                break;
            case EVENTO_ALTA_PRODUCTO:
                mainGUI.actualizar(evento, datos);
                JOptionPane.showMessageDialog(null, "Producto creado",
                        "exito", JOptionPane.INFORMATION_MESSAGE);
                break;
            case EVENTO_BAJA_PRODUCTO:
                mainGUI.actualizar(evento, datos);
                JOptionPane.showMessageDialog(null, "Producto dado de baja",
                        "exito", JOptionPane.INFORMATION_MESSAGE);
                break;
            case EVENTO_MODIFICAR_PRODUCTO:
            	 mainGUI.actualizar(evento, datos);
                JOptionPane.showMessageDialog(null, "Producto actualizado",
                        "exito", JOptionPane.INFORMATION_MESSAGE);
                break;
            case EVENTO_CERRAR_VENTA:
            	mainGUI.actualizar(evento, datos);
                JOptionPane.showMessageDialog(null, "Venta completada",
                        "exito", JOptionPane.INFORMATION_MESSAGE);
                break;

            case EVENTO_MAIN:
            case EVENTO_CONSULTAR_CLIENTE:
            case EVENTO_LISTAR_CLIENTES:
            case EVENTO_CONSULTAR_PRODUCTO:
            case EVENTO_CONSULTAR_PRODUCTO_VENTA:
            case EVENTO_LISTAR_PRODUCTOS:
            case EVENTO_LISTAR_VENTAS:
                mainGUI.actualizar(evento, datos);
                break;
        }
    }

}