

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ben_1
 */
public class Staff extends Person implements Payroll {

    private String duty;
    private int workload;
    private int departmentID;

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public Staff() {

        this.duty = null;
        this.workload = 0;

    }

    public Staff(int id1, String name1, int age1, String gender1, String duty1, int workload1, int departmentID1) {

        this.id = id1;
        this.name = name1;
        this.age = age1;
        this.gender = gender1;
        this.duty = duty1;
        this.workload = workload1;
        this.departmentID = departmentID1;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }
    
    @Override public String toString(){
        return(super.toString() + "Duty: " + this.duty + "\n" + "Workload: " + this.workload + "\n" + "PayRoll: " +computePayRoll() + "$");
        

    }
    
    public String toStringAppend(){
        return(super.toString() + this.duty + ","+ this.workload + "," + computePayRoll());
        

    }

    @Override
    public double computePayRoll() {

        if (this.workload <= 36) {
            return this.workload * 32 * 2;
        }

        return 0.0;

    }

    @Override
    public void Category() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
