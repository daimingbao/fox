package com.fox.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class TcpClient {

    public static void main(String args[]) throws Exception {

        try {
            int p = Integer.parseInt(args[1]);

            //int port_number = p;
            Socket server = new Socket(args[0], p);

            BufferedReader buf = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter out = new PrintWriter(server.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(buf.readLine());
            //输入姓名
            String name = br.readLine();

            out.println(name);
            out.flush();
            System.out.println(buf.readLine());

            //输入题目数
            String numStr = br.readLine();
            int num = Integer.parseInt(numStr);
            out.println(numStr);
            out.flush();
            String resp = buf.readLine();
            System.out.println(resp);
            for (int i = 0; i < num; i++) {
                String quet = buf.readLine();
                System.out.println(quet);
                //自己输入答案
                String answer = br.readLine();
                out.println(answer);
                out.flush();
                //服务器答案
                String s_answer = buf.readLine();
                System.out.println(s_answer);
            }
            //总的答对数
            String s_answer2 = buf.readLine();
            System.out.println(s_answer2);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (NullPointerException e) {
            e.printStackTrace();

        }
    }
}