/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pongsiri
 */
public class StudentDatabase{
    public static void main(String[]args)throws ClassNotFoundException, SQLException {
        String derbyClientDriver = "org.apache.derby.jdbc.ClientDriver";
        
        Class.forName(derbyClientDriver);
        
        String url = "jdbc:derby://localhost:1527/Student";
        String user = "app";
        String passwd = "app";
        
        Connection con = DriverManager.getConnection(url, user, passwd);
        
        Statement stmt = con.createStatement();
        
        StudentJDBC s1 = new StudentJDBC(1, "Pitchayuth", 3.8);
        
        insertStudent(stmt, s1);
        updateStudentName(stmt, s1);
        //deleteStudent(stmt, s1);
        
    }
    
    public static void insertStudent(Statement stmt, StudentJDBC s) throws SQLException{
        String sql = "insert into student (id, name, gpa)" +
                     " values (" + s.getId() + "," + "'" + s.getName() + "'" + "," + s.getGPA() + ")";
        int result = stmt.executeUpdate(sql);
        System.out.println("INSERT " + result + " row");
    }
    
    public static void deleteStudent(Statement stmt, StudentJDBC s) throws SQLException {
        String sql = "DELETE from student where id = " + s.getId() ;
        int result = stmt.executeUpdate(sql);
        System.out.println("DELETE " + result + " row");
    }
    
    public static void updateStudentName(Statement stmt, StudentJDBC s) throws SQLException {
        String sql = "UPDATE student set name = '" +s.getName() + "'" + "WHERE id = " + s.getId();
        int result = stmt.executeUpdate(sql);
        System.out.println("UPDATE " + result + " row");
    }
    public static void updateStudentGpa(Statement stmt, StudentJDBC s) throws SQLException {
        String sql = "UPDATE student set name = " + s.getGPA() + "WHERE id = " + s.getId();
        int result = stmt.executeUpdate(sql);
        System.out.println("UPDATE " + result + " row");
    }
}