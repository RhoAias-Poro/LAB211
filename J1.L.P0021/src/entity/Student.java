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

    public enum CourseName {
        Java, Net, Cpp;

        public static CourseName getTypeByInt(int type) {
            switch (type) {
                case 1:
                    return Java;
                case 2:
                    return Net;
                case 3:
                    return Cpp;
                default:
                    throw new AssertionError();
            }
        }

        public int getIntType() {
            switch (this) {
                case Java:
                    return 1;
                case Net:
                    return 2;
                case Cpp:
                    return 3;
                default:
                    throw new AssertionError();
            }
        }
    }
}
