package de.etg.psp.examen.servidor;

import java.io.IOException;
import java.net.Socket;

import de.etg.psp.examen.common.Conexion;
import de.etg.psp.examen.common.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Calculadora implements Runnable {

    public static final int PARAM_CERO = 0;
    public static final int PARAM_UNO = 1;
    public static final int PARAM_DOS = 2;

    public static final String COMA = ",";

    private final Socket cliente;
    private final Historico historico;

    @Override
    public void run() {
        try {
            String[] peticion = Conexion.recibir(cliente).split(COMA);

            int n1 = Integer.parseInt(peticion[PARAM_CERO]);
            int n2 = Integer.parseInt(peticion[PARAM_DOS]);

            String cuenta = peticion[PARAM_UNO];

            try {
                Cuenta cuen = Cuenta.obtenerCuenta(cuenta);
                int resultado = calcular(cuen, n1, n2);
                Conexion.enviar(String.valueOf(resultado), cliente);
            } catch (Exception e) {
            }

        } catch (IOException e) {

        }

    }

    private int calcular(Cuenta cuenta, int n1, int n2) {
        switch (cuenta) {
            case SUMA -> {
                return n1 + n2;
            }
            case RESTA -> {
                return n1 - n2;
            }
            case MULTI -> {
                return n1 * n2;
            }
            case DIV -> {
                return n1 / n2;
            }
            case POT -> {
                return n1 ^ n2;
            }
            default -> throw new AssertionError();
        }
    }
}
