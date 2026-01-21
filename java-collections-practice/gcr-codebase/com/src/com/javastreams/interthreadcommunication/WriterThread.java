package com.javastreams.interthreadcommunication;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriterThread extends Thread {

    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes());
            pos.close();
        } catch (IOException e) {
            System.out.println("Writer error");
        }
    }
}
