/**
 * 
 */
package Negocio.FactoriaSA;

import Negocio.Clientes.SACliente;
import Negocio.Clientes.SAClienteImp;
import Negocio.Productos.SAProducto;
import Negocio.Productos.SAProductoImp;
import Negocio.Ventas.SAVenta;
import Negocio.Ventas.SAVentaImp;


public class FactoriaSAImp extends FactoriaSA {

    // Evitamos que se pueda acceder al constructor desde fuera
    protected FactoriaSAImp() {}


    
    private SACliente saCliente;
    
    private SAVenta saVenta;
    
    private SAProducto saProducto;


    @Override
    public SACliente getSACliente() {
        if (saCliente == null) {
            saCliente = new SAClienteImp();
        }

        return saCliente;
    }

    
    @Override
    public SAVenta getSAVenta() {
        if (saVenta == null) {
            saVenta = new SAVentaImp();
        }

        return saVenta;
    }


    @Override
    public SAProducto getSAProducto() {
        if (saProducto == null) {
            saProducto = new SAProductoImp();
        }

        return saProducto;
    }

}