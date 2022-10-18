package bo;

import entity.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager implements Comparator<Student> {
    private ArrayList<Student> listStudent;

    public StudentManager() {
        listStudent = new ArrayList<Student>();
    }

    public Student addStudent(Student s) throws Exception {
        if (s == null) throw new Exception("Student cannot be null");
        listStudent.add(s);
        return s;
    }

    public ArrayList<Student> getStudentList() {
        return listStudent;
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
        if (s == null) throw new Exception("Student cannot be null");
        int index = searchById(id);
        if (index != -1) return listStudent.set(index, s);
        throw new Exception("Student not found");
    }

    public Student getStudentById(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) return listStudent.get(index);
        throw new Exception("ID not found");
    }

    public Student deleteStudent(String id) throws Exception {
        int index = searchById(id);
        if (index != -1) {
            return listStudent.remove(index);
        }
        throw new Exception("Student doesn't exist");
    }

    public ArrayList<Student> findAndSort(String name) {
        ArrayList<Student> newList = new ArrayList<Student>();
        for (Student student : listStudent) {
            //check student have name contains input
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                newList.add(student);
            }
        }
        if (!listStudent.isEmpty() && !newList.isEmpty()) {
            newList.sort(new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {

                    return s1.getStudentName().toLowerCase().compareTo(s2.getStudentName().toLowerCase());
                }
            });
        }
        return newList;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }

    public String toString(Student s) {
        if(s == null) return "null";
        String ret = "";
        for (int i = 0; i < s.getCourseName().size(); i++) {
            ret += s.getId() + " | " + s.getStudentName() + " | " + s.getSemester() + " | " + s.getCourseName().get(i) + "\n";
        }
        return ret;
    }
}
