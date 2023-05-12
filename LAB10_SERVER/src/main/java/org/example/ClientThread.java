package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.GameServer.closedServer;

public class ClientThread extends Thread {
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private int kick=0;

    public ClientThread(Socket socket, ServerSocket socketServer) {
        this.socket = socket;
        this.serverSocket = socketServer;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            // Send the response to the output stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String reply;
            while(!closedServer){
                    String request = in.readLine();
                    kick++;
                    System.out.println(request);
                    if (request.compareTo("stop") == 0) {
                        reply = "The server stopped";
                        out.println(reply);
                        out.flush();
                        closedServer = true;
                        socket.close();
                        serverSocket.close();
                        System.out.println("Closed server");
                    } else {
                        if(kick>=3){
                            reply="exit , you are kicked";
                            out.println(reply);
                            out.flush();
                            break;
                        }
                        else{
                            reply = "Server received the request";
                            out.println(reply);
                            out.flush();
                        }
                    }
                }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }

    }
}
