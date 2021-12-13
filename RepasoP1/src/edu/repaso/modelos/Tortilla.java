package edu.repaso.modelos;

import edu.repaso.adaptadores.AccionesPapa;

import java.util.ArrayList;

public class Tortilla {

    private String nombre;
    private Huevo []huevos;
    private AccionesPapa papa; //Atributo de tipo interfaz, para recibir cuaqluier tipo de papa
    private ArrayList<Vegetales> vegetales;

    public Tortilla() {
        this.huevos = new Huevo[3];
    }

    public Tortilla(String nombre, Huevo[] huevos, AccionesPapa papa, ArrayList<Vegetales> vegetales) {
        this.nombre = nombre;
        this.huevos = huevos;
        this.papa = papa;
        this.vegetales = vegetales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Huevo[] getHuevos() {
        return huevos;
    }

    public void setHuevos(Huevo[] huevos) {
        this.huevos = huevos;
    }

    public AccionesPapa getPapa() {
        return papa;
    }

    public void setPapa(AccionesPapa papa) {
        this.papa = papa;
    }

    public ArrayList<Vegetales> getVegetales() {
        return vegetales;
    }

    public void setVegetales(ArrayList<Vegetales> vegetales) {
        this.vegetales = vegetales;
    }

    @Override
    //tiene el mismo nombre, el mismo numero de huevos, el mismo tipo de papa y el mismo numero de vegetales.
    public boolean equals(Object obj) {
        Tortilla tortillaObj = (Tortilla) obj;
        return tortillaObj.getNombre().equalsIgnoreCase(this.nombre) &&
               tortillaObj.getHuevos().length == this.huevos.length &&
               tortillaObj.getPapa().getClass().equals(this.papa.getClass()) &&
               tortillaObj.getVegetales().size() == this.vegetales.size();
    }

    public void verVegetalesTortilla() {
        try {
            for (Vegetales vegetalActual : this.vegetales) {
                System.out.println(vegetalActual.getNombre());
            }
            System.out.print("\n");
        } catch (Exception ex) {
            System.err.println("Error inesperado " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "\n---------------------------------\n"+
                "NOMBRE: " +this.nombre +
                "\nPAPA: " + this.getPapa().obtenerNombre() +
                "\nVEGETALES: \n";
    }

    public Tortilla procesarLineaArchivoPlano(String linea){
        Tortilla tortilla = new Tortilla();
        ArrayList<Vegetales> listaVegetales = new ArrayList<>();
        String []lineaTortilla = linea.split("\\|");
        String []nombre = lineaTortilla[0].split("NOMBRE: ");
        tortilla.nombre = nombre[1];

        String []vegetales = lineaTortilla[1].split("VEGETALES: ")[1].split(";");
        for(String lineaVegatales : vegetales){
            listaVegetales.add(Vegetales.procesarLineaArchivoPlano(lineaVegatales));
        }
        tortilla.vegetales = listaVegetales;
        return tortilla;
    }
}

