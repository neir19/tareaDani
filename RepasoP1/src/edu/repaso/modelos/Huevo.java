package edu.repaso.modelos;

import edu.repaso.adaptadores.AccionesHuevo;

public class Huevo implements AccionesHuevo {

    public static final String HUEVOS_COCINADOS = "cocinados";
    public static final String HUEVOS_POCHADOS = "pochados";
    public static final String HUEVOS_PERICOS = "pericos";
    public static final String HUEVOS_REVUELTOS = "revueltos";
    public static final Double PRECIO_HUEVOS = 500d;

    //Atributos
    //Visibilidad, tipo de dato, nombre de atributo
    private Integer id;
    private Float gramos;

    //Metodos o funciones
    //Constructor por defecto
    public Huevo(){
        this.id = -1;
        this.gramos = 0f;
    }

    //Constructor por parametros
    public Huevo(Integer id, Float gramos){
        this.id = id;
        this.gramos = gramos;
    }

    //Visibilidad, tipo de dato de retorno, nombre de metodo
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getGramos() {
        return gramos;
    }

    public void setGramos(Float gramos) {
        this.gramos = gramos;
    }

    @Override
    public void pelar(String tipoCoccion) {
        if(HUEVOS_COCINADOS.equalsIgnoreCase(tipoCoccion)){
            this.cocinar(tipoCoccion);
            System.out.println("Se lavan con agua fria");
            System.out.println("Se les da un golpe con  una cuchara");
            System.out.println("Se quita la cascara con los dedos para cada huevo");
        }
        else{
            System.out.println("Se quiebran los huevos");
        }
    }

    @Override
    public void cocinar(String tipoCoccion) {
        switch (tipoCoccion){
            case HUEVOS_COCINADOS:
                System.out.println("Se ponen en agua caliente por al menos 10 minutos");
                break;

            case HUEVOS_POCHADOS:
                System.out.println("Se echan en agua hirviendo");
                System.out.println("Se mezcla con el agua hasta que esta se evapore");
                break;

            case HUEVOS_PERICOS:
                System.out.println("Se sofrien primero la cebolla y el tomate en el sarten");
                System.out.println("Se agregan los huevos al sarten y se revuelve todo");
                break;

            case HUEVOS_REVUELTOS:
                System.out.println("Se agregan los huevos al sarten y se revuelve todo");
                break;

            default:
                System.out.println("No se pueden preparar los huevos con el tipo de coccion dado");
                break;
        }
    }
}
