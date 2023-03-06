package skyjo.ihm.menu;

import skyjo.Controleur;
import skyjo.ihm.FrameSkyjo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenuInfo extends JPanel implements ActionListener {

    Controleur ctrl;
    FrameSkyjo papa;

    JButton btnRetour;
    public PanelMenuInfo(Controleur ctrl, FrameSkyjo papa)
    {
        this.ctrl = ctrl;
        this.papa = papa;

        this.btnRetour = new JButton("Retour");

        this.btnRetour.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.btnRetour)
        {
            this.setVisible(false);
            this.papa.changePanel("menu");
        }


    }
}
