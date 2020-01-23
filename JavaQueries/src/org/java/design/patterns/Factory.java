package org.java.design.patterns;

public class Factory {
    public static void main(String args[]) {
        ComputerFac pc = ComputerFactory.getComputer("PC", "8GB", "256GB SSD", "3.4 GHZ");
        ComputerFac server = ComputerFactory.getComputer("Server", "64GB", "3TB SSD", "3.4 GHZ");
        System.out.println("PC - " + pc);
        System.out.println("Server - " + server);
    }
}

abstract class ComputerFac {
    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override
    public String toString() {
        return "RAM = " + this.getRAM() + ", HDD = " + this.getHDD() + ", CPU = " + this.getCPU();
    }
}

class PCFac extends ComputerFac {

    private String ram;
    private String hdd;
    private String cpu;

    PCFac(String ram, String hdd, String cpu) {
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

class ServerFac extends ComputerFac {
    private String ram;
    private String hdd;
    private String cpu;

    ServerFac(String ram, String hdd, String cpu) {
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

class ComputerFactory {
    public static ComputerFac getComputer(String type, String ram, String hdd, String cpu) {
        if("PC".equals(type)) {
            return new PCFac(ram, hdd, cpu);
        } else if ("Server".equals(type)) {
            return new ServerFac(ram, hdd, cpu);
        }
        return null;
    }
}