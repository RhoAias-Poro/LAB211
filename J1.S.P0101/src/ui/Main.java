package ui;

import controller.EmployeeManageController;
import entity.Employee;
import util.IntegerUtils;
import util.Validations;

public class Main {
    public static void main(String[] args) {
        Employee employee;
        EmployeeManageController controller = new EmployeeManageController();
        String menu = """
                Welcome to the Employee Management System\s
                1. Add employees
                2. Update employees
                3. Delete employees
                4. Search employees
                5. Sort employees by salary
                6. Exit
                """;
        int choice;
        do {
            System.out.println(menu);
            choice = IntegerUtils.getOption();
            try {
                switch (choice) {
                    case 1 -> {
                        employee = controller.addEmployee();
                        System.out.println("Add employee complete: ");
                        System.out.println(employee);
                    }
                    case 2 -> {
                        employee = controller.updateEmployee();
                        System.out.println("Update employee complete. Employee before the update: ");
                        System.out.println(employee);
                    }
                    case 3 -> {
                        employee = controller.deleteEmployee();
                        System.out.println("Delete employee complete. Employee have been deleted: ");
                        System.out.println(employee);
                    }
                    case 4 -> System.out.println(controller.findEmployeeByName());
                    case 5 -> System.out.println(controller.sortEmployeeBySalary());
                    default -> choice = 6;
                }
            } catch (Exception e) {
                Validations.throwError(e.getMessage());
            }
        } while (choice != 6);
    }
}
