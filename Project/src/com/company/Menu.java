package com.company;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Menu {
    Scanner sc = new Scanner(System.in);
    String curUser;
    String curUserType;
    String url = "jdbc:postgresql://localhost:5432/postgres";
    int curInfoID = 104;
    int curOrderNum = 1004;

    public void run() throws SQLException{
        printMainMenu();
        //callDatabase("select * from book;");
    }


    void printMainMenu(){
        boolean loop = true;
        while (loop){
            System.out.println("Welcome to the bookstore database program. Please choose one of the following options:");
            System.out.println("1: Login \n 2: Sign up\n 3: View the store\n 0: Exit");
            int result = sc.nextInt();
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
                    printUserMenu();
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
        if (curUserType.equals("normal")){
            printNormalUserMenu();
        }else if (curUserType.equals("admin")){
            printAdminMenu();
        } else{
            printNotUserMenu();
        }
    }

    void printNotUserMenu(){
        boolean loop = true;
        while (loop){
            System.out.println("Please choose one of the following options:");
            System.out.println("1: View books \n 2: View current basket\n 3: Login\n 4: Sign Up\n 0: Exit");
            int result = sc.nextInt();
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
                    System.exit(0);
                default:
                    System.out.println("You have entered an invalid choice. Please try again.");
            }
        }
        printMainMenu();
    }



    void printNormalUserMenu(){
        boolean loop = true;
        while (loop){
            System.out.println("Please choose one of the following options:");
            System.out.println("1: View books \n 2: View current basket\n 3: Track an Order\n 4: Logout\n 0: Exit");
            int result = sc.nextInt();
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
        printMainMenu();
    }

    void printAdminMenu(){
        boolean loop = true;
        while (loop){
            System.out.println("Please choose one of the following options:");
            System.out.println("1: View books \n 2: Add a book to the database \n 3: Remove a book from the database\n " +
                    "4: View publishers\n 5: Generate a Report\n 6: Track an Order\n 7: Logout\n 0: Exit");
            int result = sc.nextInt();
            sc.nextLine();
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
        printUserMenu();
    }

    void printBookMenu(){
        boolean loop = true;
        while (loop){
            System.out.println("You are now in the Book Menu. Please choose one of the following options:");
            System.out.println("1: View all books \n 2: Find books by Title  \n 3: Find books by author\n " +
                    "4: Find books by price\n 5: Find books by publisher\n  6: Find books by number of pages\n  " +
                    "7: Find books by ISBN\n 8: Find books by genre\n 0: Exit");
            int result = sc.nextInt();
            sc.nextLine();
            switch (result){
                case 1:
                    printAllBooks();
                    loop = false;
                    break;
                case 2:
                    printBooksByTitle();
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
        printUserMenu();
    }

    void printBasketMenu(){
        boolean loop = true;
        while (loop){
            System.out.println("You are now in your checkout basket. Here are the current books in your basket:\n");
            printCheckoutBasket();
            System.out.println("Please choose one of the following options:");
            System.out.println("1: Remove a book from the basket\n 2: Change the amount of a book in the basket\n" +
                    " 3: Checkout\n 0: Exit");
            int result = sc.nextInt();
            switch (result){
                case 1:
                    removeBookFromBasket();
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
        printUserMenu();
    }

    void printReportMenu(){
        boolean loop = true;
        while (loop){
            System.out.println("You are now in the report menu. Please choose which type of report you would like to generate:");
            System.out.println("1: Sales vs Expenditures\n 2: Sales per Genre\n 3: Sales per Author\n " +
                    "4: Sales per Publisher\n 0: Exit");
            int result = sc.nextInt();
            sc.nextLine();
            switch (result){
                case 1:
                    generateExpendituresReport();
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
        printUserMenu();
    }

    void login(){
        sc.nextLine();
        System.out.println("Please enter your username:");
        String username = sc.nextLine();
        System.out.println("Please enter your password:");
        String password = sc.nextLine();


        //add a query that checks to see if the user is in the database.
        //If yes, proceed to the usermenu.
        //If no, say it's not registered and as them if they wanna try again or login instead or proceed without logging in

        try (Connection connection = DriverManager.getConnection(url, "postgres", "4aq!cKeAS9ncRkyj");
             Statement statement = connection.createStatement();
        )
        {
            ResultSet rSet = statement.executeQuery("select username, password, type from db_user where username = '" + username + "';");
            rSet.next();
            if (rSet.getString("password").equals(password)){
                curUser = username;
                curUserType = rSet.getString("type");
                System.out.println("login successful");
                printUserMenu();
            }else {
                System.out.println("You have entered the wrong username/password combination.");
                printMainMenu();
            }

        }catch (Exception sqle) {
            System.out.println(sqle);
        }

    }

    void signUp(){
        System.out.println("Please enter your username:");
        String username = sc.nextLine();
        System.out.println("Please enter your password:");
        String password = sc.nextLine();
        System.out.println("\n Shipping information:\n");
        System.out.println("Please enter your name.");
        String name = sc.nextLine();
        System.out.println("Please enter your street");
        String street = sc.nextLine();
        System.out.println("Please enter your city");
        String city = sc.nextLine();
        System.out.println("Please enter your province");
        String province = sc.nextLine();
        System.out.println("Please enter your country");
        String country = sc.nextLine();
        System.out.println("Please enter your postal code");
        String postalCode = sc.nextLine();


        //add a query that checks if the username is already chosen
        //if not, the user will be added to the database.
        //proceed to the usermenu




        try (Connection connection = DriverManager.getConnection(url, "postgres", "4aq!cKeAS9ncRkyj");
             Statement statement = connection.createStatement();
        )
        {
            System.out.println("connected");
            ResultSet rSet = statement.executeQuery("select username from db_user where username = '" + username + "';");
            rSet.last();





            if (rSet.getRow() >= 1){
                System.out.println("the user already exists in the database. Please try again with a different username.");
            }else {

                statement.executeQuery("insert into db_info values ('" + curInfoID++ + "', '" + name + "', '" +
                        street + "', '" + city + "', '" + province + "', '" + country + ", '" + postalCode + "');");

                System.out.println("Would you line to your shipping and billing addresses to be the same? (enter the character 'y' if yes)");
                String answer = sc.nextLine();
                if (!answer.equals("y")) {
                    System.out.println("Billing information:\n");

                    System.out.println("Please enter your name.");
                    String name1 = sc.nextLine();
                    System.out.println("Please enter your street");
                    String street1 = sc.nextLine();
                    System.out.println("Please enter your city");
                    String city1 = sc.nextLine();
                    System.out.println("Please enter your province");
                    String province1 = sc.nextLine();
                    System.out.println("Please enter your country");
                    String country1 = sc.nextLine();
                    System.out.println("Please enter your postal code");
                    String postalCode1 = sc.nextLine();


                    statement.executeQuery("insert into db_info values ('" + curInfoID++ + "', '" + name1 + "', '" +
                            street1 + "', '" + city1 + "', '" + province1 + "', '" + country1 + ", '" + postalCode1 + "');");


                    statement.executeQuery("insert into db_user values ('" + username + "',' " + password +
                            "', 'normal', '" + (curInfoID - 1) + "', '" + curInfoID + ", null);");

                } else {

                    statement.executeQuery("insert into db_user values ('" + username + "',' " + password +
                            "', 'normal', '" + curInfoID + "', '" + curInfoID + ", null);");

                }

            }

        } catch (Exception sqle) {
            System.out.println(sqle);
        }

    }

    void logOut(){
        curUser = curUserType = "";
        printMainMenu();
    }

    void trackOrder(){


    }

    void addBook(){
        System.out.println("Please enter the ISBN of the book you would like to add to the database:");
        String ISBN = sc.nextLine();
        System.out.println("Please enter the Title of the book you would like to add to the database:");
        String title = sc.nextLine();
        System.out.println("Please enter the Author of the book you would like to add to the database:");
        String author = sc.nextLine();
        System.out.println("Please enter the Publisher of the book you would like to add to the database:");
        String publisher = sc.nextLine();
        System.out.println("Please enter the Genre of the book you would like to add to the database:");
        String genre = sc.nextLine();
        System.out.println("Please enter the number of pages of the book you would like to add to the database:");
        String numPages = sc.nextLine();
        System.out.println("Please enter the price of the book you would like to add to the database:");
        String price = sc.nextLine();
        System.out.println("Please enter the supplier's price of the book you would like to add to the database:");
        String sPrice = sc.nextLine();
        System.out.println("Please enter the percentage of the profit the publisher will receive of the book you would like to add to the database:");
        String profit = sc.nextLine();
        System.out.println("Please enter the current stock of the book you would like to add to the database:");
        String stock = sc.nextLine();

        try (Connection connection = DriverManager.getConnection(url, "postgres", "4aq!cKeAS9ncRkyj");
             Statement statement = connection.createStatement();
        )
        {
          statement.executeUpdate("INSERT INTO book VALUES (" + ISBN + ", '" + title + "', '" + author + "', '"
                                                                   + publisher + "', '" + genre + "', " + numPages +
                                                                                  ", " + price + ", " + sPrice + ", " + profit + ", " +
                                                                    stock + ");");
            System.out.println("Book has been successfully added.");

        } catch (Exception sqle) {
            System.out.println(sqle);
        }

    }

    void removeBook(){
        System.out.println("Please enter the ISBN of the book you would like to remove from the database.");
        String ISBN = sc.nextLine();
        try (Connection connection = DriverManager.getConnection(url, "postgres", "4aq!cKeAS9ncRkyj");
             Statement statement = connection.createStatement();
        )
        {
            statement.executeUpdate("DELETE FROM book WHERE ISBN = '" + ISBN + "';");

        } catch (Exception sqle) {
            System.out.println(sqle);
        }
    }

    void viewPublishers(){
        callDatabase("select * from publisher;");
    }

    void printAllBooks(){
        callDatabase("select * from book;");
    }

    void printBooksByTitle(){
        System.out.println("Please enter the title of the book you would like to find:");
        String input = sc.nextLine();
        callDatabase("select * from book where title = '" + input +"';");
    }

    void printBooksByAuthor(){
        System.out.println("Please enter the Author of the book you would like to find:");
        String input = sc.nextLine();
        callDatabase("select * from book where author_name = '" + input +"';");
    }

    void printBooksByPrice(){
        System.out.println("Please enter the minimum price of the book you would like to find:");
        float min = sc.nextFloat();
        System.out.println("Please enter the maximum price of the book you would like to find:");
        float max = sc.nextFloat();
        callDatabase("select * from book where price > " + min +" AND price < " + max + ";");
    }

    void printBooksByPublisher(){
        System.out.println("Please enter the Publisher of the book you would like to find:");
        String input = sc.nextLine();
        callDatabase("select * from book where publisher = '" + input +"';");
    }

    void printBooksByNumberOfPages(){
        System.out.println("Please enter the minimum number of pages of the book you would like to find:");
        float min = sc.nextFloat();
        System.out.println("Please enter the maximum number of pages of the book you would like to find:");
        float max = sc.nextFloat();
        callDatabase("select * from book where num_pages > " + min +" AND num_pages < " + max + ";");
    }

    void printBooksByISBN(){
        System.out.println("Please enter the ISBN of the book you would like to find:");
        String input = sc.nextLine();
        callDatabase("select * from book where ISBN = '" + input +"';");
    }

    void printBooksByGenre(){
        System.out.println("Please enter the Genre of the book you would like to find:");
        String input = sc.nextLine();
        callDatabase("select * from book where genre = '" + input +"';");
    }

    void printCheckoutBasket(){
        callDatabase("select book.ISBN, title, author_name, genre, num_pages, price from (db_user inner join basketed_book ON basketed_book.ID = db_user.checkout_basket) right outer join book ON basketed_book.isbn = book.isbn where username = '" + curUser +"';");
    }

    //may omit this
    void changeBookAmountInBasket(){

    }

    //
    void removeBookFromBasket(){
        System.out.println("Please enter the ISBN of the book you would like to delete:");
        sc.nextLine();
        String ISBN = sc.nextLine();
        try (Connection connection = DriverManager.getConnection(url, "postgres", "4aq!cKeAS9ncRkyj");
             Statement statement = connection.createStatement();
        )
        {
            ResultSet rSet = statement.executeQuery("select checkout_basket, isbn, amount from (db_user full outer join basketed_book ON db_user.checkout_basket = basketed_book.ID) where username = '" + curUser + "' AND ISBN = '" + ISBN + "';");
            rSet.next();
            statement.executeUpdate("DELETE FROM basketed_book Where ID = '" + rSet.getString(1) + "' AND ISBN = '" + rSet.getString(2) + "' AND amount = '" + rSet.getString(3) + "';");

            System.out.println("Successfully deleted");
            printUserMenu();
        } catch (Exception sqle) {
            System.out.println(sqle);
        }
    }

    void checkout(){
        try (Connection connection = DriverManager.getConnection(url, "postgres", "4aq!cKeAS9ncRkyj");
             Statement statement = connection.createStatement();
        )
        {
            ResultSet rSet = statement.executeQuery("select isbn, amount, checkout_session.shipping_info, checkout_session.billing_info from (checkout_session natural join basketed_book) inner join db_user ON checkout_session.ID = db_user.checkout_basket where username = '" + curUser + "';");
            rSet.next();
            statement.executeUpdate("insert into db_order values ('" + curOrderNum++ + "', null, '" + rSet.getString("shipping_info") + "', '" + rSet.getString("shipping_info") + "');");

            do  {
                statement.executeUpdate("insert into ordered_book values ('" + (curOrderNum - 1) + "', '" + rSet.getString("isbn") + "', '" + rSet.getString("amount") +"');");
            }while (rSet.next());
            System.out.println("Successfully checked out!");
            printUserMenu();
        } catch (Exception sqle) {
            System.out.println(sqle);
        }
    }

    void generateExpendituresReport() {
        generateReport("Expenditures");
    }

    void generateGenreReport(){
        generateReport("Genre");
    }

    void generateAuthorReport(){
        generateReport("Author");
    }

    void generatePublisherReport(){
        generateReport("Publisher");
    }

    void generateReport(String type){
        System.out.println("What is the starting date the report should be run for? (enter in yyyy-MM-dd format or the program will break.)");
        String startDate = sc.nextLine();
        //Date startDate = Date.valueOf(sc.nextLine());
        System.out.println("What is the ending date the report should be run for? (enter in yyyy-MM-dd format or the program will break.)");
        String endDate = sc.nextLine();
        //Date endDate = Date.valueOf(sc.nextLine());

        try (Connection connection = DriverManager.getConnection(url, "postgres", "4aq!cKeAS9ncRkyj");
             Statement statement = connection.createStatement();
        )
        {
            System.out.println("connected");
            if (type.equals("Expenditures")){
                ResultSet rSet = statement.executeQuery("select amount, price, profit_percentage from (book natural join sale) where sale_date > '" + startDate + "' AND sale_date < '" + endDate + "';");
                float totalProfit = 0;
                while (rSet.next()){
                    totalProfit += (rSet.getFloat("price") * rSet.getFloat("profit_percentage") * rSet.getFloat("amount"));
                }

                rSet = statement.executeQuery("select amount, supplier_price from (book natural join expenditure) where expenditure_date > '" + startDate + "' AND expenditure_date < '" + endDate + "';");
                float totalExpenditures = 0;
                while (rSet.next()) {
                    totalExpenditures += (rSet.getFloat("amount") * rSet.getFloat("supplier_price"));
                }

                System.out.println("Total Profit: " + totalProfit);
                System.out.println("Total Expenditures: " + totalExpenditures);
            } else if (type.equals("Genre")){
                ResultSet rSet = statement.executeQuery("select distinct genre from book;");
                ArrayList<String> genres = new ArrayList<>();
                while (rSet.next()){
                    genres.add(rSet.getString("genre"));
                }

                for (String genre : genres) {
                    int numSales = 0;
                    float salesValue = 0;

                    rSet = statement.executeQuery("select amount, price from sale natural join book where sale_date > '" + startDate + "' AND sale_date < '" + endDate + "' AND genre = '" + genre + "';");

                    while (rSet.next()) {
                        salesValue += rSet.getFloat("price") * rSet.getInt("amount");
                        numSales += rSet.getInt("amount");
                    }
                    System.out.println("There were " + numSales + " sales in the " + genre + " genre for a total of " + salesValue + "$.");
                }
            } else if (type.equals("Author")){
                ResultSet rSet = statement.executeQuery("select distinct author_name from book;");
                ArrayList<String> authors = new ArrayList<>();
                while (rSet.next()) {
                    authors.add(rSet.getString("author_name"));
                }

                for (String author : authors) {
                    int numSales = 0;
                    float salesValue = 0;

                    rSet = statement.executeQuery("select amount, price from sale natural join book where sale_date > '" + startDate + "' and sale_date < '" + endDate + "' and author_name = '" + author + "';");

                    while (rSet.next()) {
                        salesValue += rSet.getFloat("price") * rSet.getInt("amount");
                        numSales += rSet.getInt("amount");
                    }
                    System.out.println("There were " + numSales + " sales by the author " + author + " for a total of " + salesValue + "$.");
                }
            } else if (type.equals("Publisher")) {
                ResultSet rSet = statement.executeQuery("select distinct publisher from book;");
                ArrayList<String> publishers = new ArrayList<>();
                while (rSet.next()) {
                    publishers.add(rSet.getString("publisher"));
                }

                for (String publisher : publishers) {
                    int numSales = 0;
                    float salesValue = 0;

                    rSet = statement.executeQuery("select amount, price from sale natural join book where sale_date > '" + startDate + "' and sale_date < '" + endDate + "' and publisher = '" + publisher + "';");

                    while (rSet.next()) {
                        salesValue += rSet.getFloat("price") * rSet.getInt("amount");
                        numSales += rSet.getInt("amount");
                    }
                    System.out.println("There were " + numSales + " sales by the publisher " + publisher + " for a total of " + salesValue + "$.");
                }
            }



        } catch (Exception sqle) {
            System.out.println(sqle);
        }



    }



    public void callDatabase(String query){
        try (Connection connection = DriverManager.getConnection(url, "postgres", "4aq!cKeAS9ncRkyj");
             Statement statement = connection.createStatement();
        )
        {
            System.out.println("connected");
            ResultSet rSet = statement.executeQuery(query);

            ResultSetMetaData MetaData= rSet.getMetaData();
            int numCols = MetaData.getColumnCount();

            String colInfo = "";

            for (int i = 1; i <= numCols; i++){
                colInfo += MetaData.getColumnName(i);
                if (i < numCols){
                    colInfo += ", ";
                }
            }
            System.out.println(colInfo);


            while (rSet.next()){
                colInfo = "";
                for (int i = 1; i <= numCols; i++){
                    colInfo += rSet.getString(i);
                    if (i < numCols){
                        colInfo += ", ";
                    }
                }
                System.out.println(colInfo);
            }

        } catch (Exception sqle) {
            System.out.println(sqle);
        }
    }
}
