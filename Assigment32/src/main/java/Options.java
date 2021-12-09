

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ben_1
 */


public class Options extends Menu {

    //Counters
    int menuCounter;
    int checkCounter;

    //method to display menu options
    public void Options() {

        menuCounter = 0;
        checkCounter = 0;

        //do-while to ensure that the user creates a department before continuing to menu.
        do {

            //if the user attemps to use menu but hasn't created a department it will display this error message.
            if (menuCounter > 0 && menuChoice != 0) {
                System.out.println("\n----------< You must press 1 to create a Department! >----------");
                checkCounter++;

            } 
            
            if(menuChoice > 10 && checkCounter< 1 ){
                System.out.println("\n----------< Please select valid menu option! >----------");
                
                System.out.println(" \nPress 1 create a Department \n" + "Press 2 to add a student \n"
                            + "Press 3 to add a teacher \n"
                            + "Press 4 to add staff \n"
                            + "Press 5 to assign a teacher as a dean \n"
                            + "Press 6 to view Departments \n"
                            + "Press 7 to view all students \n"
                            + "Press 8 to view all teachers \n"
                            + "Press 9 to view the dean \n"
                            + "Press 10 to view Staff \n"
                            + "Press 0 to exit");
            
            }else {

                //the firstLoopcounter hasn't been incremeneted, it will ask the user to create a department.
                if (firstLoopcounter <= 0) {
                    System.out.println("\nPlease select option 1 to create a Department");

                    System.out.println(" \nPress 1 create a Department \n" + "Press 2 to add a student \n"
                            + "Press 3 to add a teacher \n"
                            + "Press 4 to add staff \n"
                            + "Press 5 to assign a teacher as a dean \n"
                            + "Press 6 to view Departments \n"
                            + "Press 7 to view all students \n"
                            + "Press 8 to view all teachers \n"
                            + "Press 9 to view the dean \n"
                            + "Press 10 to view Staff \n"
                            + "Press 0 to exit");
 
                    //only after the user has created a department, it will display the normal menu.
                } else {

                    System.out.println(" \nPlease select one of the following options");

                    System.out.println(" \nPress 1 create a Department \n" + "Press 2 to add a student \n"
                            + "Press 3 to add a teacher \n"
                            + "Press 4 to add staff \n"
                            + "Press 5 to assign a teacher as a dean \n"
                            + "Press 6 to view Departments \n"
                            + "Press 7 to view all students \n"
                            + "Press 8 to view all teachers \n"
                            + "Press 9 to view the dean \n"
                            + "Press 10 to view Staff \n"
                            + "Press 0 to exit");

                }
            }

            menuChoice = input.nextInt();
            menuCounter++;

            //while the user has not created a department yet, or exited the program, it will loop the error message.
        } while (menuChoice != 1 && menuChoice != 0 && firstLoopcounter <= 0);

    }
}
