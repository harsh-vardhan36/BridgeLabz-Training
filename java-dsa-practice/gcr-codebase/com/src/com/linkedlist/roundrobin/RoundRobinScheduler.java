package com.linkedlist.roundrobin;

public class RoundRobinScheduler {
    private CNode head;
    private int totalTime;

    public void addProcess(Process process) {
        CNode newNode = new CNode(process);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        CNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void simulate(int timeQuantum) {
        if (head == null) return;

        CNode current = head;

        while (head != null) {
            displayQueue();

            if (current.data.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.data.remainingTime);
                current.data.remainingTime -= execTime;
                totalTime += execTime;
            }

            if (current.data.remainingTime == 0) {
                current.data.turnAroundTime = totalTime;
                current.data.waitingTime =
                        current.data.turnAroundTime - current.data.burstTime;
                removeProcess(current.data.pid);
                current = head;
            } else {
                current = current.next;
            }
        }
    }

    public void removeProcess(int pid) {
        if (head == null) return;

        if (head.data.pid == pid && head.next == head) {
            head = null;
            return;
        }

        if (head.data.pid == pid) {
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
            if (curr.next.data.pid == pid) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public void displayQueue() {
        if (head == null) return;
        CNode temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print(
                "P" + temp.data.pid + "(" + temp.data.remainingTime + ") "
            );
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void displayAverages(Process[] processes) {
        double totalWT = 0, totalTAT = 0;
        for (Process p : processes) {
            totalWT += p.waitingTime;
            totalTAT += p.turnAroundTime;
        }
        System.out.println("\nAverage Waiting Time: " + totalWT / processes.length);
        System.out.println("Average Turnaround Time: " + totalTAT / processes.length);
    }
}
