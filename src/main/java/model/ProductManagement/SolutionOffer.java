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

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    ArrayList<Product> products;
    int price;// floor, ceiling, and target ideas
    MarketChannelAssignment marketChannelComb;

    public SolutionOffer(MarketChannelAssignment m) {
        marketChannelComb = m;
        products = new ArrayList<Product>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void setPrice(int p) {
        price = p;

    }

    public ArrayList<String> getProductDetails() {
        ArrayList<String> prooductList = new ArrayList<>();
        for (Product p : products) {
            prooductList.add(p.getName());
        }
        return prooductList;
    }

}
