package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
//import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EskoTest1 {

	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Main Equation : ");
		String mainEq = br.readLine();
		String mainEqArr[] = mainEq.trim().split(",");
		List<String> output = new ArrayList<String>();
		String unit1 = mainEqArr[0];
		int noOfUnits = mainEqArr.length;
		String equation[] = new String[noOfUnits];
		Set<String> units = new HashSet<String>();
		int b = 1;
		int min = 0;
		int lastIndex = -1;
		for(int i=0; i<noOfUnits-1; i++) {
			System.out.println("Equation : ");
			equation[i] = br.readLine();
			String equationArr[] = equation[i].trim().split(" ");
			units.add(equationArr[3]);
			if(units.contains(unit1)) {
				unit1 = equationArr[0];
			}
			if(Integer.parseInt(equationArr[2]) < min) {
				output.add(lastIndex, " = "+equationArr[2]+""+equationArr[3]);
				for(int j=lastIndex+1; j<output.size(); j++) {
					String str = new String(output.get(j));
					int val = Integer.parseInt(str.replaceAll("[\\D]", ""));
					int index = str.lastIndexOf(String.valueOf(val%10));
					output.set(j, " = "+Integer.parseInt(equationArr[2])*val+""+output.get(j).substring(index+1));
				}
				
			} else {
				b = b*(Integer.parseInt(equationArr[2]));
				output.add(" = "+b+""+equationArr[3]);
			}
			if(min < Integer.parseInt(equationArr[2])) {
				min = Integer.parseInt(equationArr[2]);
				lastIndex = lastIndex+1;
			};
		}
		System.out.println(output);
		String out = "1"+unit1;
		Iterator<String> itr = output.iterator();
		while(itr.hasNext()) {
			out = out+itr.next();
		}
		System.out.println(out);
		in.close();
	}
}
