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

import javax.swing.JDialog;

import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.TextArea;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import languagesPackage.Language;

/**
 * This is DecryptionWindow Class that provides
 * a UI for the user to do the decryption
 * it contains static methods and fields for direct access and invoking
 * @author Yahya Almardeny
 * @version 05/10/2016
 */
public class DecryptionWindow{
	/**
	 * These fields to be accessed directly without instantiation in the GuiListener Class
	 * protected means it can be accessed by all classes in the same package and by only the subclasses in other packages
	 * because there is no need to be seen in other packages (they have no business with it in my project)
	 */
	protected static JFrame frame;
	protected static JDialog plainWindow;
	protected static JTable table;
	protected static TextArea plainTextArea;
	protected static JTextField  txtTypeTheKeyword;
	protected static JSpinner spinner;
	protected static TextArea cipherTextArea;

	/*Eclipse implicitly creates a constructor when it's not created*/
	
    /**
     * This methods creates a Decryption Window
     * @param language
     * @param listener
     */
	public static void createDecryptionWindow(Language language, GuiListener listener){
		JPanel contentPane;
		JLabel lblNewLabel,lblInitialPos,lblKeyword,lblCipherText,lblHomophonesTable,lblTheKey;
		JSeparator separator,separator_1, separator_2,separator_3 ;
		JButton btnMainMenu,btnBrowesKey,btnDecrypt,btnBrowseCipherText;
		
		switch(language){
		case ENGLISH:
			frame = new JFrame();
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
			frame.setTitle("Decryption");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 751, 561);
			frame.setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);
			
			
			lblNewLabel = new JLabel("Decryption");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(21, 21, 86, 29);
			contentPane.add(lblNewLabel);
			
			
			lblInitialPos = new JLabel("Initial Pos.");
			lblInitialPos.setForeground(Color.WHITE);
			lblInitialPos.setHorizontalAlignment(SwingConstants.CENTER);
			lblInitialPos.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblInitialPos.setBounds(283, 265, 92, 29);
			contentPane.add(lblInitialPos);
			
			lblKeyword = new JLabel("Keyword");
			lblKeyword.setForeground(Color.WHITE);
			lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblKeyword.setBounds(21, 265, 76, 29);
			contentPane.add(lblKeyword);
			
			cipherTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			cipherTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			cipherTextArea.setText("**Type the cipher text here or have a browse**");
			cipherTextArea.setBounds(24, 351, 700, 92);
			contentPane.add(cipherTextArea);
			cipherTextArea.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			      	if (cipherTextArea.getText().equals("**Type the cipher text here or have a browse**")){
			      		cipherTextArea.setText("");
		    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			
			lblCipherText = new JLabel("CIPHER TEXT");
			lblCipherText.setHorizontalAlignment(SwingConstants.CENTER);
			lblCipherText.setForeground(new Color(30, 144, 255));
			lblCipherText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblCipherText.setBounds(315, 305, 135, 29);
			contentPane.add(lblCipherText);
			
			
			txtTypeTheKeyword = new JTextField();
			txtTypeTheKeyword.setText("*Type the keyword here");
			txtTypeTheKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			txtTypeTheKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTypeTheKeyword.setBounds(96, 266, 148, 25);
			contentPane.add(txtTypeTheKeyword);
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
			lblHomophonesTable.setBounds(21, 105, 150, 29);
			contentPane.add(lblHomophonesTable);
			
			spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(375, 266, 45, 23);
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
			table.setBounds(21, 139, 708, 80);
			contentPane.add(table);
			table.setVisible(true);
			
			
			separator = new JSeparator();
			separator.setBounds(0, 303, 750, 2);
			contentPane.add(separator);
			
			btnMainMenu = new JButton("Main Menu");
			btnMainMenu.setBounds(625, 24, 95, 23);
			contentPane.add(btnMainMenu);
			btnMainMenu.setActionCommand("Main Menu1");
			btnMainMenu.addActionListener(listener);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 74, 750, 2);
			contentPane.add(separator_1);
			
			btnBrowesKey = new JButton("Browse Key");
			btnBrowesKey.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnBrowesKey.setBounds(620, 246, 110, 29);
			contentPane.add(btnBrowesKey);
			btnBrowesKey.setActionCommand("Browse Key1");
			btnBrowesKey.addActionListener(listener);
			
			
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
			
			/*DECRPTION*/
			
			btnDecrypt = new JButton("DECRYPT");
			btnDecrypt.setForeground(new Color(0, 0, 0));
			btnDecrypt.setFont(new Font("Algerian", Font.PLAIN, 16));
			btnDecrypt.setBounds(300, 475, 150, 40);
			btnDecrypt.setFocusPainted(false);
			contentPane.add(btnDecrypt);
			btnDecrypt.setActionCommand("Decrypt");
			btnDecrypt.addActionListener(listener);
			
			
			btnBrowseCipherText = new JButton("Browse");
			btnBrowseCipherText.setBounds(635, 449, 89, 23);
			contentPane.add(btnBrowseCipherText);
			btnBrowseCipherText.setActionCommand("Browse Cipher Text");
			btnBrowseCipherText.addActionListener(listener);
			frame.setVisible(true);
			break;
			
		case FRENCH:
			frame = new JFrame();
			contentPane = new JPanel();
			
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
			frame.setTitle("Décryptage");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 751, 561);
			frame.setLocationRelativeTo(null);
			
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);
			
			
			lblNewLabel = new JLabel("Décryptage");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(21, 21, 100, 29);
			contentPane.add(lblNewLabel);
			
			
			lblInitialPos = new JLabel("Pos. initiale");
			lblInitialPos.setForeground(Color.WHITE);
			lblInitialPos.setHorizontalAlignment(SwingConstants.CENTER);
			lblInitialPos.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblInitialPos.setBounds(283, 265, 92, 29);
			contentPane.add(lblInitialPos);
			
			lblKeyword = new JLabel("Mot clé");
			lblKeyword.setForeground(Color.WHITE);
			lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblKeyword.setBounds(21, 265, 76, 29);
			contentPane.add(lblKeyword);
			
			cipherTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			cipherTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			cipherTextArea.setText("**Tapez votre texte cipher ici ou avoir une navigation**");
			cipherTextArea.setBounds(24, 351, 700, 92);
			contentPane.add(cipherTextArea);
			cipherTextArea.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (cipherTextArea.getText().equals("**Tapez votre texte cipher ici ou avoir une navigation**")){
			      		cipherTextArea.setText("");
		    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			lblCipherText = new JLabel("TEXTE CIPHER");
			lblCipherText.setHorizontalAlignment(SwingConstants.CENTER);
			lblCipherText.setForeground(new Color(30, 144, 255));
			lblCipherText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblCipherText.setBounds(315, 305, 135, 29);
			contentPane.add(lblCipherText);
			
			
			txtTypeTheKeyword = new JTextField();
			txtTypeTheKeyword.setText("*Tapez mot-clé ici");
			txtTypeTheKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			txtTypeTheKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTypeTheKeyword.setBounds(96, 266, 148, 25);
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
			lblHomophonesTable.setBounds(21, 105, 175, 29);
			contentPane.add(lblHomophonesTable);
			
			spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(375, 266, 45, 23);
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
			table.setBounds(21, 139, 708, 80);
			contentPane.add(table);
			table.setVisible(true);
			
			separator = new JSeparator();
			separator.setBounds(0, 303, 750, 2);
			contentPane.add(separator);
			
			btnMainMenu = new JButton("Menu Principal");
			btnMainMenu.setBounds(605, 24, 118, 23);
			contentPane.add(btnMainMenu);
			btnMainMenu.setActionCommand("Main Menu1");
			btnMainMenu.addActionListener(listener);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 74, 750, 2);
			contentPane.add(separator_1);
			
			btnBrowesKey = new JButton("Naviguer Clé");
			btnBrowesKey.setBounds(615, 230, 110, 23);
			contentPane.add(btnBrowesKey);
			btnBrowesKey.setActionCommand("Browse Key1");
			btnBrowesKey.addActionListener(listener);
			
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
			
			/*DECRPTION*/
			
			btnDecrypt = new JButton("DECRYPTER");
			btnDecrypt.setForeground(new Color(0, 0, 0));
			btnDecrypt.setFont(new Font("Algerian", Font.PLAIN, 16));
			btnDecrypt.setBounds(300, 475, 150, 40);
			btnDecrypt.setFocusPainted(false);
			contentPane.add(btnDecrypt);
			btnDecrypt.setActionCommand("Decrypt");
			btnDecrypt.addActionListener(listener);
			
			btnBrowseCipherText = new JButton("Naviguer");
			btnBrowseCipherText.setBounds(635, 449, 89, 23);
			contentPane.add(btnBrowseCipherText);
			btnBrowseCipherText.setActionCommand("Browse Cipher Text");
			btnBrowseCipherText.addActionListener(listener);
			frame.setVisible(true);
			break;
			
			
		case GERMAN:
			frame = new JFrame();
			contentPane = new JPanel();
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
			frame.setTitle("Entschlüsselungs");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 751, 561);
			frame.setLocationRelativeTo(null);
			
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);
			
			
			lblNewLabel = new JLabel("Entschlüsselungs");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(21, 21, 135, 29);
			contentPane.add(lblNewLabel);
			
			lblInitialPos = new JLabel("Ausgangsposition");
			lblInitialPos.setForeground(Color.WHITE);
			lblInitialPos.setHorizontalAlignment(SwingConstants.CENTER);
			lblInitialPos.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblInitialPos.setBounds(300, 265, 130, 29);
			contentPane.add(lblInitialPos);
			
			lblKeyword = new JLabel("Schlüsselwort");
			lblKeyword.setForeground(Color.WHITE);
			lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblKeyword.setBounds(15, 265, 115, 29);
			contentPane.add(lblKeyword);
			
			cipherTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			cipherTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			cipherTextArea.setText("**Geben Sie Ihren Chiffretext hier oder stöbern**");
			cipherTextArea.setBounds(24, 351, 700, 92);
			contentPane.add(cipherTextArea);
			cipherTextArea.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (cipherTextArea.getText().equals("**Geben Sie Ihren Chiffretext hier oder stöbern**")){
			      		cipherTextArea.setText("");
		    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			lblCipherText = new JLabel("CHIFFRETEXT");
			lblCipherText.setHorizontalAlignment(SwingConstants.CENTER);
			lblCipherText.setForeground(new Color(30, 144, 255));
			lblCipherText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblCipherText.setBounds(315, 305, 135, 29);
			contentPane.add(lblCipherText);
			
			
			txtTypeTheKeyword = new JTextField();
			txtTypeTheKeyword.setText("*Geben schlüsselwort hier");
			txtTypeTheKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			txtTypeTheKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTypeTheKeyword.setBounds(125, 266, 148, 25);
			contentPane.add(txtTypeTheKeyword);
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
			lblHomophonesTable.setBounds(20, 105, 165, 29);
			contentPane.add(lblHomophonesTable);
			
			spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(435, 266, 45, 23);
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
			table.setBounds(21, 139, 708, 80);
			contentPane.add(table);
			table.setVisible(true);
			
			separator = new JSeparator();
			separator.setBounds(0, 303, 750, 2);
			contentPane.add(separator);
			
			btnMainMenu = new JButton("Hauptmenü");
			btnMainMenu.setBounds(620, 24, 105, 23);
			contentPane.add(btnMainMenu);
			btnMainMenu.setActionCommand("Main Menu1");
			btnMainMenu.addActionListener(listener);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 74, 750, 2);
			contentPane.add(separator_1);
			
			btnBrowesKey = new JButton("Schmökern Schlüssel");
			btnBrowesKey.setBounds(570, 230, 160, 23);
			contentPane.add(btnBrowesKey);
			btnBrowesKey.setActionCommand("Browse Key1");
			btnBrowesKey.addActionListener(listener);
			
			separator_2 = new JSeparator();
			separator_2.setBounds(0, 105, 750, 2);
			contentPane.add(separator_2);
			
			lblTheKey = new JLabel("DER SCHLÜSSEL");
			lblTheKey.setHorizontalAlignment(SwingConstants.CENTER);
			lblTheKey.setForeground(new Color(30, 200, 255));
			lblTheKey.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblTheKey.setBounds(310, 78, 150, 29);
			contentPane.add(lblTheKey);
			
			separator_3 = new JSeparator();
			separator_3.setBounds(0, 335, 750, 2);
			contentPane.add(separator_3);
			
			/*DECRPTION*/
			
			btnDecrypt = new JButton("ENTSCHLÜSSELUNG");
			btnDecrypt.setForeground(new Color(0, 0, 0));
			btnDecrypt.setFont(new Font("Algerian", Font.PLAIN, 16));
			btnDecrypt.setBounds(290, 475, 190, 40);
			btnDecrypt.setFocusPainted(false);
			contentPane.add(btnDecrypt);
			btnDecrypt.setActionCommand("Decrypt");
			btnDecrypt.addActionListener(listener);
			
			
			btnBrowseCipherText = new JButton("Schmökern");
			btnBrowseCipherText.setBounds(625, 449, 100, 23);
			contentPane.add(btnBrowseCipherText);
			btnBrowseCipherText.setActionCommand("Browse Cipher Text");
			btnBrowseCipherText.addActionListener(listener);
			frame.setVisible(true);
			break;
			
			
		case SPANISH:
			frame = new JFrame();
			contentPane = new JPanel();
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
			frame.setTitle("Desencriptación");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(100, 100, 751, 561);
			frame.setLocationRelativeTo(null);
			
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPane.setLayout(null);
			frame.setContentPane(contentPane);
			
			lblNewLabel = new JLabel("Desencriptación");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(21, 21, 125, 29);
			contentPane.add(lblNewLabel);
			
			lblInitialPos = new JLabel("Pos. inicial");
			lblInitialPos.setForeground(Color.WHITE);
			lblInitialPos.setHorizontalAlignment(SwingConstants.CENTER);
			lblInitialPos.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblInitialPos.setBounds(320, 265, 92, 29);
			contentPane.add(lblInitialPos);
			
			lblKeyword = new JLabel("Palabra clave");
			lblKeyword.setForeground(Color.WHITE);
			lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyword.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
			lblKeyword.setBounds(21, 265, 100, 29);
			contentPane.add(lblKeyword);
			
			cipherTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			cipherTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			cipherTextArea.setText("**Escriba su texto plano o tener un browse**");
			cipherTextArea.setBounds(24, 351, 700, 92);
			contentPane.add(cipherTextArea);
			cipherTextArea.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			    	if (cipherTextArea.getText().equals("**Escriba su texto plano o tener un browse**")){
			      		cipherTextArea.setText("");
		    	}
			    }
			    public void focusLost(FocusEvent e) {}
			});
			
			lblCipherText = new JLabel("TEXTO CIFRADO");
			lblCipherText.setHorizontalAlignment(SwingConstants.CENTER);
			lblCipherText.setForeground(new Color(30, 144, 255));
			lblCipherText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 19));
			lblCipherText.setBounds(310, 305, 145, 29);
			contentPane.add(lblCipherText);
			
			
			txtTypeTheKeyword = new JTextField();
			txtTypeTheKeyword.setText("*Escriba palabra clave aquí");
			txtTypeTheKeyword.setHorizontalAlignment(SwingConstants.CENTER);
			txtTypeTheKeyword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtTypeTheKeyword.setBounds(125, 266, 165, 25);
			contentPane.add(txtTypeTheKeyword);
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
			lblHomophonesTable.setBounds(21, 105, 150, 29);
			contentPane.add(lblHomophonesTable);
			
			spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(410, 266, 45, 23);
			contentPane.add(spinner);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] {
						{null,null,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
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
			table.setBounds(21, 139, 708, 80);
			contentPane.add(table);
			table.setVisible(true);
			
			separator = new JSeparator();
			separator.setBounds(0, 303, 750, 2);
			contentPane.add(separator);
			
			btnMainMenu = new JButton("Menú Principal");
			btnMainMenu.setBounds(605, 24, 120, 23);
			contentPane.add(btnMainMenu);
			btnMainMenu.setActionCommand("Main Menu1");
			btnMainMenu.addActionListener(listener);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 74, 750, 2);
			contentPane.add(separator_1);
			
			btnBrowesKey = new JButton("Ramoneo Clave");
			btnBrowesKey.setBounds(608, 230, 122, 23);
			contentPane.add(btnBrowesKey);
			btnBrowesKey.setActionCommand("Browse Key1");
			btnBrowesKey.addActionListener(listener);
			
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
			
			/*DECRPTION*/
			
			btnDecrypt = new JButton("DESENCRIPTAR");
			btnDecrypt.setForeground(new Color(0, 0, 0));
			btnDecrypt.setFont(new Font("Algerian", Font.PLAIN, 16));
			btnDecrypt.setBounds(295, 475, 175, 40);
			btnDecrypt.setFocusPainted(false);
			contentPane.add(btnDecrypt);
			btnDecrypt.setActionCommand("Decrypt");
			btnDecrypt.addActionListener(listener);
			
			
			btnBrowseCipherText = new JButton("Ramoneo");
			btnBrowseCipherText.setBounds(635, 449, 89, 23);
			contentPane.add(btnBrowseCipherText);
			btnBrowseCipherText.setActionCommand("Browse Cipher Text");
			btnBrowseCipherText.addActionListener(listener);
			frame.setVisible(true);
			break;
		}
		
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This methods creates a pop-up window to show the resulted plain text after the decryption
	 * @param language
	 * @param listener
	 */
	public static void createPlainTextWindow(Language language, GuiListener listener){
		JSeparator separator_Cipher,separator_Cipher1;
		JButton  btnSaveCipherText;
		JLabel lblPlainText;
		
		switch(language){
		case ENGLISH:
			plainWindow = new JDialog();
	        plainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
	        plainWindow.setTitle("Plain Text");
	        plainWindow.setResizable(false);
	        plainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        plainWindow.setBounds(150, 100, 500, 500);
	        plainWindow.setLocationRelativeTo(null);
	        plainWindow.getContentPane().setBackground(Color.GRAY);
	        plainWindow.getContentPane().setLayout(null);
	        plainWindow.setVisible(true);
	       
	        separator_Cipher = new JSeparator();
			separator_Cipher.setBounds(0, 10, 500, 2);
			plainWindow.getContentPane().add(separator_Cipher);
			
			lblPlainText = new JLabel("PLAIN TEXT");
			lblPlainText.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlainText.setForeground(new Color(30, 144, 255));
			lblPlainText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
			lblPlainText.setBounds(185, 12, 125, 29);
			plainWindow.getContentPane().add(lblPlainText);
			
			
			separator_Cipher1 = new JSeparator();
			separator_Cipher1.setBounds(0, 40, 500, 2);
			plainWindow.getContentPane().add(separator_Cipher1);
	        
			plainTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			plainTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			plainTextArea.setBounds(5, 50, 480, 350);
			plainWindow.getContentPane().add(plainTextArea);
			
	        btnSaveCipherText = new JButton("Save");
	        btnSaveCipherText.setForeground(new Color(0, 0, 0));
	        btnSaveCipherText.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        btnSaveCipherText.setBounds(185, 425, 125, 30);
	        btnSaveCipherText.setFocusPainted(false);
	        plainWindow.getContentPane().add(btnSaveCipherText);
	        btnSaveCipherText.setActionCommand("Save Plain Text");
	        btnSaveCipherText.addActionListener(listener);
	        
			break;
			
		case FRENCH:
			 plainWindow = new JDialog();
             plainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
             plainWindow.setTitle("Texte Brut");
             plainWindow.setResizable(false);
             plainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             plainWindow.setBounds(150, 100, 500, 500);
             plainWindow.setLocationRelativeTo(null);
             plainWindow.getContentPane().setBackground(Color.GRAY);
             plainWindow.getContentPane().setLayout(null);
             plainWindow.setVisible(true);
            
            separator_Cipher = new JSeparator();
     		separator_Cipher.setBounds(0, 10, 500, 2);
     		plainWindow.getContentPane().add(separator_Cipher);
     		
     		lblPlainText = new JLabel("TEXTE BRUT");
     		lblPlainText.setHorizontalAlignment(SwingConstants.CENTER);
     		lblPlainText.setForeground(new Color(30, 144, 255));
     		lblPlainText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
     		lblPlainText.setBounds(185, 12, 125, 29);
     		plainWindow.getContentPane().add(lblPlainText);
     		
     		separator_Cipher1 = new JSeparator();
     		separator_Cipher1.setBounds(0, 40, 500, 2);
     		plainWindow.getContentPane().add(separator_Cipher1);
             
     		plainTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
     		plainTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
     		plainTextArea.setBounds(5, 50, 480, 350);
     		plainWindow.getContentPane().add(plainTextArea);
     		
             btnSaveCipherText = new JButton("Sauvegarder");
             btnSaveCipherText.setForeground(new Color(0, 0, 0));
             btnSaveCipherText.setFont(new Font("Tahoma", Font.PLAIN, 14));
             btnSaveCipherText.setBounds(185, 425, 125, 30);
             btnSaveCipherText.setFocusPainted(false);
             plainWindow.getContentPane().add(btnSaveCipherText);
             btnSaveCipherText.setActionCommand("Save Plain Text");
 	        btnSaveCipherText.addActionListener(listener);
			break;
			
		case GERMAN:
			 plainWindow = new JDialog();
             plainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
             plainWindow.setTitle("Klartext");
             plainWindow.setResizable(false);
             plainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             plainWindow.setBounds(150, 100, 500, 500);
             plainWindow.setLocationRelativeTo(null);
             plainWindow.getContentPane().setBackground(Color.GRAY);
             plainWindow.getContentPane().setLayout(null);
             plainWindow.setVisible(true);
            
            separator_Cipher = new JSeparator();
     		separator_Cipher.setBounds(0, 10, 500, 2);
     		plainWindow.getContentPane().add(separator_Cipher);
     		
     		lblPlainText = new JLabel("KLARTEXT");
     		lblPlainText.setHorizontalAlignment(SwingConstants.CENTER);
     		lblPlainText.setForeground(new Color(30, 144, 255));
     		lblPlainText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
     		lblPlainText.setBounds(185, 12, 125, 29);
     		plainWindow.getContentPane().add(lblPlainText);
     		
     		separator_Cipher1 = new JSeparator();
     		separator_Cipher1.setBounds(0, 40, 500, 2);
     		plainWindow.getContentPane().add(separator_Cipher1);
             
     		plainTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
     		plainTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
     		plainTextArea.setBounds(5, 50, 480, 350);
     		plainWindow.getContentPane().add(plainTextArea);
     		
             btnSaveCipherText = new JButton("Speichern");
             btnSaveCipherText.setForeground(new Color(0, 0, 0));
             btnSaveCipherText.setFont(new Font("Tahoma", Font.PLAIN, 14));
             btnSaveCipherText.setBounds(190, 425, 125, 30);
             btnSaveCipherText.setFocusPainted(false);
             plainWindow.getContentPane().add(btnSaveCipherText);
             btnSaveCipherText.setActionCommand("Save Plain Text");
 	         btnSaveCipherText.addActionListener(listener);
			break;
			
		case SPANISH:
			plainWindow = new JDialog();
            plainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
            plainWindow.setTitle("Texto Plano");
            plainWindow.setResizable(false);
            plainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            plainWindow.setBounds(150, 100, 500, 500);
            plainWindow.setLocationRelativeTo(null);
            plainWindow.getContentPane().setBackground(Color.GRAY);
            plainWindow.getContentPane().setLayout(null);
            plainWindow.setVisible(true);
           
            separator_Cipher = new JSeparator();
    		separator_Cipher.setBounds(0, 10, 500, 2);
    		plainWindow.getContentPane().add(separator_Cipher);
    		
    		lblPlainText = new JLabel("TEXTO PLANO");
    		lblPlainText.setHorizontalAlignment(SwingConstants.CENTER);
    		lblPlainText.setForeground(new Color(30, 144, 255));
    		lblPlainText.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 17));
    		lblPlainText.setBounds(185, 12, 125, 29);
    		plainWindow.getContentPane().add(lblPlainText);
    		
    		separator_Cipher1 = new JSeparator();
    		separator_Cipher1.setBounds(0, 40, 500, 2);
    		plainWindow.getContentPane().add(separator_Cipher1);
            
    		plainTextArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
    		plainTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
    		plainTextArea.setBounds(5, 50, 480, 350);
    		plainWindow.getContentPane().add(plainTextArea);
    		
    		btnSaveCipherText = new JButton("Guardar");
            btnSaveCipherText.setForeground(new Color(0, 0, 0));
            btnSaveCipherText.setFont(new Font("Tahoma", Font.PLAIN, 14));
            btnSaveCipherText.setBounds(190, 425, 125, 30);
            btnSaveCipherText.setFocusPainted(false);
            plainWindow.add(btnSaveCipherText);
            btnSaveCipherText.setActionCommand("Save Plain Text");
	        btnSaveCipherText.addActionListener(listener);
			break;
		}
		
	}
		
}
