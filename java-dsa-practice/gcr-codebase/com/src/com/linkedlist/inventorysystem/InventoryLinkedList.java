package com.linkedlist.inventorysystem;

public class InventoryLinkedList {
    private Node head;

    public void addAtBeginning(Item item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(Item item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtPosition(Item item, int position) {
        if (position == 1) {
            addAtBeginning(item);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        Node newNode = new Node(item);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeByItemId(int itemId) {
        if (head == null) return;

        if (head.data.itemId == itemId) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int itemId, int newQty) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.itemId == itemId) {
                temp.data.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByItemId(int itemId) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.itemId == itemId) {
                displayItem(temp.data);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchByItemName(String name) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.itemName.equals(name)) {
                displayItem(temp.data);
            }
            temp = temp.next;
        }
    }

    public double calculateTotalValue() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total += temp.data.price * temp.data.quantity;
            temp = temp.next;
        }
        return total;
    }

    public void sortByName(boolean ascending) {
        head = mergeSort(head, true, ascending);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, false, ascending);
    }

    private Node mergeSort(Node head, boolean byName, boolean asc) {
        if (head == null || head.next == null) return head;

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head, byName, asc);
        Node right = mergeSort(nextOfMiddle, byName, asc);

        return merge(left, right, byName, asc);
    }

    private Node merge(Node a, Node b, boolean byName, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (byName) {
            condition = asc
                    ? a.data.itemName.compareTo(b.data.itemName) <= 0
                    : a.data.itemName.compareTo(b.data.itemName) > 0;
        } else {
            condition = asc
                    ? a.data.price <= b.data.price
                    : a.data.price > b.data.price;
        }

        Node result;
        if (condition) {
            result = a;
            result.next = merge(a.next, b, byName, asc);
        } else {
            result = b;
            result.next = merge(a, b.next, byName, asc);
        }
        return result;
    }

    private Node getMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayAll() {
        Node temp = head;
        while (temp != null) {
            displayItem(temp.data);
            temp = temp.next;
        }
    }

    private void displayItem(Item i) {
        System.out.println(
            i.itemId + " | " + i.itemName + " | " + i.quantity + " | " + i.price
        );
    }
}
