package partie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) 
	{
		try
		{
			Scanner scanner=new Scanner(new File("exemple.box"));
			// On boucle sur chaque ligne
			while (scanner.hasNextLine()) 
			{
				scanner.useDelimiter("(FILM|REALISATEUR|ANNEE|VILLE) : |ENTREES :"); // utilise les delimiteurs donnes
				String line = scanner.next(); // va lire toute la ligne et place la tete de lecture a la ligne suivante
				System.out.println(line);
			}
			scanner.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
