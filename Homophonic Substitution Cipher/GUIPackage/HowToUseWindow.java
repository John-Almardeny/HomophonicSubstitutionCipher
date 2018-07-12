package GUIPackage;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.TextArea;
import languagesPackage.Language;


/**
 * This is a simple GUI window Class that contains
 * information about how to use this program for the user
 * in 5 different languages (English, French, German and Spanish)
 * @author Yahya Almardeny
 * @version 05/10/2016
 */
public class HowToUseWindow {

	
	/**The constructor
	 * @param language
	 */
	public HowToUseWindow(Language language) {
		JFrame frmHowToUse;
		JLabel lblNewLabel;
		TextArea textArea;
		
		switch(language){
			case ENGLISH:
				frmHowToUse = new JFrame();
				frmHowToUse.setTitle("How To Use");
				frmHowToUse.setResizable(false);
				frmHowToUse.setIconImage(Toolkit.getDefaultToolkit().getImage(HowToUseWindow.class.getResource("/GUIPackage/images/icon.png")));
				frmHowToUse.setBackground(Color.DARK_GRAY);
				frmHowToUse.getContentPane().setBackground(Color.DARK_GRAY);
				frmHowToUse.setBounds(100, 100, 774, 562);
				frmHowToUse.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frmHowToUse.getContentPane().setLayout(null);
				
				lblNewLabel = new JLabel("How To Use This Program");
				lblNewLabel.setForeground(SystemColor.textHighlight);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(235, 11, 269, 50);
				frmHowToUse.getContentPane().add(lblNewLabel);
				
				textArea = new TextArea();
				textArea.setForeground(Color.WHITE);
				textArea.setBackground(Color.DARK_GRAY);
				textArea.setEditable(false);
				textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
				textArea.setText("  \tThis is an improved version of the standard Homophonic Substitution Cipher; it basically applies the\r\n\t\tSpanish Strip Cipher with some enhancement on the final cipher text format by symbolizing the \r\n\t   \thomophones randomly. This cipher is available in 4 different languages: English, French,\r\n\t\t\t\t\t\tGerman and Spanish.\r\n\r\n  The Key:\r\n\t•As the name suggests, the key is the key to encrypt and decrypt the messages.\r\n\t•It consists of 3 main parts: The Keyword, The Initial Position and The Homophones Table.\r\n\t•The Keyword (letters only) + Initial Position (positive integers only starting from 0) will generate the\r\n\t  random alphabet which represents a resource of the letters to be mapped with the homophones.\r\n\t•The Homophones Table: is a group of strips (columns), every strip contains between 1 to 5 numbers.\r\n\t  Once the number is chosen in a strip, it cannot be used in another one (no duplicates allowed).\r\n\t•You can choose to type your own homophones (numbers must be between 00 – 99) or you can \r\n\t  -in a more convenient way- let the program randomly uniquely generate the homophones for you.\r\n\t•Every letter in the random alphabet can map one or more homophones according to the strip size.\r\n\t•The strips and their sizes are generated carefully according to the frequency of each letter in the language\r\n\t  (i.e. the more frequent the letter is, the bigger strip assigned to it).\r\n\r\n  Encryption:\r\n\t•Type your plain text or have a browse to load it from your computer.\r\n\t•Insert your key: \r\n\t•Click on the “Encrypt” button and a window will popup containing the cipher text in a symbolized format.\r\n\t•Save your cipher text and send it separately with the key to the other party.\r\n\r\n  Decryption:\r\n\t•Use the same key that was used in encrypting the original plain text.\r\n\t•You can type it manually or you can load it from your computer in one go.\r\n\t•Type the cipher text or have a browse, then click on the “Decrypt” button. \r\n\t    A window will popup containing the original massage/plain text.\r\n\r\n");
				textArea.setBounds(10, 65, 750, 461);
				frmHowToUse.getContentPane().add(textArea);
				frmHowToUse.setVisible(true);
				break;
				
			case FRENCH:
				frmHowToUse = new JFrame();
				frmHowToUse.setTitle("Comment Utiliser");
				frmHowToUse.setResizable(false);
				frmHowToUse.setIconImage(Toolkit.getDefaultToolkit().getImage(HowToUseWindow.class.getResource("/GUIPackage/images/icon.png")));
				frmHowToUse.setBackground(Color.DARK_GRAY);
				frmHowToUse.getContentPane().setBackground(Color.DARK_GRAY);
				frmHowToUse.setBounds(100, 100, 821, 562);
				frmHowToUse.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frmHowToUse.getContentPane().setLayout(null);
				
			
				
				lblNewLabel = new JLabel("Comment Utiliser Ce Programme");
				lblNewLabel.setForeground(SystemColor.textHighlight);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(226, 11, 306, 50);
				frmHowToUse.getContentPane().add(lblNewLabel);
				
				textArea = new TextArea();
				textArea.setForeground(Color.WHITE);
				textArea.setBackground(Color.DARK_GRAY);
				textArea.setEditable(false);
				textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
				textArea.setText("  Ceci est une version améliorée de la norme homophonique Substitution Cipher; il applique essentiellement la bande \r\n\t   de Cipher espagnole avec une certaine amélioration sur le format final de texte chiffré en symbolisant les \r\n\t\thomophones au hasard. Ce chiffre est disponible en 4 langues différentes: anglais, \r\n\t\t\t\t\tfrançais, allemand et espagnol.\r\n\r\n  La clé:\r\n\t•Comme son nom l'indique, la clé est la clé pour chiffrer et déchiffrer les messages.\r\n\t•Il se compose de 3 parties principales: Le mot-clé, la position initiale et le tableau homophones.\r\n\t•Mot (lettres seulement) + Position initiale (des nombres entiers positifs seulement à partir de 0) \r\n\t  vont générer l'alphabet aléatoire qui représente une ressource des lettres à être mappé avec les homophones.\r\n\t•Le tableau homophones: est un groupe de bandes (colonnes), chaque bande contient entre 1 à 5 chiffres.\r\n\t  Une fois que le nombre est choisi dans une bande, il ne peut pas être utilisé dans un autre (pas de doublons autorisés).\r\n\t•Vous pouvez choisir de taper vos propres homophones (numéros doivent être compris entre 00 - 99) ou vous pouvez \r\n\t  -dans un waypoint plus commode de laisser le programme de façon aléatoire générer uniquement les homophones pour vous.\r\n\t•Chaque lettre de l'alphabet aléatoire peut mapper un ou plusieurs homophones selon la taille de la bande.\r\n\t•Les bandes et leurs tailles sont générées avec soin en fonction de la fréquence de chaque lettre dans la langue \r\n\t  (à savoir le plus souvent la lettre est la plus grande bande qui lui est attribué).\r\n\r\n  Cryptage:\r\n\t•Tapez votre texte ou avoir une navigation pour le charger à partir de votre ordinateur.\r\n\t•Insérez votre clé: Cliquez sur le bouton \"Encrypt\" et une fenêtre contenant apparaître\r\n\t  le texte chiffré dans un format symbolisé.\r\n\t•Sauvegardez votre texte chiffré et l'envoyer séparément avec la clé à l'autre partie.\r\n\r\n  Décryptage:\r\n\t•Utilisez la même clé qui a été utilisé pour crypter le texte brut d'origine.\r\n\t•Vous pouvez taper manuellement ou vous pouvez le charger à partir de votre ordinateur en une seule fois.\r\n\t•Tapez le texte chiffré ou avoir une navigation, puis cliquez sur le bouton \"Déchiffrer\".\r\n\t\tUne fenêtre contenant apparaître le massage d'origine / texte brut.\r\n\r\n\r\n");
				textArea.setBounds(10, 65, 795, 461);
				frmHowToUse.getContentPane().add(textArea);
				frmHowToUse.setVisible(true);
				break;
				
			case GERMAN:
				frmHowToUse = new JFrame();
				frmHowToUse.setTitle("Wie Benutzt Man");
				frmHowToUse.setResizable(false);
				frmHowToUse.setIconImage(Toolkit.getDefaultToolkit().getImage(HowToUseWindow.class.getResource("/GUIPackage/images/icon.png")));
				frmHowToUse.setBackground(Color.DARK_GRAY);
				frmHowToUse.getContentPane().setBackground(Color.DARK_GRAY);
				frmHowToUse.setBounds(100, 100, 821, 562);
				frmHowToUse.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frmHowToUse.getContentPane().setLayout(null);
				
				lblNewLabel = new JLabel("Wie Dieses Programm Zu Benutzen");
				lblNewLabel.setForeground(SystemColor.textHighlight);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(226, 11, 328, 50);
				frmHowToUse.getContentPane().add(lblNewLabel);
				
				textArea = new TextArea();
				textArea.setForeground(Color.WHITE);
				textArea.setBackground(Color.DARK_GRAY);
				textArea.setEditable(false);
				textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
				textArea.setText("  Dies ist eine verbesserte Version des Standard-Homophonic Substitution Cipher; Grundsätzlich gilt die spanische Streifen Cipher \r\n\tmit einer gewissen Verbesserung auf dem endgültigen Chiffretext-Format durch die homophones zufällig symbolisiert.\r\n\t\t\tDiese Chiffre ist in 4 verschiedenen Sprachen: Englisch, Französisch, Deutsch und Spanisch.\r\n\r\n  Der Schlüssel:\r\n\t•Wie der Name schon sagt, ist der Schlüssel, der Schlüssel zu verschlüsseln und die Nachrichten zu entschlüsseln.\r\n\t•Es besteht aus 3 Teilen: Das Schlüsselwort der Anfangsposition und der Homophone Table.\r\n\t•Das Schlüsselwort (Buchstaben nur) + Initial Position (positive ganze Zahlen sind nur ab 0) wird die Zufalls Alphabet zu erzeugen, \r\n\t   die eine Ressource der Buchstaben repräsentiert mit den homophones abgebildet werden.\r\n\t•Die Homophone Table: eine Gruppe von Streifen (Spalten), jeder Streifen enthält zwischen 1 bis 5 Zahlen. \r\n\t  Sobald die Anzahl in einem Streifen gewählt wird, kann es nicht in einen anderen verwendet werden (keine Duplikate erlaubt).\r\n\t•Sie können Ihre eigene homophones eingeben (Zahlen zwischen 00 sein müssen - 99) oder Sie können eine bequemere \r\n\t  -im homophones für Sie das Programm zufällig eindeutig generieren Weg- lassen.\r\n\t•Jeder Buchstabe in dem Random-Alphabet kann ein oder mehrere Homophone entsprechend der Streifengröße abzubilden.\r\n\t•Die Streifen und ihre Größen sind entsprechend der Frequenz jedes Buchstabens in der Sprache sorgfältig erzeugt\r\n\t   (d.h. desto häufiger der Brief ist, desto größer Streifen zugeordnet).\r\n\r\n  Verschlüsselung:\r\n\t•Geben Sie Ihren Klartext oder stöbern Sie es von Ihrem Computer zu laden.\r\n\t•Legen Sie Ihre Schlüssel:\r\n\t•Klicken Sie auf das \"Verschlüsseln\" und ein Popup-Fenster wird der Chiffretext in einem symbolisierten Format enthält.\r\n\t•Speichern Sie Ihre Chiffretext und senden Sie es separat mit dem Schlüssel der anderen Partei.\r\n\r\n  Decryption:\r\n\t•Verwenden Sie den gleichen Schlüssel, der in die Verschlüsselung des ursprünglichen Klartext verwendet wurde.\r\n\t•Sie können es manuell eingeben oder Sie können es von Ihrem Computer in einem Rutsch zu laden.\r\n\t•Geben Sie den Chiffretext oder stöbern, dann klicken Sie auf \"Entschlüsseln\" Taste.\r\n\t\t Es wird ein Fenster Popup die ursprüngliche Massage / plain Text enthält.\r\n\r\n\r\n");
				textArea.setBounds(10, 65, 795, 461);
				frmHowToUse.getContentPane().add(textArea);
				frmHowToUse.setVisible(true);
				break;
				
			case SPANISH:
				frmHowToUse = new JFrame();
				frmHowToUse.setTitle("Cómo Utilizar");
				frmHowToUse.setResizable(false);
				frmHowToUse.setIconImage(Toolkit.getDefaultToolkit().getImage(HowToUseWindow.class.getResource("/GUIPackage/images/icon.png")));
				frmHowToUse.setBackground(Color.DARK_GRAY);
				frmHowToUse.getContentPane().setBackground(Color.DARK_GRAY);
				frmHowToUse.setBounds(100, 100, 821, 562);
				frmHowToUse.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frmHowToUse.getContentPane().setLayout(null);
				
				lblNewLabel = new JLabel("Cómo Utilizar Este Programa");
				lblNewLabel.setForeground(SystemColor.textHighlight);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(226, 11, 328, 50);
				frmHowToUse.getContentPane().add(lblNewLabel);
				
				textArea = new TextArea();
				textArea.setForeground(Color.WHITE);
				textArea.setBackground(Color.DARK_GRAY);
				textArea.setEditable(false);
				textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
				textArea.setText("  Esta es una versión mejorada de la norma Homophonic Sustitución Cipher; que básicamente se aplica la Franja de cifrado español\r\n\t\tcon algunas mejoras en el formato de texto cifrado final que simboliza los homófonos al azar.\r\n\t\t\tEsta cifra está disponible en 4 idiomas diferentes: Inglés, Francés, Alemán y Español.\r\n\r\n  La clave:\r\n\t•Como su nombre indica, la clave es la clave para cifrar y descifrar los mensajes.\r\n\t•Se compone de 3 partes principales: la palabra clave, la posición inicial y la tabla de homófonos.\r\n\t•Palabra Clave (sólo letras) + Posición Inicial (números enteros positivos sólo a partir de 0) generarán el alfabeto\r\n\t  al azar que representa un recurso de las cartas para ser mapeada con los homófonos.\r\n\t•La Tabla Homophones: es un grupo de tiras (columnas), cada tira contiene entre 1 a 5 números. Una vez elegido\r\n\t  el número en una tira, no se puede utilizar en otro (no hay duplicados permitidos).\r\n\t•Puede elegir escribir sus propias palabras homófonas (números deben ser de 00 - 99) o puede\r\n\t -en una forma más cómoda manera- dejar que el programa genera aleatoriamente de forma única los homófonos para usted.\r\n\t•Cada letra del alfabeto al azar puede asignar uno o más homófonos de acuerdo con el tamaño de la división.\r\n\t•Las tiras y sus tamaños se generan cuidadosamente de acuerdo con la frecuencia de cada carta en el idioma \r\n\t  (es decir, la más frecuente es la carta, la tira más grande asignado a él).\r\n\r\n  Encriptación:\r\n\t•Escriba su texto plano o tener una exploración para cargarlo desde su ordenador.\r\n\t•Introduzca su clave:\r\n\t  Haga clic en el botón \"Cifrar\" y aparecerá una ventana emergente que contiene el texto cifrado en un formato simbolizada.\r\n\t•Guardar el texto cifrado y enviarlo por separado con la llave a la otra parte.\r\n\r\n  Descifrado:\r\n\t•Utilizar la misma clave que se utilizó para cifrar el texto plano original.\r\n\t•Puede escribir manualmente o puede cargar desde el ordenador de una sola vez.\r\n\t•Escriba el texto cifrado o tienen un navegar, a continuación, haga clic en el botón \"Descifrar\". \r\n\t\tUna ventana popup que contiene el / texto plano original de masaje.\r\n\r\n");
				textArea.setBounds(10, 65, 795, 461);
				frmHowToUse.getContentPane().add(textArea);
				frmHowToUse.setVisible(true);
				
				break;
		}	
		
	}
}
