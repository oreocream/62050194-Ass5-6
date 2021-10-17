/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Pongsiri
 */
public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student s = new Student(1, "Pongsiri", 3.63);
        StudentTable.insertStudent(s);
        
        //StudentTable.removeStudent(s);
        
        s.setName("O");
        StudentTable.updateStudent(s);
        
        //display
        printAllStudent(StudentTable.findAllStudent());
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void printAllStudent(List<Student> employeeList) {
        for(Student emp : employeeList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGPA()+ " ");
       }
    }
    
    
}