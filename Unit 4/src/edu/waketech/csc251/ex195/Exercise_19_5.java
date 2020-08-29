package edu.waketech.csc251.ex195;
import java.util.Scanner;
public class Exercise_19_5 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 5 numbers: ");
		Integer[] list = new Integer[5];
		for(int i = 0; i < list.length; i++) {
			list[i] = input.nextInt();
		}
		
		System.out.println("Max Number: " + max(list));
	}

	public static <E extends Comparable<E>> E max(E[] list) {
		
		E max = list[0];
		for(int i = 0; i < list.length; i++) {
			if(list[i].compareTo(max) > 0) {
				max = list[i];
			}
		}
		return max;
	}
	
}