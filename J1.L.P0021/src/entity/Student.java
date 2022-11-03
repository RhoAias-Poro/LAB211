package entity;

import java.util.ArrayList;

public class Student {
    private String studentName;
    private String semester;
    private ArrayList<CourseName> course = new ArrayList<CourseName>();
    private String id;

    public Student() {

    }

    public Student(String id, String studentName, String semester, ArrayList<CourseName> course) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<CourseName> getCourseName() {
        return course;
    }

    public void setCourseName(CourseName course) {
        this.course.add(course);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(getId() + " | " + getStudentName() + " | " + getSemester());
        for (int i = 0; i < getCourseName().size(); i++) {
            ret.append(" | ").append(getCourseName().get(i));
        }
        return ret.toString().toString();
    }

    public enum CourseName {
        Java, Net, Cpp;

        public static CourseName getTypeByInt(int type) {
            return switch (type) {
                case 1 -> Java;
                case 2 -> Net;
                case 3 -> Cpp;
                default -> throw new AssertionError();
            };
        }
    }
}
