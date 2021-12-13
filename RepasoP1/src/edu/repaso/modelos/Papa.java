package edu.repaso.modelos;

import edu.repaso.adaptadores.AccionesPapa;

public class Papa implements AccionesPapa {
    protected Integer id;
    protected Double precio;
    protected Float peso;

    public Papa() {
    }

    public Papa(Integer id, Double precio, Float peso) {
        this.id = id;
        this.precio = precio;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    @Override
    public void cortar() {
        System.out.println("Se esta cortando una papa cualquiera");
    }

    @Override
    public void cocinar() {

    }

    @Override
    public void empacar() {

    }

    @Override
    public void almacenar() {

    }

    @Override
    public Double obtenerPrecio() {
        return this.precio;
    }

    @Override
    public Integer obtenerIdPapa() {
        return this.id;
    }

    @Override
    public String obtenerNombre() {
        return "Papa";
    }


}
