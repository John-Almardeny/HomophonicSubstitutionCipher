package cipheringPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import languagesPackage.Language;

/**This is Key Class that implements Serializable interface in order to store a copy of the key object later into file and send it
 * The Key is a combination of three main components that create the key:
 * Keyword, initial position and the homophones table
 * It contains an example about compile time polymorphism or what known as method overloading, namely: the "setKeyword" methods
 * @author Yahya Almardeny
 * @version 05/10/2016
 */

	public class Key implements Serializable{
		
		private static final long serialVersionUID = 1L;
		private ArrayList<String>orderedAlphabet; // The Ordered Alphabet
		private ArrayList<String>randomAlphabet; // The Random Alphabet
		private ArrayList<String> keyword; // The Keyword 
		private int initialPosition; // The Initial Position for Shifting
		protected ArrayList<ArrayList<String>> homophones; //ArrayList of ArrayLists to hold the Homophones, it will be accessed in subclasses
	
	   
		
		
	/**The Constructor for objects of class Key
	 * it takes no parameters
	 */
	public Key (){
	   orderedAlphabet = new ArrayList<String>();
	   randomAlphabet  = new ArrayList<String>();
	   keyword = new ArrayList<String>();
	   initialPosition = 0;
	   homophones = new ArrayList<ArrayList<String>>();
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**Method to set the language
	* @param language
	*/
	public void setLanguage(Language language){ 
		switch (language){
			case ENGLISH: // 26 LETTER
				orderedAlphabet.add("A");
				orderedAlphabet.add("B");
				orderedAlphabet.add("C");
				orderedAlphabet.add("D");
				orderedAlphabet.add("E");
				orderedAlphabet.add("F");
				orderedAlphabet.add("G");
				orderedAlphabet.add("H");
				orderedAlphabet.add("I");
				orderedAlphabet.add("J");
				orderedAlphabet.add("K");
				orderedAlphabet.add("L");
				orderedAlphabet.add("M");
				orderedAlphabet.add("N");
				orderedAlphabet.add("O");
				orderedAlphabet.add("P");
				orderedAlphabet.add("Q");
				orderedAlphabet.add("R");
				orderedAlphabet.add("S");
				orderedAlphabet.add("T");
				orderedAlphabet.add("U");
				orderedAlphabet.add("V");
				orderedAlphabet.add("W");
				orderedAlphabet.add("X");
				orderedAlphabet.add("Y");
				orderedAlphabet.add("Z");
				break;
				
			case FRENCH: // 40 Letter
				orderedAlphabet.add("A");
				orderedAlphabet.add("B");
				orderedAlphabet.add("C");
				orderedAlphabet.add("D");
				orderedAlphabet.add("E");
				orderedAlphabet.add("F");
				orderedAlphabet.add("G");
				orderedAlphabet.add("H");
				orderedAlphabet.add("I");
				orderedAlphabet.add("J");
				orderedAlphabet.add("K");
				orderedAlphabet.add("L");
				orderedAlphabet.add("M");
				orderedAlphabet.add("N");
				orderedAlphabet.add("O");
				orderedAlphabet.add("P");
				orderedAlphabet.add("Q");
				orderedAlphabet.add("R");
				orderedAlphabet.add("S");
				orderedAlphabet.add("T");
				orderedAlphabet.add("U");
				orderedAlphabet.add("V");
				orderedAlphabet.add("W");
				orderedAlphabet.add("X");
				orderedAlphabet.add("Y");
				orderedAlphabet.add("Z");
				orderedAlphabet.add("Ù");
				orderedAlphabet.add("Û");
				orderedAlphabet.add("Ü");
				orderedAlphabet.add("Ÿ");
				orderedAlphabet.add("À");
				orderedAlphabet.add("Â");
				orderedAlphabet.add("Ç");
				orderedAlphabet.add("É");
				orderedAlphabet.add("È");
				orderedAlphabet.add("Ê");
				orderedAlphabet.add("Ë");
				orderedAlphabet.add("Ï");
				orderedAlphabet.add("Î");
				orderedAlphabet.add("Ô");
				break;
			
			case GERMAN:// 30 Letter
				orderedAlphabet.add("A");
				orderedAlphabet.add("B");
				orderedAlphabet.add("C");
				orderedAlphabet.add("D");
				orderedAlphabet.add("E");
				orderedAlphabet.add("F");
				orderedAlphabet.add("G");
				orderedAlphabet.add("H");
				orderedAlphabet.add("I");
				orderedAlphabet.add("J");
				orderedAlphabet.add("K");
				orderedAlphabet.add("L");
				orderedAlphabet.add("M");
				orderedAlphabet.add("N");
				orderedAlphabet.add("O");
				orderedAlphabet.add("P");
				orderedAlphabet.add("Q");
				orderedAlphabet.add("R");
				orderedAlphabet.add("S");
				orderedAlphabet.add("T");
				orderedAlphabet.add("U");
				orderedAlphabet.add("V");
				orderedAlphabet.add("W");
				orderedAlphabet.add("X");
				orderedAlphabet.add("Y");
				orderedAlphabet.add("Z");
				orderedAlphabet.add("Ä"); 
				orderedAlphabet.add("Ö");
				orderedAlphabet.add("Ü");
				orderedAlphabet.add("ẞ");
				break;
			
			case SPANISH: // 32 Letter
				orderedAlphabet.add("A");
				orderedAlphabet.add("B");
				orderedAlphabet.add("C");
				orderedAlphabet.add("D");
				orderedAlphabet.add("E");
				orderedAlphabet.add("F");
				orderedAlphabet.add("G");
				orderedAlphabet.add("H");
				orderedAlphabet.add("I");
				orderedAlphabet.add("J");
				orderedAlphabet.add("K");
				orderedAlphabet.add("L");
				orderedAlphabet.add("M");
				orderedAlphabet.add("N");
				orderedAlphabet.add("Ñ");
				orderedAlphabet.add("O");
				orderedAlphabet.add("P");
				orderedAlphabet.add("Q");
				orderedAlphabet.add("R");
				orderedAlphabet.add("S");
				orderedAlphabet.add("T");
				orderedAlphabet.add("U");
				orderedAlphabet.add("V");
				orderedAlphabet.add("W");
				orderedAlphabet.add("X");
				orderedAlphabet.add("Y");
				orderedAlphabet.add("Z");
				orderedAlphabet.add("Á");
				orderedAlphabet.add("É");
				orderedAlphabet.add("Í");
				orderedAlphabet.add("Ó");
				orderedAlphabet.add("Ú");
				break;		
		}
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**Method to get the Ordered Alphabet
	 * @return orderedAlphabet
	 */
	public ArrayList<String> getOrderedAlphabet(){
		return orderedAlphabet;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**Method to set the Initial Position
	 *@param initialPos
	 */
	public void setInitialPosition(int initialPos){
		//initialPosition = (initialPos>0 ? initialPos : 0;
		if (initialPos>0){ // check for incorrect values (i.e Negative numbers)
			initialPosition = initialPos;
		}
		else {initialPosition = 0;} // change negative number to zero by default	
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**Getter method that returns the initial position
	* @return initialPostion
	*/
	public int getInitialPosition(){
		return initialPosition;
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**Getter method that returns the keyword
	 *@return keyword
	 */
	public ArrayList<String> getKeyword() {
		return keyword;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**Method to set the keyword
	 * @param keyword 
	 */
	public void setKeyword(ArrayList<String> keyword) {
		this.keyword = new ArrayList<String>(); // every time this method is invoked, create a new object of the keyword ArrayList
		this.keyword = removeDuplicatesFromKeyword(keyword); // internally invoke this private method to remove duplicates from the keyword
		for(int i=0; i<this.keyword.size();i++){
			this.keyword.set(i,this.keyword.get(i).toUpperCase()); // change all lowercase letters (if any) to uppercase to have a uniform
		}
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This method overloads the first setKeyword method
	 * and sets the keyword by passing a String parameter not any ArrayList
	 * @param keyword
	 */
	public void setKeyword (String keyword){
		this.keyword = new ArrayList<String>(); // every time this method is invoked, create a new object of the keyword ArrayList
		ArrayList<String> keywordArray = new ArrayList<String>();
		for (int i=0; i<keyword.length();i++){
			keywordArray.add(i, keyword.substring(i, i+1));
		}
		this.keyword = removeDuplicatesFromKeyword(keywordArray);
		for(int i=0; i<this.keyword.size();i++){
			this.keyword.set(i,this.keyword.get(i).toUpperCase()); // change all lowercase letters (if any) to uppercase to have a uniform
		}
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	/**A setter Method to create and set the Random Alphabet
	 *@param language
	 */
	public void setRandomAlphabet(Language language){
		randomAlphabet = new ArrayList<String>(); // every time this method is invoked, create a new object of the randomAlphabet ArrayList
		int keywordLen = keyword.size();
		if(keywordLen>0){ // first of all check if the keyword exists/inserted
			ArrayList<String> trimmedOrderedAlphabet = remainingLettersOfordAlphabet();// invoking this method internally returns what left in the ordered alphabet after excluding the keyword letters
			int rows = numberOfRows(trimmedOrderedAlphabet,keywordLen, language)+1;//invoking this method internally returns how many rows will be in the keyword matrix
			ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>(); // container to pick up the strips from keyword matrix
			Iterator<String> trimmedOrdAlphabet = trimmedOrderedAlphabet.iterator(); // to iterate through the trimmed ordered alphabet
		
			container.add(0,keyword); // first add the keyword
			int counter = 1; // then start from index 1
			while (counter<rows){ // while there are more rows in the keyword matrix
				ArrayList<String> temp = new ArrayList<String>(); // create a temporary ArrayList
				for(int i=0;i<keywordLen;i++){ // and for each row (which equals to the keyword length)
							if(trimmedOrdAlphabet.hasNext()){
								 temp.add(trimmedOrdAlphabet.next()); // add eery element of the row to the temporary array
							}
				}
				container.add(counter,temp); //then add the generated row to the container
				counter++;
			}
			
		    int x=0;
		    /*copy the transpose of the container (i.e. strips) to the random alphabet*/
			for(int i=0;i<keywordLen;i++){
				for(int j=0;j<rows;j++){
					try{ // because the strips may not be equal in size
					randomAlphabet.add(x,container.get(j).get(i));
					x++;
					}
					catch (IndexOutOfBoundsException e){rows--;} // when failed to add, that means rest of the strips are less in one index
				}
			}
		    x--;
		    if (x>=0){ // to check if the random number was generated
				String lastLetter = new String(); // create a string to hold the last letter of the set of the random alphabet while shifting
				int shifts = initialPosition;  // how many shifts
				
				while(shifts>0){ // repeat shifting
					lastLetter = randomAlphabet.get(x);
					for(int i=x; i>=1;i--){ // shift all letters by one
						randomAlphabet.set(i,randomAlphabet.get(i-1));
				}
				randomAlphabet.set(0,lastLetter);
				shifts--;
				}
		    }
		}
		else{randomAlphabet = copyArrayList(orderedAlphabet);} // if no alphabet was generated, so random alphabet is identical to the ordered alphabet	
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/** A getter method to get the Random Alphabet
	 * @return randomAlphabet
	 */
	public ArrayList<String> getRandomAlphabet(){
		return randomAlphabet;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/** A setter method to set the homophones
	 * @param homophones
	 */
	public void setHomophones(ArrayList<ArrayList<String>> homophones){
		this.homophones = homophones;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	/** A getter method to return the homophones table
	 * @return homophones
	 */
	public ArrayList<ArrayList<String>> getHomophones(){
		return homophones;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/** Private method to return an ArrayList of the remaining letter of the ordered alphabet
	 * this method will be invoked internally to compare the keyword with the ordered alphabet
	 * it removes all letters already exist in the keyword from the ordered alphabet
	 * @return copyOfOrderedAlphabet
	 */
	private ArrayList<String> remainingLettersOfordAlphabet(){
		ArrayList<String> copyOfOrderedAlphabet = copyArrayList(orderedAlphabet);
		int orderedAlphaLen = copyOfOrderedAlphabet.size()-1;
		
		int keywordLen = keyword.size();
		if(keywordLen!=orderedAlphaLen+1){ // to make sure that the keyword doesn't contain all the alphabet of the language
			while(orderedAlphaLen>=0){
				for(int i=0;i<keywordLen;i++){
					if(keyword.get(i).equalsIgnoreCase(copyOfOrderedAlphabet.get(orderedAlphaLen))){ // start from the end of the ordered alphabet (the copy)
						copyOfOrderedAlphabet.remove(orderedAlphaLen);
					}
				}
				orderedAlphaLen--;
			}
		}
		return copyOfOrderedAlphabet;
		
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	/**Private method that is invoked internally to remove the duplicates from the keyword
	 * @Param: ArrayList<String> keyword
	 * @return keyword
	 */
	private ArrayList<String> removeDuplicatesFromKeyword(ArrayList<String> keyword){
		int size = keyword.size();
		for(int i=0; i<size;i++){ // cycle through every index of the ArrayList in ascending order
			for(int j=(size-1); j>0;j--){ // and cycle through every index of the ArrayList in descending order
				if (i!=j){ // if the two indices are not equal (in order not to compare every index with itself)
					if (keyword.get(i).equalsIgnoreCase(keyword.get(j))){ // if they are two different indices and they are equal
						keyword.remove(j); // remove the duplicate
						size--; // decrement the size of the keyword in order not to go beyond the boundary 
					}
				}
			}
		}
		return keyword;		
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	/** Private method that is invoked internally to calculate the number of the generated keyword matrix
	 * @Param: language of the enum Class Language type
	 * @Param: keywordLen of type int
	 * @Param: ArrayList<String> trimmedOrderedAlphabet
	 * @return number of rows
	 */
	private int numberOfRows(ArrayList<String> trimmedOrderedAlphabet, int keywordLen, Language language){
		int trimmedOrderedAlphaLen = trimmedOrderedAlphabet.size(); 
	    int maximumLen=0;
	    switch(language){
		    case ENGLISH:
		    	maximumLen=26;
		    	break;
		    case FRENCH:
		    	maximumLen=40;
		    	break;
		    case GERMAN:
		    	maximumLen=30;
		    	break;
		    case SPANISH:
		    	maximumLen=32;
		    	break;
	    }
		if(trimmedOrderedAlphaLen!=maximumLen){ // to check if the the keyword contains all alphabet of the language
			double decimal = (double)trimmedOrderedAlphaLen/keywordLen; // what left of the alphabet will be split on rows of the keyword length
			int integer = (int)decimal;
			double floatingPoint = decimal - integer;
			if(floatingPoint>0){ // that means there is a row that is not completed (less that the keyword length) 
				return ++integer; // increment integer then return it
			}
			else {return integer;} // that means ordered alphabet is split equally on the keyword matrix
		}
		else return 0; // if the key word contains all the alphabet, there will be no keyword matrix, all we need to create the Key is to shift (if initial position >0)	
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	 /**Java passes objects by reference
	 * so any change on the parameter will change the original object
	 * to avoid this while doing some manipulating on the ArrayLists 
	 * this method returns a copy of a given ArrayList of type String
	 * it is identified protected to be used in the subclasses 
	 *@Param ArrayList<String> originalArray
	 *@return copyOfArrayList
	 */
	protected ArrayList<String> copyArrayList(ArrayList<String> originalArray){
		ArrayList<String> copyOfArrayList = new ArrayList<String>();
		for(int i=0; i<originalArray.size();i++){
			copyOfArrayList.add(originalArray.get(i));
		}
		return copyOfArrayList;
	}
	


}