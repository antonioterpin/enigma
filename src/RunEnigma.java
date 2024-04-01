/**
 * @author Antonio Terpin
 * @year: 2015
 *
 * This class is used to simulate the Enigma machine.
 */
public class RunEnigma {

	Reflector r;
	Rotor lr, t_lr, cr, t_cr, rr, t_rr;
	CriptoK ck;
	int ld, cd;
	
	public RunEnigma(int ld, int cd, Reflector r, Rotor lr, Rotor cr, Rotor rr, CriptoK ck)
	{
		this.r = r;
		
		this.t_lr = this.lr = lr;
		this.t_cr = this.cr = cr;
		this.t_rr = this.rr = rr;
		this.ld = ld;
		this.cd = cd;
		this.ck = ck;
	}
	
	/**
	 * Encrypt a character
	 * 
	 * @param c the character to encrypt
	 */
	public void cript(char c)
	{		
		int ch = c - 65;
		
		/*
		 * Cryptokiller disabled
		 */
		
		//int k = ck.xchg(ch);
		//if(k != -1) ch = k;
		
		ch = lr.left_to_right(ch);
		if(lr.get_char() == ld) {
			// If the left rotor is in the position ld, then the central rotor rotates
			cr.rotation();
		}
		
		if(cr.get_char() == cd) {
			// If the central rotor is in the position cd, then the right rotor rotates
			rr.rotation();
		}

		// The central rotor rotates to the right
		ch = cr.left_to_right(ch);
		// The right rotor rotates to the right
		ch = rr.left_to_right(ch);
		// The character is reflected
		ch = r.reflect(ch);
		// The right rotor rotates to the left
		ch = rr.right_to_left(ch);
		// The central rotor rotates to the left
		ch = cr.right_to_left(ch);
		// The left rotor rotates to the left
		ch = lr.right_to_left(ch);
		
		/*
		 * Cryptokiller disabled
		 */
		
		//k = ck.xchg(ch);
		//if(k != -1) ch = k;
		
		System.out.println(c + "-->" + (char)(ch + 65));

		lr.rotation();
		
	}
	
	/**
	 * Reset the machine to the initial configuration
	 */
	public void reset_machine() {
		this.lr = this.t_lr;
		this.cr = this.t_cr;
		this.rr = this.t_rr;
		this.lr.reset_cont();
		this.cr.reset_cont();
		this.rr.reset_cont();
	}
}
