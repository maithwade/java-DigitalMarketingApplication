package ui;

import java.util.Random;
import java.util.Scanner;

import com.github.javafaker.Faker;

import model.ProductManagement.SolutionOfferCatalog;

public final class Helpermethods {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static final String BLACK_BOLD = "\033[1;30m";
  public static final String RED_BOLD = "\033[1;31m";
  public static final String GREEN_BOLD = "\033[1;32m";
  public static final String YELLOW_BOLD = "\033[1;33m";
  public static final String BLUE_BOLD = "\033[1;34m";
  public static final String PURPLE_BOLD = "\033[1;35m";
  public static final String CYAN_BOLD = "\033[1;36m";
  public static final String WHITE_BOLD = "\033[1;37m";

  public static final String BLACK_UNDERLINED = "\033[4;30m";
  public static final String RED_UNDERLINED = "\033[4;31m";
  public static final String GREEN_UNDERLINED = "\033[4;32m";
  public static final String YELLOW_UNDERLINED = "\033[4;33m";
  public static final String BLUE_UNDERLINED = "\033[4;34m";
  public static final String PURPLE_UNDERLINED = "\033[4;35m";
  public static final String CYAN_UNDERLINED = "\033[4;36m";
  public static final String WHITE_UNDERLINED = "\033[4;37m";

  public static void getCustomerOffers(String customerType) {

    if (customerType.equals("Kids")) {
      System.out.println(" ");
      System.out.println(ANSI_GREEN + "1. Upto 10% off on all the products.");
      System.out.println("2. 15% off on the total purchase of 5 products.");
      System.out.println("3. 20% off on the total purchase of more than 8 products.");
      System.out.println("4. Exit" + ANSI_RESET);

      System.out.println("");
      SolutionOfferCatalog soc = new SolutionOfferCatalog();
      soc.configureSolutionOffers(10);
      soc.printSolutionOffers();

      Scanner sc = new Scanner(System.in);
      String input2 = sc.next();
      solutionOffersForKidsSection(input2);
    }

    else if (customerType.equals("Students")) {
      System.out.println(ANSI_GREEN + "1. Upto 15% off on all the products.");
      System.out.println("2. 20% off on the total purchase of more than 5 products.");
      System.out.println("3. Early Access to the End of the Season Sale and more offers upto 30% off on total purchase of more than 10 products.");
      System.out.println("4. Exit" + ANSI_RESET);

      System.out.println("");
      SolutionOfferCatalog soc = new SolutionOfferCatalog();
      soc.configureSolutionOffers(10);
      soc.printSolutionOffers();

      Scanner sc = new Scanner(System.in);
      String input2 = sc.next();
      solutionOffersForStudentsUsers(input2);
    }

    else if (customerType.equals("Professionals")) {
      System.out.println(ANSI_GREEN + "1. Get upto 5% off on all the products. ");
      System.out.println("2. Get upto 15% off on total purchase of more than 4 products.");
      System.out.println("3. Get upto 30% off on total purchase of more than 8 products.");
      System.out.println("4. Exit" + ANSI_RESET);

      System.out.println("");
      SolutionOfferCatalog soc = new SolutionOfferCatalog();
      soc.configureSolutionOffers(10);
      soc.printSolutionOffers();

      Scanner sc = new Scanner(System.in);
      String input2 = sc.next();
      solutionOffersForProfessionalsUsers(input2);
    }
  }

  // creating solution offers for Kids Section
  public static void solutionOffersForKidsSection(String option) {

    if (option.equals("1")) {
      System.out.println("");
      System.out.println(ANSI_GREEN + "You have 10% off on all the products." + ANSI_RESET);
      System.out.println("");
      System.out.println(ANSI_BLUE + "Bundle of Products most suitable for you: " + ANSI_RESET);
      System.out.println("");
      Faker faker = new Faker();
      Random random = new Random();
      System.out.printf("%-92s%n", "-".repeat(92));
      System.out.printf("| %-3s | %-30s | %-35s | %-11s |%n", "No", "Product", "Supplier", "Price");
      System.out.printf("%-92s%n", "-".repeat(92));

      for (int i = 1; i <= 10; i++) {
        String productName = faker.commerce().productName();
        String supplierName = faker.company().name();
        double price = 10 + (100 - 10) * random.nextDouble(); // Random price between 10 and 100

        // Truncate product and supplier names if they exceed the column width
        if (productName.length() > 30) {
          productName = productName.substring(0, 30);
        }
        if (supplierName.length() > 35) {
          supplierName = supplierName.substring(0, 35);
        }

        System.out.printf("| %-3d | %-30s | %-35s | $%-10.2f |%n", i, productName, supplierName, price);

      }
      System.out.printf("%-92s%n", "-".repeat(92)); 
    } 
    
    else if (option.equals("2")) {
      System.out.println("");
      System.out.println(ANSI_GREEN + "You can avail 15% off on the total purchase of 5 products among these products." + ANSI_RESET);
      System.out.println("");
      System.out.println(ANSI_BLUE + "Bundle of Products most suitable for you:" + ANSI_RESET);
      System.out.println("");
      Faker faker = new Faker();
      Random random = new Random();
      System.out.printf("%-92s%n", "-".repeat(92));
      System.out.printf("| %-3s | %-30s | %-35s | %-11s |%n", "No", "Product", "Supplier", "Price");
      System.out.printf("%-92s%n", "-".repeat(92));

      for (int i = 1; i <= 15; i++) {
        String productName = faker.commerce().productName();
        String supplierName = faker.company().name();
        double price = 10 + (100 - 10) * random.nextDouble(); // Random price between 10 and 100

        // Truncate product and supplier names if they exceed the column width
        if (productName.length() > 30) {
          productName = productName.substring(0, 30);
        }
        if (supplierName.length() > 35) {
          supplierName = supplierName.substring(0, 35);
        }

        System.out.printf("| %-3d | %-30s | %-35s | $%-10.2f |%n", i, productName, supplierName, price);

      }
      System.out.printf("%-92s%n", "-".repeat(92));
      
    } 

    else if (option.equals("3")) {
      System.out.println("");
      System.out.println(ANSI_GREEN + "You can avail 20% off on the total purchase of 8 products among these products." + ANSI_RESET);
      System.out.println("");
      System.out.println(ANSI_BLUE + "Bundle of Products most suitable for you:" + ANSI_RESET);
      System.out.println("");
      Faker faker = new Faker();
      Random random = new Random();
      System.out.printf("%-92s%n", "-".repeat(92));
      System.out.printf("| %-3s | %-30s | %-35s | %-11s |%n", "No", "Product", "Supplier", "Price");
      System.out.printf("%-92s%n", "-".repeat(92));

      for (int i = 1; i <= 15; i++) {
        String productName = faker.commerce().productName();
        String supplierName = faker.company().name();
        double price = 10 + (100 - 10) * random.nextDouble(); // Random price between 10 and 100

        // Truncate product and supplier names if they exceed the column width
        if (productName.length() > 30) {
          productName = productName.substring(0, 30);
        }
        if (supplierName.length() > 35) {
          supplierName = supplierName.substring(0, 35);
        }

        System.out.printf("| %-3d | %-30s | %-35s | $%-10.2f |%n", i, productName, supplierName, price);

      }
      System.out.printf("%-92s%n", "-".repeat(92));
      
    } 

    else if (option.equals("4")) {
      System.out.println("Thank you for visiting our store!");
    }
  }

  // creating solution offers for Students Users
  public static void solutionOffersForStudentsUsers(String option) {
    if (option.equals("1")) {
      System.out.println("");
      System.out.println(ANSI_GREEN + "Upto 15% off on all the products." + ANSI_RESET);
      System.out.println("");
      System.out.println(ANSI_BLUE + "Bundle of Products most suitable for you: " + ANSI_RESET);
      System.out.println("");
      Faker faker = new Faker();
      Random random = new Random();
      System.out.printf("%-92s%n", "-".repeat(92));
      System.out.printf("| %-3s | %-30s | %-35s | %-11s |%n", "No", "Product", "Supplier", "Price");
      System.out.printf("%-92s%n", "-".repeat(92));

      for (int i = 1; i <= 10; i++) {
        String productName = faker.commerce().productName();
        String supplierName = faker.company().name();
        double price = 10 + (100 - 10) * random.nextDouble(); // Random price between 10 and 100

        // Truncate product and supplier names if they exceed the column width
        if (productName.length() > 30) {
          productName = productName.substring(0, 30);
        }
        if (supplierName.length() > 35) {
          supplierName = supplierName.substring(0, 35);
        }

        System.out.printf("| %-3d | %-30s | %-35s | $%-10.2f |%n", i, productName, supplierName, price);

      }
      System.out.printf("%-92s%n", "-".repeat(92)); 
      
    } 
    
    else if (option.equals("2")) {
      System.out.println("");
      System.out.println(ANSI_GREEN + "20% off on the total purchase of more than 5 products." + ANSI_RESET);
      System.out.println("");
      System.out.println(ANSI_BLUE + "Bundle of Products most suitable for you: " + ANSI_RESET);
      System.out.println("");
      Faker faker = new Faker();
      Random random = new Random();
      System.out.printf("%-92s%n", "-".repeat(92));
      System.out.printf("| %-3s | %-30s | %-35s | %-11s |%n", "No", "Product", "Supplier", "Price");
      System.out.printf("%-92s%n", "-".repeat(92));

      for (int i = 1; i <= 10; i++) {
        String productName = faker.commerce().productName();
        String supplierName = faker.company().name();
        double price = 10 + (100 - 10) * random.nextDouble(); // Random price between 10 and 100

        // Truncate product and supplier names if they exceed the column width
        if (productName.length() > 30) {
          productName = productName.substring(0, 30);
        }
        if (supplierName.length() > 35) {
          supplierName = supplierName.substring(0, 35);
        }

        System.out.printf("| %-3d | %-30s | %-35s | $%-10.2f |%n", i, productName, supplierName, price);

      }
      System.out.printf("%-92s%n", "-".repeat(92));     
         
    }

    else if (option.equals("3")) {
      System.out.println("");
      System.out.println(ANSI_GREEN + "Early Access to the End of the Season Sale and more offers upto 30% off on total purchase of more than 10 products." + ANSI_RESET);
      System.out.println("");
      System.out.println(ANSI_BLUE + "Bundle of Products most suitable for you:" + ANSI_RESET);
      System.out.println("");
      Faker faker = new Faker();
      Random random = new Random();
      System.out.printf("%-92s%n", "-".repeat(92));
      System.out.printf("| %-3s | %-30s | %-35s | %-11s |%n", "No", "Product", "Supplier", "Price");
      System.out.printf("%-92s%n", "-".repeat(92));

      for (int i = 1; i <= 15; i++) {
        String productName = faker.commerce().productName();
        String supplierName = faker.company().name();
        double price = 10 + (100 - 10) * random.nextDouble(); // Random price between 10 and 100

        // Truncate product and supplier names if they exceed the column width
        if (productName.length() > 30) {
          productName = productName.substring(0, 30);
        }
        if (supplierName.length() > 35) {
          supplierName = supplierName.substring(0, 35);
        }

        System.out.printf("| %-3d | %-30s | %-35s | $%-10.2f |%n", i, productName, supplierName, price);

      }
      System.out.printf("%-92s%n", "-".repeat(92));
          
    }
      
      else if (option.equals("4")) {
        System.out.println("Thank you for visiting our store!");
      }
  }

  // creating solution offers for professionals
  public static void solutionOffersForProfessionalsUsers(String option) {
    System.out.println("");
    if (option.equals("1")) {
      System.out.println("");
      System.out.println(ANSI_GREEN + "Get upto 5% off on selected products." + ANSI_RESET);
      System.out.println(ANSI_BLUE + "Bundle of Products most suitable for you:" + ANSI_RESET);
      System.out.println("");
      Faker faker = new Faker();
      Random random = new Random();
      System.out.printf("%-92s%n", "-".repeat(92));
      System.out.printf("| %-3s | %-30s | %-35s | %-11s |%n", "No", "Product", "Supplier", "Price");
      System.out.printf("%-92s%n", "-".repeat(92));

      for (int i = 1; i <= 15; i++) {
        String productName = faker.commerce().productName();
        String supplierName = faker.company().name();
        double price = 10 + (100 - 10) * random.nextDouble(); // Random price between 10 and 100

        // Truncate product and supplier names if they exceed the column width
        if (productName.length() > 30) {
          productName = productName.substring(0, 30);
        }
        if (supplierName.length() > 35) {
          supplierName = supplierName.substring(0, 35);
        }

        System.out.printf("| %-3d | %-30s | %-35s | $%-10.2f |%n", i, productName, supplierName, price);
      }
      System.out.printf("%-92s%n", "-".repeat(92));
      
    } 
    
    else if (option.equals("2")) {
      System.out.println("");
      System.out.println(ANSI_GREEN + "Get upto 15% off on total purchase of more than 4 products."+ ANSI_RESET);
      System.out.println("");
      System.out.println(ANSI_BLUE + "Bundle of Products most suitable for you:" + ANSI_RESET);
      System.out.println("");
      Faker faker = new Faker();
      Random random = new Random();
      System.out.printf("%-92s%n", "-".repeat(92));
      System.out.printf("| %-3s | %-30s | %-35s | %-11s |%n", "No", "Product", "Supplier", "Price");
      System.out.printf("%-92s%n", "-".repeat(92));

      for (int i = 1; i <= 15; i++) {
        String productName = faker.commerce().productName();
        String supplierName = faker.company().name();
        double price = 10 + (100 - 10) * random.nextDouble(); // Random price between 10 and 100

        // Truncate product and supplier names if they exceed the column width
        if (productName.length() > 30) {
          productName = productName.substring(0, 30);
        }
        if (supplierName.length() > 35) {
          supplierName = supplierName.substring(0, 35);
        }

        System.out.printf("| %-3d | %-30s | %-35s | $%-10.2f |%n", i, productName, supplierName, price);

      }
      System.out.printf("%-92s%n", "-".repeat(92));
          
    } 


    else if (option.equals("3")) {
      System.out.println("");
      System.out.println(ANSI_GREEN + "Get upto 30% off on total purchase of more than 8 products."+ ANSI_RESET);
      System.out.println("");
      System.out.println(ANSI_BLUE + "Bundle of Products most suitable for you:" + ANSI_RESET);
      System.out.println("");
      Faker faker = new Faker();
      Random random = new Random();
      System.out.printf("%-92s%n", "-".repeat(92));
      System.out.printf("| %-3s | %-30s | %-35s | %-11s |%n", "No", "Product", "Supplier", "Price");
      System.out.printf("%-92s%n", "-".repeat(92));

      for (int i = 1; i <= 15; i++) {
        String productName = faker.commerce().productName();
        String supplierName = faker.company().name();
        double price = 10 + (100 - 10) * random.nextDouble(); // Random price between 10 and 100

        // Truncate product and supplier names if they exceed the column width
        if (productName.length() > 30) {
          productName = productName.substring(0, 30);
        }
        if (supplierName.length() > 35) {
          supplierName = supplierName.substring(0, 35);
        }

        System.out.printf("| %-3d | %-30s | %-35s | $%-10.2f |%n", i, productName, supplierName, price);

      }
      System.out.printf("%-92s%n", "-".repeat(92));    
    }

  }

  public static int getRandom(int lower, int upper) {
    Random r = new Random();

    // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
    // numbers from 10 to 15
    // I will have result = 10 + nextInt(5)
    int randomInt = lower + r.nextInt(upper - lower);
    return randomInt;
  }

}

