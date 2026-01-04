package com.linkedlist.socialmedia;

public class User {
    int userId;
    String name;
    int age;
    FriendNode friends;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
    }
}
