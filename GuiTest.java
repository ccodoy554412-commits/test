package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class GuiTest extends JFrame{

	public static void main(String[] args) {
		new GuiTest();
		/*
		what to add:
		1. get the name of the game
		2. redio buttons wheather i have spent anything on that specific game or not 
		3. drop box if its a gatcha or not
		4. how many hours have i spent on that game
		5. how much i have spent on that game
		6. ANOTHER "radio button or drop box" for the if i still play it or not
		 */
	}
	GuiTest(){
		//back
		setVisible(true);
		setSize(650,500);
		setTitle("");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//front
		JLabel title = new JLabel("Gatcha Tracker");
		add(title).setBounds(200,10,100,20);
		//get game name
		JLabel gname = new JLabel("Game name");
		add(gname).setBounds(20,40,100,20);
		JTextField gnametxt = new JTextField();
		add(gnametxt).setBounds(20,60,150,20);

		//gatcha or not
		JRadioButton gatcha = new JRadioButton("Gatcha");
		JRadioButton other = new JRadioButton("Not Gatcha");
		ButtonGroup bg = new ButtonGroup();
		bg.add(gatcha);
		bg.add(other);
		add(gatcha).setBounds(200,50,100,20);
		add(other).setBounds(200,70,100,20);

		//type of game
		JLabel gameT = new JLabel("Game Type");
		add(gameT).setBounds(20,80,100,20);
		String[] type = {"VN","RPG","PvP","Gatcha","Platformer","Educational","Frien Slop"};
		JComboBox<String> db = new JComboBox<>(type);
		add(db).setBounds(20,100,150,20);

		//hours spent
		JLabel dsp = new JLabel("Days Wasted");
		add(dsp).setBounds(20,120,100,20);
		JTextField dsptxt = new JTextField();
		add(dsptxt).setBounds(20,140,150,20);
		
		//spendings
		JLabel spent = new JLabel("Spendings");
		add(spent).setBounds(200,90,100,20);
		JTextField waste = new JTextField();
		add(waste).setBounds(200,110,150,20);

		//acivity
		JLabel status = new JLabel("Player status");
		add(status).setBounds(370,40,100,20);
		String[] stat = {"Active","Break","Droped"};
		JComboBox<String> statdb = new JComboBox<>(stat);
		add(statdb).setBounds(370,60,150,20);

		//buttons
		JButton add = new JButton("Add");
		add(add).setBounds(370,90,140,20);
		JButton updt = new JButton("Delete");
		add(updt).setBounds(370,135,140,20);
		JButton del = new JButton("Update");
		add(del).setBounds(370,115,140,20);

		//table
		String[] colms = {"Game name","Genre","game type","Days Played","Amount Spent","Player Status"};
		DefaultTableModel dtm = new DefaultTableModel(colms,0);
		JTable table = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp).setBounds(10,170,615,280);
	}

}
