package skyjo.ihm.menu;

import skyjo.Controleur;
import skyjo.ihm.FrameSkyjo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelMenuInfo extends JPanel implements ActionListener {

    Controleur ctrl;
    FrameSkyjo papa;

    JPanel panelCentre;
    JPanel panelChoixNbJoueur;
    JPanel panelChoixPseudo;

    JComboBox<Integer> combNbJoueur;
    ArrayList<JTextField> lstTxtPseudoJoueurs;
    JLabel  lblErreurPseudo;
    JButton btnLancer;
    JButton btnRetour;

    public PanelMenuInfo(Controleur ctrl, FrameSkyjo papa)
    {
        this.ctrl = ctrl;
        this.papa = papa;

        this.setLayout(new BorderLayout());

        JPanel panelNord = new JPanel();
        this.panelCentre = new JPanel();
        JPanel panelSud = new JPanel(new GridLayout(5,5));

        this.panelChoixNbJoueur = new JPanel();
        this.panelChoixPseudo   = new JPanel();

        JLabel lblTitre = new JLabel("Titre");

        Integer[] nbJoueurOption = {2,3,4,5,6,7,8};
        this.lstTxtPseudoJoueurs = new ArrayList<JTextField>();
        for(int i=0; i<8; i++)
        {
            this.lstTxtPseudoJoueurs.add(new JTextField());
        }

        this.combNbJoueur = new JComboBox<Integer>(nbJoueurOption);
        this.combNbJoueur.setSelectedIndex(0);

        this.lblErreurPseudo = new JLabel();
        this.btnLancer = new JButton("Lancer");
        this.btnRetour = new JButton("Retour");

        this.combNbJoueur.addActionListener(this);
        this.btnLancer.addActionListener(this);
        this.btnRetour.addActionListener(this);

        this.add(this.btnLancer);
        this.add(this.btnRetour);

        panelNord.add(lblTitre);

        panelChoixNbJoueur.add(this.combNbJoueur);
        afficheTextFieldPseudo();

        panelCentre.add(panelChoixNbJoueur);

        for(int i=0; i<5; i++) {
            panelSud.add(new JLabel());
        }

        panelSud.add(new JLabel());
        panelSud.add(new JLabel());
        panelSud.add(this.btnLancer);
        panelSud.add(new JLabel());
        panelSud.add(new JLabel());

        for(int i=0; i<5; i++) {
            panelSud.add(new JLabel());
        }

        panelSud.add(new JLabel());
        panelSud.add(new JLabel());
        panelSud.add(this.btnRetour);
        panelSud.add(new JLabel());
        panelSud.add(new JLabel());

        for(int i=0; i<5; i++) {
            panelSud.add(new JLabel());
        }

        this.add(panelNord, BorderLayout.NORTH);
        this.add(panelCentre, BorderLayout.CENTER);
        this.add(panelSud, BorderLayout.SOUTH);

    }

    private void afficheTextFieldPseudo() {
        this.panelChoixPseudo.removeAll();
        this.panelChoixPseudo.setLayout(new GridLayout((this.combNbJoueur.getSelectedIndex()+2)*2, 3));

        for(int i=0; i<this.combNbJoueur.getSelectedIndex()+2; i++)
        {
            this.panelChoixPseudo.add(this.lstTxtPseudoJoueurs.get(i));
            this.panelChoixPseudo.add(new JLabel());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.btnLancer)
        {
            if(verifierNom())
            {
                String[] tabPseudo = new String[this.combNbJoueur.getSelectedIndex()+2];
                for(int i = 0; i<this.combNbJoueur.getSelectedIndex()+2; i++)
                {
                    tabPseudo[i] = this.lstTxtPseudoJoueurs.get(i).getText();
                }

                this.ctrl.creerJoueur(tabPseudo);
                this.papa.changePanel("plateau");
            }
            else {
                this.lblErreurPseudo.setBackground(Color.RED);
                this.panelChoixPseudo.add(lblErreurPseudo);
            }


        }
        else if(e.getSource() == this.btnRetour)
        {
            this.setVisible(false);
            this.papa.changePanel("menu");
        }
        else if(e.getSource() == this.combNbJoueur)
        {
            afficheTextFieldPseudo();
        }
    }

    private boolean verifierNom() {

        for(JTextField p : this.lstTxtPseudoJoueurs)
        {
            if(p.getText().contains(" "))
            {
                this.lblErreurPseudo.setText("Interdiction de mettre des espaces dans votre pseudo");
                return false;
            }
            if(p.getText() == null || p.getText().equals(""))
            {
                this.lblErreurPseudo.setText("Vous devez inséré un pseudo pour chaque joueur");
                return false;
            }
        }
        return true;

    }
}