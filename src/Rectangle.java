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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.colorchooser.ColorSelectionModel;


public class Rectangle extends FormeADeuxCoordonnees {

	public Rectangle(int noSequentiel, int ordreReception, Point point1, Point point2) {
		super(noSequentiel, ordreReception, point1, point2);
	}

	@Override
	public Color getCouleur() {
		return new Color(64, 192, 255, 128);
	}
	
	@Override
	public void dessiner(Graphics graphics, int index){
		super.dessiner(graphics, index);
		
		int x = this.getPoint1().x;
		int y = this.getPoint1().y;
		Dimension taille = this.getTaille();
		int largeur = taille.width;
		int hauteur = taille.height;
		if (x + (getPoint2().x - getPoint1().x) < 0){
			largeur = 0 - x;
		}
		if (y + (getPoint2().y - getPoint1().y) < 0){
			hauteur = 0 - y;
		}
		int marge = 40 * index;
		
		graphics.fillRect(marge, marge, largeur, hauteur);
		
		super.dessinerContour(graphics, marge);
	}

	@Override
	public Double getAire() {
		// TODO Auto-generated method stub
		int largeur = this.getTaille().width;
		int hauteur = this.getTaille().height;

		return ((double)(largeur) * (double)(hauteur));
	}

	@Override
	public Double getDistanceEntrePoints() {
		// TODO Auto-generated method stub
		Double distance = Math.sqrt(Math.pow((this.getPoint2().x -this.getPoint1().x),2)+Math.pow((this.getPoint2().y -this.getPoint1().y),2) );
		return distance;
	}
}
