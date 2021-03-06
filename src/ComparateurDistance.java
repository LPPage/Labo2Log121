
public class ComparateurDistance extends Comparateur {

	public ComparateurDistance(boolean ascendant) {
		super(ascendant);
	}

	@Override
	public int compare(Forme premier, Forme deuxieme) {
		return super.compare(premier, deuxieme) * Double.compare(premier.getDistanceEntrePoints(), deuxieme.getDistanceEntrePoints());
	}
}
