package ziffernfolge;

public interface Datenspeicher {

	/**
	 * Konstruktor
	 */
	//public Datenspeicher()

	/**
	 * Diese Funktion speichert eine gegebene Ergebnisliste in ein .txt Dokument. 
	 * @param ergebnisliste
	 * @throws Datenspeicher.CouldNotStoreErgebnisListeException
	 */
	public void speichere(Ergebnisliste ergebnisliste);

	/**
	 * Diese Funktion lieﬂt ein .txt Dokument und speichert es in eine Ergebnisliste. 
	 * @return Ergebnisliste
	 * @throws Datenspeicher.CouldNotStoreErgebnisListeException
	 */
	public Ergebnisliste lade();

	@SuppressWarnings("serial")
	public class CouldNotStoreErgebnisListeException extends RuntimeException {
	}
}
