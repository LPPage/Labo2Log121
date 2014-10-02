
public class ItemListeChainee {
	private final ListeChainee liste;
	private Forme forme;
	private ItemListeChainee itemPrecedent, itemSuivant;
	
	public ItemListeChainee(ListeChainee liste, Forme forme)
	{
		this.liste=liste;
		this.setForme(forme);
	}

	public ItemListeChainee getItemPrecedent() {
		return itemPrecedent;
	}

	public void setItemPrecedent(ItemListeChainee itemPrecedent) {
		this.itemPrecedent = itemPrecedent;
	}

	public ItemListeChainee getItemSuivant() {
		return itemSuivant;
	}

	public void setItemSuivant(ItemListeChainee itemSuivant) {
		this.itemSuivant = itemSuivant;
	}

	public ListeChainee getListe() {
		return liste;
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}	
}
