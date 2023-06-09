package view;

import controller.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {
    private JLabel enterText;
    private FileManager nameUser;
    private Header headerProject;
    private JTextField nickName;
    private Escucha escucha;
    private JButton start;
    private int counter;

    /**
     * Constructor of GUI class
     */
    public GUI(){

        initGUI();
        //Default JFrame configuration
        this.setTitle("I Know That Word");
        this.setSize(400,400);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        counter = 0;
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        enterText = new JLabel("Enter a nickname");

        nameUser = new FileManager();
        escucha = new Escucha();
        //Set up JComponents
        headerProject = new Header("I Know That Word", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
        nickName = new JTextField();
        nickName.setBounds(50, 50, 200, 30);
        this.add(nickName);

        start = new JButton("Start");
        start.addActionListener(escucha);
        this.add(start, BorderLayout.SOUTH);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    private void CheckRecord () {
        if (nickName.getText().contains(" ") || nickName.getText().isEmpty() || nickName.getText() == null) {
            JOptionPane.showMessageDialog(null,"Debes ingresar un nombre","Usuario Inválido",JOptionPane.INFORMATION_MESSAGE);
            nickName.setText("");
        } else {
           // System.out.println("Ingreso al else");
            nameUser.readUsers(nickName.getText());
           //nameUser.writer(nickName.getText());

        }
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start){
            CheckRecord();
        }

        }
    }
}