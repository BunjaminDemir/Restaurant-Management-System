package Mng_sys;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class Drinks_form {

    public static void main(String[] args){
        
        // create JFrame and JTable
        JFrame frmDrinks = new JFrame();
        frmDrinks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmDrinks.setTitle("Drinks");
        frmDrinks.setType(Type.UTILITY);
        frmDrinks.setResizable(false);
        frmDrinks.getContentPane().setBackground(new Color(51, 102, 102));
        final JTable table = new JTable(); 
        
        
        Object[] columns = {"Id","Name","Price $ ","Size"};
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
       final JTextField textID = new JTextField();
       final JTextField textname = new JTextField();
       final JTextField textprice = new JTextField();
       final JTextField textsize = new JTextField();
        
        // create JButtons
        final JButton btnAdd = new JButton("Add");
        final JButton btnDelete = new JButton("Delete");
        final JButton btnUpdate = new JButton("Update");     
        
        textID.setBounds(102, 222, 100, 25);
        textname.setBounds(102, 252, 100, 25);
        textprice.setBounds(102, 282, 100, 25);
        textsize.setBounds(102, 312, 100, 25);
        
        btnAdd.setBounds(232, 222, 100, 25);
        btnUpdate.setBounds(232, 253, 100, 25);
        btnDelete.setBounds(232, 283, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frmDrinks.getContentPane().setLayout(null);
        
        frmDrinks.getContentPane().add(pane);
        
        // add JTextFields to the jframe
        frmDrinks.getContentPane().add(textID);
        frmDrinks.getContentPane().add(textname);
        frmDrinks.getContentPane().add(textprice);
        frmDrinks.getContentPane().add(textsize);
    
        // add JButtons to the jframe
        frmDrinks.getContentPane().add(btnAdd);
        frmDrinks.getContentPane().add(btnDelete);
        frmDrinks.getContentPane().add(btnUpdate);
        
        JLabel lblId = new JLabel("ID");
        lblId.setHorizontalAlignment(SwingConstants.TRAILING);
        lblId.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        lblId.setBounds(46, 227, 46, 14);
        frmDrinks.getContentPane().add(lblId);
        
        JLabel lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(SwingConstants.TRAILING);
        lblName.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        lblName.setBounds(46, 257, 46, 14);
        frmDrinks.getContentPane().add(lblName);
        
        JLabel lblPrice = new JLabel("Price $");
        lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
        lblPrice.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        lblPrice.setBounds(35, 287, 57, 14);
        frmDrinks.getContentPane().add(lblPrice);
        
        JLabel lblStatus = new JLabel("Size");
        lblStatus.setHorizontalAlignment(SwingConstants.TRAILING);
        lblStatus.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        lblStatus.setBounds(46, 317, 46, 14);
        frmDrinks.getContentPane().add(lblStatus);
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textID.setText(null);
        		textname.setText(null);
        		textprice.setText(null);
        		textsize.setText(null);
        	}
        });
        btnReset.setBounds(232, 320, 100, 25);
        frmDrinks.getContentPane().add(btnReset);
        
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(1);
        	}
        });
        btnExit.setBounds(480, 318, 90, 28);
        frmDrinks.getContentPane().add(btnExit);
        
        // create an array of objects to set the row data
        final Object[] row = new Object[4];
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
             
                row[0] = textID.getText();
                row[1] = textname.getText();
                row[2] = textprice.getText();
                row[3] = textsize.getText();
                
                // add row to the model
                model.addRow(row);
            }
        });
        
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

           
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                	JOptionPane.showMessageDialog(btnDelete, "Error!");
                }
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textID.setText(model.getValueAt(i, 0).toString());
            textname.setText(model.getValueAt(i, 1).toString());
            textprice.setText(model.getValueAt(i, 2).toString());
            textsize.setText(model.getValueAt(i, 3).toString());
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(textID.getText(), i, 0);
                   model.setValueAt(textname.getText(), i, 1);
                   model.setValueAt(textprice.getText(), i, 2);
                   model.setValueAt(textsize.getText(), i, 3);
                }
                else{
                    JOptionPane.showMessageDialog(btnUpdate, "Error!");
                }
            }
        });
        
        frmDrinks.setSize(885,400);
        frmDrinks.setLocationRelativeTo(null);
        frmDrinks.setVisible(true);
        
    }
}
