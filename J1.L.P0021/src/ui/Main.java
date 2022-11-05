package ui;

import controller.StudentManagerController;
import entity.Student;
import utils.Validations;

public class Main {

    public static void main(String[] args) {
        StudentManagerController controller = new StudentManagerController();
        int choice = 0, i = 0;
        String menu = """
                WELCOME TO STUDENT MANAGEMENT
                \t1. Create
                \t2. Find and Sort
                \t3. Update/Delete
                \t4. Report
                \t5. Exit""";
        do {
            System.out.print(menu);
            choice = Validations.getInt("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program): ", "Please enter number only", "Please enter in the menu above", 1, 5);
            try {
                switch (choice) {
                    case 1 -> {
                        while (true) {
                            Student student = controller.addStudent();
                            System.out.println("Add complete");
                            System.out.println(student);
                            i++;
                            if (i >= 2) {
                                String input = Validations.pressYNtoContinue("Do you want to continue adding student(Y/N): ");
                                if (input.equalsIgnoreCase("n")) {
                                    i = 0;
                                    break;
                                }
                            }
                        }
                    }
                    case 2 -> System.out.println(controller.findAndSortByName());
                    case 3 -> {
                        String uOrD = Validations.getStringByRegex("Do you want Update Or Delete(U/D): ", "U/D only!!!", "[UDud]");
                        if (uOrD.toLowerCase().equals("u")) {
                            Student updateStudent = controller.updateStudent();
                            System.out.println("Update Student successfully. The Student before the update: ");
                            System.out.println(updateStudent);
                        } else {
                            Student deleteStudent = controller.removeStudent();
                            System.out.println("Delete Student successfully. The Student have been deleted: ");
                            System.out.println(deleteStudent);
                        }
                    }
                    case 4 -> System.out.println(controller.report());
                    default -> choice = 5;
                }
            } catch (Exception e) {
                Validations.throwError(e.getMessage());
            }
        } while (choice != 5);
    }
}
