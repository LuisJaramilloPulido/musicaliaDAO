/**
 * 
 */
package Presentacion.Comando.FactoriaComando;

import Presentacion.Comando.Cliente.*;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Comando.Productos.*;
import Presentacion.Comando.Ventas.ComandoCerrarVenta;
import Presentacion.Comando.Ventas.ComandoConsultarProductoVenta;
import Presentacion.Comando.Ventas.ComandoListarVentas;
import Presentacion.Comando.Ventas.ComandoMostrarClienteVenta;
import Presentacion.Comando.Ventas.ComandoQuery;


public class FactoriaComandoImp extends FactoriaComando {

    // Evitamos que se pueda acceder al constructor desde fuera
    protected FactoriaComandoImp() {}

   
    @Override
    public Comando nuevoComando(IDEvento evento) {
        Comando comando = null;

        switch (evento) {
            case EVENTO_MAIN:
                break;
            case EVENTO_ALTA_CLIENTE:
                comando = new ComandoAltaCliente();
                break;
            case EVENTO_BAJA_CLIENTE:
                comando = new ComandoBajaCliente();
                break;
            case EVENTO_MODIFICAR_CLIENTE:
                comando = new ComandoModificarCliente();
                break;
            case EVENTO_CONSULTAR_CLIENTE:
                comando = new ComandoConsultarCliente();
                break;
            case EVENTO_LISTAR_CLIENTES:
                comando = new ComandoListarClientes();
                break;

            case EVENTO_ALTA_PRODUCTO:
                comando = new ComandoAltaProducto();
                break;
            case EVENTO_BAJA_PRODUCTO:
                comando = new ComandoBajaProducto();
                break;
            case EVENTO_MODIFICAR_PRODUCTO:
                comando = new ComandoModificarProducto();
                break;
            case EVENTO_CONSULTAR_PRODUCTO:
                comando = new ComandoConsultarProducto();
                break;
            case EVENTO_LISTAR_PRODUCTOS:
                comando = new ComandoListarProductos();
                break;
            case EVENTO_LISTAR_VENTAS:
                comando = new ComandoListarVentas();
                break;
            case EVENTO_CONSULTAR_PRODUCTO_VENTA:
                comando = new ComandoConsultarProductoVenta();
                break;
            case EVENTO_CERRAR_VENTA:
                comando = new ComandoCerrarVenta();
                break;
            case EVENTO_MOSTRAR_CLIENTE_VENTA:
                comando = new ComandoMostrarClienteVenta();
                break;
            case EVENTO_QUERY:
                comando = new ComandoQuery();
                break;
		default:
			break;
        }

        return comando;
    }

}