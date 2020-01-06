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

    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 20, 2000l, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));

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
                socket.getChannel();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            } catch (Exception e) {

        }}

        @Override
        public void run() {
            InputStream inputStream = null;
            String clientCommon = null;
            while (true) {
                try {
                    System.out.println("客户端请求来了1：" + clientCommon);

//                    inputStream = );

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    clientCommon = bufferedReader.readLine();
                    System.out.println("客户端请求来了：" + clientCommon);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    OutputStream outputStream  = socket.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                    bufferedWriter.write(clientCommon.split("#")[0]+" pong");
                    bufferedWriter.flush();

                    byte[] b = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    while (System.in.read(b, 0, b.length) != -1) {
                        sb.append(new String(b));
                    }
                    bufferedWriter.write(sb.toString()+" pong");
                    bufferedWriter.flush();
                    System.out.println("aaa");
                    //                bufferedWriter.close();
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
