package de.etg.psp.examen.cliente;

import java.io.IOException;
import java.net.Socket;

import de.etg.psp.examen.common.Conexion;
import de.etg.psp.examen.servidor.Server;

public class Cliente {

    public static void main(String[] args) {
        try (Socket socket = new Socket(Server.HOST, Server.PUERTO)) {

            Conexion.enviar(args[0], socket);

            String respuesta = Conexion.recibir(socket);
            System.out.println(respuesta);
        } catch (IOException e) {

        }
    }
}
