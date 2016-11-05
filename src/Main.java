package partie1;

public class Main {
	public static void main(String[] args) {
		if(args.length<1)
			System.err.println("nom de fichier manquant");
		else {
			BoxOfficeTableau box = new BoxOfficeTableau(args[0]);
			System.out.println(box.toString());
		}
	}
}
