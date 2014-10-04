/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: MenuFenetre.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.MenuElement;

/**
 * Crée le menu de la fenêtre de l'applicationé
 */
public class MenuFenetre extends JMenuBar{
	
	private static final long serialVersionUID = 1536336192561843187L;
	private static final int  MENU_DESSIN_ARRETER_TOUCHE_MASK  = ActionEvent.CTRL_MASK;
	private static final char MENU_DESSIN_ARRETER_TOUCHE_RACC  = KeyEvent.VK_A;
	private static final int  MENU_DESSIN_DEMARRER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_DESSIN_DEMARRER_TOUCHE_RACC = KeyEvent.VK_D;
	private static final int  MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;
	private static final String
			MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
			MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
			MENU_DESSIN_DEMARRER = "app.frame.menus.draw.start",
			MENU_DESSIN_ARRETER = "app.frame.menus.draw.stop",
			MENU_OBTENIR_FORMES = "app.frame.menus.draw.obtenirFormes",
			MENU_DESSIN_ADRESSE = "app.frame.menus.draw.adresse",
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about",
			MENU_TRIER = "app.frame.menus.sort.title",
			MENU_TRIER_CRITERE = "app.frame.menus.sort.criteria.title",
			MENU_TRIER_CRITERE_RECEPTION = "app.frame.menus.sort.criteria.reception",
			MENU_TRIER_CRITERE_NOSEQ = "app.frame.menus.sort.criteria.noseq",
			MENU_TRIER_CRITERE_AIRE = "app.frame.menus.sort.criteria.area",
			MENU_TRIER_CRITERE_TYPE = "app.frame.menus.sort.criteria.type",
			MENU_TRIER_CRITERE_DISTANCE = "app.frame.menus.sort.criteria.distance",
			MENU_TRIER_CRITERE_HAUTEUR = "app.frame.menus.sort.criteria.height",
			MENU_TRIER_CRITERE_LARGEUR = "app.frame.menus.sort.criteria.width",
			MENU_TRIER_ORDRE = "app.frame.menus.sort.order.title",			
			MENU_TRIER_ORDRE_CROISSANT = "app.frame.menus.sort.order.ascending",
			MENU_TRIER_ORDRE_DECROISSANT = "app.frame.menus.sort.order.descending";
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";  

	private JMenu menuCritere, menuOrdre;
	private JMenuItem adresseMenuItem, obtenirFormesMenuItem,
		critereAireMenuItem, critereDistanceMenuItem, critereNoSeqMenuItem, critereReceptionMenuItem, critereTypeMenuItem, critereHauteurMenuItem, critereLargeurMenuItem,
		ordreCroissantMenuItem, ordreDecroissantMenuItem;
	private static final int DELAI_QUITTER_MSEC = 200;
 	   
	CommBase comm; // Pour activer/désactiver la communication avec le serveur
	FenetrePrincipale fenetre;
	
	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm, FenetrePrincipale fenetre) {
		this.comm = comm;
		this.fenetre = fenetre;
		
		addMenuDessiner();
		addMenuTrier();
		addMenuFichier();
		addMenuAide();
	}

	/**
	 *  Créer le menu "Draw". 
	 */
	protected void addMenuDessiner() {
		JMenu menu = creerMenu(MENU_DESSIN_TITRE,new String[] { MENU_DESSIN_ADRESSE }, false);
			
		adresseMenuItem = menu.getItem(0);
		adresseMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			fenetre.demanderAdresse();
		    }
	    });
		
		add(menu);
	}
	
	/**
	 *  Créer le menu "Trier". 
	 */
	private void addMenuTrier() {		
        JMenu menu = new JMenu(LangueConfig.getResource(MENU_TRIER));
		menuCritere = creerMenu(MENU_TRIER_CRITERE, new String[] { MENU_TRIER_CRITERE_RECEPTION, MENU_TRIER_CRITERE_NOSEQ, MENU_TRIER_CRITERE_AIRE, MENU_TRIER_CRITERE_TYPE, MENU_TRIER_CRITERE_DISTANCE, MENU_TRIER_CRITERE_HAUTEUR, MENU_TRIER_CRITERE_LARGEUR }, true);
		menuOrdre = creerMenu(MENU_TRIER_ORDRE, new String[] { MENU_TRIER_ORDRE_CROISSANT, MENU_TRIER_ORDRE_DECROISSANT }, true);
		initailiserSousMenuTrier(menu, menuCritere);
		initailiserSousMenuTrier(menu, menuOrdre);

		critereReceptionMenuItem = menuCritere.getItem(0);
		critereNoSeqMenuItem = menuCritere.getItem(1);
		critereAireMenuItem = menuCritere.getItem(2);
		critereTypeMenuItem = menuCritere.getItem(3);
		critereDistanceMenuItem = menuCritere.getItem(4);
		critereHauteurMenuItem = menuCritere.getItem(5);
		critereLargeurMenuItem = menuCritere.getItem(6);		
		ordreCroissantMenuItem = menuOrdre.getItem(0);
		ordreDecroissantMenuItem = menuOrdre.getItem(1);
		
		add(menu);
	}
	
	private void initailiserSousMenuTrier(JMenu menu, JMenu sousMenu)
	{
		menu.add(sousMenu);
		sousMenu.getItem(0).setSelected(true);
		trierSurClic(sousMenu);
	}
	
	private void trierSurClic(JMenu menu)
	{
		for (int i = 0; i < menu.getItemCount(); i++)
		{
			JMenuItem item = menu.getItem(i);
			item.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0) {
					fenetre.trierFormes();
				}
			});
		}
	}
	
	/** 
	 * Créer le menu "File". 
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] { MENU_OBTENIR_FORMES, MENU_FICHIER_QUITTER }, false);
		
		obtenirFormesMenuItem = menu.getItem(0);
		obtenirFormesMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			fenetre.reconnecter();
		    }
	    });
		
		menu.getItem(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.stop();
			    try {
						Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				System.exit(0);
			}
		});
		menu.getItem(1).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));
		add(menu);
	}

	/**
	 *  Créer le menu "Help". 
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { MENU_AIDE_PROPOS }, false);
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,  LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS), 
						LangueConfig.getResource(MENU_AIDE_PROPOS), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}
	
	/**
	 * Créer un élément de menu à partir d'un champs principal et ses éléments
	 * @param titleKey champs principal
	 * @param itemKeys éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey, String[] itemKeys, boolean isBouton) {
		ButtonGroup group = new ButtonGroup();
        JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
        for(int i=0; i < itemKeys.length; ++i) {
        	String text = LangueConfig.getResource(itemKeys[i]);
        	JMenuItem item;
        	if (isBouton) 
        	{
        		item = new JRadioButtonMenuItem(text);
        		group.add(item);
        	}
        	else
        	{
        		item = new JMenuItem(text);
        	}
        	menu.add(item);
        }
        return menu;
   }
	
	public Comparateur creerComparateur()
	{
		boolean croissant = this.ordreCroissantMenuItem.isSelected();
		if (this.critereReceptionMenuItem.isSelected())
		{
			return new ComparateurReception(croissant);
		}
		else if (this.critereNoSeqMenuItem.isSelected())
		{
			return new ComparateurNoSeq(croissant);
		}
		else if (this.critereAireMenuItem.isSelected())
		{
			return new ComparateurAire(croissant);
		}
		else if (this.critereTypeMenuItem.isSelected())
		{
			return new ComparateurType(croissant);
		}
		else if (this.critereDistanceMenuItem.isSelected())
		{
			return new ComparateurDistance(croissant);
		}
		else if (this.critereLargeurMenuItem.isSelected())
		{
			return new ComparateurLargeur(croissant);
		}
		else if (this.critereHauteurMenuItem.isSelected())
		{
			return new ComparateurHauteur(croissant);
		}
		else
		{
			throw new IllegalStateException("Crit�re de comparaison de formes inconnu!");	
		}
	}
}
