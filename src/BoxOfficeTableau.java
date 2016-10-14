package partie1;

public class BoxOfficeTableau extends BoxOffice {
	public final static int TAILLE_INITIALE = 128;
	private Film[] film;
	private int nbFilms = 0;
	
	public BoxOfficeTableau(String file) {
		super(file);
		film = new Film[TAILLE_INITIALE];
	}
	
	public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
		if(nbFilms < TAILLE_INITIALE) {
			film[nbFilms] = new Film(titre, realisateur, annee, nbEntrees);
		}
		else {
			film = agrandissementTab(film);
			film[nbFilms] = new Film(titre, realisateur, annee, nbEntrees);
		}
		nbFilms++;
	}

	public Film[] agrandissementTab(Film[] tmp) {
		Film[] tab = new Film[nbFilms * 2];
		for(int i = 0; i < nbFilms; i++)
			tab[i] = tmp[i];
		return tab;
	}
	
	
	public String toString() {
		String res = "";
		for(Film test : film)
			res += "("+test.annee+") "+test.titre+"	Real : " +test.realisateur+
			"Entrees: "+test.nbEntrees + "\n";
		return res;
	}
}
