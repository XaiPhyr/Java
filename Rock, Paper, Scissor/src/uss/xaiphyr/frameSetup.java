package uss.xaiphyr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class frameSetup {

    private JFrame f, ff;
    private JLabel headerLabel, statusLabel, secHeaderLabel, secStatusLabel;
    private JPanel controlPanel, secControlPanel;
    private mathEquation math1;

    public void firstFrame(){

        f = new JFrame("");
        f.setTitle("First Frame");
        f.setSize(500,500);
        f.setLayout(new GridLayout(5,5));

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(250,250);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.exit(0);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        //frameButton();
        //textFrame();
        gameButton();

        f.add(headerLabel);
        f.add(statusLabel);
        f.add(controlPanel);
        f.setVisible(true);
    }


    public void secondFrame(){
        ff = new JFrame("");
        ff.setTitle("Second Frame");
        ff.setSize(500,500);
        ff.setLayout(new GridLayout(5,5));

        secHeaderLabel = new JLabel("", JLabel.CENTER);
        secStatusLabel = new JLabel("", JLabel.CENTER);
        secStatusLabel.setSize(250,250);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
                super.windowOpened(windowEvent);
                System.exit(0);
            }
        });

        secControlPanel = new JPanel();
        secControlPanel.setLayout(new FlowLayout());

        secFrameButton();

        ff.add(secHeaderLabel);
        ff.add(secStatusLabel);
        ff.add(secControlPanel);
        ff.setVisible(true);
    }

    public void frameButton(){
        JButton okButton = new JButton("OK");
        JButton mathButton = new JButton("Math Equations");
        JButton exitButton = new JButton("Exit");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(f, "OK");
            }
        });
        mathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.setVisible(false);
                secondFrame();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        //controlPanel.add(okButton);
        controlPanel.add(mathButton);
        //controlPanel.add(exitButton);
    }

    public void secFrameButton(){
        JButton addButton = new JButton("Addition");
        JButton subButton = new JButton("Subtraction");
        JButton mulButton = new JButton("Multiplication");
        JButton divButton = new JButton("Division");
        JButton exitButton = new JButton("Exit");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String one = JOptionPane.showInputDialog("Enter: ");
                String two = JOptionPane.showInputDialog("Enter 2: ");

                int total = math1.add(Integer.parseInt(one), Integer.parseInt(two));

                secStatusLabel.setText("Total: " +total);
            }
        });
        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String one = JOptionPane.showInputDialog("Enter: ");
                String two = JOptionPane.showInputDialog("Enter 2: ");

                int total = math1.sub(Integer.parseInt(one), Integer.parseInt(two));

                secStatusLabel.setText("Total: " +total);
            }
        });
        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String one = JOptionPane.showInputDialog("Enter: ");
                String two = JOptionPane.showInputDialog("Enter 2: ");

                int total = math1.mul(Integer.parseInt(one), Integer.parseInt(two));

                secStatusLabel.setText("Total: " +total);
            }
        });
        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String one = JOptionPane.showInputDialog("Enter: ");
                String two = JOptionPane.showInputDialog("Enter 2: ");

                int total = math1.div(Integer.parseInt(one), Integer.parseInt(two));

                secStatusLabel.setText("Total: " +total);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.setVisible(true);
                ff.setVisible(false);
            }
        });

        secControlPanel.add(addButton);
        secControlPanel.add(subButton);
        secControlPanel.add(mulButton);
        secControlPanel.add(divButton);
        secControlPanel.add(exitButton);
    }

    public void textFrame(){
        JTextField text = new JTextField(8);
        JPasswordField passText = new JPasswordField(8);

        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String data = text.getText();
                headerLabel.setText("Text is: " +data);

                if (data.equals("exit")){
                    System.exit(0);
                }
            }
        });
        passText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                char[] passData = passText.getPassword();
                statusLabel.setText("Password is: " + new String(passData));

                if (new String(passData).equals("exit")){
                    System.exit(0);
                }
            }
        });

        controlPanel.add(text);
        controlPanel.add(passText);
    }

    private int scoreBoard = 0, enemyScoreBoard = 0;
    private int pNum;
    public void gameButton(){
        String[] game = {"Rock", "Paper", "Scissor"};
        Random rand = new Random();


        JButton exitButton = new JButton("Exit");
        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorButton = new JButton("Scissor");

        headerLabel.setText("You: " +scoreBoard+ " Enemy: " +enemyScoreBoard);

        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pNum = rand.nextInt(3);

                if (pNum == 0){
                    statusLabel.setText("Tie: " +game[0]);
                }else if (pNum == 1){
                    statusLabel.setText("You Lose: " +game[1]);
                    enemyScoreBoard = enemyScoreBoard + 1;

                    headerLabel.setText("You: " +scoreBoard+ " Enemy: " +enemyScoreBoard);
                }else if (pNum == 2){
                    statusLabel.setText("You Win: " +game[2]);
                    scoreBoard = scoreBoard + 1;

                    headerLabel.setText("You: " +scoreBoard+ " Enemy: " +enemyScoreBoard);
                }
            }
        });
        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pNum = rand.nextInt(3);

                if (pNum == 0){
                    statusLabel.setText("You Win: " +game[0]);
                    scoreBoard = scoreBoard + 1;

                    headerLabel.setText("You: " +scoreBoard+ " Enemy: " +enemyScoreBoard);
                }else if (pNum == 1){
                    statusLabel.setText("Tie: " +game[1]);
                }else if (pNum == 2){
                    statusLabel.setText("You Lose: " +game[2]);
                    enemyScoreBoard = enemyScoreBoard + 1;

                    headerLabel.setText("You: " +scoreBoard+ " Enemy: " +enemyScoreBoard);
                }
            }
        });
        scissorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pNum = rand.nextInt(3);

                if (pNum == 0){
                    statusLabel.setText("You Lose: " +game[0]);
                    enemyScoreBoard = enemyScoreBoard + 1;

                    headerLabel.setText("You: " +scoreBoard+ " Enemy: " +enemyScoreBoard);
                }else if (pNum == 1){
                    statusLabel.setText("You Win: " +game[1]);
                    scoreBoard = scoreBoard + 1;

                    headerLabel.setText("You: " +scoreBoard+ " Enemy: " +enemyScoreBoard);
                }else if (pNum == 2){
                    statusLabel.setText("Tie: " +game[2]);
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        controlPanel.add(rockButton);
        controlPanel.add(paperButton);
        controlPanel.add(scissorButton);
        controlPanel.add(exitButton);
    }
}
