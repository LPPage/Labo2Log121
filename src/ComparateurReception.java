
public class ComparateurReception extends ComparateurFormes {

	public ComparateurReception(boolean ascendant) {
		super(ascendant);
	}

	@Override
	int compare(Forme premier, Forme deuxieme) {
		return super.compare(premier, deuxieme) * Integer.compare(premier.getOrdreReception(), deuxieme.getOrdreReception());
	}
}
