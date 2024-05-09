/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author Windows
 */
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(7878)) {
            System.out.println("Server is running on port 7878");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                System.out.println("Client IP: " + socket.getInetAddress().getHostName());

                Server temp = new Server();
                Thread t = new Thread(temp.new ClientHandler(socket));
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class ClientHandler implements Runnable {

        private Socket socket;

        public ClientHandler(Socket socket) {
            super();
            this.socket = socket;
        }

        @Override
        public void run() {

            try {

                DataInputStream in = new DataInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                int choice = 0;

                while (true) {

                    choice = in.readInt();
                    switch (choice) {
                        case 1:
                            String title = in.readUTF();
                            break;
                        case 2:
                            break;
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
