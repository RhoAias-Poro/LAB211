package ui;

import controller.EmployeeManageController;
import entity.Employee;
import util.IntegerUtils;
import util.Validations;

public class Main {
    public static void main(String[] args) throws Exception {
        Employee employee = new Employee();
        EmployeeManageController controller = new EmployeeManageController();
        String menu = "Wellcome to the Employee Management System \n"
                + "1. Add employees\n"
                + "2. Update employees\n"
                + "3. Delete employees\n"
                + "4. Search employees\n"
                + "5. Sort employees by salary\n"
                + "6. Exit\n";
        int choice = 0, id = 0;
        do {
            System.out.println(menu);
            choice = IntegerUtils.getOption();
            switch (choice) {
                case 1:
                    employee = controller.addEmployee();
                    System.out.println("Add employee complete");
                    break;
                case 2:
                    id = Validations.getInt("Enter employee ID that you want to update: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE);
                    try {
                        employee = controller.updateEmployee(id);
                        System.out.println("Update employee complete");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    id = Validations.getInt("Enter employee ID that you want to delete: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE);
                    try {
                        employee = controller.deleteEmployee(id);
                        System.out.println("Delete employee complete");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    String name = Validations.getStringByRegex("Enter employee name that you want to find: ", "Please enter character only", "[a-zA-Z\s]+");
                    String result = controller.findEmployee(name);
                    System.out.println(result);
                    break;
                case 5:
                    System.out.println(controller.sortEmployee());
                    break;
                case 6:
                    choice = 6;
                    break;
            }
        } while (choice != 6);
    }
}
