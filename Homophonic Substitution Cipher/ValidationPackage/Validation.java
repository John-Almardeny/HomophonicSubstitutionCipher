package ValidationPackage;


import java.util.ArrayList;


import java.util.Iterator;

import languagesPackage.Language;

/**This is Class Validation
 * It validates the keyword, the initial position, the homophones and the plain-text
 * and throws custom exceptions for invalid inputs
 * The thrown exceptions will be handled in the GuiListener Class
 * It contains an example about compile time polymorphism or what known as method overloading
 * @author Yahya Almardeny
 * @version 05/10/2016
 */


public class Validation {
	/*The instance variables that contains each language alphabet*/
	static final String english[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	static final String french[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Ù","Û","Ü","Ÿ","À","Â","Ç","É","È","Ê","Ë","Ï","Î","Ô"};
	static final String german[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Ä","Ö","Ü","ẞ"};
	static final String spanish[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z","Á","É","Í","Ó","Ú"};

    
	/*The Constructor*/
	public Validation(){}
	
	
	/**This method validates the Keyword and throws InvalidKeywordException
	 * if there is any invalid input
	 * (i.e Empty Input or any invalid char such as a digit, a letter from another language)
	 * @param language
	 * @param  keyword
	 * @throws   InvalidKeywordException
	 */
	public static void validateKeyword(Language language, String keyword) throws InvalidKeywordException{
		switch (language){
		case ENGLISH:
			if (keyword.isEmpty() || keyword.replaceAll(" ", "").isEmpty()){
				throw new InvalidKeywordException("Empty Keyword!");	 
			}
			else if(!belongToLanguage(language, keyword.replaceAll(" ",""))){ // invoke internally the private method "belongToLanguage" which returns boolean
				throw new InvalidKeywordException("Invalid Keyword!");
			}
			break;
		case FRENCH:
			if (keyword.isEmpty() || keyword.replaceAll(" ", "").isEmpty()){
				throw new InvalidKeywordException("Mot-clé vide!");	 
			}
			else if(!belongToLanguage(language, keyword.replaceAll(" ",""))){ // invoke internally the private method "belongToLanguage" which returns boolean
				throw new InvalidKeywordException("Mot-clé non valide!");
			}
			break;
		case GERMAN:
			if (keyword.isEmpty() || keyword.replaceAll(" ", "").isEmpty()){
				throw new InvalidKeywordException("Leer Stichwort!");	 
			}
			else if(!belongToLanguage(language, keyword.replaceAll(" ",""))){ // invoke internally the private method "belongToLanguage" which returns boolean
				throw new InvalidKeywordException("Ungültiges Schlüsselwort!");
			}
			break;
		case SPANISH:
			if (keyword.isEmpty() || keyword.replaceAll(" ", "").isEmpty()){
				throw new InvalidKeywordException("Palabra clave vacía!");	 
			}
			else if(!belongToLanguage(language, keyword.replaceAll(" ",""))){ // invoke internally the private method "belongToLanguage" which returns boolean
				throw new InvalidKeywordException("Palabra clave no válida!");
			}
			break;
		}
	}
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	

	/**This method validates the Keyword and throws InvalidKeywordException
	 * if there is any invalid input
	 * (i.e Empty Input or any invalid char such as a digit, a letter from another language)
	 * It overloads the the first method that validates the keyword too (this is an example about compile time polymorphism)
	 * @param language
	 * @param keyword
	 * @throws InvalidKeywordException
	 */
	public static void validateKeyword(Language language, ArrayList<String> keyword) throws InvalidKeywordException{
		String keywordString= "";
		for (int i=0;i<keyword.size();i++){
			keywordString += keyword.get(i);
		}
		switch(language){
			case ENGLISH:
				if (keywordString.isEmpty() || keywordString.replaceAll(" ", "").isEmpty()){
					throw new InvalidKeywordException("Empty Keyword!");	 
				}
				else if(!belongToLanguage(language, keywordString.replaceAll(" ",""))){ // invoke internally the private method "belongToLanguage" which returns boolean
					throw new InvalidKeywordException("Invalid Keyword!");
				}
				break;
			case FRENCH:
				if (keywordString.isEmpty() || keywordString.replaceAll(" ", "").isEmpty()){
					throw new InvalidKeywordException("Mot-clé vide!");	 
				}
				else if(!belongToLanguage(language, keywordString.replaceAll(" ",""))){ // invoke internally the private method "belongToLanguage" which returns boolean
					throw new InvalidKeywordException("Mot-clé non valide!");
				}
				break;
			case GERMAN:
				if (keywordString.isEmpty() || keywordString.replaceAll(" ", "").isEmpty()){
					throw new InvalidKeywordException("Leer Stichwort!");	 
				}
				else if(!belongToLanguage(language, keywordString.replaceAll(" ",""))){ // invoke internally the private method "belongToLanguage" which returns boolean
					throw new InvalidKeywordException("Ungültiges Schlüsselwort!");
				}
				break;
			case SPANISH:
				if (keywordString.isEmpty() || keywordString.replaceAll(" ", "").isEmpty()){
					throw new InvalidKeywordException("Palabra clave vacía!");	 
				}
				else if(!belongToLanguage(language, keywordString.replaceAll(" ",""))){ // invoke internally the private method "belongToLanguage" which returns boolean
					throw new InvalidKeywordException("Palabra clave no válida!");
				}
				break;
		}
		
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/** This method validates the Initial Position and throws NumberFormatException
	 * if there is any invalid input(i.e Negative Number or a Non-digit)
	 * it's fine if it's empty because the constructor of every instance
	 * of the program initialize the "Initial-Position" with zero value 
	 * zero value is accepted (which means no initial position)
	 * it will be read as a String then it will be parsed
	 * @param initialPostion
	 * @throws NumberFormatException
	 */
	public static void validateInitialPostion(String initialPostion)throws NumberFormatException{
		if (!onlyDigits(initialPostion)){ // invoke internally the private method "onlyDigits" which returns boolean
			throw new NumberFormatException("Invalid Initial-Position!");
		}
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**This method validates the Plain-Text and throws InvalidPlainTextException
	 * if there is any invalid input
	 * (i.e Empty Input or any invalid char such as a digit, a symbol or a letter from another language)
	 * @param language
	 * @param plainText
	 * @throws InvalidPlainTextException
	 */
	public static void validatePlainText(Language language, String plainText) throws InvalidPlainTextException{
		switch (language){
		case ENGLISH:
			if (plainText.isEmpty() || plainText.replaceAll(" ", "").isEmpty()){
				throw new InvalidPlainTextException("Empty Plain-Text!");
			}
			else if(!belongToLanguage(language, plainText.replaceAll(" ",""))){// invoke internally the private method "belongToLanguage" which returns boolean
				throw new InvalidPlainTextException("Invalid Plain-Text!");
			}
			break;
		case FRENCH:
			if (plainText.isEmpty() || plainText.replaceAll(" ", "").isEmpty()){
				throw new InvalidPlainTextException("Vide Texte-Brut!");
			}
			else if(!belongToLanguage(language, plainText.replaceAll(" ",""))){// invoke internally the private method "belongToLanguage" which returns boolean
				throw new InvalidPlainTextException("Invalide Texte-Brut!");
			}
			break;
		case GERMAN:
			if (plainText.isEmpty() || plainText.replaceAll(" ", "").isEmpty()){
				throw new InvalidPlainTextException("Leere Klartext!");
			}
			else if(!belongToLanguage(language, plainText.replaceAll(" ",""))){// invoke internally the private method "belongToLanguage" which returns boolean
				throw new InvalidPlainTextException("Ungültige Klartext!");
			}
			break;
		case SPANISH:
			if (plainText.isEmpty() || plainText.replaceAll(" ", "").isEmpty()){
				throw new InvalidPlainTextException("Texto Plano Vacía!");
			}
			else if(!belongToLanguage(language, plainText.replaceAll(" ",""))){// invoke internally the private method "belongToLanguage" which returns boolean
				throw new InvalidPlainTextException("Texto Plano No Válido!");
			}
			break;
		}
		
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/** This method validates the Homophones Table and throws NumberFormatException
	 * if there is any Non-digit among the homophones
	 * @param language
	 * @param homophonesTable
	 * @throws NumberFormatException
	 */
	public static void validateHomophonesTable(Language language, ArrayList<ArrayList<String>> homophonesTable) throws InvalidHomophonesException{
	
			int i=0;
			switch (language){
				case ENGLISH:
					if (!detectEmptyStrip(homophonesTable)){
						try{
							i=26;
							for (int j=0;j<i;j++){
								ArrayList<String> strip = new ArrayList<String>();
								strip = homophonesTable.get(j);
								Iterator<String> itr =  strip.iterator();
								while (itr.hasNext()){
									String s = itr.next();
									if (!onlyDigits(s)){throw new InvalidHomophonesException ("Invalid Homophones!");}
								}
							}
						}
						catch (IndexOutOfBoundsException e){ // that happens when the user loads a key that contains homophones table with columns less than 26
							   // in fact that's important for the French, German and Spanish Languages in particular
							   // because English key contains the least numbers of columns among the supported languages in this program
							  // so it won't go out of the index bound if the user loaded a French key to be used as an English key but NOT vice versa
								throw  new InvalidHomophonesException ("Invalid Key!");
						}
					}
					else {throw new InvalidHomophonesException ("Incomplete or Empty Homophones!");}
					break;
				case FRENCH:
					if (!detectEmptyStrip(homophonesTable)){
						i=40;
						try{
							for (int j=0;j<i;j++){
								ArrayList<String> strip = new ArrayList<String>();
								strip = homophonesTable.get(j);
								Iterator<String> itr =  strip.iterator();
								while (itr.hasNext()){
									String s = itr.next();
									if (!onlyDigits(s)){throw new InvalidHomophonesException ("Homophones Invalide!");}
								}
							}
						}
						catch (IndexOutOfBoundsException e){
								throw  new InvalidHomophonesException ("Clé Invalide!");
						}
						
					}
					else {throw new InvalidHomophonesException ("Homophones Incomplète ou Vides!");}
					break;
				case GERMAN:
					if (!detectEmptyStrip(homophonesTable)){
						try{
							i=30;
							for (int j=0;j<i;j++){
								ArrayList<String> strip = new ArrayList<String>();
								strip = homophonesTable.get(j);
								Iterator<String> itr =  strip.iterator();
								while (itr.hasNext()){
									String s = itr.next();
									if (!onlyDigits(s)){throw new InvalidHomophonesException ("Ungültige Homophones!");}
								}
							}
						}
						catch (IndexOutOfBoundsException e){
							throw  new InvalidHomophonesException ("Ungültige Schlüssel!");
						}
					}
					else {throw new NumberFormatException ("Unvollständige oder Leere Homophones!");}
					break;
				case SPANISH:
					if (!detectEmptyStrip(homophonesTable)){
						try{
							i=32;
							for (int j=0;j<i;j++){
								ArrayList<String> strip = new ArrayList<String>();
								strip = homophonesTable.get(j);
								Iterator<String> itr =  strip.iterator();
								while (itr.hasNext()){
									String s = itr.next();
									if (!onlyDigits(s)){throw new InvalidHomophonesException ("Homophones no válidos!");}
								}
							}
						}
						catch (IndexOutOfBoundsException e){
							throw  new InvalidHomophonesException ("Clave no válidos!");
						}
					}
					else {throw new InvalidHomophonesException ("Incompleta o Homophones Vacías!");}
					break;
				
			}
			
			
		
		
		}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	/** A private method that is invoked internally to check if a given String
	 * contains any invalid char that doesn't belong to the language alphabet
	 * @Param: language from the enum Class Language
	 * @Param String s
	 * @return boolean true or false
	 */
	private static boolean belongToLanguage(Language language, String s){
		boolean belong = false; // indicates if the char belongs to the alphabet of the language chosen
		switch(language){
			case ENGLISH:
				//compare every char in the given string with all alphabet
				for(int i=0; i<s.length();i++){
					for(int j=0; j<english.length;j++){
						if (s.substring(i, i+1).toUpperCase().equals(english[j])){
							//if found any match then it belongs
							belong = true;
						}
					}
					//after each complete-round of the second loop
					// if any char doesn't match, return false and stop the process
					
					if (!belong){return false;}
					belong=false;
				}
				break;
				
			case FRENCH:
				for(int i=0; i<s.length();i++){
					for(int j=0; j<french.length;j++){
						if (s.substring(i, i+1).toUpperCase().equals(french[j])){
							belong = true;
						}
					}
					if (!belong){return false;}
					belong=false;
				}
				break;
				
			case GERMAN:
				for(int i=0; i<s.length();i++ ){
					for(int j=0; j<german.length;j++){
						if (s.substring(i, i+1).toUpperCase().equals(german[j])){
							belong = true;
						}
					}
					if (!belong){return false;}
					belong=false;
				}
				break;
				
			case SPANISH:
				for(int i=0; i<s.length();i++){
					for(int j=0; j<spanish.length;j++){
						if (s.substring(i, i+1).toUpperCase().equals(spanish[j])){
							belong = true;
						}
					}
					if (!belong){return false;}
					belong=false;
				}
				break;
		}
			
		return true;	
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		
	
	
	/**This method checks if all chars in a given String are digits
	 * and returns true if all are digits
	 * whilst it returns false if any illegal char found
	 *@Param: String s
	 *@return boolean true or false 
	 */
	private static boolean onlyDigits(String s){
		char c[] = s.replaceAll(" ","").toCharArray(); // convert the String into an array of chars after removing all spaces
		for (int i=0; i<c.length;i++){
			if(!Character.isDigit(c[i])){ // if any non-digit found, returns false and stop the process
				return false;		
			}
		}
		return true;
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
   private static boolean detectEmptyStrip(ArrayList<ArrayList<String>> homophones){
	   if (!homophones.isEmpty()){
		   for (int i=0; i<homophones.size(); i++){
				   if (homophones.get(i).isEmpty()){
					   return true;
				   }
		   }
	   }
	   else if (homophones.isEmpty()){return true;}
	   return false;
   }
	
}
