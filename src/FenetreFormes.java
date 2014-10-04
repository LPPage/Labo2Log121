/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
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
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
 * @since 2013/05/04
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	
	private ListeChainee formes = new ListeChainee();
	
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
		int index = 0;
		ItemListeChainee item = formes.getPremierItem();
		while (item != null)
		{
			Forme forme = item.getForme();
			if (forme != null)
			{
				if (formes.getComparateur().enDiagonale())
				{
					forme.dessiner(g, index++);
				}
				else
				{
					forme.dessiner(g);				
				}
			}
			item = item.getItemSuivant();
		}
	}
	
	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
	
	/**
	 * 
	 * @param forme la forme à ajouter à la file de formes pour étre éventuellement dessinée
	 */
	public void ajouterForme(Forme forme)
	{
		this.formes.ajouter(forme);
		this.repaint();
	}
	
	public void trierFormes(Comparateur comparateur)
	{
		this.formes = new ListeChainee(comparateur, formes);
		this.repaint();
	}
	
	public void supprimerFormes()
	{
		this.formes = new ListeChainee(formes.getComparateur());
		this.repaint();
	}
}
