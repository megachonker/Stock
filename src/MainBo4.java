import java.io.IOException;
import java.util.ArrayList;

public class MainBo4 {

	public static void main(String[] args) throws Exception {

		/*
		Ordinateur pc1 = new Ordinateur(new Date("02","02",2005),2,"14'","Pentium4");
		System.out.println(pc1.toString());	
		Ordinateur pc2 = new Ordinateur(new Date(8,8,2007),4,"15'","AspirateurAproton");
		System.out.println(pc2.toString());	
		Ordinateur pc3 = new Ordinateur(new Date(11,1,2008),5,"17'","Optiognion");
		System.out.println(pc3.toString());	
		*/
		
		/*
		VideoProjecteur projecteur1 = new VideoProjecteur(new Date(1,1,2005),1,"800x600");
		System.out.println(projecteur1.toString());	
		*/
		
		/*
		ArrayList<Materiel> liste = new ArrayList<Materiel>();
		liste.add(new VideoProjecteur(new Date(1,1,2005),1,"800x600"));
		liste.add(new Ordinateur(new Date("02","02",2005),2,"14'","Pentium4"));
		liste.add(new VideoProjecteur(new Date(7,7,2007),3,"800x600"));
		liste.add(new Ordinateur(new Date(8,8,2007),4,"15'","AspirateurAproton"));
		liste.add(new Ordinateur(new Date(11,1,2008),5,"17'","Optiognion"));

			
		for(int u = 0; u<liste.size();u++) {
			System.out.println(liste.get(u).toString());
		}
		*/
		/*
		Ordinateur pc1 = new Ordinateur(new Date("02","02",2005),2,"14'","Pentium4");
		System.out.println(pc1.toString());	
	
		System.out.println(pc1.pretDate(new Date(9,4,2019)));
		System.out.println(pc1.toString());	
		
		pc1.pretDate();
		System.out.println(pc1.toString());	
		
		pc1.release();
		System.out.println(pc1.toString());	
		*/
		Stock aled = new Stock();
		aled.ajout(new Ordinateur(new Date("02","02",2005),2,"14'","Pentium4"));
		aled.ajout(new Ordinateur(new Date(8,8,2007),4,"15'","AspirateurAproton"));
		aled.ajout(new VideoProjecteur(new Date(7,7,2007),3,"800x600"));

		aled.save("azer");
		
		System.out.println("apres trie:");
		aled.sort();
		aled.toString();
		
		System.out.println("apres relecture:");
		aled.loadwrite("azer");
		aled.toString();
		
		System.out.println(aled.recherche(2).pretDate(10,10,2022));
		System.out.println(aled.recherche(2).release());

		aled.toString();
		
		Stock a = new Stock();
		a.ajout(new Ordinateur(new Date("02","02",2005),2,"14'","Pentium4"));
		a.ajout(new Ordinateur(new Date(8,8,2007),4,"15'","AspirateurAproton"));
		a.ajout(new VideoProjecteur(new Date(7,7,2007),3,"800x600"));

		Stock b = new Stock();
		b.ajout(new Ordinateur(new Date("12","05",2008),2,"10'","Pentium48"));
		b.ajout(new Ordinateur(new Date(8,8,2010),5,"12'","Aspirateur"));

		Stock c = new Stock();
		c.ajout(new Materiel(new Date("12","05",2008),2));
		c.ajout(new Ordinateur(new Date(1,1,2012),1,"4k'","ALLEEED"));
		c.ajout(new VideoProjecteur(new Date(7,7,2010),1,"1920x1080"));

		
		a.save("a.db");
		b.save("b.db");
		c.save("c.db");
	}

}
