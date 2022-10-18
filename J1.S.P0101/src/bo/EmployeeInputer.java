package bo;

import entity.Employee;
import util.Validations;

public class EmployeeInputer {

    public Employee employeeInformationInput() {
        Employee e = new Employee();
        e.setId(Validations.getInt("Enter employee ID: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE));
        e.setFirstName((Validations.getStringByRegex("Enter employee first name: ", "Please enter character only", "[a-zA-Z\s]+")));
        e.setLastName((Validations.getStringByRegex("Enter employee last name: ", "Please enter character only", "[a-zA-Z\s]+")));
        e.setPhone((Validations.getPhone(10, "Please enter employee phone: ")));
        e.setEmail((Validations.getEmail("Please enter employee email: ")));
        e.setAddress((Validations.getNonEmptyString("Please enter employee address: ")));
        e.setDob(Validations.getDob("Please enter employee day of birth (dd/mm/yyyy): ", "Please enter date match the form dd/mm/yyyy"));
        e.setSex(Validations.getSex("Please enter employee gender (Male or Female): "));
        e.setSalary(Validations.getInt("Please enter employee salary: ", "Please enter number only", "Please enter positive number", 0, Integer.MAX_VALUE));
        e.setAgency(Validations.getNonEmptyString("Please enter employee agency: "));
        return e;
    }
}
