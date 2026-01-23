package com.scenariobased.avltree.onlineticketbooking;

public class TicketBookingMain {

    public static void main(String[] args) {

        EventAVLTree tree = new EventAVLTree();

        tree.root = tree.insert(tree.root, "Music Concert", 1080);
        tree.root = tree.insert(tree.root, "Tech Talk", 900);
        tree.root = tree.insert(tree.root, "Comedy Show", 1230);
        tree.root = tree.insert(tree.root, "Drama Play", 1020);

        // Cancel an event
        tree.root = tree.delete(tree.root, 900);

        // Show upcoming events
        System.out.println("Upcoming Events:");
        tree.inorder(tree.root);
    }
}
