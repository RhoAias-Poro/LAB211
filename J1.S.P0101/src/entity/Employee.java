package entity;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String dob;
    private String sex;
    private int salary;
    private String agency;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, String phone, String email, String address, String dob, String sex, int salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String toString() {
        String FORMAT_OUTPUT = "%-3d | %-10s | %-5s | %-10s | %-20s | %-20s | %-10s | %-6s | %-6d | %-10s \n";
        return String.format(FORMAT_OUTPUT, getId(), getFirstName(), getLastName(), getPhone(), getEmail(), getAddress(), getDob(), getSex(), getSalary(), getAgency());
    }

}
