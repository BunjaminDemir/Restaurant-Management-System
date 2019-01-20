package Mng_sys;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Control_Panel {

	private JFrame frmHomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Control_Panel window = new Control_Panel();
					window.frmHomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Control_Panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomePage = new JFrame();
		frmHomePage.setTitle("Home Page");
		frmHomePage.setResizable(false);
		frmHomePage.setAlwaysOnTop(true);
		frmHomePage.setType(Type.UTILITY);
		frmHomePage.getContentPane().setBackground(new Color(51, 102, 102));
		frmHomePage.setBounds(100, 100, 659, 451);
		frmHomePage.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 11, 684, 2);
		frmHomePage.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 39, 684, 2);
		frmHomePage.getContentPane().add(separator_1);
		
		
		
		
		final JButton btnMainPage = new JButton("MainPage");
		btnMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(btnMainPage, "You Are in Main Page");
			
			}
		});
		btnMainPage.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnMainPage.setBounds(275, 11, 90, 30);
		frmHomePage.getContentPane().add(btnMainPage);
		
		JButton btnMeals = new JButton("Meals");
		btnMeals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMeals.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnMeals.setBounds(20, 11, 90, 30);
		frmHomePage.getContentPane().add(btnMeals);
		
		JButton btnDrinks = new JButton("Drinks");
		btnDrinks.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDrinks.setBounds(143, 11, 90, 30);
		frmHomePage.getContentPane().add(btnDrinks);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnOrder.setBounds(422, 11, 90, 30);
		frmHomePage.getContentPane().add(btnOrder);
		
		JButton btnBudget = new JButton("Budget");
		btnBudget.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBudget.setBounds(535, 11, 90, 30);
		frmHomePage.getContentPane().add(btnBudget);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\Bunjamin\\Desktop\\images.png"));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Bunjamin\\Desktop\\images.png"));
		btnNewButton.setBounds(31, 80, 560, 270);
		frmHomePage.getContentPane().add(btnNewButton);
		
		JButton btnSignOut = new JButton("Exit");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}

			
		});
		btnSignOut.setBounds(535, 362, 90, 28);
		frmHomePage.getContentPane().add(btnSignOut);
	}

	
	

	

}
