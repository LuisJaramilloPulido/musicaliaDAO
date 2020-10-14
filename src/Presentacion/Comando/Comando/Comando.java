/**
 * 
 */
package Presentacion.Comando.Comando;

import Presentacion.Controlador.RespuestaComando;


public interface Comando {
	
	public RespuestaComando ejecutar(Object datos);
}