package com.sample;

import java.util.Scanner;

public class SeleniumDemo {

	private static Scanner scan;

	public static void main(String[] args) {
		System.out.println("Inside the main method :");
		int multiplier=1;
		scan=new Scanner(System.in);
		int number=scan.nextInt();
		
		for(int i = number;i>0;i--){
			multiplier=multiplier*i;
		}
		System.out.println("Factorial of "+number+" is "+multiplier);
	}
}
