

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Student extends Person {

    private String course;
    private int semester;
    private int deptChoice;

    public int getDeptChoice() {
        return deptChoice;
    }

    public void setDeptChoice(int deptChoice) {
        this.deptChoice = deptChoice;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return this.course;
    }

    public int getSemester() {
        return this.semester;
    }
    

    public Student() {
        this.course = null;
        this.semester = 0;
    }

    public Student(int id1, String name1, int age1, String gender1, String course1, int semester1, int deptChoice1) {

        this.id = id1;
        this.name = name1;
        this.age = age1;
        this.gender = gender1;
        this.course = course1;
        this.semester = semester1;
        this.deptChoice = deptChoice1;
    }

    @Override public String toString() {
       return (super.toString() + "Course: " + this.course + "\n" + "Semester: " + this.semester);

    }
    
     public String toStringAppend() {
       return (super.toString() + this.course + "," + this.semester);

    }

    @Override
    public void Category() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
