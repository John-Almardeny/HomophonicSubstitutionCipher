package ValidationPackage;

/**This is a custom Exception Class that extends Exception
 * and its name InvalidPlainTextException 
 * this class is an example of constructor overloading
 * @author Yahya Almardeny
 * @version 05/10/2016
 */
public class InvalidPlainTextException extends Exception {
    
	
	/** Default Serial Version ID*/
	private static final long serialVersionUID = 1L;

	/**the constructor of the objects of the Class InvalidPlainTextException
	 * it takes no parameter
	 */
	public InvalidPlainTextException() {
		// implicitly super constructor is invoked 
	}
    
	/**the constructor of the objects of the Class InvalidPlainTextException
	 * @param message
	 */
	public InvalidPlainTextException(String message) {
		super(message);
		
	}

}
