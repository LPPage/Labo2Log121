/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FileDeFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pagé
2013-09-25 Version initiale
*******************************************************/  

public class FileDeFormes {
	private final Forme[] formes;
	private int pointeur = 0;
	private final int taille;
	
	public FileDeFormes(int taille)
	{
		formes = new Forme[taille];
		this.taille = taille;
	}
	
	/**
	 * 
	 * @param forme la forme a ajouter a la file, possiblement écrasant la premiére dans la file
	 */
	public void ajouter(Forme forme)
	{
		pointeur = (pointeur) % this.taille;
		this.getFormes()[pointeur] = forme;
		pointeur++;
	}

	/**
	 * 
	 * @return toutes les formes dans la file
	 */
	public Forme[] getFormes() {
		return formes;
	}
	
	public int getIndex(Forme f){
		int index = 0;
		for (int k = 0; k < this.taille; k++){
			if (formes[k]==f)
				index = k;
		}
		return index;
	}
}
