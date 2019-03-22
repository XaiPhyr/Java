package uss.xaiphyr;

public class Main {

    public static void main(String[] args) {
	// write your code here
        newtonFormulation formulation = new newtonFormulation();
        Thread t1 = new Thread(formulation);

        t1.start();
    }
}
