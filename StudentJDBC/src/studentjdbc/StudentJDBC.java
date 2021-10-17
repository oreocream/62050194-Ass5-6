/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjdbc;

/**
 *
 * @author Pongsiri
 */
public class StudentJDBC {

private int id;
    private String name;
    private double GPA;
    
    public StudentJDBC(){};
    
    public StudentJDBC(int id, String name, double gpa){
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double gpa) {
        this.GPA = GPA;
    }
    
}
