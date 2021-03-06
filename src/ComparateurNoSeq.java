
public class ComparateurNoSeq extends Comparateur {

	public ComparateurNoSeq(boolean ascendant) {
		super(ascendant);
	}

	@Override
	public int compare(Forme premier, Forme deuxieme) {
		return super.compare(premier, deuxieme) * Integer.compare(premier.getNoSequentiel(), deuxieme.getNoSequentiel());
	}
}
