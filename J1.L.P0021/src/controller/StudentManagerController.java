package controller;

import bo.StudentManager;
import bo.StudentsInputer;
import entity.Student;
import utils.ValidationAndNormalizingTextUtil;

import java.util.ArrayList;

public class StudentManagerController {
    private StudentsInputer studentsInputer;
    private Student student;
    private StudentManager studentManager;

    public StudentManagerController() {
        studentManager = new StudentManager();
        studentsInputer = new StudentsInputer();
    }

    private void addStudent() throws Exception {
        student = new Student();
        studentsInputer.inputInformation(student);
        try {
            Student isFound = studentManager.getStudentById(student.getId());
            if (isFound.getStudentName().equalsIgnoreCase(student.getStudentName()) && !isFound.getSemester().equalsIgnoreCase(student.getSemester())) {
                studentManager.addStudent(student);
                System.out.print("\nAdd a student Complete\n");
            } else {
                System.out.println("Invalid Student Information");
                addStudent();
            }
        } catch (Exception e) {
            studentManager.addStudent(student);
            System.out.print("\nAdd a student Complete\n");
        }
    }


    private void toString(String id, String name, String semester, ArrayList<Student.courseName> course) {
        for (int i = 0; i < course.size(); i++) {
            System.out.println(id + " " + name + " " + semester + " " + course.get(i));
        }
    }

    public void numberStudentAdd() throws Exception {
        int i = 0;
        while (true) {
            if (i < 2) {
                addStudent();
                i++;
            } else {
                String input = ValidationAndNormalizingTextUtil.pressYNtoContinue("Do you want to continue(Y/N)");
                if (input.toLowerCase().equals("y")) {
                    addStudent();
                } else break;
            }
        }
    }

    public void search(String input) {
        ArrayList<Student> foundList = studentManager.findAndSort(input);
        for (Student s : foundList) {
            toString(s.getId(), s.getStudentName(), s.getSemester(), s.getCourseName());
        }
    }

    public Student updateStudent(String id) throws Exception {
        student = studentManager.getStudentById(id);
        studentsInputer.inputInformation(student);
        return studentManager.updateStudent(id, student);
    }

    public Student removeStudent(String id) throws Exception {
        return studentManager.deleteStudent(id);
    }

    public void report() {
        ArrayList<Student> list = studentManager.getStudentList();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Student.courseName> listCourse1 = list.get(i).getCourseName();
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
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getId().equalsIgnoreCase(list.get(j).getId()) && !list.get(i).getSemester().equalsIgnoreCase(list.get(j).getSemester())) {
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
            System.out.println(list.get(i).getStudentName() + " | " + "Java" + "  | " + countJava);
            System.out.println(list.get(i).getStudentName() + " | " + "Net" + "   | " + countNet);
            System.out.println(list.get(i).getStudentName() + " | " + "Cpp" + "   | " + countCpp);
            list.remove(list.get(i));
        }
    }
}
