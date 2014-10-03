
public class ComparateurHauteur extends ComparateurFormes {

	public ComparateurHauteur(boolean ascendant) {
		super(ascendant);
	}

	@Override
	public int compare(Forme premier, Forme deuxieme) {
		return super.compare(premier, deuxieme) * Integer.compare(premier.getTaille().height, deuxieme.getTaille().height);
	}
}
