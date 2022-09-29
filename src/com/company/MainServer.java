package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    private static Socket socket;
    private static ServerSocket server;
    private static BufferedReader in; // поток чтения
    private static BufferedWriter out; // поток записи

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(4004);//прослушиваем порт
                socket = server.accept(); //ждем, когда подключатся
                try {
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//принятие сообщений
                    out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//отправление сообщений
                    int res = Calculator.calculator(in.readLine());
                    out.write(res + "\n");
                    out.flush();
                } finally { // закрываем потоки
                    socket.close();
                    in.close();
                    out.close();
                }
            } finally {
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
