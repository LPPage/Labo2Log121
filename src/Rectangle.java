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

	public Rectangle(int noSequentiel, Point point1, Point point2) {
		super(noSequentiel, point1, point2);
	}

	@Override
	public Color getCouleur() {
		return Color.cyan;
	}
	
	@Override
	public void dessiner(Graphics graphics, int index){
		super.dessiner(graphics, index);
		
		int x = this.getPoint1().x;
		int y = this.getPoint1().y;
		int largeur = this.getTaille().width;
		int hauteur = this.getTaille().height;
		if (x + largeur < 0){
			largeur = 0 - x;
		}
		if (y + hauteur < 0){
			hauteur = 0 - y;
		}
		int marge = 40 * index;
		
		graphics.fillRect(marge, marge, largeur, hauteur);
		
		super.dessinerContour(graphics, marge);
	}
}
