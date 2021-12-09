
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
public class CreateStudent extends Menu {

    //Variables
    int studentID;
    String studentName;
    int studentAge;
    String studentGender;
    String studentCourse;
    int studentSemester;

    //Counters
    int studentCount1;
    int studentCount2;

    public void readStudent() throws IOException {

        String filePath = "C:\\Users\\ben_1\\Desktop\\FinalProject\\Student.txt";

        try {

            RandomAccessFile file = new RandomAccessFile(filePath, "r");
            String str;

            while ((str = file.readLine()) != null) {

                String studentLine[] = str.split(",");
                Student stu = new Student(Integer.parseInt(studentLine[0]), studentLine[1],
                        Integer.parseInt(studentLine[2]), studentLine[3], studentLine[4],  Integer.parseInt(studentLine[5]), Integer.parseInt(studentLine[6]));
                StudentList.add(stu);

                
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Method for creating a new student
    public void CreateStudent() {

        departmentChoiceStu = 0;

        System.out.println("Please enter student ID:");
        studentID = input.nextInt();

        //loop that checks if the user has inputted a student ID that has already been inputted.
        for (Student stu : StudentList) {
            while (stu.getId() == studentID) {
                System.out.println("----------< Please enter unique student Id!: >----------");
                studentID = input.nextInt();
            }
        }

        //loop that mchecks if the user has inputted  a student Id that isn't at least 2 digits(for realism).
        while (studentID <= 9) {
            System.out.println("----------< Id must be at least 2 digits!: >----------");
            studentID = input.nextInt();
        }

        System.out.println("Please enter student's name:");
        studentName = input.next();
        System.out.println("Please enter " + studentName + "'s age:");
        studentAge = input.nextInt();
        System.out.println("Please enter " + studentName + "'s gender:");
        studentGender = input.next();
        System.out.println("Please enter " + studentName + "'s course:");
        studentCourse = input.next();
        System.out.println("Please enter " + studentName + "'s semester:");
        studentSemester = input.nextInt();

        studentCount1 = 0;

        //Extra option that asks user if they want to assign a student using a specific department ID.
        System.out.println("--------------------------------------");
        System.out.println("Press " + (studentCount1 + 1) + " to assign student using department ID");

        departmentChoiceStu = input.nextInt() - 1;

        //if statement that checks if the user has inputted the option to assign student based on department's ID.
        if (departmentChoiceStu == studentCount1) {

            System.out.println("Enter Id of Department");
            departmentChoiceStu2 = input.nextInt();

            studentCount2 = 0;

            //loop that checks if the counter has been incremented, it will increment if a student has been added, then it will exit the loop.
            while (studentCount2 == 0) {

                for (Department dep : DepartmentList) {

                    //if the user inputs a department ID that matches with the ID of a given department in the loop, it will add that student object to the student arrayList
                    if (dep.getId() == departmentChoiceStu2) {

                        //Creating a student object, using the attributs that were inputted by the user.
                        Student Stu = new Student(studentID, studentName, studentAge, studentGender, studentCourse, studentSemester, departmentChoiceStu2);
                        StudentList.add(Stu);//adding student object to the student arrayList.
                        System.out.println("\nYou assigned " + studentName + " to " + dep.getDescription() + " Department!");
                        studentCount2 = 1;
                        
                        String path = "C:\\Users\\ben_1\\Desktop\\FinalProject\\Student.txt";
                        
                        try {
                            AppendToStudent(Stu.toStringAppend() ,path);
                        } catch (IOException ex) {
                            Logger.getLogger(CreateTeacher.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;

                    }
                }

                //if the counter hasn't been incremented, (because a matching department ID wasn't found), it will ask the user to input a correct department ID.
                if (studentCount2 == 0) {

                    System.out.println("----------< Please enter valid Department ID! >----------");
                    departmentChoiceStu2 = input.nextInt();

                }

            }

        }
    }
    
    public void AppendToStudent(String data, String fileName) throws IOException {

        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append("\n");
        writer.write(data);
        writer.close();
}

    //Method that displays all the students.
    public void DisplayStudent() {

        //checks if the user has created a student object yet.
        if (StudentList.size() < 1) {
            System.out.println("\n----------< You must create a student first! >----------");

            //else it displays the all the students.
        } else {

            //loops through student arrayList and displays every student.
            for (Student stu : StudentList) {

                System.out.println(stu);

                //loop that checks if the student matches with the department it was previously assigned to, then it will display which department that specific student belongs to.
                for (Department dep : DepartmentList) {

                    //checks if the student department choice variable is equal to the department ID, or if it is equal to the department position.
                    //The reason for these 2 statemtents is beacause if the user previously chose to assign the student to the department using the quick option, it would use
                    //the department postion, rather than if the user assigned the student by inputting a specific department ID.
                    if (stu.getDeptChoice() == dep.getId()) {

                        System.out.println("This student belongs to the " + dep.getDescription() + " Department");
                    }
                }
                System.out.println("----------------------------------------");

            }
        }
    }

}
