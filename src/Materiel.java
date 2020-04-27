import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;

//import java.util.Random;


public class Materiel implements Serializable{
	//forcer de metre une id
	private static final long serialVersionUID = 1919400705304258435L;
	
	protected Date dateAchat, datePret = null;
	protected int serialNumber;
	private boolean status  = false;
	protected static int ID = 1 ;

	private Date dateHDJ;


	/**
	 * Constructeur de Materiel
	 *
	 * <p>avec  la date et le numero de serie</p>
	 * 
	 * @param dateAchat date de l'achat
	 * @param serialNumber numero de serire
	 * @throws IllegalArgumentException verification que le materiel ajouter ne soit pas  ajouter  a une  date future
	 */
	public Materiel(Date dateAchat, int serialNumber) throws IllegalArgumentException {
		this.dateAchat = dateAchat;
		this.serialNumber = serialNumber;
		if (!(serialNumber > 0))  throw new IllegalArgumentException("Valeurs incohérentes (serial number negatif)") ;

		refreshDATE();
		if((dateHDJ.plusVieuxQue(dateAchat))) throw new IllegalArgumentException("date de création ulterieure a date actuel");
	}
	
	/**
	 * constructeur qui genera tout soeul id
	 * @see refreshDATE
	 * @param dateAchat date de  l'achat
	 * @throws IllegalArgumentException verification que le materiel ajouter ne soit pas  ajouter  a une  date future
	 */
	public Materiel(Date dateAchat) {
		this.dateAchat = dateAchat;
		this.serialNumber = ID ;
		ID = ID + 1 ;
		refreshDATE();
		if((dateHDJ.plusVieuxQue(dateAchat))) throw new IllegalArgumentException("date de création ulterieure a date actuel");
	}

	

	
	/**
	 * Seter
	 * @param datePret date
	 * @return true
	 */
	public boolean setDatePret(Date datePret) {
		this.datePret = datePret;
		return true;
	}

	
	/**
	 * methode to string qui sert de base pour les heritage
	 * @see Ordinateur
	 * @see Materiel
	 * @see VideoProjecteur
	 * @return variable qui contien le texte generer
	 */
	public String toString() {
		
		String temp = "item acheter le: "+dateAchat.toString()+" status: ";
		
		if(this.datePret != null) {temp += "Indisponible j'usquaux "+datePret.toString();}
		else {temp += "Disponible";}

		temp += ", Serial: "+Integer.toString(serialNumber);

		
		//status =  true;
		
		return temp;
	}
	
	
	//astuce du  chef ISSOU
	/**
	 * Fonction qui Ajoute une date d'emprunte
	 * @param dateDuPret de type date
	 * @see Date
	 * @return True pour dire que ça marche ou False pour dire qu'il y a une erreur
	 */
	public boolean pretDate(Date dateDuPret){
		/**
		 * refresh aubligatoire
		 */
		refreshDATE();
		/**
		 * on test que la date du pateriel existant est plus ancienne que le pret
		 * @see  plusVieuxQue
		 */
		if(dateHDJ.plusVieuxQue(dateDuPret) && this.status == false) { ///FLM DE  TESTEr
			this.datePret = dateDuPret;
			status =  true;
			return  true;
		}

		return false;	

	}
	/**
	 * meme  fonction que celle cis dessu  mais  prenant les atribut qui von faire une date ce qui grapille des caractere
	 * 
	 * @param jour le jour
	 * @param mois le mois
	 * @param annee l'année
	 * @return vrais  faut en fonction de la réusite
	 */
	public boolean pretDate(int  jour , int mois,int annee){
		refreshDATE();

		if(dateHDJ.plusVieuxQue(new Date(jour , mois ,annee)) && status == false ) {
			this.datePret = new Date(jour , mois ,annee);
			status =  true;
			return true;
		}
		return false;
	}
	//JELEVEUXMAINTENEANT
	
	/**
	 * JELEVEUXMAINTENEANT
	 * 
	 * va effectuer un prèt de livre en fonction de  la date actuel ^^'
	 * 
	 * @see dateHDJ
	 * @return true
	 */
	public boolean pretDate(){
		
		/*
		 * OLD
		//je copie colle allegrement ce que  l'on me donne en anexe

		a.get(Calendar.DAY_OF_MONTH);
		int jour = a.get(Calendar.DAY_OF_MONTH);
		int mois = a.get(Calendar.MONTH)+1 ;
		int annee = a.get(Calendar.YEAR) ;
		
		this.datePret = new Date(jour , mois ,annee);
		*/
		
		//version plus gracieuse
		
		refreshDATE();
		this.datePret = dateHDJ;
		status =  true;
		return true;	
	}
	
	/**
	 * fonction qui permet de metre a 0 la date  d'emprunt et met a jour le status
	 * @see status
	 * @return true pour pas d'erreur
	 */
	public boolean release() {
		
		status =  false;
		this.datePret = null;
		
		return true;
	}
	/**
	 * Fonction qui rafraichit la date en la plasant  dans dateHDJ a la date de hdj, a savoir qu'elle n'es pas initialiser dans init elle est utiliser a chaque foit que l'on veux  la date car de ansde vrais logiciel genr conta gestion le soft peut rester ouver plusiuer joure donc ces pour être  sur ^^'
	 * @see dateHD
	 * 
	 */
	private void refreshDATE() {
		
		//je copie colle allegrement ce que  l'on me donne en anexe
		Calendar a = Calendar.getInstance() ;
		a.get(Calendar.DAY_OF_MONTH);
		int jour = a.get(Calendar.DAY_OF_MONTH);
		int mois = a.get(Calendar.MONTH)+1 ;
		int annee = a.get(Calendar.YEAR) ;
		
		dateHDJ = new Date(jour , mois ,annee);
	}
	
	
	
	
}
/**
 * 
 * @author The French Monster Ces le noms du pc ^^'
 * <p>cecis sert a faire des comparaison pour faire du trie  elle compare le poid</p>
 * @see Stock
 */
class Comparaison implements Comparator<Materiel>{

	@Override
	public int compare(Materiel arg0, Materiel arg1) {
		// TODO Auto-generated method stub
		return arg0.serialNumber- arg1.serialNumber;
	}

	

}