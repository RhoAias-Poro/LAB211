package bo;

import entity.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager {
    private ArrayList<Student> listStudent;
    private Student student;

    public StudentManager() {
        listStudent = new ArrayList<Student>();
    }

    public boolean addStudent(Student s) throws Exception {
        if (s == null) {
            throw new Exception("Student cannot be null");
        }
        if (checkDuplicateCourseOnEachStudent(s.getCourseName())) {
            throw new Exception("Duplicate course in the student you enter");
        }
        student = getStudentById(s.getId());
        if (student == null || checkNonDuplicateStudentInformation(s, student)) {
            return listStudent.add(s);
        }
        throw new Exception("There has a student with this information");
    }

    private boolean checkDuplicateCourseOnEachStudent(ArrayList<Student.CourseName> listCourse) {
        for (int i = 0; i < listCourse.size(); i++) {
            for (int j = i + 1; j < listCourse.size(); j++) {
                if (listCourse.get(i).equals(listCourse.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDuplicateCourseOnTwoStudent(ArrayList<Student.CourseName> students1, ArrayList<Student.CourseName> students2) {
        for (Student.CourseName courseNameStu1 : students1) {
            for (Student.CourseName courseNameStu2 : students2) {
                if (courseNameStu1.equals(courseNameStu2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkNonDuplicateStudentInformation(Student studentAdd, Student studentCheck) {
        if (studentAdd.getStudentName().equalsIgnoreCase(studentCheck.getStudentName())) {
            if (!studentAdd.getSemester().equalsIgnoreCase(studentCheck.getSemester()) || (studentAdd.getSemester().equalsIgnoreCase(studentCheck.getSemester()) && !checkDuplicateCourseOnTwoStudent(studentAdd.getCourseName(), studentCheck.getCourseName()))) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getListStudent() throws Exception {
        if (listStudent.isEmpty()) {
            throw new Exception("The List of students is empty");
        }
        ArrayList<Student> clone = new ArrayList<Student>(listStudent.size());
        clone.addAll(listStudent);
        return clone;
    }

    private int searchById(String id) {
        int index = 0;
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public Student updateStudent(String id, Student s) throws Exception {
        if (s == null) {
            throw new Exception("Student cannot be null");
        }
        int index = searchById(id);
        if (index != -1) {
            return listStudent.set(index, s);
        }
        throw new Exception("Student not found");
    }

    public Student getStudentById(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listStudent.get(index);
        }
        return null;
    }

    public Student deleteStudent(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listStudent.remove(index);
        }
        throw new Exception("Student doesn't exist");
    }

    public ArrayList<Student> findAndSortByName(String name) throws Exception {
        ArrayList<Student> newList = new ArrayList<Student>();
        if (listStudent.isEmpty()) {
            throw new Exception("Student with name does not exist");
        }
        for (Student student : listStudent) {
            //check student have name contains input
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                newList.add(student);
            }
        }
        if (!newList.isEmpty()) {
            newList.sort(new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {

                    return s1.getStudentName().toLowerCase().compareTo(s2.getStudentName().toLowerCase());
                }
            });
        }
        return newList;
    }


//    public String toString(Student s) throws Exception {
//        if (s == null) {
//            throw new Exception("Student cannot be null");
//        }
//        StringBuilder ret = new StringBuilder();
//        for (int i = 0; i < s.getCourseName().size(); i++) {
//            ret.append(s.getId()).append(" | ").append(s.getStudentName()).append(" | ").append(s.getSemester()).append(" | ").append(s.getCourseName().get(i)).append("\n");
//        }
//        return ret.toString();
//    }
}
