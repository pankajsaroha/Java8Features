package org.java.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("String : ");
		String S = br.readLine();
		System.out.println("Test cases :");
		int result = 0;
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int k = Integer.parseInt(br.readLine());
			for(int j=0; j<S.length(); j++) {
				String sub = S.substring(j);
				if(sub.length() >= k) {
					for(int m=0; m<sub.length()-k+1; m++) {
						if(canFormPalindrome(S.substring(m, m+k))) {
							result = k;
							break;
						}else {
							result = -1;
						}
					}
				}
			}
			System.out.println(result);
		}
	}
	
	static int NO_OF_CHARS = 256;
	 
    static boolean canFormPalindrome(String str) {
     
    int count[] = new int[NO_OF_CHARS];
    Arrays.fill(count, 0);
    
    for (int i = 0; i < str.length(); i++)
    count[(int)(str.charAt(i))]++;


    int odd = 0;
    for (int i = 0; i < NO_OF_CHARS; i++) 
    {
    if ((count[i] & 1) == 1)
        odd++;
 
    if (odd > 1)
        return false;
    }
    
    return true;
}

}
