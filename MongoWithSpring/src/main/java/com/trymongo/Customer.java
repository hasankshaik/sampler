package com.trymongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "com.trymongo.Customer")
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("com.trymongo.Customer[id=%s, firstName='%s', lastName='%s']", id,
                firstName, lastName);
    }

}