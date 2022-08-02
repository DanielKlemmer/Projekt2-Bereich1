package ziffernfolge;
/** abstrakter Datentyp: Verschlüsseler (und Entschlüsseler) für beliebige Zeichenketten. 
    @author Andreas Kurz 
    @version 02.09.2018 */
public interface Kryptomethode
{ // Konstruktor für Implementierungen:
  /** Ein Verschlüsseler und ein Entschlüsseler werden bereitgestellt. */ 
  //public <Kryptomethode_Implementierung>();
	
  // Konstruktor für Implementierungen:
  /** Ein Verschlüsseler und ein Entschlüsseler werden mit zugehörigem
      Schlüsselwort bereitgestellt. 
      @param schluesselwort: eine beliebige Zeichenkette */ 
  //public <Kryptomethode_Implementierung>(String schluesselwort);

  /** Der Schluessel fuer das Ver- und Entschluesseln wird bereitgestellt.
      @param wert Wert des Schluessels: eine beliebige Zeichenkette.*/
  public void Schluessel(String wert);
  
  /** Der Text wird verschluesselt. Wenn kein Schluessel bereitgestellt ist, 
      oder für den Text ein Null-Zeiger uebergeben wird, wird nicht 
      verschluesselt. Der verschlüsselte Text wird im Parameter text zur 
      Verfügung gestellt.
      @param text der zu verschluesselnde Text.*/
  public void verschluesseln(StringBuffer text);

  /** Der Text wird entschluesselt. Wenn kein Schluessel bereitgestellt ist, 
      oder für den Text ein Null-Zeiger uebergeben wird, wird nicht 
      entschluesselt. Der entschlüsselte Text wird im Parameter text zur 
      Verfügung gestellt.
      @param text der zu entschluesselnde Text.*/
  public void entschluesseln(StringBuffer text);
}