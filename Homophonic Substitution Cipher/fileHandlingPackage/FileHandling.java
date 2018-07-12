package fileHandlingPackage;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

import cipheringPackage.Key;
import languagesPackage.Language;


/**
 * This is a FileHandling Class
 * To Load and Save The Key in/from an Object File in the Directory
 * chosen by the user with (*.key) extension
 * Also to Load and Save Texts (e.g cipher text, plain text)
 * in/from a Text File (*.txt) in the directory chosen by the user
 * All the methods are static so no need for creating an instance of this class
 * Direct access is required for more convenience 
 * @author Yahya Almardeny
 * @version 05/10/2016
 */

public class FileHandling {
      
	public FileHandling(){} 
	
	/**
	 * This method create SaveDialog
	 * to save the given key object of type Key in a key File as an object
	 * it's declared static because it doesn't rely on any instance of this class
	 * so it can be accessed directly by invoking it directly from this class
	 * @param key
	 */
	public static void saveKey(Language language, Key key){
		 
		FileDialog saveDialog = new FileDialog(new Frame(), "Save", FileDialog.SAVE ); // save dialog
		saveDialog.setFile("*.key"); // set the file extension
		saveDialog.setVisible(true); // make it visible
		
		String fileName = saveDialog.getFile();
		
		if (fileName != null){ // if the user didn't click on the cancel button
				if (!fileName.endsWith(".key")){fileName += ".key";} // check if the user kept the file extension ".key" in the dialog, if not add it
	        	File f = new File (saveDialog.getDirectory(), fileName); // create a file in the chosen directory & name
	        	FileOutputStream fos = null; // object of the FileOutputStream to hold the file
				try {
					fos = new FileOutputStream(f); // add the file
					
				} catch (FileNotFoundException e) {
					switch (language){
						case ENGLISH:
							JOptionPane.showMessageDialog(null, "File " + fileName + " Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
							break;
						case FRENCH:
							JOptionPane.showMessageDialog(null, "Fichier " + fileName + " Non Trouvé!", "Error", JOptionPane.ERROR_MESSAGE);
							break;
						case GERMAN:
							JOptionPane.showMessageDialog(null, "Datei " + fileName + " Nicht Gefunden!", "Error", JOptionPane.ERROR_MESSAGE);
							break;
						case SPANISH:
							JOptionPane.showMessageDialog(null, "Archivo " + fileName + " No Encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
							break;	
					}
				}
				ObjectOutputStream oos = null; // object of the ObjectInputStream to hold the object sent to the file
				try {
					oos = new ObjectOutputStream(fos);
					oos.writeObject(key); // write the object to the file
					fos.close(); // close the streams
					oos.close();
				} catch (IOException e) {
					switch (language){
						case ENGLISH:
							JOptionPane.showMessageDialog(null, "An Error Occurred While Trying To Save The File " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
							break;
						case FRENCH:
							JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de sauvegarder le fichier " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
							break;   
						case GERMAN:
							JOptionPane.showMessageDialog(null, "Ein Fehler aufgetreten bei dem Versuch, die Datei zu speichern " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
							break;
						case SPANISH:
							JOptionPane.showMessageDialog(null, "Se produjo un error al intentar guardar el archivo " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
							break;	
					}
			
				}
		}
		saveDialog.dispose(); // close the dialog
		
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * This method opens a key file
	 * chosen by the user in a directory
	 * if the file doesn't exist in the the chosen directory
	 * it returns null
	 * this method catch all possible at-run-time errors that may happen
	 * and informs the user about it 
	 * @return an object of class Key (the content of the file *.key)
	 * @param language
	 */
	public static Key openKey(Language language){
		FileDialog loadDialog = new FileDialog(new Frame(), "Save", FileDialog.LOAD );
		loadDialog.setFile("*.key");
		loadDialog.setVisible(true);
		String fileName = loadDialog.getFile();
		switch (language){
			case ENGLISH:
				if (fileName != null){
					if (!fileName.endsWith(".key")){fileName += ".key";} 
		        	File f = new File (loadDialog.getDirectory(), fileName);
		        	FileInputStream fis = null;
					try {
						fis = new FileInputStream(f);
						
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "File " + fileName + " Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					ObjectInputStream ois = null;
					try {
						ois = new ObjectInputStream(fis);
						try {
							return (Key)ois.readObject();
						} catch (ClassNotFoundException e) {
							
							JOptionPane.showMessageDialog(null, "An Error Occurred While Trying To Open The File " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
						}
						fis.close();
						ois.close();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Invalid Key File", "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (NullPointerException e) {}
				}
				break;
			case FRENCH:
				if (fileName != null){
					if (!fileName.endsWith(".key")){fileName += ".key";} 
		        	File f = new File (loadDialog.getDirectory(), fileName);
		        	FileInputStream fis = null;
					try {
						fis = new FileInputStream(f);
						
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "Fichier " + fileName + " Non Trouvé!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					ObjectInputStream ois = null;
					try {
						ois = new ObjectInputStream(fis);
						try {
							return (Key) ois.readObject();
						} catch (ClassNotFoundException e) {
							JOptionPane.showMessageDialog(null, "Fichier clé non valide", "Error", JOptionPane.ERROR_MESSAGE);
						}
						fis.close();
						ois.close();
					} catch (IOException e) {

						JOptionPane.showMessageDialog(null, "Une erreur est survenue lors d'ouvrir le fichier " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (NullPointerException e) {}
				}
				break;
				
			case GERMAN:
				if (fileName != null){
					if (!fileName.endsWith(".key")){fileName += ".key";} 
		        	File f = new File (loadDialog.getDirectory(), fileName);
		        	FileInputStream fis = null;
					try {
						fis = new FileInputStream(f);
						
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "Datei " + fileName + " Nicht Gefunden!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					ObjectInputStream ois = null;
					try {
						ois = new ObjectInputStream(fis);
						try {
							return (Key) ois.readObject();
						} catch (ClassNotFoundException e) {
							JOptionPane.showMessageDialog(null, "Ein Fehler aufgetreten bei dem Versuch, die Datei zu öffnen " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
						}
						fis.close();
						ois.close();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Invalid Schlüsseldatei", "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (NullPointerException e) {}
				}
				break;
				
			case SPANISH:
				if (fileName != null){
					if (!fileName.endsWith(".key")){fileName += ".key";} 
		        	File f = new File (loadDialog.getDirectory(), fileName);
		        	FileInputStream fis = null;
					try {
						fis = new FileInputStream(f);
						
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "Archivo " + fileName + " No Encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					ObjectInputStream ois = null;
					try {
						ois = new ObjectInputStream(fis);
						try {
							return (Key) ois.readObject();
						} catch (ClassNotFoundException e) {
							JOptionPane.showMessageDialog(null, "Se produjo un error al intentar abrir el archivo "+ fileName, "Error", JOptionPane.ERROR_MESSAGE);
						}
						fis.close();
						ois.close();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Archivo de clave no válida", "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (NullPointerException e) {}
				}
				break;
	
			
		}
		loadDialog.dispose();
		return null;
		
	}

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This method saves the given text in a text file
	 * with the name and in the directory chosen by the user
	 * @param text
	 * @param language
	 */
	public static void saveFile(Language language, String text){
		
		FileDialog saveDialog = new FileDialog(new Frame(), "Save", FileDialog.SAVE );
		saveDialog.setFile("*.txt");
		saveDialog.setVisible(true);
		String fileName = saveDialog.getFile();
		if (fileName != null){ // if the user entered a name for the file and did not click Cancel
			if (!fileName.endsWith(".txt")){fileName += ".txt";} // make sure there to add proper extension to the file if the user did not
	        File f = new File (saveDialog.getDirectory(), fileName);
			PrintWriter writeData = null;
			try{
			 	writeData=new PrintWriter(f);
			 	writeData.append(text);
			}
			catch(FileNotFoundException e){ // inform the user if file not found
				switch (language){
				case ENGLISH:
					JOptionPane.showMessageDialog(null, "File " + fileName + " Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case FRENCH:
					JOptionPane.showMessageDialog(null, "Fichier " + fileName + " Non Trouvé!", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case GERMAN:
					JOptionPane.showMessageDialog(null, "Datei " + fileName + " Nicht Gefunden!", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case SPANISH:
					JOptionPane.showMessageDialog(null, "Archivo " + fileName + " No Encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
					break;	
				}
				
			}
			writeData.close();
		}
		saveDialog.dispose();
	
}

	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This method opens a text file chosen by the user
	 * @param language
	 * @return the content of the file text as a String
	 */
	public static String openFile(Language language){
		String fileContent =""; // the content of the file to be returend
		FileDialog openDialog = new FileDialog(new Frame(), "Save", FileDialog.LOAD );
		openDialog.setFile("*.txt");
		openDialog.setVisible(true);
		String fileName = openDialog.getFile();
		if (fileName != null){
			if (!fileName.endsWith(".txt")){fileName += ".txt";} 
	        File f = new File (openDialog.getDirectory(), fileName);
			Scanner readData = null;
			try {
				readData=new Scanner(f);
				while(readData.hasNext()){ // read the content until the end of the file ... it reads token specified by whitespace by default
					fileContent += readData.nextLine();
				}
				readData.close();
			}
			catch (FileNotFoundException e) { // inform the user if the file not found
				switch(language){
					case ENGLISH:
						JOptionPane.showMessageDialog(null, "File " + fileName + " Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case FRENCH:
						JOptionPane.showMessageDialog(null, "Fichier " + fileName + " Non Trouvé!", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case GERMAN:
						JOptionPane.showMessageDialog(null, "Datei " + fileName + " Nicht Gefunden!", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case SPANISH:
						JOptionPane.showMessageDialog(null, "Archivo " + fileName + " No Encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
						break;
				}
			}
			
			
		}
		openDialog.dispose(); // dispose the dialog
		return fileContent; // return the content
	
}
	

}
