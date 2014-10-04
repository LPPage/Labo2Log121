
public class ItemListeChainee {
	private Forme forme;
	private ItemListeChainee itemPrecedent, itemSuivant;
	
	public ItemListeChainee(Forme forme)
	{
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

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}	
}
