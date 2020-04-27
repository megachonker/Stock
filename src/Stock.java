import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Stock implements Serializable  {

	 
	private static final long serialVersionUID = 9181831987792835828L;
	
	
	private ArrayList<Materiel> liste = new ArrayList<Materiel>();

	/**
	 * j'addor le mal ces a dire de faire ce des truc  que on  fait pas en coure lol
	 */
	public Stock() {

	}

	/**
	 * Ajout un element au stoque
	 * @param element Materiel a ajouter
	 * @return true / false selont erreur
	 * @see Materiel materiel
	 * @see Ordinateur ordi
	 * @see VideoProjecteur projo
	 */
	public boolean ajout(Materiel element){ //verifier  doublon ?
		if(element != null) {
			return 	liste.add(element);
		}
		return false;

		/*try {
				liste.add(element);
				return true;
			}
		catch (IllegalArgumentException ex) {
			  return false;
			}
		*/
	}
	
	/**
	 * Ouai je me suis pas fouler j'aurait du en fair un jolie graphiquemnet mais bon :/
	 * <p> ça dump toute les object dans le tableaux est appelle l'eur toString</p>
	 * @see toString
	 */
	public String toString() {  //GUUUUUUUUUVG
		for(int u = 0; u<liste.size();u++) { //  pas   opti
			System.out.println(liste.get(u).toString());
		}
		return  null;
	}

	/**
	 * permet de suprimer un element donnée en fonction de sont ID et nons de sa position dans  le tableaux
	 * @param id identifiant du materiel
	 * @return true false en fonction de si sa truve
	 */
	public boolean supression(int id) {
		for(int u = 0; u<liste.size();u++) {
			if(liste.get(u).serialNumber==id) {
				liste.remove(u);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Supression suprime un objet de la liste qui corspond directement a l'objet  mit en argument
	 * @param matos materiel donnée 
	 * @return true false si trouver
	 * @see Materiel
	 */
	public boolean supression(Materiel matos) {
			for(int u = 0; u<liste.size();u++) {
				//System.out.print("\n\n"+String.valueOf(liste.get(u))+"\n\n");
				if(liste.get(u).toString().equals(matos.toString())){
				//if(liste.get(u).serialNumber==matos.serialNumber) {  // je triche ici je par du principe que il n'y a  pas 2 id identique  
					liste.remove(u);
					return true;
				}
			}
		return false;
	}

	/**
	 * recherche un identifiant dans tout la liste est en resort l'objet corespondant
	 * @param id int mit en argument
	 * @return Materiel ce  que on  a trouver
	 */
	public Materiel recherche(int id) {
		for(Materiel matos : this.liste) {
			if(matos.serialNumber==id) {
				return matos;
			}			
		}
		return null;
	}
	/**
	 * fonction qui resort la taille de l'inventaire
	 * @return int un vieux int
	 */
	public int sizeInventaire() {
		return  liste.size();
	}
	
	/**
	 * classe qui va trier en fonction des id il me semble
	 * @see Materiel 
	 */
	public void sort() {
		Collections.sort(liste, new Comparaison());
	}
	
	
	
	
	//copier coller de pokedex / pokemon car meme  taff et flm
	/**
	 * sauvgarde 
	 * @param nomsFichier noms fichier a  sauvgarder de preferance en .db
	 * @throws IOException si probbleme entrer sortie
	 */
	public void save(String nomsFichier) throws IOException{
	    FileOutputStream fileOutputStream = new FileOutputStream(nomsFichier);//+".txt");
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	    objectOutputStream.writeObject(this);
	    objectOutputStream.flush();
	    objectOutputStream.close();
	}
	/**
	 * Dump  un object a partire d'un fichier
	 * @param nomsFichier noms avec  .db
	 * @return Stock un object
	 * @throws Exception io tout ça
	 */
	public static Stock load(String nomsFichier) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(nomsFichier);//+".txt");
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    Stock p2 = (Stock) objectInputStream.readObject();
	    objectInputStream.close();
	    return p2;
	}
	/**
	 * Lit et réécrite le stoque actuelle en fc fichier  
	 * @param nomsFichier noms .db
	 * @throws Exception tout ça io
	 */
	public void loadwrite(String nomsFichier) throws Exception {
	    this.liste.clear();
	    for(Materiel lepokemon : load(nomsFichier).liste) {
		    this.liste.add(lepokemon);
	    }
	    //System.out.println(p2.liste.get(1).toString());
	    
	}
	
	/**
	 * geter qui sort  un Objet
	 * @param line index du tableaux
	 * @return Materiel un objet 
	 */
	public Materiel getLigne(int line) {
		return liste.get(line);
	}
	
	
	
	
}