package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LazyPay1 {
	
	static List<String> list = new ArrayList<>(); 
	static int count = 0;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(br.readLine().trim());
		String s = br.readLine().replace(" ","");
		//printSubSeq(str, s);
		permutation("", str, s);
		System.out.println(count);
		br.close();
	}

	static void printSubSeqRec(String str, int len, int index, String curr, String s) {
		if (index == len) {
			return;
		}
		if(curr.equals(s)) {
			count++;
		}
		for (int i = index + 1; i < len; i++) {
			curr += str.charAt(i);
			printSubSeqRec(str, len, i, curr, s);

			curr = curr.substring(0, curr.length() - 1);
		}
	}

	static void printSubSeq(String str, String s) {
		int index = -1;
		String curr = "";

		printSubSeqRec(str, str.length(), index, curr, s);
	}
	
	static void permutation(String prefix, String str, String s) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), s);
	    }
	}
}
