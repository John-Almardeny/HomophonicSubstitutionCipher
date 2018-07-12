package GUIPackage;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import languagesPackage.Language;


/**
 * This is MainMenuWindow Class
 * It create the main menu of this app
 * that contains the main 5 options: Encryption, Decryption, How To Use, About , Exit.
 * in 5 different languages (English, French, German, Spanish)
 * @author Yahya Almardeny
 * @version 05/10/2016
 *
 */
public class MainMenuWindow {
	protected static JFrame frmMainMenu;

	/*Eclipse implicitly creates a constructor when it's not created*/
	
    /**
     * This methods creates the MainMenu Window
     * according to the language chosen by the user
     * @param language
     * @param listener
     */
	public static void createMainMenu(Language language, GuiListener listener){
		JLabel lblNewLabel;
		JButton btnEncryption,btnDecryption,btnHowToUse,btnAbout,btnExit;

		switch (language){
		case ENGLISH:
			frmMainMenu = new JFrame();
			frmMainMenu.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
			frmMainMenu.setForeground(Color.BLACK);
			frmMainMenu.setBackground(Color.LIGHT_GRAY);
			frmMainMenu.getContentPane().setBackground(Color.DARK_GRAY);
			frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(LanguageWindow.class.getResource("/GUIPackage/images/icon.png")));
			frmMainMenu.setTitle("Main Menu");
			frmMainMenu.setResizable(false);
			frmMainMenu.setBounds(10, 10, 394, 495);
			frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmMainMenu.setLocationRelativeTo(null);
			frmMainMenu.getContentPane().setLayout(null);
			
			btnEncryption = new JButton("ENCRYPTION");
			btnEncryption .setForeground(Color.BLACK);
			btnEncryption .setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnEncryption .setBounds(120, 133, 150, 34);
			btnEncryption.setFocusPainted(false);
			frmMainMenu.getContentPane().add(btnEncryption );
			btnEncryption.setActionCommand("Encryption");
			btnEncryption.addActionListener(listener);
			
			
			lblNewLabel = new JLabel("Main Menu");
			lblNewLabel.setEnabled(false);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(23, 57, 345, 34);
			frmMainMenu.getContentPane().add(lblNewLabel);
			
			
			btnDecryption = new JButton("DECRYPTION");
			btnDecryption.setForeground(Color.BLACK);
			btnDecryption.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDecryption.setFocusPainted(false);
			btnDecryption.setBounds(120, 197, 150, 34);
			frmMainMenu.getContentPane().add(btnDecryption);
			btnDecryption.setActionCommand("Decryption");
			btnDecryption.addActionListener(listener);
			
			
			
			btnHowToUse = new JButton("HOW TO USE");
			btnHowToUse.setForeground(Color.BLACK);
			btnHowToUse.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnHowToUse.setFocusPainted(false);
			btnHowToUse.setBounds(120, 258, 150, 34);
			frmMainMenu.getContentPane().add(btnHowToUse);
			btnHowToUse.setActionCommand("How To Use");
			btnHowToUse.addActionListener(listener);
			
			
			btnAbout = new JButton("ABOUT");
			btnAbout.setForeground(Color.BLACK);
			btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAbout.setFocusPainted(false);
			btnAbout.setBounds(120, 322, 150, 34);
			frmMainMenu.getContentPane().add(btnAbout);
			btnAbout.setActionCommand("About");
			btnAbout.addActionListener(listener);
			
			btnExit = new JButton("EXIT");
			btnExit.setForeground(Color.BLACK);
			btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnExit.setFocusPainted(false);
			btnExit.setBounds(120, 385, 150, 34);
			frmMainMenu.getContentPane().add(btnExit);
			btnExit.setActionCommand("Exit");
			btnExit.addActionListener(listener);
			frmMainMenu.setVisible(true);
			break;
			
			
		case FRENCH:
			frmMainMenu = new JFrame();
			frmMainMenu.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
			frmMainMenu.setForeground(Color.BLACK);
			frmMainMenu.setBackground(Color.LIGHT_GRAY);
			frmMainMenu.getContentPane().setBackground(Color.DARK_GRAY);
			frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(LanguageWindow.class.getResource("/GUIPackage/images/icon.png")));
			frmMainMenu.setTitle("Menu Principal");
			frmMainMenu.setResizable(false);
			frmMainMenu.setBounds(10, 10, 394, 495);
			frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmMainMenu.setLocationRelativeTo(null);
			frmMainMenu.getContentPane().setLayout(null);
			
			btnEncryption = new JButton("CRYPTAGE");
			btnEncryption.setForeground(Color.BLACK);
			btnEncryption.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnEncryption.setBounds(113, 133, 165, 34);
			btnEncryption.setFocusPainted(false);
			frmMainMenu.getContentPane().add(btnEncryption);
			btnEncryption.setActionCommand("Encryption");
			btnEncryption.addActionListener(listener);
			
			lblNewLabel = new JLabel("Menu Principal");
			lblNewLabel.setEnabled(false);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(23, 57, 345, 34);
			frmMainMenu.getContentPane().add(lblNewLabel);
			
			
			btnDecryption = new JButton("DÉCRYPTAGE");
			btnDecryption.setForeground(Color.BLACK);
			btnDecryption.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDecryption.setFocusPainted(false);
			btnDecryption.setBounds(113, 197, 165, 34);
			frmMainMenu.getContentPane().add(btnDecryption);
			btnDecryption.setActionCommand("Decryption");
			btnDecryption.addActionListener(listener);
			
			btnHowToUse = new JButton("COMMENT UTILISER");
			btnHowToUse.setForeground(Color.BLACK);
			btnHowToUse.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnHowToUse.setFocusPainted(false);
			btnHowToUse.setBounds(113, 258, 165, 34);
			frmMainMenu.getContentPane().add(btnHowToUse);
			btnHowToUse.setActionCommand("How To Use");
			btnHowToUse.addActionListener(listener);
			
			btnAbout = new JButton("À PROPOS DE NOUS");
			btnAbout.setForeground(Color.BLACK);
			btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAbout.setFocusPainted(false);
			btnAbout.setBounds(113, 322, 165, 34);
			frmMainMenu.getContentPane().add(btnAbout);
			btnAbout.setActionCommand("About");
			btnAbout.addActionListener(listener);
			
			btnExit = new JButton("SORTIE");
			btnExit.setForeground(Color.BLACK);
			btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnExit.setFocusPainted(false);
			btnExit.setBounds(113, 385, 165, 34);
			frmMainMenu.getContentPane().add(btnExit);
			btnExit.setActionCommand("Exit");
			btnExit.addActionListener(listener);
			frmMainMenu.setVisible(true);
			break;
			
			
		case GERMAN:
			frmMainMenu = new JFrame();
			frmMainMenu.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
			frmMainMenu.setForeground(Color.BLACK);
			frmMainMenu.setBackground(Color.LIGHT_GRAY);
			frmMainMenu.getContentPane().setBackground(Color.DARK_GRAY);
			frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(LanguageWindow.class.getResource("/GUIPackage/images/icon.png")));
			frmMainMenu.setTitle("Hauptmenü");
			frmMainMenu.setResizable(false);
			frmMainMenu.setBounds(10, 10, 394, 495);
			frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmMainMenu.setLocationRelativeTo(null);
			frmMainMenu.getContentPane().setLayout(null);
			
			btnEncryption = new JButton("VERSCHLÜSSELUNG");
			btnEncryption.setForeground(Color.BLACK);
			btnEncryption.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnEncryption.setBounds(113, 133, 165, 34);
			frmMainMenu.getContentPane().add(btnEncryption);
			btnEncryption.setFocusPainted(false);
			btnEncryption.setActionCommand("Encryption");
			btnEncryption.addActionListener(listener);
			
			
			lblNewLabel = new JLabel("Hauptmenü");
			lblNewLabel.setEnabled(false);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(23, 57, 345, 34);
			frmMainMenu.getContentPane().add(lblNewLabel);
			
			
			btnDecryption = new JButton("ENTSCHLÜSSELUNG");
			btnDecryption.setForeground(Color.BLACK);
			btnDecryption.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDecryption.setFocusPainted(false);
			btnDecryption.setBounds(110, 197, 168, 34);
			frmMainMenu.getContentPane().add(btnDecryption);
			btnDecryption.setActionCommand("Decryption");
			btnDecryption.addActionListener(listener);
			
			btnHowToUse = new JButton("WIE BENUTZT MAN");
			btnHowToUse.setForeground(Color.BLACK);
			btnHowToUse.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnHowToUse.setFocusPainted(false);
			btnHowToUse.setBounds(113, 258, 165, 34);
			frmMainMenu.getContentPane().add(btnHowToUse);
			btnHowToUse.setActionCommand("How To Use");
			btnHowToUse.addActionListener(listener);
			
			btnAbout = new JButton("ÜBER UNS");
			btnAbout.setForeground(Color.BLACK);
			btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAbout.setFocusPainted(false);
			btnAbout.setBounds(113, 322, 165, 34);
			frmMainMenu.getContentPane().add(btnAbout);
			btnAbout.setActionCommand("About");
			btnAbout.addActionListener(listener);
			
			btnExit = new JButton("AUSGANG");
			btnExit.setForeground(Color.BLACK);
			btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnExit.setFocusPainted(false);
			btnExit.setBounds(113, 385, 165, 34);
			frmMainMenu.getContentPane().add(btnExit);
			btnExit.setActionCommand("Exit");
			btnExit.addActionListener(listener);
			frmMainMenu.setVisible(true);
			break;
			
			
		case SPANISH:
			frmMainMenu = new JFrame();
			frmMainMenu.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
			frmMainMenu.setForeground(Color.BLACK);
			frmMainMenu.setBackground(Color.LIGHT_GRAY);
			frmMainMenu.getContentPane().setBackground(Color.DARK_GRAY);
			frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(LanguageWindow.class.getResource("/GUIPackage/images/icon.png")));
			frmMainMenu.setTitle("Menú Principal");
			frmMainMenu.setResizable(false);
			frmMainMenu.setBounds(10, 10, 394, 495);
			frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmMainMenu.setLocationRelativeTo(null);
			frmMainMenu.getContentPane().setLayout(null);
			
			btnEncryption = new JButton("ENCRIPTACIÓN");
			btnEncryption.setForeground(Color.BLACK);
			btnEncryption.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnEncryption.setBounds(113, 133, 165, 34);
			btnEncryption.setFocusPainted(false);
			frmMainMenu.getContentPane().add(btnEncryption);
			btnEncryption.setActionCommand("Encryption");
			btnEncryption.addActionListener(listener);
			
			lblNewLabel = new JLabel("Menú Principal");
			lblNewLabel.setEnabled(false);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(23, 57, 345, 34);
			frmMainMenu.getContentPane().add(lblNewLabel);
			
			
			btnDecryption = new JButton("DESENCRIPTACIÓN");
			btnDecryption.setForeground(Color.BLACK);
			btnDecryption.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDecryption.setFocusPainted(false);
			btnDecryption.setBounds(110, 197, 168, 34);
			frmMainMenu.getContentPane().add(btnDecryption);
			btnDecryption.setActionCommand("Decryption");
			btnDecryption.addActionListener(listener);
			
			btnHowToUse = new JButton("CÓMO UTILIZAR");
			btnHowToUse.setForeground(Color.BLACK);
			btnHowToUse.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnHowToUse.setFocusPainted(false);
			btnHowToUse.setBounds(113, 258, 165, 34);
			frmMainMenu.getContentPane().add(btnHowToUse);
			btnHowToUse.setActionCommand("How To Use");
			btnHowToUse.addActionListener(listener);
			
			btnAbout = new JButton("SOBRE NOSOTROS");
			btnAbout.setForeground(Color.BLACK);
			btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAbout.setFocusPainted(false);
			btnAbout.setBounds(113, 322, 165, 34);
			frmMainMenu.getContentPane().add(btnAbout);
			btnAbout.setActionCommand("About");
			btnAbout.addActionListener(listener);
			
			btnExit = new JButton("SALIDA");
			btnExit.setForeground(Color.BLACK);
			btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnExit.setFocusPainted(false);
			btnExit.setBounds(113, 385, 165, 34);
			frmMainMenu.getContentPane().add(btnExit);
			btnExit.setActionCommand("Exit");
			btnExit.addActionListener(listener);
			frmMainMenu.setVisible(true);
			break;
		
		
		}
		
		
		
	}

}
