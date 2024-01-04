/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {

    Market market;
    Channel channel;

    public MarketChannelAssignment(Market m, Channel c) {
        market = m;
        channel = c;
    }

    // new
    public String getMarketType() {
        return market.getCustomerType();
    }

    public String getChannelType() {
        return channel.getChannelName();
    }

    public ArrayList<String> getMarketChannelName() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add(getMarketType());
        arr.add(getChannelType());
        return arr;
    }

}
