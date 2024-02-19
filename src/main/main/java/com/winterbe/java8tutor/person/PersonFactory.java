package com.winterbe.java8tutor.person;

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
