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
		return new Color(255, 168, 64, 128);
	}

	@Override
	public Double getAire() {
		return 0.0 ;
	}

	@Override
	public Double getDistanceEntrePoints() {
		Double distance = Math.sqrt(Math.pow((this.getPoint2().x -this.getPoint1().x),2)+Math.pow((this.getPoint2().y -this.getPoint1().y),2) );
		return distance;
	}

	@Override
	public int getTypeForme() {
		return 5;
	}

	@Override
	protected void onDessiner(Graphics graphics, Point coinHautGauche) {
		int x1, x2, y1, y2;
		int largeur = this.getTaille().width;
		int hauteur = this.getTaille().height;
		
		if (this.getPoint1().x > this.getPoint2().x)
		{
			x1 = coinHautGauche.x + largeur;
			x2 = coinHautGauche.x;
		}
		else{
			x1 = coinHautGauche.x;
			x2 = coinHautGauche.x + largeur;			
		}
		if (this.getPoint1().y > this.getPoint2().y)
		{
			y1 = coinHautGauche.y + hauteur;
			y2 = coinHautGauche.y;
		}
		else
		{
			y1 = coinHautGauche.y;
			y2 = coinHautGauche.y + hauteur;			
		}	
				
		graphics.drawLine(x1, y1, x2, y2);
	}
}
