package bo;

import entity.Employee;

import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> listEmployees;

    public EmployeeManager() {
        listEmployees = new ArrayList<Employee>();
    }

    public Employee addEmployee(Employee employee) throws Exception {
        if (employee == null) throw new Exception("Employee cannot be null");
        listEmployees.add(employee);
        return employee;
    }

    public int searchById(int id) throws Exception {
        if (id < 0) throw new Exception("ID cannot be negative");
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
        if (s == null) throw new Exception("Employee cannot be null");
        int index = searchById(id);
        if (index != -1) return listEmployees.set(index, s);
        throw new Exception("Employee not found");
    }

    public Employee getEmployeeById(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) return listEmployees.get(index);
        throw new Exception("ID not found");
    }

    public Employee deleteEmployee(int id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listEmployees.remove(index);
        }
        throw new Exception("Employee doesn't exist");
    }

    public ArrayList<Employee> findEmployeeWithName(String name) throws Exception {
        ArrayList<Employee> foundList = new ArrayList<Employee>();
        for (Employee employee : listEmployees) {
            if (employee.getFirstName().toLowerCase().contains(name.toLowerCase()) || employee.getLastName().toLowerCase().contains(name.toLowerCase())) {
                foundList.add(employee);
            }
        }
        if (foundList.isEmpty()) throw new Exception("The List employee with name does not exist");
        return foundList;
    }

    public ArrayList<Employee> returnEmployeeList() throws Exception {
        if (listEmployees.isEmpty()) throw new Exception("The List of students is empty");
        ArrayList<Employee> clone = new ArrayList<Employee>(listEmployees.size());
        for (Employee s : listEmployees) clone.add(s);
        return clone;
    }

    public String toString(Employee emp) throws Exception {
        if(emp == null) throw new Exception("Employee cannot be null");
        return (emp.getId() + " | " + emp.getFirstName() + " | " + emp.getLastName() + " | " + emp.getPhone() + " | " + emp.getEmail() + " | " + emp.getAddress() + " | " + emp.getDob() + " | " + emp.getSex() + " | " + emp.getSalary() + " | " + emp.getAgency() + "\n");
    }
}
