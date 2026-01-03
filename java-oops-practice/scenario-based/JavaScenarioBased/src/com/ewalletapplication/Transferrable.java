package com.ewalletapplication;

interface Transferrable {
	
    void transferTo(User receiver, double amount);
}