package cipheringPackage;

/**This is Cipher Class that extends the Key Class
 * It is the parent of both Encryption and Decryption Classes
 * It contains the shared attributes (fields) among Encryption and Decryption Classes
 * with getter and setter methods to manipulate them
 * @author Yahya Almardeny
 * @version 05/10/2016
 */

public class Cipher extends Key{
	
	 /** Default Serial Version ID*/
	private static final long serialVersionUID = 1L;

	private String cipherText; // the encrypted-text
	private String plainText; // the plain-text
	private final String [][]symbols = {{"#","$",";"},{"!","@","€"},{"~","|", "'"},{"%","^","["}, {"&","*","]"},{"(",")","{"},{"-","+","}"},{"=","/","£"},
								  {"\\","\"","¡"},{"<",">","¿"},{".",":","±"}}; // a set of symbols to be used to hide the numbers in the cipher-text
	
	/**the constructor take no parameters*/
	public Cipher(){
		super(); // no need to explicitly call the superclass constructor
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**A setter method to set the plain text
	 * @param plainText
	 */
	public void setPlainText(String plainText){
		this.plainText = plainText;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**A getter method to get the plain text*/
	public String getPlainText(){
		return plainText;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A getter method to get the cipher text
	 * @return cipherText
	 * */
	public String getCipherText(){
		return this.cipherText;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**A setter method to set the cipher text
	 * @param cipherText
	 */
	public void setCipherText(String cipherText){
		this.cipherText = cipherText;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**A getter method to get the Symbols
	 * @return symbols
	 * */
	public String [][] getSymbols() {
		return symbols;
	}
    

	
}
