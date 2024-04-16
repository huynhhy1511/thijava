//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();

        Experience employee1 = new Experience("huynh ngoc huy", "15-11-2005", "0905881525", "Huy@gmail.com", "Experience", 5, "Java");
        Fresher employee2 = new Fresher("Quang", "1-1-2005", "0905661525", "Quang@gmai.com", "Fresher", "1-6-2028", "Good", "VKU");
        Intern employee3 = new Intern("Thai", "2-2-2005", "0907715252", "Thai@gmail.com", "Intern", "Information technology", "Ki 2", "VKU ");

        employeeManagement.addEmployee(employee1);
        employeeManagement.addEmployee(employee2);
        employeeManagement.addEmployee(employee3);

        System.out.println("Employee Count: " + Employee.getEmployeeCount());
        
        List<Employee> employees = employeeManagement.getEmployees();
        for (Employee employee : employees) {
            employee.showInfo();
            System.out.println();
        }

        employeeManagement.removeEmployee(employee2);
        employeeManagement.removeEmployee(employee1);

        System.out.println("Employee list after remove");
        List<Employee> employees2 = employeeManagement.getEmployees();
        for (Employee employee : employees2) {
            employee.showInfo();
            System.out.println();
        }

        String filePath = "employees.txt";
        EmployeeFileIO fileIO = new EmployeeFileIO(filePath);
        fileIO.writeToFile(employees);

        List<Employee> employeesFromFile = fileIO.readFromFile();
        System.out.println("Employees read from file:");
        for (Employee employee : employeesFromFile) {
            employee.showInfo();
            System.out.println();
        }
    }
}