/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.Random;

import com.github.javafaker.Faker;

import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  static int upperPriceLimit = 50;
  static int lowerPriceLimit = 10;
  static int range = 5;
  static int productMaxQuantity = 5;

  public static Business createABusinessAndLoadALotOfData(String name, int supplierCount, int productCount,
      int customerCount, int orderCount, int itemCount) {
    Business business = new Business(name);

    // Add Suppliers +
    loadSuppliers(business, supplierCount);

    // Add Products +
    loadProducts(business, productCount);

    // Add Customers
    loadCustomers(business, customerCount);

    // Add Order
    loadOrders(business, orderCount, itemCount);

    return business;
  }

  public static void loadSuppliers(Business b, int supplierCount) {
    Faker faker = new Faker();

    SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    for (int index = 1; index <= supplierCount; index++) {
      supplierDirectory.newSupplier(faker.company().name());
    }
  }

  static void loadProducts(Business b, int productCount) {
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();

    for (Supplier supplier : supplierDirectory.getSupplierList()) {

      int randomProductNumber = getRandom(1, productCount);
      ProductCatalog productCatalog = supplier.getProductCatalog();

      for (int index = 1; index <= randomProductNumber; index++) {

        String productName = "Product #" + index + " from " + supplier.getName();
        int randomFloor = getRandom(lowerPriceLimit, lowerPriceLimit + range);
        int randomCeiling = getRandom(upperPriceLimit - range, upperPriceLimit);
        int randomTarget = getRandom(randomFloor, randomCeiling);

        productCatalog.newProduct(productName, randomFloor, randomCeiling, randomTarget);
      }
    }
  }

  static int getRandom(int lower, int upper) {
    Random r = new Random();

    // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
    // numbers from 10 to 15
    // I will have result = 10 + nextInt(5)
    int randomInt = lower + r.nextInt(upper - lower);
    return randomInt;
  }

  static void loadCustomers(Business b, int customerCount) {
    CustomerDirectory customerDirectory = b.getCustomerDirectory();
    PersonDirectory personDirectory = b.getPersonDirectory();

    Faker faker = new Faker();

    for (int index = 1; index <= customerCount; index++) {
      Person newPerson = personDirectory.newPerson(faker.name().fullName());
      CustomerProfile newcustprofile = customerDirectory.newCustomerProfile(newPerson);
      Market market = new Market("Kids");
      market.addCustomerType("Kids");
      newcustprofile.assignMarketToCustomer(market);
    }

    for (int index = 1; index <= customerCount; index++) {
      Person newPerson = personDirectory.newPerson(faker.name().fullName());
      CustomerProfile newcustprofile = customerDirectory.newCustomerProfile(newPerson);
      Market market = new Market("Students");
      market.addCustomerType("Students");
      newcustprofile.assignMarketToCustomer(market);
    }

    for (int index = 1; index <= customerCount; index++) {
      Person newPerson = personDirectory.newPerson(faker.name().fullName());
      CustomerProfile newcustprofile = customerDirectory.newCustomerProfile(newPerson);
      Market market = new Market("Professionals");
      market.addCustomerType("Professionals");
      newcustprofile.assignMarketToCustomer(market);
    }

  }

  static void loadOrders(Business b, int orderCount, int itemCount) {

    // reach out to masterOrderList
    MasterOrderList mol = b.getMasterOrderList();

    // pick a random customer (reach to customer directory)
    CustomerDirectory cd = b.getCustomerDirectory();
    SupplierDirectory sd = b.getSupplierDirectory();

    for (int index = 0; index < orderCount; index++) {

      CustomerProfile randomCustomer = cd.pickRandomCustomer();
      if (randomCustomer == null) {
        System.out.println("Cannot generate orders. No customers in the customer directory.");
        return;
      }

      // create an order for that customer
      Order randomOrder = mol.newOrder(randomCustomer);
      String[] custType = { "Kids", "Students", "Professionals" };
      int randomNumber = getRandom(1, 3);
      Market market = randomCustomer.getMarket();
      market.addCustomerType(custType[randomNumber]);
      Channel ch = new Channel();
      MarketChannelAssignment mca = new MarketChannelAssignment(market, ch);
      randomOrder.setmarketchannel(mca);

      int randomItemCount = getRandom(1, itemCount);
      for (int itemIndex = 0; itemIndex < randomItemCount; itemIndex++) {

        Supplier randomSupplier = sd.pickRandomSupplier();
        if (randomSupplier == null) {
          System.out.println("Cannot generate orders. No supplier in the supplier directory.");
          return;
        }
        ProductCatalog pc = randomSupplier.getProductCatalog();
        Product randomProduct = pc.pickRandomProduct();
        if (randomProduct == null) {
          System.out.println("Cannot generate orders. No products in the product catalog.");
          return;
        }

        int price = randomProduct.getTargetPrice();
        String typeOfMarket = randomCustomer.getMarketType();
        if (typeOfMarket == "Kids") {
          price = (int) (price - (price * 0.1));
        } else if (typeOfMarket == "Students") {
          price = (int) (price - (price * 0.15));
        } else {
          price = price + (int) (price * 0.1);
        }

        int randomPrice = price;
        int randomQuantity = getRandom(1, productMaxQuantity);

        randomOrder.newOrderItem(randomProduct, randomPrice, randomQuantity);
      }
    }
    // Make sure order items are connected to the order

  }

}
