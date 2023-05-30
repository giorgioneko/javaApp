package shoppingSystem.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shoppingSystem.ApplicationContext;
import shoppingSystem.DefaultUser;
import shoppingSystem.DefaultUserManagementService;
import shoppingSystem.User;
import shoppingSystem.UserManagementService;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class SignUpMenu extends JFrame {
	/**
 * 
 */
private static final long serialVersionUID = 1L;
private UserManagementService userManagementService;
private JPanel contentPane;
private JTextField textFieldName;
private JTextField textFieldEmail;
private JTextField textFieldLastName;
JLabel errorMessage;
private JPasswordField passwordField;
private JPasswordField confirmPasswordField;

{
	userManagementService = DefaultUserManagementService.getInstance();
	ApplicationContext.getInstance();



}
public SignUpMenu() {
	setIconImage(new ImageIcon(System.getProperty("user.dir")+"\\src\\shoppingSystem\\icon\\STL211940.jpg").getImage());
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 762, 541);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	getContentPane().setLayout(null);
	
	textFieldName = new JTextField();
	textFieldName.setBounds(167, 47, 530, 48);
	getContentPane().add(textFieldName);
	textFieldName.setColumns(10);
	
	textFieldEmail = new JTextField();
	textFieldEmail.setColumns(10);
	textFieldEmail.setBounds(167, 332, 530, 48);
	getContentPane().add(textFieldEmail);
	
	JLabel header = new JLabel("Sign up");
	header.setFont(new Font("Arial", Font.PLAIN, 16));
	header.setHorizontalAlignment(SwingConstants.CENTER);
	header.setBounds(211, 11, 467, 25);
	getContentPane().add(header);
	
	JButton confirmButton = new JButton("Confirm");
	confirmButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				User newUser= new DefaultUser(textFieldName.getText(),textFieldLastName.getText(),String.valueOf(passwordField.getPassword()),textFieldEmail.getText(),String.valueOf(confirmPasswordField.getPassword()));
				 userManagementService.registerUser(newUser);
				 dispose();
			} catch (Exception e1) {
				errorMessage.setVisible(true);
			}
			
		}
	});
	confirmButton.setBackground(Color.GREEN);
	confirmButton.setBorderPainted(false);
	confirmButton.setFont(new Font("Arial", Font.BOLD, 16));
	confirmButton.setBounds(502, 429, 195, 63);
	getContentPane().add(confirmButton);
	
	JLabel nameLabel = new JLabel("Name");
	nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	nameLabel.setBounds(10, 49, 102, 40);
	getContentPane().add(nameLabel);
	
	JLabel passwordLabel = new JLabel("Password");
	passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
	passwordLabel.setBounds(10, 184, 102, 40);
	getContentPane().add(passwordLabel);
	
	JLabel confirmPasswordLabel = new JLabel("Confrim Password");
	confirmPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
	confirmPasswordLabel.setBounds(10, 258, 131, 40);
	getContentPane().add(confirmPasswordLabel);
	
	JLabel emailLabel = new JLabel("E-mail");
	emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
	emailLabel.setBounds(10, 334, 102, 40);
	getContentPane().add(emailLabel);
	
	textFieldLastName = new JTextField();
	textFieldLastName.setColumns(10);
	textFieldLastName.setBounds(167, 108, 530, 48);
	contentPane.add(textFieldLastName);
	
	JLabel lastNameLabel = new JLabel("Last name");
	lastNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lastNameLabel.setBounds(10, 110, 102, 40);
	contentPane.add(lastNameLabel);
	
	errorMessage = new JLabel("Is not the same as password");
	errorMessage.setVisible(false);
	errorMessage.setBackground(Color.RED);
	errorMessage.setForeground(Color.RED);
	errorMessage.setBounds(177, 307, 520, 14);
	contentPane.add(errorMessage);
	
	passwordField = new JPasswordField();
	passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
	passwordField.setBounds(167, 181, 530, 49);
	contentPane.add(passwordField);
	
	confirmPasswordField = new JPasswordField();
	confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
		confirmPasswordField.setBounds(167, 256, 530, 49);
		contentPane.add(confirmPasswordField);
		setVisible(true);
	}


}
