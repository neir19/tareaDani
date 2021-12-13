package edu.repaso.modelos;

public class PapaPastusa extends Papa {

    private static final Double PRECIO_PAPA_PASTUSA = 250d;

    public PapaPastusa() {
        this.precio = PRECIO_PAPA_PASTUSA;
    }

    public PapaPastusa(Integer id, Float peso) {
        super(id, PRECIO_PAPA_PASTUSA, peso);
    }

    @Override
    public void cortar() {
        System.out.println("Se lava la papa pastusa");
        System.out.println("Se pela la papa pastusa");
        System.out.println("Se esta cortando la papa pastusa");
    }

    @Override
    public String obtenerNombre() {
        return "Papa Pastusa";
    }
}
