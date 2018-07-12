package GUIPackage;



import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import languagesPackage.Language;


/**
 * This is a LanguageWindow Class
 * it creates a simple-small window 
 * to let the user choose the language they want
 * The supported Languages are (English, French, German, and Spanish)
 * @author Yahya Almardeny
 * @version 05/10/2016
 *
 */
public class LanguageWindow {
	/*The language field is very important because it'll be a reference for all further operations in the GuiListener Class
	 * it holds the language chosen by the user to reference the next windows and operations
	 * it must be static and public to be accessed freely by the GuiListener Class at any time
	 * always initialize the language field with the English Language as a default language
	*/
	public static Language language = Language.ENGLISH; 
	public static JFrame chooseLanguage;

	/*Eclipse implicitly creates a constructor when it's not created*/
	
	/**
	 * This method creates the LanguageWindow 
	 * it's static to be accessed directly without having to
	 * create an instance of the class
	 * @param listener
	 */
	public static void createLanguageWindow(GuiListener listener) {
		/*Create The Language Frame and its Components*/
		chooseLanguage = new JFrame();
		chooseLanguage.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		chooseLanguage.setForeground(Color.BLACK);
		chooseLanguage.setBackground(Color.LIGHT_GRAY);
		chooseLanguage.getContentPane().setBackground(Color.DARK_GRAY);
		chooseLanguage.setIconImage(Toolkit.getDefaultToolkit().getImage(LanguageWindow.class.getResource("/GUIPackage/images/icon.png")));
		chooseLanguage.setTitle("Language");
		chooseLanguage.setResizable(false);
		chooseLanguage.setBounds(10, 10, 271, 160);
		chooseLanguage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseLanguage.setLocationRelativeTo(null);
		chooseLanguage.getContentPane().setLayout(null);
		
		
		JLabel lblLanguageLabel = new JLabel("Choose Language");
		lblLanguageLabel.setForeground(Color.WHITE);
		lblLanguageLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblLanguageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLanguageLabel.setBounds(31, 11, 196, 29);
		chooseLanguage.getContentPane().add(lblLanguageLabel);
		
		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"English", "French", "German", "Spanish"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(68, 47, 122, 23);
		chooseLanguage.getContentPane().add(comboBox);
		chooseLanguage.setVisible(true); 
		
		comboBox.addActionListener(new ActionListener() { // listen what the user chose from the list of the languages in the comboBox
				public void actionPerformed(ActionEvent e){
						switch(comboBox.getSelectedItem().toString()){
							case "English":
								language = Language.ENGLISH;
								break;
							case "French":
								language = Language.FRENCH;
								break;
							case "German":
								language = Language.GERMAN;
								break;
							case "Spanish":
								language = Language.SPANISH;
								break;
						}
        	
        	}  
        });
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(93, 88, 75, 23);
		chooseLanguage.getContentPane().add(btnOk);
		btnOk.setActionCommand("Language Selected");
		btnOk.addActionListener(listener);
        				
      
		
	
	}
	
	
	

}
		
	
		
	
		
