package test;

import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;


public class sirJudCode extends JFrame{

	static JTextField txtName,txtUPrice,txtQuantity,txtTotal;
	static DefaultTableModel model;

	sirJudCode(){

		JLabel lblName = new JLabel("Fullname");
		add(lblName).setBounds(30,50,100,10);

		txtName = new JTextField();
		add(txtName).setBounds(30,65,150,30);

		JLabel lblUPrice = new JLabel("Unit Price");
		add(lblUPrice).setBounds(30,100,100,10);

		txtUPrice = new JTextField();
		add(txtUPrice).setBounds(30,115,150,30);

		JLabel lblQuantity = new JLabel("Quantity");
		add(lblQuantity).setBounds(30,150,100,10);

		txtQuantity = new JTextField();
		add(txtQuantity).setBounds(30,165,150,30);

		JLabel lblTotal = new JLabel("Total");
		add(lblTotal).setBounds(30,200,100,10);

		txtTotal = new JTextField();
		add(txtTotal).setBounds(30,215,150,30);
		txtTotal.setEditable(false);

		JButton btnAdd = new JButton("Add");
		add(btnAdd).setBounds(30,250,70,30);

		JButton btnUpdate = new JButton("Update");
		add(btnUpdate).setBounds(30,285,70,30);

		JButton btnDelete = new JButton("Delete");
		add(btnDelete).setBounds(30,320,70,30);

		String columns[] = {"Fullname","UnitPrice", "Quantity", "Total"};
		model = new DefaultTableModel(columns, 0);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		add(scrollpane).setBounds(200,50,460,300);



		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					txtName.setText(model.getValueAt(row,0).toString());
					txtUPrice.setText(model.getValueAt(row, 1).toString());
					txtQuantity.setText(model.getValueAt(row, 2).toString());
					txtTotal.setText(model.getValueAt(row, 3).toString());
				}
			}

		});

		read();

		btnAdd.addActionListener(e->{

			try {
				FileWriter fw = new FileWriter("Billing.txt",true);
				String name = txtName.getText();
				double price = Double.parseDouble(txtUPrice.getText());
				int quantity = Integer.parseInt(txtQuantity.getText());
				double total = price*quantity;
				txtTotal.setText(String.valueOf(total));

				fw.write(name+"#"+price+"#"+quantity+"#"+total+"\n");
				fw.close();

				JOptionPane.showMessageDialog(null,"Record saved successfully!");

				read();


			} catch (IOException x) {
				System.err.println("System Error" + x);

			}
			clear();

		});

		btnDelete.addActionListener(e->{
			int selectedRow = table.getSelectedRow();

			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "Select a record to delete");
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete this record?","Confirm Delete", JOptionPane.YES_NO_OPTION);
			if(confirm != JOptionPane.YES_OPTION)return;

			ArrayList<String> lines = new ArrayList<>();
			try(BufferedReader br = new BufferedReader(new FileReader ("Billing.txt"))){
				String line;
				int rowIndex=0;
				while((line=br.readLine()) !=null) {
					if(rowIndex !=selectedRow) lines.add(line);
					rowIndex++;
				}

			}catch(IOException z) {
				System.err.println(z);
			}

			//ArrayList -> File
			try(BufferedWriter bw = new BufferedWriter (new FileWriter("Billing.txt"))){

				for(String record:lines) bw.write(record+"\n");

			}catch(IOException z) {
				System.err.println(z);
			}

			read();
			JOptionPane.showMessageDialog(null,"Deleted Successfully");
			clear();
		});
		
		
		btnUpdate.addActionListener(e->{
			int selectedRow = table.getSelectedRow();
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(null,"Select a record to Update");
				return;
			}
			//File -> ArrayList
			ArrayList<String> lines = new ArrayList<>();
			try(BufferedReader br = new BufferedReader(new FileReader("Billing.txt"))){
				String line;
				int rowIndex=0;
				while((line=br.readLine())!=null) {
					if(rowIndex == selectedRow) {
						double price = Double.parseDouble(txtUPrice.getText());
						int quantity = Integer.parseInt(txtQuantity.getText());
						double total = price*quantity;
						txtTotal.setText(String.valueOf(total));

						String updatedRecord = txtName.getText() + "#" + txtUPrice.getText() + "#" + txtQuantity.getText() + "#" + txtTotal.getText();
						
						lines.add(updatedRecord);
						
 					}else {
 						lines.add(line);
 					}
					rowIndex++;
				}
				
			}catch(IOException x) {
				System.out.println(x);
			}
			
			//ArrayList -> File
			try(BufferedWriter bw = new BufferedWriter (new FileWriter("Billing.txt"))){

				for(String record:lines) bw.write(record+"\n");

			}catch(IOException z) {
				System.err.println(z);
			}

			read();
			JOptionPane.showMessageDialog(null,"Updated Successfully");
			clear();		
		});


	



		//setUndecorated(true);
		//setResizable(false);
		setTitle("Billing System");
		//setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,500);
		setVisible(true);
	}


	public static void clear() {
		txtName.setText("");
		txtUPrice.setText("");
		txtQuantity.setText("");
		txtTotal.setText("");
	}

	public static void read() {
		model.setRowCount(0);

		try(BufferedReader br = new BufferedReader(new FileReader("Billing.txt"))){
			String line;
			while((line=br.readLine())!=null) {
				String row[] = line.split("#");
				model.addRow(row);
			}

		}catch(IOException e) {
			System.out.println(e);
		}

	}


	public static void main(String[]args) {
		new sirJudCode();
	}

}