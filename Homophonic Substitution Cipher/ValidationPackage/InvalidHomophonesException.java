package ValidationPackage;

/**
 * InvalidHomophonesException is a customized Exception Class
 * It extends the Exception Class and contains two constructors
 * One of them can be called by overloading the second.
 * @author Yahya Almardeny
 * @version 05/10/2016
 */
public class InvalidHomophonesException extends Exception {


	 /** Default Serial Version ID*/
	private static final long serialVersionUID = 1L;
    
	
	public InvalidHomophonesException() {
	}
  
	
	public InvalidHomophonesException(String message) {
		super(message);
	}

}
