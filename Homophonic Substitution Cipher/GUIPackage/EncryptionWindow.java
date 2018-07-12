package GUIPackage;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.TextArea;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import languagesPackage.Language;


/**
 * This is EncryptionWindow Class that provides
 * a UI for the user to do the encryption
 * it contains static methods and fields for direct access and invoking
 * @author Yahya Almardeny
 * @version 05/10/2016
 *
 */
public class EncryptionWindow {
	/**
	 * These fields to be accessed directly without instantiation in the GuiListener Class
	 * protected means it can be accessed by all classes in the same package and by only the subclasses in other packages
	 * because there is no need to be seen in other packages (they have no business with it in my project)
	 */
	protected static JFrame frame;
	protected static JDialog cipherWindow;
	protected static JTable table;
	protected static TextArea plainTextArea;
	protected static JTextField  txtTypeTheKeyword;
	protected static JSpinner spinner;
	protected static TextArea resultedCipherTextArea;

	/*Eclipse implicitly creates a constructor when it's not created*/
	
	
	/**
	 * This methods creates a Decryption Window
	 * @param language
	 * @param listener
	 */
	public static void createEncryptionWindow(Language language, GuiListener listener){
		JPanel contentPane;
		JLabel lblNewLabel,lblInitialPos, lblPlainText,lblKeyword, lblHomophonesTable,lblTheKey;
		JSeparator separator,separator_1,separator_2,separator_3;
		JButton btnMainMenu, btnBrowes,btnGenerate,btnSaveKey, btnEncrypt,btnBrowsePlainText;
		
		switch (language){
		case ENGLISH:
			frame = new JFrame();
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
			frame.setTitle("Encryption");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 751, 561);
			frame.setLocationRelativeTo(null);
			
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);
			
			
			lblNewLabel = new JLabel("Encryption");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(21, 21, 86, 29);
			contentPane.add(lblNewLabel);
			
			lblInitialPos = new JLabel("Initial Pos.");
			lblInitialPos.setForeground(Color.WHITE);
			lblInitialPos.setHorizontalAlignment(SwingConstants.CENTER);
			lblInitialPos.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblInitialPos.setBounds(283, 120, 92, 29);
			contentPane.add(lblInitialPos);
			
			lblKeyword = new JLabel("Keyword");
			lblKeyword.setForeground(Color.WHITE);
			lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblKeyword.setBounds(21, 120, 76, 29);
			contentPane.add(lblKeyword);
			
			plainTextArea =  new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			plainTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			plainTextArea.setText("**Type your text here or have a browse, Only letters and spaces are allowed**");
			plainTextArea.setBounds(24, 351, 700, 92);
			contentPane.add(plainTextArea);
			plainTextArea.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (plainTextArea.getText().equals("**Type your text here or have a browse, Only letters and spaces are allowed**")){
			    		plainTextArea.setText("");
			    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			
			lblPlainText = new JLabel("PLAIN TEXT");
			lblPlainText.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlainText.setForeground(new Color(30, 144, 255));
			lblPlainText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblPlainText.setBounds(315, 305, 112, 29);
			contentPane.add(lblPlainText);
			
			
			txtTypeTheKeyword = new JTextField();
			txtTypeTheKeyword.setText("*Type the keyword here");
			txtTypeTheKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			txtTypeTheKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTypeTheKeyword.setBounds(96, 120, 148, 25);
			contentPane.add(txtTypeTheKeyword);
			txtTypeTheKeyword.setColumns(10);
			txtTypeTheKeyword.setColumns(10);
			txtTypeTheKeyword.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (txtTypeTheKeyword.getText().equals("*Type the keyword here")){
			    		txtTypeTheKeyword.setText("");
			    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			
			lblHomophonesTable = new JLabel("Homophones Table");
			lblHomophonesTable.setHorizontalAlignment(SwingConstants.CENTER);
			lblHomophonesTable.setForeground(Color.WHITE);
			lblHomophonesTable.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblHomophonesTable.setBounds(21, 160, 150, 29);
			contentPane.add(lblHomophonesTable);
			
			spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(375, 120, 45, 23);
			contentPane.add(spinner);
			
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						  "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
					}
				));
			table.setShowHorizontalLines(false);
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
			table.setBounds(21, 185, 708, 80);
			contentPane.add(table);
			table.setVisible(true);
			
			
			separator = new JSeparator();
			separator.setBounds(0, 303, 750, 2);
			contentPane.add(separator);
			
			btnMainMenu = new JButton("Main Menu");
			btnMainMenu.setBounds(625, 24, 95, 23);
			contentPane.add(btnMainMenu);
			btnMainMenu.setActionCommand("Main Menu");
			btnMainMenu.addActionListener(listener);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 74, 750, 2);
			contentPane.add(separator_1);
			
			btnBrowes = new JButton("Browse");
			btnBrowes.setBounds(120, 270, 89, 23);
			contentPane.add(btnBrowes);
			btnBrowes.setActionCommand("Browse Key");
			btnBrowes.addActionListener(listener);
			
			btnGenerate = new JButton("Generate");
			btnGenerate.setBounds(21, 270, 89, 23);
			contentPane.add(btnGenerate);
			btnGenerate.setActionCommand("Generate Homophones");
			btnGenerate.addActionListener(listener);
			
			btnSaveKey = new JButton ("Save Key");
			btnSaveKey.setBounds(640, 270, 89, 25);
			contentPane.add(btnSaveKey);
			btnSaveKey.setActionCommand("Save Key");
			btnSaveKey.addActionListener(listener);
			
			separator_2 = new JSeparator();
			separator_2.setBounds(0, 105, 750, 2);
			contentPane.add(separator_2);
			
			lblTheKey = new JLabel("THE KEY");
			lblTheKey.setHorizontalAlignment(SwingConstants.CENTER);
			lblTheKey.setForeground(new Color(30, 144, 255));
			lblTheKey.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblTheKey.setBounds(325, 78, 100, 29);
			contentPane.add(lblTheKey);
			
			separator_3 = new JSeparator();
			separator_3.setBounds(0, 335, 750, 2);
			contentPane.add(separator_3);
			
			frame.setVisible(true);
			
			/*ENCRPTION*/
			btnEncrypt = new JButton("ENCRYPT");
			btnEncrypt.setForeground(new Color(0, 0, 0));
			btnEncrypt.setFont(new Font("Algerian", Font.PLAIN, 16));
			btnEncrypt.setBounds(300, 475, 150, 40);
			btnEncrypt.setFocusPainted(false);
			contentPane.add(btnEncrypt);
			btnEncrypt.setActionCommand("Encrypt");
			btnEncrypt.addActionListener(listener);
			
			btnBrowsePlainText = new JButton("Browse");
			btnBrowsePlainText.setBounds(635, 449, 89, 23);
			contentPane.add(btnBrowsePlainText);
			btnBrowsePlainText.setActionCommand("Browse Plain Text");
			btnBrowsePlainText.addActionListener(listener);
			break;
			
			
		case FRENCH:
			frame = new JFrame();
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
			frame.setTitle("Cryptage");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 751, 561);
			frame.setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);
			
			
			lblNewLabel = new JLabel("Cryptage");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(21, 21, 86, 29);
			contentPane.add(lblNewLabel);
			
			lblInitialPos = new JLabel("Pos. initiale");
			lblInitialPos.setForeground(Color.WHITE);
			lblInitialPos.setHorizontalAlignment(SwingConstants.CENTER);
			lblInitialPos.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblInitialPos.setBounds(283 , 120, 92, 29);
			contentPane.add(lblInitialPos);
			
			lblKeyword = new JLabel("Mot clé");
			lblKeyword.setForeground(Color.WHITE);
			lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblKeyword.setBounds(21, 120, 76, 29);
			contentPane.add(lblKeyword);
			
			plainTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			plainTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			plainTextArea.setText("**Tapez votre plaintext ici ou avoir une navigation, Seules les lettres et les espaces sont autorisés**");
			plainTextArea.setBounds(24, 351, 700, 92);
			contentPane.add(plainTextArea);
			plainTextArea.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (plainTextArea.getText().equals("**Tapez votre plaintext ici ou avoir une navigation, Seules les lettres et les espaces sont autorisés**")){
			    		plainTextArea.setText("");
			    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			lblPlainText = new JLabel("TEXTE BRUT");
			lblPlainText.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlainText.setForeground(new Color(30, 144, 255));
			lblPlainText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblPlainText.setBounds(315, 305, 112, 29);
			contentPane.add(lblPlainText);
			
			
			txtTypeTheKeyword = new JTextField();
			txtTypeTheKeyword.setText("*Tapez mot-clé ici");
			txtTypeTheKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			txtTypeTheKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTypeTheKeyword.setBounds(96, 120, 148, 25);
			contentPane.add(txtTypeTheKeyword);
			txtTypeTheKeyword.setColumns(10);
			txtTypeTheKeyword.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (txtTypeTheKeyword.getText().equals("*Tapez mot-clé ici")){
			    		txtTypeTheKeyword.setText("");
			    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			lblHomophonesTable = new JLabel("Homophones Tableau");
			lblHomophonesTable.setHorizontalAlignment(SwingConstants.CENTER);
			lblHomophonesTable.setForeground(Color.WHITE);
			lblHomophonesTable.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblHomophonesTable.setBounds(21, 160 , 175, 29);
			contentPane.add(lblHomophonesTable);
			
			spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(375, 120 , 45, 23);
			contentPane.add(spinner);
			
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
					}
				));
			table.setShowHorizontalLines(false);
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
			table.setBounds(21, 185, 708, 80);
			contentPane.add(table);
			table.setVisible(true);
			
			separator = new JSeparator();
			separator.setBounds(0, 303, 750, 2);
			contentPane.add(separator);
			
			btnMainMenu = new JButton("Menu Principal");
			btnMainMenu.setBounds(605, 24, 118, 23);
			contentPane.add(btnMainMenu);
			btnMainMenu.setActionCommand("Main Menu");
			btnMainMenu.addActionListener(listener);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 74, 750, 2);
			contentPane.add(separator_1);
			
			btnBrowes = new JButton("Naviguer");
			btnBrowes.setBounds(120, 270, 89, 23);
			contentPane.add(btnBrowes);
			btnBrowes.setActionCommand("Browse Key");
			btnBrowes.addActionListener(listener);
			
			btnGenerate = new JButton("Générer");
			btnGenerate.setBounds(21 , 270, 89, 23);
			btnGenerate.setToolTipText("Type Keyword First & Optionally The Initial Pos.");
			contentPane.add(btnGenerate);
			btnGenerate.setActionCommand("Generate Homophones");
			btnGenerate.addActionListener(listener);
			
			btnSaveKey = new JButton ("Sauvegarder Clé");
			btnSaveKey.setBounds(600, 270, 130, 25);
			contentPane.add(btnSaveKey);
			btnSaveKey.setActionCommand("Save Key");
			btnSaveKey.addActionListener(listener);
			
			separator_2 = new JSeparator();
			separator_2.setBounds(0, 105, 750, 2);
			contentPane.add(separator_2);
			
			lblTheKey = new JLabel("LA CLÉ");
			lblTheKey.setHorizontalAlignment(SwingConstants.CENTER);
			lblTheKey.setForeground(new Color(30, 144, 255));
			lblTheKey.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblTheKey.setBounds(325, 78, 100, 29);
			contentPane.add(lblTheKey);
			
			separator_3 = new JSeparator();
			separator_3.setBounds(0, 335, 750, 2);
			contentPane.add(separator_3);
			
			/*ENCRPTION*/
			
			btnEncrypt = new JButton("ENCRYPT");
			btnEncrypt.setForeground(new Color(0, 0, 0));
			btnEncrypt.setFont(new Font("Algerian", Font.PLAIN, 16));
			btnEncrypt.setBounds(300, 475, 150, 40);
			btnEncrypt.setFocusPainted(false);
			contentPane.add(btnEncrypt);
			btnEncrypt.setActionCommand("Encrypt");
			btnEncrypt.addActionListener(listener);

			
			btnBrowsePlainText = new JButton("Naviguer");
			btnBrowsePlainText.setBounds(635, 449, 89, 23);
			contentPane.add(btnBrowsePlainText);
			btnBrowsePlainText.setActionCommand("Browse Plain Text");
			btnBrowsePlainText.addActionListener(listener);
			frame.setVisible(true);
			break;
			
			
		case GERMAN:
			frame = new JFrame();
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
			frame.setTitle("Verschlüsselung");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 751, 561);
			frame.setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);
			
			
			
			lblNewLabel = new JLabel("Verschlüsselung");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(20, 21, 130, 29);
			contentPane.add(lblNewLabel);
			
			
			lblInitialPos = new JLabel("Ausgangsposition");
			lblInitialPos.setForeground(Color.WHITE);
			lblInitialPos.setHorizontalAlignment(SwingConstants.CENTER);
			lblInitialPos.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblInitialPos.setBounds(310 , 120, 130, 29);
			contentPane.add(lblInitialPos);
			
			lblKeyword = new JLabel("Schlüsselwort");
			lblKeyword.setForeground(Color.WHITE);
			lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblKeyword.setBounds(18, 120, 115, 29);
			contentPane.add(lblKeyword);
			
			plainTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			plainTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			plainTextArea.setText("**Geben Sie Ihren Klartextes hier oder stöbern, Nur Buchstaben und Leerzeichen sind erlaubt**");
			plainTextArea.setBounds(24, 351, 700, 92);
			contentPane.add(plainTextArea);
			plainTextArea.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (plainTextArea.getText().equals("**Geben Sie Ihren Klartextes hier oder stöbern, Nur Buchstaben und Leerzeichen sind erlaubt**")){
			    		plainTextArea.setText("");
			    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			lblPlainText = new JLabel("KLARTEXT");
			lblPlainText.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlainText.setForeground(new Color(30, 144, 255));
			lblPlainText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblPlainText.setBounds(315, 305, 112, 29);
			contentPane.add(lblPlainText);
			
			
			txtTypeTheKeyword = new JTextField();
			txtTypeTheKeyword.setText("*Geben schlüsselwort hier");
			txtTypeTheKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			txtTypeTheKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTypeTheKeyword.setBounds(130, 120 , 150, 25);
			contentPane.add(txtTypeTheKeyword);
			txtTypeTheKeyword.setColumns(10);
			txtTypeTheKeyword.setColumns(10);
	
			txtTypeTheKeyword.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (txtTypeTheKeyword.getText().equals("*Geben schlüsselwort hier")){
			    		txtTypeTheKeyword.setText("");
			    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			lblHomophonesTable = new JLabel("Homophones Tabelle");
			lblHomophonesTable.setHorizontalAlignment(SwingConstants.CENTER);
			lblHomophonesTable.setForeground(Color.WHITE);
			lblHomophonesTable.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblHomophonesTable.setBounds(21, 160, 165, 29);
			contentPane.add(lblHomophonesTable);
			
			spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(440, 122 , 45, 23);
			contentPane.add(spinner);
			
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
					}
				));
			table.setShowHorizontalLines(false);
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
			table.setBounds(21, 185, 708, 80);
			contentPane.add(table);
			table.setVisible(true);
			
			
			separator = new JSeparator();
			separator.setBounds(0, 303, 750, 2);
			contentPane.add(separator);
			
			btnMainMenu = new JButton("Hauptmenü");
			btnMainMenu.setBounds(620, 24, 105, 23);
			contentPane.add(btnMainMenu);
			btnMainMenu.setActionCommand("Main Menu");
			btnMainMenu.addActionListener(listener);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 74, 750, 2);
			contentPane.add(separator_1);
			
			btnBrowes = new JButton("Schmökern");
			btnBrowes.setBounds(130, 270, 100, 23);
			contentPane.add(btnBrowes);
			btnBrowes.setActionCommand("Browse Key");
			btnBrowes.addActionListener(listener);
			
			
			btnGenerate = new JButton("Generieren");
			btnGenerate.setBounds(21, 270, 100, 23);
			contentPane.add(btnGenerate);
			btnGenerate.setActionCommand("Generate Homophones");
			btnGenerate.addActionListener(listener);
			
			
			btnSaveKey = new JButton ("Speichern Schlüssel");
			btnSaveKey.setBounds(577, 270, 153, 25);
			contentPane.add(btnSaveKey);
			btnSaveKey.setActionCommand("Save Key");
			btnSaveKey.addActionListener(listener);
			
			separator_2 = new JSeparator();
			separator_2.setBounds(0, 105, 750, 2);
			contentPane.add(separator_2);
			
			lblTheKey = new JLabel("DER SCHLÜSSEL");
			lblTheKey.setHorizontalAlignment(SwingConstants.CENTER);
			lblTheKey.setForeground(new Color(25, 200, 255));
			lblTheKey.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblTheKey.setBounds(285, 78, 185, 29);
			contentPane.add(lblTheKey);
			
			separator_3 = new JSeparator();
			separator_3.setBounds(0, 335, 750, 2);
			contentPane.add(separator_3);
			
			/*ENCRPTION*/
			
			btnEncrypt = new JButton("VERSCHLÜSSELUNG");
			btnEncrypt.setForeground(new Color(0, 0, 0));
			btnEncrypt.setFont(new Font("Algerian", Font.PLAIN, 16));
			btnEncrypt.setBounds(275, 475, 200, 40);
			btnEncrypt.setFocusPainted(false);
			contentPane.add(btnEncrypt);
			btnEncrypt.setActionCommand("Encrypt");
			btnEncrypt.addActionListener(listener);
			
		
			btnBrowsePlainText = new JButton("Schmökern");
			btnBrowsePlainText.setBounds(625, 449, 100, 23);
			contentPane.add(btnBrowsePlainText);
			btnBrowsePlainText.setActionCommand("Browse Plain Text");
			btnBrowsePlainText.addActionListener(listener);
			frame.setVisible(true);
			break;
			
			
		case SPANISH:
			frame = new JFrame();
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
			frame.setTitle("Encriptación");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 751, 561);
			frame.setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);
			
			
			lblNewLabel = new JLabel("Encriptación");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(21, 21, 100, 29);
			contentPane.add(lblNewLabel);
			
			lblInitialPos = new JLabel("Pos. inicial");
			lblInitialPos.setForeground(Color.WHITE);
			lblInitialPos.setHorizontalAlignment(SwingConstants.CENTER);
			lblInitialPos.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblInitialPos.setBounds(308, 120, 92, 29);
			contentPane.add(lblInitialPos);
			
			lblKeyword = new JLabel("Palabra clave");
			lblKeyword.setForeground(Color.WHITE);
			lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblKeyword.setBounds(21, 120, 100, 29);
			contentPane.add(lblKeyword);
			
			plainTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			plainTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			plainTextArea.setText("**Escriba su texto plano o tener un browse, Sólo se permiten letras y espacios**");
			plainTextArea.setBounds(24, 351, 700, 92);
			contentPane.add(plainTextArea);
			plainTextArea.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (plainTextArea.getText().equals("**Escriba su texto plano o tener un browse, Sólo se permiten letras y espacios**")){
			    		plainTextArea.setText("");
			    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			lblPlainText = new JLabel("TEXTO PLANO");
			lblPlainText.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlainText.setForeground(new Color(30, 144, 255));
			lblPlainText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblPlainText.setBounds(310, 305, 125, 29);
			contentPane.add(lblPlainText);
			
			
			txtTypeTheKeyword = new JTextField();
			txtTypeTheKeyword.setText("*Escriba palabra clave aquí");
			txtTypeTheKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			txtTypeTheKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTypeTheKeyword.setBounds(125, 120, 166, 25);
			contentPane.add(txtTypeTheKeyword);
			txtTypeTheKeyword.setColumns(10);
			txtTypeTheKeyword.setColumns(10);
			txtTypeTheKeyword.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (txtTypeTheKeyword.getText().equals("*Escriba palabra clave aquí")){
			    		txtTypeTheKeyword.setText("");
			    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			lblHomophonesTable = new JLabel("Homophones Tabla");
			lblHomophonesTable.setHorizontalAlignment(SwingConstants.CENTER);
			lblHomophonesTable.setForeground(Color.WHITE);
			lblHomophonesTable.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblHomophonesTable.setBounds(21, 160, 150, 29);
			contentPane.add(lblHomophonesTable);
			
			spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(400, 120, 45, 23);
			contentPane.add(spinner);
			
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
					}
				));
			table.setShowHorizontalLines(false);
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
			table.setBounds(21, 185, 708, 80);
			contentPane.add(table);
			table.setVisible(true);
			
			
			
			
			separator = new JSeparator();
			separator.setBounds(0, 303, 750, 2);
			contentPane.add(separator);
			
			btnMainMenu = new JButton("Menú Principal");
			btnMainMenu.setBounds(605, 24, 120, 23);
			contentPane.add(btnMainMenu);
			btnMainMenu.setActionCommand("Main Menu");
			btnMainMenu.addActionListener(listener);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 74, 750, 2);
			contentPane.add(separator_1);
			
			btnBrowes = new JButton("Ramoneo");
			btnBrowes.setBounds(120 , 270,89, 23);
			contentPane.add(btnBrowes);
			btnBrowes.setActionCommand("Browse Key");
			btnBrowes.addActionListener(listener);
			
			btnGenerate = new JButton("Generar");
			btnGenerate.setBounds(21 , 270, 89, 23);
			contentPane.add(btnGenerate);
			btnGenerate.setActionCommand("Generate Homophones");
			btnGenerate.addActionListener(listener);
			
			
			btnSaveKey = new JButton ("Guardar Clave");
			btnSaveKey.setBounds(615, 270, 114, 25);
			contentPane.add(btnSaveKey);
			btnSaveKey.setActionCommand("Save Key");
			btnSaveKey.addActionListener(listener);
			
			
			separator_2 = new JSeparator();
			separator_2.setBounds(0, 105, 750, 2);
			contentPane.add(separator_2);
			
			lblTheKey = new JLabel("LA CLAVE");
			lblTheKey.setHorizontalAlignment(SwingConstants.CENTER);
			lblTheKey.setForeground(new Color(30, 144, 255));
			lblTheKey.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblTheKey.setBounds(325, 78, 100, 29);
			contentPane.add(lblTheKey);
			
			separator_3 = new JSeparator();
			separator_3.setBounds(0, 335, 750, 2);
			contentPane.add(separator_3);
			
			/*ENCRPTION*/
			
			btnEncrypt = new JButton("ENCRIPTAR");
			btnEncrypt.setForeground(new Color(0, 0, 0));
			btnEncrypt.setFont(new Font("Algerian", Font.PLAIN, 16));
			btnEncrypt.setBounds(300, 475, 150, 40);
			btnEncrypt.setFocusPainted(false);
			contentPane.add(btnEncrypt);
			btnEncrypt.setActionCommand("Encrypt");
			btnEncrypt.addActionListener(listener);
			
			
			btnBrowsePlainText = new JButton("Ramoneo");
			btnBrowsePlainText.setBounds(635, 449, 89, 23);
			contentPane.add(btnBrowsePlainText);
			btnBrowsePlainText.setActionCommand("Browse Plain Text");
			btnBrowsePlainText.addActionListener(listener);
			frame.setVisible(true);
			break;
			
		}
		
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * This methods creates a pop-up window to show the resulted cipher text after the encryption
	 * @param language
	 * @param listener
	 */
	public static void createCipherWindow(Language language, GuiListener listener){
		
		JSeparator separator_Cipher;
		JLabel lblTheKey;
		JSeparator separator_Cipher1;
		JButton btnSaveCipherText;
		switch(language){
			case ENGLISH:
				cipherWindow = new JDialog();
		        cipherWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
		        cipherWindow.setTitle("Cipher Text");
		        cipherWindow.setResizable(false);
		        cipherWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        cipherWindow.setBounds(150, 100, 500, 500);
		        cipherWindow.setLocationRelativeTo(null);
		        cipherWindow.getContentPane().setBackground(Color.GRAY);
		        cipherWindow.setLayout(null);
		        cipherWindow.setVisible(true);
		       
		        separator_Cipher = new JSeparator();
				separator_Cipher.setBounds(0, 10, 500, 2);
				cipherWindow.add(separator_Cipher);
				
				lblTheKey = new JLabel("CIPHER TEXT");
				lblTheKey.setHorizontalAlignment(SwingConstants.CENTER);
				lblTheKey.setForeground(new Color(30, 144, 255));
				lblTheKey.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
				lblTheKey.setBounds(185, 12, 125, 29);
				cipherWindow.add(lblTheKey);
				
				separator_Cipher1 = new JSeparator();
				separator_Cipher1.setBounds(0, 40, 500, 2);
				cipherWindow.add(separator_Cipher1);
		        
				resultedCipherTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
				resultedCipherTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
				resultedCipherTextArea.setBounds(5, 50, 480, 350);
				cipherWindow.add(resultedCipherTextArea);
				
		        btnSaveCipherText = new JButton("Save");
		        btnSaveCipherText.setForeground(new Color(0, 0, 0));
		        btnSaveCipherText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		        btnSaveCipherText.setBounds(195, 425, 125, 30);
		        btnSaveCipherText.setFocusPainted(false);
		        btnSaveCipherText.setActionCommand("SaveCipherText");
		        btnSaveCipherText.addActionListener(listener);
		        cipherWindow.add(btnSaveCipherText);
		        break;
		        
			case FRENCH:
				cipherWindow = new JDialog();
                cipherWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
                cipherWindow.setTitle("Texte Cipher");
                cipherWindow.setResizable(false);
                cipherWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cipherWindow.setBounds(150, 100, 500, 500);
                cipherWindow.setLocationRelativeTo(null);
                cipherWindow.getContentPane().setBackground(Color.GRAY);
                cipherWindow.setLayout(null);
                cipherWindow.setVisible(true);
               
               
                separator_Cipher = new JSeparator();
        		separator_Cipher.setBounds(0, 10, 500, 2);
        		cipherWindow.add(separator_Cipher);
        		
        		lblTheKey = new JLabel("TEXTE CIPHER");
        		lblTheKey.setHorizontalAlignment(SwingConstants.CENTER);
        		lblTheKey.setForeground(new Color(40, 144, 255));
        		lblTheKey.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
        		lblTheKey.setBounds(185, 12, 125, 29);
        		cipherWindow.add(lblTheKey);
        		
        		separator_Cipher1 = new JSeparator();
        		separator_Cipher1.setBounds(0, 40, 500, 2);
        		cipherWindow.add(separator_Cipher1);
                
        		resultedCipherTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        		resultedCipherTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
        		resultedCipherTextArea.setBounds(5, 50, 480, 350);
        	
        		cipherWindow.add(resultedCipherTextArea);
        		
                btnSaveCipherText = new JButton("Sauvegarder");
                btnSaveCipherText.setForeground(new Color(0, 0, 0));
                btnSaveCipherText.setFont(new Font("Tahoma", Font.PLAIN, 14));
                btnSaveCipherText.setBounds(195, 425, 125, 30);
                btnSaveCipherText.setFocusPainted(false);
                btnSaveCipherText.setActionCommand("SaveCipherText");
		        btnSaveCipherText.addActionListener(listener);
                cipherWindow.add(btnSaveCipherText);
                
				break;
				
			case GERMAN:
				 cipherWindow = new JDialog();
	             cipherWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
	             cipherWindow.setTitle("Chiffretext");
	             cipherWindow.setResizable(false);
	             cipherWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 cipherWindow.setBounds(150, 100, 500, 500);
                 cipherWindow.setLocationRelativeTo(null);
	             cipherWindow.getContentPane().setBackground(Color.GRAY);
	             cipherWindow.setLayout(null);
	             cipherWindow.setVisible(true);
	             
	               
	             separator_Cipher = new JSeparator();
	             separator_Cipher.setBounds(0, 10, 500, 2);
	             cipherWindow.add(separator_Cipher);
	        		
	             lblTheKey = new JLabel("CHIFFRETEXT");
		         lblTheKey.setHorizontalAlignment(SwingConstants.CENTER);
		         lblTheKey.setForeground(new Color(30, 144, 255));
		         lblTheKey.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
		         lblTheKey.setBounds(195, 12, 125, 29);
		         cipherWindow.add(lblTheKey);
	        		
	        		separator_Cipher1 = new JSeparator();
	        		separator_Cipher1.setBounds(0, 40, 500, 2);
	        		cipherWindow.add(separator_Cipher1);
	                
	        		resultedCipherTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
	        		resultedCipherTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
	        		resultedCipherTextArea.setBounds(5, 50, 480, 350);
	        	
	        		cipherWindow.add(resultedCipherTextArea);
	        		
	                btnSaveCipherText = new JButton("Speichern");
	                btnSaveCipherText.setForeground(new Color(0, 0, 0));
	                btnSaveCipherText.setFont(new Font("Tahoma", Font.PLAIN, 14));
	                btnSaveCipherText.setBounds(195, 425, 125, 30);
	                btnSaveCipherText.setFocusPainted(false);
	                btnSaveCipherText.setActionCommand("SaveCipherText");
			        btnSaveCipherText.addActionListener(listener);
	                cipherWindow.add(btnSaveCipherText);
				break;
				
			case SPANISH:
				cipherWindow = new JDialog();
                cipherWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
                cipherWindow.setTitle("Texto Cifrado");
                cipherWindow.setResizable(false);
                cipherWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cipherWindow.setBounds(150, 100, 500, 500);
                cipherWindow.setLocationRelativeTo(null);
                cipherWindow.getContentPane().setBackground(Color.GRAY);
                cipherWindow.setLayout(null);
                cipherWindow.setVisible(true);
              
               
                separator_Cipher = new JSeparator();
        		separator_Cipher.setBounds(0, 10, 500, 2);
        		cipherWindow.add(separator_Cipher);
        		
        		lblTheKey = new JLabel("TEXTO CIFRADO");
        		lblTheKey.setHorizontalAlignment(SwingConstants.CENTER);
        		lblTheKey.setForeground(new Color(30, 144, 255));
        		lblTheKey.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
        		lblTheKey.setBounds(180, 12, 130, 29);
        		cipherWindow.add(lblTheKey);
        		
        		separator_Cipher1 = new JSeparator();
        		separator_Cipher1.setBounds(0, 40, 500, 2);
        		cipherWindow.add(separator_Cipher1);
                
        		resultedCipherTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        		resultedCipherTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
        		resultedCipherTextArea.setBounds(5, 50, 480, 350);
        	
        		cipherWindow.add(resultedCipherTextArea);
        		
                btnSaveCipherText = new JButton("Guardar");
                btnSaveCipherText.setForeground(new Color(0, 0, 0));
                btnSaveCipherText.setFont(new Font("Tahoma", Font.PLAIN, 14));
                btnSaveCipherText.setBounds(190, 425, 125, 30);
                btnSaveCipherText.setFocusPainted(false);
                btnSaveCipherText.setActionCommand("SaveCipherText");
		        btnSaveCipherText.addActionListener(listener);
                cipherWindow.add(btnSaveCipherText);
				break;
		}	
	}
	
		
}
