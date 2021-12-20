package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

//@SuppressWarnings("ALL")
public class Main {
//    static Scanner sc = new Scanner(System.in);
//    static Statement statement = initDatabase();
//    static String curUser;
//    static String curUserType;



    public static void main(String[] args) throws SQLException{
        Menu menu = new Menu();
        menu.run();
        //System.out.println(statement.executeQuery("select * from prereq;"));


    }





}


