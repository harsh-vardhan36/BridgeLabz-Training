package com.java8.stream.loggingtranscations;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionLogger {

    public static void main(String[] args) {

        List<String> transactionIds = List.of(
            "TXN1001",
            "TXN1002",
            "TXN1003"
        );

        transactionIds.forEach(id ->
            System.out.println(LocalDateTime.now() + " - Transaction: " + id)
        );
    }
}
