package org.java.graph;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		// String actMsg = "A selection from Umbrella Branch Licenses for ISR 4K
		// Routers, Umbrella WLAN, Umbrella Roaming Licenses, Umbrella Professional,
		// Umbrella Platform,Umbrella Insights or Umbrella Investigate, is required.
		// Please make a selection. (CE202217)";
		String actMsg = "Umbrella Professional, Umbrella Platform,Umbrella Insights or Umbrella Investigate, is required. Please make a selection. (CE202217)";

		String dyingTemplate = "Umbrella Professional, <D1>,<D1> or Umbrella Investigate, is required. Please make a selection. (CE202217)";
		String deadFields = "D1: Product Name,D1: Product Name";
		Test deff = new Test();
		boolean bn = deff.compareErrors(actMsg, dyingTemplate, deadFields);
		System.out.println(bn);
	}

	public boolean compareErrors(String actualMsg, String dynamicTemplate, String dyingFields) {
		// TODO Auto-generated method stub
		String[] strList1 = actualMsg.split(" |\\,");
		String[] strList2 = dynamicTemplate.split(" |\\,");
		String[] strList3 = dyingFields.split(",");
		int wordsInActualMsgs = 0;
		Map<String, String> dynamicMap = getDynamicFeilds(actualMsg, dynamicTemplate, dyingFields);
		if (dynamicMap != null) {
			for (Map.Entry<String, String> m : dynamicMap.entrySet()) {
				int count = 0, i = 0;
				String deadFields = m.getValue().toString();
				String[] dynamicWords = deadFields.split(" |\\,");
				wordsInActualMsgs = wordsInActualMsgs + dynamicWords.length;
				while (i < dynamicWords.length) {
					if (dynamicWords[i].equals("||"))
						count++;
					i++;
				}
				wordsInActualMsgs = wordsInActualMsgs - count;
			}
			// if((strList1.length-wordsInActualMsgs)+1==strList2.length)
			// System.out.println("(strList1.length-wordsInActualMsgs)+dynamicMap.size()==strList2.length");
			// System.out.println("("+strList1.length+"-"+wordsInActualMsgs+")+"+strList3.length+"=="+strList2.length);
			if ((strList1.length - wordsInActualMsgs) + strList3.length == strList2.length)
				return true;
		}
		return false;
	}

	private Map<String, String> getDynamicFeilds(String actualMsg, String dynamicTemplate, String dynamicFields) {
		try {
			String[] strList1 = actualMsg.split(" |\\,");
			String[] strList2 = dynamicTemplate.split(" |\\,");
			String[] strList3 = dynamicFields.split(",");
			List<String> list3 = Arrays.asList(strList3);
			System.out.println(list3);					//unnecessary line
			List<String> list1 = Arrays.asList(strList1); // actual
			List<String> list2 = Arrays.asList(strList2); // d1 d2
			Map<String, String> dynamicValues = new HashMap<>();
			int j = 0;
			int k = 0;
			int count = 0;
			while (j < list1.size()) {

				while (k < list2.size()) {

					if (list2.get(k).contains("<") && list2.get(k).contains(">")) {
						// System.out.println(j + " === " + k);
						System.out.println(" " + list2.get(k));
						if (dynamicValues.keySet().contains(list2.get(k))) {
							String temp = dynamicValues.get(list2.get(k)) + " || " + list1.get(j);
							dynamicValues.put(list2.get(k), temp);
						} else {
							dynamicValues.put(list2.get(k), list1.get(j));

						}
						j++;
						k++;
						count++;
					}
					if (list2.get(k).equalsIgnoreCase(list1.get(j))) {
						System.out.println(j + " === " + k);
						j++;
						k++;
						count = 0;
					} else if (!list2.get(k).equalsIgnoreCase(list1.get(j))) {

						if (list2.get(k).contains("<") && list2.get(k).contains(">")) {
							count = 0;
							System.out.println(j + " === " + k);
							System.out.println(" " + list2.get(k));
							if (dynamicValues.keySet().contains(list2.get(k))) {
								String temp = dynamicValues.get(list2.get(k)) + " " + list1.get(j);
								dynamicValues.put(list2.get(k), temp);
							} else {
								dynamicValues.put(list2.get(k), list1.get(j));
							}
							j++;
							k++;
							count++;
						} else {
							System.out.println(j + " === " + k);
							String value = dynamicValues.get(list2.get(k - 1));
							value = value + " " + list1.get(j);
							dynamicValues.put(list2.get(k - 1), value);
							count++;
							j++;
						}
					}

				}
			}
			System.out.println(count);					//unnecessary line
			System.out.println(dynamicValues);
			return dynamicValues;
		} catch (Exception e) {
			return null;
		}
	}

}
