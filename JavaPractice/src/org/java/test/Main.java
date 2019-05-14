package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    /*
        You can declare the other variables or functions here
    */
    public static void process_data(String a, String b){
        /*
            Complete this function to check if the data is a music or not.
        */
        if(a.chars().allMatch( Character::isDigit )) {
			System.out.println("N");
		}else if(b.chars().allMatch( Character::isDigit )) {
		    if(b.charAt(0) == '0') {
		        System.out.println("N");
		    } else {
			    System.out.println("M");
		    }
		} else {
			System.out.println("N");
		}
    }

    public static void process_data(String a, String b, String c){
        /*
            Complete this function to check if the data is a video or not
        */
        if(b.chars().allMatch( Character::isDigit ) && c.chars().allMatch( Character::isDigit )) {
			if(b.charAt(0) == '0' || c.charAt(0) == '0') {
		        System.out.println("N");
		    } else {
			    System.out.println("V");
		    }
		} else {
			System.out.println("N");
		}
    }

    public static void main(String[] args) throws Exception {
        /*
            Read the input here. Now based on the count of words in each line of input, you need to call the process_data function
        */    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String a[] = br.readLine().split(" ");
			if(a.length == 2) {
			    process_data(a[0], a[1]);
			}
			if(a.length == 3) {
			    process_data(a[0], a[1], a[2]);
			}
		}
    }
}
