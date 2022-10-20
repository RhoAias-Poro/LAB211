package controller;

import bo.EmployeeInputer;
import bo.EmployeeManager;
import entity.Employee;

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
        int check = manager.searchById(employee.getId());
        if (check == -1) {
            return manager.addEmployee(employee);
        }
        throw new Exception("Duplicate ID");
    }

    public Employee updateEmployee(int id) throws Exception {
        employee = manager.getEmployeeById(id);
        employee = inputer.employeeInformationInput();
        return manager.updateEmployee(id, employee);
    }

    public Employee deleteEmployee(int id) throws Exception {
        return manager.deleteEmployee(id);
    }

    public String findEmployee(String name) throws Exception {
        ArrayList<Employee> foundList = manager.findEmployeeWithName(name);
        return printList(foundList);
    }

    public String sortEmployee() throws Exception {
        ArrayList<Employee> employeeList = manager.returnEmployeeList();
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        return printList(employeeList);
    }

    private String printList(ArrayList<Employee> employeeList) {
        String ret = "";
        for (Employee emp : employeeList) {
            ret += manager.toString(emp);
        }
        return ret;
    }
}
