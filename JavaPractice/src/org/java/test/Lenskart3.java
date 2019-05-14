package org.java.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lenskart3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//String s[] = in.next().split("");
		String s = in.next();
		List<List<String>> list = new ArrayList<>();
        //findSubArrays(list, s, n);
		List<String> li = SubString(s, n); 
        //Collections.sort(list, new MyComparator());
		Collections.sort(li, new MyComparator());
        /*for(List<String> l : list) {
        	String str = String.join("", l);
        	int a = occurrence(str, '0');
        	int b = occurrence(str, '1');
        	if(a>b) {
        		System.out.println(str.length());
        		return;
        	}
        }*/
		for(String str : li) {
        	//String str = String.join("", l);
        	int a = occurrence(str, '0');
        	int b = occurrence(str, '1');
        	if(a>b) {
        		System.out.println(str.length());
        		return;
        	}
        }
		in.close();
	}
	
	public static int occurrence(String str, char c) {
		String s = str.replaceAll("[^"+c+"]", "");
		return s.length();
	}
	
	
	/*public static void findSubArrays(List<List<String>> list, String arr[], int n) {
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                List<String> list2 = new ArrayList<>();
                for(int k=i; k<=j; k++) {
                    list2.add(arr[k]);
                }
                list.add(list2);
            }
        }
    }*/
	
	public static List<String> SubString(String str, int n) 
    { 
		List<String> list = new ArrayList<>();
       for (int i = 0; i < n; i++)  
           for (int j = i+1; j <= n; j++) 
             
                list.add(str.substring(i, j)); 
       
       return list;
    }
	
	

}

class MyComparator implements java.util.Comparator<String> {

    public int compare(String s1, String s2) {

        return s2.length() - s1.length();
    }
}
