package Mng_sys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Budget_form{
	
	public static void main(String[] args) {
		
		JFrame frmBudget = new JFrame();
		frmBudget.getContentPane().setBackground(new Color(51,102,102));
		frmBudget.setAlwaysOnTop(true);
		frmBudget.setResizable(false);
		frmBudget.setType(Type.UTILITY);
		frmBudget.setTitle("Budget");
		final JTable table = new JTable();
		
		//Create a table modell and  setting Column Identifiers -Bunjamin Demir
		
		Object[] columns = {
				"Datum",
				"Amount of money entered"
				
		};
		
		final DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		
		
		//SET THE MODELL FOR THE TABLE 
		
		table.setModel(model);
		
	// WE MAKE CHANGE  ON JTABLE
		
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		Font font = new Font("",1,22);
		table.setFont(font);
		table.setRowHeight(30);
		
		
		//Create  JTEXTFIELDS
		
		final JTextField textdate = new JTextField();
		final JTextField textamount = new JTextField();
		
		//Create  JBUTTONS
		
		JButton btnAdd = new JButton("Add");
		JButton btnDelete = new JButton("Delete");
		JButton btnUpdate = new JButton("Update");
		
		textdate.setBounds(80, 215, 141, 25);
		textamount.setBounds(80, 293, 141, 25);
		
		
		btnAdd.setBounds(338, 212, 100, 25);
		btnDelete.setBounds(338, 246, 100, 25);
		btnUpdate.setBounds(338, 283, 100, 25);
		
		
		//Create JScrollPane;
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 801, 200);
		
		
		frmBudget.getContentPane().setLayout(null);
		
		frmBudget.getContentPane().add(pane);
		
		
		// add JTEXTFIELDS TO THE JFRAME
		
		frmBudget.getContentPane().add(textdate);
		frmBudget.getContentPane().add(textamount);
		
		
		
		// add JBUTTONS TO THE JFRAME
		
		frmBudget.getContentPane().add(btnAdd);
		frmBudget.getContentPane().add(btnDelete);
		frmBudget.getContentPane().add(btnUpdate);
		
		
		JLabel lblid = new JLabel("Date : ");
		lblid.setFont(new Font("SansSerif", Font.BOLD,13));
		lblid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblid.setBounds(142, 212, 135, 16);
		frmBudget.getContentPane().add(lblid);
		lblid.setFont(new Font("SansSerif", Font.BOLD,13));
		lblid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblid.setBounds(10, 220, 55, 16);
		lblid.setFont(new Font("SansSerif", Font.BOLD,13));
		lblid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblid.setBounds(10, 220, 55, 16);
		lblid.setFont(new Font("SansSerif", Font.BOLD,13));
		lblid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblid.setBounds(10, 220, 55, 16);
		
		
		JButton  btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				textdate.setText(null);
				textamount.setText(null);
				
			}
		});
		
		btnReset.setBounds(338,319,100,25);
		frmBudget.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnExit.setIcon(new ImageIcon("C:\\\\Users\\\\Bunjamin\\\\Desktop\\\\kapat.png"));
		btnExit.setBounds(535, 319, 100, 25);
		frmBudget.getContentPane().add(btnExit);
		
		JLabel lblname = new JLabel("Amount of money entered");
		lblname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblname.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblname.setBounds(56, 265, 165, 16);
		frmBudget.getContentPane().add(lblname);
		
		
		
		final Object[] row = new Object[2];
		
		btnAdd.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				
				row[0] = textdate.getText();
				row[1] = textamount.getText();
				model.addRow(row);
				
				
			}
			
	});
		
		btnDelete.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				 int i = table.getSelectedRow();
				 if (i >= 0) {
					 model.removeRow(i);
				 }
				 
				 else {
					 JOptionPane.showMessageDialog(frmBudget, "DELETE ERROR");
					 
				 }
			}
		});
		
		
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				
				
				textdate.setText(model.getValueAt(i, 0).toString());
				textamount.setText(model.getValueAt(i, 1).toString());
				
			}
			
		});
		
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				int i = table.getSelectedRow();
						
			if (i >= 0) {
				model.setValueAt(textdate.getText(),i,0);
				model.setValueAt(textamount.getText(), i, 1);
				
			}
			
			else {
				JOptionPane.showMessageDialog(frmBudget, "ERROR");
				
			}
			}
		});
		
		
		frmBudget.setSize(813,390);
		frmBudget.setLocationRelativeTo(null);
		frmBudget.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBudget.setVisible(true);
		

		
	}
}
