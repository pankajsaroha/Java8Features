package org.java.test;

class A
{
    static int i = 1111;

    static
    {
        i = i-- - --i;
    }

    {
        i = i++ + ++i;
    }
}

class B extends A
{
    static
    {
        i = --i - i--;
    }

    {
        i = ++i + i++;
    }
}

public class Test2
{
    public static void main(String[] args)
    {
        B b = new B();

        System.out.println(b.i);
    }
}