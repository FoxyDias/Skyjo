package skyjo;

import skyjo.metier.*;
import skyjo.ihm.*;


public class Controleur {

    FrameSkyjo ihm;
    MetierSkyjo metier;


    public Controleur()
    {

        this.metier = new MetierSkyjo(this);
        this.ihm    = new FrameSkyjo(this);

    }

    public static void main(String[] args) {
        Controleur ctrl = new Controleur();
    }
}