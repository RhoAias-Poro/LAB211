package bo;

import entity.Student;
import utils.ValidationAndNormalizingTextUtil;

public class StudentsInputer {

    String courseInfo = "Course Information: \n1. Java\n2. Net\n3. Cpp\n";

    public void inputInformation(Student s) {
        s.setId(ValidationAndNormalizingTextUtil.getStringByRegex("Enter Student ID: ", "Please enter valid character", "[a-zA-Z0-9]+"));
        s.setStudentName(ValidationAndNormalizingTextUtil.getStringByRegex("Enter Name: ", "Please enter character only!", "[A-Za-z ]+"));
        s.setSemester(ValidationAndNormalizingTextUtil.getNonEmptyString("Enter Semester Name: "));
        while (true) {
            int courseID = ValidationAndNormalizingTextUtil.getInt(courseInfo + "Enter Course ID: ", "Please enter number only", "Please enter courseID on the screen only", 1, 3);
            s.setCourseName(Student.courseName.getTypeByInt(courseID));
            String input = ValidationAndNormalizingTextUtil.pressYNtoContinue("Do you want to continue adding course(Y/N)?");
            if (input.toLowerCase().equals("n")) break;
        }
    }

}
