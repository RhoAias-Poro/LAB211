package entity;

public class StudentReport {
    private String code;
    private String name;
    private String course;
    private int totalCourse;

    public StudentReport(String code, String name, String course, int totalCourse) {
        this.code = code;
        this.name = name;
        this.course = course;
        this.totalCourse = totalCourse;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.course + " | " + this.totalCourse + "\n";
    }
}
