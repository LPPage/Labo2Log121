/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Ovale.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pag�
2013-09-25 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Ovale extends Forme {

	private final Point centre;
	private final int rayonH, rayonV;
	
	public Ovale(int noSequentiel, Point centre, int rayonH, int rayonV) {
		super(noSequentiel);
		this.centre = centre;
		this.rayonH = rayonH;
		this.rayonV = rayonV;		
	}

	public Point getCentre() {
		return centre;
	}

	public int getRayonH() {
		return rayonH;
	}

	public int getRayonV() {
		return rayonV;
	}

	@Override
	public Color getCouleur() {
		return Color.magenta;
	}
	
	@Override
	public Dimension getTaille() {
		return new Dimension(2 * rayonH, 2 * rayonV);
	}
	
	@Override
	public void dessiner(Graphics graphics){
		super.dessiner(graphics);
		
		int x = this.getCentre().x;
		int y = this.getCentre().y;
		int largeur = this.getTaille().width;
		int hauteur = this.getTaille().height;
		
		graphics.fillOval(x, y, largeur, hauteur);
	}
}
