

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Teacher extends Person implements Payroll{
    
    //Variables
    private String specialty;
    private String degree;
    private double saldegree;
    private int departmentID;//variable that stores value of either the id of the department that the teacher is assigned to, or the index of the department the teacher is assigned to(depending on which method the teacher was assigned.)

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getSaldegree() {
        return saldegree;
    }

    public void setSaldegree(double saldegree) {
        this.saldegree = saldegree;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
    

    public void setDegree(String degree) {this.degree = degree;}

    public String getDegree() {return this.degree;}
    
    
    //Constructors for Teacher class
    public Teacher() {
    this.specialty = null;
    this.degree = null;
}

    public Teacher(int id1, String name1, int age1, String gender1, String specialty1, String degree1, int departmentID1 ) {

   this.id = id1;
   this.name = name1;
   this.age = age1;
   this.gender = gender1;
   this.specialty = specialty1;
   this.degree = degree1;
   this.departmentID = departmentID1;
    }
     
    //method to i=override and display Teacher information
     @Override public String toString(){
        return(super.toString() + "Specialty: " + this.specialty + "\n" + "Degree: " + this.degree + "\n" + "PayRoll: " + computePayRoll() + "$");

    }
     
      public String toStringAppend(){
        return(super.toStringAppend() + this.specialty + "," + this.degree + "," + departmentID);

    }
    
    @Override
    public double computePayRoll() {
        
        if("phd".equals(this.degree)){
            this.saldegree = 112;
        return 36 * this.saldegree * 2;
        }
        
        if("master".equals(this.degree)){
            this.saldegree = 82;
        return 36 * this.saldegree * 2;
        }
        
        if("bachelor".equals(this.degree)){
            this.saldegree = 42;
        return 36 * this.saldegree * 2;
        }
        
        return 0.0;
    }

    @Override
    public void Category() {
        
    }
}
