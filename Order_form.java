package Mng_sys;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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


public class Order_form{
	
	public static void main (String[]args) {
		JFrame frmOrder = new JFrame();
		frmOrder.setTitle("Order");
		frmOrder.setType(Type.UTILITY);
		frmOrder.setResizable(false);
		frmOrder.getContentPane().setBackground(new Color(51,102,102));
		final JTable table = new JTable();
		
		
		Object [] columns = {
				"Prod. ID ",
				"Total Value",
				"Status of Order"
		};
		final DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columns);
		
		table.setModel(model);
		
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		
		Font font = new Font("",1,22);
		table.setFont(font);
		table.setRowHeight(30);
		
		final JTextField textID = new JTextField();
		final JTextField texttotal = new JTextField();
		final JTextField textorder = new JTextField();
		
		
		final JButton btnAdd = new JButton("Add");
		final JButton btnDelete = new JButton("Delete");
		final JButton btnUpdate = new JButton("Update");
		
		
		
		textID.setBounds(234,223,100,25);
		texttotal.setBounds(234, 253, 100, 25);
		textorder.setBounds(234, 283, 100, 25);
				
		btnAdd.setBounds(364, 223, 100, 25);
		btnUpdate.setBounds(364, 268, 100, 25);
		btnDelete.setBounds(364, 313, 100, 25);
		
		
		JScrollPane pane = new JScrollPane(table);
		
		pane.setBounds(0, 0, 880, 200);
		
		frmOrder.getContentPane().setLayout(null);
		frmOrder.getContentPane().add(pane);
		
		frmOrder.getContentPane().add(textID);
		frmOrder.getContentPane().add(texttotal);
		frmOrder.getContentPane().add(textorder);
		
		
		
		
		frmOrder.getContentPane().add(btnAdd);
		frmOrder.getContentPane().add(btnUpdate);
		frmOrder.getContentPane().add(btnDelete);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblProductId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProductId.setBounds(69, 228, 155, 14);
		frmOrder.getContentPane().add(lblProductId);
		
		JLabel lblTotalValueprice = new JLabel("Total Value (Price)");
		lblTotalValueprice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalValueprice.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblTotalValueprice.setBounds(69, 258, 155, 14);
		frmOrder.getContentPane().add(lblTotalValueprice);
		
		JLabel lblOrderStatus = new JLabel("Order Status");
		lblOrderStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderStatus.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblOrderStatus.setBounds(69, 288, 155, 14);
		frmOrder.getContentPane().add(lblOrderStatus);
		
		JButton btnNewButton = new JButton("Reset Fields");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textID.setText(null);
				texttotal.setText(null);
				textorder.setText(null);
			}
		});
		btnNewButton.setBounds(364, 362, 100, 23);
		frmOrder.getContentPane().add(btnNewButton);
		
		
		
		
		
		
		final Object[] row = new Object [3];
		
		 btnAdd.addActionListener(new ActionListener(){

	            
	            public void actionPerformed(ActionEvent e) {
	             
	                row[0] = textID.getText();
	                row[1] = texttotal.getText();
	                row[2] = textorder.getText();
	                
	                
	                // add row to the model
	                model.addRow(row);
		
		btnDelete.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e ) {
				 
				 int i  = table.getSelectedRow();
				 if (i >= 0 ) {
					 model.removeRow(i);
				 }
				 else {
					 JOptionPane.showMessageDialog(btnDelete,"Error!");
				 }
			 }
		});
		table.addMouseListener(new MouseAdapter() {
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e ) {
				
				int i = table.getSelectedRow();
				if(i >= 0)
				{
					model.setValueAt(textID.getText(), i , 0);
					model.setValueAt(texttotal.getText(), i , 1);
					model.setValueAt(textorder.getText(), i , 2);
				}
				else {
					JOptionPane.showMessageDialog(btnUpdate, "Error");
				
				}
			}
		});
		
		frmOrder.setSize(900,425);
		frmOrder.setLocationRelativeTo(null);
		frmOrder.setVisible(true);
	}
});
	}
}
