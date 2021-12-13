package edu.repaso.modelos;

import edu.repaso.adaptadores.AccionesPapa;

public class PapaCriolla extends Papa implements AccionesPapa {

    private static final Double PRECIO_PAPA_CRIOLLA = 400d;

    private Integer numeroHuecos;

    public PapaCriolla() {
        this.precio = PRECIO_PAPA_CRIOLLA;
    }

    public PapaCriolla(Integer id, Float peso, Integer numeroHuecos) {
        super(id, PRECIO_PAPA_CRIOLLA, peso);
        this.numeroHuecos = numeroHuecos;
    }

    public Integer getNumeroHuecos() {
        return numeroHuecos;
    }

    public void setNumeroHuecos(Integer numeroHuecos) {
        this.numeroHuecos = numeroHuecos;
    }

    @Override
    public void cortar() {
        System.out.println("Se sacan de cada hueco, los ojos de la papa criolla");
        System.out.println("Se esta cortando la papa criolla");
    }

    @Override
    public String obtenerNombre() {
        return "Papa Criolla";
    }
}
