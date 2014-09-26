/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Ligne.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pag�
2013-09-25 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Ligne extends FormeADeuxCoordonnees {

	public Ligne(int noSequentiel, Point point1, Point point2) {
		super(noSequentiel, point1, point2);
	}

	@Override
	public Color getCouleur() {
		return Color.orange;
	}
	
	@Override
	public void dessiner(Graphics graphics){
		super.dessiner(graphics);
		
		int x1 = this.getPoint1().x;
		int y1 = this.getPoint1().y;
		int x2 = this.getPoint2().x;
		int y2 = this.getPoint2().y;
		
		graphics.drawLine(x1, y1, x2, y2);
	}
}
