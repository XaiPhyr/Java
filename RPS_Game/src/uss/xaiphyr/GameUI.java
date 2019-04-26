package uss.xaiphyr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI {

    private JFrame iFace = new JFrame("Game Interface");
    private JLabel header, round, score, score2;
    private JPanel controlPanel, gridPanel;
    private JButton R, P, S;
    private int num, urScore, opponent;

    public void bodyInterface(){
        iFace.setSize(500, 500);
        iFace.setTitle("ROCK - PAPER - SCISSOR");
        iFace.setLayout(new GridLayout(5,5));
        iFace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        header = new JLabel("ANSWER: ", JLabel.CENTER);
        round = new JLabel("ROUND: ", JLabel.CENTER);
        score = new JLabel("Opponent Score: 0", JLabel.CENTER);
        score2 = new JLabel("Your Score: 0", JLabel.CENTER);

        controlPanel = new JPanel(new GridBagLayout());
        gridPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbag = new GridBagConstraints();

        gameButton();

        gbag.insets = new Insets(10,10,10,10);
        gridPanel.add(score, gbag);
        gridPanel.add(score2, gbag);
        iFace.add(header);
        controlPanel.add(R);
        controlPanel.add(P);
        controlPanel.add(S);
        iFace.add(gridPanel);
        iFace.add(controlPanel);
        iFace.setVisible(true);
    }

    public void gameButton(){
        String[] guess = new String[]{"Rock", "Paper", "Scissor"};
        num = (int) (Math.random() * 3);

        R = new JButton("R");
        P = new JButton("P");
        S = new JButton("S");

        R.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                header.setText("ROCK");
                if (guess[num].equals("Rock")){
                    header.setText("TIE: ROCK == ROCK");
                    num = (int) (Math.random() * 3);
                }else if (guess[num].equals("Paper")){
                    header.setText("LOSE: ROCK < PAPER");
                    num = (int) (Math.random() * 3);
                    opponent = opponent + 1;
                    score.setText("Opponent Score: " +opponent);
                }else{
                    header.setText("WIN: ROCK > SCISSOR");
                    num = (int) (Math.random() * 3);
                    urScore = urScore + 1;
                    score2.setText("Your Score: " +urScore);
                }
            }
        });

        P.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                header.setText("PAPER");
                if (guess[num].equals("Rock")){
                    header.setText("WIN: PAPER > ROCK");
                    urScore = urScore + 1;
                    score2.setText("Your Score: " +urScore);
                    num = (int) (Math.random() * 3);
                }else if (guess[num].equals("Paper")){
                    header.setText("TIE: PAPER == PAPER");
                    num = (int) (Math.random() * 3);
                }else{
                    header.setText("LOSE: PAPER < SCISSOR");
                    num = (int) (Math.random() * 3);
                    opponent = opponent + 1;
                    score.setText("Opponent Score: " +opponent);
                }
            }
        });

        S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                header.setText("SCISSOR");
                if (guess[num].equals("Rock")){
                    header.setText("LOSE: SCISSOR < ROCK");
                    num = (int) (Math.random() * 3);
                    opponent = opponent + 1;
                    score.setText("Opponent Score: " +opponent);
                }else if (guess[num].equals("Paper")){
                    header.setText("WIN: SCISSOR > PAPER");
                    num = (int) (Math.random() * 3);
                    urScore = urScore + 1;
                    score2.setText("Your Score: " +urScore);
                }else{
                    header.setText("TIE: SCISSOR == SCISSOR");
                    num = (int) (Math.random() * 3);
                }
            }
        });
    }
}
