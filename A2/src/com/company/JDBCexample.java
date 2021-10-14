package com.company;

import java.sql.*;
import java.util.*;

public class JDBCexample {
    public static void main(String[] args) {
        System.out.println("Trying to log into the database");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/COMP_3005", "postgres", "4aq!cKeAS9ncRkyj");
             Statement statement = connection.createStatement();
        )
        {
            System.out.println("connected");
            ArrayList<String> courses = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the course id.");
            String courseId = sc.nextLine();


            recur(courses, courseId, statement);

            System.out.println("The required courses for course with id " + courseId + " are:\n");
            //i=1 because the first item in the array is the class we're finding the prereqs for
            for (int i = 1; i < courses.size(); i++){
                System.out.println(courses.get(i));
            }


        } catch (Exception sqle) {
        }
    }
    public static void recur(ArrayList<String> list, String id, Statement statement){
        ArrayList<String> newCourses = new ArrayList<>();
        try{
            if (!list.contains(id)){
                list.add(id);
            }

            ResultSet rSet = statement.executeQuery("select prereq_id from prereq where course_id = '" + id +"'; ");
            while (rSet.next()){
                newCourses.add(rSet.getString("prereq_id"));
            }
            for (int i = 0; i < newCourses.size(); i++){
                recur(list, newCourses.get(i), statement);
            }
        }
        catch (SQLException sqle) {
        }
    }
}


