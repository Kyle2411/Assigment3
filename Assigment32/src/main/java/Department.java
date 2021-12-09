

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
import java.util.ArrayList;

public class Department {

    private int id;
    private String description;
    private Teacher dean;
    public static ArrayList<Teacher> TeacherList = new ArrayList<>();
    public static ArrayList<Student> StudentList = new ArrayList<>();
    public static ArrayList<Staff> StaffList = new ArrayList<>();

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department() {
    }

    public Department(int i, String d) {
        this.id = i;
        this.description = d;

    }

    public void setDean(Teacher teach) {
        this.dean = teach;
    }

    public Teacher getDean() {
        return this.dean;
    }

    public void Display() {
        System.out.println("ID: " + this.id + "\n" + "Description: " + this.description + "\n");

    }

}
