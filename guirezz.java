package test;

import java.io.*;
import javax.swing.*;

public class guirezz extends JFrame{
    public static void main(String[]args){
        new guirezz();
    }
    guirezz(){
        //back back
        setVisible(true);
        setSize(500,300);
        setTitle("Pig scaller");
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //frontback
        //txt
        JLabel pn = new JLabel("Pig number");
        JLabel weights = new JLabel("Weight (Kg):");

        //tf
        JTextField pnt = new JTextField();
        JTextField weigh = new JTextField();

        JTextField result = new JTextField("Total Cost");
        result.setEditable(false);
        result.setHorizontalAlignment(JTextField.CENTER);

        //buttons
        JButton conf = new JButton("Confirm");
        JButton del = new JButton("Clear");
        JButton close = new JButton("Close");



        //show
        //txt
        add(pn).setBounds(20,50,100,20);
        add(weights).setBounds(20,85,100,20);
        //tf
        add(pnt).setBounds(100,50,100,25);
        add(weigh).setBounds(100,85,100,25);
        add(result).setBounds(10,200,470,35);
        //button
        add(conf).setBounds(250,25,100,50);
        add(del).setBounds(250,82,100,50);
        add(close).setBounds(250,140,100,50);
        
        //action listener
        conf.addActionListener(e->{
            try {
                double count = Double.parseDouble(weigh.getText());
                double cal = count*187;

                result.setText(String.format(" %.0f₱",cal));
               
                try(FileWriter fw = new FileWriter("Price.txt",true);
                    PrintWriter pw = new PrintWriter(fw)){
                        pw.printf("Pig no.: %s \n",pnt.getText());
                        pw.printf("Weight: %s \n",weigh.getText());
                        pw.printf("Potential price: %s \n\n",result.getText());


                    }catch(IOException ioEx){
                        System.out.println("error");
                    }
                
            } catch (NumberFormatException f) {
                System.out.println("Error");
            }
        });

        del.addActionListener(e->{
            pnt.setText("");
            weigh.setText("");
            result.setText("Total Cost");

        });

        close.addActionListener(e->{
            System.exit(0);
        });


    }

}
