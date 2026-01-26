package com.junit.banktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount(1000.0);
    }

    @Test
    void testDepositUpdatesBalance() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void testWithdrawUpdatesBalance() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance());
    }

    @Test
    void testWithdrawFailsWhenInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000.0);
        });
    }
}
