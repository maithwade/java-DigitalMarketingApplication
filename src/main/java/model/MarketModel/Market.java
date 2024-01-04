/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Market {
    ArrayList<SolutionOffer> so;
    ArrayList<MarketChannelAssignment> channels;
    ArrayList<String> characteristics;
    ArrayList<Market> submarkets;
    ArrayList<String> customerType;
    int size;

    public Market(String s) {
        characteristics = new ArrayList<String>();
        characteristics.add(s);
        customerType = new ArrayList<>();// new addition
    }

    // new addition
    public void addCustomerType(String ct) {
        this.customerType.add(ct);
    }

    public String getCustomerType() {
        return customerType.get(0);
    }

}
