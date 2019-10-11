package org.java.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test_2 {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("test cases : ");
		int t = Integer.parseInt(br.readLine());
		for(int test=0; test<t; test++) {
			System.out.println("String : ");
			String s = br.readLine();
			char arr[] = s.toCharArray();
			boolean result = checkPalindrom(arr);
			if(result) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
	}
	
	static boolean checkPalindrom(char arr[]) {
		int j = arr.length-1;
		boolean result = false;
		
		int k=0;
		
		while(k<j+1) {
			for(int i=0; i<j; i++) {
				if(arr[i] != arr[j]) {
					//System.arraycopy(arr, 0, newArray, 0, arr.length);
					char newArray[] = Arrays.copyOf(arr, arr.length);
					//newArray = swap(newArray, i, j);
					char temp = newArray[i];
					newArray[i] = newArray[j];
					newArray[j] = temp;
					result = istPalindrom(newArray);
					if(result == true)
						return result;
				}
			}
			k++;
			j--;
		}
		return result;
	}
	
	/*static char[] swap(char a[], int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}*/
	
	public static boolean istPalindrom(char[] word){
	    int i1 = 0;
	    int i2 = word.length - 1;
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            return false;
	        }
	        ++i1;
	        --i2;
	    }
	    return true;
	}
}
