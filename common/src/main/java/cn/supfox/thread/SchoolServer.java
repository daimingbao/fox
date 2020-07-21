package cn.supfox.thread;

import java.net.*;
import java.io.*;

public class SchoolServer {

    ServerSocket server;
    Socket sock;
    int port;

    public static void main(String[] args) throws Exception{	
	SchoolServer s = new SchoolServer(Integer.parseInt(args[0]));
	s.go();
    }


    public SchoolServer(int p) throws Exception{
	port = p;
	server = new ServerSocket(port);
    }

    public void go() throws Exception{
	while (true) {
	    sock = server.accept();	    
	    BufferedReader in =
		new BufferedReader(new InputStreamReader(sock.getInputStream()));
	    PrintWriter out = new PrintWriter(sock.getOutputStream());
	    out.println("Enter your name : ");
	    out.flush();
	    String name = in.readLine();
	    boolean nb_ask = false;
	    int nq = 0;
	    while (!nb_ask){
		out.println("Enter number of questions :");
		out.flush();
		String nqstr = in.readLine();
		try {
		    nqstr = nqstr.trim();
		    nq = Integer.parseInt(nqstr);
		    nb_ask = true;
		    out.println("OK");
		    out.flush();
		}catch(NumberFormatException e){
		    nb_ask = false;
		    out.println("NO");
		    out.flush();
		}
	    }
	    int score = 0;
	    for (int i = 0; i < nq; i++){
		int rdm1 = (int) (Math.random() * 9);
		int rdm2 = (int) (Math.random() * 9);
		out.println(rdm1 + " * " + rdm2 + " = ");
		out.flush();
		String respstr = in.readLine();
		if(respstr == null) // saisie vide
		    respstr = "";
		respstr = respstr.trim();
		int resp = 0;
		try {
		    resp = Integer.parseInt(respstr);
		    if (resp == rdm1 * rdm2){
			score++;
			out.println("OK");
		    } else
			out.println("NO");
		    out.flush();
		    
		} catch (NumberFormatException e){
		    out.println("NO");
		    out.flush();
		}
	    
	    }
	    out.println(name + ", you got " + score + " pts");
	    out.flush();
	    sock.close();
	}
    }
}

		    
	
