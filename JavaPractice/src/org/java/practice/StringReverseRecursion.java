package org.java.practice;

class StringReverseRecursion {
    public static void main(String args[] ) throws Exception {
    	StringReverseRecursion t = new StringReverseRecursion();
    	System.out.println(t.reverseUtil("hello"));
    }
    
    public String reverseUtil(String str) {
    	return reverse(str, str.length()-1);
    }
    
    /*public String reverse(String str) {
    	if(str.isEmpty()) {
    		System.out.println("line 12 - "+str);
    		return str;
    	}
    	System.out.println("Return - "+reverse(str.substring(1))+str.charAt(0) + ", str - "+str);
    	return "";
    }*/
    
    public String reverse(String str, int n) {
    	if(n<0) {
    		return "";
    	}
    	return str.charAt(n)+reverse(str.substring(0, n), n-1);
    }
}
