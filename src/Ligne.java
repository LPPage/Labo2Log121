/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Ligne.java
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

public class Ligne extends FormeADeuxCoordonnees {

	public Ligne(int noSequentiel, int ordreReception, Point point1, Point point2) {
		super(noSequentiel, ordreReception, point1, point2);
	}

	@Override
	public Color getCouleur() {
		return Color.orange;
	}
	
	@Override
	public void dessiner(Graphics graphics, int index){
		super.dessiner(graphics, index);		
		int marge = 40 * index;
		int x1, x2, y1, y2;
		int largeur = this.getTaille().width;
		int hauteur = this.getTaille().height;
		
		if (largeur < 0){
			x1 = marge - largeur;
			x2 = marge;
		}else{
			x1 = marge;
			x2 = marge + largeur;			
		}
		if (hauteur < 0){
			y1 = marge - hauteur;
			y2 = marge;
		}else{
			y1 = marge;
			y2 = marge + hauteur;			
		}
		
		
		graphics.drawLine(x1, y1, x2, y2);
		super.dessinerContour(graphics, marge);
	}
}
