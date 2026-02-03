package de.etg.psp.examen.servidor;

public class Historico {

    private int totalSimples;
    private int totalComplejas;

    private double totalCoste;

    public synchronized void sumar(boolean comprobacion) {
        if (comprobacion) {
            totalSimples++;
        } else {
            totalComplejas++;
        }
    }

}
