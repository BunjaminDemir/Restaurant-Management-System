package Login_sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLoginManagementSystem;
	private JPasswordField txtPassword;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginManagementSystem = new JFrame();
		frmLoginManagementSystem.getContentPane().setBackground(new Color(47, 79, 79));
		frmLoginManagementSystem.setResizable(false);
		frmLoginManagementSystem.setTitle("Login Management System ");
		frmLoginManagementSystem.setBounds(100, 100, 585, 323);
		frmLoginManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginManagementSystem.getContentPane().setLayout(null);
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			private Component frame;

			public void actionPerformed(ActionEvent e) {
					
				
			String username = txtUsername.getText();
			String password = txtPassword.getText();
				
				
				
				if (username.contains("Administrator") && password.contains("King"))
				{
				     txtPassword.setText(null);
				     txtUsername.setText(null);
				     
				     JOptionPane.showMessageDialog(btnLogin, "Welcome to Our Program " + username);
				     
				   
				     
				      
				   
				    
				}else{
					JOptionPane.showMessageDialog(frame,
						    "Invalid Login Details");
					
				}
				
			 
			
			
			}

			private Point s(String string) {
				// TODO Auto-generated method stub
				return null;
			}
				
			
			
		});
		btnLogin.setBounds(463, 227, 89, 23);
		frmLoginManagementSystem.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(364, 227, 89, 23);
		frmLoginManagementSystem.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(265, 227, 89, 23);
		frmLoginManagementSystem.getContentPane().add(btnExit);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(364, 117, 147, 23);
		frmLoginManagementSystem.getContentPane().add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(364, 72, 147, 20);
		frmLoginManagementSystem.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(251, 73, 89, 14);
		frmLoginManagementSystem.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_1.setBounds(251, 121, 89, 14);
		frmLoginManagementSystem.getContentPane().add(lblNewLabel_1);
		
		final JButton btnResim = new JButton("");
		btnResim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(btnResim, "This Program is  Coded by BUNJAMIN DEMIR  | CMS  V.10 LOGIN PANEL ");
			}
		});
		btnResim.setIcon(new ImageIcon("C:\\Users\\Bunjamin\\Desktop\\accountlogin-icon.png"));
		btnResim.setBounds(33, 11, 173, 228);
		frmLoginManagementSystem.getContentPane().add(btnResim);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(235, 189, 306, 2);
		frmLoginManagementSystem.getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login System ");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2.setBounds(265, 11, 220, 24);
		frmLoginManagementSystem.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(235, 44, 306, 2);
		frmLoginManagementSystem.getContentPane().add(separator_1);
		
		JLabel lblerror = new JLabel("Welcome to Our  Management System ");
		lblerror.setEnabled(false);
		lblerror.setBounds(265, 164, 220, 14);
		frmLoginManagementSystem.getContentPane().add(lblerror);
		frmLoginManagementSystem.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmLoginManagementSystem.getContentPane(), btnLogin, btnReset, btnExit, txtPassword, txtUsername, lblNewLabel, lblNewLabel_1, btnResim, separator, lblNewLabel_2}));
	}

	protected Point Str(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
