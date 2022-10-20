package controller;

import bo.StudentManager;
import bo.StudentsInputer;
import entity.Student;

import java.util.ArrayList;

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
        try {
            Student isFound = studentManager.getStudentById(student.getId()); // throw exception if not found
            if (isFound.getStudentName().equalsIgnoreCase(student.getStudentName()) && !isFound.getSemester().equalsIgnoreCase(student.getSemester())) {
                throw new Exception();
            }
        } catch (Exception e) {
            return studentManager.addStudent(student);
        }
        throw new Exception("Duplicate student");
    }

    public String findAndSort(String input) throws Exception {
        ArrayList<Student> foundList = studentManager.findAndSort(input);
        String ret = "";
        for (Student s : foundList) {
            ret += studentManager.toString(s);
        }
        return ret;
    }

    public Student updateStudent(String id) throws Exception {
        student = studentManager.getStudentById(id);
        student = studentsInputer.inputInformation();
        return studentManager.updateStudent(id, student);
    }

    public Student removeStudent(String id) throws Exception {
        return studentManager.deleteStudent(id);
    }

    public String report() throws Exception {
        ArrayList<Student> list = studentManager.getStudentList();
        String ret = "";
        while (list.size() > 0) {
            ArrayList<Student.courseName> listCourse1 = list.get(0).getCourseName();
            int countJava = 0;
            int countNet = 0;
            int countCpp = 0;
            if (listCourse1.contains(Student.courseName.getTypeByInt(1))) {
                countJava += 1;
            }
            if (listCourse1.contains(Student.courseName.getTypeByInt(2))) {
                countNet += 1;
            }
            if (listCourse1.contains(Student.courseName.getTypeByInt(3))) {
                countCpp += 1;
            }
            for (int j = 1; j < list.size(); j++) {
                // same id but different semester
                if (list.get(0).getId().equalsIgnoreCase(list.get(j).getId()) && !list.get(0).getSemester().equalsIgnoreCase(list.get(j).getSemester())) {
                    ArrayList<Student.courseName> listCourse2 = list.get(j).getCourseName();
                    if (listCourse2.contains(Student.courseName.getTypeByInt(1))) {
                        countJava += 1;
                    }
                    if (listCourse2.contains(Student.courseName.getTypeByInt(2))) {
                        countNet += 1;
                    }
                    if (listCourse2.contains(Student.courseName.getTypeByInt(3))) {
                        countCpp += 1;
                    }
                }
                list.remove(list.get(j));
            }
            ret = list.get(0).getStudentName() + " | " + "Java" + "  | " + countJava + "\n" + list.get(0).getStudentName() + " | " + "Net" + "   | " + countNet + "\n" + list.get(0).getStudentName() + " | " + "Cpp" + "   | " + countCpp + "\n";
            list.remove(list.get(0));
        }
        return ret;
    }
}
