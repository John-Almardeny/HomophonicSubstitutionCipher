package cipheringPackage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import languagesPackage.Language;

/**This is Encryption Class that extends the Cipher Class
 * it performs all the encryption work
 * and stores the cipher-text(which is the final-wanted result)in the Cipher class private field "cipherText"
 * @author Yahya Almardeny
 * @version 05/10/2016
 */


public class Encryption extends Cipher{
    
	/** Default Serial Version ID*/
	private static final long serialVersionUID = 1L;

	/**
	 * The Constructor
	 */
	public Encryption() {
		super(); //no parameters, so it's optional to invoke the super constructor because java implicitly invokes it
	}
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	/**This methods generate the homophones randomly
	 * and fill it in the homophones table 
	 * each column of the table is called a strip
	 * the size of each strip is calculated carefully to fit every language in an optimum way
	 * @param language 
	 */
	public void generateHomophons(Language language){
		homophones = new ArrayList<ArrayList<String>>(); // every time this method is invoked, create new object of the homophones
		// values are picked carefully to add the maximum numbers of homophones in the table
		int stripSize=0; //initial strip size which is the maximum size of a strip that can be
		int levelTwo=0, levelThree=0, levelFour=0; // variables to split the homophones into appropriate-in-size strips but less that the maximum size  
		switch(language){
			case ENGLISH: // 26 letter
				stripSize=5; 
				levelTwo=3; levelThree=2; levelFour=1;
				break;
			case FRENCH: // 40 letter
				stripSize=4;
				levelTwo=3; levelThree=2; levelFour=1;
				break;
			case GERMAN:
				stripSize=5; // 30 letter
				levelTwo=3; levelThree=2; levelFour=1;
				break;
			case SPANISH:
				stripSize=4; // 32 letter
				levelTwo=3; levelThree=2; levelFour=1;
				break;
		}
		
		int homophonesIndex =0, sizeCounter=0;
		
		ArrayList<String> HomophonesContainer = new ArrayList<String>();// to save a record about all homophones already generated in order not to exclude them in next rounds
		for(int i=0; i<super.getOrderedAlphabet().size();i++){
			ArrayList<String> strip = new ArrayList<String>(); // an temporary ArrayList to hold the strip generated randomly
			for(int j=0;j<stripSize; j++, sizeCounter++){
				//strip.add(j,noDuplicateRandom(HomophonesContainer, sizeCounter==0));
				if (sizeCounter==0){
					strip.add(j,noDuplicateRandom(HomophonesContainer, true));// the true parameter informs the private noDuplicateRandom method that it's the very first round
				}
				else{strip.add(j,noDuplicateRandom(HomophonesContainer, false));}
			}
			homophonesIndex=setStrips(strip, homophonesIndex); // this private method adds the strips incrementally to the homophones-ArrayList field and return next index
			// the first 10 strips are always the biggest in size then the next 20 and so on, this info will be used while redistributing the homophones later
			if (i==10){stripSize=levelTwo;} 
			if (i==20){stripSize=levelThree;}
			if (i==26){stripSize=levelFour;}
			
		}
		redistributeHomophonesInTable(language);// to make the most frequent letters the assigned the biggest strips and so on
		
	}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/** A private method to be invoked internally to generate the Homophones
	 * it generates a controlled-random numbers with a max. upper-limit
	 * the random number is not repeated once it's picked up
	 * @Param:  
	 */
	private String noDuplicateRandom(ArrayList<String> HomophonesContainer,  boolean firstCall){
		if(firstCall){ // only every very first invoke the HomophonesContainer should be filled out
			for(int i=0; i<100;i++){ // fill the container with the numbers from 00 to 99
				//(i<10 ? "0" : "")+i
				if(i<10){
					switch (i){
						case 0:
							HomophonesContainer.add("00"); // the convention is to have this style in SSC
							break;
						case 1:
							HomophonesContainer.add("01");
							break;
						case 2:
							HomophonesContainer.add("02");
							break;
						case 3:
							HomophonesContainer.add("03");
							break;
						case 4:
							HomophonesContainer.add("04");
							break;
						case 5:
							HomophonesContainer.add("05");
							break;
						case 6:
							HomophonesContainer.add("06");
							break;
						case 7:
							HomophonesContainer.add("07");
							break;
						case 8:
							HomophonesContainer.add("08");
							break;
						case 9:
							HomophonesContainer.add("09");
							break;
					}
				}
				else {HomophonesContainer.add(Integer.toString(i));}// primitive types don't have methods because they're not objects, that is why I used "Integer" Class to change the variable i to string	
			}
		}
		Random randomGenerator = new Random();
		//pick up a random index inside the HomophonesContainer with upper-limit of value "the container size"
		// then remove it from the container in order not picking it up again next time
		return HomophonesContainer.remove(randomGenerator.nextInt(HomophonesContainer.size())); 
	}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
    /** Method to encrypt the plain-text
     * @param language
     */
	public void encrypt(Language language){
		char plainText[] = super.getPlainText().toCharArray(); // convert the plain-text string into array of chars for easier manipulating
		int i=0;
		String cipherText=""; // literal string to hold the cipher-text

		while (i<plainText.length){ // read the entire plain-text string
			  Random rnd = new Random();
			  switch(language){
				case ENGLISH:
					switch(Character.toUpperCase(plainText[i])){// read char by char in the plain-text after converting it to upperCase to avoid case-sensitivity
						case ' '://concatenate to the end of the cipherText string in every round
						    cipherText +=" ";
						    	break;
					    case 'A':// invoke internally "homophoneIndex" which return the homophone index of the given char
					    	// choose a random homophone from the strip with upper-limit of value "size of the specified strip)
							cipherText += homophones.get(homophoneIndex("A")).get(rnd.nextInt(homophones.get(homophoneIndex("A")).size()));
								break;
						case 'B':
							cipherText += homophones.get(homophoneIndex("B")).get(rnd.nextInt(homophones.get(homophoneIndex("B")).size()));
								break;
						case 'C': 
							cipherText += homophones.get(homophoneIndex("C")).get(rnd.nextInt(homophones.get(homophoneIndex("C")).size()));
								break;
						case 'D':
							cipherText += homophones.get(homophoneIndex("D")).get(rnd.nextInt(homophones.get(homophoneIndex("D")).size()));
								break;
						case 'E':
							cipherText += homophones.get(homophoneIndex("E")).get(rnd.nextInt(homophones.get(homophoneIndex("E")).size()));
								break;
						case 'F':
							cipherText += homophones.get(homophoneIndex("F")).get(rnd.nextInt(homophones.get(homophoneIndex("F")).size()));
								break;
						case 'G':
							cipherText += homophones.get(homophoneIndex("G")).get(rnd.nextInt(homophones.get(homophoneIndex("G")).size()));
								break;
						case 'H':
							cipherText += homophones.get(homophoneIndex("H")).get(rnd.nextInt(homophones.get(homophoneIndex("H")).size()));
								break;
						case 'I':
							cipherText += homophones.get(homophoneIndex("I")).get(rnd.nextInt(homophones.get(homophoneIndex("I")).size()));
								break;
						case 'J': 
							cipherText += homophones.get(homophoneIndex("J")).get(rnd.nextInt(homophones.get(homophoneIndex("J")).size()));
								break;
						case 'K':
							cipherText += homophones.get(homophoneIndex("K")).get(rnd.nextInt(homophones.get(homophoneIndex("K")).size()));
								break;
						case 'L':
							cipherText += homophones.get(homophoneIndex("L")).get(rnd.nextInt(homophones.get(homophoneIndex("L")).size()));
								break;
						case 'M':
							cipherText += homophones.get(homophoneIndex("M")).get(rnd.nextInt(homophones.get(homophoneIndex("M")).size()));
								break;
						case 'N':
							cipherText += homophones.get(homophoneIndex("N")).get(rnd.nextInt(homophones.get(homophoneIndex("N")).size()));
								break;
						case 'O':
							cipherText += homophones.get(homophoneIndex("O")).get(rnd.nextInt(homophones.get(homophoneIndex("O")).size()));
								break;
						case 'P':
							cipherText += homophones.get(homophoneIndex("P")).get(rnd.nextInt(homophones.get(homophoneIndex("P")).size()));
								break;
						case 'Q':
							cipherText += homophones.get(homophoneIndex("Q")).get(rnd.nextInt(homophones.get(homophoneIndex("Q")).size()));
								break;
						case 'R':
							cipherText += homophones.get(homophoneIndex("R")).get(rnd.nextInt(homophones.get(homophoneIndex("R")).size()));
								break;
						case 'S':
							cipherText += homophones.get(homophoneIndex("S")).get(rnd.nextInt(homophones.get(homophoneIndex("S")).size()));
								break;
						case 'T':
							cipherText += homophones.get(homophoneIndex("T")).get(rnd.nextInt(homophones.get(homophoneIndex("T")).size()));
								break;
						case 'U':
							cipherText += homophones.get(homophoneIndex("U")).get(rnd.nextInt(homophones.get(homophoneIndex("U")).size()));
								break;
						case 'V':
							cipherText += homophones.get(homophoneIndex("V")).get(rnd.nextInt(homophones.get(homophoneIndex("V")).size()));
								break;
						case 'W':
							cipherText += homophones.get(homophoneIndex("W")).get(rnd.nextInt(homophones.get(homophoneIndex("W")).size()));
								break;
						case 'X':
							cipherText += homophones.get(homophoneIndex("X")).get(rnd.nextInt(homophones.get(homophoneIndex("X")).size()));
								break;
						case 'Y':
							cipherText += homophones.get(homophoneIndex("Y")).get(rnd.nextInt(homophones.get(homophoneIndex("Y")).size()));
								break;
						case 'Z':
							cipherText += homophones.get(homophoneIndex("Z")).get(rnd.nextInt(homophones.get(homophoneIndex("Z")).size()));
								break;
						}
					break;
					
				case FRENCH:
					switch(Character.toUpperCase(plainText[i])){
						case ' ':
							cipherText +=" ";
					    	break;
						case 'A':
							cipherText += homophones.get(homophoneIndex("A")).get(rnd.nextInt(homophones.get(homophoneIndex("A")).size()));
							break;
						case 'B':
							cipherText += homophones.get(homophoneIndex("B")).get(rnd.nextInt(homophones.get(homophoneIndex("B")).size()));
							break;
						case 'C': 
							cipherText += homophones.get(homophoneIndex("C")).get(rnd.nextInt(homophones.get(homophoneIndex("C")).size()));
							break;
						case 'D':
							cipherText += homophones.get(homophoneIndex("D")).get(rnd.nextInt(homophones.get(homophoneIndex("D")).size()));
							break;
						case 'E':
							cipherText += homophones.get(homophoneIndex("E")).get(rnd.nextInt(homophones.get(homophoneIndex("E")).size()));
							break;
						case 'F':
							cipherText += homophones.get(homophoneIndex("F")).get(rnd.nextInt(homophones.get(homophoneIndex("F")).size()));
							break;
						case 'G':
							cipherText += homophones.get(homophoneIndex("G")).get(rnd.nextInt(homophones.get(homophoneIndex("G")).size()));
							break;
						case 'H':
							cipherText += homophones.get(homophoneIndex("H")).get(rnd.nextInt(homophones.get(homophoneIndex("H")).size()));
							break;
						case 'I':
							cipherText += homophones.get(homophoneIndex("I")).get(rnd.nextInt(homophones.get(homophoneIndex("I")).size()));
							break;
						case 'J': 
							cipherText += homophones.get(homophoneIndex("J")).get(rnd.nextInt(homophones.get(homophoneIndex("J")).size()));
							break;
						case 'K':
							cipherText += homophones.get(homophoneIndex("K")).get(rnd.nextInt(homophones.get(homophoneIndex("K")).size()));
							break;
						case 'L':
							cipherText += homophones.get(homophoneIndex("L")).get(rnd.nextInt(homophones.get(homophoneIndex("L")).size()));
							break;
						case 'M':
							cipherText += homophones.get(homophoneIndex("M")).get(rnd.nextInt(homophones.get(homophoneIndex("M")).size()));
							break;
						case 'N':
							cipherText += homophones.get(homophoneIndex("N")).get(rnd.nextInt(homophones.get(homophoneIndex("N")).size()));
							break;
						case 'O':
							cipherText += homophones.get(homophoneIndex("O")).get(rnd.nextInt(homophones.get(homophoneIndex("O")).size()));
							break;
						case 'P':
							cipherText += homophones.get(homophoneIndex("P")).get(rnd.nextInt(homophones.get(homophoneIndex("P")).size()));
							break;
						case 'Q':
							cipherText += homophones.get(homophoneIndex("Q")).get(rnd.nextInt(homophones.get(homophoneIndex("Q")).size()));
							break;
						case 'R':
							cipherText += homophones.get(homophoneIndex("R")).get(rnd.nextInt(homophones.get(homophoneIndex("R")).size()));
							break;
						case 'S':
							cipherText += homophones.get(homophoneIndex("S")).get(rnd.nextInt(homophones.get(homophoneIndex("S")).size()));
							break;
						case 'T':
							cipherText += homophones.get(homophoneIndex("T")).get(rnd.nextInt(homophones.get(homophoneIndex("T")).size()));
							break;
						case 'U':
							cipherText += homophones.get(homophoneIndex("U")).get(rnd.nextInt(homophones.get(homophoneIndex("U")).size()));
							break;
						case 'V':
							cipherText += homophones.get(homophoneIndex("V")).get(rnd.nextInt(homophones.get(homophoneIndex("V")).size()));
							break;
						case 'W':
							cipherText += homophones.get(homophoneIndex("W")).get(rnd.nextInt(homophones.get(homophoneIndex("W")).size()));
							break;
						case 'X':
							cipherText += homophones.get(homophoneIndex("X")).get(rnd.nextInt(homophones.get(homophoneIndex("X")).size()));
							break;
						case 'Y':
							cipherText += homophones.get(homophoneIndex("Y")).get(rnd.nextInt(homophones.get(homophoneIndex("Y")).size()));
							break;
						case 'Z':
							cipherText += homophones.get(homophoneIndex("Z")).get(rnd.nextInt(homophones.get(homophoneIndex("Z")).size()));
							break;	
					    case 'É':
					    	cipherText += homophones.get(homophoneIndex("É")).get(rnd.nextInt(homophones.get(homophoneIndex("É")).size()));
							break;
						case 'À':
							cipherText += homophones.get(homophoneIndex("À")).get(rnd.nextInt(homophones.get(homophoneIndex("À")).size()));
							break;
					    case 'È':
							cipherText += homophones.get(homophoneIndex("È")).get(rnd.nextInt(homophones.get(homophoneIndex("È")).size()));
							break;
						case 'Ê':
							cipherText += homophones.get(homophoneIndex("Ê")).get(rnd.nextInt(homophones.get(homophoneIndex("Ê")).size()));
							break;
						case 'Ç':
							cipherText += homophones.get(homophoneIndex("Ç")).get(rnd.nextInt(homophones.get(homophoneIndex("Ç")).size()));
							break;
						case 'Ô':
							cipherText += homophones.get(homophoneIndex("Ô")).get(rnd.nextInt(homophones.get(homophoneIndex("Ô")).size()));
								break;
						case 'Ù':
							cipherText += homophones.get(homophoneIndex("Ù")).get(rnd.nextInt(homophones.get(homophoneIndex("Ù")).size()));
							break;
						case 'Â':
							cipherText += homophones.get(homophoneIndex("Â")).get(rnd.nextInt(homophones.get(homophoneIndex("Â")).size()));
							break;
						case 'Î':
							cipherText += homophones.get(homophoneIndex("Î")).get(rnd.nextInt(homophones.get(homophoneIndex("Î")).size()));
							break;
						case 'Ï':
							cipherText += homophones.get(homophoneIndex("Ï")).get(rnd.nextInt(homophones.get(homophoneIndex("Ï")).size()));
							break;
						case 'Ë':
							cipherText += homophones.get(homophoneIndex("Ë")).get(rnd.nextInt(homophones.get(homophoneIndex("Ë")).size()));;
							break;
						case 'Ü':
							cipherText += homophones.get(homophoneIndex("Ü")).get(rnd.nextInt(homophones.get(homophoneIndex("Ü")).size()));
							break;
						case 'Ÿ':
							cipherText += homophones.get(homophoneIndex("Ÿ")).get(rnd.nextInt(homophones.get(homophoneIndex("Ÿ")).size()));
							break;
						case 'Û':
							cipherText += homophones.get(homophoneIndex("Û")).get(rnd.nextInt(homophones.get(homophoneIndex("Û")).size()));
							break;
							
							}
				   break;
				   
				case GERMAN:
					switch(Character.toUpperCase(plainText[i])){
						case ' ':
							cipherText +=" ";
					    	break;
						case 'A':
							cipherText += homophones.get(homophoneIndex("A")).get(rnd.nextInt(homophones.get(homophoneIndex("A")).size()));
							break;
						case 'B':
							cipherText += homophones.get(homophoneIndex("B")).get(rnd.nextInt(homophones.get(homophoneIndex("B")).size()));
							break;
						case 'C': 
							cipherText += homophones.get(homophoneIndex("C")).get(rnd.nextInt(homophones.get(homophoneIndex("C")).size()));
							break;
						case 'D':
							cipherText += homophones.get(homophoneIndex("D")).get(rnd.nextInt(homophones.get(homophoneIndex("D")).size()));
							break;
						case 'E':
							cipherText += homophones.get(homophoneIndex("E")).get(rnd.nextInt(homophones.get(homophoneIndex("E")).size()));
							break;
						case 'F':
							cipherText += homophones.get(homophoneIndex("F")).get(rnd.nextInt(homophones.get(homophoneIndex("F")).size()));
							break;
						case 'G':
							cipherText += homophones.get(homophoneIndex("G")).get(rnd.nextInt(homophones.get(homophoneIndex("G")).size()));
							break;
						case 'H':
							cipherText += homophones.get(homophoneIndex("H")).get(rnd.nextInt(homophones.get(homophoneIndex("H")).size()));
							break;
						case 'I':
							cipherText += homophones.get(homophoneIndex("I")).get(rnd.nextInt(homophones.get(homophoneIndex("I")).size()));
							break;
						case 'J': 
							cipherText += homophones.get(homophoneIndex("J")).get(rnd.nextInt(homophones.get(homophoneIndex("J")).size()));
							break;
						case 'K':
							cipherText += homophones.get(homophoneIndex("K")).get(rnd.nextInt(homophones.get(homophoneIndex("K")).size()));
							break;
						case 'L':
							cipherText += homophones.get(homophoneIndex("L")).get(rnd.nextInt(homophones.get(homophoneIndex("L")).size()));
							break;
						case 'M':
							cipherText += homophones.get(homophoneIndex("M")).get(rnd.nextInt(homophones.get(homophoneIndex("M")).size()));
							break;
						case 'N':
							cipherText += homophones.get(homophoneIndex("N")).get(rnd.nextInt(homophones.get(homophoneIndex("N")).size()));
							break;
						case 'O':
							cipherText += homophones.get(homophoneIndex("O")).get(rnd.nextInt(homophones.get(homophoneIndex("O")).size()));
							break;
						case 'P':
							cipherText += homophones.get(homophoneIndex("P")).get(rnd.nextInt(homophones.get(homophoneIndex("P")).size()));
							break;
						case 'Q':
							cipherText += homophones.get(homophoneIndex("Q")).get(rnd.nextInt(homophones.get(homophoneIndex("Q")).size()));
							break;
						case 'R':
							cipherText += homophones.get(homophoneIndex("R")).get(rnd.nextInt(homophones.get(homophoneIndex("R")).size()));
							break;
						case 'S':
							cipherText += homophones.get(homophoneIndex("S")).get(rnd.nextInt(homophones.get(homophoneIndex("S")).size()));
							break;
						case 'T':
							cipherText += homophones.get(homophoneIndex("T")).get(rnd.nextInt(homophones.get(homophoneIndex("T")).size()));
							break;
						case 'U':
							cipherText += homophones.get(homophoneIndex("U")).get(rnd.nextInt(homophones.get(homophoneIndex("U")).size()));
							break;
						case 'V':
							cipherText += homophones.get(homophoneIndex("V")).get(rnd.nextInt(homophones.get(homophoneIndex("V")).size()));
							break;
						case 'W':
							cipherText += homophones.get(homophoneIndex("W")).get(rnd.nextInt(homophones.get(homophoneIndex("W")).size()));
							break;
						case 'X':
							cipherText += homophones.get(homophoneIndex("X")).get(rnd.nextInt(homophones.get(homophoneIndex("X")).size()));
							break;
						case 'Y':
							cipherText += homophones.get(homophoneIndex("Y")).get(rnd.nextInt(homophones.get(homophoneIndex("Y")).size()));
							break;
						case 'Z':
							cipherText += homophones.get(homophoneIndex("Z")).get(rnd.nextInt(homophones.get(homophoneIndex("Z")).size()));
							break;	
						case 'Ü': 
							cipherText += homophones.get(homophoneIndex("Ü")).get(rnd.nextInt(homophones.get(homophoneIndex("Ü")).size()));
							break;
						case 'Ä':
							cipherText += homophones.get(homophoneIndex("Ä")).get(rnd.nextInt(homophones.get(homophoneIndex("Ä")).size()));
							break;
						case 'ẞ':
							cipherText += homophones.get(homophoneIndex("ẞ")).get(rnd.nextInt(homophones.get(homophoneIndex("ẞ")).size()));
							break;
						case 'Ö':
							cipherText += homophones.get(homophoneIndex("Ö")).get(rnd.nextInt(homophones.get(homophoneIndex("Ö")).size()));
							break;
					}
					break;
				case SPANISH:
					switch(Character.toUpperCase(plainText[i])){
						case ' ':
							cipherText +=" ";
					    	break;
						case 'A':
							cipherText += homophones.get(homophoneIndex("A")).get(rnd.nextInt(homophones.get(homophoneIndex("A")).size()));
								break;
						case 'B':
							cipherText += homophones.get(homophoneIndex("B")).get(rnd.nextInt(homophones.get(homophoneIndex("B")).size()));
								break;
						case 'C': 
							cipherText += homophones.get(homophoneIndex("C")).get(rnd.nextInt(homophones.get(homophoneIndex("C")).size()));
								break;
						case 'D':
							cipherText += homophones.get(homophoneIndex("D")).get(rnd.nextInt(homophones.get(homophoneIndex("D")).size()));
								break;
						case 'E':
							cipherText += homophones.get(homophoneIndex("E")).get(rnd.nextInt(homophones.get(homophoneIndex("E")).size()));
								break;
						case 'F':
							cipherText += homophones.get(homophoneIndex("F")).get(rnd.nextInt(homophones.get(homophoneIndex("F")).size()));
								break;
						case 'G':
							cipherText += homophones.get(homophoneIndex("G")).get(rnd.nextInt(homophones.get(homophoneIndex("G")).size()));
								break;
						case 'H':
							cipherText += homophones.get(homophoneIndex("H")).get(rnd.nextInt(homophones.get(homophoneIndex("H")).size()));
								break;
						case 'I':
							cipherText += homophones.get(homophoneIndex("I")).get(rnd.nextInt(homophones.get(homophoneIndex("I")).size()));
								break;
						case 'J': 
							cipherText += homophones.get(homophoneIndex("J")).get(rnd.nextInt(homophones.get(homophoneIndex("J")).size()));
								break;
						case 'K':
							cipherText += homophones.get(homophoneIndex("K")).get(rnd.nextInt(homophones.get(homophoneIndex("K")).size()));
								break;
						case 'L':
							cipherText += homophones.get(homophoneIndex("L")).get(rnd.nextInt(homophones.get(homophoneIndex("L")).size()));
								break;
						case 'M':
							cipherText += homophones.get(homophoneIndex("M")).get(rnd.nextInt(homophones.get(homophoneIndex("M")).size()));
								break;
						case 'N':
							cipherText += homophones.get(homophoneIndex("N")).get(rnd.nextInt(homophones.get(homophoneIndex("N")).size()));
								break;
						case 'O':
							cipherText += homophones.get(homophoneIndex("O")).get(rnd.nextInt(homophones.get(homophoneIndex("O")).size()));
								break;
						case 'P':
							cipherText += homophones.get(homophoneIndex("P")).get(rnd.nextInt(homophones.get(homophoneIndex("P")).size()));
								break;
						case 'Q':
							cipherText += homophones.get(homophoneIndex("Q")).get(rnd.nextInt(homophones.get(homophoneIndex("Q")).size()));
								break;
						case 'R':
							cipherText += homophones.get(homophoneIndex("R")).get(rnd.nextInt(homophones.get(homophoneIndex("R")).size()));
								break;
						case 'S':
							cipherText += homophones.get(homophoneIndex("S")).get(rnd.nextInt(homophones.get(homophoneIndex("S")).size()));
								break;
						case 'T':
							cipherText += homophones.get(homophoneIndex("T")).get(rnd.nextInt(homophones.get(homophoneIndex("T")).size()));
								break;
						case 'U':
							cipherText += homophones.get(homophoneIndex("U")).get(rnd.nextInt(homophones.get(homophoneIndex("U")).size()));
								break;
						case 'V':
							cipherText += homophones.get(homophoneIndex("V")).get(rnd.nextInt(homophones.get(homophoneIndex("V")).size()));
								break;
						case 'W':
							cipherText += homophones.get(homophoneIndex("W")).get(rnd.nextInt(homophones.get(homophoneIndex("W")).size()));
								break;
						case 'X':
							cipherText += homophones.get(homophoneIndex("X")).get(rnd.nextInt(homophones.get(homophoneIndex("X")).size()));
								break;
						case 'Y':
							cipherText += homophones.get(homophoneIndex("Y")).get(rnd.nextInt(homophones.get(homophoneIndex("Y")).size()));
								break;
						case 'Z':
							cipherText += homophones.get(homophoneIndex("Z")).get(rnd.nextInt(homophones.get(homophoneIndex("Z")).size()));
								break;
						case 'Í':
							cipherText += homophones.get(homophoneIndex("Í")).get(rnd.nextInt(homophones.get(homophoneIndex("Í")).size()));
								break;
						case 'Ó':
							cipherText += homophones.get(homophoneIndex("Ó")).get(rnd.nextInt(homophones.get(homophoneIndex("Ó")).size()));
								break;
						case 'É':
							cipherText += homophones.get(homophoneIndex("É")).get(rnd.nextInt(homophones.get(homophoneIndex("É")).size()));
								break;
						case 'Á': 
							cipherText += homophones.get(homophoneIndex("Á")).get(rnd.nextInt(homophones.get(homophoneIndex("Á")).size()));
								break;
						case 'Ñ':
							cipherText += homophones.get(homophoneIndex("Ñ")).get(rnd.nextInt(homophones.get(homophoneIndex("Ñ")).size()));
								break;
						case 'Ú':
							cipherText += homophones.get(homophoneIndex("Ú")).get(rnd.nextInt(homophones.get(homophoneIndex("Ú")).size()));
							break;		
					}
					break;
					
				
			  }
			  i++;
		}
		
		super.setCipherText(cipherText); // assign the result to the cipher-text field
		hideDigits(); // convert digits into symbols to hide them
	
		}
	


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	

/**A private method to be invoked internally in the encrypt method
 * it returns the the appropriate index of specific letter in the random alphabet
 * which corresponds to what should be a right strip index in the homophones
 * so it tracks the index of the homophone (which should be equal to the index of the random alphabet) according
 *  to the index of given letter in the random alphabet
 * @Param: String letter
 */
 private int homophoneIndex(String letter){
	 Iterator<String> index = super.getRandomAlphabet().iterator();
	 int i=0;
	 while(index.hasNext()){
		 if(letter.equals(index.next())){
			 return i;
		 }
		 i++;
	 }
	 return 0;
 }

 

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


 
	/**This method converts the digits in the homophones into symbols
	 * every digit can be assigned randomly one out of three possible symbols,
	 * exist constantly in the 2D symbol array
	 */
	private void hideDigits(){
		if (super.getCipherText().length()>0){ // check if there is cipher-text
			String temp = ""; // literal string temp to hold the symbolized cipher-text
			String [][]symbols = super.getSymbols();
			char ch[] = super.getCipherText().toCharArray(); // change the string into array of chars to manipulate 
			Random rnd = new Random();
			int i=0;
	
			while (i<ch.length){ // while didn't reach the end of the array of chars
				  switch (ch[i]){
				  // always the same cardinality in the 2D symbols array for each specific digit or for the space in encryption/decryption
					  case ' ':
						  temp+=symbols[0][rnd.nextInt(3)]; //concatenate randomly one of the three-constant symbols assigned to replace the space in the cipher text and so on..
						  break;  
					  case '0':
						  temp+=symbols[1][rnd.nextInt(3)];
						  break;
					  case '1':
						  temp+=symbols[2][rnd.nextInt(3)];
						  break;
					  case '2':
						  temp+=symbols[3][rnd.nextInt(3)];
						  break;
					  case '3':
						  temp+=symbols[4][rnd.nextInt(3)];
						  break;
					  case '4':
						  temp+=symbols[5][rnd.nextInt(3)];
						  break;
					  case '5':
						  temp+=symbols[6][rnd.nextInt(3)];
						  break;
					  case '6':
						  temp+=symbols[7][rnd.nextInt(3)];
						  break;
					  case '7':
						  temp+=symbols[8][rnd.nextInt(3)];
						  break;
					  case '8':
						  temp+=symbols[9][rnd.nextInt(3)];
						  break;
					  case '9':
						  temp+=symbols[10][rnd.nextInt(3)];
						  break; 
				  }
				  i++;
		}
			super.setCipherText(temp); // assign the temp string to the cipher-text field
		
		}
	}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/**a private setter method invoked internally to add the strips incrementally to the homophones table
	 * it increments the index in the homophones-array and then returns it
	 * @Param: ArrayList<String> strip
	 * @Param: homophonesIndex
	 */
	private int setStrips(ArrayList<String> strip, int homophonesIndex){
		// we need to make a copy because strip object is passed by reference(pointer to object)
		// thus any change in the parameter "strip" later will affect and overwrite the old values 
		homophones.add(homophonesIndex,copyArrayList(strip)); 
		return ++homophonesIndex;	
	}
	


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	/**This private method is invoked internally to re-distribute
	 * the generated homophones according to the most frequent letter in the language
	 * @Param: language of the enum Class Language type
	 */
	private void redistributeHomophonesInTable(Language language){
		/*Descending Letter Frequency For Each Language
		*English e t a o i n s r h l d c u m f p g w y b v k x j q z
		*French e s a i t n r u l o d c m p é v q f b g h j à x è y ê z ç ô ù â û î w k ï ë ü ñ
		*German e n i s r a t d h u l c g m o b w f k z v ü p ä ß j ö y q x
		*Spanish e a o s r n i d l c t u m p b g y í v q ó h f z j é á ñ x ú w k7
		*/
		
		if (super.getKeyword().size()>0){// check if there is keyword to avoid infinitive loops
			ArrayList<ArrayList<String>> homophoneTableCopy = new ArrayList<ArrayList<String>>();
			switch(language){
				case ENGLISH:
					for(int i=0; i<26;i++){ // make a copy of the homophones Table
						ArrayList<String> temp = copyArrayList(homophones.get(i));
						homophoneTableCopy.add(temp);
					}
					for(int i=0; i<26;i++){ // cycle through the entire alphabet
						switch(super.getRandomAlphabet().get(i)){ // check what is the alphabet
							case "E": // if it's the letter "E", assign to it a big strip because its frequency in English Language is high and so on...
								homophones.set(i,homophoneTableCopy.get(0));
								break;
							case "T":
								homophones.set(i,homophoneTableCopy.get(1));
								break;
							case "A": 
								homophones.set(i,homophoneTableCopy.get(2));
								break;
							case "O":
								homophones.set(i,homophoneTableCopy.get(3));
								break;
							case "I":
								homophones.set(i,homophoneTableCopy.get(4));
								break;
							case "N":
								homophones.set(i,homophoneTableCopy.get(5));
								break;
							case "S":
								homophones.set(i,homophoneTableCopy.get(6));
								break;
							case "R":
								homophones.set(i,homophoneTableCopy.get(7));
								break;
							case "H":
								homophones.set(i,homophoneTableCopy.get(8));
								break;
							case "L": 
								homophones.set(i,homophoneTableCopy.get(9));
								break;
							case "D":
								homophones.set(i,homophoneTableCopy.get(10));
								break;
							case "C":
								homophones.set(i,homophoneTableCopy.get(11));
								break;
							case "U":
								homophones.set(i,homophoneTableCopy.get(12));
								break;
							case "M":
								homophones.set(i,homophoneTableCopy.get(13));
								break;
							case "F":
								homophones.set(i,homophoneTableCopy.get(14));
								break;
							case "P":
								homophones.set(i,homophoneTableCopy.get(15));
								break;
							case "G":
								homophones.set(i,homophoneTableCopy.get(16));
								break;
							case "W":
								homophones.set(i,homophoneTableCopy.get(17));
								break;
							case "Y":
								homophones.set(i,homophoneTableCopy.get(18));
								break;
							case "B":
								homophones.set(i,homophoneTableCopy.get(19));
								break;
							case "V":
								homophones.set(i,homophoneTableCopy.get(20));
								break;
							case "K":
								homophones.set(i,homophoneTableCopy.get(21));
								break;
							case "X":
								homophones.set(i,homophoneTableCopy.get(22));
								break;
							case "J":
								homophones.set(i,homophoneTableCopy.get(23));
								break;
							case "Q":
								homophones.set(i,homophoneTableCopy.get(24));
								break;
							case "Z":
								homophones.set(i,homophoneTableCopy.get(25));
								break;
						}
						
					}
					
					break;
				case FRENCH:
					for(int i=0; i<40;i++){
						ArrayList<String> temp = copyArrayList(homophones.get(i));
						homophoneTableCopy.add(temp);
					}
					for(int i=0; i<40;i++){
						switch(super.getRandomAlphabet().get(i)){
							case "E": 
								homophones.set(i,homophoneTableCopy.get(0));
								break;
							case "S":
								homophones.set(i,homophoneTableCopy.get(1));
								break;
							case "A":
								homophones.set(i,homophoneTableCopy.get(2));
								break;
							case "I":
								homophones.set(i,homophoneTableCopy.get(3));
								break;
							case "T":
								homophones.set(i,homophoneTableCopy.get(4));
								break;
							case "N":
								homophones.set(i,homophoneTableCopy.get(5));
								break;
							case "R":
								homophones.set(i,homophoneTableCopy.get(6));
								break;
							case "U":
								homophones.set(i,homophoneTableCopy.get(7));
								break;
							case "L":
								homophones.set(i,homophoneTableCopy.get(8));
								break;
							case "O": 
								homophones.set(i,homophoneTableCopy.get(9));
								break;
							case "D":
								homophones.set(i,homophoneTableCopy.get(10));
								break;
							case "C":
								homophones.set(i,homophoneTableCopy.get(11));
								break;
							case "M":
								homophones.set(i,homophoneTableCopy.get(12));
								break;
							case "P":
								homophones.set(i,homophoneTableCopy.get(13));
								break;
							case "É":
								homophones.set(i,homophoneTableCopy.get(14));
								break;
							case "V": 
								homophones.set(i,homophoneTableCopy.get(15));
								break;
							case "Q":
								homophones.set(i,homophoneTableCopy.get(16));
								break;
							case "F":
								homophones.set(i,homophoneTableCopy.get(17));
								break;
							case "B":
								homophones.set(i,homophoneTableCopy.get(18));
								break;
							case "G":
								homophones.set(i,homophoneTableCopy.get(19));
								break;
							case "H":
								homophones.set(i,homophoneTableCopy.get(20));
								break;
							case "J":
								homophones.set(i,homophoneTableCopy.get(21));
								break;
							case "À":
								homophones.set(i,homophoneTableCopy.get(22));
								break;
							case "X":
								homophones.set(i,homophoneTableCopy.get(23));
								break;
							case "È":
								homophones.set(i,homophoneTableCopy.get(24));
								break;
							case "Y":
								homophones.set(i,homophoneTableCopy.get(25));
								break;
							case "Ê":
								homophones.set(i,homophoneTableCopy.get(26));
								break;
							case "Z":
								homophones.set(i,homophoneTableCopy.get(27));
								break;
							case "Ç":
								homophones.set(i,homophoneTableCopy.get(28));
								break;
							case "Ô":
								homophones.set(i,homophoneTableCopy.get(29));
								break;
							case "Ù":
								homophones.set(i,homophoneTableCopy.get(30));
								break;
							case "Â":
								homophones.set(i,homophoneTableCopy.get(31));
								break;
							case "Î":
								homophones.set(i,homophoneTableCopy.get(32));
								break;
							case "W":
								homophones.set(i,homophoneTableCopy.get(33));
								break;
							case "K":
								homophones.set(i,homophoneTableCopy.get(34));
								break;
							case "Ï":
								homophones.set(i,homophoneTableCopy.get(35));
								break;
							case "Ë":
								homophones.set(i,homophoneTableCopy.get(36));
								break;
							case "Ü":
								homophones.set(i,homophoneTableCopy.get(37));
								break;
							case "Ÿ":
								homophones.set(i,homophoneTableCopy.get(38));
								break;
							case "Û":
								homophones.set(i,homophoneTableCopy.get(39));
								break;
						
						}
					}
				   break;
				   
				case GERMAN:
					for(int i=0; i<30;i++){
						ArrayList<String> temp = copyArrayList(homophones.get(i));
						homophoneTableCopy.add(temp);
					}
					for(int i=0; i<30;i++){
						switch(super.getRandomAlphabet().get(i)){
							case "E":
								homophones.set(i,homophoneTableCopy.get(0));
								break;
							case "N":
								homophones.set(i,homophoneTableCopy.get(1));
								break;
							case "I":
								homophones.set(i,homophoneTableCopy.get(2));
								break;
							case "S":
								homophones.set(i,homophoneTableCopy.get(3));
								break;
							case "R":
								homophones.set(i,homophoneTableCopy.get(4));
								break;
							case "A":
								homophones.set(i,homophoneTableCopy.get(5));
								break;
							case "T":
								homophones.set(i,homophoneTableCopy.get(6));
								break;
							case "D":
								homophones.set(i,homophoneTableCopy.get(7));
								break;
							case "H":
								homophones.set(i,homophoneTableCopy.get(8));
								break;
							case "U":
								homophones.set(i,homophoneTableCopy.get(9));
								break;
							case "L":
								homophones.set(i,homophoneTableCopy.get(10));
								break;
							case "C":
								homophones.set(i,homophoneTableCopy.get(11));
								break;
							case "G":
								homophones.set(i,homophoneTableCopy.get(12));
								break;
							case "M":
								homophones.set(i,homophoneTableCopy.get(13));
								break;
							case "O":
								homophones.set(i,homophoneTableCopy.get(14));
								break;
							case "B":
								homophones.set(i,homophoneTableCopy.get(15));
								break;
							case "W":
								homophones.set(i,homophoneTableCopy.get(16));
								break;
							case "F":
								homophones.set(i,homophoneTableCopy.get(17));
								break;
							case "K":
								homophones.set(i,homophoneTableCopy.get(18));
								break;
							case "Z":
								homophones.set(i,homophoneTableCopy.get(19));
								break;
							case "V":
								homophones.set(i,homophoneTableCopy.get(20));
								break;
							case "Ü": 
								homophones.set(i,homophoneTableCopy.get(21));
								break;
							case "P":
								homophones.set(i,homophoneTableCopy.get(22));
								break;
							case "Ä":
								homophones.set(i,homophoneTableCopy.get(23));
								break;
							case "ẞ":
								homophones.set(i,homophoneTableCopy.get(24));
								break;
							case "J":
								homophones.set(i,homophoneTableCopy.get(25));
								break;
							case "Ö":
								homophones.set(i,homophoneTableCopy.get(26));
								break;
							case "Y":
								homophones.set(i,homophoneTableCopy.get(27));
								break;
							case "Q":
								homophones.set(i,homophoneTableCopy.get(28));
								break;
							case "X":
								homophones.set(i,homophoneTableCopy.get(29));
								break;
						
						
						}
					}
						
					break;
				case SPANISH:
					for(int i=0; i<32;i++){
						ArrayList<String> temp = copyArrayList(homophones.get(i));
						homophoneTableCopy.add(temp);
					}
					for(int i=0; i<32;i++){
						switch(super.getRandomAlphabet().get(i)){
							case "E": 
								homophones.set(i,homophoneTableCopy.get(0));
								break;
							case "A":
								homophones.set(i,homophoneTableCopy.get(1));
								break;
							case "O":
								homophones.set(i,homophoneTableCopy.get(2));
								break;
							case "S":
								homophones.set(i,homophoneTableCopy.get(3));
								break;
							case "R":
								homophones.set(i,homophoneTableCopy.get(4));
								break;
							case "N":
								homophones.set(i,homophoneTableCopy.get(5));
								break;
							case "I":
								homophones.set(i,homophoneTableCopy.get(6));
								break;
							case "D":
								homophones.set(i,homophoneTableCopy.get(7));
								break;
							case "L":
								homophones.set(i,homophoneTableCopy.get(8));
								break;
							case "C":
								homophones.set(i,homophoneTableCopy.get(9));
								break;
							case "T":
								homophones.set(i,homophoneTableCopy.get(10));
								break;
							case "U":
								homophones.set(i,homophoneTableCopy.get(11));
								break;
							case "M":
								homophones.set(i,homophoneTableCopy.get(12));
								break;
							case "P":
								homophones.set(i,homophoneTableCopy.get(13));
								break;
							case "B":
								homophones.set(i,homophoneTableCopy.get(14));
								break;
							case "G":
								homophones.set(i,homophoneTableCopy.get(15));
								break;
							case "Y":
								homophones.set(i,homophoneTableCopy.get(16));
								break;
							case "Í":
								homophones.set(i,homophoneTableCopy.get(17));
								break;
							case "V":
								homophones.set(i,homophoneTableCopy.get(18));
								break;
							case "Q": 
								homophones.set(i,homophoneTableCopy.get(19));
								break;
							case "Ó":
								homophones.set(i,homophoneTableCopy.get(20));
								break;
							case "H":
								homophones.set(i,homophoneTableCopy.get(21));
								break;
							case "F":
								homophones.set(i,homophoneTableCopy.get(22));
								break;
							case "Z":
								homophones.set(i,homophoneTableCopy.get(23));
								break;
							case "J":
								homophones.set(i,homophoneTableCopy.get(24));
								break;
							case "É":
								homophones.set(i,homophoneTableCopy.get(25));
								break;
							case "Á": 
								homophones.set(i,homophoneTableCopy.get(26));
								break;
							case "Ñ":
								homophones.set(i,homophoneTableCopy.get(27));
								break;
							case "X":
								homophones.set(i,homophoneTableCopy.get(28));
								break;
							case "Ú":
								homophones.set(i,homophoneTableCopy.get(29));
								break;
							case "W":
								homophones.set(i,homophoneTableCopy.get(30));
								break;
							case "K":
								homophones.set(i,homophoneTableCopy.get(31));
							break;
							}
						}
					}
			}
		}
    
}





