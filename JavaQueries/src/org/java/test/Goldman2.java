package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Goldman2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int codersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> coders = new ArrayList<>();

        for (int i = 0; i < codersCount; i++) {
            int codersItem = Integer.parseInt(bufferedReader.readLine().trim());
            coders.add(codersItem);
        }

        int res = getCountOfPossibleTeams(coders);

        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
	}
	
	static int getCountOfPossibleTeams(List<Integer> coders) {
		
		return 0;
    }
}
