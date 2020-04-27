import java.io.Serializable;

public class Date  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8110643975203500037L;
	private int jour,mois,annee;
	

	/**
	 * Constructeur de Date avec des  INTEGER
	 * 
	 * @param jour jour 
	 * @param mois mois
	 * @param annee année
	 * @throws IllegalArgumentException au cas ou l'user fait de la merde 
	 * @see verification
	 */
	public Date(int jour, int mois, int annee) throws IllegalArgumentException {
	      this.jour = jour ;
	      this.mois = mois ;
	      this.annee = annee ;
	      if (!verification()) throw new IllegalArgumentException("Valeurs incohérentes") ;
	}
	
	/**
	 * Constructeur de Date avec des String au  cas ou ^^'
	 * 
	 * @param jour jour 
	 * @param mois mois
	 * @param annee année
	 * @throws IllegalArgumentException au cas ou l'user fait de la merde 
	 * @see verification
	 */
	public Date(String jour,String mois,int annee)  throws IllegalArgumentException {
	      this.jour = Integer.parseInt(jour);
	      this.mois = Integer.parseInt(mois);
	      this.annee = annee;
	      if (!verification()) throw new IllegalArgumentException("Valeurs incohérentes") ;
	}
	
	/**
	 * classe qui verifie que la date est logique genr 31 jour par mois 12 mois et +-100ans
	 * @return
	 */
	private boolean verification() {
		if(!(this.jour <= 31 && this.jour > 0)) {
			return false;
		}
		if(!(this.mois <= 12 && this.mois > 0)) {
			return false;
		}
		if(!(this.annee <= 2500 && this.annee >= 1950)) {
			return false;
		}
		return true;
	}
	
	/**
	 * getter 
	 * @return jour
	 */
	public int getJour() {
		return this.jour;
	}
	/**
	 * getter 
	 * @return mois
	 */
	public int getMois() {
		return this.mois;
	}
	/**
	 * getter 
	 * @return anner
	 */
	public int getAnnee() {
		return this.annee;
	}
	
	/**
	 * to string qui met en forme joliement la date
	 */
	public String toString(){
		return jour+"/"+mois+"/"+annee;
	}
	
	/**
	 * verifie  que la date de la classe est plus grande que celle cibler
	 * @see Date
	 * @param dateAcomparer date que l'on  veux  comparer
	 * @return true si ces  bon false si pas bon
	 */
	public boolean  plusVieuxQue(Date dateAcomparer) {
		if(!(this.annee <= dateAcomparer.annee)) {
			//System.out.println(this.annee+"<="+dateAcomparer.annee+"CES FALSE ANNE");
			return  false;
		}
		if(this.annee == dateAcomparer.annee){
			if(!(this.mois <= dateAcomparer.mois)) {
				//System.out.println(this.mois+"<="+dateAcomparer.mois+"CES FALSE mois");
				return  false;
			}
			if(this.mois == dateAcomparer.mois) {
				if(!(this.jour <= dateAcomparer.jour)) {
					//System.out.println(this.jour+"<="+dateAcomparer.jour+"CES FALSE jour");

					return  false;
				}
			}
		}
		return true;
	}
	
}
