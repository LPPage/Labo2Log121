/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: DecodeurForme.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pag�
2013-09-25 Version initiale
*******************************************************/  

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.etsmtl.log.util.IDLogger;

public class DecodeurForme {
	private final int noSeq;
	private final String typeForme;
	private final int[] parametres;
		
	/**
	 * 
	 * @param chaineForme la chaine d�crivant une forme provenant du serveur
	 */
	public DecodeurForme(String chaineForme)
	{
		Pattern pattern = Pattern.compile("(?<noSeq>\\d+) <(?<typeForme>\\w+)> (?<parametres>[\\d+\\s]+) </\\w+>");
		Matcher matcher = pattern.matcher(chaineForme);
		
		if (!matcher.find())
		{
			throw new IllegalArgumentException("La chaine de la forme n'a pas pu �tre interpr�t�e.");
		}
		
		this.noSeq = Integer.parseInt(matcher.group("noSeq"));
		IDLogger.getInstance().logID(this.noSeq); ;
			
		this.typeForme = matcher.group("typeForme");
		
		String[] strParametres = matcher.group("parametres").split(" ");
		parametres = new int[strParametres.length];
		for (int i = 0; i < getParametres().length; i++)
		{
			this.getParametres()[i] = Integer.parseInt(strParametres[i]);
		}
	}

	/**
	 * 
	 * @return le num�ro s�quentiel d�cod�
	 */
	public int getNoSeq() {
		return noSeq;
	}

	/**
	 * 
	 * @return le type de forme d�cod�
	 */
	public String getTypeForme() {
		return typeForme;
	}

	/**
	 * 
	 * @return un tableau contenant les param�tres additionnels de la forme
	 */
	public int[] getParametres() {
		return parametres;
	}
}
