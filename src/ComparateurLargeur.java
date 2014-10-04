
public class ComparateurLargeur extends Comparateur {

	public ComparateurLargeur(boolean ascendant) {
		super(ascendant);
	}
	
	@Override
	public int compare(Forme premier, Forme deuxieme) {
		return super.compare(premier, deuxieme) * Integer.compare(premier.getTaille().width, deuxieme.getTaille().width);
	}
}
