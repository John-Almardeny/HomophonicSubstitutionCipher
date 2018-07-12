package mainMethod;
import GUIPackage.GuiListener;
import GUIPackage.LanguageWindow;
import GUIPackage.SplashScreen;

/**
 * This is the main class to run the program 
 * It launches the splash screen first by creating anonymous instance of the SplashScreen Class
 * then it moves to the first window in the program by invoking it from LanguageWindow Class
 * from that point, the GuiListener Class will take care for the rest of the actions 
 * @author Yahya Almardeny
 * @version 05/10/2016
 */
public final class HomophonicSubstitutionCipher {

	public static void main(String[] args){
		new SplashScreen().showSplashScreen();
		LanguageWindow.createLanguageWindow(new GuiListener());
    }

}
