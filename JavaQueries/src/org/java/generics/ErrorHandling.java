package org.java.generics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorHandling {

	public static void main(String args[]) {
		// String actMsg = "A selection from Umbrella Branch Licenses for ISR 4K
		// Routers, Umbrella WLAN, Umbrella Roaming Licenses, Umbrella Professional,
		// Umbrella Platform,Umbrella Insights or Umbrella Investigate, is required.
		// Please make a selection. (CE202217)";
		String actMsg = "A selection of Umbrella Professional, Umbrella Platform,Umbrella Insights or Umbrella Investigate, is required. Please make a selection. (CE202217)";

		String dyingTemplate = "A selection of Umbrella Professional, <D1> <D1> or Umbrella Investigate, is required. Please make a selection. (CE202217)";
		String deadFields = "D1: Product Name,D1: Product Name";
		ErrorHandling deff = new ErrorHandling();
		boolean bn = deff.compareErrors(actMsg, dyingTemplate, deadFields);
		System.out.println(bn);
	}

	public boolean compareErrors(String actualMsg, String dynamicTemplate, String dyingFields) {
		
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
			String[] strList1 = actualMsg.split(",");
			String[] strList2 = dynamicTemplate.split(",");

			List<String> list1 = Arrays.asList(strList1); // actual
			List<String> list2 = Arrays.asList(strList2); // d1 d2
			Map<String, String> dynamicValues = new HashMap<>();
			int k = 0;
			while (k < list2.size()) {
				if (list2.get(k).contains("<") && list2.get(k).contains(">")) {
					String keyStr = list2.get(k);
					int firstIndex = keyStr.indexOf("<");
					int lastIndex = keyStr.indexOf(">");
					String key = keyStr.substring(firstIndex, lastIndex + 1);
					if ((keyStr.charAt(keyStr.length() - 1) == '>') == false) {
						String restStr = keyStr.substring(lastIndex + 1);
						if (list1.get(k).contains(restStr)) {
							int index1 = list2.get(k).indexOf("<");
							int index2 = list1.get(k).indexOf(restStr);
							if (dynamicValues.keySet().contains(key)) {
								String temp = dynamicValues.get(key) + " || " + list1.get(k).substring(index1, index2);
								dynamicValues.put(key, temp);
							} else {
								dynamicValues.put(key, list1.get(k).substring(index1, index2));
							}
						}
					} else {
						if (dynamicValues.keySet().contains(key)) {
							String temp = dynamicValues.get(key) + " || " + list1.get(k);
							dynamicValues.put(key, temp);
						} else {
							dynamicValues.put(key, list1.get(k).substring(firstIndex));
						}
					}
				}
				k++;
			}

			System.out.println(dynamicValues);
			return dynamicValues;
		} catch (Exception e) {
			return null;
		}
	}

}
