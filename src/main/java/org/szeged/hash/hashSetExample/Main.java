package org.szeged.hash.hashSetExample;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Dog> dogSet = new HashSet<Dog>();
        dogSet.add(new Dog("white"));
        dogSet.add(new Dog("white"));

        System.out.println("We have " + dogSet.size() + " white dogs!");

        if(dogSet.contains(new Dog("white"))){
            System.out.println("We have a white dog!");
        }else{
            System.out.println("No white dog!");
        }
    }
}
