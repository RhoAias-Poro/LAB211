package controller;

import bo.StudentManager;
import bo.StudentsInputer;
import entity.Student;
import entity.StudentReport;
import utils.Validations;

import java.util.ArrayList;
import java.util.Map;

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
        throw new Exception("Can't add student");
    }

    public String findAndSortByName() throws Exception {
        String name = Validations.getStringByRegex("Please enter a name you want to search: ", "Please enter character only", "[a-zA-Z\s]");
        ArrayList<Student> foundList = studentManager.findAndSortByName(name);
        StringBuilder ret = new StringBuilder();
        for (Student s : foundList) {
            ret.append(s.toString());
        }
        return ret.toString();
    }

    public Student updateStudent() throws Exception {
        String id = Validations.getStringByRegex("Enter Student ID that you want to manipulate: ", "Please enter valid character", "[a-zA-Z0-9]+");
        student = studentsInputer.inputInformation();
        return studentManager.updateStudent(id, student);
    }

    public Student removeStudent() throws Exception {
        String id = Validations.getStringByRegex("Enter Student ID that you want to manipulate: ", "Please enter valid character", "[a-zA-Z0-9]+");
        return studentManager.deleteStudent(id);
    }

    public String report() throws Exception {
//        ArrayList<Student> list = studentManager.getListStudent();
//        StringBuilder ret = new StringBuilder();
//        while (list.size() > 0) {
//            ArrayList<Student.CourseName> listCourse1 = list.get(0).getCourseName();
//            int countJava = 0;
//            int countNet = 0;
//            int countCpp = 0;
//            countJava += countCourse(listCourse1, 1);
//            countNet += countCourse(listCourse1, 2);
//            countCpp += countCourse(listCourse1, 3);
//            for (int j = 1; j < list.size(); j++) {
//                // same id but different semester
//                if (list.get(0).getId().equalsIgnoreCase(list.get(j).getId())) {
//                    if (!list.get(0).getSemester().equalsIgnoreCase(list.get(j).getSemester())
//                            || (list.get(0).getSemester().equalsIgnoreCase(list.get(j).getSemester()) && !list.get(0).getCourseName().equals(list.get(j).getCourseName()))) {
//                        ArrayList<Student.CourseName> listCourse2 = list.get(j).getCourseName();
//                        countJava += countCourse(listCourse2, 1);
//                        countNet += countCourse(listCourse2, 2);
//                        countCpp += countCourse(listCourse2, 3);
//                    }
//                    list.remove(list.get(j));
//                }
//            }
//            ret.append(list.get(0).getStudentName()).append(" | ").append("Java").append("  | ").append(countJava).append("\n").append(list.get(0).getStudentName()).append(" | ").append("Net").append("   | ").append(countNet).append("\n").append(list.get(0).getStudentName()).append(" | ").append("Cpp").append("   | ").append(countCpp).append("\n");
//            list.remove(list.get(0));
//        }
        String ret = "";
        Map<String, StudentReport> m = studentManager.report();
        for (StudentReport sr : m.values()) {
            ret += sr;
        }
        return ret;
    }

    private int countCourse(ArrayList<Student.CourseName> list, int course) {
        if (list.contains(Student.CourseName.getTypeByInt(course))) {
            return 1;
        }
        return 0;
    }
}
