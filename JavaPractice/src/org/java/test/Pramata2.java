package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Pramata2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            long K = Long.parseLong(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            long[] A = new long[N];
            for(int i_A=0; i_A<arr_A.length; i_A++)
            {
            	A[i_A] = Long.parseLong(arr_A[i_A]);
            }

            long out_ = fun(A, K);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
	}
	
	static long fun(long[] arr, long k){
		long n = arr.length;
		
		long cnt1 = 0;
		long cnt2 = 0;
		long cnt3 = 0;
		for (int i = 0; i < n; i++) {
			
			long xor = 0;
			if(xor > k) {
				cnt3 += 1;
			} else if(xor == k) {
				cnt2 += 1;
			} else{
				cnt1 += 1;
			}
			for (int j = i; j < n; j++) {
				xor = 0;
				for(int h=i; h <= j; h++) {
					System.out.print(arr[h]+" ");
					xor = xor ^ arr[h];
				}
				System.out.println();
				if(xor > k) {
					cnt3 += 1;
				} else if(xor == k) {
					cnt2 += 1;
				} else{
					cnt1 += 1;
				}
			}
			
		}
		
		
		return (long) (((cnt1+cnt2)*(cnt1+cnt2))+((cnt2+cnt3)*(cnt2+cnt3))+((cnt3+cnt1)*(cnt3+cnt1)) - ((cnt1 * cnt1)+(cnt2 * cnt2) + (cnt3 * cnt3)))%1000000007;
    }
	

}
