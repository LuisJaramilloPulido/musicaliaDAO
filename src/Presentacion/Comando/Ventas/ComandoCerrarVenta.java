/**
 * 
 */
package Presentacion.Comando.Ventas;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Ventas.SAVenta;
import Negocio.Ventas.TransferVenta;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.RespuestaComando;


public class ComandoCerrarVenta implements Comando {
    
    @Override
    public RespuestaComando ejecutar(Object datos) {
        SAVenta saCliente = FactoriaSA.getInstance().getSAVenta();

        Integer result = saCliente.crearVentaSA((TransferVenta) datos);

        RespuestaComando respuestaComando = new RespuestaComando();
        if (result != null) {
            respuestaComando.setEvento(IDEvento.EVENTO_CERRAR_VENTA);
        }
        else {
            respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
        }

        return respuestaComando;
    }
}