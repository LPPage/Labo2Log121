
public class ListeChainee {
	private final Comparateur comparateur;
	private ItemListeChainee premierItem, dernierItem;
	
	public ListeChainee()
	{
		this(new ComparateurReception(false));
	}
	
	public ListeChainee(Comparateur comparateur)
	{
		this.comparateur = comparateur;
	}
	
	public ListeChainee(Comparateur comparateur, ListeChainee source)
	{
		this(comparateur);
		ItemListeChainee item = source.premierItem;
		while (item != null)
		{
			ajouter(item.getForme());
			item = item.getItemSuivant();
		}
	}
	
	public void ajouter(Forme forme)
	{
		ItemListeChainee itemAjoute = new ItemListeChainee(forme);
		ItemListeChainee itemAvant = null;
		ItemListeChainee itemApres = premierItem;
		
		while (itemApres != null && comparateur.compare(forme, itemApres.getForme()) > 0)
		{
			itemAvant = itemApres;
			itemApres = itemApres.getItemSuivant();
		}
		
		if (itemAvant == null)
		{
			premierItem = itemAjoute;
		}
		else
		{
			itemAvant.setItemSuivant(itemAjoute);
			itemAjoute.setItemPrecedent(itemAvant);
		}
		
		if (itemApres == null)
		{
			dernierItem = itemApres;
		}
		else
		{
			itemApres.setItemPrecedent(itemAjoute);
			itemAjoute.setItemSuivant(itemApres);
		}
	}
	
	public ItemListeChainee getPremierItem()
	{
		return premierItem;
	}
	
	public ItemListeChainee getDernierItem()
	{
		return dernierItem;
	}
	
	public Comparateur getComparateur()
	{
		return comparateur;
	}
}
