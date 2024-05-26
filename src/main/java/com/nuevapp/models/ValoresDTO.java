package com.nuevapp.models;

public class ValoresDTO {

    private ValoresDTO(){}

    private static String ValorUno;
    private static String ValorDos;
    private static String operacion;
    private static String ValorResultado;

    public static String getOperacion() {
        return operacion;
    }

    public static void setOperacion(String operacion) {
        ValoresDTO.operacion = operacion;
    }

    public static String getValorUno() {
        return ValorUno;
    }

    public static void setValorUno(String valorUno) {
        ValorUno = valorUno;
    }

    public static String getValorDos() {
        return ValorDos;
    }

    public static void setValorDos(String valorDos) {
        ValorDos = valorDos;
    }

    public static String getValorResultado() {
        return ValorResultado;
    }

    public static void setValorResultado(String valorResultado) {
        ValorResultado = valorResultado;
    }

}
