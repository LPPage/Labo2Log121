/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetrePrincipale.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
/**
 * Cette classe représente la fenêtre principale de l'application 
 * @author Patrice Boucher
 * @since 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener{
	private static final String QUESTION_ADRESSE_SERVEUR = "Quel est le nom d'héte et le port du serveur de formes?";
	private static final String ADRESSE_SERVEUR_PAR_DEFAUT = "localhost:10000";
	
	private static final long serialVersionUID = -1210804336046370508L;

	private static final String ERREUR = "Erreur";
	private static final String ERREUR_CONNEXION_PERDUE = "La connexion avec le serveur a été perdue.";
	private static final String ERREUR_HOTE_INCONNU = "Le nom d'héte n'a pas été trouvé.";
	private static final String ERREUR_PORT_FERME = "Le serveur ne répond pas sur le port spécifié.";
		
	private final FenetreFormes fenetreFormes;
	private final CreateurFormes createurFormes = new CreateurFormes();
	private final CommBase comm;
	private final MenuFenetre menu;
	private int compteurReception = 0;
	
	/**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm){
		this.comm = comm;
		this.menu = new MenuFenetre(comm, this);
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH); 
		this.fenetreFormes = new FenetreFormes();
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de forme à la fenètre principale
		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... à réviser selon le comportement que vous désirez ...
		this.setLocationRelativeTo(null);
	}
	
	// Appelé lorsque le sujet lance "firePropertyChanger"
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		
		switch (arg0.getPropertyName())
		{
		case "FORME-RECUE":
			String reponse = (String)arg0.getNewValue();
			System.out.println(reponse);
			Forme forme = createurFormes.creerForme(reponse, compteurReception++);
			this.fenetreFormes.ajouterForme(forme);
			break;
		case "CONNECTION_PERDUE":
			if (this.afficherErreurEtRedemanderAdresse(ERREUR_CONNEXION_PERDUE, "Connnexion perdue"))
			{
				this.reconnecter();	
			}
			break;
		}
	}
	
	/**
	 *  Se connecter en demandant une adresse jusqu'é ce que celle-ci soit valide ou que l'utilisateur annule l'opération
	 */
	public void reconnecter() {
		fenetreFormes.supprimerFormes();
		while (true)
		{
			try {
				comm.start(); 
				break;
			}
			catch (UnknownHostException ex)
			{
				if (!this.afficherErreurEtRedemanderAdresse(ERREUR_HOTE_INCONNU, "Héte inconnu")) break;
			}
			catch (IOException ex)
			{
				if (!this.afficherErreurEtRedemanderAdresse(ERREUR_PORT_FERME, "Port fermé")) break;
			}		
		}
		menu.rafraichirMenus();
	}
		
	/**
	 * Afficher une erreur et redemander une adresse
	 * @return  si une adress a été saisie
	 */
	private boolean afficherErreurEtRedemanderAdresse(String messageErreur, String titre)
	{
		if (!afficherErreur(messageErreur, titre))
		{
			return false;
		}
		return this.demanderAdresse();
	}

	/**
	 * 
	 * Demander une adresse jusqu'é ce que celle-ci ait un format valide
	 * @return si une adress a été saisie
	 */
	public boolean demanderAdresse()
	{
		while (true)
		{
			try
			{
				String adresse = JOptionPane.showInputDialog(this, QUESTION_ADRESSE_SERVEUR, ADRESSE_SERVEUR_PAR_DEFAUT);
				if (adresse == null)
				{
					return false;
				}
				comm.setAdresse(adresse);
				return true;
			}
			catch (AdresseException ex)
			{
				if (!this.afficherErreur(ex.getMessage(), "Adresse invalide"))
				{
					return false;
				}
			}
		}
	}

	/**
	 * 
	 * Afficher une erreur et demander su l'on veut saisir une autre adresse
	 * @return si l'on veut essayer une autre adresse
	 */
	private boolean afficherErreur(String messageErreur, String titre)
	{
		String message = messageErreur + " Voulez-vous essayer une autre adresse?";
		int reponse = JOptionPane.showConfirmDialog(this, message, titre, JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
		return reponse == JOptionPane.YES_OPTION;
	}
	
	public void trierFormes()
	{
		this.fenetreFormes.trierFormes(menu.creerComparateur());
	}
}
