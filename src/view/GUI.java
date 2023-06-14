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

    private Fondo image;
    private Header headerProject;
    public static JPanel panel;

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

        setLayout(new BorderLayout());
        panel = new JPanel();

        headerProject = new Header("I Know That Word", Color.BLACK);
        add(headerProject, BorderLayout.NORTH);

        image  = new Fondo(new ImageIcon(getClass().getResource("/resources/imageotaku.jpg")).getImage());
        this.setContentPane(image);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Agregar el panel nicknamePanel directamente al panel principal
        Nickname nicknamePanel = new Nickname();
        panel.add(nicknamePanel);

        add(panel, BorderLayout.CENTER);


        pack();
        panel.setVisible(true);


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


}