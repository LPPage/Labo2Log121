/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Cercle.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pagé
2013-09-25 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.Point;


public class Cercle extends Ovale {

	public Cercle(int noSequentiel, Point centre, int rayon) {
		super(noSequentiel, centre, rayon, rayon);
	}
	
	@Override
	public Color getCouleur() {
		return Color.green;
	}
}
