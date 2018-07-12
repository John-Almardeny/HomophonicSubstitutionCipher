package GUIPackage;



import fileHandlingPackage.FileHandling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


import cipheringPackage.Decryption;
import cipheringPackage.Encryption;
import cipheringPackage.Key;
import languagesPackage.Language;
import ValidationPackage.InvalidHomophonesException;
import ValidationPackage.InvalidKeywordException;
import ValidationPackage.InvalidPlainTextException;
import ValidationPackage.Validation;


/**
 * This is GuiListener Class that implements ActionListener interface
 * It listens to all actions in all GUI Windows and acts upon them
 * Is listens to the actions performed by pressing the buttons on the UI in particular
 * This class is the soul of the program
 * @author Yahya Almardeny
 * @version 05/10/2016
 */
public class GuiListener implements ActionListener{
	
	private static Encryption enc;
	private static Decryption dec;
	

	


 public void actionPerformed(ActionEvent e)	{
	 
	 switch (e.getActionCommand()){ // the Action Command will specify which button was pressed
	  
	 	/*LISTEN TO THE LANGUAGEWINDOW*/
	 
		 case "Language Selected": // this action command generated when the O.k button in the LanguageWindow is pressed
			 switch(LanguageWindow.language){
		 		case ENGLISH:
		 			MainMenuWindow.createMainMenu(Language.ENGLISH, new GuiListener()); // create the main menu according to the language chosen
		 			LanguageWindow.chooseLanguage.dispose(); // close the LanguageWindow
		 			break;
		 			
		 		case FRENCH:
		 			MainMenuWindow.createMainMenu(Language.FRENCH, new GuiListener());
		 			LanguageWindow.chooseLanguage.dispose();
			 		break;
			 		
		 		case GERMAN:
		 			MainMenuWindow.createMainMenu(Language.GERMAN, new GuiListener());
		 			LanguageWindow.chooseLanguage.dispose();
			 		break;
			 		
		 		case SPANISH:
		 			MainMenuWindow.createMainMenu(Language.SPANISH, new GuiListener());
		 			LanguageWindow.chooseLanguage.dispose();
			 		break;
			 }
			 break;
			 
			 
			 
			 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			 
			 
			 
			 
		/*LISTEN TO THE MAINMENU WINDOW*/
			 
		 case "Encryption": // User Clicked "Encryption" Button in the Main Menu
			 switch(LanguageWindow.language){
			 	case ENGLISH:
					 EncryptionWindow.createEncryptionWindow(Language.ENGLISH, new GuiListener()); // open the Encryption Window in the chosen language
					 enc = new Encryption(); // create new Encryption object 
					 enc.setLanguage(Language.ENGLISH); // set the language of the object
					 MainMenuWindow.frmMainMenu.dispose(); // close the Main Menu Window
					 break;
					 
			 	case FRENCH:
					 EncryptionWindow.createEncryptionWindow(Language.FRENCH, new GuiListener());
					 enc = new Encryption();
					 enc.setLanguage(Language.FRENCH);
					 MainMenuWindow.frmMainMenu.dispose();
					 break;
					 
			 	case GERMAN:
					 EncryptionWindow.createEncryptionWindow(Language.GERMAN, new GuiListener());
					 enc = new Encryption();
					 enc.setLanguage(Language.GERMAN);
					 MainMenuWindow.frmMainMenu.dispose();
					 break;
					 
			 	case SPANISH:
					 EncryptionWindow.createEncryptionWindow(Language.SPANISH, new GuiListener());
					 enc = new Encryption();
					 enc.setLanguage(Language.SPANISH);
					 MainMenuWindow.frmMainMenu.dispose();
					 break;
			 }
			 break;
			 
			 
		 case "Decryption": // User Clicked "Decryption" Button in the Main Menu
			 switch(LanguageWindow.language){
			 	case ENGLISH:
					 DecryptionWindow.createDecryptionWindow(Language.ENGLISH, new GuiListener());// open the Decryption Window in the chosen language
					 dec = new Decryption(); // create new Decryption object
					 dec.setLanguage(Language.ENGLISH); // set the language of the object
					 MainMenuWindow.frmMainMenu.dispose(); // close the Main Menu Window
					 break;
					 
			 	case FRENCH:
			 		 DecryptionWindow.createDecryptionWindow(Language.FRENCH, new GuiListener());
			 		 dec = new Decryption();
			 		 dec.setLanguage(Language.FRENCH);
					 MainMenuWindow.frmMainMenu.dispose();
					 break;
					 
			 	case GERMAN:
			 		 DecryptionWindow.createDecryptionWindow(Language.GERMAN, new GuiListener());
			 		 dec = new Decryption();
			 		 dec.setLanguage(Language.GERMAN);
					 MainMenuWindow.frmMainMenu.dispose();
					 break;
					 
			 	case SPANISH:
				 	 DecryptionWindow.createDecryptionWindow(Language.SPANISH, new GuiListener());
				 	 dec = new Decryption();
				 	 dec.setLanguage(Language.SPANISH);
					 MainMenuWindow.frmMainMenu.dispose();
					 break;
			 }
			 break;
			 
			 
		 case "About":// User Clicked "About" Button in the Main Menu
			 switch(LanguageWindow.language){
			 	case ENGLISH:
			 		new AboutWindow(Language.ENGLISH); // create new About Window (this called anonymous object, there is no further operations on the object) in the chosen language
			 		break;
			 		
			 	case FRENCH:
			 		new AboutWindow(Language.FRENCH);
			 		break;
			 		
			 	case GERMAN:
			 		new AboutWindow(Language.GERMAN);
			 		break;
			 		
			 	case SPANISH:
			 		new AboutWindow(Language.SPANISH);
			 		break;
			 }	
			 break;
			 
			 
		 case "How To Use":// User Clicked "How To Use" Button in the Main Menu
			 switch(LanguageWindow.language){
			 
			 	case ENGLISH:
					 new HowToUseWindow(Language.ENGLISH); // create new HowToUse Window (this called anonymous object, there is no further operations on the object) in the chosen language
					 break;
					 
			 	case FRENCH:
					 new HowToUseWindow(Language.FRENCH);
					 break;
					 
			 	case GERMAN:
					 new HowToUseWindow(Language.GERMAN);
					 break;
					 
			 	case SPANISH:
					 new HowToUseWindow(Language.SPANISH);
					 break;
			 }
		     break;
			 
		 case "Exit": // User Clicked "Exit" Button in the Main Menu
			 System.exit(0); // simply exit the entire program in peace
			 break;
			 
			 
			 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			 
			 
		/*LISTEN TO THE ENCRYPTIONWINDOW*/
			 
		 case "Main Menu": // User Clicked "Main Menu" Button in the Encryption Window
			 switch(LanguageWindow.language){
			 	case ENGLISH:
			 		MainMenuWindow.createMainMenu(Language.ENGLISH, new GuiListener()); // create Main Menu Window
			 		EncryptionWindow.frame.dispose(); // close the current Encryption Window
			 		break;
			 		
			 	case FRENCH:
			 		MainMenuWindow.createMainMenu(Language.FRENCH, new GuiListener());
			 		EncryptionWindow.frame.dispose();
			 		break;
			 	
			 	case GERMAN:
			 		MainMenuWindow.createMainMenu(Language.GERMAN, new GuiListener());
			 		EncryptionWindow.frame.dispose();
			 		break;
			 	
			 	case SPANISH:
			 		MainMenuWindow.createMainMenu(Language.SPANISH, new GuiListener());
			 		EncryptionWindow.frame.dispose();
			 		break;
			 }
			 break;
			 
			 
		 case "Generate Homophones": // User Clicked "Generate" Button in the Encryption Window
			switch(LanguageWindow.language){
				case ENGLISH:
					try {
						 Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString()); // check the initial position, this method throws NumberFormatException 
						 enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue())); // if it's O.k, set it in the object
						 Validation.validateKeyword(Language.ENGLISH, EncryptionWindow.txtTypeTheKeyword.getText()); // check the keyword, this method throws InvalidKeywordException
						 enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText()); // if it's O.k, set it in the object
						 enc.setRandomAlphabet(Language.ENGLISH); // create the Random Alphabet that is vital for generating the Homophones Table
						 enc.generateHomophons(Language.ENGLISH); // generate the homophones
						 fillGeneratedHomophonesInTable(enc.getHomophones(), "ENGLISH", "Encryption"); // internally invoke this private method that fills the homophones in the GUI Table
					}
					catch(NumberFormatException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // pop-up message to inform the user about the error
					}
					catch(InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case FRENCH:
					 try {
						 Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
						 enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
						 Validation.validateKeyword(Language.FRENCH, EncryptionWindow.txtTypeTheKeyword.getText());
						 enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
						 enc.setRandomAlphabet(Language.FRENCH);
						 enc.generateHomophons(Language.FRENCH);
						 fillGeneratedHomophonesInTable(enc.getHomophones(), "FRENCH", "Encryption");
					 }
					 catch(NumberFormatException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
					 }
					 catch(InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
					 }
					 break;
					 
				 case GERMAN:
					 try {
						 Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
						 enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
						 Validation.validateKeyword(Language.GERMAN, EncryptionWindow.txtTypeTheKeyword.getText());
						 enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
						 enc.setRandomAlphabet(Language.GERMAN);
						 enc.generateHomophons(Language.GERMAN);
						 fillGeneratedHomophonesInTable(enc.getHomophones(), "GERMAN", "Encryption");
					 }
					 catch(NumberFormatException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
					 }
					 catch(InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
					 }
					 break;
				case SPANISH:
					 try {
						 Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
						 enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
						 Validation.validateKeyword(Language.SPANISH, EncryptionWindow.txtTypeTheKeyword.getText());
						 enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
						 enc.setRandomAlphabet(Language.SPANISH);
						 enc.generateHomophons(Language.SPANISH);
						 fillGeneratedHomophonesInTable(enc.getHomophones(), "SPANISH", "Encryption");
					 }
					 catch(NumberFormatException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					 }
					 catch(InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					 }
				 	 break;
			 }
			 break;
		
			 
		 case "Save Key": // User Clicked "Save" Button in the Encryption Window to save the Key 
			/*in case the user changed the key after generating the Homophones, make them aware about this if they're going to save they key
			 but the user is still able to save the key
			 */
			switch (LanguageWindow.language){
				 case ENGLISH:
				 	try{
				 	 Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
					 Validation.validateKeyword(Language.ENGLISH, EncryptionWindow.txtTypeTheKeyword.getText());
					 Validation.validateHomophonesTable(Language.ENGLISH, enc.getHomophones());
					 enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
					 enc.setHomophones(getHomophonesFromGuiTable("Encryption"));
					 enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
				 	}
					catch(NumberFormatException | InvalidHomophonesException | InvalidKeywordException m){ // give a little warning if there is any invalid component in the Key
						JOptionPane.showMessageDialog(null, "You are trying to save invalid key that cannot be encrypted/decrypted later", "Warning", JOptionPane.WARNING_MESSAGE);
			 		}
				 	break;
				 	
				 case FRENCH:
					try{
						Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
						Validation.validateKeyword(Language.FRENCH, EncryptionWindow.txtTypeTheKeyword.getText());
						Validation.validateHomophonesTable(Language.FRENCH, enc.getHomophones());
						enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
						enc.setHomophones(getHomophonesFromGuiTable("Encryption"));
						enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
				 	}
					catch(NumberFormatException | InvalidHomophonesException | InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, "Vous essayez d'enregistrer clé non valide qui ne peut pas être chiffré/déchiffré plus tard", "Attention", JOptionPane.WARNING_MESSAGE);
				 	}
					break;
					
				 	case GERMAN:
				 		try{
					 		 Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
							 Validation.validateKeyword(Language.GERMAN, EncryptionWindow.txtTypeTheKeyword.getText());
							 Validation.validateHomophonesTable(Language.GERMAN, enc.getHomophones());
							 enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
							 enc.setHomophones(getHomophonesFromGuiTable("Encryption"));
							 enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
				 		}
				 		catch(NumberFormatException | InvalidHomophonesException | InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, "Sie versuchen, ungültige Schlüssel zu speichern, die nicht verschlüsselt/entschlüsselt später werden kann", "Warnung", JOptionPane.WARNING_MESSAGE);
				 		}
				 		break;
				 		
				 	case SPANISH:
				 		try{
					 		 Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
							 Validation.validateKeyword(Language.SPANISH, EncryptionWindow.txtTypeTheKeyword.getText());
							 Validation.validateHomophonesTable(Language.SPANISH, enc.getHomophones());
							 enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
							 enc.setHomophones(getHomophonesFromGuiTable("Encryption"));
							 enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
				 		}
				 		catch(NumberFormatException | InvalidHomophonesException | InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, "Usted está tratando de guardar la clave no válido que no se pueden cifrar/descifrar tarde", "Advertencia", JOptionPane.WARNING_MESSAGE);
				 		}
				 		break;
			 }
			 FileHandling.saveKey(LanguageWindow.language, enc); // invoke the static method "saveKey" from the FileHandling Class to save the Key object
			 break;
			 
			 
		 case "Browse Key": // User Clicked "Browse" button in the EncryptionWindow to save the Key
			 Key k = new Encryption(); // create a Key object for the Encryption to hold the loaded key
			 switch (LanguageWindow.language){
			 	case ENGLISH:
			 		 try{ // check if the key is valid and make the user aware of any invalid key, the user is still able to load the invalid key but later they cannot use it to encrypt the plain text
			 			 k = FileHandling.openKey(Language.ENGLISH); // open the key and assign it to the key object
						 Validation.validateInitialPostion(((Integer)k.getInitialPosition()).toString()); // validate the initial position, this method throws NumberFormatException
						 Validation.validateKeyword(Language.ENGLISH, k.getKeyword()); // validate the keyword, this method throws InvalidKeywordException  
						 Validation.validateHomophonesTable(Language.ENGLISH, k.getHomophones()); // validate the homophones, this method throws InvalidHomophonesException
						 EncryptionWindow.txtTypeTheKeyword.setText(keywordAsString(k.getKeyword()));
						 EncryptionWindow.spinner.setValue((Integer)k.getInitialPosition());
						 fillGeneratedHomophonesInTable( k.getHomophones(), "ENGLISH", "Encryption");
					 }
					 catch(NumberFormatException | InvalidHomophonesException | InvalidKeywordException m){ // if invalid key found, give the user a little warning to be aware about the issue
							 JOptionPane.showMessageDialog(null, "You are trying to load invalid key that cannot be encrypted/decrypted later", "Warning", JOptionPane.WARNING_MESSAGE);
					 }
			 		 catch(NullPointerException   m){} // if the user chose inexistent file
			 		 break;
			 		 
			 	case FRENCH:
			 		 try{ 
			 			 k = FileHandling.openKey(Language.FRENCH);
						 Validation.validateInitialPostion(((Integer)k.getInitialPosition()).toString());
						 Validation.validateKeyword(Language.FRENCH, k.getKeyword()); 
						 Validation.validateHomophonesTable(Language.FRENCH, k.getHomophones());
						 EncryptionWindow.txtTypeTheKeyword.setText(keywordAsString(k.getKeyword()));
						 EncryptionWindow.spinner.setValue((Integer)k.getInitialPosition());
						 fillGeneratedHomophonesInTable( k.getHomophones(), "FRENCH", "Encryption");
					 }
					 catch(NumberFormatException | InvalidHomophonesException | InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, "Vous essayez de charger la clé non valide qui ne peut pas être chiffré/déchiffré plus tard", "Attention", JOptionPane.WARNING_MESSAGE);
					 }
			 		 catch(NullPointerException   m){}
					
			 		 break;
			 		
			 	case GERMAN:
			 		 try{
			 			k = FileHandling.openKey(Language.GERMAN);
						 Validation.validateInitialPostion(((Integer)k.getInitialPosition()).toString());
						 Validation.validateKeyword(Language.GERMAN, k.getKeyword()); 
						 Validation.validateHomophonesTable(Language.GERMAN, k.getHomophones());
						 EncryptionWindow.txtTypeTheKeyword.setText(keywordAsString(k.getKeyword()));
						 EncryptionWindow.spinner.setValue((Integer)k.getInitialPosition());
						 fillGeneratedHomophonesInTable( k.getHomophones(), "GERMAN", "Encryption");
					 }
					 catch(NumberFormatException | InvalidHomophonesException | InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, "Sie versuchen, ungültige Schlüssel zu laden, die nicht verschlüsselt/entschlüsselt später werden kann", "Warnung", JOptionPane.WARNING_MESSAGE);
					 }
			 		 catch(NullPointerException   m){}
			 		 
			 		 break;
			 		 
			 	case SPANISH:
			 		 try{
			 			 k = FileHandling.openKey(Language.SPANISH);
						 Validation.validateInitialPostion(((Integer)k.getInitialPosition()).toString());
						 Validation.validateKeyword(Language.SPANISH, k.getKeyword()); 
						 Validation.validateHomophonesTable(Language.SPANISH, k.getHomophones());
						 EncryptionWindow.txtTypeTheKeyword.setText(keywordAsString(k.getKeyword()));
						 EncryptionWindow.spinner.setValue((Integer)k.getInitialPosition());
						 fillGeneratedHomophonesInTable( k.getHomophones(), "SPANISH", "Encryption");
					 }
					 catch(NumberFormatException  | InvalidHomophonesException | InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, "Usted está tratando de cargar la clave no válido que no se pueden cifrar/descifrar tarde", "Advertencia", JOptionPane.WARNING_MESSAGE);
					 }
			 		 catch(NullPointerException   m){}

			 		break;
			 }
			 break;
			 
			 
		 case "Encrypt":// User Clicked "Encrypt" Button in the EncryptionWindow
			 // before attempting to encrypt, check everything again (in addition to the Plain-Text) in case the user inserted any invalid input after the first checking steps
			switch (LanguageWindow.language){
			   case ENGLISH:
				 if (EncryptionWindow.plainTextArea.getText().length()<=40000){ // although this program perform encryption/decryption in no time but if the number of letters > 40 000, 
					 //it takes the program more than 10 seconds in average to encrypt/decrypt. It's more convenient to split the huge text into smaller passages, 40 000 letters in cluding spaces means more than 10 A4 full pages!
				  try{
					   Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
					   Validation.validateKeyword(Language.ENGLISH, EncryptionWindow.txtTypeTheKeyword.getText());
					   Validation.validateHomophonesTable(Language.ENGLISH, getHomophonesFromGuiTable("Encryption"));
					   Validation.validatePlainText(Language.ENGLISH, EncryptionWindow.plainTextArea.getText()); // validate the Plain Text, this method throws InvalidPlainTextException 
					   enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
					   enc.setHomophones(getHomophonesFromGuiTable("Encryption"));
					   enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
					   enc.setRandomAlphabet(Language.ENGLISH); // create the Random Alphabet according to the new key (if anything has been changed)
					   enc.setPlainText(EncryptionWindow.plainTextArea.getText()); // set the plain text in the object
					   enc.encrypt(Language.ENGLISH); // encrypt
					   EncryptionWindow.createCipherWindow(Language.ENGLISH, new GuiListener()); // open the Cipher Text Window
					   EncryptionWindow.resultedCipherTextArea.setText(enc.getCipherText()); // display the Resulted Cipher Text
					   
					   
					   
				   }
				   /*Inform The User About The Error*/
				   catch(NumberFormatException m){
						 JOptionPane.showMessageDialog(null, "Invalid Initial Pos.", "Error", JOptionPane.ERROR_MESSAGE);
				   }
				   catch(InvalidHomophonesException message){
						 JOptionPane.showMessageDialog(null, message.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				   }
					catch(InvalidKeywordException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				   }
				   	catch(InvalidPlainTextException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				   }
				 }
				 else {JOptionPane.showMessageDialog(null, "The Plain-text is too big ("+  EncryptionWindow.plainTextArea.getText().length() + " letter) and cannot be encrypted in one go!\n" + "Max. number of letters allowed is 40 000 including spaces", "Notification", JOptionPane.INFORMATION_MESSAGE);}
				   break;
				   
			   case FRENCH:
				  if (EncryptionWindow.plainTextArea.getText().length()<=40000){
					 try{
					   Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
					   Validation.validateKeyword(Language.FRENCH, EncryptionWindow.txtTypeTheKeyword.getText());
					   Validation.validateHomophonesTable(Language.FRENCH, getHomophonesFromGuiTable("Encryption")); 
					   Validation.validatePlainText(Language.FRENCH, EncryptionWindow.plainTextArea.getText());
					   enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
					   enc.setHomophones(getHomophonesFromGuiTable("Encryption"));
					   enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
					   enc.setRandomAlphabet(Language.FRENCH);
					   enc.setPlainText(EncryptionWindow.plainTextArea.getText());
					   enc.encrypt(Language.FRENCH);
					   EncryptionWindow.createCipherWindow(Language.FRENCH, new GuiListener());
					   EncryptionWindow.resultedCipherTextArea.setText(enc.getCipherText());
	
				   }
				   catch(NumberFormatException m){
						 JOptionPane.showMessageDialog(null, "Invalid Pos. initiale", "Erreur", JOptionPane.ERROR_MESSAGE);
				   }
				   catch(InvalidHomophonesException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				   }
					 catch(InvalidKeywordException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				   }
					catch(InvalidPlainTextException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				  }
				 }
				  else {JOptionPane.showMessageDialog(null, "Le Plain-texte est trop grand ("+  EncryptionWindow.plainTextArea.getText().length() +" lettre) et ne peut pas être chiffré en une seule fois!\n" + "Max. Nombre de lettres autorisées est de 40 000 y compris les espaces", "Notification",  JOptionPane.INFORMATION_MESSAGE);}
				   break;
				   
			   case GERMAN:
				  if (EncryptionWindow.plainTextArea.getText().length()<=40000){
				   try{
					   Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
					   Validation.validateKeyword(Language.GERMAN, EncryptionWindow.txtTypeTheKeyword.getText());
					   Validation.validateHomophonesTable(Language.GERMAN, getHomophonesFromGuiTable("Encryption"));
					   Validation.validatePlainText(Language.GERMAN, EncryptionWindow.plainTextArea.getText());
					   enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
					   enc.setHomophones(getHomophonesFromGuiTable("Encryption"));
					   enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
					   enc.setRandomAlphabet(Language.GERMAN);
					   enc.setPlainText(EncryptionWindow.plainTextArea.getText());
					   enc.encrypt(Language.GERMAN);
					   EncryptionWindow.createCipherWindow(Language.GERMAN, new GuiListener());
					   EncryptionWindow.resultedCipherTextArea.setText(enc.getCipherText());
					
				   }
				   catch(NumberFormatException m){
						 JOptionPane.showMessageDialog(null, "Ungültige Anfangsposition", "Fehler", JOptionPane.ERROR_MESSAGE);
				   }
				   catch(InvalidHomophonesException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				   }
					 catch(InvalidKeywordException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
				   }
					catch(InvalidPlainTextException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				   }
				}
				   else {JOptionPane.showMessageDialog(null, "The Plain-Text zu groß ist (" + EncryptionWindow.plainTextArea.getText().length() +" Brief) und nicht in einem Rutsch verschlüsselt werden kann!\n" + "Max. Anzahl der Buchstaben erlaubt ist 40 000 inklusive Leerzeichen", "Benachrichtigung", JOptionPane.INFORMATION_MESSAGE);}
				   break;
				   
			   case SPANISH:
				 if (EncryptionWindow.plainTextArea.getText().length()<=40000){
				   try{
					   Validation.validateInitialPostion(((Integer)(EncryptionWindow.spinner.getValue())).toString());
					   Validation.validateKeyword(Language.SPANISH, EncryptionWindow.txtTypeTheKeyword.getText());
					   Validation.validateHomophonesTable(Language.SPANISH, getHomophonesFromGuiTable("Encryption"));
					   Validation.validatePlainText(Language.SPANISH, EncryptionWindow.plainTextArea.getText());
					   enc.setKeyword(EncryptionWindow.txtTypeTheKeyword.getText());
					   enc.setHomophones(getHomophonesFromGuiTable("Encryption"));
					   enc.setInitialPosition((Integer)(EncryptionWindow.spinner.getValue()));
					   enc.setRandomAlphabet(Language.SPANISH);
					   enc.setPlainText(EncryptionWindow.plainTextArea.getText());
					   enc.encrypt(Language.SPANISH);
					   EncryptionWindow.createCipherWindow(Language.SPANISH, new GuiListener());
					   EncryptionWindow.resultedCipherTextArea.setText(enc.getCipherText());
					  
				   }
				   catch(NumberFormatException m){
						 JOptionPane.showMessageDialog(null, "Posición inicial no válido", "Error", JOptionPane.ERROR_MESSAGE);
				   }
			       catch(InvalidHomophonesException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				   }
				   catch(InvalidKeywordException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				   }
				   catch(InvalidPlainTextException m){
						 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				   }
				}
				   else {JOptionPane.showMessageDialog(null, "El texto plano es demasiado grande (" + EncryptionWindow.plainTextArea.getText().length() + " letra) y no se puede cifrar en una sola vez!\n" + "Max. Número de letras permitidas es de 40 000 espacios incluidos", "Notificación", JOptionPane.INFORMATION_MESSAGE);}
				   break;										
	 			}
			 
			 break;
			 
			 
		 case "Browse Plain Text": // User Clicked "Browse" Button in the EncryptionWindow to load the plain text
			 EncryptionWindow.plainTextArea.setText(FileHandling.openFile(LanguageWindow.language)); // simply open the text file and fill its content in the Text Area in the EncryptionWindow
			 //The openFile method in the FileHandling Class will take care about any error and throws the appropriate exception and inform the user via pop-up messages
			 break;
			 
		
		 case "SaveCipherText":  // User Clicked "Save" Button in the CipherTextWindow to save the cipher text
			 FileHandling.saveFile(LanguageWindow.language, enc.getCipherText());// simply save the cipher text into a text file 
			 //The saveFile method in the FileHandling Class will take care about any error and throws the appropriate exception and inform the user via pop-up messages
			 break;
			 
		
			 
			 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			 
			 
			 
		/*LISTEN TO DECRYPTIONWINDOW*/
			 
		 case "Main Menu1": // User Clicked "Main Menu" Button in the DecryptionWindow, the Action Command is "MAin Menu1" to distinguish from the button in the EncryptionWindow
			 switch(LanguageWindow.language){
			 	case ENGLISH:
			 		MainMenuWindow.createMainMenu(Language.ENGLISH, new GuiListener());
			 		DecryptionWindow.frame.dispose();
			 		break;
			 		
			 	case FRENCH:
			 		MainMenuWindow.createMainMenu(Language.FRENCH, new GuiListener());
			 		DecryptionWindow.frame.dispose();
			 		break;
			 		
			 	case GERMAN:
			 		MainMenuWindow.createMainMenu(Language.GERMAN, new GuiListener());
			 		DecryptionWindow.frame.dispose();
			 		break;
			 		
			 	case SPANISH:
			 		MainMenuWindow.createMainMenu(Language.SPANISH, new GuiListener());
			 		DecryptionWindow.frame.dispose();
			 		break;
			 }
			 
			 break;	 
			 
			 
			 
		 case "Browse Key1":
			 Key k1 = new Key();
			 switch (LanguageWindow.language){
			 	case ENGLISH:
			 		 try{ // check if the key is valid and make the user aware of any invalid key, the user is still able to load the key
			 			 k1 = FileHandling.openKey(Language.ENGLISH);
						 Validation.validateInitialPostion(((Integer)k1.getInitialPosition()).toString());
						 Validation.validateKeyword(Language.ENGLISH, k1.getKeyword()); 
						 Validation.validateHomophonesTable(Language.ENGLISH, k1.getHomophones());
						 DecryptionWindow.txtTypeTheKeyword.setText(keywordAsString(k1.getKeyword()));
						 DecryptionWindow.spinner.setValue((Integer)k1.getInitialPosition());
						 fillGeneratedHomophonesInTable( k1.getHomophones(), "ENGLISH" , "Decryption");
					 }
					 catch(NumberFormatException | InvalidHomophonesException | InvalidKeywordException m){ // give a little warning and inform the user
							 JOptionPane.showMessageDialog(null, "You are trying to load invalid key that cannot be encrypted/decrypted later", "Warning", JOptionPane.WARNING_MESSAGE);
					 }
			 		 catch(NullPointerException   m){}
			 		break;
			 		
			 	case FRENCH:
			 		 try{
			 			 k1 = FileHandling.openKey(Language.FRENCH);
						 Validation.validateInitialPostion(((Integer)k1.getInitialPosition()).toString());
						 Validation.validateKeyword(Language.FRENCH, k1.getKeyword()); 
						 Validation.validateHomophonesTable(Language.FRENCH, k1.getHomophones());
						 DecryptionWindow.txtTypeTheKeyword.setText(keywordAsString(k1.getKeyword()));
						 DecryptionWindow.spinner.setValue((Integer)k1.getInitialPosition());
						 fillGeneratedHomophonesInTable( k1.getHomophones(), "FRENCH" , "Decryption");
					 }
					 catch(NumberFormatException  | InvalidHomophonesException | InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, "Vous essayez de charger la clé non valide qui ne peut pas être chiffré/déchiffré plus tard", "Attention", JOptionPane.WARNING_MESSAGE);
					 }
			 		 catch(NullPointerException   m){}
			 		 break;
			 		 
			 	case GERMAN:
			 		 try{
			 			 k1 = FileHandling.openKey(Language.GERMAN);
						 Validation.validateInitialPostion(((Integer)k1.getInitialPosition()).toString());
						 Validation.validateKeyword(Language.GERMAN, k1.getKeyword()); 
						 Validation.validateHomophonesTable(Language.GERMAN, k1.getHomophones());
						 DecryptionWindow.txtTypeTheKeyword.setText(keywordAsString(k1.getKeyword()));
						 DecryptionWindow.spinner.setValue((Integer)k1.getInitialPosition());
						 fillGeneratedHomophonesInTable( k1.getHomophones(), "GERMAN" , "Decryption");
					 }
					 catch(NumberFormatException  | InvalidHomophonesException | InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, "Sie versuchen, ungültige Schlüssel zu laden, die nicht verschlüsselt/entschlüsselt später werden kann", "Warnung", JOptionPane.WARNING_MESSAGE);
					 }
			 		 catch(NullPointerException   m){}
			 		 break;
			 		 
			 	case SPANISH:
			 		 try{
			 			 k1 = FileHandling.openKey(Language.SPANISH);
						 Validation.validateInitialPostion(((Integer)k1.getInitialPosition()).toString());
						 Validation.validateKeyword(Language.SPANISH, k1.getKeyword()); 
						 Validation.validateHomophonesTable(Language.SPANISH, k1.getHomophones());
						 DecryptionWindow.txtTypeTheKeyword.setText(keywordAsString(k1.getKeyword()));
						 DecryptionWindow.spinner.setValue((Integer)k1.getInitialPosition());
						 fillGeneratedHomophonesInTable( k1.getHomophones(), "SPANISH" , "Decryption");
					 }
					 catch(NumberFormatException  | InvalidHomophonesException | InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, "Usted está tratando de cargar la clave no válido que no se pueden cifrar/descifrar tarde", "Advertencia", JOptionPane.WARNING_MESSAGE);
					 }
			 		 catch(NullPointerException   m){}
			 		 break;
			 }
			
			 break;
			 
			 
			 
		 case "Browse Cipher Text": // User Clicked "Browse" Button in the DecryptionWindow to load the cipher text
			 DecryptionWindow.cipherTextArea.setText(FileHandling.openFile(LanguageWindow.language));
			 break;
			 
			 
			 
			 
		 case "Decrypt": // User Clicked "Decrypt" Button in the DecryptionWindow to decrypt the cipher text
			 switch (LanguageWindow.language){
			 	case ENGLISH:
			 		
			 	if (DecryptionWindow.cipherTextArea.getText().length()<=80000){
			 		try{ // check that everything is valid before attempting to decrypt
			 			/*No need to check the Cipher Text because it's always valid regardless its content(i.e it won't crash the program)
			 			 * Whilst The Correctness of the cipher text is entirely the user's responsibility
			 			 * in other words, incorrect cipher text will result incorrect plain text but won't crash the program
			 			 */
			 			Validation.validateInitialPostion(((Integer)(DecryptionWindow.spinner.getValue())).toString());
						Validation.validateKeyword(Language.ENGLISH, DecryptionWindow.txtTypeTheKeyword.getText());
						Validation.validateHomophonesTable(Language.ENGLISH, getHomophonesFromGuiTable("Decryption"));
						dec.setInitialPosition((Integer)(DecryptionWindow.spinner.getValue()));
						dec.setKeyword(DecryptionWindow.txtTypeTheKeyword.getText());
						dec.setRandomAlphabet(Language.ENGLISH);
						dec.setHomophones(getHomophonesFromGuiTable("Decryption"));
						dec.decrypt(DecryptionWindow.cipherTextArea.getText()); // decrypt the cipher text
						DecryptionWindow.createPlainTextWindow(Language.ENGLISH, new GuiListener()); // create the PlainTextWindow in the chosen language
						DecryptionWindow.plainTextArea.setText(dec.getPlainText()); // display the plain text
					   }
					   catch(NumberFormatException m){ // inform the user with the error
							 JOptionPane.showMessageDialog(null, "Invalid Initial Pos.", "Error", JOptionPane.ERROR_MESSAGE);
					   }
					   catch(InvalidHomophonesException message){
							 JOptionPane.showMessageDialog(null, message.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					   }
					   catch(InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					   }
			 		}
			 		 else {JOptionPane.showMessageDialog(null, "The Cipher-text is too big ("+  DecryptionWindow.cipherTextArea.getText().length() + " character) and cannot be decrypted in one go!\n" + "Max. number of character allowed is 80 000", "Notification", JOptionPane.INFORMATION_MESSAGE);}
					   break;
					   
			 	case FRENCH:
			 		if (DecryptionWindow.cipherTextArea.getText().length()<=80000){
			 			try{
				 			Validation.validateInitialPostion(((Integer)(DecryptionWindow.spinner.getValue())).toString());
							Validation.validateKeyword(Language.FRENCH, DecryptionWindow.txtTypeTheKeyword.getText());
							Validation.validateHomophonesTable(Language.FRENCH, getHomophonesFromGuiTable("Decryption"));
							dec.setInitialPosition((Integer)(DecryptionWindow.spinner.getValue()));
							dec.setKeyword(DecryptionWindow.txtTypeTheKeyword.getText());
							dec.setRandomAlphabet(Language.FRENCH);
							dec.setHomophones(getHomophonesFromGuiTable("Decryption"));
							dec.decrypt(DecryptionWindow.cipherTextArea.getText());
							DecryptionWindow.createPlainTextWindow(Language.FRENCH, new GuiListener());
							DecryptionWindow.plainTextArea.setText(dec.getPlainText());
						   }
					 		catch(NumberFormatException m){
								 JOptionPane.showMessageDialog(null, "Invalid Pos. initiale", "Erreur", JOptionPane.ERROR_MESSAGE);
						   }
						   	catch(InvalidHomophonesException m){
								 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						   }
						   catch(InvalidKeywordException m){
								 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						   }
			 		}
					 else {JOptionPane.showMessageDialog(null, "Le Texte chiffré est trop grand ("+  DecryptionWindow.cipherTextArea.getText().length() +" caractère) et ne peut être déchiffré en une seule fois!\n" + "Max. Nombre de caractère autorisées est de 80 000", "Notification",  JOptionPane.INFORMATION_MESSAGE);}
					   break;
			 		
			 	case GERMAN:
			 		if (DecryptionWindow.cipherTextArea.getText().length()<=80000){
				 		try{
				 		Validation.validateInitialPostion(((Integer)(DecryptionWindow.spinner.getValue())).toString());
						Validation.validateKeyword(Language.GERMAN, DecryptionWindow.txtTypeTheKeyword.getText());
						Validation.validateHomophonesTable(Language.GERMAN, getHomophonesFromGuiTable("Decryption"));
						dec.setInitialPosition((Integer)(DecryptionWindow.spinner.getValue()));
						dec.setKeyword(DecryptionWindow.txtTypeTheKeyword.getText());
						dec.setRandomAlphabet(Language.GERMAN);
						dec.setHomophones(getHomophonesFromGuiTable("Decryption"));
						dec.decrypt(DecryptionWindow.cipherTextArea.getText());
						DecryptionWindow.createPlainTextWindow(Language.GERMAN, new GuiListener());
						DecryptionWindow.plainTextArea.setText(dec.getPlainText());
					   }
				 	   catch(NumberFormatException m){
							 JOptionPane.showMessageDialog(null, "Ungültige Anfangsposition", "Fehler", JOptionPane.ERROR_MESSAGE);
						 }
					   catch(InvalidHomophonesException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						 }
					   catch(InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
						}
			 		}
				 else {JOptionPane.showMessageDialog(null, "The Geheimtext zu groß ist (" + DecryptionWindow.cipherTextArea.getText().length() +" charakter) und kann nicht in einem rutsch entschlüsselt werden!\n" + "Max. Anzahl der charakter erlaubt ist 80 000", "Benachrichtigung", JOptionPane.INFORMATION_MESSAGE);}
				 break;
			 		
			 	case SPANISH:
			 		if (DecryptionWindow.cipherTextArea.getText().length()<=80000){
			 			try{
					 		Validation.validateInitialPostion(((Integer)(DecryptionWindow.spinner.getValue())).toString());
							Validation.validateKeyword(Language.SPANISH, DecryptionWindow.txtTypeTheKeyword.getText());
							Validation.validateHomophonesTable(Language.SPANISH, getHomophonesFromGuiTable("Decryption"));
							dec.setInitialPosition((Integer)(DecryptionWindow.spinner.getValue()));
							dec.setKeyword(DecryptionWindow.txtTypeTheKeyword.getText());
							dec.setRandomAlphabet(Language.SPANISH);
							dec.setHomophones(getHomophonesFromGuiTable("Decryption"));
							dec.decrypt(DecryptionWindow.cipherTextArea.getText());
							DecryptionWindow.createPlainTextWindow(Language.SPANISH, new GuiListener());
							DecryptionWindow.plainTextArea.setText(dec.getPlainText());
						 }
				 		catch(NumberFormatException m){
							 JOptionPane.showMessageDialog(null, "Posición inicial no válido", "Error", JOptionPane.ERROR_MESSAGE);
						 }
					   	catch(InvalidHomophonesException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						 }
						catch(InvalidKeywordException m){
							 JOptionPane.showMessageDialog(null, m.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						 }
			 		}
			 		else {JOptionPane.showMessageDialog(null, "El Texto cifrado es demasiado grande (" + DecryptionWindow.cipherTextArea.getText().length() + " carácter) y no se puede descifrar de una sola vez!\n" + "Max. Número de carácter permitidas es de 80 000", "Notificación", JOptionPane.INFORMATION_MESSAGE);}
					 break;
			 }
			 
			 break;
			 
		 case "Save Plain Text": // User Clicked "Save" Button in the PlainTextWindow to save the plain text
			 FileHandling.saveFile(LanguageWindow.language,DecryptionWindow.plainTextArea.getText()); 
	 }
	
		    
}
	

 
 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
 
 
 /**
  * This method fills the parameter homophones in the UI Table
  * Either in the EncryptionWindow or in the DecryptionWindow 
  * @param generatedHomophones
  * @param language
  * @param window
  */
 private void fillGeneratedHomophonesInTable( ArrayList<ArrayList<String>> generatedHomophones, String language, String window){
	 DecimalFormat twoDigits = new DecimalFormat("00"); //create decimal object to hold two digits format for displaying the homophones between 0-9 as 00-01-02..09
	 switch (window){ // The Table in the EncryptionWindow or DecryptionWindow
	 	case "Encryption":
	 		/*Reset All The Cells in the Table to Empty*/
	 		for (int i = 0; i < EncryptionWindow.table.getRowCount(); i++) {
		        for (int j = 0; j < EncryptionWindow.table.getColumnCount(); j++) {
		        	EncryptionWindow.table.setValueAt("", i, j);
		        }
		    }
	
			 switch (language){
				 case "ENGLISH": // 26 column
					 for (int i=0; i<26;i++){
						 Iterator<String> strip = generatedHomophones.get(i).iterator(); // take every strip of the Homophones Table separately
						 int j=0;
						 while(strip.hasNext()){
							   String s = strip.next();
							   try {
							   EncryptionWindow.table.setValueAt(twoDigits.format(Integer.parseInt(s)),j, i);  // set the value of each homophone in the table
							   }
							   catch (NumberFormatException e){ // catch any non-digit/illegal input
								   EncryptionWindow.table.setValueAt(s,j, i); // display it in the Table to give the user the opportunity to see what the error message for 
							   }
							   j++;
						 }
					 }
					 break;
					 
				 case "FRENCH": //40 column
					 for (int i=0; i<40;i++){
						 Iterator<String> strip = generatedHomophones.get(i).iterator(); 
						 int j=0;
						 while(strip.hasNext()){
							   String s = strip.next();
							   try {
								   EncryptionWindow.table.setValueAt(twoDigits.format(Integer.parseInt(s)),j, i);  
							   }
							   catch (NumberFormatException e){
								   EncryptionWindow.table.setValueAt(s,j, i);
							   }
							   j++;
						 }
					 }
					 break;
					 
				 case "GERMAN": // 30 column
					 for (int i=0; i<30;i++){
						 Iterator<String> strip = generatedHomophones.get(i).iterator(); 
						 int j=0;
						 while(strip.hasNext()){
							   String s = strip.next();
							   try {
								   EncryptionWindow.table.setValueAt(twoDigits.format(Integer.parseInt(s)),j, i);  
							   }
							   catch (NumberFormatException e){ 
								   EncryptionWindow.table.setValueAt(s,j, i); 
							   }
							   j++;
						 }
					 }
					 break;
					 
				 case "SPANISH": // 32 column
					 for (int i=0; i<32;i++){
						 Iterator<String> strip = generatedHomophones.get(i).iterator();
						 int j=0;
						 while(strip.hasNext()){
							   String s = strip.next();
							   try {
								   EncryptionWindow.table.setValueAt(twoDigits.format(Integer.parseInt(s)),j, i);  
							   }
							   catch (NumberFormatException e){
								   EncryptionWindow.table.setValueAt(s,j, i); 
							   }
							   j++;
						 }
					 }
					 break;
			}
		 	break;
		 		
	 		
	 	case "Decryption":
	 		for (int i = 0; i < DecryptionWindow.table.getRowCount(); i++) {
		        for (int j = 0; j < DecryptionWindow.table.getColumnCount(); j++) {
		        	DecryptionWindow.table.setValueAt("", i, j);
		        }
		    }

		 switch (language){
			 case "ENGLISH":
				 for (int i=0; i<26;i++){
					 Iterator<String> strip = generatedHomophones.get(i).iterator();
					 int j=0;
					 while(strip.hasNext()){
						   String s = strip.next();
						   try {
							   DecryptionWindow.table.setValueAt(twoDigits.format(Integer.parseInt(s)),j, i);  
						   }
						   catch (NumberFormatException e){ 
							   DecryptionWindow.table.setValueAt(s,j, i);
						   }
						   j++;
					 }
				 }
				 break;
			 case "FRENCH":
				 for (int i=0; i<40;i++){
					 Iterator<String> strip = generatedHomophones.get(i).iterator(); 
					 int j=0;
					 while(strip.hasNext()){
						   String s = strip.next();
						   try {
							   DecryptionWindow.table.setValueAt(twoDigits.format(Integer.parseInt(s)),j, i);  
						   }
						   catch (NumberFormatException e){
							  DecryptionWindow.table.setValueAt(s,j, i);
						   }
						   j++;
					 }
				 }
				 break;
				 
			 case "GERMAN":
				 for (int i=0; i<30;i++){
					 Iterator<String> strip = generatedHomophones.get(i).iterator(); 
					 int j=0;
					 while(strip.hasNext()){
						   String s = strip.next();
						   try {
							   DecryptionWindow.table.setValueAt(twoDigits.format(Integer.parseInt(s)),j, i);  
						   }
						   catch (NumberFormatException e){ 
							   DecryptionWindow.table.setValueAt(s,j, i); 
						   }
						   j++;
					 }
				 }
				 break;
			 case "SPANISH":
				 for (int i=0; i<32;i++){
					 Iterator<String> strip = generatedHomophones.get(i).iterator();
					 int j=0;
					 while(strip.hasNext()){
						   String s = strip.next();
						   try {
							   DecryptionWindow.table.setValueAt(twoDigits.format(Integer.parseInt(s)),j, i);  
						   }
						   catch (NumberFormatException e){
							   DecryptionWindow.table.setValueAt(s,j, i); 
						   }
						   j++;
					 }
				 }
				 break;
		 }
	 	break;
	 }
	  
 } 
 
 
 
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
 
 /**
  * This method retrieves the homophones from the Gui Table and return it as ArrayList<ArrayList<String>>
  * @param window
  * @return ArrayList<ArrayList<String>> homophones
  */
 private ArrayList<ArrayList<String>> getHomophonesFromGuiTable(String window){
	 ArrayList<ArrayList<String>> homophones = new ArrayList<ArrayList<String>>(); // create ArrayList<ArrayList<String>> object to hold the homophones
	 switch (window){ // The Table in the EncryptionWindow or DecryptionWindow
	 	case "Encryption":
			 for (int i = 0; i <EncryptionWindow.table.getColumnCount(); i++) {
				 ArrayList<String> strip = new ArrayList<String>();
			     for (int j = 0; j <EncryptionWindow.table.getRowCount(); j++) {
			        	try {
				        	if(!EncryptionWindow.table.getValueAt(j, i).toString().isEmpty()){ // if the cell is not empty, add it to the strip
				        		strip.add(EncryptionWindow.table.getValueAt(j, i).toString());
				        	}
			        	}
			        	catch (NullPointerException e){}
			        	
			        }
			        homophones.add(i,strip);
			    }
			 return homophones;
			 
	
		 case "Decryption":
			 for (int i = 0; i <DecryptionWindow.table.getColumnCount(); i++) {
				 	ArrayList<String> strip = new ArrayList<String>();
			        for (int j = 0; j <DecryptionWindow.table.getRowCount(); j++) {
			        	try {
				        	if (!DecryptionWindow.table.getValueAt(j, i).toString().isEmpty()){
				        		strip.add(DecryptionWindow.table.getValueAt(j, i).toString());
				        	}
			        	}
			        	catch (NullPointerException e){}
			        	
			        }
			        homophones.add(i,strip);
			    }
			 return homophones;
			 
	 }
	 
	return homophones;
	 
 }
 

 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
 

 /**
  * This method converts the ArrayList<String> to a String literal
  * @param ArrayList<String> keyword
  * @return keywordString
  */
 private String keywordAsString(ArrayList<String> keyword){
	 String keywordString = "";
	 for (int i=0; i<keyword.size(); i++){
		 keywordString += keyword.get(i);
	 }
	 return keywordString;
 }
 
 

 
 
}