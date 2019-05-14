package org.java.test;

public class PanagramMissingChar{

    public static void main(String []args){
       
       String str = "abcdefghijklmnopqrstuvwxyz";
       String str2 = "the quick jumps over the lazy dog";
       str2 = str2.replace(" ", "");
       
       StringBuilder missing = new StringBuilder();
       StringBuilder sb = new StringBuilder(str2);
       int i=0;
       int j=0;
       
       while(i<str.length()) {
           while(j<sb.length()) {
               if(str.charAt(i) == sb.charAt(j)) {
                   sb.deleteCharAt(j);
                   j--;
                   break;
               }
               j++;
           }
           if(j==sb.length()) {
        	   missing.append(str.charAt(i));
           }
           i++;
           j=0;
       }
      
       
       System.out.println(missing);
    }
}