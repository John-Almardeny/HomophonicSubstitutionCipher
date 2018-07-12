package GUIPackage;


import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Splash Screen Class
 * @author Yahya Almardeny
 * @version 05/10/2016
 */
public class SplashScreen {
	/*No Fields Required*/
	/*Eclipse implicitly creates a constructor when it's not created*/

	
	/**This method simply shows the splash screen for a while
	 * then it disappears to move to the next frame/window
	 */
	public void showSplashScreen() {
		JFrame frame = new JFrame(); // create new frame
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
		frame.setResizable(false); // deactivate resizablity
		frame.setUndecorated(true); // disable the native decoration of the frame
		frame.add(new JLabel(new  ImageIcon(this.getClass().getResource("/GUIPackage/images/splashBG.png")))); // set new icon
		frame.pack(); // sizes the frame to fit the image
		frame.setLocationRelativeTo(null); // center the splash screen window
		frame.setVisible(true);
		try {
			Thread.sleep(4000); // try to sleep 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		frame.dispose(); //then dispose
	}

}
