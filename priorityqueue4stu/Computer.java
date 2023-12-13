//This class is almost the same as the one in Chapter 1.
//Some getters are added.

package priorityqueue4stu;

//Computer class implements the interface Comparable<Computer>
//   and compares two Computer objects based on their computing power.
public class Computer implements Comparable<Computer> {  
    
    //rewrite the compareTo(..) method in Comparable<Computer>
    @Override
    public int compareTo(Computer other) {
        double thisPower = computePower();
        double theOtherPower = other.computePower();

        if (thisPower == theOtherPower) {
            return 0;
        } else if (thisPower > theOtherPower) {
            return 1;
        } else {
            return -1;
        }
    }    
    
    private String brand;
    private double cpuSpeed;
    private double ramSize;

    public Computer(String brand, double cpuSpeed, double ramSize) {
        this.brand = brand;
        this.cpuSpeed = cpuSpeed;
        this.ramSize = ramSize;
    }

    public double computePower() {
        return cpuSpeed * ramSize;
    }

    public String getBrand() {
        return brand;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public double getRamSize() {
        return ramSize;
    }  
    
}
