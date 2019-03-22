package uss.xaiphyr;

import javax.swing.*;

public class newtonFormulation implements Runnable {
    JFrame f = new JFrame("Newton's Second Law");
    public int[] xMass, xAcceleration, xForce;
    public int value, elemMass, elemAcceleration;

    @Override
    public void run() {
        JOptionPane.showMessageDialog(f, "Newton's Second Law of Motion:\nF = ma\n\nF = Force\nm = Mass\na = Acceleration");
        newtonEquation();

        try {
            for (int counter = 0; counter < value; counter++){
                System.out.println(xMass[counter]+ " * " +xAcceleration[counter]+ " = " +xForce[counter]+ " N");
                //JOptionPane.showMessageDialog(f, xMass[counter]+ " * " +xAcceleration[counter]+ " = " +xForce[counter]+ " N");
                Thread.sleep(1000);
            }
        }catch (InterruptedException error){ }
        System.out.print("\nForces (N): ");
        totalForce(0);
        System.exit(0); }

    public void newtonEquation(){
        value = Integer.parseInt(JOptionPane.showInputDialog("Range of Values: "));

        xMass = new int[value];
        for (int counter = 0; counter < value; counter++){
            elemMass = Integer.parseInt(JOptionPane.showInputDialog("Input Mass: "));
            xMass[counter] = elemMass; }

        xAcceleration = new int[value];
        for (int counter = 0; counter < value; counter++){
            elemAcceleration = Integer.parseInt(JOptionPane.showInputDialog("Input Acceleration: "));
            xAcceleration[counter] = elemAcceleration; }

        xForce = new int[value];
        for (int counter = 0; counter < value; counter++)
            xForce[counter] = xMass[counter] * xAcceleration[counter];
    }

    public void totalForce(int counter){
        if (counter < value) {
            System.out.print(xForce[counter] + ", ");
            totalForce(counter + 1); }
    }
}