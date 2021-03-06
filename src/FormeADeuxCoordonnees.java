/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FormeADeuxCoordonnees.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pagé
2013-09-25 Version initiale
*******************************************************/  

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class FormeADeuxCoordonnees extends Forme {
	private final Point point1, point2;
	
	@Override
	public Point getCoinHautGauche()
	{
		return new Point(Math.min(point1.x, point2.x), Math.min(point1.y, point2.y));
	}
	
	public FormeADeuxCoordonnees(int noSequentiel, int ordreReception, Point point1, Point point2) {
		super(noSequentiel, ordreReception);
		this.point1 = point1;
		this.point2 = point2;
	}

	/**
	 * 
	 * @return le premier point de la forme
	 */
	public Point getPoint1() {
		return point1;
	}

	/**
	 * 
	 * @return le deuxieme point de la forme
	 */
	public Point getPoint2() {
		return point2;
	}
	
	@Override
	public Dimension getTaille() {
		int largeur = Math.abs((int)(getPoint2().x - getPoint1().x));
		int hauteur = Math.abs((int)(getPoint2().y - getPoint1().y));
		
		return new Dimension(largeur, hauteur);
	}
}
