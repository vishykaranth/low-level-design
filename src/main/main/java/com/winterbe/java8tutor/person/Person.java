package com.winterbe.java8tutor.person;

import lombok.ToString;

@ToString
class Person {
    String firstName;
    String lastName;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
