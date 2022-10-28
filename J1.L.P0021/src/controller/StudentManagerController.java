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
        return studentManager.addStudent(student);
    }

    public String findAndSort(String name) throws Exception {
        ArrayList<Student> foundList = studentManager.findAndSortByName(name);
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
        ArrayList<Student> list = studentManager.getListStudent();
        String ret = "";
        while (list.size() > 0) {
            ArrayList<Student.CourseName> listCourse1 = list.get(0).getCourseName();
            int countJava = 0;
            int countNet = 0;
            int countCpp = 0;
            countJava += countCourse(listCourse1, 1);
            countNet += countCourse(listCourse1, 2);
            countCpp += countCourse(listCourse1, 3);
            for (int j = 1; j < list.size(); j++) {
                // same id but different semester
                if (list.get(0).getId().equalsIgnoreCase(list.get(j).getId())) {
                    if (!list.get(0).getSemester().equalsIgnoreCase(list.get(j).getSemester())
                            || (list.get(0).getSemester().equalsIgnoreCase(list.get(j).getSemester())
                            && !list.get(0).getCourseName().equals(list.get(j).getCourseName()))) {
                        ArrayList<Student.CourseName> listCourse2 = list.get(j).getCourseName();
                        countJava += countCourse(listCourse2, 1);
                        countNet += countCourse(listCourse2, 2);
                        countCpp += countCourse(listCourse2, 3);
                    }
                    list.remove(list.get(j));
                }
            }
            ret += list.get(0).getStudentName() + " | " + "Java" + "  | " + countJava + "\n" + list.get(0).getStudentName() + " | " + "Net" + "   | " + countNet + "\n" + list.get(0).getStudentName() + " | " + "Cpp" + "   | " + countCpp + "\n";
            list.remove(list.get(0));
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
