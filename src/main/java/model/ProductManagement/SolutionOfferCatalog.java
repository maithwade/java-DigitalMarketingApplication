/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.SolutionOffer;
import ui.Helpermethods;

import java.util.Random;

import com.github.javafaker.Faker;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {
    ArrayList<SolutionOffer> solutionoffers;

    public SolutionOfferCatalog() {
        solutionoffers = new ArrayList<>();
    }

    static int getRandom(int lower, int upper) {
        Random r = new Random();

        // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
        // numbers from 10 to 15
        // I will have result = 10 + nextInt(5)
        int randomInt = lower + r.nextInt(upper - lower);
        return randomInt;
    }

    public void configureSolutionOffers(int count) {
        Faker faker = new Faker();
        Random random = new Random();
        // Logic to configure solution offers based on markets and channels
        String[] characteristic = { "Limited", "mid-size", "all" };
        String[] custType = { "Kids", "Student", "Professional" };
        for (int i = 0; i < count; i++) {
            int randomNumber = getRandom(1, 3);
            Market market = new Market(characteristic[randomNumber]);
            market.addCustomerType(custType[randomNumber]);
            Channel ch = new Channel();
            MarketChannelAssignment mca = new MarketChannelAssignment(market, ch);
            SolutionOffer onlineOffer = new SolutionOffer(mca);
            //
            int totalprice = 0;
            for (int j = 0; j < 4; j++) {
                String productName = faker.commerce().productName();
                String supplierName = faker.company().name();
                int price = (int) (10 + (100 - 10) * random.nextDouble()); // Random price between 10 and 100
                totalprice = totalprice + price;
                // Truncate product and supplier names if they exceed the column width
                if (productName.length() > 30) {
                    productName = productName.substring(0, 30);
                }
                if (supplierName.length() > 35) {
                    supplierName = supplierName.substring(0, 35);
                }
                onlineOffer.addProduct(new Product(productName, price + 20, price - 20, price));
            }

            onlineOffer.setPrice(totalprice);

            solutionoffers.add(onlineOffer);
        }

    }

    public void printSolutionOffers() {
        int index = 1;
        for (SolutionOffer sol : solutionoffers) {
            System.out.println(Helpermethods.ANSI_BLUE + "Bundle: "+ index + Helpermethods.ANSI_RESET);
            System.out.println(Helpermethods.ANSI_GREEN + "Products in bundle: " + Helpermethods.ANSI_RESET + sol.getProductDetails());
            System.out.println(Helpermethods.ANSI_PURPLE + "Price of bundle: " + Helpermethods.ANSI_RESET + "$" + sol.price);
            index++;
        }
    }
}
