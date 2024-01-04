/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

import javax.security.auth.login.AccountException;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.Personnel.Profile;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOfferCatalog;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccount;
import model.UserAccountManagement.UserAccountDirectory;
import ui.Helpermethods;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here

    // 1. Populate the model +

    Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Business", 50, 40, 40, 40, 20);

    SupplierDirectory sd = business.getSupplierDirectory();

    MasterOrderList mol = business.getMasterOrderList();
    MasterOrderReport orderReport = mol.generateMasterOrderReport();
    //mol.generateSalesByMarketChannelReport();
    // orderReport.printOrderReport();
    // 2. Maybe some interaction with the user (optional).

    // Creating account for the user interaction part
    Scanner ui = new Scanner(System.in);

    boolean exit = false;

    while (!exit) {
      System.out.println(" ");
      System.out.println(
          Helpermethods.YELLOW_UNDERLINED + "Welcome to the Digital Marketing Application." + Helpermethods.ANSI_RESET);
      System.out.println(" ");
      System.out.println("1. Create a new Account");
      System.out.println("2. Already have an account? Login.");
      System.out.println("3. Exit");

      String input = ui.next();

      if (input.equals("1")) { // this entire code block takes the details of the new user.
        System.out.println(" ");
        System.out
            .println(Helpermethods.ANSI_BLUE + "Enter your details to create an account." + Helpermethods.ANSI_RESET);
        System.out.println(" ");
        System.out.println("Enter your first name: ");
        String firstName = ui.next();
        System.out.println("Enter your last name: ");
        String lastName = ui.next();
        System.out.println("Enter your email: ");
        String email = ui.next();
        System.out.println("Enter your password: ");
        String password = ui.next();

        // adding the user details to the business
        Faker faker = new Faker();
        IdNumber id = faker.idNumber();
        PersonDirectory pd = business.getPersonDirectory();
        Person person = pd.newPerson(id.toString(), firstName, lastName, email);

        // creating the profile for the person
        Profile p = new Profile(person) {
          @Override
          public String getRole() {
            return "Customer";
          }
        };

        // creating the user account for the person
        UserAccountDirectory uad = business.getUserAccountDirectory();
        UserAccount account = uad.newUserAccount(p, email, password);
        System.out.println(" ");
        System.out.println(
            Helpermethods.ANSI_PURPLE + "Your account has been created successfully." + Helpermethods.ANSI_RESET);
        System.out.println(" ");

        // creating block of code to get more details about the user type and offer them
        // solution offers
        Scanner customerType = new Scanner(System.in);

        boolean exitCode1 = false;

        while (!exitCode1) {
          System.out
              .println(Helpermethods.ANSI_BLUE + "Select how do you want to continue." + Helpermethods.ANSI_RESET);
          System.out.println(" ");
          System.out.println("1. Kids");
          System.out.println("2. Students");
          System.out.println("3. Professionals");

          String input1 = customerType.next();

          // saving the customer type in the profile
          if (input1.equals("1")) {
            p.setCustomerType("Kids");
          } else if (input1.equals("2")) {
            p.setCustomerType("Students");
          } else if (input1.equals("3")) {
            p.setCustomerType("Professionals");
          }

          else {
            System.out.println(Helpermethods.RED_BOLD + "Invalid input. Please try again." + Helpermethods.ANSI_RESET);
          }
          exitCode1 = true;

          // printing the customer type

          Scanner advertisingChannels = new Scanner(System.in);

          System.out.println(" ");
          System.out.println(Helpermethods.ANSI_PURPLE + "You have selected " + Helpermethods.ANSI_RESET
              + Helpermethods.PURPLE_UNDERLINED + p.getCustomerType() + Helpermethods.ANSI_RESET
              + Helpermethods.ANSI_PURPLE + " as your customer type." + Helpermethods.ANSI_RESET);
          System.out.println(" ");
          System.out.println(Helpermethods.ANSI_BLUE + "How did you hear about us?" + Helpermethods.ANSI_RESET);
          System.out.println(" ");
          System.out.println("1. Youtube");
          System.out.println("2. Instagram");
          System.out.println("3. Facebook");
          System.out.println("4. Twitter");
          System.out.println("5. Google");

          String input3 = advertisingChannels.next();

          if (input3.equals("1")) {
            p.setChannel("Youtube");
            System.out.println(" ");
            System.out.println(Helpermethods.ANSI_PURPLE + "Oh! you are here from " + Helpermethods.ANSI_RESET
                + Helpermethods.PURPLE_UNDERLINED + p.getChannel() + Helpermethods.ANSI_RESET
                + Helpermethods.ANSI_PURPLE + "." + Helpermethods.ANSI_RESET);
            System.out.println(" ");
          } else if (input3.equals("2")) {
            p.setChannel("Instagram");
            System.out.println(" ");
            System.out.println(Helpermethods.ANSI_PURPLE + "Oh! you are here from " + Helpermethods.ANSI_RESET
                + Helpermethods.PURPLE_UNDERLINED + p.getChannel() + Helpermethods.ANSI_RESET
                + Helpermethods.ANSI_PURPLE + "." + Helpermethods.ANSI_RESET);
            System.out.println(" ");
          } else if (input3.equals("3")) {
            p.setChannel("Facebook");
            System.out.println(" ");
            System.out.println(Helpermethods.ANSI_PURPLE + "Oh! you are here from " + Helpermethods.ANSI_RESET
                + Helpermethods.PURPLE_UNDERLINED + p.getChannel() + Helpermethods.ANSI_RESET
                + Helpermethods.ANSI_PURPLE + "." + Helpermethods.ANSI_RESET);
            System.out.println(" ");
          } else if (input3.equals("4")) {
            p.setChannel("Twitter");
            System.out.println(" ");
            System.out.println(Helpermethods.ANSI_PURPLE + "Oh! you are here from " + Helpermethods.ANSI_RESET
                + Helpermethods.PURPLE_UNDERLINED + p.getChannel() + Helpermethods.ANSI_RESET
                + Helpermethods.ANSI_PURPLE + "." + Helpermethods.ANSI_RESET);
            System.out.println(" ");
          } else if (input3.equals("5")) {
            p.setChannel("Google");
            System.out.println(" ");
            System.out.println(Helpermethods.ANSI_PURPLE + "Oh! you are here from " + Helpermethods.ANSI_RESET
                + Helpermethods.PURPLE_UNDERLINED + p.getChannel() + Helpermethods.ANSI_RESET
                + Helpermethods.ANSI_PURPLE + "." + Helpermethods.ANSI_RESET);
            System.out.println(" ");
          } else {
            System.out.println(Helpermethods.RED_BOLD + "Invalid input. Please try again." + Helpermethods.ANSI_RESET);
            System.out.println(" ");
          }

        }
      }

      // login code block
      else if (input.equals("2")) {
        System.out.println(" ");
        System.out.println("Enter your email: ");
        String email = ui.next();
        System.out.println("Enter your password: ");
        String password = ui.next();
        UserAccountDirectory uad = business.getUserAccountDirectory();
        UserAccount account = uad.AuthenticateUser(email, password);
        if (account != null) {
          System.out.println(" ");
          System.out.println(Helpermethods.ANSI_PURPLE + "Login successful!" + Helpermethods.ANSI_RESET);
          System.out.println(" ");
          System.out.println(Helpermethods.CYAN_BOLD + "Welcome "
              + account.getAssociatedPersonProfile().getPerson().getPersonFullName() + "!" + Helpermethods.ANSI_RESET);
          System.out.println(Helpermethods.ANSI_CYAN + "Your customer type is "
              + account.getAssociatedPersonProfile().getCustomerType() + "." + Helpermethods.ANSI_RESET);
          System.out.println(" ");
          System.out.println("Displaying offers for You ");
          Helpermethods.getCustomerOffers(account.getAssociatedPersonProfile().getCustomerType());
        } else {
          System.out
              .println(Helpermethods.ANSI_RED + "Invalid credentials. Please try again." + Helpermethods.ANSI_RESET);
        }
      }

      else if (input.equals("3")) {
        System.out.println(" ");
        System.out.println(Helpermethods.GREEN_UNDERLINED + "Thank you for visiting us!" + Helpermethods.ANSI_RESET);
        exit = true;
      }
    }

    // generate Solution offers
    // SolutionOfferCatalog soc = new SolutionOfferCatalog();
    // soc.configureSolutionOffers(15);
    // soc.printSolutionOffers();

    // generate sales orders

    // The below given is the interaction of the management team with the
    // application

    // Scanner sc = new Scanner(System.in);

    // boolean exitCode = false;

    // while (!exitCode) {
    //   System.out.println(Helpermethods.YELLOW_UNDERLINED + "Welcome to the Management Database. Please pick an option:"
    //       + Helpermethods.ANSI_RESET);
    //   System.out.println("1. Generate Product Performance Report");
    //   System.out.println("2. Generate Sales Order Report");
    //   System.out.println("3. Generate Sales by Market Report");
    //   System.out.println("4. Generate Sales by Channel Report");
    //   System.out.println("5. Exit");

    //   String input1 = sc.next();

    //   // System.out.println(input);

    //   if (input1.equals("1")) {
    //     Supplier randomSupplier = sd.pickRandomSupplier();
    //     ProductCatalog pd = randomSupplier.getProductCatalog();
    //     ProductsReport myFirstReport = pd.generateProductPerformanceReport("Name");
    //     myFirstReport.printProductReport();

    //   }

    //   if (input1.equals("2"))
    //     orderReport.printOrderReport();

    //   if (input1.equals("3"))
    //     mol.generateSalesByMarketReport();
    //     //mol.generateSalesByMarketChannelReport();
        
    //   if (input1.equals("4"))
    //     mol.generateSalesByChannelReport();

    //   if (input1.equals("5"))
    //     //mol.generateSalesByProductReport();
      
    //   if (input1.equals("6"));
    //     System.out.println(Helpermethods.ANSI_GREEN + "Thank you, have a nice day!" + Helpermethods.ANSI_RESET);
    //     exitCode = true;
    // }


    Scanner sc = new Scanner(System.in);

    boolean exitCode = false;

    while (!exitCode) {
      System.out.println(Helpermethods.YELLOW_UNDERLINED + "Welcome to the Management Database. Please pick an option:"
          + Helpermethods.ANSI_RESET);
      System.out.println("1. Generate Product Performance Report");
      System.out.println("2. Generate Sales Order Report");
      System.out.println("3. Generate Sales by Market Report");
      System.out.println("4. Generate Sales by Channel Report");
      System.out.println("5. Exit");

      String input1 = sc.next();

      switch (input1) {
        case "1":
          Supplier randomSupplier = sd.pickRandomSupplier();
          ProductCatalog pd = randomSupplier.getProductCatalog();
          ProductsReport myFirstReport = pd.generateProductPerformanceReport("Name");
          myFirstReport.printProductReport();
          break;

        case "2":
          orderReport.printOrderReport();
          break;

        case "3":
          mol.generateSalesByMarketReport();
          break;

        case "4":
          mol.generateSalesByChannelReport();
          break;

        case "5":
          System.out.println(" ");
          System.out.println(Helpermethods.GREEN_UNDERLINED + "Thank you, have a nice day!" + Helpermethods.ANSI_RESET);
          exitCode = true;
          break;

        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    }

    // 3. Show some analytics (Summarizing, comparing, sorting, grouping data by
    // some criteria)

    // business.printShortInfo();

    // Faker magicBox = new Faker();

    // System.out.println("================== First, Last name ==================
    // ");
    // for (int index=0; index < 50; index++){
    // String fullName = magicBox.name().fullName();
    // System.out.println(fullName);
    // }

    // System.out.println("================== Companies ================== ");

    // for (int index=0; index < 50; index++){
    // String companyName = magicBox.company().name();
    // System.out.println(companyName);
    // }

    // System.out.println("================== Products ================== ");

    // for (int index=0; index < 50; index++){
    // String product = magicBox.commerce().productName();
    // System.out.println(product);
    // }

    // System.out.println("================== Yoda Quotes ================== ");

    // for (int index=0; index < 50; index++){
    // String quote = magicBox.yoda().quote();
    // System.out.println(quote);
    // }

    // sc.close();

  }
}
