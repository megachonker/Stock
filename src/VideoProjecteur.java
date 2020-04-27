
public class VideoProjecteur extends Materiel {
	
	private String resolution;
	/**
	 * constructeur du projecteur sans SEREAL numbers
	 * @param dateAchat date d'achat
	 * @param resolution resolution genr 1920x1080
	 */
	public VideoProjecteur(Date dateAchat, String resolution) {
		super(dateAchat);
		this.resolution = resolution; 
		
	}
	/**
	 * comme dessu mais avec Un  sereal number
	 * @param dateAchat date
	 * @param serialNumber serie
	 * @param resolution resolution
	 * @throws IllegalArgumentException fait remonter l'erreeur
	 * @see Date
	 */
	public VideoProjecteur(Date dateAchat, int serialNumber, String resolution) throws IllegalArgumentException {
		super(dateAchat, serialNumber);
		this.resolution = resolution; 
	}

	/**
	 * to string qui utilise celuit de materiel
	 * @see Materiel matos
	 * @see toString to string
	 * @return un jolie message
	 */
	public String toString() {
		return "VidéoProjecteur qui une resolution de "+this.resolution +" "+ super.toString();
	}

}