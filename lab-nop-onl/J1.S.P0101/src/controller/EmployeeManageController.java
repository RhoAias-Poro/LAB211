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

    public Employee addEmployee() {
        while (true) {
            employee = new Employee();
            inputer.employeeInformationInput(employee);
            int check = manager.searchById(employee.getId());
            if (check == -1) {
                manager.addEmployee(employee);
                break;
            } else {
                System.out.println("Duplicate ID value");
            }
        }
        return employee;
    }

    public Employee updateEmployee(int id) throws Exception {
        employee = manager.getEmployeeById(id);
        inputer.employeeInformationInput(employee);
        return manager.updateEmployee(id, employee);
    }

    public Employee deleteEmployee(int id) throws Exception {
        return manager.deleteEmployee(id);
    }

    public String findEmployee(String name) {
        ArrayList<Employee> foundList = manager.findEmployeeWithName(name);
        String ret = "";
        for (Employee emp : foundList) {
            ret += emp.getId() + " | " + emp.getFirstName() + " | " + emp.getLastName() + " | " + emp.getPhone() + " | " + emp.getEmail() + " | " + emp.getAddress() + " | " + emp.getDob() + " | " + emp.getSex() + " | " + emp.getSalary() + " | " + emp.getAgency() + "\n";
        }
        return ret;
    }

    public String sortEmployee() {
        ArrayList<Employee> employeeList = manager.returnEmployeeList();
        String ret = "";
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        for (Employee emp : employeeList) {
            ret += emp.getId() + " | " + emp.getFirstName() + " | " + emp.getLastName() + " | " + emp.getPhone() + " | " + emp.getEmail() + " | " + emp.getAddress() + " | " + emp.getDob() + " | " + emp.getSex() + " | " + emp.getSalary() + " | " + emp.getAgency() + "\n";
        }
        return ret;
    }
}
