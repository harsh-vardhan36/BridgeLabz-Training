package com.hashmap.custom;

public class Main {

    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();

        map.put(1, 10);
        map.put(2, 20);
        map.put(17, 170); 

        System.out.println(map.get(1));   
        System.out.println(map.get(17));  

        map.remove(1);
        System.out.println(map.get(1));   

        System.out.println(map.size());   
        
    }
}
