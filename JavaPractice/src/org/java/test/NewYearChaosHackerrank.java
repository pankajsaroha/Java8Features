package org.java.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class NewYearChaosHackerrank{

     public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String given[] = br.readLine().split(" ");
        int a[] = new int[given.length];
        for(int i=0; i<given.length; i++) {
            a[i] = Integer.parseInt(given[i]);
        }
        
        System.out.println(Arrays.toString(a));
        
        countSwap(a);
     }
     
     static void countSwap(int a[]) {
         int count = 0;
         boolean flag = false;
         
         for(int i=0; i<a.length; i++) {
             if(a[i]-(i+1) > 2) {
                 flag = true;
                 break;
             }
             for(int j=Math.max(0, a[i]-1-1); j<i; j++) {
                 System.out.println("value of j "+ i + " Value of a[j] " +a[j]);
                 if(a[j]>a[i]) {
                     count++;
                 }
             }
         }
         if(flag) {
             System.out.println("Too chaotic");
         }else {
             System.out.println(count);
         }
     }
     
     static int[] swap(int b[], int i, int j) {
         int temp = b[i];
         b[i] = b[j];
         b[j] = temp;
         return b;
     }
}