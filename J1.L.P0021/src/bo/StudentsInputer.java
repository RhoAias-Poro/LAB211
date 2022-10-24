package bo;

import entity.Student;
import utils.Validations;

public class StudentsInputer {

    String courseInfo = "Course Information: \n1. Java\n2. Net\n3. Cpp\n";

    public Student inputInformation() {
        Student s = new Student();
        int i = 0;
        s.setId(Validations.getStringByRegex("Enter Student ID: ", "Please enter valid character", "[a-zA-Z0-9]+"));
        s.setStudentName(Validations.getStringByRegex("Enter Name: ", "Please enter character only!", "[A-Za-z\s]+"));
        s.setSemester(Validations.getNonEmptyString("Enter Semester Name: "));
        while (true) {
            int courseID = Validations.getInt(courseInfo + "Enter Course ID: ", "Please enter number only", "Please enter courseID on the screen only", 1, 3);
            s.setCourseName(Student.CourseName.getTypeByInt(courseID));
            i++;
            if (s.getCourseName().size() == 3) {
                System.out.println("Full course can enter in one semester");
                break;
            }
            String input = Validations.pressYNtoContinue("Do you want to continue adding course(Y/N)?: ");
            if (input.toLowerCase().equals("n")) {
                break;
            }
        }
        return s;
    }

}
