package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI {

    public JComponent lighterLabel;
    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];


    //player ui

    JPanel lifePanel;
    JLabel lifeLabel[] = new JLabel[6];
    JPanel inventoryPanel;
    public JLabel swordLabel, shieldLabel, corpusLabel;


    //game over ui
    public JLabel titleJLabel;
    public JButton restartButton;

    public UI(GameManager gm) {
        this.gm = gm;
        createMainField();
        createPlayerField();
        createGameoverField();
        generateScene();
        window.setVisible(true);
    }

    private void createPlayerField() {
        lifePanel = new JPanel();
        lifePanel.setBounds(50, 0, 250, 50);
        lifePanel.setBackground(Color.black);
        lifePanel.setLayout(new GridLayout(1, 5));
        window.add(lifePanel);

        ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("hart.png"));
        Image image = lifeIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image);

        int i = 0;
        while (i < 5) {
            lifeLabel[i] = new JLabel();
            lifeLabel[i].setIcon(lifeIcon);
            lifePanel.add(lifeLabel[i]);
            i++;
        }

        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(650, 0, 100, 50);
        inventoryPanel.setBackground(Color.blue);
        inventoryPanel.setLayout(new GridLayout(1, 3));
        window.add(inventoryPanel);


        //items
        swordLabel = new JLabel();
        ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("sword.png"));
        swordLabel.setIcon(swordIcon);
        inventoryPanel.add(swordLabel);
        shieldLabel = new JLabel();
        ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("sword.png"));
        shieldLabel.setIcon(shieldIcon);
        inventoryPanel.add(shieldLabel);
        corpusLabel = new JLabel();
        ImageIcon corpusIcon = new ImageIcon(getClass().getClassLoader().getResource("sword.png"));
        corpusLabel.setIcon(corpusIcon);
        inventoryPanel.add(corpusLabel);
        lighterLabel = new JLabel();
        ImageIcon lighterIcon = new ImageIcon(getClass().getClassLoader().getResource("lighter.png"));
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
        bgPanel[bgNum].setVisible(false);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFilename));
        bgLabel[bgNum].setIcon(bgIcon);

    }

    public void createObject(int bgNum, int objX, int objY, int objWidth, int objHight, String objFilename,
                             String choice1Name, String choice2Name, String choice3Name,
                             String choice1Command, String choice2Command, String choice3Command) {

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuItem[] = new JMenuItem[4];
        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(choice1Command);
        popupMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(choice2Command);
        popupMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(choice3Name);
        menuItem[3].addActionListener(gm.aHandler);
        menuItem[3].setActionCommand(choice3Command);
        popupMenu.add(menuItem[3]);

        JLabel objectLabal = new JLabel();
        objectLabal.setBounds(objX, objY, objWidth, objHight);
//check if object is in the right place
        //        objectLabal.setOpaque(true);
//        objectLabal.setBackground(Color.blue);

        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource(objFilename));
        objectLabal.setIcon(objIcon);

        objectLabal.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(objectLabal, e.getX(), e.getY());
                }
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });

        bgPanel[bgNum].add(objectLabal);


    }

    public void createArrowButton(int bgNumber, int x, int y, int width, int height, String arrowFileName, String command) {
        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));

        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.aHandler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        bgPanel[bgNumber].add(arrowButton);
    }

    public void createGameoverField() {
        titleJLabel = new JLabel();
        titleJLabel.setBounds(200, 150, 400, 200);
        titleJLabel.setBackground(Color.red);
        titleJLabel.setFont(new Font("Time New Roman", Font.PLAIN, 17));
        titleJLabel.setVisible(false);
        window.add(titleJLabel);

        restartButton = new JButton();
        restartButton.setBounds(340, 320, 120, 50);
        restartButton.setBorder(null);
        restartButton.setBackground(null);
        restartButton.setForeground(Color.white);
        restartButton.setFocusPainted(false);
        restartButton.addActionListener(gm.aHandler);
        restartButton.setActionCommand("restart");
        restartButton.setVisible(false);
        window.add(restartButton);
    }

    public void generateScene() {
        createBackground(1, "castle.jpg");
        createObject(1, 440, 140, 200, 200, "viking.png", "Look", "Talk", "Fight", "lookViking", "talkViking", "fightViking");
        createObject(1, 440, 40, 100, 100, "knight.jpg", "Look", "Talk", "Fight", "lookKnight", "talkKnight", "fightKnight");
        createObject(1, 140, 300, 500, 500, "house.png", "Look", "Talk", "Rest", "lookHut", "talkHut", "RestHut");
        createArrowButton(1, 0, 50, 50, 50, "leftArrow.png", "goScene2");
        bgPanel[1].add(bgLabel[1]);

        //scene 2
        createBackground(2, "castle2.jpg");
        createObject(2, 0, 100, 100, 300, "Blank_square.svg.png", "Look", "Talk", "Enter", "lookCave", "talkCave", "enterCave");
        createObject(2, 350, 250, 50, 50, "Blank_square.svg.png", "Look", "Talk", "Search", "lookRoot", "talkRoot", "searchRoot");
        createArrowButton(2, 650, 50, 50, 50, "rightArrow.png", "goScene1");
        bgPanel[2].add(bgLabel[2]);

        createBackground(3, "castle1.jpg");
        createArrowButton(3, 650, 50, 50, 50, "rightArrow.png", "goScene2");
        bgPanel[3].add(bgLabel[3]);
    }
}
