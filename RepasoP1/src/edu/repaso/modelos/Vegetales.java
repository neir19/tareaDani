package edu.repaso.modelos;

import edu.repaso.adaptadores.AccionesVegetales;

public class Vegetales implements AccionesVegetales {

    public static final Double PRECIO_VEGETALES = 1000d;

    private Integer id;
    private String nombre;

    public Vegetales(){
    }

    public Vegetales(Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void cortar() {
        System.out.println("Se pelan los vegetales y luego se cortan");
    }

    @Override
    public void cocinar() {
        System.out.println("Se lavan los vegetales");
        System.out.println("Se preparan al vapor");
    }

    @Override
    public void empacar() {
        System.out.println("Se separan los vegetales");
        System.out.println("Se empacan al vacio");
    }

    @Override
    public void almacenar() {
        System.out.println("Se separan los vegetales");
        System.out.println("Se guardan en cajas de carton tipo Delicado, con capacidad maxima de 5 KG c/u");
    }

    public static Vegetales procesarLineaArchivoPlano(String linea) {
        String []texto = linea.split(",");
        return new Vegetales(new Integer(texto[0].trim()), texto[1].trim());
    }
}
