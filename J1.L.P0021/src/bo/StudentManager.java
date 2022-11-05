package bo;

import entity.Student;
import entity.Student.CourseName;
import entity.StudentReport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public class StudentManager {
    private ArrayList<Student> listStudent;

    public StudentManager() {
        listStudent = new ArrayList<>();
    }


    public boolean addStudent(Student studentAdd) throws Exception {
        if (studentAdd == null) {
            throw new Exception("Student cannot be null");
        }
        if (checkDuplicateCourseOnEachStudent(studentAdd.getCourseName())) {
            throw new Exception("Duplicate course in the student you enter");
        }
        Student studentFound = getStudentById(studentAdd.getId());
        if (studentFound == null || checkNonDuplicateStudentInformation(studentAdd, studentFound)) {
            return listStudent.add(studentAdd);
        }
        return mergedStudent(studentAdd, studentFound);
    }

    private boolean checkDuplicateCourseOnEachStudent(ArrayList<CourseName> listCourse) {
        for (int i = 0; i < listCourse.size(); i++) {
            for (int j = i + 1; j < listCourse.size(); j++) {
                if (listCourse.get(i).equals(listCourse.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDuplicateCourseOnTwoStudent(ArrayList<CourseName> studentAdd, ArrayList<CourseName> studentFound) {
        for (CourseName courseNameStu1 : studentAdd) {
            for (CourseName courseNameStu2 : studentFound) {
                if (courseNameStu1.equals(courseNameStu2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkNonDuplicateStudentInformation(Student studentAdd, Student studentFound) {
        //if not duplicate
        if (studentAdd.getStudentName().equalsIgnoreCase(studentFound.getStudentName())) {
            if (!studentAdd.getSemester().equalsIgnoreCase(studentFound.getSemester())) {
                return true;
            }
        }
        //else
        return false;
    }

    private boolean mergedStudent(Student studentAdd, Student studentFound) {
        if (studentFound.getCourseName().size() + studentAdd.getCourseName().size() > 3) {
            return false;
        }
        if (studentAdd.getStudentName().equalsIgnoreCase(studentFound.getStudentName())) {
            if ((studentAdd.getSemester().equalsIgnoreCase(studentFound.getSemester()) && !checkDuplicateCourseOnTwoStudent(studentAdd.getCourseName(), studentFound.getCourseName()))) {
                for (CourseName course : studentAdd.getCourseName()) {
                    studentFound.setCourseName(course);
                }
                return true;
            }
        }
        return false;
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

    public Student updateStudent(Student studentUpdate) throws Exception {
        if (studentUpdate == null) {
            throw new Exception("Student cannot be null");
        }
        // Validate student update data
        if (checkDuplicateCourseOnEachStudent(studentUpdate.getCourseName())) {
            throw new Exception("Duplicate course in the student you update");
        }
        Student studentFound = getStudentById(studentUpdate.getId());
        if (studentFound != null) {
            return listStudent.set(searchById(studentFound.getId()), studentUpdate);
        }
        throw new Exception("Update fail duo to Duplicate information or Student not found");
    }


    public Student getStudentById(String id) {
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
        throw new Exception("Student doesn't exist to delete");
    }

    public ArrayList<Student> findAndSortByName(String name) {
        ArrayList<Student> newList = new ArrayList<>();
        for (Student student : listStudent) {
            //check student have name contains input
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                newList.add(student);
            }
        }
        if (!newList.isEmpty()) {
            newList.sort(new Comparator<>() {
                @Override
                public int compare(Student s1, Student s2) {

                    return s1.getStudentName().toLowerCase().compareTo(s2.getStudentName().toLowerCase());
                }
            });
        }
        return newList;
    }

    public TreeMap<String, StudentReport> getReportList() {
        TreeMap<String, StudentReport> result = new TreeMap<>();
        for (Student student : listStudent) {
            ArrayList<CourseName> courseNames = student.getCourseName();
            for (CourseName course : courseNames) {
                String key = student.getId() + "|" + course;
                StudentReport report = result.get(key);
                if (report == null) {
                    report = new StudentReport(student.getId(), student.getStudentName(), course.toString(), 0);
                    result.put(key, report);
                }
                report.setTotalCourse(report.getTotalCourse() + 1);
            }
        }
        return result;
    }
}
