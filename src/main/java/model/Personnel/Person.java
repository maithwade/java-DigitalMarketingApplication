/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Personnel;

/**
 *
 * @author kal bugrara
 */
public class Person {

    String id;
    //adding the user attributes to the person class
    String fname;
    String lname;
    String email;

    public Person(String id, String fname, String lname, String email) {   //adding those attributes to the constructor

        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public Person(String id) {  //original constructor with just the id
        this.id = id;
    }

    public String getPersonId() {
        return id;
    }

    //adding the getters for the user attributes

    public String getPersonFirstName() {
        return fname;
    }

    public String getPersonLastName() {
        return lname;
    }

    public String getPersonFullName() {
        return fname + " " + lname;
    }

    public String getPersonEmail() {
        return email;
    }



    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getPersonId();
    }

    
}
