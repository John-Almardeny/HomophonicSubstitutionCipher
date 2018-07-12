package GUIPackage;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import languagesPackage.Language;


/**
 * This is a simple GUI window Class that contains
 * overview about the author for the user
 * in 5 different languages (English, French, German and Spanish)
 * @author Yahya Almardeny
 * @version 05/10/2016
 */
public class AboutWindow {

    /**The constructor
     * @param language
     */
	public AboutWindow(Language language) {
		JFrame frame = new JFrame();
		JPanel contentPane = new JPanel();
		JLabel lblNewLabel,lblanImprovedVersion,lblAuthorYahyaAlmardeny,lblEmailAlmardenygamilcom,lblGithubGithubcomjohnalmardeny,lblAllRightsReserved;
		switch (language){
			case ENGLISH:
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
				frame.setTitle("About");
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(100, 100, 561, 414);
				frame.setLocationRelativeTo(null);
				contentPane = new JPanel();
				contentPane.setBackground(Color.DARK_GRAY);
				contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				contentPane.setLayout(null);
				frame.setContentPane(contentPane);
				
				
				lblNewLabel = new JLabel("Homophonic Substitution Cipher");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(84, 36, 387, 73);
				contentPane.add(lblNewLabel);
				
				lblanImprovedVersion = new JLabel("(An Improved Version of Spanish Strip Cipher in 4 Different Languages)");
				lblanImprovedVersion.setForeground(Color.WHITE);
				lblanImprovedVersion.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblanImprovedVersion.setHorizontalAlignment(SwingConstants.CENTER);
				lblanImprovedVersion.setBounds(39, 89, 485, 73);
				contentPane.add(lblanImprovedVersion);
				
				
				lblAuthorYahyaAlmardeny = new JLabel("Author: Yahya Almardeny");
				lblAuthorYahyaAlmardeny.setForeground(SystemColor.textHighlight);
				lblAuthorYahyaAlmardeny.setFont(new Font("Papyrus", Font.BOLD, 18));
				lblAuthorYahyaAlmardeny.setHorizontalAlignment(SwingConstants.CENTER);
				lblAuthorYahyaAlmardeny.setBounds(138, 173, 258, 73);
				contentPane.add(lblAuthorYahyaAlmardeny);
				
				lblEmailAlmardenygamilcom = new JLabel("E-mail: almardeny@gamil.com");
				lblEmailAlmardenygamilcom.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblEmailAlmardenygamilcom.setForeground(Color.WHITE);
				lblEmailAlmardenygamilcom.setHorizontalAlignment(SwingConstants.CENTER);
				lblEmailAlmardenygamilcom.setBounds(154, 257, 231, 35);
				contentPane.add(lblEmailAlmardenygamilcom);
				
				lblGithubGithubcomjohnalmardeny = new JLabel("GitHub: github.com/John-Almardeny ");
				lblGithubGithubcomjohnalmardeny.setForeground(new Color(255, 255, 255));
				lblGithubGithubcomjohnalmardeny.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblGithubGithubcomjohnalmardeny.setHorizontalAlignment(SwingConstants.CENTER);
				lblGithubGithubcomjohnalmardeny.setBounds(148, 292, 248, 35);
				contentPane.add(lblGithubGithubcomjohnalmardeny);
				
				lblAllRightsReserved = new JLabel("All Rights Reserved 2016©");
				lblAllRightsReserved.setForeground(new Color(255, 255, 255));
				lblAllRightsReserved.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
				lblAllRightsReserved.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllRightsReserved.setBounds(158, 346, 220, 35);
				contentPane.add(lblAllRightsReserved);
				frame.setVisible(true);
				break;
				
				
			case FRENCH:
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
				frame.setTitle("À Oropos De Nous");
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(100, 100, 561, 414);
				frame.setLocationRelativeTo(null);
				contentPane = new JPanel();
				contentPane.setBackground(Color.DARK_GRAY);
				contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				contentPane.setLayout(null);
				frame.setContentPane(contentPane);
				
				
				lblNewLabel = new JLabel("Homophonique Substitution Cipher");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(84, 36, 387, 73);
				contentPane.add(lblNewLabel);
				
				lblanImprovedVersion = new JLabel("(Une version améliorée de l'espagnol Strip Cipher en 4 langues différentes)");
				lblanImprovedVersion.setForeground(Color.WHITE);
				lblanImprovedVersion.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblanImprovedVersion.setHorizontalAlignment(SwingConstants.CENTER);
				lblanImprovedVersion.setBounds(10, 89, 535, 73);
				contentPane.add(lblanImprovedVersion);
				
				lblAuthorYahyaAlmardeny = new JLabel("Auteur: Yahya Almardeny");
				lblAuthorYahyaAlmardeny.setForeground(SystemColor.textHighlight);
				lblAuthorYahyaAlmardeny.setFont(new Font("Papyrus", Font.BOLD, 18));
				lblAuthorYahyaAlmardeny.setHorizontalAlignment(SwingConstants.CENTER);
				lblAuthorYahyaAlmardeny.setBounds(138, 173, 258, 73);
				contentPane.add(lblAuthorYahyaAlmardeny);
				
				lblEmailAlmardenygamilcom = new JLabel("E-mail: almardeny@gamil.com");
				lblEmailAlmardenygamilcom.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblEmailAlmardenygamilcom.setForeground(Color.WHITE);
				lblEmailAlmardenygamilcom.setHorizontalAlignment(SwingConstants.CENTER);
				lblEmailAlmardenygamilcom.setBounds(154, 257, 231, 35);
				contentPane.add(lblEmailAlmardenygamilcom);
				
				lblGithubGithubcomjohnalmardeny = new JLabel("GitHub: github.com/John-Almardeny ");
				lblGithubGithubcomjohnalmardeny.setForeground(new Color(255, 255, 255));
				lblGithubGithubcomjohnalmardeny.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblGithubGithubcomjohnalmardeny.setHorizontalAlignment(SwingConstants.CENTER);
				lblGithubGithubcomjohnalmardeny.setBounds(148, 292, 248, 35);
				contentPane.add(lblGithubGithubcomjohnalmardeny);
				
				lblAllRightsReserved = new JLabel("Tous Droits Réservés 2016 ©");
				lblAllRightsReserved.setForeground(new Color(255, 255, 255));
				lblAllRightsReserved.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
				lblAllRightsReserved.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllRightsReserved.setBounds(158, 346, 220, 35);
				contentPane.add(lblAllRightsReserved);
				frame.setVisible(true);
				break;
				
				
			case GERMAN:
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
				frame.setTitle("Über Uns");
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(100, 100, 597, 414);
				frame.setLocationRelativeTo(null);
				contentPane = new JPanel();
				contentPane.setBackground(Color.DARK_GRAY);
				contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				contentPane.setLayout(null);
				frame.setContentPane(contentPane);
				
				
				lblNewLabel = new JLabel("Homophonic Substitution Cipher");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(100, 36, 387, 73);
				contentPane.add(lblNewLabel);
				
				lblanImprovedVersion = new JLabel("(Eine verbesserte Version des spanischen Streifen Cipher in 4 verschiedenen Sprachen)");
				lblanImprovedVersion.setForeground(Color.WHITE);
				lblanImprovedVersion.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblanImprovedVersion.setHorizontalAlignment(SwingConstants.CENTER);
				lblanImprovedVersion.setBounds(10, 89, 571, 73);
				contentPane.add(lblanImprovedVersion);
				
				lblAuthorYahyaAlmardeny = new JLabel("Autor: Yahya Almardeny");
				lblAuthorYahyaAlmardeny.setForeground(SystemColor.textHighlight);
				lblAuthorYahyaAlmardeny.setFont(new Font("Papyrus", Font.BOLD, 18));
				lblAuthorYahyaAlmardeny.setHorizontalAlignment(SwingConstants.CENTER);
				lblAuthorYahyaAlmardeny.setBounds(169, 166, 258, 73);
				contentPane.add(lblAuthorYahyaAlmardeny);
				
				lblEmailAlmardenygamilcom = new JLabel("E-mail: almardeny@gamil.com");
				lblEmailAlmardenygamilcom.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblEmailAlmardenygamilcom.setForeground(Color.WHITE);
				lblEmailAlmardenygamilcom.setHorizontalAlignment(SwingConstants.CENTER);
				lblEmailAlmardenygamilcom.setBounds(177, 250, 231, 35);
				contentPane.add(lblEmailAlmardenygamilcom);
				
				lblGithubGithubcomjohnalmardeny = new JLabel("GitHub: github.com/John-Almardeny ");
				lblGithubGithubcomjohnalmardeny.setForeground(new Color(255, 255, 255));
				lblGithubGithubcomjohnalmardeny.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblGithubGithubcomjohnalmardeny.setHorizontalAlignment(SwingConstants.CENTER);
				lblGithubGithubcomjohnalmardeny.setBounds(171, 285, 248, 35);
				contentPane.add(lblGithubGithubcomjohnalmardeny);
				
				lblAllRightsReserved = new JLabel("Alle Rechte Vorbehalten 2016 ©");
				lblAllRightsReserved.setForeground(new Color(255, 255, 255));
				lblAllRightsReserved.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
				lblAllRightsReserved.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllRightsReserved.setBounds(177, 339, 238, 35);
				contentPane.add(lblAllRightsReserved);
				frame.setVisible(true);
				break;
				
				
			case SPANISH:
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptionWindow.class.getResource("/GUIPackage/images/icon.png")));
				frame.setTitle("Sobre Nosotros");
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(100, 100, 532, 414);
				frame.setLocationRelativeTo(null);
				contentPane = new JPanel();
				contentPane.setBackground(Color.DARK_GRAY);
				contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				contentPane.setLayout(null);
				frame.setContentPane(contentPane);
				
				
				lblNewLabel = new JLabel("Homophonic Sustitución Cipher");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(66, 36, 387, 73);
				contentPane.add(lblNewLabel);
				
				lblanImprovedVersion = new JLabel("(Una versión mejorada del español Gaza Cipher en 4 idiomas diferentes)");
				lblanImprovedVersion.setForeground(Color.WHITE);
				lblanImprovedVersion.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblanImprovedVersion.setHorizontalAlignment(SwingConstants.CENTER);
				lblanImprovedVersion.setBounds(-24, 89, 571, 73);
				contentPane.add(lblanImprovedVersion);
				
				lblAuthorYahyaAlmardeny = new JLabel("Autor: Yahya Almardeny");
				lblAuthorYahyaAlmardeny.setForeground(SystemColor.textHighlight);
				lblAuthorYahyaAlmardeny.setFont(new Font("Papyrus", Font.BOLD, 18));
				lblAuthorYahyaAlmardeny.setHorizontalAlignment(SwingConstants.CENTER);
				lblAuthorYahyaAlmardeny.setBounds(135, 166, 258, 73);
				contentPane.add(lblAuthorYahyaAlmardeny);
				
				lblEmailAlmardenygamilcom = new JLabel("E-mail: almardeny@gamil.com");
				lblEmailAlmardenygamilcom.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblEmailAlmardenygamilcom.setForeground(Color.WHITE);
				lblEmailAlmardenygamilcom.setHorizontalAlignment(SwingConstants.CENTER);
				lblEmailAlmardenygamilcom.setBounds(143, 250, 231, 35);
				contentPane.add(lblEmailAlmardenygamilcom);
				
				lblGithubGithubcomjohnalmardeny = new JLabel("GitHub: github.com/John-Almardeny ");
				lblGithubGithubcomjohnalmardeny.setForeground(new Color(255, 255, 255));
				lblGithubGithubcomjohnalmardeny.setFont(new Font("Sylfaen", Font.PLAIN, 16));
				lblGithubGithubcomjohnalmardeny.setHorizontalAlignment(SwingConstants.CENTER);
				lblGithubGithubcomjohnalmardeny.setBounds(137, 285, 248, 35);
				contentPane.add(lblGithubGithubcomjohnalmardeny);
				
				lblAllRightsReserved = new JLabel("Todos Los Derechos Reservados © 2016");
				lblAllRightsReserved.setForeground(new Color(255, 255, 255));
				lblAllRightsReserved.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
				lblAllRightsReserved.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllRightsReserved.setBounds(116, 339, 286, 35);
				contentPane.add(lblAllRightsReserved);
				frame.setVisible(true);
				break;
				
		}
	
		
		
	}
}