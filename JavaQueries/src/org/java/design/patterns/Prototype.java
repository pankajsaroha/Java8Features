package org.java.design.patterns;

import java.util.ArrayList;
import java.util.List;

public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emp = new Employees();
        emp.loadData();
        Employees emp1 = (Employees) emp.clone();
        Employees emp2 = (Employees) emp.clone();
        List<String> list = emp1.getEmpList();
        list.add("Nupur");
        List<String> list1 = emp2.getEmpList();
        list1.remove("Saideep");

        System.out.println("Emp : " + emp.getEmpList());
        System.out.println("Emp1 : " + list) ;
        System.out.println("Emp2 : " + list1) ;
    }
}

class Employees implements Cloneable {
    private List<String> empList;

    public Employees() {
        empList = new ArrayList<>();
    }

    public Employees(List<String> list) {
        this.empList = list;
    }

    public void loadData() {
        empList.add("Pankaj");
        empList.add("Anmol");
        empList.add("Saideep");
        empList.add("Divya");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> list = new ArrayList<>();
        for(String s : this.getEmpList()) {
            list.add(s);
        }
        return new Employees(list);
    }
}