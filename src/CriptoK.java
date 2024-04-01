/**
 * @author Antonio Terpin
 * 
 * This class is used to simulate the Cryptographic Killer.
 * 
 * The Cryptographic Killer is a device that is used to encrypt 
 * and decrypt messages by exchanging characters.
 */
public class CriptoK {
	//Cryptographic Killer
	CharPair[] pairs = new CharPair[10];
	
	/**
	 * Constructor
	 * 
	 * @param pairs the pairs of characters to exchange
	 */
	public CriptoK(CharPair[] pairs) {
		this.pairs = pairs;
	}
	
	/**
	 * Exchange a character
	 * 
	 * @param value the character to exchange
	 * @return the exchanged character
	 */
	public int xchg(int value) {
		// Find the value to exchange
		int i = 0;
		while(i < 10 && (pairs[i].a != value && pairs[i].b != value)) {
			i++;
		}

		if (i == 10) {
			// Character not found
			return -1;
		}

		// Return the exchanged value
		return pairs[i].get_other(value);
	}
}
