

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ben_1
 */
public class CreateDepartment extends Menu {

    //variables
    int departmentID;
    String departmentDescription;
    int deptNum = 0;

    //Counters
    int numOfStudentsCounter = 0;
    int numOfTeachersCounter = 0;
    int numOfStaffCounter = 0;
    int deptCounter = 0;

    //Method to Create a department.
    public void CreateDepartment() {

        System.out.println("Please enter Department ID:");
        departmentID = input.nextInt();

        //Looping through department arrayList.
        for (Department dep : DepartmentList) {

            //While loop that checks if the user has inputted an ID that has already been inputted.
            while (dep.getId() == departmentID) {
                System.out.println("----------< Please enter unique Department Id!: >----------");
                departmentID = input.nextInt();
            }
        }

        //While loop that checks if the user has inputted an ID that is less than 2 digits.
        while (departmentID <= 9) {
            System.out.println("----------< Id must be at least 2 digits: >----------");
            departmentID = input.nextInt();
        }

        System.out.println("Please enter department description:");
        departmentDescription = input.next();

        //Creating department object with user-inputted attributes.
        Department Dept = new Department(departmentID, departmentDescription);
        DepartmentList.add(Dept);//adding the department object to the department arrayList.
        deptNum++;//Incrementing deptNum to store the value of the department position in the arrayList.
    }

    //Method that displays the department details.
    public void DisplayDepartments() {

        //loop that chekcs if a department has been created yet.
        while (DepartmentList.size() > 0) {

            deptCounter = 0;
            deptOption = 0;
            deptOption2 = 0;

            //When there are more than one department.
            if (DepartmentList.size() > 1) {
                System.out.println("You currently have " + DepartmentList.size() + " Departments \n");

                //When there is only one department.
            } else {

                System.out.println("You currently have " + DepartmentList.size() + " Department \n");
            }

            //Displaying all the departments.
            for (Department dept : DepartmentList) {

                dept.Display();
                System.out.println("------------------");

            }

            //displaying the options in the subMenu using a for loop.
            for (Department dept2 : DepartmentList) {

                System.out.println("Press " + (deptCounter + 1) + " to view details of " + dept2.getDescription() + " Department ");

                temp = deptCounter;//setting the temp value to what the user inputs.
            }

            System.out.println("Press " + (temp + 2) + " to exit to Main menu");

            deptOption = input.nextInt() - 1;//subtracting one from user input to account for 0 index array, because when displaying counters they begin from 0, so I increment them.

            //if the user chooses exit option, it will break the menu loop.
            if (deptOption == (temp + 1)) {

                break;
            }

            //if the user enters an invalid option in the menu will loop the error message.
            if (deptOption > temp || deptOption < 0) {

                System.out.println("\n----------< Please select valid option! >----------\n");
            } else {

                //while loop that checks if the user has inputted the option in the menu to return to subMenu.
                while (deptOption2 != 4) {

                    numOfStudentsCounter = 0;
                    numOfTeachersCounter = 0;

                    //looping through the student arrayList, if the student object's Id, or department choice number matches with that of a department, it will increment the counter. 
                    for (Student stuCheck : StudentList) {

                        if (stuCheck.getDeptChoice() == DepartmentList.get(deptOption).getId()) {

                            numOfStudentsCounter++;

                        }
                    }

                    //looping through the teacher arrayList, if the teacher object's Id, or department choice number matches with that of a department, it will increment the counter.
                    for (Teacher teachCheck : TeacherList) {

                        if (teachCheck.getDepartmentID() == DepartmentList.get(deptOption).getId()) {

                            numOfTeachersCounter++;
                        }
                    }
                    //looping through the staff arrayList, if the staff object's Id, or department choice number matches with that of a department, it will increment the counter.
                    for (Staff staffCheck : StaffList) {

                        if (staffCheck.getDepartmentID() == DepartmentList.get(deptOption).getId()) {

                            numOfStaffCounter++;
                        }
                    }

                    //If the previous counter was not incremented, it means there was no match, so it displays that their were no students in that department.
                    if (numOfStudentsCounter == 0) {

                        System.out.println("\n----------< " + DepartmentList.get(deptOption).getDescription() + " Department has no students! >----------");
                        //else the counter has been incremented, so it displays the option to view all students in that department.
                    } else {

                        System.out.println("\nPress 1 to view all students belonging to " + DepartmentList.get(deptOption).getDescription() + " Department");
                    }

                    //If the previous counter was not incremented, it means there was no match, so it displays that their were no teachers in that department.
                    if (numOfTeachersCounter == 0) {

                        System.out.println("----------< " + DepartmentList.get(deptOption).getDescription() + " Department has no teachers! >----------");
                        //else the counter has been incremented, so it displays the option to view all teachers in that department.
                    } else {

                        System.out.println("Press 2 to view all teachers belonging to " + DepartmentList.get(deptOption).getDescription() + " Department");

                    }

                    if (numOfStaffCounter == 0) {

                        System.out.println("----------< " + DepartmentList.get(deptOption).getDescription() + " Department has no staff! >----------");
                        //else the counter has been incremented, so it displays the option to view all staff in that department.
                    } else {

                        System.out.println("Press 3 to view all staff belonging to " + DepartmentList.get(deptOption).getDescription() + " Department");

                    }

                    System.out.println("Press 4 to return to Department menu");
                    deptOption2 = input.nextInt();

                    //If the user selects the option to view students, it will display all students in that department.
                    if (deptOption2 == 1) {

                        //for loop that loops through the student arrayList to check if that student is assigned to that current department, using department Id, and student department choice method.
                        for (Student stu : StudentList) {

                            if (stu.getDeptChoice() == DepartmentList.get(deptOption).getId()) {

                                System.out.println(stu);
                                System.out.println("------------------");

                                //else it skips to the next student object in the array
                            } else {

                                continue;
                            }

                        }

                    }

                    //If the user selects the option to view teachers, it will display all teachers in that department.
                    if (deptOption2 == 2) {

                        //for loop that loops through the teacher arrayList to check if that teacher is assigned to that current department, using department Id, and teacher department choice method.
                        for (Teacher teach : TeacherList) {

                            if (teach.getDepartmentID() == DepartmentList.get(deptOption).getId()) {

                                System.out.println(teach);
                                System.out.println("------------------");

                                //else it skips to the next teacher object in the array
                            } else {

                                continue;
                            }

                        }

                    }

                    if (deptOption2 == 3) {

                        //for loop that loops through the staff arrayList to check if that teacher is assigned to that current department, using department Id, and staff department choice method.
                        for (Staff staff : StaffList) {

                            if (staff.getDepartmentID() == DepartmentList.get(deptOption).getId()) {

                                System.out.println(staff);
                                System.out.println("------------------");

                                //else it skips to the next staff object in the array
                            } else {

                                continue;
                            }
                        }

                    }
                }
            }
        }
    }
}
