
package model.OrderManagement;

import java.util.ArrayList;
import java.util.Collections;

import ui.Helpermethods;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderReport {
    ArrayList<OrderSummary> orderSummaryList;

    public MasterOrderReport() {

        orderSummaryList = new ArrayList<OrderSummary>();

    }

    public void generateOrderReport(ArrayList<Order> orders) {
        ArrayList<Order> orderList = orders;
        OrderSummary orderSummary;

        OrderSummaryComparator comparator = new OrderSummaryComparator();

        for (Order order : orderList) {
            orderSummary = new OrderSummary(order);
            orderSummaryList.add(orderSummary);
        }
        Collections.sort(orderSummaryList, comparator);
    }

    public OrderSummary getTopProfitableOrder() { // most profitable order
        OrderSummary currentTopOrder = null;

        for (OrderSummary os : orderSummaryList) {
            if (currentTopOrder == null)
                currentTopOrder = os; // initial step
            else if (os.getOrderProfit() > currentTopOrder.getOrderProfit()) {
                currentTopOrder = os; // we have a new higher total
            }
        }
        return currentTopOrder;
    }

    // public void printOrderReport() {
    // System.out.println("Master Order Report");
    // for (OrderSummary os : orderSummaryList) {
    // int index = orderSummaryList.indexOf(os);
    // System.out.print((index + 1) + " ");
    // os.printOrderSummary();
    // }

    // }

    // public void printOrderReport() {
    // System.out.println("Master Order Report");
    // for (OrderSummary os : orderSummaryList) {
    // int index = orderSummaryList.indexOf(os) + 1;
    // os.printOrderSummary(index);
    // }
    // }

    public void printOrderReport() {
        int tableWidth = 121; // adjust this value to match the actual width of the table
        String line = new String(new char[tableWidth]).replace('\0', '-'); // create a line with the width of the table
        System.out.println(line);
        String title = Helpermethods.ANSI_BLUE + "Sales Order Report" + Helpermethods.ANSI_RESET;
        int paddingSize = (tableWidth - title.length()) / 2; // calculate the padding size
        String format = "%" + (paddingSize + title.length()) + "s%n"; // create a format string for printf
        System.out.printf(format, title); // print the title centered
        // String line = new String(new char[tableWidth]).replace('\0', '-'); // create
        // a line with the width of the table
        System.out.println(line);
        System.out.printf("| %-5s | %-25s | %-15s | %-15s | %-45s | %n", "Index", "Customer Id", "Number of Items",
                "Sales Volume", "Market And Channel"); // print the column titles
        System.out.println(line);
        for (OrderSummary os : orderSummaryList) {
            int index = orderSummaryList.indexOf(os) + 1;
            os.printOrderSummary(index);
        }
        System.out.println(line);

        
    }

}
