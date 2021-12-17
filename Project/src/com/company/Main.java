package com.company;
import java.util.Scanner;

public class Main {
    Scanner sc= new Scanner(System.in);

    public void main(String[] args) {
        System.out.println("Welcome to the bookstore database program. Please choose one of the following options:");
        System.out.println("1: Login \n 2: Sign up\n 3: View the store\n 3: Exit");

        login();
        printMenu();


    }

    void printMenu(){
        //if the user is a normal user
        printBaseUserMenu();
        //if the user is an admin
        printAdminmenu();

    }

    void printNotUserMenu(){
        int result = 0;
        while(true){
            switch (result){
                case 1:
                    printBookMenu();
                case 2:
                    //add a login at the end


            }

        }
    }

    void printBaseUserMenu(){
        int result = 0;
        while(true){
            switch (result){
                case 1:
                    printBookMenu();
                case 2:



            }

        }
    }

    void printAdminMenu(){
        int result = 0;
        while(true){
            switch (result){
                case 1:

            }

        }

    }

    void printBookMenu(){
        //need to be able to add books to basked
    }



}

