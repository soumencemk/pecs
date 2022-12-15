package com.soumen;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Producer Extends --");
        List<Operator> operatorList = List.of(new Operator("admin", "admin@admin.com"),
                new Operator("user", "user@admin.com"));

        List<User> userList = List.of(new Operator("admin", "admin@admin.com"),
                new Operator("user", "user@admin.com"));
        // sendEmails(usersList); Compiler complains here..
        sendEmailsFixed(operatorList);
        // addUsersFromSales(userList); compiler complains
        addUsersFromSalesFixed(userList);
    }

    /*public static void sendEmails(List<User> userList){
        userList.forEach(user -> System.out.println("Sending email to : " + user.getEmailId()));
    }*/
    public static void sendEmailsFixed(List<? extends User> userList) {
        userList.forEach(user -> System.out.println("Sending email to : " + user.getEmailId()));
    }

    /*public static void addUsersFromSales(List<Operator> users){
        users.add(new Operator("sales1","sales1@sales.com"));
        users.add(new Operator("sales2","sales2@sales.com"));
    }*/
    public static void addUsersFromSalesFixed(List<? super Operator> users) {
        users.add(new Operator("sales1", "sales1@sales.com"));
        users.add(new Operator("sales2", "sales2@sales.com"));
    }
}

class Operator extends User {
    public Operator() {
        super();
    }

    public Operator(String name, String email) {
        super(name, email);
    }
}

class RegularUsers extends User {
    public RegularUsers(String name, String email) {
        super(name, email);
    }

    public RegularUsers() {
        super();
    }
}


class User {
    private String name;
    private String emailId;

    public User() {

    }

    public User(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}