/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *******************************************************/  

import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {
	private static final String ERREUR_FORMAT_ADRESSE_INVALIDE = "L'adresse n'est pas dans un format valide.";	
	private static final String ERREUR_PORT_PAS_DANS_PLAGE = "Le numéro de port doit étre entre 1 et 65535.";
	private SwingWorker threadComm = null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private String hote;
	private int port;
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;

	/**
	 * 
	 * @param adresse
	 * @throws AdresseException si le format de l'adresse est invalide
	 */
	public void setAdresse(String adresse) throws AdresseException{
		try
		{
			String[] partiesAdresse = adresse.split(":");
			this.hote = partiesAdresse[0];
			int validatedPort = Integer.parseInt(partiesAdresse[1]);
			if (validatedPort < 1 || validatedPort > 65535)
			{
				throw new AdresseException(ERREUR_PORT_PAS_DANS_PLAGE);
			}
			this.port = validatedPort;
		}
		catch (AdresseException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw new AdresseException(ERREUR_FORMAT_ADRESSE_INVALIDE);
		}
	}


	/**
	 * Définir le récepteur de l'information reéue dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}

	/**
	 * Démarre la communication
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public void start() throws UnknownHostException, IOException{
		creerCommunication();
	}

	/**
	 * Arrête la communication
	 */
	public void stop(){
		try{
			if(threadComm!=null)
				threadComm.cancel(true);
			writer.println("END");
			reader.close();
			writer.close();
			socket.close();
			isActif = false;			
		}
		//gestion des erreurs
		//hôte inconnu
		catch (UnknownHostException e) {
			final JPanel panel = new JPanel();
			//lève un JOptionPane et change isInvalid à true pour empêcher le fil de commencer
			JOptionPane.showMessageDialog(panel, "Le nom de l'hôte fourni est invalide!", "Erreur", JOptionPane.ERROR_MESSAGE);				
		}
		//l'hôte ne répond pas sur le port spécifié
		catch (IOException e) {
			final JPanel panel = new JPanel();
			//lève un JOptionPane et change isInvalid à true pour empêcher le fil de commencer
			JOptionPane.showMessageDialog(panel, "Le serveur \"" + hote + "\" ne répond pas sur le port " + port + "!", "Erreur", JOptionPane.ERROR_MESSAGE);			
		}

	}

	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 * @throws IOException si le port est fermé
	 * @throws UnknownHostException si la réslution DSN a échoué
	 */
	protected void creerCommunication() throws UnknownHostException, IOException{
		this.socket = new Socket(hote, port);
		this.writer = new PrintWriter(socket.getOutputStream(), true);
		this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		isActif = true;
	}

	protected void obtenirFormes() throws UnknownHostException, IOException{
		threadComm = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");

				try
				{
					for(int k = 0; k < 10; k++){

						writer.println("GET");

						reader.readLine();
						String reponse = reader.readLine();

						if(listener!=null){
							firePropertyChange("FORME-RECUE", null, (Object)reponse); 
						}
					}
				}
				catch (IOException ex)
				{
					isActif = false;
					if(listener!=null){
						firePropertyChange("CONNECTION_PERDUE", null, null); 
					}
				}

				return null;
			}
		};
		if(listener!=null)
			threadComm.addPropertyChangeListener(listener);
		threadComm.execute();
		isActif = true;
	}

	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif(){
		return isActif;
	}
}
