import javax.swing.event.*;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;



/**
 * Affichage d'une fenêtre avec un menu
 * @author Frédéric Drouhin et moi lol
 *
 */
public class GuiMateriel implements ActionListener  {

	JButton boutonadd;
	JButton boutonrm;
	JTable table;
	int returnVal;
	FileNameExtensionFilter filter = new FileNameExtensionFilter("db file", "db", "database");

	
	//Stock stoque = new Stock();
	public Stock stoque;
	String nameSauvgarde = "last.db";
	/**
	 * La fenêtre d'accès
	 */
	private JFrame frame = new JFrame("Interface de gestion de maériéel") ;
	
/**
 * je met une base de donner en parametre
 * @param db un stoque
 * @see Stock
 */
	public GuiMateriel(Stock db) {
		
		this.stoque = db;
		
		// ---------------------------------------------------------
		// Le menu avec fichier > ouvrir, un séparateur, quitter
		JMenuBar menuBar = new JMenuBar() ;
	
		// Le menu fichier
		JMenu fichier = new JMenu("Fichier") ;
		
		
		// Le menu fichier
		//JMenu add = new JMenu("+") ;

		
		
		// ouvrir
		JMenuItem ouvrir = new JMenuItem("Ouvrir", KeyEvent.VK_O) ; 
		ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK)) ; // raccourci clavier
		ouvrir.addActionListener(this); // pour gérer l'évenement de choix de l'action (voir la méthode actionPerformed)

		
		// sauvgarder
		JMenuItem sauvgarde = new JMenuItem("sauvgarde", KeyEvent.VK_S) ; 
		sauvgarde.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)) ; // raccourci clavier
		sauvgarde.addActionListener(this); // pour gérer l'évenement de choix de l'action (voir la méthode actionPerformed)
		
		// sauvgarder
		JMenuItem sauvgarderSous = new JMenuItem("sauvgarderSous...", KeyEvent.VK_S) ; 
		sauvgarderSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK)) ; // raccourci clavier
		sauvgarderSous.addActionListener(this); // pour gérer l'évenement de choix de l'action (voir la méthode actionPerformed)	
		
		// quitter
		JMenuItem quitter = new JMenuItem("Quitter", KeyEvent.VK_Q) ;
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK)) ;
		quitter.addActionListener(this);
		
		

		fichier.add(ouvrir) ;
		fichier.addSeparator();
		fichier.add(sauvgarde) ;
		fichier.add(sauvgarderSous) ;
		fichier.addSeparator();
		fichier.add(quitter) ;
		menuBar.add(fichier) ;
		//menuBar.add(boutonadd);
		//menuBar.add(boutonrm);

		
		frame.setJMenuBar(menuBar);
		
		//------------------------------------------------------------------
		//bouton ajout

				boutonadd = new JButton("+");
				boutonadd.addActionListener(this);
				menuBar.add(boutonadd);

				
		//------------------------------------------------------------------
		//bouton rm

				boutonrm = new JButton("-");
				boutonrm.addActionListener(this);
				menuBar.add(boutonrm);

				
		
		
		// ----------------------------------------------------------
		// Ajout d'une table
		JPanel panel = new JPanel(new GridLayout(1,0));

		TableMateriel model = new TableMateriel(stoque); // stock c'est un stock de matériel et TableMateriel est une classe héritée de AbstractTableModel
		model.fireTableDataChanged();
		table = new JTable(model) ;
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane) ;
		frame.add(panel) ;


		 
		// ----------------------------------------------------------
		// Lorsque l'on clique sur la croix
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int dialogResult = JOptionPane.showConfirmDialog(frame, "Voulez-vous quitter ?", "Quitter ?", JOptionPane.YES_NO_OPTION);
				if(dialogResult == 0) {
					System.exit(0) ;
				}
			}
		});
	}
	

	/**
	 * methode pour  l'afichage de la fenetre
	 */
	public void display() {
		//frame.pack();
		frame.setSize(500, 300); // ou vous pouvez utiliser la méthode pack qui met la dimension en fonction des composants
		frame.setVisible(true) ;
		
	}
	

	
	
	/**
	 * Gestion des événements sur le menu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//JMenuItem source = (JMenuItem) (e.getSource());
		//JButton source1 = (JButton) (e.getSource());

		  Object sources = e.getSource();
		    if (sources instanceof JButton) {
		    	
				JButton source = (JButton) (e.getSource());
				
				if (source.getText().equals("+")) {
					AjoutDeRajout test = new AjoutDeRajout(stoque);
					test.setVisible(true);

				}

				if (source.getText().equals("-")) {
					stoque.supression((stoque.getLigne(table.getSelectedRow()).serialNumber));
					System.out.println(table.getSelectedRow());
				}
		    
		    
		    } else if (sources instanceof JMenuItem) {
				JMenuItem source = (JMenuItem) (e.getSource());

				if (source.getText().equals("sauvgarde")) {
					try {
						stoque.save(nameSauvgarde);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				if (source.getText().equals("sauvgarderSous...")) {
					final JFileChooser sv = new JFileChooser(".");
					sv.setDialogTitle("Specify a file to save");
					sv.setFileFilter(filter);
					returnVal = sv.showOpenDialog(sv);
					nameSauvgarde = sv.getSelectedFile().getName().toString();
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			        	try {
							stoque.save(nameSauvgarde);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        }
				}

				
				if (source.getText().equals("Ouvrir")) {

					final JFileChooser fc = new JFileChooser(".");
					fc.setDialogTitle("Quoi charger ?");   
					fc.setFileFilter(filter);
					returnVal = fc.showOpenDialog(fc);
					
			        if (returnVal == JFileChooser.APPROVE_OPTION) {

			            
						if(JOptionPane.showConfirmDialog(
								frame,
								"SUR ?",
								"�te vous sur de charger ?",
								JOptionPane.ERROR_MESSAGE)==0) {
							
								try {
									stoque.loadwrite(fc.getSelectedFile().getName().toString());
									stoque.toString();

									JOptionPane.showMessageDialog(
											frame,
											"Nice",
											"base charger",
											JOptionPane.INFORMATION_MESSAGE);
									
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									JOptionPane.showMessageDialog(
											frame,
											"Erreur",
											e1.toString(),
											JOptionPane.ERROR_MESSAGE);
								}
						}
			        }
					

				}
				else if (source.getText().equals("Quitter")) {

					int dialogResult = JOptionPane.showConfirmDialog(frame, "Voulez-vous quitter ?", "Quitter ?", JOptionPane.YES_NO_OPTION);
					if(dialogResult == 0) {
						System.exit(0) ;
					}
				}		    }

		
		
	}


	

	/**
	 * Le main avec une thread pour l'interface
	 * @param args des argument
	 */
	public static void main(String[] args) {
		Stock stoque1 = new Stock();
		try {
			stoque1.loadwrite("b.db");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GuiMateriel(stoque1).display() ;
			}
		});

	}

}
