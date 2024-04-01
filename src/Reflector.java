/**
 * @author Antonio Terpin
 * @year: 2015
 * 
 * Reflectors are used to reflect the signal back through the rotors.
 * The reflector is a fixed mapping of characters.
 */
public class Reflector {
	CharPair[] pairs = new CharPair[13];
	
	/**
	 * Constructor
	 * 
	 * @param pairs the pairs of characters to exchange
	 */
	public Reflector(CharPair[] pairs) {
		this.pairs = pairs;
	}
	
	/**
	 * Reflect a character
	 * 
	 * @param value the character to reflect
	 * @return the reflected character
	 */
	public int reflect(int value) {
		// Find the value to reflect (corresponding pair)
		int i = 0;
		while(pairs[i].a != value && pairs[i].b != value) i++;

		// Return the reflected value
		return pairs[i].get_other(value);
	}
}
