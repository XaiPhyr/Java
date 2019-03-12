package uss.xaiphyr;

import java.util.Date;

public class XaiPhyr implements Runnable{
    private int delay = 1000;
    private double totalAdd = 0, totalSub = 0, totalMul = 0, totalDiv = 0;
    private double numOne, numTwo;

    public void valueNum(double firstNum, double secNum){
        numOne = firstNum;
        numTwo = secNum;
    }

    private String arithmetic;
    XaiPhyr(String operation){
        arithmetic = operation;
    }

    @Override
    public void run() {
        try {
            for (int counter = 0; counter < 10; counter++) {
                Date now = new Date();
                switch (arithmetic) {
                    case "sub":
                        totalSub = numOne - numTwo;
                        System.out.print("\nSubtracting..." + numOne + " and " + numTwo + " is " + totalSub);
                        break;
                    case "mul":
                        totalMul = numOne * numTwo;
                        System.out.print("\nMultiplying..." + numOne + " and " + numTwo + " is " + totalMul);
                        break;
                    case "div":
                        totalDiv = numOne / numTwo;
                        System.out.print("\nDividing..." + numOne + " and " + numTwo + " is " + totalDiv);
                        break;
                    case "add":
                        totalAdd = numOne + numTwo;
                        System.out.print("\nAdding..." + numOne + " and " + numTwo + " is " + totalAdd);
                        break;
                }
                Thread.sleep(delay);
            }
        }catch (InterruptedException error) {
            error.printStackTrace();
        }
    }
}