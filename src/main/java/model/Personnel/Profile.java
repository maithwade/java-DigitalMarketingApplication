/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Personnel;

import model.MarketModel.Channel;

/**
 *
 * @author kal bugrara
 */
public abstract class Profile {
    Person person;
    String customerType; //new addition
    Channel channel;
    

    public Profile(Person p) {  
        person = p;
    }

    public abstract String getRole();

    public Person getPerson() {
        return person;
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    //assigning the customer type

    public String getCustomerType() {
        return customerType;
    }
    
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getChannel() {
        return channel.getChannelName();
        
    }

    public void setChannel(String ch) {
        this.channel = new Channel(ch);
    }

}
