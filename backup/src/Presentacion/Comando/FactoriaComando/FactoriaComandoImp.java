/**
 * 
 */
package Presentacion.Comando.FactoriaComando;

import Presentacion.Comando.Cliente.*;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Comando.Productos.*;
import Presentacion.Comando.Ventas.CerrarVenta;
import Presentacion.Comando.Ventas.ConsultarProductoVenta;
import Presentacion.Comando.Ventas.ListarVentas;


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
                comando = new AltaCliente();
                break;
            case EVENTO_BAJA_CLIENTE:
                comando = new BajaCliente();
                break;
            case EVENTO_MODIFICAR_CLIENTE:
                comando = new ModificarCliente();
                break;
            case EVENTO_CONSULTAR_CLIENTE:
                comando = new ConsultarCliente();
                break;
            case EVENTO_LISTAR_CLIENTES:
                comando = new ListarClientes();
                break;

            case EVENTO_ALTA_PRODUCTO:
                comando = new AltaProducto();
                break;
            case EVENTO_BAJA_PRODUCTO:
                comando = new BajaProducto();
                break;
            case EVENTO_MODIFICAR_PRODUCTO:
                comando = new ModificarProducto();
                break;
            case EVENTO_CONSULTAR_PRODUCTO:
                comando = new ConsultarProducto();
                break;
            case EVENTO_LISTAR_PRODUCTOS:
                comando = new ListarProductos();
                break;
            case EVENTO_LISTAR_VENTAS:
                comando = new ListarVentas();
                break;
            case EVENTO_CONSULTAR_PRODUCTO_VENTA:
                comando = new ConsultarProductoVenta();
                break;
            case EVENTO_CERRAR_VENTA:
                comando = new CerrarVenta();
                break;
        }

        return comando;
    }

}