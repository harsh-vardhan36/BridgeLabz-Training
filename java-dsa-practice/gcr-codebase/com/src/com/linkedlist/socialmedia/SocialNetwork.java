package com.linkedlist.socialmedia;

public class SocialNetwork {
    private UserNode head;

    public void addUser(User user) {
        UserNode newNode = new UserNode(user);
        newNode.next = head;
        head = newNode;
    }

    public void addFriend(int userId1, int userId2) {
        User u1 = findUserById(userId1);
        User u2 = findUserById(userId2);
        if (u1 == null || u2 == null) return;

        u1.friends = addFriendNode(u1.friends, userId2);
        u2.friends = addFriendNode(u2.friends, userId1);
    }

    public void removeFriend(int userId1, int userId2) {
        User u1 = findUserById(userId1);
        User u2 = findUserById(userId2);
        if (u1 == null || u2 == null) return;

        u1.friends = removeFriendNode(u1.friends, userId2);
        u2.friends = removeFriendNode(u2.friends, userId1);
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) return;

        FriendNode temp = user.friends;
        System.out.print("Friends of " + user.name + ": ");
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void findMutualFriends(int userId1, int userId2) {
        User u1 = findUserById(userId1);
        User u2 = findUserById(userId2);
        if (u1 == null || u2 == null) return;

        System.out.print("Mutual Friends: ");
        FriendNode f1 = u1.friends;
        while (f1 != null) {
            FriendNode f2 = u2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.print(f1.friendId + " ");
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }
        System.out.println();
    }

    public void searchUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.data.userId == userId) {
                displayUser(temp.data);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found");
    }

    public void searchUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.data.name.equals(name)) {
                displayUser(temp.data);
            }
            temp = temp.next;
        }
    }

    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode f = temp.data.friends;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(
                temp.data.name + " has " + count + " friends"
            );
            temp = temp.next;
        }
    }

    private User findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.data.userId == userId) return temp.data;
            temp = temp.next;
        }
        return null;
    }

    private FriendNode addFriendNode(FriendNode head, int friendId) {
        FriendNode newNode = new FriendNode(friendId);
        newNode.next = head;
        return newNode;
    }

    private FriendNode removeFriendNode(FriendNode head, int friendId) {
        if (head == null) return null;
        if (head.friendId == friendId) return head.next;

        FriendNode temp = head;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    private void displayUser(User u) {
        System.out.println(
            u.userId + " | " + u.name + " | " + u.age
        );
    }
}
