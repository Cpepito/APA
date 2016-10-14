package partie1;

public class Film 
{
	protected String titre;
	protected String realisateur;
	protected int annee;
	protected int nbEntrees;
	
	public Film(String titre, String real, int an, int nbE)
	{
		this.titre = titre;
		this.realisateur = real;
		this.annee = an;
		this.nbEntrees = nbE;
	}

	public String getTitre() {
		return titre;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public int getAnnee() {
		return annee;
	}

	public int getNbEntrees() {
		return nbEntrees;
	}

	public void setNbEntrees(int nbEntrees) {
		this.nbEntrees = nbEntrees;
	}
}


