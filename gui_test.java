package test;

import javax.swing.*;

public class gui_test extends JFrame{
    public static void main(String[]args){
        new gui_test();
    }
    gui_test(){

        //front end of the gui

        JLabel text = new JLabel("newtext"); //show the text in the frame
        add(text).setBounds(50,25,150,25); //position of the text in the frame

        JTextField textf = new JTextField(); //input text 
        add(textf).setBounds(150,25,180,25);    

        JButton but = new JButton("BUTT"); //button to click
        add(but).setBounds(50,75,90,25);


        //backend for the gui
        setSize(500,300); //default size of the frame

        setTitle(""); //title bar text

        setLayout(null); //this will make us use setBounds for positioning the components

        setDefaultCloseOperation(EXIT_ON_CLOSE); //this close/stop the program when the x button is clicked

        setVisible(true); //to show the frame

        setLocationRelativeTo(null); //puts the screen in the middle of the screen
    }

}
