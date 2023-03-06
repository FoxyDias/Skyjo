package skyjo.metier;

public class Joueur {

    String pseudo;
    int[][] grilleCartesCache;
    int[][] grilleCartesDecouvert;

    public Joueur(String p)
    {
        this.pseudo = p;
        this.grilleCartesCache = new int[][]{{-9, -9, -9, -9},
                                             {-9, -9, -9, -9},
                                             {-9, -9, -9, -9}};

        this.grilleCartesDecouvert = new int[][]{{-9, -9, -9, -9},
                                                 {-9, -9, -9, -9},
                                                 {-9, -9, -9, -9}};

    }

    public int[][] getGrilleCartesDecouvert() {
        return grilleCartesDecouvert;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void ajouterCarte(int val)
    {
        for(int i=0; i<this.grilleCartesCache.length; i++)
        {
            for(int j=0; j<this.grilleCartesCache[i].length; j++)
            {
                if(this.grilleCartesCache[i][j] < -2 || this.grilleCartesCache[i][j] > 12 )
                    this.grilleCartesCache[i][j] = val;
            }
        }
    }

    public void decouvrirCarte(int lig, int col)
    {
        this.grilleCartesDecouvert[lig][col] = this.grilleCartesCache[lig][col];
    }

    public boolean isFini()
    {
        boolean fini = true;
        for(int i=0; i<this.grilleCartesDecouvert.length; i++)
        {
            for(int j=0; j<this.grilleCartesDecouvert[i].length; j++)
            {
                if(!(this.grilleCartesCache[i][j] < -2 || this.grilleCartesCache[i][j] > 12))
                {
                    fini = false;
                }

            }
        }
        return fini;
    }

    public int getScoreActuel()
    {
        int score = 0;
        for(int i=0; i<this.grilleCartesDecouvert.length; i++)
        {
            for(int j=0; j<this.grilleCartesDecouvert[i].length; j++)
            {
                if(!(this.grilleCartesCache[i][j] < -2 || this.grilleCartesCache[i][j] > 12))
                {
                    score += this.grilleCartesDecouvert[i][j];
                }

            }
        }
        return score;
    }

}
