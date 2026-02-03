package de.etg.psp.examen.common;

import static de.etg.psp.examen.common.ICuenta.COSTE_SIMPLE;
import static de.etg.psp.examen.common.ICuenta.VAL_DIV;
import static de.etg.psp.examen.common.ICuenta.VAL_MULTI;
import static de.etg.psp.examen.common.ICuenta.VAL_POTENCIA;
import static de.etg.psp.examen.common.ICuenta.VAL_RESTA;
import static de.etg.psp.examen.common.ICuenta.VAL_SUMA;

public enum Cuenta {
    SUMA(VAL_SUMA, COSTE_SIMPLE), RESTA(VAL_RESTA, COSTE_SIMPLE), MULTI(VAL_MULTI, COSTE_SIMPLE),
    DIV(VAL_DIV, COSTE_SIMPLE), POT(VAL_POTENCIA, COSTE_SIMPLE);

    private final String valor;
    private final double coste;

    private Cuenta(String valor, double coste) {
        this.valor = valor;
        this.coste = coste;
    }

    public String getValor() {
        return valor;
    }

    public double getCoste() {
        return coste;
    }

    public static Cuenta obtenerCuenta(String cuenta) throws IllegalArgumentException {
        for (Cuenta cuen : values()) {
            if (cuen.getValor().equalsIgnoreCase(cuenta)) {
                return cuen;
            }
        }
        throw new IllegalArgumentException();
    }

}
