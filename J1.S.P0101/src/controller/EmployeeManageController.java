package controller;

import bo.EmployeeInputer;
import bo.EmployeeManager;
import entity.Employee;
import util.Validations;

import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeManageController {
    private Employee employee;
    private EmployeeManager manager;
    private EmployeeInputer inputer;

    public EmployeeManageController() {
        manager = new EmployeeManager();
        inputer = new EmployeeInputer();
    }

    public Employee addEmployee() throws Exception {
        employee = inputer.employeeInformationInput();
        if (manager.addEmployee(employee)) {
            return employee;
        }
        throw new Exception("Can't add employee");
    }

    public Employee updateEmployee() throws Exception {
        int id = Validations.getInt("Enter employee ID that you want to update: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE);
        employee = inputer.employeeInformationInput();
        return manager.updateEmployee(id, employee);
    }

    public Employee deleteEmployee() throws Exception {
        int id = Validations.getInt("Enter employee ID that you want to update: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE);
        return manager.deleteEmployee(id);
    }

    public String findEmployeeByName() {
        String name = Validations.getStringByRegex("Enter employee name that you want to find: ", "Please enter character only", "[a-zA-Z\s]+");
        ArrayList<Employee> foundList = manager.findEmployeeWithName(name);
        if (foundList.size() == 0) {
            return "Can't find employee with this name";
        }
        return getStringListEmployees(foundList);
    }

    public String sortEmployeeBySalary() {
        ArrayList<Employee> employeeList = manager.getListEmployees();
        if (employeeList.size() == 0) {
            return "You haven't entered any employee";
        }
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        return getStringListEmployees(employeeList);
    }

    private String getStringListEmployees(ArrayList<Employee> employeeList) {
        StringBuilder ret = new StringBuilder();
        for (Employee emp : employeeList) {
            ret.append(emp.toString());
        }
        return ret.toString();
    }
}
