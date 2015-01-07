import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {


		//on indique le chemin du fichier d'entrée (.in) au clavier
		System.out.println("entrez le chemin du fichier d'entree avec l'extension");
		BufferedReader BR1 = new BufferedReader(new InputStreamReader(System.in));

		String cheminFichierEntree = null;

		try {
			cheminFichierEntree = BR1.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		//on lit dans le fichier indique
		BufferedReader IN = null;

		//cheminFichierEntree="/home/jackdanny/Bureau/M2/cours-M2-IARF/IA/scip/aux/ks_2.in";

		try {
			IN = new BufferedReader(new FileReader(cheminFichierEntree ));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		//volume du sac
		int volume = 0;


		String ligne = null;
		String[] champs = null;

		ArrayList < Integer > volumeObjets = new ArrayList <Integer>();
		ArrayList < Integer > valeurObjets = new ArrayList <Integer>();

		int volumeObjCour;
		int valeurObjCour;


		//la premiere ligne doit contenir le volume du conteneur

		try {
			ligne = IN.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
		champs = ligne.split(" ");


		if (champs.length != 1 || ligne.compareTo("") == 0){
			System.out.println("Erreur : La premiere ligne doit contenir le volume du conteneur");
			System.exit(0);
		}

		//on recupere la valeur du volume
		volume = Integer.parseInt(champs[0]);


		try {


			while((ligne = IN.readLine()) != null) {
				champs = ligne.split(" ");
				//sion a une ligne avec deux chaines:
				if (champs.length == 2) {

					//on récupère le volume et la valeur de l'objet et on les insère dans les tableaux
					volumeObjCour = Integer.parseInt(champs[0]);
					valeurObjCour = Integer.parseInt(champs[1]);

					volumeObjets.add(volumeObjCour);
					valeurObjets.add(valeurObjCour);

				}
				else{
					System.out.println("Attenion ligne non conforme!");
				}



			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		//Maintenant on va ecrire dans le fichier



		//on indique le chemin du fichier de sortie (.lp) au clavier
		System.out.println("entrez le chemin du fichier de sortie avec l'extension (.lp)");

		String cheminFichierSortie = null;

		try {
			cheminFichierSortie = BR1.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		File fbidon=new File(cheminFichierSortie); 
		if( fbidon.exists() ) {
			System.out.println("Attention le fichier de sortie existe! Pour plus de securite supprimer le" +
					" et reesayer");
			System.exit(0);
		}
		
		
		try {
			PrintWriter fic = new PrintWriter(new FileWriter(cheminFichierSortie));
			fic.println("Maximize");

			//on maximize les valeurs des objets choisis

			for(int i=0;i<valeurObjets.size();i++){


				fic.print(valeurObjets.get(i));
				fic.print("x" + (i+1) );

				if(i != valeurObjets.size()-1){
					fic.print(" + ");
				}


			}
			fic.println();
			fic.println("Subject To");
			fic.print("c0: ");	


			//on ajoute les contraintes de volumes

			for(int i=0;i<volumeObjets.size();i++){


				fic.print(volumeObjets.get(i));
				fic.print("x" + (i+1) );

				if(i != valeurObjets.size()-1){
					fic.print(" + ");
				}


			}
			fic.print(" <= ");

			fic.println(volume);


			//on specifie les domaines des variables

			fic.println("Bounds");
			
			for(int i=0;i<volumeObjets.size();i++){
				fic.println("0 <= " + "x" + (i+1));
			}

			//on rajoute les variables entières à assigner

			fic.println("Generals");
			for(int i=0;i<volumeObjets.size();i++){
				fic.print("x" + (i+1) + " ");
			}
			fic.println();

			//On rajoute END
			fic.println("END");

			fic.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("fini!");

	
	}
}
