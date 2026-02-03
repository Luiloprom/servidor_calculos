package de.etg.psp.examen.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PUERTO = 8080;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PUERTO)) {
            Historico historico = new Historico();

            while (true) {
                Socket cliente = server.accept();
                Thread hilo = new Thread(new Calculadora(cliente, historico));
                hilo.start();
            }
        } catch (IOException e) {

        }
    }
}