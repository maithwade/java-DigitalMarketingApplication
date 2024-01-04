/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.SolutionOffer;
import model.SalesManagement.SalesPersonProfile;
import ui.Helpermethods;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {
    ArrayList<Order> orders;
    MasterOrderReport masterOrderReport;

    public MasterOrderList() {
        orders = new ArrayList<Order>();

    }

    public Order newOrder(CustomerProfile cp) {
        Order o = new Order(cp);
        orders.add(o);
        return o;

    }

    public ArrayList<Order> getAllOrders() {
        return orders;
    }

    // public void generateSalesByMarketChannelReport() {
    //     HashMap<String, Integer> channelMap = new HashMap<>();
    //     HashMap<String, Integer> marketMap = new HashMap<>();
    //     for (Order ord : orders) {
    //         Integer totalSales = ord.getOrderTotal();
    //         ArrayList<String> arr = ord.getMarketChannelNameArray();
    //         String marketname = arr.get(0);
    //         String channelName = arr.get(1);
    //         if (marketMap.get(marketname) != null) {
    //             marketMap.put(marketname, marketMap.get(marketname) + totalSales);
    //         } else {
    //             marketMap.put(marketname, totalSales);
    //         }

    //         if (channelMap.get(channelName) != null) {
    //             channelMap.put(channelName, channelMap.get(channelName) + totalSales);
    //         } else {
    //             channelMap.put(channelName, totalSales);
    //         }
    //     }
    //     System.out.println("--------------Sales per Market------------------\n");
    //     System.out.println("| Market      " + "    |  " + "Total Revenue");
    //     marketMap.forEach((key, value) -> System.out.printf("| %-15s | %-20d | %n", key, value));

    //     System.out.println("--------------Sales per Channel------------------\n");
    //     System.out.println("| Channel     " + "    |  " + "Total Revenue");
    //     channelMap.forEach((key, value) -> System.out.printf("| %-15s | %-20d | %n", key, value));
    // }

    public void generateSalesByMarketReport() {
        HashMap<String, Integer> marketMap = new HashMap<>();
        for (Order ord : orders) {
            Integer totalSales = ord.getOrderTotal();
            ArrayList<String> arr = ord.getMarketChannelNameArray();
            String marketname = arr.get(0);
            if (marketMap.get(marketname) != null) {
                marketMap.put(marketname, marketMap.get(marketname) + totalSales);
            } else {
                marketMap.put(marketname, totalSales);
            }
        }
        // System.out.println("Sales per Market");
        // System.out.println("-------------------------------------------");
        // System.out.printf("| %-15s | %-21s |%n", "Market", "Total Revenue");
        // System.out.println("-------------------------------------------");
        // marketMap.forEach((key, value) -> System.out.printf("| %-15s | $%-20d | %n", key, value));
        // System.out.println("-------------------------------------------");

        int tableWidth = 50; // adjust this value to match the actual width of the table
        String line = new String(new char[tableWidth]).replace('\0', '-'); // create a line with the width of the table
        //System.out.println(line);
        String title = Helpermethods.ANSI_BLUE +"Sales per Market" + Helpermethods.ANSI_RESET;
        int paddingSize = (tableWidth - title.length()) / 2; // calculate the padding size
        String format = "%" + (paddingSize + title.length()) + "s%n"; // create a format string for printf
        System.out.printf(format, title); // print the title centered
        //System.out.println(line);
        System.out.println("-------------------------------------------");
        System.out.printf("| %-15s | %-21s |%n", "Market", "Total Revenue");
        System.out.println("-------------------------------------------");
        marketMap.forEach((key, value) -> System.out.printf("| %-15s | $%-20d | %n", key, value));
        System.out.println("-------------------------------------------");
    }

    public void generateSalesByChannelReport() {
        HashMap<String, Integer> channelMap = new HashMap<>();
        for (Order ord : orders) {
            Integer totalSales = ord.getOrderTotal();
            ArrayList<String> arr = ord.getMarketChannelNameArray();
            String channelName = arr.get(1);
            if (channelMap.get(channelName) != null) {
                channelMap.put(channelName, channelMap.get(channelName) + totalSales);
            } else {
                channelMap.put(channelName, totalSales);
            }
        }
        // System.out.println("--------------Sales per Channel------------------\n");
        // System.out.println("| Channel     " + "    |  " + "Total Revenue");
        // channelMap.forEach((key, value) -> System.out.printf("| %-15s | %-20d | %n", key, value));
        int tableWidth = 40; // adjust this value to match the actual width of the table
        String line = new String(new char[tableWidth]).replace('\0', '-'); // create a line with the width of the table
        //System.out.println(line);
        String title = Helpermethods.ANSI_BLUE + "Sales per Channel" + Helpermethods.ANSI_RESET;
        int paddingSize = (tableWidth - title.length()) / 2; // calculate the padding size
        String format = "%" + (paddingSize + title.length()) + "s%n"; // create a format string for printf
        System.out.printf(format, title); // print the title centered
        //System.out.println(line);
        System.out.println("------------------------------------------");
        System.out.printf("| %-15s | %-20s |%n", "Channel", "Total Revenue");
        System.out.println("------------------------------------------");
        channelMap.forEach((key, value) -> System.out.printf("| %-15s | %-20d | %n", key, value));
        System.out.println("------------------------------------------");
    }
    

    public Order newOrder(CustomerProfile cp, SalesPersonProfile spp) {
        Order o = new Order(cp, spp);
        orders.add(o);

        return o;
    }

    public MasterOrderReport generateMasterOrderReport() {
        masterOrderReport = new MasterOrderReport();
        masterOrderReport.generateOrderReport(orders);

        return masterOrderReport;
    }

    public int getSalesVolume() {

        int sum = 0;
        for (Order order : orders) {
            sum = sum + order.getOrderTotal();
        }
        return sum;
    }

    public void printShortInfo() {
        System.out.println("Checking what's inside the master order list.");
        System.out.println("There are " + orders.size() + " order.");
    }

}
