package Main;

import Presentacion.Comando.Comando.IDEvento;
import Presentacion.Controlador.ApplicationController;

public class Main {

	
	public static void main(String[] args) {
		ApplicationController.getInstance().handleRequest(IDEvento.EVENTO_MAIN, null);
	}

}
