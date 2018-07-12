package ValidationPackage;

/**This is a custom Exception Class that extends Exception
 * and its name InvalidKeywordException 
 * this class is an example of constructor overloading
 * @author Yahya Almardeny
 * @version 05/10/2016
 */

public class InvalidKeywordException extends Exception{

	 /** Default Serial Version ID*/
	private static final long serialVersionUID = 1L;


	/**the constructor of the objects of the Class InvalidPlainTextException
	 * it takes no parameter
	 */
	public InvalidKeywordException() {
		// implicitly super constructor is called
	}
	
	
	/**the constructor of the objects of the Class InvalidPlainTextException
	 * it overloads the first constructor
	 * @param message
	 */
	public InvalidKeywordException(String message) {
		super(message);
	}

}
