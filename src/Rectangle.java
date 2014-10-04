/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Rectangle.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pagé
2013-09-25 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Rectangle extends FormeADeuxCoordonnees {

	public Rectangle(int noSequentiel, int ordreReception, Point point1, Point point2) {
		super(noSequentiel, ordreReception, point1, point2);
	}

	@Override
	public Color getCouleur() {
		return Color.cyan;
	}
	
	@Override
	public Double getAire() {
		int largeur = this.getTaille().width;
		int hauteur = this.getTaille().height;

		return ((double)(largeur) * (double)(hauteur));
	}

	@Override
	public Double getDistanceEntrePoints() {
		Double distance = Math.sqrt(Math.pow((this.getPoint2().x -this.getPoint1().x),2)+Math.pow((this.getPoint2().y -this.getPoint1().y),2) );
		return distance;
	}

	@Override
	public int getTypeForme() {
		return 2;
	}

	@Override
	protected void onDessiner(Graphics graphics, Point coinHautGauche) {
		int largeur = this.getTaille().width;
		int hauteur = this.getTaille().height;
		graphics.fillRect(coinHautGauche.x, coinHautGauche.y, largeur, hauteur);
	}
}
