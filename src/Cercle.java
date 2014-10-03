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

	public Cercle(int noSequentiel, int ordreReception, Point centre, int rayon) {
		super(noSequentiel, ordreReception, centre, rayon, rayon);
	}
	
	@Override
	public Double getAire() {
		// TODO Auto-generated method stub
		
		return Math.PI * this.getRayonH() * this.getRayonH();
	}

	@Override
	public Double getDistanceEntrePoints() {
		// TODO Auto-generated method stub
		return (double) this.getRayonH() *2;
	}
	
	@Override
	public Color getCouleur() {
		return Color.green;
	}
	
	@Override
	public int getTypeForme() {
		// TODO Auto-generated method stub
		return 3;
	}
}
