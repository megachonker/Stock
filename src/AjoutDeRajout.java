import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * tout ça pour un vieux menu ...
 * @author The French Monster
 *
 */
public class AjoutDeRajout extends JFrame implements ActionListener{

	private JComboBox listeType,listeJour,listeMois,listeAnnee;
	private JTextField cpuID, taille,resolution;
	private JLabel cpuTitre, tailleTitre,resolutionTitre,wmsg,wwmsg,jmsg,mmsg,amsg;
	private Stock base;
	public AjoutDeRajout(Stock base){
		this.base = base;
		setTitle("Ajouter un  Materielle");
		//pack();
		setSize(320,240);
		//setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(true); //On permet le redimensionnement
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setContentPane(init());
	}
	
	private JButton boutonAjouter = new  JButton("Ajouter");
	private JButton boutonAnuler = new  JButton("Anuler") ;
	
/**
 *  premier layoute auquelle on va ajouter ou modifier des menu
 * @return Box return un element box des 3 menu
 */
public Box init() {
		//on fait la boite
		//panel.setLayout(new FlowLayout());
		//JPanel Ptype = new JPanel();
		//Ptype.setLayout(new BoxLayout(Ptype, BoxLayout.LINE_AXIS));		        
    Box Ptype = Box.createHorizontalBox();
    Box Ptypebis = Box.createHorizontalBox();
    wwmsg    = new JLabel("choisire le type de  materiel:  ");
    Ptypebis.add(wwmsg);

    
		//on  fait le premier menu
	    String[] type = {"materiel", "ordinateur", "video projecteur"};
		listeType = new JComboBox(type);
		Ptype.add(listeType);
		listeType.addActionListener(this);
		
	    Box Pdate = Box.createHorizontalBox();
	    Box Pdatebis = Box.createHorizontalBox();
		wmsg = new JLabel("saisire la date de  création:  ");
		Pdatebis.add(wmsg);
		//JPanel Pdate = new JPanel();
		//panel.setLayout(new FlowLayout());
		//Pdate.setLayout(new BoxLayout(Pdate, BoxLayout.LINE_AXIS));
		
		//jour
		String[] jour = new String[31];
		for(int i = 0; i  <jour.length;i++) {
			jour[i] = Integer.toString(i+1);
		}
		listeJour = new JComboBox(jour);
		listeJour.addActionListener(this);
		jmsg   = new JLabel("Jour:  ");
		Pdate.add(jmsg);
		Pdate.add(listeJour);

		
		//mois
		String[] mois = new String[12];
		for(int i = 0; i  <mois.length;i++) {
			mois[i] = Integer.toString(i+1);
		}
		mmsg   = new JLabel("Mois:  ");
		listeMois = new JComboBox(mois);
		listeMois.addActionListener(this);

		Pdate.add(mmsg);
		Pdate.add(listeMois);

		//annee
		String[] annee = new String[100];
		for(int i = 0; i <annee.length;i++) {
			annee[i] = Integer.toString(i+1951);
		}
		amsg  = new JLabel("Année:  ");
		listeAnnee = new JComboBox(annee);
		listeAnnee.setSelectedIndex(69);
		listeAnnee.addActionListener(this);

		Pdate.add(amsg);
		Pdate.add(listeAnnee);

		
	    Box Ptgl = Box.createHorizontalBox();

//		JPanel Ptgl = new JPanel();
	///	Ptgl.setLayout(new BoxLayout(Ptgl, BoxLayout.LINE_AXIS));		        
		
		//ajouter
		//boutonAjouter = new  JButton("Ajouter");
		Ptgl.add(boutonAjouter);
		boutonAjouter.addActionListener(this);

		//anuler
		//boutonAnuler = new  JButton("Anuler");
		Ptgl.add(boutonAnuler);
		boutonAnuler.addActionListener(this);
		 
		//JPanel panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));		        
	    Box panel = Box.createVerticalBox();
		
	    panel.add(Ptypebis);
		panel.add(Ptype);
		panel.add(Pdatebis);
		panel.add(Pdate);
		panel.add(Ptgl);
		return panel;
}
/**
 * en fonction de ce qu'a choisie l'user le menu  va se metre a jour tout soeul et afficher des champ a rempliere par l'user PERTINANT  en fc de la  selection
 * @param x
 */
	public void choix(int x){
		
		this.remove(boutonAjouter);
		this.remove(boutonAnuler);
		
		try{
			this.remove(resolution);
			this.remove(resolutionTitre);
			}
		catch(NullPointerException  e){

			}
		
		try {
			this.remove(taille);
			this.remove(tailleTitre);
			this.remove(cpuID);
			this.remove(cpuTitre);
		}
		catch(NullPointerException e) {
			
		}
		switch(x) {
		case 0:
			return;
		case 1:
			cpuID = new JTextField();
			cpuID.setPreferredSize(new Dimension(50, 25));
			cpuTitre = new JLabel("saisire cpu:  ");
			
			taille = new JTextField();
			taille.setPreferredSize(new Dimension(25, 25));
			tailleTitre = new JLabel("Taille en pouce:  ");
			this.add(tailleTitre);
			this.add(taille);
			this.add(cpuTitre);
			this.add(cpuID);

			return;
		case 2:
			resolution = new JTextField();
			resolution.setPreferredSize(new Dimension(75, 25));
			resolutionTitre = new JLabel("saisire la résolution:  ");
			this.add(resolutionTitre);
			this.add(resolution);
			return;
		}

		


	}

	public JTextField getResolution(){
		return resolution;
	}
	
	public JTextField getcpu(){
		return cpuID;
	}
	public JTextField getTaille(){
		return taille;
	}
	
	public JComboBox getlisteType(){
		return listeType;
	}
	
	public JComboBox getlisteJour(){
		return listeJour;
	}
	
	public JComboBox getlisteMois(){
		return listeMois;
	}
	public JComboBox getlisteAnnee(){
		return listeAnnee;
	}


	
	private int varTempon;
	@Override
	/**
	 * ce  qui va ecouter les input
	 */
	public void actionPerformed(ActionEvent e) {
		  Object sources = e.getSource();
		    if (sources instanceof JButton) {
				JButton source = (JButton) (e.getSource());

				if(source.getText().equals("Ajouter")) {
					
					if(JOptionPane.showConfirmDialog(
							this,
							"SUR ?",
							"ête vous sur de validée ?",
							JOptionPane.ERROR_MESSAGE)==0) {
						try {
						
						if(varTempon==0) {//getlisteType().getSelectedIndex()==0) {
							base.ajout(new Materiel(new Date(getlisteJour().getSelectedIndex()+1,getlisteMois().getSelectedIndex()+1,getlisteAnnee().getSelectedIndex()+1951)));
						}
						if(varTempon==1) {//getlisteType().getSelectedIndex()==1) {
							base.ajout(new Ordinateur(new Date(getlisteJour().getSelectedIndex()+1,getlisteMois().getSelectedIndex()+1,getlisteAnnee().getSelectedIndex()+1951),getcpu().getText(),getTaille().getText()));
						}
						if(varTempon==2) {//getlisteType().getSelectedIndex()==2) {
							base.ajout(new VideoProjecteur(new Date(getlisteJour().getSelectedIndex()+1,getlisteMois().getSelectedIndex()+1,getlisteAnnee().getSelectedIndex()+1951),getResolution().getText()));
						}
						
						}
						catch(IllegalArgumentException a) {
							JOptionPane.showMessageDialog(
									this,
									a.toString(),
									"Erreur  de saisie",
									JOptionPane.ERROR_MESSAGE);
						}
						
					}
				}
									
				if(source.getText().equals("Anuler")) {
					setVisible(false); //you can't see me!
					dispose(); //Destroy the JFrame object
				}
				
		    } else if (sources instanceof JComboBox) {
		    	JComboBox source = (JComboBox) (e.getSource());
		    	varTempon = listeType.getSelectedIndex();
		        choix(varTempon);

		        
				JPanel enBT = new JPanel();
				enBT.setLayout(new BoxLayout(enBT, BoxLayout.LINE_AXIS));		        
				//ajouter
				enBT.add(boutonAjouter);//panel.add(boutonAjouter,BorderLayout.SOUTH);
				//boutonAjouter.addActionListener(this);

				//anuler
				enBT.add(boutonAnuler);
				//boutonAnuler.addActionListener(this);

				this.add(enBT);
		    }

		    
	}


}
