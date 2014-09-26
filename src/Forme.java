/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Forme.java
Date crÃ©Ã©: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pagé
2013-09-25 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class Forme {
	private final int noSequentiel;
	
	public Forme(int noSequentiel)
	{
		this.noSequentiel = noSequentiel;
	}

	/**
	 * 
	 * @return le numéro séquentiel de la forme
	 */
	public int getNoSequentiel() {
		return noSequentiel;
	}
	
	/**
	 * 
	 * @return la couleur de la forme
	 */
	public abstract Color getCouleur();
	
	/**
	 * 
	 * @param graphics objet à l'aide duquel on veut dessiner la forme
	 */
	public void dessiner(Graphics graphics)
	{
		graphics.setColor(getCouleur());
	}	
	
	/**
	 * 
	 * @return la hauteur et la largeur de la forme
	 */
	public abstract Dimension getTaille();
}
