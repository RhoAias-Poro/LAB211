package ui;

import controller.StudentManagerController;
import entity.Student;
import utils.Validations;

public class Main {

    public static void main(String[] args) throws Exception {
        StudentManagerController controller = new StudentManagerController();
        Student student = new Student();
        int choice = 0, i = 0;
        String menu = "WELCOME TO STUDENT MANAGEMENT\n" + "\t1. Create\n" + "\t2. Find and Sort\n" + "\t3. Update/Delete\n" + "\t4. Report\n" + "\t5. Exit";
        do {
            System.out.print(menu);
            choice = Validations.getInt("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program): ", "Please enter number only", "Please enter in the menu above", 1, 5);
            try {
                switch (choice) {
                    case 1:
                        while (true) {
                            student = controller.addStudent();
                            System.out.println("Add complete");
                            i++;
                            if (i >= 2) {
                                String input = Validations.pressYNtoContinue("Do you want to continue adding student(Y/N): ");
                                if (input.equalsIgnoreCase("n")) {
                                    i = 0;
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println(controller.findAndSortByName());
                        break;
                    case 3:
                        String uOrD = Validations.getStringByRegex("Do you want Update Or Delete: ", "U/D only!!!", "[UDud]");
                        if (uOrD.toLowerCase().equals("u")) {
                            Student updateStudent = controller.updateStudent();
                            System.out.println("Update Student successfully!");
                        } else {
                            Student deleteStudent = controller.removeStudent();
                            System.out.println("Delete Student successfully!");
                        }
                    case 4:
                        System.out.println(controller.report());
                        break;
                    default:
                        choice = 5;
                        break;
                }
            } catch (Exception e) {
                Validations.throwError(e.getMessage());
            }
        } while (choice != 5);
    }
}
