package skyjo.metier;

import skyjo.Controleur;

import java.util.ArrayList;
import java.util.Random;

public class MetierSkyjo {

    Controleur ctrl;

    int[] tabPioche;
    int[] tabDefausse;
    int indexJoueurActuel;
    int cartePiocher;
    ArrayList<Joueur> lstJoueur;

    public MetierSkyjo(Controleur ctrl) {

        this.ctrl = ctrl;
        this.lstJoueur = new ArrayList<Joueur>();
        this.indexJoueurActuel = 0;
        this.cartePiocher = 0;

        initPartie();

    }

    public void initPartie()
    {
                                //-2 | -1 | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12
        this.tabPioche = new int[]{ 5, 10, 15, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        this.tabDefausse = new int[tabPioche.length];

        for(Joueur j : this.lstJoueur)
        {
            j.ajouterCarte(piocherCarteRandom());
        }
        changerCartePiocher();

    }

    public int piocherCarteRandom()
    {
        Random alea = new Random();
        int rand = alea.nextInt(13);

        while( this.tabPioche[alea.nextInt(13)] == 0 )
        {
            rand = alea.nextInt(13);
        }
        return this.tabPioche[rand];
    }

    public void changerCartePiocher()
    {
        this.cartePiocher = piocherCarteRandom();
    }

    public void determinePremierJoueur()
    {
        this.indexJoueurActuel = 0;
        for(int i=1; i<this.lstJoueur.size(); i++)
        {
            int j1 = this.lstJoueur.get(this.indexJoueurActuel).getScoreActuel();
            int j2 = this.lstJoueur.get(i).getScoreActuel();

            if( j1 < j2 )
            {
                this.indexJoueurActuel = i;
            }
        }
    }

    public void jouerTour(String action, int col, int lig)
    {
        if(action.equals("retouner"))
        {
            this.lstJoueur.get(this.indexJoueurActuel).decouvrirCarte(lig,col);
        }
        else if(action.equals("remplacer"))
        {
            int temp = this.lstJoueur.get(this.indexJoueurActuel).getGrilleCartesDecouvert()[lig][col];
            this.lstJoueur.get(this.indexJoueurActuel).remplacerCarte(this.cartePiocher, lig, col);
            this.cartePiocher = temp;
        }
    }

    public void creerJoueur(String[] tabPseudo) {
        for(int i=0; i<tabPseudo.length; i++)
        {
            this.lstJoueur.add(new Joueur(tabPseudo[i]));
        }
    }
}
