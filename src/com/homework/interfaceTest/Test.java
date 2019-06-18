package com.homework.interfaceTest;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Test {

	public static void main(String[] args) {
	    
	    // java8 lambda表达式函数式输出
	    //Timer timer = new Timer(5000, event -> {System.out.println("This is Timer");}) ;
	    Timer timer = new Timer(5000, System.out::println) ;
	    //Timer timer = new Timer(5000, event);
	    timer.start();
	    
	    JOptionPane.showMessageDialog(null, "Quit program?");
	    System.exit(0);
	}
}

