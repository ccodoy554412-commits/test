package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class guitesk extends JFrame{
	
	public static void main(String[] args) {
	new guitesk();	
	}
	guitesk(){
		setVisible(true);
		setSize(800,550);
		setTitle("Warehouse Iventory");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//first row
		JLabel name = new JLabel("Product SKU");
		add(name).setBounds(350,20,100,20);

		//product name
		JLabel producN = new JLabel("Product Name");
		add(producN).setBounds(20,70,100,20);
		JTextField prodtxt = new JTextField();
		add(prodtxt).setBounds(20,90,200,20);
		//price per unit
		JLabel ppu = new JLabel("Price per Unit");
		add(ppu).setBounds(20,120,100,20);
		JTextField pputx = new JTextField();
		add(pputx).setBounds(20,140,200,20);
		//quantity in stock
		JLabel qis = new JLabel("Quatity in Stock");
		add(qis).setBounds(20,170,200,20);
		JTextField qistxt = new JTextField();
		add(qistxt).setBounds(20,190,200,20);
		//supplier
		JLabel supp = new JLabel("Supplier Name");
		add(supp).setBounds(240,70,100,20);
		JTextField suptxt = new JTextField();
		add(suptxt).setBounds(240,90,200,20);
		//category
		JLabel cate = new JLabel("Category");
		add(cate).setBounds(240,120,100,20);
		String[] cat = {"Electronics","Groceries","Clothing","Furniture","Tools"};
		JComboBox<String> cated = new JComboBox<>(cat);
		add(cated).setBounds(240,140,200,20);
		//item status
		JLabel is = new JLabel("Item Status:");
		add(is).setBounds(240,170,100,20);

		JRadioButton ss = new JRadioButton("Standard Storage");
		JRadioButton cs = new JRadioButton("Cold Storage");
		ButtonGroup storage = new ButtonGroup();
		storage.add(ss);
		storage.add(cs);
		add(ss).setBounds(320,170,150,20);
		add(cs).setBounds(320,190,150,20);

		//buttons
		JButton add = new JButton("Add to Table");
		add(add).setBounds(520,70,150,50);
		JButton clear = new JButton("Clear");
		add(clear).setBounds(520,130,150,50);

		//jtable
		String[] colms = {"Name","Supplier Name","Category","Price","Quantity","Storage Type"};
		DefaultTableModel dtm = new DefaultTableModel(colms,0);
		JTable table = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp).setBounds(10,230,770,260);


		//action listener
		add.addActionListener(e->{
			Object[] row = {
				prodtxt.getText(),
				suptxt.getText(),
				cated.getSelectedItem(),
				pputx.getText(),
				qistxt.getText(),
				ss.isSelected() ? "Standard Storage":"Cold Storage"
			};
			dtm.addRow(row);
		});
	}
}
