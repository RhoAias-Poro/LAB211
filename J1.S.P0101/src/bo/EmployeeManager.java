package bo;

import entity.Employee;

import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> listEmployees;

    public EmployeeManager() {
        listEmployees = new ArrayList<Employee>();
    }

    public boolean addEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("Employee cannot be null");
        }
        int check = searchById(employee.getId());
        if (check == -1) {
            return listEmployees.add(employee);
        }
        throw new Exception("Duplicate employee information");
    }

    public int searchById(int id) throws Exception {
        int index = 0;
        for (Employee employee : listEmployees) {
            if (employee.getId() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public Employee updateEmployee(int id, Employee s) throws Exception {
        if (s == null) {
            throw new Exception("Employee cannot be null");
        }
        int index = searchById(id);
        if (index != -1) {
            return listEmployees.set(index, s);
        }
        throw new Exception("Employee doesn't exist to update");
    }

    public Employee deleteEmployee(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listEmployees.remove(index);
        }
        throw new Exception("Employee doesn't exist to delete");
    }

    public ArrayList<Employee> findEmployeeWithName(String name) {
        ArrayList<Employee> foundList = new ArrayList<Employee>();
        for (Employee employee : listEmployees) {
            if (employee.getFirstName().toLowerCase().contains(name.toLowerCase()) || employee.getLastName().toLowerCase().contains(name.toLowerCase())) {
                foundList.add(employee);
            }
        }
        return foundList;
    }

    public ArrayList<Employee> getListEmployees() {
        return listEmployees;
    }
}
