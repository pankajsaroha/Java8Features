package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Capillary1 {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine().trim());
		for (int t=0; t<testcases; t++) {
			String s = br.readLine();
			int q = Integer.parseInt(br.readLine().trim());
			String xpoints[] = br.readLine().split(" ");
			String ypoints[] = br.readLine().split(" ");
			int x[] = new int[q];
			int y[] = new int[q];
			int count = 0;
			for(int i=0; i<q; i++) {
				x[i] = Integer.parseInt(xpoints[i]);
				y[i] = Integer.parseInt(ypoints[i]);
				if(x[i] == 0 && y[i] == 0) {
					count++;
				} else {
					int len = Math.abs(x[i]) + Math.abs(y[i]);
					for (int j = 0; j <= s.length() - len; j++) {
						int xpoint = 0;
						int ypoint = 0;
					    String substr = s.substring(j, j + len);
					    if (substr.matches("[a-zA-Z]+")) {
					    		/*int u = (int) substr.chars().filter(n -> n == 'U').count();
					    		int d = (int) substr.chars().filter(n -> n == 'D').count();
					    		int l = (int) substr.chars().filter(n -> n == 'L').count();
					    		int r = (int) substr.chars().filter(n -> n == 'R').count();*/
					    	int u=0,d=0,l=0,r = 0;
					    	for(int k=0; k<substr.length();k++) {
					    		char c = substr.charAt(k);
					    		if(c == 'U') u++;
					    		if(c == 'D') d++;
					    		if(c == 'L') l++;
					    		if(c == 'R') r++;
					    	}
					    		xpoint = xpoint + (l-r);
					    	    ypoint = ypoint + (u-d);
					    	if(xpoint == x[i] && ypoint == y[i]) {
								count++;
								break;
							}
					    }
					}
				}
			}
			System.out.println(count);
			/*List<List<Character>> list = new ArrayList<>();
	        subString(list, s.toCharArray(), s.length());
	        printCount(list, q, x, y);*/
		}
		br.close();
	}
	
	/*static List<List<Character>> subString(List<List<Character>> list, char str[], int n) { 
        for (int len = 1; len <= n; len++) { 
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; 
                List<Character> clist = new ArrayList<>();
                for (int k = i; k <= j; k++) { 
                    System.out.print(str[k]); 
                    clist.add(str[k]);
                } 
                list.add(clist);
                System.out.println(); 
            } 
        } 
        System.out.println(list);
        return list;
    }*/
	
	static void subString(char str[], int n) { 
        for (int len = 1; len <= n; len++) { 
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; 
                List<Character> clist = new ArrayList<>();
                for (int k = i; k <= j; k++) { 
                    clist.add(str[k]);
                } 
                
            } 
        } 
    }
	
	public static void printCount(List<List<Character>> list,int q, int x[], int y[]) {
		int count = 0;
		for(int i=0; i<q; i++) {
			if(x[i] == 0 && y[i] == 0) {
				count++;
			} else {
				int len = Math.abs(x[i]) + Math.abs(y[i]);
				for(List<Character> clist : list) {
					int xpoint = 0;
					int ypoint = 0;
					if(clist.size() == len) {
						for(Character c : clist) {
							if(c == 'U') {
								ypoint++;
							} else if(c == 'D') {
								ypoint--;
							} else if(c == 'L') {
								xpoint--;
							} else {
								xpoint++;
							}
						}
						if(xpoint == x[i] && ypoint == y[i]) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}
