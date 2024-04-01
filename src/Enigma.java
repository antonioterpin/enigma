/**
 * @author Antonio Terpin
 * @year 2015
 * 
 * This class is used to simulate the Enigma machine.
 */

import java.util.Scanner;

public class Enigma implements Runnable {

	/**
	 * @param args
	 */
	
	Reflector r; //reflector
	Rotor lr, cr, rr; //left rotor, central rotor, right rotor
	CriptoK ck; //cryptographic killer
	int ld, cd;
	private Scanner reader;
	
	/**
	 * Constructor
	 * 
	 * @param ld the left disk
	 * @param cd the right disk
	 * @param r the reflector
	 * @param lr the left rotor
	 * @param cr the central rotor
	 * @param rr the right rotor
	 * @param ck the cryptographic killer
	 */
	public Enigma (
		int ld, int cd, Reflector r, Rotor lr, Rotor cr, Rotor rr, CriptoK ck) {
		System.out.println("Assembling disks..");
		System.out.println("Left disk assembled..");
		System.out.println("Right disk assembled..\n");
		
		
		System.out.println("Assembling reflector..");
		this.r = r;
		System.out.println("Reflector assembled..\n");
		
		System.out.println("Assembling rotors..");
		this.lr = lr;
		System.out.println("Left rotor assembled..");
		this.cr = cr;
		System.out.println("Central rotor assembled..");
		this.rr = rr;
		System.out.println("Left rotor assembled..\n");
		
		System.out.println("Assembling the cryptographic killer..");
		this.ck = ck;
		System.out.println("Cryptographic killer assembled..\n");
		
		System.out.println("Assembling disks..");
		System.out.println("Assembling central-left disk..");
		this.ld = ld;
		System.out.println("Left disk assembled..");
		System.out.println("Assembling central-right disk..");
		this.cd = cd;
		System.out.println("Right disk assembled..");
	}

	@Override
	public void run() {
		char temp = '0', choice = 'A';
		do {
			RunEnigma job = new RunEnigma(ld ,cd, r, lr, cr, rr, ck);
			System.out.println("Encrypt or Decrypt a message? (E or D)\n" +
					"Digit C (Close) to quit: ");
			reader = new Scanner(System.in);
			try {
				choice = reader.next(".").charAt(0);
				choice = Character.toUpperCase(choice);
			} catch (Exception exc) {
				choice = 'A';
			}
			System.out.print("\n");
			
			switch(choice) {
				case 'D': {
						job.reset_machine();
					} //continue with case 2..
				case 'E': {
					System.out.println("\n '0' is the escape character\n");
					reader = new Scanner(System.in);
					do {
						try {
							temp = reader.next(".").charAt(0);
							temp = Character.toUpperCase(temp);
						} catch (Exception exc) {
							temp = '0';
							System.out.println("Error! Digit one char at time!");
						} if(temp >= 65 && temp <= 90) {
							job.cript(temp);
						} else if(temp != '0') {
							System.out.println(temp + " is not a letter or a '0'");
						}
					} while(temp != '0');
				} break;
				case 'C': System.out.println("Simulation finished.");break;
				default: System.out.println("Uncorrect choice..");break;
			}
		} while(choice != 'C');
		reader.close();
	}

}
