package uss.xaiphyr;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        execProgram();
        System.exit(0);
    }

    public static JFrame initFrame(){
        JFrame mainFrame = new JFrame("User Input");
        mainFrame.setSize(500,500);
        return mainFrame;
    }

    public static void execProgram(){
        JFrame useFrame = initFrame();
        String input = JOptionPane.showInputDialog("Input: ");

        String inputChar = "", inputChar2 = "";

        for (int counter = input.length() - 1; counter >= 0; counter--){
            inputChar = inputChar+input.charAt(counter);
        }

        for (int counter = 0; counter < input.length(); counter++){
            inputChar2 = inputChar2+ " " +input.charAt(counter);
        }

        if(input.equals(inputChar)){
            JOptionPane.showMessageDialog(useFrame, "Output:\n" +inputChar2+ " \nYES");
        }else{
            JOptionPane.showMessageDialog(useFrame, "Output:\n" +inputChar2+ " \nNo");
        }
    }
}