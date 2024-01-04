/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import java.util.ArrayList;
import java.util.Random;

import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;
import model.SalesManagement.SalesPersonProfile;
import ui.Helpermethods;

/**
 *
 * @author kal bugrara
 */
public class Order {

    ArrayList<OrderItem> orderItems;
    CustomerProfile customer;
    SalesPersonProfile salesperson;
    MarketChannelAssignment mca;
    String status;

    public Order() {
    }

    public Order(CustomerProfile cp) {
        orderItems = new ArrayList<OrderItem>();
        customer = cp;
        customer.addCustomerOrder(this); // we link the order to the customer
        salesperson = null;
        status = "in process";
    }

    public Order(CustomerProfile cp, SalesPersonProfile ep) {
        orderItems = new ArrayList<OrderItem>();
        customer = cp;
        salesperson = ep;
        customer.addCustomerOrder(this); // we link the order to the customer
        salesperson.addSalesOrder(this);
    }

    // new

    public ArrayList<String> getMarketChannelNameArray() {
        return mca.getMarketChannelName();
    }

    public String getMarketchannelInfo() {
        return "Market: " + mca.getMarketType() + " and Channel: " + mca.getChannelType();
    }

    static int getRandom(int lower, int upper) {
        Random r = new Random();

        // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
        // numbers from 10 to 15
        // I will have result = 10 + nextInt(5)
        int randomInt = lower + r.nextInt(upper - lower);
        return randomInt;
    }

    public void setmarketchannel(MarketChannelAssignment marketchannel) {
        mca = marketchannel;

    }

    public OrderItem newOrderItem(Product p, int actualPrice, int q) {
        OrderItem oi = new OrderItem(p, actualPrice, q);
        orderItems.add(oi);
        return oi;
    }

    // order total is the sumer of the order item totals
    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum = sum + oi.calculatePricePerformance(); // positive and negative values
        }
        return sum;
    }

    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    // sum all the item targets and compare to the total of the order
    public boolean isOrderAboveTotalTarget() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum = sum + oi.getOrderItemTargetTotal(); // product targets are added
        }
        if (getOrderTotal() > sum) {
            return true;
        } else {
            return false;
        }

    }

    public void CancelOrder() {
        status = "Cancelled";
    }

    public void Submit() {
        status = "Submitted";
    }

    public int getNumberOfItems() {
        return orderItems.size();
    }

    public String getCustomerId() {
        return customer.getCustomerId();
    }
}
