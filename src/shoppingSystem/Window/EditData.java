package shoppingSystem.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import shoppingSystem.ApplicationContext;
import shoppingSystem.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EditData extends JFrame {

	/**
 * 
 */
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private ApplicationContext context;
private JTextField OLdEmail;
private JTextField NewEmail;
private JPasswordField oldPassword;
private JPasswordField NewPassword;
private JPasswordField ConfirmPassword;




/**
 * Create the frame.
 */
public EditData(String data) {
	setIconImage(new ImageIcon(System.getProperty("user.dir")+"\\src\\shoppingSystem\\icon\\STL211940.jpg").getImage());
	context = ApplicationContext.getInstance();
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
	
	
	
	
	
	
	
	switch (data) {
	case "E-mail": {
		setTitle("Change E-mail");
		setBounds(100, 100, 450, 319);
	    OLdEmail = new JTextField();
		OLdEmail.setBounds(52, 72, 347, 37);
		contentPane.add(OLdEmail);
		OLdEmail.setColumns(10);
		
		NewEmail = new JTextField();
		NewEmail.setColumns(10);
		NewEmail.setBounds(52, 160, 347, 37);
		contentPane.add(NewEmail);
		JLabel errorLabelEmptyEmailField = new JLabel("fill in an E-mail");
		errorLabelEmptyEmailField.setForeground(Color.RED);
		errorLabelEmptyEmailField.setBounds(52, 200, 247, 14);
		contentPane.add(errorLabelEmptyEmailField);
		errorLabelEmptyEmailField.setVisible(false);
		
		JLabel oldeEmailLabel = new JLabel("Old E-mail");
		oldeEmailLabel.setBounds(52, 47, 293, 14);
		contentPane.add(oldeEmailLabel);
		
		JLabel newEmailLabel = new JLabel("New E-mail");
		newEmailLabel.setBounds(52, 138, 293, 14);
		contentPane.add(newEmailLabel);
		
		JLabel header = new JLabel("Change E-mail");
		header.setFont(new Font("Arial", Font.PLAIN, 14));
		header.setBounds(10, 11, 288, 23);
		contentPane.add(header);
		JLabel errorLabelCurrentEmailNotSame = new JLabel("old E-mail not the same as current E-mail");
		errorLabelCurrentEmailNotSame.setForeground(Color.RED);
		errorLabelCurrentEmailNotSame.setBounds(52, 113, 247, 14);
		contentPane.add(errorLabelCurrentEmailNotSame);
		errorLabelCurrentEmailNotSame.setVisible(false);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User currentuser = context.getLoggedInUser();
				if (currentuser.getEmail().equals(OLdEmail.getText())) {
					errorLabelCurrentEmailNotSame.setVisible(false);
					if (!NewEmail.getText().trim().equals("") ) {
						errorLabelEmptyEmailField.setVisible(false);
						currentuser.setEmail(NewEmail.getText());
						dispose();
					}
					else {
						
						
						
						errorLabelEmptyEmailField.setVisible(true);
					}
				}
				else {
				
					errorLabelCurrentEmailNotSame.setVisible(true);
				}
			}
		});
		confirmButton.setBounds(278, 227, 146, 42);
		contentPane.add(confirmButton);
		break;
		
	}
	
	case "Password": {
		setTitle("Change password");
		setBounds(100, 100, 516, 341);
		JLabel header = new JLabel("Change password");
		header.setFont(new Font("Arial", Font.BOLD, 16));
		header.setBounds(21, 11, 160, 29);
		contentPane.add(header);
		
		JLabel oldPasswordLabel = new JLabel("Old password");
		oldPasswordLabel.setBounds(10, 54, 106, 23);
		contentPane.add(oldPasswordLabel);
		
		JLabel newPasswordLabel = new JLabel("New password");
		newPasswordLabel.setBounds(10, 114, 106, 23);
		contentPane.add(newPasswordLabel);
		
		JLabel confirmPasswordLabel = new JLabel("Confirm password");
		confirmPasswordLabel.setBounds(10, 170, 106, 23);
		contentPane.add(confirmPasswordLabel);
		
		
		oldPassword = new JPasswordField();
		oldPassword.setBounds(136, 51, 229, 29);
		contentPane.add(oldPassword);
		oldPassword.setColumns(10);
		
		NewPassword = new JPasswordField();
		NewPassword.setColumns(10);
		NewPassword.setBounds(136, 108, 229, 29);
		contentPane.add(NewPassword);
		
		ConfirmPassword = new JPasswordField();
		ConfirmPassword.setColumns(10);
		ConfirmPassword.setBounds(136, 167, 229, 29);
		contentPane.add(ConfirmPassword);
		JLabel errorLabelOldPasswordNotSameAsCurrent = new JLabel("Old password is not same as current one ");
		errorLabelOldPasswordNotSameAsCurrent.setForeground(Color.RED);
		errorLabelOldPasswordNotSameAsCurrent.setBounds(136, 83, 402, 14);
		contentPane.add(errorLabelOldPasswordNotSameAsCurrent);
		errorLabelOldPasswordNotSameAsCurrent.setVisible(false);
		JLabel errorLabelCofrimNtSameAsNewOrNewIsEmpty = new JLabel("Confrim password is not same as new password or is empty");
		errorLabelCofrimNtSameAsNewOrNewIsEmpty.setForeground(Color.RED);
		errorLabelCofrimNtSameAsNewOrNewIsEmpty.setBounds(136, 206, 426, 14);
		contentPane.add(errorLabelCofrimNtSameAsNewOrNewIsEmpty);
		errorLabelCofrimNtSameAsNewOrNewIsEmpty.setVisible(false);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User currentUser = context.getLoggedInUser();
				if (currentUser.SamePassword(String.valueOf(oldPassword.getPassword()))) {
					errorLabelOldPasswordNotSameAsCurrent.setVisible(false);
					if (String.valueOf(NewPassword.getPassword()).equals(String.valueOf(ConfirmPassword.getPassword())) && !String.valueOf(NewPassword.getPassword()).trim().equals("")) {
						errorLabelCofrimNtSameAsNewOrNewIsEmpty.setVisible(false);
						currentUser.setPassword(String.valueOf(NewPassword.getPassword()));
						dispose();
					}
					else {
						
						errorLabelCofrimNtSameAsNewOrNewIsEmpty.setVisible(true);
					}
				}
				else {
					
					errorLabelOldPasswordNotSameAsCurrent.setVisible(true);
				}
				
			}
		});
		confirmButton.setFont(new Font("Arial", Font.PLAIN, 16));
			confirmButton.setBounds(318, 244, 106, 39);
			contentPane.add(confirmButton);
			
			
			break;
		
			
		}
		
		}
		
		setVisible(true);
		
	}

}
