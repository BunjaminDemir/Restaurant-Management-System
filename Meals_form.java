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
import javax.swing.ImageIcon;
import Mng_sys.Control_Panel;

public class Meals_form {

    public static void main(String[] args){
        
        // create JFrame and JTable
        JFrame frmMeals = new JFrame();
        frmMeals.getContentPane().setBackground(new Color(51, 102, 102));
        frmMeals.setAlwaysOnTop(true);
        frmMeals.setResizable(false);
        frmMeals.setType(Type.UTILITY);
        frmMeals.setTitle("Meals");
        final JTable table = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"Id","Name","Price € ","Portion"};
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
        final JTextField textID = new JTextField();
        final JTextField textName = new JTextField();
        final JTextField textPrice = new JTextField();
        final JTextField textPortion = new JTextField();
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");     
        
        textID.setBounds(110, 215, 141, 25);
        textName.setBounds(110, 245, 141, 25);
        textPrice.setBounds(110, 275, 141, 25);
        textPortion.setBounds(110, 305, 141, 25);
        
        btnAdd.setBounds(338, 212, 100, 25);
        btnUpdate.setBounds(338, 246, 100, 25);
        btnDelete.setBounds(338, 283, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(6, 3, 801, 200);
        
        frmMeals.getContentPane().setLayout(null);
        
        frmMeals.getContentPane().add(pane);
        
        // add JTextFields to the jframe
        frmMeals.getContentPane().add(textID);
        frmMeals.getContentPane().add(textName);
        frmMeals.getContentPane().add(textPrice);
        frmMeals.getContentPane().add(textPortion);
    
        // add JButtons to the jframe
        frmMeals.getContentPane().add(btnAdd);
        frmMeals.getContentPane().add(btnDelete);
        frmMeals.getContentPane().add(btnUpdate);
        
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblId.setBounds(10, 220, 55, 16);
        frmMeals.getContentPane().add(lblId);
        
        JLabel lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblName.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblName.setBounds(10, 250, 55, 16);
        frmMeals.getContentPane().add(lblName);
        
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrice.setBounds(10, 280, 55, 16);
        frmMeals.getContentPane().add(lblPrice);
        
        JLabel lblPortion = new JLabel("Portion");
        lblPortion.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblPortion.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPortion.setBounds(10, 310, 55, 16);
        frmMeals.getContentPane().add(lblPortion);
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textPortion.setText(null);
        		textID.setText(null);
        		textName.setText(null);
        		textPrice.setText(null);
        	}
        });
        btnReset.setBounds(338, 319, 100, 25);
        frmMeals.getContentPane().add(btnReset);
        
        JButton btnExit = new JButton(" Exit");
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
        btnExit.setIcon(new ImageIcon("C:\\Users\\Bunjamin\\Desktop\\kapat.png"));
        btnExit.setBounds(684, 330, 100, 25);
        frmMeals.getContentPane().add(btnExit);
        
        JButton btnGoBack = new JButton("Go Back");
        btnGoBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new Control_Panel();
        		this.setVisible(true);
        		Control_Panel.main(null);
        	}

        	private void setVisible(boolean b) {
			
				
			}
        });
        btnGoBack.setBounds(571, 329, 90, 26);
        frmMeals.getContentPane().add(btnGoBack);
        
        // create an array of objects to set the row data
        final Object[] row = new Object[4];
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
             
                row[0] = textID.getText();
                row[1] = textName.getText();
                row[2] = textPrice.getText();
                row[3] = textPortion.getText();
                
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
                	JOptionPane.showMessageDialog(null,"Delete ERROR");
                }
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textID.setText(model.getValueAt(i, 0).toString());
            textName.setText(model.getValueAt(i, 1).toString());
            textPrice.setText(model.getValueAt(i, 2).toString());
            textPortion.setText(model.getValueAt(i, 3).toString());
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
                   model.setValueAt(textName.getText(), i, 1);
                   model.setValueAt(textPrice.getText(), i, 2);
                   model.setValueAt(textPortion.getText(), i, 3);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Delete ERROR");
                }
            }
        });
        
        frmMeals.setSize(813,390);
        frmMeals.setLocationRelativeTo(null);
        frmMeals.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMeals.setVisible(true);
        
    }
}
