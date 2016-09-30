package partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class BoxOffice 
{
	private String listing;
	
	public abstract void addFilm (String titre, String realisateur, int annee, int nbEntrees);
	
	public BoxOffice (String listing)
	{
		try
		{
			Scanner scanner=new Scanner(new File(listing));
			// On boucle sur chaque ligne
			while (scanner.hasNextLine()) 
			{
				String line = scanner.nextLine(); // va lire toute la ligne et place la tete de lecture a la ligne suivante
				scanner.useDelimiter("(FILM|REALISATEUR|ANNEE|VILLE) : |ENTREES :"); 
				do
				{
					System.out.println(scanner.next());
				}while (line != "\n");
					
			}
			scanner.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
