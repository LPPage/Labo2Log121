
public class ListeChainee {
	private final ComparateurFormes comparateur;
	private ItemListeChainee premierItem, dernierItem;
	
	public ListeChainee()
	{
		this(new ComparateurReception(false));
	}
	
	public ListeChainee(ComparateurFormes comparateur)
	{
		this.comparateur = comparateur;
	}
	
	public ListeChainee(ComparateurFormes comparateur, ListeChainee source)
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
		ItemListeChainee itemAjoute = new ItemListeChainee(this, forme);
		ItemListeChainee itemAvant = null;
		ItemListeChainee itemApres = premierItem;
		
		while (itemApres != null && comparateur.compare(forme, itemApres.getForme()) < 0)
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
	
	public ComparateurFormes getComparateur()
	{
		return comparateur;
	}
}
