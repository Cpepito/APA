package partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class BoxOffice 
{
	protected String listing;
	
	public abstract void addFilm (Film f);
		
	public abstract void createStock();
		
	public BoxOffice (String listing)
	{
		try
		{
			this.listing = listing;
			createStock();			
			Scanner scanner=new Scanner(new File(listing));
			// On boucle sur chaque ligne
			while (scanner.hasNextLine()) 
			{
				String line = scanner.nextLine();
				String[] donnees = line.split("\t");
				String nomFilm = donnees[0].substring(7);
				String nomRealisateur = donnees[1].substring(14);
				int anneeFilm = Integer.parseInt(donnees[2].substring(8));
				int nbEntrees = Integer.parseInt(donnees[4].substring(9));
				Film f = new Film(nomFilm, nomRealisateur, anneeFilm, nbEntrees);
				addFilm(f);
			}
			scanner.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}


