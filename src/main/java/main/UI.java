package main;

import javax.swing.*;
import java.awt.*;

public class UI {

    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    public UI(GameManager gm) {
        this.gm = gm;
        createMainField();

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea("Sample");
        messageText.setBounds(50, 410, 700, 90);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.yellow);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Calibri", Font.PLAIN, 22));
        window.add(messageText);
    }

    public void createBackground(int bgNum, String bgFilename) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 700, 350);
        bgPanel[bgNum].setBackground(Color.pink);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[1]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFilename));
        bgLabel[bgNum].setIcon(bgIcon);

    }

    public void createObject(int bgNum, int objX, int objY, int objWidth, int objHight, String objFilename) {
        JLabel objectLabal = new JLabel();
        objectLabal.setBounds(objX, objY, objWidth, objHight);

        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource(objFilename));
        objectLabal.setIcon(objIcon);

        bgPanel[bgNum].add(objectLabal);
        bgPanel[bgNum].add(bgLabel[bgNum]);

    }

    public void generateScreen(){
        createBackground(1,"castle2.jpg");
        createObject(1,440,140,200,200,"viking.png");
    }
}
