/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Carre.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pag�
2013-09-25 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.Point;

public class Carre extends Rectangle {

	public Carre(int noSequentiel, Point point1, Point point2) {
		super(noSequentiel, point1, point2);
	}
	
	@Override
	public Color getCouleur() {
		return Color.blue;
	}
}