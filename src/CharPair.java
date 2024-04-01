/**
 * @author Antonio Terpin
 * @year 2015
 * 
 * Convenient class to wrap a pair of characters.
 */
public class CharPair {
	public int a;
	public int b;
	
	/**
	 * Constructor of the pair
	 * 
	 * @param a the first character
	 * @param b the second character
	 */
	public CharPair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Get the other character of the pair
	 * 
	 * @param value the character to compare
	 * @return the other character of the pair
	 */
	public int get_other(int value) {
		if(value != a && value != b) {
			// The value is not in the pair
			return -1;
		}

		return (value == a)? b:a;
	}
}
