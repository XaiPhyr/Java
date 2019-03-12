package uss.xaiphyr;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String first = JOptionPane.showInputDialog("Number 1: "), second = JOptionPane.showInputDialog("Number 2: ");
        int firsVal = Integer.parseInt(first), secondVal = Integer.parseInt(second);

        XaiPhyr xOne = new XaiPhyr("sub"), xTwo = new XaiPhyr("mul"), xThree = new XaiPhyr("div"), xFour = new XaiPhyr("add");

        Thread yOne = new Thread(xOne), yTwo = new Thread(xTwo), yThree = new Thread(xThree), yFour = new Thread(xFour);

        xOne.valueNum(firsVal, secondVal);
        xTwo.valueNum(firsVal, secondVal);
        xThree.valueNum(firsVal, secondVal);
        xFour.valueNum(firsVal, secondVal);

        yOne.start();
        yTwo.start();
        yThree.start();
        yFour.start();
    }
}
