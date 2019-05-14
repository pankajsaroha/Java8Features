package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WissenTest2 {

	public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        String a[] = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        findSubArrays(arr, n);
     }
     
     public static void findSubArrays(int arr[], int n) {
    	 int total = 0;
         List<Integer[]> list = new ArrayList<>();
         for(int i=0; i<n; i++) {
             for(int j=i; j<n; j++) {
                 int sumoutar = 0;
                 int suminar = 0;
                 int inlen = 0;
                 int outlen = 0;
                 Integer ar[] = new Integer[2];
                 ar[0] = i+1;
                 for(int k=0; k<i; k++) {
                	 sumoutar += arr[k];
                	 outlen++;
                 }
                 for(int k=i; k<=j; k++) {
                     suminar += arr[k];
                     inlen++;
                 }
                 ar[1] = j+1;
                 for(int k=j+1; k<n; k++) {
                	 sumoutar += arr[k];
                	 outlen++;
                 }
                 float avgin = 0;
                 if(inlen != 0) {
                	 avgin = ((float)suminar/inlen);
                 }
                 float avgout = 0;
                 if(outlen != 0){
                	 avgout = ((float)sumoutar/outlen);
                 }
                 if(avgin > avgout) {
                	 total++;
                	 list.add(ar);
                 }
             }
         }
         System.out.println(total);
         for(Integer[] a: list) {
        	 System.out.println(a[0]+" "+a[1]);
         }
     }

}
