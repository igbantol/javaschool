package quarter2.employee;

import java.util.Scanner;

class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public double calculateSalary() {
        // TODO 1: Return 0.0
        return 0.0;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.printf("Calculated Salary: %.2f%n",
                          calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        // TODO 2: Return the monthly salary
        return monthlySalary;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n===== EMPLOYEE INFORMATION =====");
        System.out.println("Name: " + name);
        System.out.println("Type: Full-Time Employee");
        System.out.printf("Monthly Salary: %.2f%n",
                          monthlySalary);
    }
}

class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,
                            double hoursWorked,
                            double hourlyRate) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        // TODO 3: Calculate hoursWorked * hourlyRate
        return hoursWorked * hourlyRate;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n===== EMPLOYEE INFORMATION =====");
        System.out.println("Name: " + name);
        System.out.println("Type: Part-Time Employee");
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.printf("Hourly Rate: %.2f%n", hourlyRate);
        System.out.printf("Calculated Salary: %.2f%n",
                          calculateSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = input.nextLine();

        System.out.print("Enter employee type (F/P): ");
        String type = input.nextLine().trim();

        // TODO 4: Declare an Employee reference variable.
        Employee employee = null;

        // TODO 5: If type is F, ask for monthly salary
        //         and create a FullTimeEmployee object.
        if (type.equalsIgnoreCase("F")) {
            System.out.print("Enter monthly salary: ");
            double monthlySalary = input.nextDouble();
            employee = new FullTimeEmployee(name, monthlySalary);
        }
        // TODO 6: If type is P, ask for hours worked
        //         and hourly rate, then create a
        //         PartTimeEmployee object.
        else if (type.equalsIgnoreCase("P")) {
            System.out.print("Enter hours worked: ");
            double hoursWorked = input.nextDouble();
            System.out.print("Enter hourly rate: ");
            double hourlyRate = input.nextDouble();
            employee = new PartTimeEmployee(name, hoursWorked, hourlyRate);
        }

        // TODO 7: Display the employee information.
        //         Handle invalid employee types.
        if (employee != null) {
            employee.displayInfo();
        } else {
            System.out.println("Invalid employee type! Please enter F or P.");
        }

        input.close();
    }
}
