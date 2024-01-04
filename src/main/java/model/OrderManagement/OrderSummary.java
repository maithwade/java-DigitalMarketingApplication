/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

/**
 *
 * @author kal bugrara
 */
public class OrderSummary {
    int salesvolume;
    int numberOfItems;
    boolean totalabovetarget;
    int orderpriceperformance;
    int numberofOrderitemsabovetarget;
    String customerId;
    String marketChannel;

    public OrderSummary(Order o) {
        salesvolume = o.getOrderTotal();
        numberOfItems = o.getNumberOfItems();
        totalabovetarget = o.isOrderAboveTotalTarget();
        orderpriceperformance = o.getOrderPricePerformance();
        numberofOrderitemsabovetarget = o.getNumberOfOrderItemsAboveTarget();
        customerId = o.getCustomerId();
        marketChannel = o.getMarketchannelInfo();

    }

    public int getOrderProfit() {
        return orderpriceperformance;
    }

    // public void printOrderSummary(){
    // System.out.println("| " + customerId + " | " + numberOfItems + " | " +
    // salesvolume);
    // }

    public void printOrderSummary(int index) {
        System.out.printf("| %-5d | %-25s | %-15d | %-15d | %-45s | %n", index, customerId, numberOfItems, salesvolume,
                marketChannel);
    }

}
