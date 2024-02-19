package com.ramesh.java8.methodreferences;

// Syntax : ClassName::new

//You can refer a constructor by using the new keyword. Here, we are referring constructor with the help of functional interface.
public class ReferenceToConstructor {
    public static void main(String[] args) {
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }
}

interface Messageable {
    Message getMessage(String msg);
}

class Message {
    Message(String msg) {
        System.out.print(msg);
    }
}  