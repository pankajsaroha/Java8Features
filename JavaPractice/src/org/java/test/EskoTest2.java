package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EskoTest2 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Main Equation : ");
		String mainEq = br.readLine();
		String mainEqArr[] = mainEq.trim().split(",");
		List<String> output = new ArrayList<String>();
		int noOfUnits = mainEqArr.length;
		String equation[] = new String[noOfUnits];
		Map<String, String> map = new HashMap<String, String>(); 
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		for(int i=0; i<noOfUnits-1; i++) {
			System.out.println("Equation : ");
			equation[i] = br.readLine();
			String equationArr[] = equation[i].trim().split(" ");
			map.put(equationArr[0], equationArr[2]+equationArr[3]);
			list1.add(equationArr[0]);
			list2.add(equationArr[3]);
		}
		list1.removeAll(list2);
		String mainUnit = list1.get(0);
		output.add(" = "+map.get(mainUnit));
		String str = map.get(mainUnit);
		int val = Integer.parseInt(str.replaceAll("[\\D]", ""));
		int index = str.lastIndexOf(String.valueOf(val%10));
		String unit = str.substring(index+1);
		for(int i=0; i<noOfUnits-2; i++) {
			
			str = map.get(unit);
			val = val*Integer.parseInt(str.replaceAll("[\\D]", ""));
			index = str.lastIndexOf(String.valueOf(val%10));
			unit = str.substring(index+1);
			output.add(" = "+val+unit);
			
		}
		
		String out = "1"+mainUnit;
		Iterator<String> itr = output.iterator();
		while(itr.hasNext()) {
			out = out+itr.next();
		}
		System.out.println(out);
	}
}
