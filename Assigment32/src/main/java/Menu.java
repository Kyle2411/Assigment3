

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends Department {

    //Creating Scanner class.
    public static Scanner input = new Scanner(System.in);

    //Creating ArrayLists.
    public static ArrayList<Department> DepartmentList = new ArrayList<>();

    //Creating objects for each class.
    public static CreateDepartment createDepartment = new CreateDepartment();
    public static CreateStudent createStudent = new CreateStudent();
    public static CreateTeacher createTeacher = new CreateTeacher();
    public static CreateDean createDean = new CreateDean();
    public static CreateStaff createStaff = new CreateStaff();
    public static Options options = new Options();

    //Creating variables.
    public static int menuChoice = 1;
    public static int studentChoice;
    public static int departmentChoiceTeach;
    public static int departmentChoiceTeach2;
    public static int departmentChoiceStu;
    public static int departmentChoiceStu2;
    public static int departmentChoiceStaff;
    public static int departmentChoiceStaff2;
    public static int deanChoice;
    public static int deanChoice2;
    public static int deanChoice3;
    public static int departmentDeanChoice;
    public static int viewDepartmentDean;
    public static int temp = 1;
    public static int deptOption;
    public static int deptOption2;
    public static int firstLoopcounter;
    public static int createDeanCounter;

    //Method to use functions of menu.
    public void showMenu() {
        

        //while loop that checks if the user has entered option 0, to exit the program.
        while (menuChoice != 0) {

            try {
                createStaff.readStaff();
                createStudent.readStudent();;
                createTeacher.readTeacher();
                
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            options.Options();

            //Switch loop that allows user to select multiple options in the menu.
            switch (menuChoice) {

                //creating department option
                case 1:

                    createDepartment.CreateDepartment();
                    firstLoopcounter++;//incrementing counter, that is checked in Options class, this will let the user select other options after creating a Department.

                    break;

                //Creating student option.
                case 2:

                    createStudent.CreateStudent();

                    break;

                //Creating teacher option.
                case 3:

                    createTeacher.CreateTeacher();

                    break;

                //Creating dean option.
                case 4:

                    createStaff.CreateStaff();

                    break;

                //Display departments subMenu option.
                case 5:

                    createDean.makeDean();

                    break;

                //Displaying students option.
                case 6:

                    createDepartment.DisplayDepartments();

                    break;

                //Displaying teachers option.
                case 7:

                    createStudent.DisplayStudent();

                    break;

                //Displaying dean option.
                case 8:

                    createTeacher.DisplayTeacher();

                    break;

                case 9:

                    createDean.DisplayDean();

                    break;

                case 10:

                    createStaff.DisplayStaff();

                    break;
            }
  
        }
        
        System.out.println("\nEnjoy your day!");
    }
}
