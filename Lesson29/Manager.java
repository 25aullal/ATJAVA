public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getAnnualIncome() {
        double totalSalary = getSalary() + bonus;
        return totalSalary;
    }

    // note that I added a method to Employee.java
    public void printStats() {
        super.printStats();
        System.out.print("; Bonus: " + bonus);
    }

}