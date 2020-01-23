package org.java.design.patterns;

public class Builder {

    public static void main(String[] args) {
        Computer1 computer = new Computer1.ComputerBuilder("500 GB", "2 GB").setBluetoothEnabled(true).setGraphicsCardEnabled(true).build();
        System.out.println(computer);
    }
}

class Computer1 {
    private String hdd;
    private String ram;

    private boolean isBluetoothEnabled;
    private boolean isGraphicsCardEnabled;

    Computer1(ComputerBuilder builder) {
        this.hdd = builder.hdd;
        this.ram = builder.ram;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
    }

    public String toString() {
        return "HDD=" + this.hdd + ", RAM=" + this.ram + ", Graphics Card=" + this.isGraphicsCardEnabled
                + ", Bluetooth=" + this.isBluetoothEnabled;
    }

    static class ComputerBuilder {
        private String hdd;
        private String ram;

        private boolean isBluetoothEnabled;
        private boolean isGraphicsCardEnabled;

        ComputerBuilder(String hdd, String ram) {
            this.hdd = hdd;
            this.ram = ram;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        Computer1 build() {
            return new Computer1(this);
        }
    }

}