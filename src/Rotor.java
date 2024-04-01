/**
 * @author Antonio Terpin
 * @year: 2015
 * 
 * This class is used to simulate the rotors of the Enigma machine.
 * A rotor is a wheel with 26 characters on it. The rotor can be rotated
 * to change the mapping of the characters.
 */
public class Rotor {
	// The alphabet is an array of characters pairs
	public CharPair alphabet[] = new CharPair [26];
	private int cont = 0;
	
	public Rotor(CharPair[] alphabet) {
		this.alphabet = alphabet;
	}
	
	public void rotation() {
		// Each rotation is a shift of 1 position. We use the modulo operator to wrap around the array, but we count the number of rotations.
		this.cont++;
		this.cont = this.cont % 26;
	}
	
	public int left_to_right(int index) {
		index = (index + this.cont) % 26;
		index = this.search_index_a(this.alphabet[index].b) - this.cont;
		return (index + 26) % 26;
	}

	/**
	 * Move the rotor from right to left
	 * 
	 * @param index of the rotor
	 * @return the new index of the rotor
	 */
	public int right_to_left(int index)
	{
		index = (index + this.cont) % 26;
		index = this.search_index_b(this.alphabet[index].a) - this.cont;
		return (index + 26) % 26;
	}
	
	/**
	 * Get the character of the rotor
	 * 
	 * @return the character of the rotor
	 */
	public int get_char()
	{
		return this.alphabet[this.cont].a;
	}
	
	/**
	 * Reset the number of rotations of the rotor
	 */
	public void reset_cont() {
		this.cont = 0;
	}
	
	/**
	 * Search the index of the value in the first element of the alphabet pairs
	 * 
	 * @param value to search in the alphabet
	 * @return index of the value in the alphabet
	 */
	private int search_index_a(int value) {
		int index = 0;
		while(value != this.alphabet[index].a) {
			index++;
		}
		return index;
	}
	
	/**
	 * Search the index of the value in the second element of the alphabet pairs
	 * 
	 * @param value to search in the alphabet
	 * @return index of the value in the alphabet
	 */
	private int search_index_b(int value) {
		int index = 0;
		while(value != this.alphabet[index].b) {
			index++;
		}
		return index;
	}
}
