package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nickname extends JFrame  implements ActionListener {
    private JButton button;
    private JTextField textField;
    private JLabel name;
    private JPanel panel;

    Nickname(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        name = new JLabel("Enter your nickname");
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setFont(new Font("Consolas", Font.PLAIN,18));


        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas", Font.PLAIN,35));
        textField.setBackground(new Color(200,120,24));
        textField.setForeground(new Color(160,105,60));

        button = new JButton("Start");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(name);
        panel.add(textField);
        panel.add(button);


       // this.add(panel, BorderLayout.CENTER);
        //this.add(button, BorderLayout.SOUTH);
        this.add(panel);
        this.pack();
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            textField.getText();
        }
    }
}

