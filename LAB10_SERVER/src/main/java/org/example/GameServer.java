package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 2023;
    public static boolean closedServer = false;
    public static boolean emergency = false;

    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (!closedServer) {
                Socket socket = serverSocket.accept();
                new ClientThread(socket,serverSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Problem");
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer gameServer = new GameServer();
    }
}
