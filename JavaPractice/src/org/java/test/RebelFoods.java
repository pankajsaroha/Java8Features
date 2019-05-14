package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RebelFoods {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		RebelFoods rf = new RebelFoods();
		System.out.println(solution(s1, s2, 1, 1));
		br.close();
	}
	
	static int lcs(String X, String Y, int m, int n) 
		{ 
			int L[][]=new int[m + 1][n + 1]; 
			for (int i = 0; i <= m; i++) 
			{ 
				for (int j = 0; j <= n; j++) 
				{ 
					if (i == 0 || j == 0) 
						L[i][j] = 0; 
		
					else if (X.charAt(i - 1) == Y.charAt(j - 1)) 
						L[i][j] = L[i - 1][j - 1] + 1; 
		
					else
						L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]); 
				} 
			} 
		
			return L[m][n]; 
		} 
		static int solution (String X, String Y, int costX, int costY) 
		{ 
			int m = X.length(); 
			int n = Y.length(); 
			int len_LCS; 
			len_LCS = lcs(X, Y, m, n); 
		
			return costX * (m - len_LCS) + 
				costY * (n - len_LCS); 
		} 
}
