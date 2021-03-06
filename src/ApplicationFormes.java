/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: ApplicationFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  
 

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Cette classe représente l'application dans son ensemble. 
 * @author Patrice Boucher
 * @since 2013/05/04
 */
public class ApplicationFormes{	
	/**
	 * main de l'application
	 * @param args
	 */
	public static void main(String[] args) {
		new ApplicationFormes();
	}
	
	/**
	 * Constructeur
	 */
	public ApplicationFormes(){
		final CommBase comm = new CommBase();
		
		FenetrePrincipale fenetre = new FenetrePrincipale(comm);
		if (!fenetre.demanderAdresse())
		{
			System.exit(0);
		}
		fenetre.setVisible(true);
		
		fenetre.addWindowListener(new WindowAdapter(){
			@Override
		    public void windowClosing(WindowEvent e) {
				comm.stop();
			}
		});	
		
		comm.setPropertyChangeListener(fenetre);
	}
}
