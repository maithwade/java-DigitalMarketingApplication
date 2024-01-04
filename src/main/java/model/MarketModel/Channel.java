/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import ui.Helpermethods;

/**
 *
 * @author kal bugrara
 */
public class Channel {

    // adding the types of advertising channels
    ArrayList<String> advertisingChannels;
    String name = "";

    public Channel(String name) {
        this.name = name;
    }

    public Channel() {
        advertisingChannels = new ArrayList<String>();
        addAdvertisingChannels();
    }

    private void addAdvertisingChannels() {
        advertisingChannels.add("Youtube");
        advertisingChannels.add("Instagram");
        advertisingChannels.add("Facebook");
        advertisingChannels.add("Twitter");
        advertisingChannels.add("Google");
    }

    public ArrayList<String> getAdvertisingChannels() {
        return advertisingChannels;
    }

    public void setAdvertisingChannels(ArrayList<String> advertisingChannels) {
        this.advertisingChannels = advertisingChannels;
    }

    public String getChannelName() {
        return name != "" ? name : advertisingChannels.get(Helpermethods.getRandom(0, 4));
    }
}