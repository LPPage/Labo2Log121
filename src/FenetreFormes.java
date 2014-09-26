/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date cr√©√©: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Cette fen√™tre g√®re l'affichage des formes 
 * @author Patrice Boucher
 * @since 2013/05/04
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	
	private final FileDeFormes formes = new FileDeFormes(10);
	
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		//... 
	}
	
	/*
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics g){
		for(Forme forme : this.formes.getFormes())
		{
			if (forme != null)
			{
				forme.dessiner(g);
			}
		}
	}
	
	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit r√©server 
	 * l'espace n√©cessaire √† son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
	
	/**
	 * 
	 * @param forme la forme ‡ ajouter ‡ la file de formes pour Ítre Èventuellement dessinÈe
	 */
	public void ajouterForme(Forme forme)
	{
		this.formes.ajouter(forme);
		this.repaint();
	}
}
