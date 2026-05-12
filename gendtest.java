
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class gendtest extends JFrame {

    gendtest(){
        setVisible(true);
        setTitle("title");
        setSize(700,400);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //name
        JLabel name = new JLabel("Name");
        JTextField nemetxt = new JTextField();
        add(name).setBounds(20,30,150,20);
        add(nemetxt).setBounds(20,50,150,20);

        //gender
        JLabel gen = new JLabel("Gender");
        JTextField gentxt = new JTextField();
        add(gen).setBounds(20,80,100,20);
        add(gentxt).setBounds(20,100,150,20);

        //age
        JLabel age = new JLabel("Age");
        JTextField agetxt = new JTextField();
        add(age).setBounds(20,120,100,20);
        add(agetxt).setBounds(20,140,150,20);

        //buttons
        JButton add = new JButton("Add");
        JButton updt = new JButton("Update");
        JButton del = new JButton("Delete");
        add(add).setBounds(20,180,150,20);
        add(updt).setBounds(20,200,150,20);
        add(del).setBounds(20,220,150,20);

        //table
        String[] colms = {"Name","Age","Gender"};
        DefaultTableModel dtm = new DefaultTableModel(colms,0);
        JTable table = new JTable(dtm);
        JScrollPane sp = new JScrollPane(table);
        add(sp).setBounds(200,20,480,330);

        //mouse listener
        table.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e){

           } 
        });

        add.addActionListener(e->{

            Object[] rows = {
                

            };

        });
    }

    public static void main(String[] args) {
       new gendtest(); 
    }
}
