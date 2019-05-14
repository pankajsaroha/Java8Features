package org.java.stream;

import java.util.List;
import java.util.Objects;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class TempStudent {
    public String name;
    public int age;
    public Address address;
    public List<MobileNumber> mobileNumbers;
 
    public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
    }
}

class Student {
    private String name;
    private int age;
    private Address address;
    private List<MobileNumber> mobileNumbers;
    
    Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }
    
    public void setMobile(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }
    
    @Override
    public String toString() {
        return "name "+ this.name+", age "+this.age+", address " + this.address+", mobile numbers "+this.mobileNumbers+".";
    }
}

class Address {
    private String zipcode;
    
    public Address(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public String getZipcode() {
        return zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    @Override
    public String toString() {
        return zipcode;
    }
}

class MobileNumber {
    private String mobile;
    
    public MobileNumber(String mobile) {
        this.mobile = mobile;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Override
    public String toString() {
        return mobile;
    }
}

public class Streaming {
    public static void main(String args[]) {
        Student student1 = new Student("Pankaj", 24, new Address("1234"), Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
        
        Student student2 = new Student("Manish", 21, new Address("1235"), Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333")));
        
        Student student3 = new Student("Deepak", 24, new Address("1236"), Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
        
        Student student4 = new Student("Prince", 24, new Address("1236"), Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
        
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        
        //Student with exact name match
        students.stream().filter(student -> student.getName().equals("Pankaj")).forEach(System.out::println);
        
        Optional<Student> opt = students.stream().filter(student -> student.getName().equals("Manish")).findAny();
        System.out.println(opt.isPresent() ? opt.get() : "Not found");
        
        //Student having address 1235
        opt = students.stream().filter(student -> student.getAddress().getZipcode().equals("1235")).findFirst();
        System.out.println(opt.isPresent() ? opt.get() : "Not found");
        
        //Students having mobile number 3333
        List<Student> list = students.stream().filter(student -> student.getMobileNumbers().stream().anyMatch(x -> x.getMobile().equals("3333"))).collect(Collectors.toList());
        System.out.println(list);
        String result = list.stream().map(student -> student.getName()).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
        
        //Students having mobile number 1233 and 1234
        list = students.stream().filter(student -> student.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getMobile(), "1233") || Objects.equals(x.getMobile(), "1234"))).collect(Collectors.toList());
        result = list.stream().map(student -> student.getName()).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
        
        /*
         * Create List<Student> from List<TempStudent>
         */
        TempStudent tempStd1 = new TempStudent("Pankaj", 25, new Address("12341"), Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
        TempStudent tempStd2 = new TempStudent("Manish", 22, new Address("12352"), Arrays.asList(new MobileNumber("11112"), new MobileNumber("33332")));
        TempStudent tempStd3 = new TempStudent("Deepak", 26, new Address("12363"), Arrays.asList(new MobileNumber("33333"), new MobileNumber("44443")));
        
        List<TempStudent> tempStds = Arrays.asList(tempStd1, tempStd2, tempStd3);
        
        List<Student> stds = tempStds.stream().map(temp -> new Student(temp.name, temp.age, temp.address, temp.mobileNumbers)).collect(Collectors.toList());
        System.out.println(stds);
        
        /*
         * Convert List<Student to List<String>
         */
        
        List<String> listString = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(listString);
        
        /*
         * Change the case of List<String>
         */
        
        List<String> nameList = Arrays.asList("Pankaj", "Manish", "Deepak", "Vishu", "Prince");
        System.out.println(nameList.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));
        
        /*
         * Sort List<String>
         */
        System.out.println(nameList.stream().sorted().collect(Collectors.joining(", ")));
        
        /*
         * Conditionally applyting filter
         */
        
        boolean sortConditionFlag = true;
        
        Stream<Student> conditionalFilterResult = students.stream().filter(std -> std.getName().startsWith("P"));
        
        if(sortConditionFlag) {
        	conditionalFilterResult = conditionalFilterResult.sorted(Comparator.comparing(Student::getName));
        }
        
        System.out.println("Before Sorting...");
        students.forEach(s -> System.out.print(s.getName()+" "));
        
        List<Student> studs = conditionalFilterResult.collect(Collectors.toList());
        System.out.println("\nAfter Sorting...");
        studs.forEach(s -> System.out.print(s.getName()+" "));
    }
}
