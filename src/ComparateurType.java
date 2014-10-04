
public class ComparateurType extends Comparateur {

	public ComparateurType(boolean ascendant) {
		super(ascendant);
	}

	@Override
	public int compare(Forme premier, Forme deuxieme) {
		return super.compare(premier, deuxieme) * Integer.compare(premier.getTypeForme(), deuxieme.getTypeForme());
	}
}
