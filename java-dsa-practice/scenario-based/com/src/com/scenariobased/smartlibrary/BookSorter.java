package com.scenariobased.smartlibrary;

public class BookSorter {
	
    public void insertionSort(String[] books) {
        for (int i = 1; i < books.length; i++) {
            String current = books[i];
            int j = i - 1;
            
            while (j >= 0 && books[j].compareTo(current) > 0) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = current;
        }
    }

    public void display(String[] books) {
        for (String book : books) {
            System.out.println(book);
        }
    }
}
