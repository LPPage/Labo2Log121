
public class ComparateurReception extends Comparateur {

	public ComparateurReception(boolean ascendant) {
		super(ascendant);
	}

	@Override
	public int compare(Forme premier, Forme deuxieme) {
		return super.compare(premier, deuxieme) * Integer.compare(premier.getOrdreReception(), deuxieme.getOrdreReception());
	}

	@Override
    public boolean enDiagonale()
    {
    	return false;
    }
}
