package partie1;

public class BoxOfficeTableau extends BoxOffice {
	public final int TAILLE_INITIALE = 128;
	private Film[] films;
	private static int nbFilms = 0;
	private static int nbLignes = 0;
	
	
	public BoxOfficeTableau(String file) {
		super(file);
	}
	
	public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
		boolean trouve = false;
		int ind = 0;
		nbLignes++;
		if(nbFilms < films.length) {
			for(int i = 0; i < nbFilms; i++) {
					if (titre.equals(films[i].getTitre())) {
						trouve = true;
						ind = i;
					}
				}
			if(trouve) {
				films[ind].setNbEntrees(films[ind].getNbEntrees() + nbEntrees);				
			}
			else {
				films[nbFilms] = new Film(titre, realisateur, annee, nbEntrees);
				nbFilms++;
			}
		}
		else {
			films = agrandissementTab(films);
			
			for(int i = 0; i < nbFilms; i++) {
				if(films[i].getTitre().equals(titre)) {
					trouve = true;
					ind = i;
				}
			}
			if(trouve) {
				films[ind].setNbEntrees(films[ind].getNbEntrees() + nbEntrees);				
			}
			else {
				films[nbFilms] = new Film(titre, realisateur, annee, nbEntrees);
				nbFilms++;
			}
		}
	}
	
	public void triTableau()
	{
		Film temporaire;
		while(true)
		{
			boolean trie = false;
			//on veut trier le tableau en ordre decroissant en fonction du nombre d'entrees
			for(int i=0 ; i < nbFilms - 1 ; i++)
			{
				if(films[i].getNbEntrees() < films[i+1].getNbEntrees())
				{
					trie = true;
					temporaire = films[i];
					films[i] = films[i+1];
					films[i+1] = temporaire;
				}
			}
			if(!trie) {
				break;
			}
		}
	}

	public void createStock() {
		films = new Film[TAILLE_INITIALE];
	}

	public Film[] agrandissementTab(Film[] tmp) {
		Film[] tab = new Film[nbFilms * 2];
		for(int i = 0; i < nbFilms; i++)
			tab[i] = tmp[i];
		return tab;
	}
	
	public String afficherTroisMeilleurs() {
		triTableau();
		String res = "";
		for(int i =0; i <3; i++)
			res += films[i].toString() + "\n";
		return res;
	}
	
	public String toString() {
		String resultat = "Fichier : " + listing + "\n"
						+ "Nombrede lignes : " + nbLignes + "\n"
						+ "Nombre de Films : " + nbFilms + "\n"
						+ " ---------- "+ "\n"
						+ afficherTroisMeilleurs();
		return resultat;
	}
}

