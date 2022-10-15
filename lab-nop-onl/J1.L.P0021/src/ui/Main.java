package ui;

import controller.StudentManagerController;
import entity.Student;
import utils.IntegerUtils;
import utils.Validations;

public class Main {

    public static void main(String[] args) throws Exception {
        StudentManagerController controller = new StudentManagerController();
        int choice = 0;
        String menu = "WELCOME TO STUDENT MANAGEMENT\n" +
                "\t1. Create\n" +
                "\t2. Find and Sort\n" +
                "\t3. Update/Delete\n" +
                "\t4. Report\n" +
                "\t5. Exit\n" +
                "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).";

        do {
            System.out.print(menu);
            choice = IntegerUtils.getOption();
            switch (choice) {
                case 1:
                    controller.numberStudentAdd();
                    break;
                case 2:
                    String input = Validations.getStringByRegex("Please enter a name you want to search: ", "Please enter character only", "[a-zA-Z]");
                    System.out.println(controller.findAndSort(input));
                    break;
                case 3:
                    System.out.print("Please enter a Student ID that you want to manipulate: ");
                    String id = Validations.getStringByRegex("Enter Student ID: ", "Please enter valid character", "[a-zA-Z0-9]+");
                    String uOrD = Validations.pressUDtoContinue("Do you want to update or delete(U/D): ");
                    if (uOrD.toLowerCase().equals("u")) {
                        try {
                            Student updateStudent = controller.updateStudent(id);
                            System.out.println("Update Student successfully!");
                            System.out.println(updateStudent);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            Student deleteStudent = controller.removeStudent(id);
                            System.out.println("Delete Student successfully!");
                            System.out.println(deleteStudent);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                case 4:
                    System.out.println(controller.report());
                    break;
                case 5:
                    choice = 5;
                    break;
            }
        } while (choice < 5);
    }
}
