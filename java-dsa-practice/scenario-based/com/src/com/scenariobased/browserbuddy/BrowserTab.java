package com.scenariobased.browserbuddy;

class BrowserTab {
    Page current;

    void visit(String url) {
        Page newPage = new Page(url);

        if (current != null) {
            current.next = newPage;
            newPage.prev = current;
        }

        current = newPage;
        System.out.println("Visited: " + url);
    }

    void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page");
        }
    }

    void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No next page");
        }
    }

    String getCurrentPage() {
        return current != null ? current.url : "Empty Tab";
    }
}
