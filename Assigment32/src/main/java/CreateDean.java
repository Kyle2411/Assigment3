/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ben_1h
 */
public class CreateDean extends Menu {

    //Counters
    int deanCounter0;
    int deanCounter;
    int deanCounter1;
    int deanCounter2;
    int deanCounter3;
    int deanCounter4;
    int deanCounter5;

    //Method that assigns a dean
    public void makeDean() {

        //if the user atttemps to assign a dean before a teacher has been created this error message will be dsiplayed.
        if (TeacherList.size() < 1) {
            System.out.println("\n----------< You must create a Teacher first! >---------- ");

            //else the rest of the code will execute.
        } else {

            //Extra option that asks user if they want to assign a dean using a specific department ID and specific teacher ID.
            System.out.println("--------------------------------------");
            System.out.println("Press " + (deanCounter0 + 1) + " to search for sepecific department to add dean");

            deanChoice = input.nextInt() - 1;

            if (deanChoice > deanCounter0 || deanChoice < 0) {

                System.out.println("\n----------< Please select valid option! >----------\n");
            } else {

            }
            //if the user selects the option to assign the dean using a specific department ID and specific teacher ID.
            if (deanChoice == deanCounter0) {

                System.out.println("Enter Id of Department to choose teacher");
                deanChoice2 = input.nextInt();

                deanCounter1 = 0;
                deanCounter = 0;

                //if the deanCounter hasn't been incremented (because a valid department hasn't been found), it will continue to loop until a valid department ID has been inputted.
                while (deanCounter == 0) {

                    //loops through the department arrayList until a matching department ID has been found.
                    for (Department dep : DepartmentList) {

                        //if the user inputted department ID matches with that department's ID , it will move on and ask the user to input a teacher ID.
                        if (deanChoice2 == dep.getId()) {

                            System.out.println("Enter Id of Teacher you want to become dean for " + dep.getDescription() + " Department!");
                            deanChoice3 = input.nextInt();

                            deanCounter = 1;
                            deanCounter2 = 0;

                            //if the deanCounter2 hasn't been incremented(because a valid teacher hasn't been found,( it will continue to loop until a valid teacher ID has been inputted.
                            while (deanCounter2 == 0) {

                                //loops through the teacher arrayList until a matching teacher ID has been found
                                for (Teacher teach : TeacherList) {

                                    //if the user inputted teacher ID matches with that department's ID, it will set that teacher as the dean of that department.
                                    if (deanChoice3 == teach.getId()) {

                                        if (dep.getId() == teach.getId()) {

                                            //using department object to set the teacher object as the new dean.
                                            dep.setDean(teach);
                                            //displaying the new dean.
                                            System.out.println("\n" + dep.getDean().getName() + " is the new dean for " + dep.getDescription() + " Department");

                                            createDeanCounter++;
                                            deanCounter1++;
                                            deanCounter2 = 1;

                                            break;

                                        }

                                        if (deanCounter2 == 0) {
                                            System.out.println("----------< Teacher must be part of Department! >----------");
                                            deanChoice3 = input.nextInt();

                                        }
                                    }
                                }

                                //if the deanCounter2 hasn't been incremented(because a dean was never assigned, therefore the counter remains 0), it will ask the user to enter a correct teacher ID.
                                if (deanCounter2 == 0) {
                                    System.out.println("----------< Please enter valid Teacher ID! >----------");
                                    deanChoice3 = input.nextInt();

                                }

                            }

                        }

                    }

                    //if the deanCounter has been incremented it will break out of the loop because a dean has been assigned.
                    if (deanCounter1 > 0) {
                        break;
                    }
                    //if the deanCounter hasn't been incremented(because a matching department ID was never found, therefore the counter remains 0), it will ask the user to enter a correct department ID.
                    if (deanCounter == 0) {
                        System.out.println("----------< Please enter valid Department ID! >----------");
                        deanChoice2 = input.nextInt();

                    }

                }

            }

        }
    }

    //method to display the dean.
    public void DisplayDean() {

        System.out.println("which department would you like to view the dean?");

        //loops through the department arrayList, and displays the options to select a department to view the dean.
        for (int i = 0; DepartmentList.size() > i; i++) {

            System.out.println("Press " + (i + 1) + " for " + DepartmentList.get(i).getDescription() + " Department");

        }
        viewDepartmentDean = input.nextInt() - 1;

        //loop that checks if the user inputted a valid option.
        while (viewDepartmentDean >= DepartmentList.size() || viewDepartmentDean < 0) {

            System.out.println("----------< Please enter valid option! >----------");

            //loops through the department arrayList, and displays the options to select a department to view the dean.
            for (int i = 0; DepartmentList.size() > i; i++) {

                System.out.println("Press " + (i + 1) + " for " + DepartmentList.get(i).getDescription() + " Department");

            }
            viewDepartmentDean = input.nextInt() - 1;
        }

        //loops through the department arrayList, and displays the options to select a department to view the dean.
        for (int i = 0; DepartmentList.size() > i; i++) {

            System.out.println("Press " + (i + 1) + " for " + DepartmentList.get(i).getDescription() + " Department");

        }

        deanCounter4 = 0;

        //checks if a dean of the department selected by the user has been assigned.
        if (DepartmentList.get(viewDepartmentDean).getDean() != null) {

            deanCounter3 = 0;

            for (Teacher teach : TeacherList) {

                //checks if the department that the user chose to view the dean' Id is equal to a teacher's ID in the arrayList
                if (DepartmentList.get(viewDepartmentDean).getId() == teach.getDepartmentID()) {

                    for (Department dep : DepartmentList) {

                        //checks if that teacher is equal to the id of the department selected by the user.
                        if (dep.getId() == teach.getDepartmentID()) {

                            //displays the dean of the department selected by the user.
                            System.out.println("\nThe dean for " + dep.getDescription() + " Department is " + dep.getDean().getName());
                            System.out.println("----------------------------------------");
                            System.out.println(dep.getDean());

                            deanCounter4++;
                            deanCounter3++;
                            break;
                        }

                    }
                }
                //if the deanCounter3 has been incremented it will break out of the loop beacuse a dean has been assigned
                if (deanCounter3 > 0) {
                    break;
                }
            }
        }

        //if the deanCounter4 has been incremented it will tell the user that no dean has been assigned to that department.
        if (deanCounter4 < 1) {

            System.out.println("\n----------< There is no dean for " + DepartmentList.get(viewDepartmentDean).getDescription() + " Department! " + ">----------");
        }
    }
}
