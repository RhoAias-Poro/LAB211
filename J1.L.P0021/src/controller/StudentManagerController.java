package controller;

import bo.StudentManager;
import bo.StudentsInputer;
import entity.Student;
import entity.StudentReport;
import utils.Validations;

import java.util.ArrayList;
import java.util.TreeMap;

public class StudentManagerController {
    private StudentsInputer studentsInputer;
    private Student student;
    private StudentManager studentManager;

    public StudentManagerController() {
        studentManager = new StudentManager();
        studentsInputer = new StudentsInputer();
    }

    public Student addStudent() throws Exception {
        student = studentsInputer.inputInformation();
        if (studentManager.addStudent(student)) {
            return student;
        }
        throw new Exception("Can't add student duo to duplicate information or add error");
    }

    public String findAndSortByName() {
        String name = Validations.getStringByRegex("Please enter a name you want to search: ", "Please enter character only", "[a-zA-Z\s]+");
        ArrayList<Student> foundList = studentManager.findAndSortByName(name);
        if (foundList.size() == 0) {
            return "Can't find student with this name";
        }
        StringBuilder ret = new StringBuilder();
        for (Student s : foundList) {
            ret.append(s.toString());
        }
        return ret.toString();
    }

    public Student updateStudent() throws Exception {
        student = studentsInputer.inputInformation();
        return studentManager.updateStudent(student);
    }

    public Student removeStudent() throws Exception {
        String id = Validations.getStringByRegex("Enter Student ID that you want to manipulate: ", "Please enter valid character", "[a-zA-Z0-9]+");
        return studentManager.deleteStudent(id);
    }

    public String report() {
        StringBuilder ret = new StringBuilder();
        TreeMap<String, StudentReport> m = studentManager.getReportList();
        if (m.size() == 0) {
            return "Can't find any students to report";
        }
        for (StudentReport sr : m.values()) {
            ret.append(sr);
        }
        return ret.toString();
    }
}
