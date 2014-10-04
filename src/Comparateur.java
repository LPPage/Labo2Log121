
public abstract class Comparateur {
	private final boolean ascendant;
	
	public Comparateur(boolean ascendant)
	{
		this.ascendant = ascendant;
	}
	
    public int compare(Forme premier, Forme deuxieme)
    {
    	return ascendant ? 1 : -1;
    }
    
    public boolean enDiagonale()
    {
    	return true;
    }
}
