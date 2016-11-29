package partie1;

public class BoxOfficeChaine extends BoxOffice {
	private static FilmChaine elements = null;
	private static int nbFilms = 0;
	private static int nbLignes = 0;
	private Film[] top3;
	
	public BoxOfficeChaine(String listing) {
		super(listing);
		
		top3[0] = new FilmChaine(new Film("","",0,-1));
		top3[1] = new FilmChaine(new Film("","",0,-2));
		top3[2] = new FilmChaine(new Film("","",0,-3));
	}
	
	
	public void createStock() {
		top3 = new Film[3];
	}
	
	public void addFilm(Film f)
    {
        boolean trouve = false;
		nbLignes++;
        if (elements == null)
        {
            elements = new FilmChaine(f);
            nbFilms++;
            top3[0] = elements;
        }
        else
        {
            FilmChaine tmp = elements;
            //Pour trouver le dernier noeud
				
            while (tmp != null)
            {
				if (tmp.getTitre().equals(f.getTitre())) { 
					trouve = true;
					tmp.setNbEntrees(tmp.getNbEntrees() + f.getNbEntrees());
					if(tmp.getNbEntrees() > top3[2].getNbEntrees()) {
						top3[2] = tmp;
						actualiser();
					}
					return;
				}
                tmp = tmp.getSuivant();
            }
            
            tmp = elements;
            
            if(trouve == false) {
				while(tmp.getSuivant() !=null)
					tmp = tmp.getSuivant();
					
                tmp.setSuivant(new FilmChaine(f));
                nbFilms++;
                tmp = tmp.getSuivant();
                if(tmp.getNbEntrees() > top3[2].getNbEntrees()) {
					top3[2] = tmp;
				}
			}
        }
    }
	
    public String affichageTroisMeilleurs()
    {
		String res = "";
		//~ FilmChaine tmp = elements;
		//~ while(tmp != null) {
			//~ res += tmp.toString();
			//~ tmp = tmp.getSuivant();
		//~ }
		
		//~ res += "\n";
		
		for(int i = 0; i < 3; i++) {
			res += top3[i].toString();
		}
		return res;
    }
    
    public String toString() {
		String resultat = "Fichier : " + listing + "\n"
						+ "Nombrede lignes : " + nbLignes + "\n"
						+ "Nombre de Films : " + nbFilms + "\n"
						+ " ---------- "+ "\n"
						+ affichageTroisMeilleurs();
		return resultat;
	}
}
