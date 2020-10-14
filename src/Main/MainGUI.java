package Main;

import Presentacion.Comando.Comando.IDEvento;


public class MainGUI {

    private VentanaPrincipal ventanaPrincipal;

    public MainGUI() {
        ventanaPrincipal = new VentanaPrincipal();
    }

    
    public void actualizar(IDEvento evento, Object datos) {
        ventanaPrincipal.actualizar(evento, datos);
    }

}
