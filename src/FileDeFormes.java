/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FileDeFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Louis-Pierre Pag�
2013-09-25 Version initiale
*******************************************************/  

public class FileDeFormes {
	private final Forme[] formes;
	private int pointeur = 0;
	
	public FileDeFormes(int taille)
	{
		formes = new Forme[taille];
	}
	
	/**
	 * 
	 * @param forme la forme a ajouter a la file, possiblement �crasant la premi�re dans la file
	 */
	public void ajouter(Forme forme)
	{
		pointeur = (pointeur + 1) % 10;
		this.getFormes()[pointeur] = forme;
	}

	/**
	 * 
	 * @return toutes les formes dans la file
	 */
	public Forme[] getFormes() {
		return formes;
	}
}
