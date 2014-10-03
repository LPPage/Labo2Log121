/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Forme.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Louis-Pierre Pagé
2013-09-25 Version initiale
 *******************************************************/  

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

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
	public void dessiner(Graphics graphics, int index)
	{		
		graphics.setColor(getCouleur());		
	}

	public void dessinerContour(Graphics graphics, int marge)
	{
		int largeurContour = getTaille().width;
		int hauteurContour = getTaille().height;
		graphics.setColor(Color.BLACK);//pas terminé
		Graphics2D graphics2D = (Graphics2D)graphics;
		graphics2D.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1F, new float[] {2f}, 0f));
		graphics2D.drawRect(marge, marge, largeurContour, hauteurContour);
		graphics2D.setStroke(new BasicStroke());
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
