package com.linkedlist.taskscheduler;

public class TaskCircularLinkedList {
    private CNode head;
    private CNode current;

    public void addAtBeginning(Task task) {
        CNode newNode = new CNode(task);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }
        CNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    public void addAtEnd(Task task) {
        CNode newNode = new CNode(task);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }
        CNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void addAtPosition(Task task, int position) {
        if (position == 1) {
            addAtBeginning(task);
            return;
        }
        CNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        CNode newNode = new CNode(task);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeByTaskId(int taskId) {
        if (head == null) return;

        if (head.data.taskId == taskId) {
            CNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
            return;
        }

        CNode curr = head;
        while (curr.next != head) {
            if (curr.next.data.taskId == taskId) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public void viewCurrentAndMoveNext() {
        if (current == null) return;
        displayTask(current.data);
        current = current.next;
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        CNode temp = head;
        do {
            if (temp.data.priority == priority) {
                displayTask(temp.data);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void displayAll() {
        if (head == null) return;
        CNode temp = head;
        do {
            displayTask(temp.data);
            temp = temp.next;
        } while (temp != head);
    }

    private void displayTask(Task t) {
        System.out.println(
            t.taskId + " | " + t.taskName + " | " + t.priority + " | " + t.dueDate
        );
    }
}
