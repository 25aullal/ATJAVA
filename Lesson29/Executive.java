public class Executive extends Manager {
    private double shares;

    public Executive(String name, double salary, double bonus, double shares) {
        super(name, salary, bonus);
        this.shares = shares;
    }

    public double getShares() {
        return shares;
    }

    public void setShares(double shares) {
        this.shares = shares;
    }

    // note that I added a method to Employee.java
    public void printStats() {
        super.printStats();
        System.out.print("; Shares: " + shares);
    }

}