package entity;

public class StudentReport {
    private String code;
    private String name;
    private String course;
    private int count;

    public StudentReport(String code, String name, String course, int count) {
        this.code = code;
        this.name = name;
        this.course = course;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.course + " | " + this.count + "\n";
    }
}
