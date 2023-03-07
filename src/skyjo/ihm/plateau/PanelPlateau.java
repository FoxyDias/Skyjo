package skyjo.ihm.plateau;

import skyjo.Controleur;
import skyjo.ihm.FrameSkyjo;

import javax.swing.*;

public class PanelPlateau extends JPanel {

    Controleur ctrl;
    FrameSkyjo papa;
    public PanelPlateau(Controleur ctrl, FrameSkyjo frameSkyjo) {

        this.ctrl = ctrl;
        this.papa = frameSkyjo;

    }
}
