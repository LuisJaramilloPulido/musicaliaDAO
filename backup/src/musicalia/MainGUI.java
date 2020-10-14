package musicalia;

import Presentacion.Comando.Comando.IDEvento;


public class MainGUI {

    private PanelMainGUI2 panel;

    public MainGUI() {
        panel = new PanelMainGUI2();
        //panel.setVisible(true);
        //panel.frameMusicalia.setVisible(true);
    }

    
    public void actualizar(IDEvento evento, Object datos) {
        panel.actualizar(evento, datos);
    }

}
