package partie1;

public class BoxOfficeTest extends BoxOffice {
	public BoxOfficeTest(String file) {
		super(file);
	}
	
	public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
		System.out.println("("+annee+") "+titre+"	Real : " +realisateur+"		Entrees: "+nbEntrees);
	}
}
