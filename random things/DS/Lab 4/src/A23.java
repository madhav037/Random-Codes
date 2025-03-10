import java.util.Scanner;

public class A23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int employeeId;
        String name;
        String designation;
        int salary;

        System.out.print("enter id : ");
        employeeId = sc.nextInt();
        System.out.print("enter name : ");
        name = sc.next();
        System.out.print("enter designation : ");
        designation = sc.next();
        System.out.print("enter salary : ");
        salary = sc.nextInt();

        Employee_details d = new Employee_details(employeeId,name,designation,salary);
        d.printDetails();
    }
}

class Employee_details {
    int employeeId;
    String name;
    String designation;
    int salary;

    Employee_details(int employeeId, String name, String designation, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public void printDetails() {
        System.out.println(employeeId);
        System.out.println(name);
        System.out.println(designation);
        System.out.println(salary);
    }
}
