package cn.supfox.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Objects;
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

        public InputThread(Socket serverSocket) {
            try {
                this.inputStream = serverSocket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private InputStream inputStream;

        @Override
        public void run() {

            while (true) {

                if (Objects.isNull(inputStream)) {
                    continue;
                }

                BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));
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

        public OutputThread(Socket serverSocket) {
            try {
                this.os = serverSocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private OutputStream os;

        @Override
        public void run() {
            try {
                while (true) {
                    if (null != os) {
                        System.out.println("11111");
                        os.write(("client-#ping").getBytes());
                        os.flush();
                    }
//                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        client();

        LockSupport.park();
    }

    public static void client() throws IOException {



            try {
                Socket serverSocket = new Socket("127.0.0.1", 63799);
                new Thread(new OutputThread(serverSocket)).start();
                System.out.println("input");
                new Thread(new InputThread(serverSocket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

}
