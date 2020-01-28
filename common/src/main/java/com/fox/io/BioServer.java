package com.fox.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dmb
 * @since 2019/12/27
 */
public class BioServer {

    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 20l, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));

    public static void main(String[] args) throws IOException {
        server();
    }

    public static void server() throws IOException {

        ServerSocket serverSocket = new ServerSocket(63799);
        System.out.println("server started");
        //等待客户端连接，阻塞了
        while (true) {

            executorService.execute(new ClientAcceptRunnable(serverSocket.accept()));
            System.out.println("client connected");

        }
    }

    static class ClientAcceptRunnable implements Runnable {

        private Socket socket;

        private InputStream inputStream;

        private OutputStream outputStream;

        public ClientAcceptRunnable(Socket socket) {
            this.socket = socket;
            try {
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            } catch (Exception e) {

        }}

        @Override
        public void run() {
            String clientCommon = null;
            while (true) {
                try {
                    System.out.println("客户端请求来了1：" + clientCommon);

//                    inputStream = );

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    clientCommon = bufferedReader.readLine();
                    System.out.println("客户端请求来了：" + clientCommon);

                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                    bufferedWriter.write(clientCommon.split("#")[0]+" pong\n");
                    bufferedWriter.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

        public void setSocket(Socket socket) {
            this.socket = socket;
        }
    }

}
