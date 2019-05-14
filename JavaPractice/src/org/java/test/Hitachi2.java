package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hitachi2 {
	
	/* sample test case
	3
	6 3
	2 3 4 2 3 2
	8 3
	1 1 1 1 2 2 2 6
	7 1
	1 1 1 1 1 2 2
	*/

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<test; t++) {
			String nk[] = br.readLine().split(" ");
			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a[] = new int[n];
			int freq[] = new int[100001];
			for(int i=0; i<n; i++) {
				int m = Integer.parseInt(st.nextToken());
				a[i] = m;
				freq[m]++;
			}
			int maxP = maxPrime(freq);
			if(maxP <= k &&n%2==0 && n%maxP == 0) {
				System.out.println(maxP);
			} else if(n%2 == 1) {
				System.out.println(-1);
			} else{
				int d = getDividend(k);
				while(d > 0) {
					if(n%d == 0) {
						System.out.println(d);
						break;
					} else {
						d = getDividend(d--);
					}
				}
			}
		}
	}
	
	static int getDividend(int k) {
		boolean flag = false;
		while(k-- > 0) {
			flag = isPrime(k);
			if(flag) {
				break;
			}
		}
		return k;
	}
	
	static int maxPrime(int freq[]) {
		int max = 0;
		for(int i=0; i<freq.length; i++) {
			int number = freq[i];
			if(isPrime(number)) {
				if(max < number) {
					max = number;
				}
			}
		}
		return max;
	}
	
	static boolean isPrime(int n) {
        if (n <= 1) 
            return false; 
       
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
       
        return true; 
    } 
}
