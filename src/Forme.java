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
import java.awt.Point;
import java.awt.Stroke;

public abstract class Forme {
	public static final int DECALAGE_DIAGONAL = 40;
	
	private final int noSequentiel;
	private final int ordreReception;
	public abstract Point getCoinHautGauche();
	
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

	public final void dessiner(Graphics graphics, int index)
	{
		int marge = DECALAGE_DIAGONAL * index;
		dessiner(graphics, new Point(marge, marge));
	}
	
	public final void dessiner(Graphics graphics)
	{
		dessiner(graphics, this.getCoinHautGauche());
	}
	
	private final void dessiner(Graphics graphics, Point coinHautGauche)
	{
		graphics.setColor(getCouleur());
		onDessiner(graphics, coinHautGauche);
		dessinerContour(graphics, coinHautGauche);
	}
	
	protected abstract void onDessiner(Graphics graphics, Point coinHautGauche);
	
	private void dessinerContour(Graphics graphics, Point coinHautGauche)
	{
		Graphics2D graphics2D = (Graphics2D)graphics;
		int largeurContour = getTaille().width;
		int hauteurContour = getTaille().height;
		graphics2D.setColor(Color.BLACK);
		graphics2D.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1F, new float[] {2f}, 0f));
		graphics2D.drawRect(coinHautGauche.x, coinHautGauche.y, largeurContour, hauteurContour);
		graphics2D.setStroke(new BasicStroke());
	}

	/**
	 * 
	 * @return la hauteur et la largeur de la forme
	 */
	public abstract Dimension getTaille();

	public abstract int getTypeForme();
	
	public abstract Double getAire();

	public abstract Double getDistanceEntrePoints();

	public int getOrdreReception() {
		return ordreReception;
	}
}
