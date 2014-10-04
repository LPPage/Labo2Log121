/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: Ovale.java
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

public class Ovale extends Forme {

	private final Point centre;
	private final int rayonH, rayonV;
	
	public Ovale(int noSequentiel, int ordreReception, Point centre, int rayonH, int rayonV) {
		super(noSequentiel, ordreReception);
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
	public Double getAire() {
		return Math.PI * rayonH*rayonV;
	}

	@Override
	public Double getDistanceEntrePoints() {
		double distance;
		if(rayonH > rayonV)
		{
			distance = rayonH*2;
		}
		else
		{
			distance = rayonV*2;
		}
		return distance;
	}

	@Override
	public int getTypeForme() {
		return 4;
	}

	@Override
	public Point getCoinHautGauche() {
		return new Point(centre.x - rayonH, centre.y - rayonV);
	}

	@Override
	protected void onDessiner(Graphics graphics, Point coinHautGauche) {
		int largeur = this.getTaille().width;
		int hauteur = this.getTaille().height;
		
		graphics.fillOval(coinHautGauche.x, coinHautGauche.y, largeur, hauteur);
	}
}
