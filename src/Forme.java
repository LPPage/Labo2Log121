/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Forme.java
Date crÃ©Ã©: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre PagÃ©
2013-09-25 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class Forme {
	private final int noSequentiel;
	private final int ordreReception;
	
	public Forme(int noSequentiel, int ordreReception)
	{
		this.noSequentiel = noSequentiel;
		this.ordreReception = ordreReception;
	}

	/**
	 * 
	 * @return le numÃ©ro sÃ©quentiel de la forme
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
	 * @param graphics objet Ã  l'aide duquel on veut dessiner la forme
	 */
	public void dessiner(Graphics graphics, int index)
	{		
		graphics.setColor(getCouleur());		
	}
	
	public void dessinerContour(Graphics graphics, int marge)
	{
		int largeurContour = getTaille().width;
		int hauteurContour = getTaille().height;
		if (largeurContour < 0){
			largeurContour = 0 - largeurContour;
		}
		if (hauteurContour < 0){
			hauteurContour = 0 - hauteurContour;
		}
		graphics.setColor(Color.BLACK);//pas terminÃ©
		graphics.drawRect(marge, marge, largeurContour, hauteurContour);		
	}
	
	/**
	 * 
	 * @return la hauteur et la largeur de la forme
	 */
	public abstract Dimension getTaille();

	public abstract Double getAire();
	
	public abstract Double getDistanceEntrePoints();
	
	public int getOrdreReception() {
		return ordreReception;
	}
}
