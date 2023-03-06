package skyjo.ihm.menu;

import skyjo.Controleur;
import skyjo.ihm.FrameSkyjo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenu extends JPanel implements ActionListener {

    Controleur ctrl;
    FrameSkyjo papa;

    JButton btnQuitter;
    JButton btnJouer;

    public PanelMenu(Controleur ctrl, FrameSkyjo papa) {

        this.ctrl = ctrl;
        this.papa = papa;

        this.setLayout(new BorderLayout());

        JPanel panelNord = new JPanel();
        JPanel panelCentre = new JPanel(new GridLayout(5,5));

        JLabel lblTitre = new JLabel("Titre");

        this.btnJouer = new JButton("Jouer");
        this.btnQuitter = new JButton("Quitter");

        this.btnQuitter.addActionListener(this);
        this.btnJouer.addActionListener(this);

        panelNord.add(lblTitre);

        for(int i=0; i<5; i++) {
            panelCentre.add(new JLabel());
        }

        panelCentre.add(new JLabel());
        panelCentre.add(new JLabel());
        panelCentre.add(this.btnJouer);
        panelCentre.add(new JLabel());
        panelCentre.add(new JLabel());

        for(int i=0; i<5; i++) {
            panelCentre.add(new JLabel());
        }

        panelCentre.add(new JLabel());
        panelCentre.add(new JLabel());
        panelCentre.add(this.btnQuitter);
        panelCentre.add(new JLabel());
        panelCentre.add(new JLabel());

        for(int i=0; i<5; i++) {
            panelCentre.add(new JLabel());
        }

        this.add(panelNord, BorderLayout.NORTH);
        this.add(panelCentre, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.btnQuitter)
        {
            this.papa.dispose();
        }
        else if(e.getSource() == this.btnJouer)
        {
            this.setVisible(false);
            this.papa.changePanel("menuInfo");
        }
    }
}
