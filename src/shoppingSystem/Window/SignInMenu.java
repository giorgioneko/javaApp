package shoppingSystem.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shoppingSystem.ApplicationContext;
import shoppingSystem.DefaultUserManagementService;
import shoppingSystem.User;
import shoppingSystem.UserManagementService;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignInMenu extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EmailTextField;
	
	private ApplicationContext context;
	private UserManagementService userManagementService;
	private JPasswordField passwordField;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SignInMenu() {
		setIconImage(new ImageIcon(System.getProperty("user.dir")+"\\src\\shoppingSystem\\icon\\STL211940.jpg").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton signinButton = new JButton("Sign in");
		signinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = userManagementService.getUserByEmail(EmailTextField.getText());
				if (user != null && user.SamePassword(String.valueOf(passwordField.getPassword()) )) {
					System.out.printf("Wlecome back %s %s", user.getFirstName(),
							user.getLastName() + System.lineSeparator());
					context.setLoggedInUser(user);
					try {
						new MainMenu();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				} else {
					System.out.println("This email or password does not exist");
				}
				
				
			}
		});
		signinButton.setBorderPainted(false);
		signinButton.setBackground(Color.LIGHT_GRAY);
		signinButton.setFont(new Font("Arial", Font.BOLD, 16));
		signinButton.setBounds(121, 397, 229, 81);
		contentPane.add(signinButton);
		
		JButton signUpButton = new JButton("Sign up");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUpMenu();
			}
		});
		signUpButton.setBorderPainted(false);
		signUpButton.setBackground(Color.ORANGE);
		signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
		signUpButton.setBounds(419, 397, 276, 81);
		contentPane.add(signUpButton);
		
		EmailTextField = new JTextField();
		EmailTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		EmailTextField.setBounds(97, 115, 598, 52);
		contentPane.add(EmailTextField);
		EmailTextField.setColumns(10);
		
		JLabel header = new JLabel("Sign in/Sign up");
		header.setFont(new Font("Arial", Font.PLAIN, 16));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBounds(75, 11, 568, 59);
		contentPane.add(header);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setBounds(10, 102, 74, 81);
		contentPane.add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(0, 223, 87, 81);
		contentPane.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(97, 236, 598, 52);
		contentPane.add(passwordField);
		setVisible(true);
	}
}
