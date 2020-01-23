package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Goldman1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int inputSeqCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> inputSeq = new ArrayList<>();

        for (int i = 0; i < inputSeqCount; i++) {
            int inputSeqItem = Integer.parseInt(bufferedReader.readLine().trim());
            inputSeq.add(inputSeqItem);
        }

        int targetSum = Integer.parseInt(bufferedReader.readLine().trim());

        int res = countSubSequence(inputSeq, targetSum);

		/*
		 * bufferedWriter.write(String.valueOf(res)); bufferedWriter.newLine();
		 */
        System.out.println(String.valueOf(res));

        bufferedReader.close();
        //bufferedWriter.close();
	}
	
	static int countSubSequence(List<Integer> inputSeq, int targetSum) {
        List<Integer> sq = new ArrayList<>();
        int count = 0;
        if(inputSeq.size() == 1) {
            if(inputSeq.get(0) == targetSum) {
                return 1;
            }
        }
        int sum = 0;
        for(int num : inputSeq) {
            sum += num;
            sq.add(num);
            if(sum == targetSum) {
                count++;
                sum = 0;
                sq = new ArrayList<Integer>();
            } else if(sum > targetSum) {
                while((sum > targetSum) && !sq.isEmpty()) {
                    if((sum - sq.get(0)) == targetSum) {
                        count++;
                        sum = 0;
                        sq = new ArrayList<Integer>();
                    }
                    	sum = sum - sq.get(0);
                    	sq.remove(0);
                }
            }
        }
        return count;
    }
	

	/*
	 * sq.remove(0); sum = 0; } else if((sum - sq.get(0)) < targetSum) { sum = sum -
	 * sq.get(0); sq.remove(0); } else {
	 */

}
