/**
 * 
 * @author The French Monster 
 * <p> classe ordinateur qui est heriter de materiel </p>
 * @see Materiel
 */
public class Ordinateur extends Materiel{
	private String tailleEcrant, cpu;

	/**
	 * constructeur de Ordinateur Sans numero de serie 
	 * @param dateAchat la date dachat
	 * @param tailleEcrant size screen
	 * @param cpu cpu brand
	 * @see Date
	 */
	public Ordinateur(Date dateAchat,String tailleEcrant, String cpu) {
		super(dateAchat);
		this.tailleEcrant = tailleEcrant;
		this.cpu = cpu;
	}

	/**
	 *  meme que au  dessu mais avec Numero de serie 
	 * @param dateAchat la date
	 * @param serialNumber numero de serie defini
	 * @param tailleEcrant taille de l'écrant 
	 * @param cpu cpu brand
	 * @throws IllegalArgumentException jsp
	 */
	public Ordinateur(Date dateAchat, int serialNumber,String tailleEcrant, String cpu) throws IllegalArgumentException {
		super(dateAchat, serialNumber);
		this.tailleEcrant = tailleEcrant;
		this.cpu = cpu;
	}
	

	/**
	 * to string qui fait un super du string de Materiel affint d'ajouter des info de la classe actuelle.
	 * voir Materiel.toString
	 * @return String message a  afficher
	 */
	public String toString() {
		return "Ordinateur qui a un écrant de "+this.tailleEcrant + " comme cpu CPU : "+cpu+" "+ super.toString();
	}
	


}
