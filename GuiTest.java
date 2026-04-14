package test;

import javax.swing.*;
public class GuiTest extends JFrame{

	public static void main(String[] args) {
		new GuiTest();
	}
	GuiTest(){
		//back
		setSize(350,300);
		setTitle("");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		//front
		
		JLabel txt = new JLabel("Please enter your name and password");
		JTextField nam = new JTextField("Name");
		JTextField pass = new JTextField("Password");
		JButton enter = new JButton("Enter");
		JButton cancel = new JButton("Cancel");


		add(txt).setBounds(25,50,250,25);
		add(nam).setBounds(25,75,250,25);
		add(pass).setBounds(25,100,250,25);
		add(enter).setBounds(25,130,90,25);
		add(cancel).setBounds(25,150,90,25);
	}

}
