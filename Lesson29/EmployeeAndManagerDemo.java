public class EmployeeAndManagerDemo {

    public static void main(String[] args) {
        Employee mickey = new Employee("Mickey", 10000000.00);
        Manager minnie = new Manager("Minnie", 12000000.00, 2000000.00);
        mickey.printStats();
        System.out.println();
        minnie.printStats();
        System.out.println();
    }

}

// arraylist... for (Employee employee: employee) {
// } employee.displayInfo