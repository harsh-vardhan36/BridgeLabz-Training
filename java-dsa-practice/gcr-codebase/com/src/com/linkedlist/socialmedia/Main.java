package com.linkedlist.socialmedia;
public class Main {
    public static void main(String[] args) {

        SocialNetwork sn = new SocialNetwork();

        sn.addUser(new User(1, "Harsh", 22));
        sn.addUser(new User(2, "Aman", 21));
        sn.addUser(new User(3, "Riya", 20));
        sn.addUser(new User(4, "Neha", 23));

        sn.addFriend(1, 2);
        sn.addFriend(1, 3);
        sn.addFriend(2, 3);
        sn.addFriend(2, 4);

        sn.displayFriends(1);
        sn.displayFriends(2);

        sn.findMutualFriends(1, 2);

        sn.searchUserById(3);
        sn.searchUserByName("Neha");

        sn.countFriends();

        sn.removeFriend(1, 3);

        System.out.println("\nAfter Removing Friend:");
        sn.displayFriends(1);
    }
}
