
/**
 * Exercise 3: Implementing the Builder Pattern
 *
 * Scenario:
 * You are developing a system to create complex objects such as a Computer with multiple optional parts. Use the Builder Pattern to manage the construction process.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named BuilderPatternExample.
 * 2. Define a Product Class:
 *    - Create a class Computer with attributes like CPU, RAM, Storage, etc.
 * 3. Implement the Builder Class:
 *    - Create a static nested Builder class inside Computer with methods to set each attribute.
 *    - Provide a build() method in the Builder class that returns an instance of Computer.
 * 4. Implement the Builder Pattern:
 *    - Ensure that the Computer class has a private constructor that takes the Builder as a parameter.
 * 5. Test the Builder Implementation:
 *    - Create a test class to demonstrate the creation of different configurations of Computer using the Builder pattern.
 */

// Step 2: Define a Product Class
class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private String powerSupply;
    private String coolingSystem;

    // Step 4: Implement the Builder Pattern
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.powerSupply = builder.powerSupply;
        this.coolingSystem = builder.coolingSystem;
    }

    // Step 3: Implement the Builder Class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String powerSupply;
        private String coolingSystem;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder setCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage +
                ", GPU=" + GPU + ", powerSupply=" + powerSupply + ", coolingSystem=" + coolingSystem + "]";
    }
}

// Step 5: Test the Builder Implementation
public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setCoolingSystem("Liquid Cooling")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
/*Expected Output:
Computer [CPU=Intel Core i9, RAM=32GB, storage=1TB SSD, GPU=NVIDIA RTX 3080, powerSupply=750W, coolingSystem=Liquid Cooling]
Computer [CPU=Intel Core i5, RAM=16GB, storage=512GB SSD, GPU=null, powerSupply=null, coolingSystem=null]
*/