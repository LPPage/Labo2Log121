/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CreateurForme.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pagé
2013-09-25 Version initiale
*******************************************************/
import java.awt.Point;

public class CreateurFormes {
	
	private static String[] formesADeuxCoordonnees = {"CARRE", "RECTANGLE", "LIGNE"};
	
	/**
	 * 
	 * @param chaineForme la chaine décrivant une forme provenant du serveur
	 * @return une sous-classe de la classe Forme aux bonnes dimensions
	 */
	public Forme creerForme(String chaineForme) {
		DecodeurForme decodeur = new DecodeurForme(chaineForme);
		int noSeq = decodeur.getNoSeq();
		int[] parametres = decodeur.getParametres();	
		
		boolean isFormeADeuxCoordonnees = false;
		for(String forme : formesADeuxCoordonnees)
		{
			isFormeADeuxCoordonnees |= forme.equals(decodeur.getTypeForme());
		}	
		
		if (isFormeADeuxCoordonnees)
		{
			int x1 = parametres[0];
			int y1 = parametres[1];
			int x2 = parametres[2];
			int y2 = parametres[3];
			Point point1 = new Point(x1, y1);
			Point point2 = new Point(x2, y2);
			
			switch(decodeur.getTypeForme())
			{
			case "CARRE":
				return new Carre(noSeq, point1, point2);
			case "RECTANGLE":
				return new Rectangle(noSeq, point1, point2);
			case "LIGNE":
				return new Ligne(noSeq, point1, point2);
			}		
		}
		else
		{
			int centreX = parametres[0];
			int centreY = parametres[1];
			Point centre = new Point(centreX, centreY);
			
			switch(decodeur.getTypeForme())
			{
			case "CERCLE":
				int rayon = parametres[2];
				return new Cercle(noSeq, centre, rayon);
			case "OVALE":
				int rayonH = parametres[2];
				int rayonV = parametres[3];
				return new Ovale(noSeq, centre, rayonH, rayonV);
			}
		}
		
		throw new IllegalArgumentException("Type de forme non reconnu.");
    }
}
