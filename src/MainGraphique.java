import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainGraphique {

	/**
	 * main thread
	 * @param args arg
	 * @throws Exception  exeption
	 */
	public static void main(String[] args) throws Exception {

		
		Stock stoque1 = new Stock();
		Scanner scanner = new Scanner(System.in); 
		String var = null;
		
		//stoque1.ajout(new Ordinateur(new Date("02","02",2005),2,"14'","Pentium4"));
		stoque1.ajout(new Ordinateur(new Date(8,8,2007),4,"15'","AspirateurAproton"));
		//stoque1.ajout(new VideoProjecteur(new Date(7,7,2007),3,"800x600"));
		
		
		choix("help verbose",stoque1);
		while(1==1){
			var = scanner.nextLine();
			choix(var,stoque1);
			System.out.print("> ");

		}
	}

	
	/*
	+===============================+
	|     Menu                      |
	+===============================+
	| 0) Help (option)
	| 1) Ajouter un ordinateur
	| 2) Ajouter un vidéo-projecteur 
	| 3) Ajouter un matériel
	| 4) Lister les éléments du stock
	| 5)Afficher le nombre de matériel en stock
	| 6)Emprunter un matériel
	| 7)Rendre un matérie
	| 8)Recherche un matériel
	| 9)Sauvegarder le stock
	| 10)Charger un stock
	| 11)Quitter
	*/
	
	/*
	+===============================+
	|     Menu                      |
	+===============================+
	| 0) Help (option)				|
	| 1) Ajouter une entrée			|
	| 2) Lister les éléments		|
	| 3) Emprunter un matériel		|
	| 4) Rendre un matérie			|
	| 5) Recherche un matériel		|
	| 6) Sauvegarder le stock		|
	| 7) Charger un stock			|
	| 8) Quitter					|
	+-------------------------------+
	*/
	
	/*
	help fonctionalitée
	+===============================+===========================================================================================================+
	|		Menu                    |		Fonctionalitée																						|
	+===============================+===========================================================================================================+
	| 0) Help (option)				|	Aide																									|
	| 1) Ajouter une entrée			|	Dans le mode ajout																						|
	| 2) Lister les éléments		|	Affiche le nombre de matériel du stock																	|
	| 3) Emprunter un matériel		|	Emprunte un matériel à partir de la date d’aujourd’hui à partir d’un numéro								|
	| 4) Rendre un matérie			|	Rendu du matériel emprunté à partir d’un numéro, affiche une erreur si le matériel n’est pas emprunté	|
	| 5) Recherche un matériel		|	Recherche un matériel à partir du numéro saisi															|
	| 6) Sauvegarder le stock		|	Sauvegarde de l’ensemble du stock dans un fichier														|
	| 7) Charger un stock			|	Lecture d’un fichier de stock																			|
	| 8) Quitter					|	Quitte le programme																						|
	+-------------------------------+-----------------------------------------------------------------------------------------------------------+
	*/
	
	/*
	help abreviation
	+===============================+===================+
	|     Menu                      |	abreviation		|
	+===============================+===================+
	| 0) Help (option)				|	h elp, ?, 0		|
	| 1) Ajouter une entrée			|	a jout, +, 1	|
	| 2) Lister les éléments		|	l ist, 2		|
	| 3) Emprunter un matériel		|	e mprunt, 3		|
	| 4) Rendre un matérie			|	r endre/elease,4|
	| 5) Recherche un matériel		|	f ind, 5		|
	| 6) Sauvegarder le stock		|	s ave, 6		|
	| 7) Charger un stock			|	c harger, 7		|
	| 8) Quitter					|	q, 8			|
	+-------------------------------+===================+
	*/
	
	/*
	help abreviation
	+=======================+===========+
	|     Menu              |abreviation|
	+=======================+===========+
	| Help (option)			|	h elp	|
	| Ajouter une entrée	|	a jout	|
	| Lister les éléments	|	l ist	|
	| Emprunter un matériel	|	e mprun |
	| Rendre un matérie		|	r endre	|
	| Recherche un matériel	|	f ind	|
	| Sauvegarder le stock	|	s ave	|
	| Charger un stock		|	c harge |
	| Quitter				|	q		|
	+-----------------------+-----------+
	*/
	/**
	 * ce qui va lire ce qui est  renter par l'user
	 * @param argument argumenet renter par l'user
	 * @param db stoque que l'on lie Pas bien fait
	 * @throws Exception exeption les exeption
	 */
	public static void choix(String argument, Stock db) throws Exception {
		
		String[] TabArgu = argument.split(" ");
/*
	    Scanner PD = new Scanner(argument);
	    PD.next();
	*/
		/*
		help abreviation
		+===============================+===================+
		|     Menu                      |	abreviation		|
		+===============================+===================+
		| 0) Help (option)				|	h elp, ?, 0		|
		| 1) Ajouter une entrée			|	a jout, +, 1	|
		| 2) Lister les éléments		|	l ist, 2		|
		| 3) Emprunter un matériel		|	e mprunt, 3		|
		| 4) Rendre un matérie			|	r endre/elease,4|
		| 5) Recherche un matériel		|	f ind, 5		|
		| 6) Sauvegarder le stock		|	s ave, 6		|
		| 7) Charger un stock			|	c harger, 7		|
		| 8) Quitter					|	q, 8			|
		+-------------------------------+===================+
		*/
		
		String[] expression  = {"^(h.*)|(\\?)|(0)","^(ad.*)|(aj.*)|(\\+)|(1)","^(l.*)|(2)","^(em.*)|(3)","^(r.*)|(4)","^(f.*)|(5)","^(s.*)|(6)","^(c.*)|(7)","^(q.*)|(8)|(exi.*)"};

		if(TabArgu[0].matches(expression[0])) {
			if(TabArgu.length>1) {

					if(TabArgu[1].matches("^(ordi.*)|(comp.*)|(pc)")){
						titreDescription("Help ajout ordinateur","exemple de syntax:\n"
								+ "ajout ordinateur 02/01/2000 2 14' Pentium4 ");
					}
					if(TabArgu[1].matches(expression[1])){
						titreDescription("Help Ajout","exemple de syntax:\n"
								+ "ajout ordinateur 02/01/2000 2 14' Pentium4\n"
								+ "la commande Add peut être abrevier en:\n"
								+ "+------+   +----------------+\n"
								+ "|  add |   | ordinateur     |\n"
								+ "|  aj  | + | materiel       |\n"
								+ "|  +   |   | video-projecteu|\n"
								+ "|  1   |   |________________|\n"
								+ "+------+");
					}
					if(TabArgu[1].matches("(all)|(abr.*)|(arg.*)")) { //oui je peut générée ça tiout soeulke mais flelmemee
						System.out.println("+=======================+===========+");
						System.out.println("|     Menu              |abreviation|");
						System.out.println("+=======================+===========+");
						System.out.println("| Help (option)         |   h elp   |");
						System.out.println("| Ajouter une entrée    |   a jout  |");
						System.out.println("| Lister les éléments   |   l ist   |");
						System.out.println("| Emprunter un matériel	|   e mprun |");
						System.out.println("| Rendre un matérie     |   r endre |");
						System.out.println("| Recherche un matériel	|   f ind   |");
						System.out.println("| Sauvegarder le stock	|   s ave   |");
						System.out.println("| Charger un stock      |   c harge |");
						System.out.println("| Quitter               |   q uit   |");
						System.out.println("+-----------------------+-----------+");
					}
					
					if(TabArgu[1].matches("^v.*")) {
						System.out.println("+===============================+===========================================================================================================+");
						System.out.println("|         Menu                  |             Fonctionalitée                                                                                |");
						System.out.println("+===============================+===========================================================================================================+");
						System.out.println("| 0) Help (option)              |   Aide                                                                                                    |");
						System.out.println("| 1) Ajouter une entrée         |   Dans le mode ajout                                                                                      |");
						System.out.println("| 2) Lister les éléments        |   Affiche le nombre de matériel du stock                                                                  |");
						System.out.println("| 3) Emprunter un matériel      |   Emprunte un matériel à partir de la date d’aujourd’hui à partir d’un numéro                             |");
						System.out.println("| 4) Rendre un matérie          |   Rendu du matériel emprunté à partir d’un numéro, affiche une erreur si le matériel n’est pas emprunté   |");
						System.out.println("| 5) Recherche un matériel      |   Recherche un matériel à partir du numéro saisi                                                          |");
						System.out.println("| 6) Sauvegarder le stock       |   Sauvegarde de l’ensemble du stock dans un fichier                                                       |");
						System.out.println("| 7) Charger un stock           |   Lecture d’un fichier de stock                                                                           |");
						System.out.println("| 8) Quitter                    |   Quitte le programme                                                                                     |");
						System.out.println("+-------------------------------+-----------------------------------------------------------------------------------------------------------+");
					}
					
					if(TabArgu[1].matches(expression[2])) { //&& TabArgu[3].matches("^(c.*)|occurance|nombre|size|taille")){
						titreDescription("Help Liste","exemple de syntax:\n"
								+ "ls size"
								+ "cette commande permet de d'aficher la liste de tout les élément et avec l'argument [size,taille] de savoir le nombre délément.");
					}
					if(TabArgu[1].matches(expression[3])) {
						titreDescription("Emprunt", "sintax: \n"
								+ "e 2 10/10/2022\n"
								+ "ou bien:\n"
								+ "e 2\n"
								+ "pour emprunter le livre le meme  jour\n"
								+ "toutefoit un libre ne peut etre emprunter 2 fois\n"
								+ "pour le rendre il faut taper la commande rendre");
					}
					if(TabArgu[1].matches(expression[4])) {
						titreDescription("Rendre", "sintax: \n"
								+ "r 2\n"
								+ "permet de rendre un materiel qui est louer\n");
					}
					if(TabArgu[1].matches(expression[5])) {
						titreDescription("Rechercher", "sintax: \n"
								+ "f 2\n"
								+ "permet de rechercher un materiel a partire de sont identifiant f comme find  !!!\n");
					}
					if(TabArgu[1].matches(expression[6])) {
						titreDescription("Sauvgarde", "sintax: \n"
								+ "s POUETPOUET\n"
								+ "la sauvgarde sera faite dans le ficheir POUETPOUET\n");
					}
					if(TabArgu[1].matches(expression[7])) {
						titreDescription("Charger", "sintax: \n"
								+ "charge POUETPOUET\n"
								+ "la sauvgarde sera charger depuis le ficheir POUETPOUET\n");
					}
					if(TabArgu[1].matches(expression[8])) {
						titreDescription("Quit", "sintax: \n"
								+ "q\n"
								+ "quit le programe\n"
								+ "a savoir que a chaque fermeture le programe sauvgarde dans un fichier temps :) le noms du fichier  est '' ");
					}
				
				
				
			}
			else {
				titreDescription("Help","help prend pour argument une autre [commande]  puis  explique sont utilisation"
						+ "\n la commande help peut etre invoquer avec:  h, ?\n"
						+ "mais peut prendre en argument 'arg' ou bien 'verbose'");
			}
		}
		else if(TabArgu[0].matches(expression[1])) {
			if(TabArgu.length>1) {
				//flm de verif
				//Scanner FDP = new Scanner("null");//temporraire 
				/*
				try {
					FDP = new Scanner(TabArgu[2]);
					FDP.useDelimiter("/|\\|\\.");
				}
				catch (ArrayIndexOutOfBoundsException expept) {
					 System.out.println(expept+  " date invalide/argumant manquand");
				}
				*/
				Scanner FDP = new Scanner("null");
				if(TabArgu.length>=3) {
					FDP = new Scanner(TabArgu[2]);
					FDP.useDelimiter("/|\\|\\.");	
				}

				
				if(TabArgu[1].matches("^(ordi.*)|(comp.*)|(pc)")){

					    try {
					    	
						    if(TabArgu.length==6) {
						    	db.ajout(new Ordinateur(new Date(FDP.nextInt(),FDP.nextInt(),FDP.nextInt()),Integer.parseInt(TabArgu[3]),TabArgu[4],TabArgu[5]));
						    }
						    else if(TabArgu.length==5) {
						    	db.ajout(new Ordinateur(new Date(FDP.nextInt(),FDP.nextInt(),FDP.nextInt()),TabArgu[3],TabArgu[4]));
						    }
						    else if(TabArgu.length==7) {
						    	db.ajout(new Ordinateur(new Date(Integer.parseInt(TabArgu[2]),Integer.parseInt(TabArgu[3]),Integer.parseInt(TabArgu[4])),TabArgu[5],TabArgu[6]));
						    }
						    else if(TabArgu.length==8) {
						    	db.ajout(new Ordinateur(new Date(Integer.parseInt(TabArgu[2]),Integer.parseInt(TabArgu[3]),Integer.parseInt(TabArgu[4])),Integer.parseInt(TabArgu[5]),TabArgu[6],TabArgu[7]));
						    }
						    else {
								titreDescription("Nombre argument invalide "+TabArgu.length+" argument detecter:","exemple de syntax:\n"
										+ "ajout ordinateur 02/01/2000 2 14' Pentium4\n"
										+ "  ^       ^         ^       ^  ^      ^\n"
										+ "action  type      date    num ecrant  cpu\n"
										+ "5 ou 6 argument attendu ");
						    }
					    }
					    //je try du debugage m ais flems
					    catch (NumberFormatException e) {
							titreDescription(e.toString(),"exemple de syntax:\n"
									+ "ajout ordinateur 02/01/2000 2 14' Pentium4\n"
									+ "                            ^\n"
									+ "                         numero\n"
									+ "ou bien un argumnet en trop qui correspond pas");
						}
					    
					    catch (NoSuchElementException e) {
							titreDescription(e.toString() + " argument manquant/invalide","exemple de syntax:\n"
								+ "ajout ordinateur 02/01/2000 2 14' Pentium4\n"
								+ "                      ^     ^  ^      ^\n"
								+ "                     date  num ecrant  cpu ");
					   }
					   catch(IllegalArgumentException e) {
							titreDescription(e.toString() + "date invalide","exemple de syntax:\n"
									+ "ajout ordinateur 02/01/2000 2 14' Pentium4\n"
									+ "                            ^  ^      ^\n"
									+ "                           num ecrant  cpu ");
					   }
					   finally {
						   System.out.println("ok");
					   }
					}

				
				else if(TabArgu[1].matches("^(video.*)|(projo)|(projec.*)")){
					
					String err = "exemple de syntax:\n"
							+ "ajout projo 02/01/2000 2 800x600 \n"
							+ "  ^       ^         ^       ^      ^      \n"
							+ "action  type     date num-optinel resolution\n";
					
					try {
				    	
					    if(TabArgu.length==4) {
					    	db.ajout(new VideoProjecteur(new Date(FDP.nextInt(),FDP.nextInt(),FDP.nextInt()),TabArgu[3]));
					    }
					    else if(TabArgu.length==5) {
					    	db.ajout(new VideoProjecteur(new Date(FDP.nextInt(),FDP.nextInt(),FDP.nextInt()),Integer.parseInt(TabArgu[3]),TabArgu[4]));
					    }
					    else {
							titreDescription("Nombre argument invalide "+TabArgu.length+" argument detecter:",err
									+ "4 ou 5 argument attendu avec le No optionel");
					    }
				    }
				    //je try du debugage m ais flems
				    catch (NumberFormatException e) {
						titreDescription(e.toString(),err
								+ "ou bien un argumnet en trop qui correspond pas");
					}
				    
				    catch (NoSuchElementException e) {
						titreDescription(e.toString() + " argument manquant",err);
				   }
				   catch(IllegalArgumentException e) {
						titreDescription(e.toString() + "date invalide",err
								+ "essayer une date plus valide  :)");
						
				   }
				   finally {
					   System.out.println("ok");
				   }

				}
				else if(TabArgu[1].matches("^(matos)|(materiel)|(truc)|(autre).*")){
					
					String err = "exemple de syntax:\n"
							+ "ajout materiel 02/01/2000 2  \n"
							+ "  ^       ^         ^     ^ \n"
							+ "action  type      date n°optinel \n";
					
					try {
				    	
					    if(TabArgu.length==4) {
					    	db.ajout(new Materiel(new Date(FDP.nextInt(),FDP.nextInt(),FDP.nextInt()),Integer.parseInt(TabArgu[3])));
					    }
					    else if(TabArgu.length==3) {
					    	//System.out.println("azerazer");
					    	//System.out.println(FDP.next()+FDP.next()+FDP.nextInt()+"ok");
					    	db.ajout(new Materiel(new Date(FDP.nextInt(),FDP.nextInt(),FDP.nextInt())));
					    }
					    else {
							titreDescription("Nombre argument invalide "+TabArgu.length+" argument detecter:",err
									+ "5 ou 6 argument attendu ");
					    }
				    }
				    //je try du debugage m ais flems
				    catch (NumberFormatException e) {
						titreDescription(e.toString(),err
								+ "ou bien un argumnet en trop qui correspond pas");
					}
				    
				    catch (NoSuchElementException e) {
						titreDescription(e.toString() + " argument manquant",err);
				   }
				   catch(IllegalArgumentException e) {
						titreDescription(e.toString() + "date invalide",err
								+ "essayer une date plus valide  :)");
						
				   }
				   finally {
					   System.out.println("ok");
				   }

				}
				else{titreDescription("Type incorecte","cette commande prend en argument 3 type: \n\n"
						+ "video-projecteur => Saisir les informations d’unvideo-projecteur\n"
						+ "Ordinateur       => Saisir les informations d’un ordinateur (autrement dit les attributs de Materiel et d’Ordinateur)\n"
						+ "Materiel         => Saisir les informations d’unmatériel\n"
						+ "\nLa Sintax est la  suivante: ajout [ordi,video-projecteur,materiel]");
				}
			}
			else {
			titreDescription("Ajouter une entrée","cette commande prend en argument 3 type: \n\n"
					+ "video-projecteur => Saisir les informations d’unvideo-projecteur\n"
					+ "Ordinateur       => Saisir les informations d’un ordinateur (autrement dit les attributs de Materiel et d’Ordinateur)\n"
					+ "Materiel         => Saisir les informations d’unmatériel\n"
					+ "\nLa Sintax est la  suivante: ajout [ordi,video-projecteur,materiel]"
					+ "\nPour plus de  présision pour la déclaration de l'object fair : help  add ordinateur"
					+ "\n les différante sintaxe pour ajouter sont: add, aj, +, 1");
			}
		}
		else if(TabArgu[0].matches(expression[2])){

			if(TabArgu.length>1) {//TabArgu[1].matches("(c.*)|(n.*)|(size)|(ta.*)")) {
				System.out.println(db.sizeInventaire());
			}
			else {
				db.toString();
			}
		}
		else if(TabArgu[0].matches(expression[3])){
			
			if(TabArgu.length>2) {
				Scanner PTN = new Scanner(TabArgu[2]);
				PTN.useDelimiter("/|\\|\\.");	
				
				/*
				System.out.println(PTN.nextInt());
				System.out.println(PTN.nextInt());
				System.out.println(PTN.nextInt());
				*/
				db.recherche(Integer.parseInt(TabArgu[1])).pretDate(PTN.nextInt(),PTN.nextInt(),PTN.nextInt());

			}
			else if(TabArgu.length==1) {
				titreDescription("Emprunt", "sintax: \n"
						+ "e 2 10/10/2022\n"
						+ "ou bien:\n"
						+ "e 2\n"
						+ "pour emprunter le livre le meme  jour");
			}
			else{
				db.recherche(Integer.parseInt(TabArgu[1])).pretDate();
			}
			
		}
		else if(TabArgu[0].matches(expression[4])){
			if(TabArgu.length>1) {
				 System.out.println(db.recherche(Integer.parseInt(TabArgu[1])).release());
			}
			else if(TabArgu.length==1) {
				titreDescription("Release", "sintax: \n"
						+ "e 2\n"
						+ "Permet de rendre un livre");
			}
		}
		else if(TabArgu[0].matches(expression[5])){
			if(TabArgu.length>1) {
				try{
					System.out.println(db.recherche(Integer.parseInt(TabArgu[1])).toString());
				}
				catch(NullPointerException e) {
					titreDescription("erreur", "recherche infructueuse\n"
							+ "veuilleur reiterer votre requette avec un id composer que de chiffre ce referer a la commande : \n"
							+ "liste");
				}
			}
			else {
				titreDescription("Recherche","donner un numero en argument et vous resort l'objet associer");
			}
			
		}
		else if(TabArgu[0].matches(expression[6])){
			if(TabArgu.length>1) {
					db.save(TabArgu[1]);				
			}
			else {
				titreDescription("Sauvgarde", "sintax\n"
						+ "s toto\n"
						+ "fichier  sauvgarder a toto");}
			
		}
		
		else if(TabArgu[0].matches(expression[7])){
			if(TabArgu.length>1) {
					db.loadwrite(TabArgu[1]);		//je supose que faut faire ça  meme si ces demander  autremenat qui serait con a  mmloin de fair une  grosse intervfecce		
			}
			else {
				titreDescription("Charger", "sintax\n"
						+ "c toto\n"
						+ "charge la base de donnée est  écrace l'existante");}
			
		}
		
		
		else if(TabArgu[0].matches(expression[8])){
			db.save("last");				
			System.exit(0); ;
		}
		else {
			System.out.println("commande not found");
		}
	
	
	
	
	}	
		
	

	/**
	 * fonction  que j'ai faite qui fait une  mise en forme
	 * @param text texte titre 
	 * @param Rtext texte descriptif
	 */
	public static void titreDescription(String text, String Rtext) {
		int decalageTitre = text.length();
		//titre
		System.out.print(
				"+==="+espacement(decalageTitre,"=")+"===+"	+"\n"+
				"|   "+text+"    |"						+"\n"+
				"+==="+espacement(decalageTitre,"=")+"===+"
		);
		String[] texte = Rtext.split("\n");
		
		int decalageTexte = 0;
		for(String ligne : texte) {
			if(decalageTexte < ligne.length()) {
				decalageTexte = ligne.length();
			}
		}
		
		if(decalageTexte < decalageTitre) {
			decalageTexte = decalageTitre;
		}
		if(decalageTexte == decalageTitre) {
			System.out.print("\n");	
		}
		else {
		System.out.print(
				"==="+espacement(decalageTexte-8-decalageTitre,"=")+"===+"
				+"\n");
		}
		for(String ligne : texte) {
			System.out.print(				
					"|   "+ligne+espacement(decalageTexte-ligne.length()," ")+"   |"
			+"\n");
		}
		System.out.print(
				"+---"+espacement(decalageTexte,"-")+"---+"
		);
		
		System.out.println();
	}
	/**
	 * sert a mise en forme 
	 * @see titreDescription
	 * @param NBcaracter differance d'espace
	 * @param TYPEcaracter type despacemetn a aplique
	 * @return temp  la variable return du texte
	 */
	public static String espacement(int NBcaracter,  String TYPEcaracter) {
		String temp = TYPEcaracter;
		for(int a = 0; a<NBcaracter ; a++) {
			temp += TYPEcaracter;
		}
		return temp;
	}
	

}
