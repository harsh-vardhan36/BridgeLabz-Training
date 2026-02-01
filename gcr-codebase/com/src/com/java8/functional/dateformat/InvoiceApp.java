package com.java8.functional.dateformat;

import java.time.LocalDate;

public class InvoiceApp {

    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        System.out.println("DD-MM-YYYY : " +
                DateFormatUtil.formatDate(invoiceDate, "dd-MM-yyyy"));

        System.out.println("Readable   : " +
                DateFormatUtil.formatDate(invoiceDate, "dd MMM yyyy"));

        System.out.println("ISO Format : " +
                DateFormatUtil.formatDate(invoiceDate, "yyyy-MM-dd"));
    }
}
