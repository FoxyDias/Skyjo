package skyjo.ihm;

import skyjo.Controleur;
import skyjo.ihm.menu.PanelMenu;
import skyjo.ihm.menu.PanelMenuInfo;
import skyjo.ihm.plateau.PanelPlateau;

import javax.swing.*;
import java.awt.*;

public class FrameSkyjo extends JFrame {

    Controleur ctrl;

    CardLayout cdlPanel;
    JPanel panelFrame;

    PanelMenu panelMenu;
    PanelMenuInfo panelMenuInfo;
    PanelPlateau  panelPlateau;

    int longueurEcran;
    int largeurEcran;

    public FrameSkyjo(Controleur ctrl) {

        this.ctrl = ctrl;

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        this.longueurEcran = dim.width;
        this.largeurEcran  = dim.height;

        this.setTitle("Foxy's Skyjo");
        this.setSize(this.longueurEcran, this.largeurEcran);

        this.cdlPanel = new CardLayout();

        this.panelFrame = new JPanel(cdlPanel);

        this.panelMenu     = new PanelMenu    (this.ctrl, this);
        this.panelMenuInfo = new PanelMenuInfo(this.ctrl, this);
        this.panelPlateau  = new PanelPlateau (this.ctrl, this);

        this.panelFrame.add(panelMenu, "menu");
        this.panelFrame.add(panelMenuInfo, "menuInfo");
        this.panelFrame.add(panelPlateau, "plateau");

        this.add(panelFrame);

        changePanel("menu");

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int getLongueurEcran() {
        return longueurEcran;
    }

    public int getLargeurEcran() {
        return largeurEcran;
    }

    public void changePanel(String pnl)
    {
        this.cdlPanel.show(this.panelFrame, pnl);
    }
}
