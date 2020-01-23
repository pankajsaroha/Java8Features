package org.java.test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Run {

    // Complete the isValid function below.
    static String isValid(String s) {
        String result = "NO";
        int st[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i) - 'a';
            st[index]++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<26; i++) {
            if(st[i]!=0) {
                if(map.containsKey(st[i])) {
                    map.put(st[i], map.get(st[i])+1);
                } else {
                    map.put(st[i], 1);
                }
                map.put(st[i], 1);
            }
        }

        if(map.size() > 2) {
            result = "NO";
        } else {
            int arr[] = new int[2];
            int i=0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                arr[i] = entry.getValue();
                i++;
            }
            if(arr[0] == 1 || arr[1] == 1) {
                result = "YES";
            }
            if(Math.abs(arr[0]-arr[1]) > 1) {
                result = "NO";
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    }
}
