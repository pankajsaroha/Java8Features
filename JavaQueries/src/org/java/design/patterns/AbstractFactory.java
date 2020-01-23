package org.java.design.patterns;

public class AbstractFactory {
    public static void main(String[] args) {
        ComputerAbstractFactory pcf = new PCFactory("8GB", "256GB SSD", "3.4 GHZ");
        Computer pc = Computers.getComputer(pcf);
        Computer server = Computers.getComputer(new ServerFactory("16GB", "4TB SSD", "3.4 GHZ"));
        System.out.println("PC - " + pc);
        System.out.println("Server - " + server);
    }
}

abstract class Computer {
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString() {
        return "RAM = " + this.getRAM() + ", HDD = " + this.getHDD() + ", CPU = " + this.getCPU();
    }
}

class PC extends Computer {
    private String ram;
    private String hdd;
    private String cpu;

    PC(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}

class Server extends Computer {
    private String ram;
    private String hdd;
    private String cpu;

    Server(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}

interface ComputerAbstractFactory {
    Computer createComputer();
}

class PCFactory implements ComputerAbstractFactory {
    private String ram;
    private String hdd;
    private String cpu;

    PCFactory (String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new PC(ram, hdd, cpu);
    }
    
}

class ServerFactory implements ComputerAbstractFactory {
    private String ram;
    private String hdd;
    private String cpu;

    ServerFactory (String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram, hdd, cpu);
    }
}

class Computers {

    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}