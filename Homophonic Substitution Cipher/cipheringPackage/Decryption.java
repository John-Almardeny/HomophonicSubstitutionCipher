package cipheringPackage;

/**This is Decryption Class that extends the Cipher Class
 * it performs all the decryption work
 * and stores the plain-text(which is the final-wanted result in decryption)in the private field "plainText"
 * @author Yahya Almardeny
 * @version 05/10/2016
 */



	public class Decryption extends Cipher {
	
	/** Default Serial Version ID*/
	private static final long serialVersionUID = 1L;


	/**Constructor for objects of class Decryption*/
	public Decryption() {
		// implicitly superclass constructor is invoked
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	/**This method decrypts the cipher-text
	 * it invokes internally other private methods in this class
	 * @param cipherText
	 */
	public void decrypt(String cipherText){
		super.setPlainText(mapHomophones(showHomophones(cipherText)));
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	/**This method convert the symbols in the cipher-text to digits
	 * in other words, it uncovers the homophons
	 * @Param: String cipherText
	 * @return String uncoveredCipherText
	 */
	private String showHomophones(String cipherText){
			String uncoveredCipherText = new String();
			uncoveredCipherText = "";
			String symbols[][]=super.getSymbols();
			if (cipherText.length()>0){
				int i=0, index =0;
					while(i<cipherText.length()){
						String ch = cipherText.substring(i,i+1); // read char by char but as a string
						for (int j=0; j<symbols.length;j++){//  loop through the entire 2D symbols array
							  for (int x=0;x<symbols[j].length;x++){
								  if (ch.equals(symbols[j][x])){//if found match, assign the loop var j to the index and break both for loops
									  index=j;
									  j=11; 
									  break;   
								  }
							  }
						}
							switch(index){ // convert the found symbol into its original digit
								case 0:
									uncoveredCipherText+=" ";
								  break;
								case 1:
									uncoveredCipherText+="0";	
								  break;
								case 2:
									uncoveredCipherText+="1";
								  break;
								case 3:
									uncoveredCipherText+="2";
								  break;
								case 4:
									uncoveredCipherText+="3";
								  break;
								case 5:
									uncoveredCipherText+="4";
								  break;
								case 6:
									uncoveredCipherText+="5";
								  break;
								case 7:
									uncoveredCipherText+="6";
								  break;
								case 8:
									uncoveredCipherText+="7";
								  break;
								case 9:
									uncoveredCipherText+="8";
								  break;
								case 10:
									uncoveredCipherText+="9";
								  break;
							  }
							i++;
						}
						
					}
			return uncoveredCipherText;
			}

	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	/**This method finds out the index -in the homophones table- of the homophone that is extracted from the cipher-text
	 * then it maps it to the corresponding alphabet in the random alphabet
	 * @Param: String cipherText
	 * @return String plainText
	 */
	private String mapHomophones(String cipherText){
		String plainText = "";
		if (cipherText.length()>0){
			int i=0, index =0;
				while(i<cipherText.length()){
					String ch = cipherText.substring(i,i+1);
					if (!ch.equals(" ")){ // if it's not a space, that means it's a digit, so take the next digit because every homophone contains a pair of digits
						ch += cipherText.substring(i+1,i+2);
						
						for (int j=0; j<homophones.size();j++){ // then find where is that homophone should be in the homophones table
							  for (int x=0;x<homophones.get(j).size();x++){
								  if (ch.equals(homophones.get(j).get(x))){
									  index=j;
									  j=homophones.size();
									  break;   
								  }
							  }
						}
						plainText+=super.getRandomAlphabet().get(index);	//map that homophone to corresponding alphabet in the randomalphabet
						i+=2; // because we moved 2 indices, increment "i" by 2
						
					}
					else if (ch.equals(" ")){plainText+=" "; i++;}// pick up spaces
					
				}
		}
		return plainText;
		}

	
}
			
			


