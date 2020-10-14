/**
 * 
 */
package Presentacion.Comando.Cliente;

import Negocio.Clientes.SACliente;
import Negocio.Clientes.TransferCliente;
import Negocio.FactoriaSA.FactoriaSA;
import Presentacion.Comando.Comando.Comando;
import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.RespuestaComando;

import java.util.List;


public class ComandoListarClientes implements Comando {
	
	@Override
	public RespuestaComando ejecutar(Object datos) {
		SACliente saCliente = FactoriaSA.getInstance().getSACliente();

		List<TransferCliente> result = saCliente.listarClientesSA();

		RespuestaComando respuestaComando = new RespuestaComando();
		if (result != null) {
			respuestaComando.setEvento(IDEvento.EVENTO_LISTAR_CLIENTES);
			respuestaComando.setDatos(result);
		}
		else {
			respuestaComando.setEvento(IDEvento.EVENTO_ERROR);
		}

		return respuestaComando;
	}
}