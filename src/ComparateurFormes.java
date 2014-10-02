
public abstract class ComparateurFormes {
	private final boolean ascendant;
	
	public ComparateurFormes(boolean ascendant)
	{
		this.ascendant = ascendant;
	}
	
    int compare(Forme premier, Forme deuxieme)
    {
    	return ascendant ? 1 : -1;
    }
}
