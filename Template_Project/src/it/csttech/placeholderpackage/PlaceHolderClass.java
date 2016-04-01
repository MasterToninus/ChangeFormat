package it.csttech.placeholderpackage;

/**
 * Represents an example class. If a basic description requires more than one
 * sentence, include it in the first paragraph.
 *
 * <p>
 * Example of a second paragraph. Note the blank line between the first <p> tag
 * and the end of the first paragraph.
 * </p>
 *
 * @author Tony
 * @todo. Boh
 * @see <a href="http://google.com">http://google.com</a>
 */
public class PlaceHolderClass {

/**
 * (Tipico Class Comment) Cosa fa la classe?
 *  printa un po' di volte la stringa passata
 *
 * @param  N numero di ripetizioni
 * @param  text Testo da scrivere
 * @return boolean: success value
// * @throws PortalException if a portal exception occurred
 */
	public static boolean printa(int N, String text){
		for(int i=0; i<N; i++)
			System.out.println(text);
		return true;
	}


    public static void main(String[] args) 
     {
         System.out.println("Sono una classe PlaceHolder");
         
         printa(4,"ciao");
     }
}
