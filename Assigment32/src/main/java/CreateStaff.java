
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
public class CreateStaff extends Menu {

    //Variables
    int staffID;
    String staffName;
    int staffAge;
    String staffGender;
    String staffDuty;
    int staffWorkload;

    //Counters
    int staffCount1;
    int staffCount2;

    
     public void readStaff() throws IOException {

        String filePath = "C:\\Users\\ben_1\\Desktop\\FinalProject\\Staff.txt";
        
        try {
            RandomAccessFile file = new RandomAccessFile(filePath, "r");
            String str;
            String line1 = null;

            while ((line1 = file.readLine()) != null) {

                while ((str = file.readLine()) != null) {

                    String staffLine[] = str.split(",");
                    Staff stf = new Staff(Integer.parseInt(staffLine[0]), staffLine[1],
                            Integer.parseInt(staffLine[2]), staffLine[3], staffLine[4], Integer.parseInt(staffLine[5]), Integer.parseInt(staffLine[6]));
                    StaffList.add(stf);
                    
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     
    //Method for creating a new staff
    public void CreateStaff() {

        departmentChoiceStaff = 0;

        System.out.println("Please enter staff ID:");
        staffID = input.nextInt();

        //loop that checks if the user has inputted a staff ID that has already been inputted.
        for (Staff staff : StaffList) {
            while (staff.getId() == staffID) {
                System.out.println("----------< Please enter unique staff Id!: >----------");
                staffID = input.nextInt();
            }
        }

        //loop that mchecks if the user has inputted a staff Id that isn't at least 2 digits(for realism).
        while (staffID <= 9) {
            System.out.println("----------< Id must be at least 2 digits!: >----------");
            staffID = input.nextInt();
        }

        System.out.println("Please enter staff's name:");
        staffName = input.next();
        System.out.println("Please enter " + staffName + "'s age:");
        staffAge = input.nextInt();
        System.out.println("Please enter " + staffName + "'s gender:");
        staffGender = input.next();
        System.out.println("Please enter " + staffName + "'s duty:");
        staffDuty = input.next();
        System.out.println("Please enter " + staffName + "'s workLoad:");
        staffWorkload = input.nextInt();


        staffCount1 = 0;

        //loop that displays all the current departments, and provides an option to select a department to assign the staff to.
        
        System.out.println("Press " + (staffCount1 + 1) + " to assign staff using department ID");

        departmentChoiceStaff = input.nextInt() - 1;

        //if statement that checks if the user has inputted the option to assign staff based on department's ID. 

            System.out.println("Enter Id of Department");
            departmentChoiceStaff2 = input.nextInt();

            staffCount2 = 0;

            //loop that checks if the counter has been incremented, it will increment if a staff has been added, then it will exit the loop.
            while (staffCount2 == 0) {

                for (Department dep : DepartmentList) {

                    //if the user inputs a department ID that matches with the ID of a given department in the loop, it will add that staff object to the staff arrayList
                    if (dep.getId() == departmentChoiceStaff2) {

                        //Creating a staff object, using the attributs that were inputted by the user.
                        Staff staff = new Staff(staffID, staffName, staffAge, staffGender, staffDuty, staffWorkload, departmentChoiceStaff2);
                        StaffList.add(staff);//adding staff object to the staff arrayList.
                        staff.computePayRoll();
                        System.out.println("\nYou assigned " + staffName + " to " + dep.getDescription() + " Department!");
                        staffCount2 = 1;
                        
                        String path = "C:\\Users\\ben_1\\Desktop\\FinalProject\\Staff.txt";
                        
                        try {
                            AppendToStaff(staff.toStringAppend() ,path);
                        } catch (IOException ex) {
                            Logger.getLogger(CreateTeacher.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        break;

                    }
                }

                //if the counter hasn't been incremented, (because a matching department ID wasn't found), it will ask the user to input a correct department ID.
                if (staffCount2 == 0) {

                    System.out.println("----------< Please enter valid Department ID! >----------");
                    departmentChoiceStaff2 = input.nextInt();

                }

            }
            
        } 
    
     public void AppendToStaff(String data, String fileName) throws IOException {

        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append("\n");
        writer.write(data);
        writer.close();
}
    

    //Method that displays all the staffs.
    public void DisplayStaff() {

        //checks if the user has created a staff object yet.
        if (StaffList.size() < 1) {
            System.out.println("\n----------< You must create a staff first! >----------");

            //else it displays the all the staffs.
        } else {

            //loops through staff arrayList and displays every staff.
            for (Staff staff : StaffList) {

                System.out.println(staff);

                //loop that checks if the staff matches with the department it was previously assigned to, then it will display which department that specific staff belongs to.
                for (Department dep : DepartmentList) {

                    //checks if the staff department choice variable is equal to the department ID, or if it is equal to the department position.
                    //The reason for these 2 statemtents is beacause if the user previously chose to assign the staff to the department using the quick option, it would use
                    //the department postion, rather than if the user assigned the staff by inputting a specific department ID.
                    if (staff.getDepartmentID() == dep.getId())  {

                        System.out.println("This staff belongs to the " + dep.getDescription() + " Department");
                    }
                }
                System.out.println("----------------------------------------");

            }
        }
    }

}
