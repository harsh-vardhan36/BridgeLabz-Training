package com.java8.references.invoice;

class Invoice {
    private String transactionId;

    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
