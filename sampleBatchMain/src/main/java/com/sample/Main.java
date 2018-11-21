package com.sample;

public class Main {
    public String hello() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new Main().hello());
    }
}
