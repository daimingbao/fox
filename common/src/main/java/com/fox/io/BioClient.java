package com.fox.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author dmb
 * @since 2019/12/27
 */
public class BioClient {

    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 20, 2000l, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));

    static class InputThread implements Runnable {

        public InputThread(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        private InputStream inputStream;

        @Override
        public void run() {
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));

            while (true) {
                String s = "";
                try {

                    while ((s = inputStreamReader.readLine()) != null) {
                        System.out.println("dddd" + s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class OutputThread implements Runnable {

        public OutputThread(OutputStream outputStream) {
            this.os = outputStream;
        }

        private OutputStream os;

        @Override
        public void run() {
            try {
                os.write(("client-#ping").getBytes());
                os.flush();
                System.out.println("client send finish");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        client();

        LockSupport.park();
    }

    public static void client() throws IOException {

        for (int i = 0; i < 5; i++) {
            final int j = i;

            try {
                Socket serverSocket = new Socket("127.0.0.1", 63799);

                executorService.execute(new OutputThread(serverSocket.getOutputStream()));
                System.out.println("input");
                executorService.execute(new InputThread(serverSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
