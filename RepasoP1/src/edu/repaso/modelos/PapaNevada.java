package edu.repaso.modelos;

public class PapaNevada extends Papa {

    private static final Double PRECIO_PAPA_NEVADA = 750d;

    private String vetas;
    private String colores;

    public PapaNevada() {
        this.precio = PRECIO_PAPA_NEVADA;
    }

    public PapaNevada(Integer id, Float peso, String vetas, String colores) {
        super(id, PRECIO_PAPA_NEVADA, peso);
        this.vetas = vetas;
        this.colores = colores;
    }

    public String getVetas() {
        return vetas;
    }

    public void setVetas(String vetas) {
        this.vetas = vetas;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    @Override
    public void cortar() {
        System.out.println("Se esta cortando la papa nevada");
    }

    @Override
    public String obtenerNombre() {
        return "Papa Nevada";
    }
}
