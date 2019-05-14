package org.java.test;

import java.util.ArrayList;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {
    	
    	ArrayList<Integer> l = new ArrayList<Integer>();
    	
        Integer i1 = 127;
 
        Integer i2 = 127;

        System.out.println(i1 == i2);
 
        Integer i3 = 128;
 
        Integer i4 = 128;

        System.out.println(i3 == i4);
    }
    
    private void display() {
    	System.out.println("Private Method");
    }
}