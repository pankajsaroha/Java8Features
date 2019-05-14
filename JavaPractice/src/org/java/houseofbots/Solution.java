package org.java.houseofbots;

import java.util.Scanner;

public class Solution {

	public static void main(String []args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int arr[] = new int[n];
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
            
            if(arr[i] > max) {
                max = arr[i];
            }
            
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        
        System.out.println(min+" "+max);
        
        in.close();
     }
}
