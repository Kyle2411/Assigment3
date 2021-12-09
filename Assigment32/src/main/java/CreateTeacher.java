
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ben_1
 */
public class CreateTeacher extends Menu {

    //Variables
    int teacherID;
    String teacherName;
    int teacherAge;
    String teacherGender;
    String teacherSpecialty;
    String teacherDegree;

    //Counters
    int teachCount1;
    int teachCount2;
    double payRollCheck;

    public void readTeacher() throws IOException {

        String filePath = "C:\\Users\\ben_1\\Desktop\\FinalProject\\Teacher.txt";

        try {
            RandomAccessFile file = new RandomAccessFile(filePath, "r");
            String str;
            String line1 = null;

            while((str = file.readLine()) != null) {

                String teacherLine[] = str.split(",");
                Teacher tea = new Teacher(Integer.parseInt(teacherLine[0]), teacherLine[1],
                        Integer.parseInt(teacherLine[2]), teacherLine[3], teacherLine[4], teacherLine[5], Integer.parseInt(teacherLine[6]));
                TeacherList.add(tea);
                tea.computePayRoll();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Method for creating a new teacher.
    public void CreateTeacher() {

        System.out.println("Please enter teacher ID:");
        teacherID = input.nextInt();

        //loop that checks if the user has inputted a teacher ID that has already been inputted.
        for (Teacher teach : TeacherList) {

            while (teach.getId() == teacherID) {
                System.out.println("----------< Please enter unique teacher Id!: >----------");
                teacherID = input.nextInt();
            }
        }

        //loop that mchecks if the user has inputted a teacher Id that isn't at least 2 digits(for realism).
        while (teacherID <= 9) {
            System.out.println("----------< Id must be at least 2 digits: >----------");
            teacherID = input.nextInt();
        }

        System.out.println("Please enter teacher's name:");
        teacherName = input.next();
        System.out.println("Please enter " + teacherName + "'s age:");
        teacherAge = input.nextInt();
        System.out.println("Please enter " + teacherName + "'s gender:");
        teacherGender = input.next();
        System.out.println("Please enter " + teacherName + "'s specialty:");
        teacherSpecialty = input.next();
        System.out.println("Please enter " + teacherName + "'s degree:");
        teacherDegree = input.next();

        teachCount1 = 0;

        //Extra option that asks user if they want to assign a teacher using a specific department ID.
        System.out.println("--------------------------------------");
        System.out.println("Press " + (teachCount1 + 1) + " to assign teacher using department ID");

        departmentChoiceTeach = input.nextInt() - 1;

        //if statement that checks if the user has inputted the option to assign teacher based on department's ID.
        if (departmentChoiceTeach == teachCount1) {

            System.out.println("Enter Id of Department");
            departmentChoiceTeach2 = input.nextInt();

            teachCount2 = 0;

            //loop that checks if the counter has been incremented, it will increment if a teacher has been added, then it will exit the loop.
            while (teachCount2 == 0) {

                for (Department dep : DepartmentList) {

                    //if the user inputs a department ID that matches with the ID of a given department in the loop, it will add that teaher object to the teacher arrayList
                    if (dep.getId() == departmentChoiceTeach2) {

                        //Creating a teacher object, using the attributs that were inputted by the user.
                        Teacher teach = new Teacher(teacherID, teacherName, teacherAge, teacherGender, teacherSpecialty, teacherDegree, departmentChoiceTeach2);
                        TeacherList.add(teach);//adding teacher object to the teacher arrayList.
                        teach.computePayRoll();
                        System.out.println("\nYou assigned teacher " + teacherName + " to " + dep.getDescription() + " Department!");
                        teachCount2 = 1;
                        
                        
                        String path = "C:\\Users\\ben_1\\Desktop\\FinalProject\\Teacher.txt";
                        
                        try {
                            AppendToTeacher(teach.toStringAppend() ,path);
                        } catch (IOException ex) {
                            Logger.getLogger(CreateTeacher.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        break;
                    }
                }

                //if the counter hasn't been incremented, (because a matching department ID wasn't found), it will ask the user to input a correct department ID.
                if (teachCount2 == 0) {

                    System.out.println("----------< Please enter valid Department ID! >----------");
                    departmentChoiceTeach2 = input.nextInt();

                }

            }

        }
    }
    
    public void AppendToTeacher(String data, String fileName) throws IOException {

        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append("\n");
        writer.write(data);
        writer.close();
}
    


    //Method that displays all the teachers.
    public void DisplayTeacher() {

        //checks if the user has created a teacher object yet.
        if (TeacherList.size() < 1) {
            System.out.println("\n----------< You must create a teacher first! >----------");

            //else it displays the all the teachers.
        } else {

            //loops through student arrayList and displays every teacher.
            for (Teacher teach : TeacherList) {

                System.out.println(teach);

                //loop that checks if the teacher matches with the department it was previously assigned to, then it will display which department that specific teacher belongs to.
                for (Department dep : DepartmentList) {

                    //checks if the teacher department choice variable is equal to the department ID, or if it is equal to the department position.
                    //The reason for these 2 statemtents is beacause if the user previously chose to assign the teacher to the department using the quick option, it would use
                    //the department postion, rather than if the user assigned the teacher by inputting a specific department ID.
                    if (teach.getDepartmentID() == dep.getId()) {

                        System.out.println("This teacher belongs to the " + dep.getDescription() + " Department");
                    }
                }
                System.out.println("----------------------------------------");

            }
        }
    }

}
