

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public abstract class Person {
    
    protected int id;
    protected String name;
    protected int age;
    protected String gender;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    

    public Person() {
        this.name = null;
        this.id = 0;
        this.gender = null;
        this.age = 0;
    }

    public Person(String n, int i, String g, int a) {

        this.name = n;
        this.id = i;
        this.gender = g;
        this.age = a;
    }

    public String toString() {
        return("ID: " + this.id + "\n" + "Name: " + this.name +"\n" + "Gender: " + this.age + "\n" + "Age: " + this.gender + "\n");
    
    }
     public String toStringAppend() {
        return(this.id + "," + this.name + "," + this.age + "," + this.gender + ",");
    
    }
    
    
    public abstract void Category();
    

}
    

