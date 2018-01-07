package com.roll.comical.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetWorkService implements Runnable {

    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetWorkService(int port, int poolSize) throws IOException {
        serverSocket = new ServerSocket(port, poolSize);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                pool.execute(new Handler(serverSocket.accept()));
            }
        } catch (IOException e) {
            pool.shutdown();
        }
    }
}

class Handler implements Runnable {

    private final Socket socket;

    Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(1);
    }
}
