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
		JTextField nem = new JTextField();
		JTextField pas = new JTextField();
		JButton ent = new JButton("Enter");

		add(ask).setBounds(160,10,100,25);
		add(nemes).setBounds(25,50,100,25);
		add(pass).setBounds(25,80,100,25);
		add(nem).setBounds(100,50,200,25);
		add(pas).setBounds(100,80,200,25);
		add(ent).setBounds(150,120,100,25);

	}
	
}