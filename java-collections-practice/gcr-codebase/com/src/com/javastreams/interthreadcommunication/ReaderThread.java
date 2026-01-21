package com.javastreams.interthreadcommunication;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReaderThread extends Thread {

    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close();
        } catch (IOException e) {
            System.out.println("Reader error");
        }
    }
}
