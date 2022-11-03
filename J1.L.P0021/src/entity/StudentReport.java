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
        String FORMAT_REPORT = "%-20s | %-10s | %-10s \n";
        return String.format(FORMAT_REPORT, this.name, this.course, this.totalCourse);
    }
}
