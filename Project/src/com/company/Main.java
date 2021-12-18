package com.company;
import java.util.Scanner;

//@SuppressWarnings("ALL")
public class Main {
    Scanner sc= new Scanner(System.in);
    String curUser;
    String curUserType;

    public void main(String[] args) {

        printMainMenu();


    }

    void printMainMenu(){
        System.out.println("Welcome to the bookstore database program. Please choose one of the following options:");
        System.out.println("1: Login \n 2: Sign up\n 3: View the store\n 0: Exit");
        int result = sc.nextInt();
        boolean loop = true;
        while (loop){
            switch (result){
                case 1:
                    login();
                    loop = false;
                    break;
                case 2:
                    signUp();
                    loop = false;
                    break;
                case 3:
                    viewStore();
                    loop = false;
                    break;
                case 0:
                    System.exit(0);;
                default:
                    System.out.println("You have entered an invalid choice. Please try again.");
            }
        }
    }

    void printUserMenu(){
        if (curUserType == "normal"){
            printNormalUserMenu();
        }else if (curUserType == "owner"){
            printAdminMenu();
        } else{
            printNotUserMenu();
        }
    }

    void printNotUserMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("1: View books \n 2: View current basket\n 3: Login\n 4: Sign Up\n 0: Exit");
        int result = sc.nextInt();
        boolean loop = true;
        while (loop){
            switch (result){
                case 1:
                    printBookMenu();
                    loop = false;
                    break;
                case 2:
                    printBasketMenu();
                    loop = false;
                    break;
                case 3:
                    login();
                    loop = false;
                    break;
                case 4:
                    signUp();
                    loop = false;
                    break;
                case 0:
                    System.exit(0);;
                default:
                    System.out.println("You have entered an invalid choice. Please try again.");
            }
        }
    }



    void printNormalUserMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("1: View books \n 2: View current basket\n 3: Track an Order\n 4: Logout\n 0: Exit");
        int result = sc.nextInt();
        boolean loop = true;
        while (loop){
            switch (result){
                case 1:
                    printBookMenu();
                    loop = false;
                    break;
                case 2:
                    printBasketMenu();
                    loop = false;
                    break;
                case 3:
                    trackOrder();
                    loop = false;
                    break;
                case 4:
                    logOut();
                    loop = false;
                    break;
                case 0:
                    System.exit(0);;
                default:
                    System.out.println("You have entered an invalid choice. Please try again.");
            }
        }
    }

    void printAdminMenu(){
        System.out.println("Please choose one of the following options:");
        System.out.println("1: View books \n 2: Add a book to the database \n 3: Remove a book from the database\n " +
                           "4: View publishers\n 5:Generate a Report\n 6: Track an Order\n 7: Logout\n 0: Exit");
        int result = sc.nextInt();
        boolean loop = true;
        while (loop){
            switch (result){
                case 1:
                    printBookMenu();
                    loop = false;
                    break;
                case 2:
                    addBook();
                    loop = false;
                    break;
                case 3:
                    removeBook();
                    loop = false;
                    break;
                case 4:
                    viewPublishers();
                    loop = false;
                    break;
                case 5:
                    printReportMenu();
                    loop = false;
                    break;
                case 6:
                    trackOrder();
                    loop = false;
                    break;
                case 7:
                    logOut();
                    loop = false;
                    break;
                case 0:
                    System.exit(0);;
                default:
                    System.out.println("You have entered an invalid choice. Please try again.");
            }
        }
    }

    void printBookMenu(){
        System.out.println("You are now in the Book Menu. Please choose one of the following options:");
        System.out.println("1: View all books \n 2: Find boobs by name  \n 3: Find books by author\n " +
                "4: Find books by price\n 5: Find books by publisher\n  6: Find books by number of pages\n  " +
                "7: Find books by ISBN\n 8: Find books by genre 0: Exit");
        int result = sc.nextInt();
        boolean loop = true;
        while (loop){
            switch (result){
                case 1:
                    printAllBooks();
                    loop = false;
                    break;
                case 2:
                    printBooksByName();
                    loop = false;
                    break;
                case 3:
                    printBooksByAuthor();
                    loop = false;
                    break;
                case 4:
                    printBooksByPrice();
                    loop = false;
                    break;
                case 5:
                    printBooksByPublisher();
                    loop = false;
                    break;
                case 6:
                    printBooksByNumberOfPages();
                    loop = false;
                    break;
                case 7:
                    printBooksByISBN();
                    loop = false;
                    break;
                case 8:
                    printBooksByGenre();
                    loop = false;
                    break;
                case 0:
                    System.exit(0);;
                default:
                    System.out.println("You have entered an invalid choice. Please try again.");
            }
        }
    }

    void printBasketMenu(){
        System.out.println("You are now in your checkout basket. Here are the current books in your basket:\n");
        printCheckoutBasket();
        System.out.println("Please choose one of the following options:");
        System.out.println("1: Remove a book from the basket\n 2: Change the amount of a book in the basket\n" +
                            " 3: Checkout\n 0: Exit");
        int result = sc.nextInt();
        boolean loop = true;
        while (loop){
            switch (result){
                case 1:
                    removeBookFromBasket;
                    loop = false;
                    break;
                case 2:
                    changeBookAmountInBasket();
                    loop = false;
                    break;
                case 3:
                    checkout();
                    loop = false;
                    break;
                case 0:
                    System.exit(0);;
                default:
                    System.out.println("You have entered an invalid choice. Please try again.");
            }
        }
    }

    void printReportMenu(){
        System.out.println("You are now in the report menu. Please choose which type of report you would like to generate:");
        System.out.println("1: Sales vs Expenditures\n 2: Sales per Genre\n 3: Sales per Author\n " +
                           "4: Sales per Publisher\n 0: Exit");
        int result = sc.nextInt();
        boolean loop = true;
        while (loop){
            switch (result){
                case 1:
                    generateExpendituresReport;
                    loop = false;
                    break;
                case 2:
                    generateGenreReport();
                    loop = false;
                    break;
                case 3:
                    generateAuthorReport();
                    loop = false;
                    break;
                case 4:
                    generatePublisherReport();
                    loop = false;
                    break;
                case 0:
                    System.exit(0);;
                default:
                    System.out.println("You have entered an invalid choice. Please try again.");
            }
        }
    }

    void login(){
        System.out.println("Please enter your username:");
        String username = sc.nextLine();
        System.out.println("Please enter your password:");
        String password = sc.nextLine();
        //add a query that checks to see if the user is in the database.
            //If yes, proceed to the usermenu.
            //If no, say it's not registered and as them if they wanna try again or login instead or proceed without logging in

    }

    void signUp(){
        System.out.println("Please enter your username:");
        String username = sc.nextLine();
        System.out.println("Please enter your password:");
        String password = sc.nextLine();
        //add a query that checks if the username is already chosen
        //if not, the user will be added to the database.
        //proceed to the usermenu

    }


}

