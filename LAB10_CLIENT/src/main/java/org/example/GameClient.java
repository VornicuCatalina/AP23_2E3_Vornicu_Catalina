package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 2023; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream())) ) {
            // Send a request to the server
            Scanner scanner=new Scanner(System.in);
            while(true) {
                String request = scanner.nextLine();
                out.println(request);
                // Wait the response from the server ("Hello World!")
                String response = in.readLine();
                System.out.println(response);
                if(response.contains("stopped")){
                    socket.close();
                    break;
                }
                if(response.contains("exit")){
                    socket.close();
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
