package ui;

import controller.EmployeeManageController;
import entity.Employee;
import util.IntegerUtils;
import util.Validations;

public class Main {
    public static void main(String[] args) throws Exception {
        Employee employee = new Employee();
        EmployeeManageController controller = new EmployeeManageController();
        String menu = "Wellcome to the Employee Management System \n" + "1. Add employees\n" + "2. Update employees\n" + "3. Delete employees\n" + "4. Search employees\n" + "5. Sort employees by salary\n" + "6. Exit\n";
        int choice = 0, id = 0;
        do {
            System.out.println(menu);
            choice = IntegerUtils.getOption();
            try {
                switch (choice) {
                    case 1 -> {
                        employee = controller.addEmployee();
                        System.out.println("Add employee complete");
                    }
                    case 2 -> {
                        employee = controller.updateEmployee();
                        System.out.println("Update employee complete");
                    }
                    case 3 -> {
                        employee = controller.deleteEmployee();
                        System.out.println("Delete employee complete");
                    }
                    case 4 -> {
                        System.out.println(controller.findEmployeeByName());
                    }
                    case 5 -> System.out.println(controller.sortEmployeeBySalary());
                    default -> choice = 6;
                }
            } catch (Exception e) {
                Validations.throwError(e.getMessage());
            }
        } while (choice != 6);
    }
}
