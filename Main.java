import java.util.Scanner;

/**
 * @author Antonio Terpin
 * @year: 2015
 * 
 * Main class to run the Enigma machine.
 */
public class Main {

	private static Scanner reader = new Scanner (System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Building the components:\n");
		
		System.out.println("Building disks..");
		int ld = 16;
		System.out.println("Central-left disk built..");
		int cd = 4;
		System.out.println("Central-right disk built..\n");

		
		System.out.println("Building reflector..");
		Reflector r;
		CharPair[] r_pairs = new CharPair[13];
		r_pairs[0] = new CharPair(0,24);
		r_pairs[1] = new CharPair(1,17);
		r_pairs[2] = new CharPair(2,20);
		r_pairs[3] = new CharPair(3,7);
		r_pairs[4] = new CharPair(4,16);
		r_pairs[5] = new CharPair(5,18);
		r_pairs[6] = new CharPair(6,11);
		r_pairs[7] = new CharPair(8,15);
		r_pairs[8] = new CharPair(9,23);
		r_pairs[9] = new CharPair(10,13);
		r_pairs[10] = new CharPair(12,14);
		r_pairs[11] = new CharPair(19,25);
		r_pairs[12] = new CharPair(21,22);
		r = new Reflector(r_pairs);
		System.out.println("Reflector built..\n");
		
		System.out.println("Building rotors..");
		Rotor rI, rII, rIII;
		CharPair[] rI_pairs = new CharPair[26];
		rI_pairs[0] = new CharPair(15,22);
		rI_pairs[1] = new CharPair(16,19);
		rI_pairs[2] = new CharPair(17,17);
		rI_pairs[3] = new CharPair(18,14);
		rI_pairs[4] = new CharPair(19,25);
		rI_pairs[5] = new CharPair(20,7);
		rI_pairs[6] = new CharPair(21,0);
		rI_pairs[7] = new CharPair(22,16);
		rI_pairs[8] = new CharPair(23,1);
		rI_pairs[9] = new CharPair(24,8);
		rI_pairs[10] = new CharPair(25,3);
		rI_pairs[11] = new CharPair(0,9);
		rI_pairs[12] = new CharPair(1,11);
		rI_pairs[13] = new CharPair(2,4);
		rI_pairs[14] = new CharPair(3,10);
		rI_pairs[15] = new CharPair(4,5);
		rI_pairs[16] = new CharPair(5,2);
		rI_pairs[17] = new CharPair(6,15);
		rI_pairs[18] = new CharPair(7,20);
		rI_pairs[19] = new CharPair(8,24);
		rI_pairs[20] = new CharPair(9,12);
		rI_pairs[21] = new CharPair(10,18);
		rI_pairs[22] = new CharPair(11,13);
		rI_pairs[23] = new CharPair(12,21);
		rI_pairs[24] = new CharPair(13,23);
		rI_pairs[25] = new CharPair(14,6);
		rI = new Rotor(rI_pairs);

		System.out.println("Left rotor built..");
		CharPair[] rII_pairs = new CharPair[26];
		rII_pairs[0] = new CharPair(18,25);
		rII_pairs[1] = new CharPair(19,13);
		rII_pairs[2] = new CharPair(20,15);
		rII_pairs[3] = new CharPair(21,24);
		rII_pairs[4] = new CharPair(22,5);
		rII_pairs[5] = new CharPair(23,21);
		rII_pairs[6] = new CharPair(24,14);
		rII_pairs[7] = new CharPair(25,4);
		rII_pairs[8] = new CharPair(0,0);
		rII_pairs[9] = new CharPair(1,9);
		rII_pairs[10] = new CharPair(2,3);
		rII_pairs[11] = new CharPair(3,10);
		rII_pairs[12] = new CharPair(4,18);
		rII_pairs[13] = new CharPair(5,8);
		rII_pairs[14] = new CharPair(6,17);
		rII_pairs[15] = new CharPair(7,20);
		rII_pairs[16] = new CharPair(8,23);
		rII_pairs[17] = new CharPair(9,1);
		rII_pairs[18] = new CharPair(10,11);
		rII_pairs[19] = new CharPair(11,7);
		rII_pairs[20] = new CharPair(12,22);
		rII_pairs[21] = new CharPair(13,19);
		rII_pairs[22] = new CharPair(14,12);
		rII_pairs[23] = new CharPair(15,2);
		rII_pairs[24] = new CharPair(16,16);
		rII_pairs[25] = new CharPair(17,6);
		rII = new Rotor(rII_pairs);

		System.out.println("Central rotor built..");
		CharPair[] rIII_pairs = new CharPair[26];
		rIII_pairs[0] = new CharPair(3,7);
		rIII_pairs[1] = new CharPair(4,9);
		rIII_pairs[2] = new CharPair(5,11);
		rIII_pairs[3] = new CharPair(6,2);//
		rIII_pairs[4] = new CharPair(7,15);
		rIII_pairs[5] = new CharPair(8,17);
		rIII_pairs[6] = new CharPair(9,19);
		rIII_pairs[7] = new CharPair(10,23);
		rIII_pairs[8] = new CharPair(11,21);
		rIII_pairs[9] = new CharPair(12,25);
		rIII_pairs[10] = new CharPair(13,13);
		rIII_pairs[11] = new CharPair(14,24);
		rIII_pairs[12] = new CharPair(15,4);
		rIII_pairs[13] = new CharPair(16,8);
		rIII_pairs[14] = new CharPair(17,22);
		rIII_pairs[15] = new CharPair(18,6);
		rIII_pairs[16] = new CharPair(19,0);
		rIII_pairs[17] = new CharPair(20,10);
		rIII_pairs[18] = new CharPair(21,12);
		rIII_pairs[19] = new CharPair(22,20);
		rIII_pairs[20] = new CharPair(23,18);
		rIII_pairs[21] = new CharPair(24,16);
		rIII_pairs[22] = new CharPair(25,14);
		rIII_pairs[23] = new CharPair(0,1);
		rIII_pairs[24] = new CharPair(1,3);
		rIII_pairs[25] = new CharPair(2,5);
		rIII = new Rotor(rIII_pairs);
		System.out.println("Right rotor built..\n");
		
		System.out.println("Building the cryptographic killer..");
		CharPair[] ck_pairs = new CharPair[10];
		ck_pairs[0] = new CharPair(0,4);
		ck_pairs[1] = new CharPair(3,5);
		ck_pairs[2] = new CharPair(8,9);
		ck_pairs[3] = new CharPair(10,14);
		ck_pairs[4] = new CharPair(13,18);
		ck_pairs[5] = new CharPair(16,19);
		ck_pairs[6] = new CharPair(17,21);
		ck_pairs[7] = new CharPair(22,24);
		ck_pairs[8] = new CharPair(23,25);
		ck_pairs[9] = new CharPair(7,12);
		CriptoK ck = new CriptoK(ck_pairs);
		System.out.println("Cryptographic killer built..\n");
		
		char temp = '0';
		int choice = 0;
		do {
			System.out.println("Choose the machine configuration among the availables:\n"
					+ "1. I,II,III\n"
					+ "2. I,III,II\n"
					+ "3. II,I,III\n"
					+ "4. II,III,I\n"
					+ "5. III,I,II\n"
					+ "6. III,II,I\n");
			
			reader = new Scanner(System.in);
			
			try {
				temp = reader.next(".").charAt(0);
			} catch (Exception exc) {
				temp = '0';
			}

			if(temp >= 48 && temp <= 54) {
				choice = temp -48;
			} else {
				System.out.println("Please follow the menu'");
			}
		} while (choice <= 0 || choice > 6);
		
		System.out.println("Assembling the machine..\n");
		
		Enigma E = null;
		
		switch(choice) {
			case 1: E = new Enigma(ld, cd, r, rI, rII, rIII, ck); break;
			case 2: E = new Enigma(ld, cd, r, rI, rIII, rII, ck); break;
			case 3: E = new Enigma(ld, cd, r, rII, rI, rIII, ck); break;
			case 4: E = new Enigma(ld, cd, r, rII, rIII, rI, ck); break;
			case 5: E = new Enigma(ld, cd, r, rIII, rI, rII, ck); break;
			case 6: E = new Enigma(ld, cd, r, rIII, rII, rI, ck); break;
			default: ; break;
		}
		
		System.out.println("The machine is ready..\n");
		System.out.println("Enigma is not case sensitive\n");
		Thread ENIGMA = new Thread (E);
		ENIGMA.start();
	}

}
