package test;

import javax.swing.*;
public class guiTes extends JFrame{
	public static void main(String[] args) {
		new guiTes();
		
		
	}
	guiTes(){
		//back
		setSize(400,300);
		setTitle("title");
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//front
		JLabel ask = new JLabel("Set new title");
		JLabel nemes = new JLabel("Name");
		JLabel pass = new JLabel("password"); 
		//text
		JTextField nem = new JTextField();
		JTextField pas = new JTextField();

		JTextField res = new JTextField("Result");
		res.setEditable(false);
		res.setHorizontalAlignment(JTextField.CENTER);

		//button
		JButton ent = new JButton("Enter");
		JButton cle = new JButton("Clear");
		JButton canc = new JButton("Cancel");

		add(ask).setBounds(160,10,100,25);
		add(nemes).setBounds(25,50,100,25);
		add(pass).setBounds(25,80,100,25);
		//txtf
		add(nem).setBounds(100,50,200,25);
		add(pas).setBounds(100,80,200,25);
		add(res).setBounds(25,150,310,25);
		//button
		add(ent).setBounds(25,120,100,25);
		add(cle).setBounds(130,120,100,25);
		add(canc).setBounds(235,120,100,25);

		//listener
		ent.addActionListener(e->{

		});
		cle.addActionListener(e->{

			nem.setText("");
			pas.setText("");
			res.setText("CLEARED");

		});

		canc.addActionListener(e->{
			System.exit(0);
		});



	}
}