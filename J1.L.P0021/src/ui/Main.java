package ui;

import controller.StudentManagerController;
import entity.Student;
import utils.Validations;

public class Main {

    public static void main(String[] args) throws Exception {
        StudentManagerController controller = new StudentManagerController();
        Student student = new Student();
        int choice = 0, i = 0;
        String menu = "WELCOME TO STUDENT MANAGEMENT\n" +
                "\t1. Create\n" +
                "\t2. Find and Sort\n" +
                "\t3. Update/Delete\n" +
                "\t4. Report\n" +
                "\t5. Exit";
        do {
            System.out.print(menu);
            choice = Validations.getInt("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program): ", "Please enter number only", "Please enter in the menu above", 1, 5);
            switch (choice) {
                case 1:
                    while (true) {
                        try {
                            student = controller.addStudent();
                            System.out.println("Add complete");
                            i++;
                        } catch (Exception e) {
                            Validations.throwError(e.getMessage());
                        }
                        if (i >= 2) {
                            String input = Validations.pressYNtoContinue("Do you want to continue(Y/N): ");
                            if (input.equalsIgnoreCase("n")) {
                                i = 0;
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    String input = Validations.getStringByRegex("Please enter a name you want to search: ", "Please enter character only", "[a-zA-Z\s]");
                    try {
                        System.out.println(controller.findAndSort(input));
                    } catch (Exception e) {
                        Validations.throwError(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Please enter a Student ID that you want to manipulate: ");
                    String id = Validations.getStringByRegex("Enter Student ID: ", "Please enter valid character", "[a-zA-Z0-9]+");
                    String uOrD = Validations.getStringByRegex("Do you want Update Or Delete: ", "U/D only!!!", "[UDud]");
                    if (uOrD.toLowerCase().equals("u")) {
                        try {
                            Student updateStudent = controller.updateStudent(id);
                            System.out.println("Update Student successfully!");
                            System.out.println(updateStudent);
                        } catch (Exception e) {
                            Validations.throwError(e.getMessage());
                        }
                    } else {
                        try {
                            Student deleteStudent = controller.removeStudent(id);
                            System.out.println("Delete Student successfully!");
                            System.out.println(deleteStudent);
                        } catch (Exception e) {
                            Validations.throwError(e.getMessage());
                        }
                    }
                case 4:
                    try {
                        System.out.println(controller.report());
                    } catch (Exception e) {
                        Validations.throwError(e.getMessage());
                    }
                    break;
                default:
                    choice = 5;
                    break;
            }
        } while (choice != 5);
    }
}
