
public class ComparateurAire extends Comparateur {

	public ComparateurAire(boolean ascendant) {
		super(ascendant);
	}

	@Override
	public int compare(Forme premier, Forme deuxieme) {
		return super.compare(premier, deuxieme) * Double.compare(premier.getAire(), deuxieme.getAire());
	}
}
