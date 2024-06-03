package org.example;

import org.example.util.ds.HashMap;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        HashMap<String, String > h = new HashMap<>();
//        h.put("0","Aayush");
//        h.put("1","Aayushma");
//        h.put("1","Subash");
//        System.out.println(h.get("00"));
//        System.out.println(h.remove("1"));
//        System.out.println(h.containsKey("81"));
//        LinkedList<Integer> l = new LinkedList<>();
//        l.addFirst(23);
//        l.addFirst(34);
//        l.addFirst(56);
//        System.out.println(l.remove(1));
//        System.out.println("After removing index 1: " + l.get(0) + ", " + l.get(1)); // Print the list after removing index 1
//        System.out.println(l.remove(1));
//        System.out.println("After removing index 1 again: " + l.get(0)); // Print the list after removing index 1 again
//        System.out.println(l.remove(0));
//        System.out.println("After removing index 0: " + l.get(0)); // Print the list after removing index 0
//        System.out.println(l.removeLast());
//        System.out.println(l.removeLast());
//        System.out.println(l.removeLast());
//        System.out.println(l.removeLast());


        try {
            LinkedList<Integer> linkedList = new LinkedList<>();
            System.out.println(linkedList.removeFirst());
        } catch (Exception er) {
            System.out.println(er.getMessage());
        }

    }
}