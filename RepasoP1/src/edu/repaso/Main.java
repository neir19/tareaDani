package edu.repaso;

import edu.repaso.modelos.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tortilla[] tortillas = crearInstanciasTortillas();
        Tortilla[] tortillasParte2 = new Tortilla[3];
        mostrarCostoTortillas(tortillas);
        mostrarVegetalesTortillasImpares(tortillas);

        //mostrarCostoTortillas(tortillasParte2);
        //mostrarVegetalesTortillasImpares(tortillasParte2);

        //Entrada de elementos por pantalla, con string
        //solicitarDatosPantallaString(tortillas);
        //Entrada de elementos por pantalla, con Integer
        //solicitarDatosPantallaInteger(tortillas);

        //Crear una Tortilla con los datos de un archivo plano
        System.out.println("La tortilla cargada desde el plano fue: ");
        Tortilla tortillaPlano = crearTortillaDesdePlano();
        System.out.println(tortillaPlano);
        tortillaPlano.verVegetalesTortilla();

    }

    private static Tortilla[] crearInstanciasTortillas(){
        //Creacion de huevos
        Huevo h1 = new Huevo(10, 80f);
        Huevo h2 = new Huevo(14, 60f);
        Huevo h3 = new Huevo(18, 120f);
        Huevo[] huevos = {h1, h2, h3};

        //Creacion de papas
        PapaCriolla papaCriolla = new PapaCriolla(100, 30f, 5);
        PapaNevada papaNevada = new PapaNevada(205, 160f,
                "parejas", "morado y amarillo");
        PapaPastusa papaPastusa = new PapaPastusa(300, 200.5f);

        //Creacion de vegetales
        Vegetales v1 = new Vegetales(1, "cebolla");
        Vegetales v2 = new Vegetales(2, "pimenton");
        Vegetales v3 = new Vegetales(3, "setas");
        Vegetales v4 = new Vegetales(4, "tomates");
        ArrayList<Vegetales> vegetales = new ArrayList<>();
        vegetales.add(v1);
        vegetales.add(v2);
        vegetales.add(v3);
        vegetales.add(v4);

        //Creacion de tortillas
        Tortilla t1 = new Tortilla("tortilla criolla", huevos, papaCriolla, vegetales);
        Tortilla t2 = new Tortilla("tortilla nevada", huevos, papaNevada, vegetales);
        Tortilla t3 = new Tortilla("tortilla", huevos, papaPastusa, vegetales);

        return new Tortilla[]{t1, t2, t3};
    }

    private static Double calcularPrecioTortilla(Tortilla tortilla){
        return Huevo.PRECIO_HUEVOS * tortilla.getHuevos().length +
                    Vegetales.PRECIO_VEGETALES * tortilla.getVegetales().size() +
                    tortilla.getPapa().obtenerPrecio();
    }

    //Funcion para mostrar el nombre y costo de todas las tortillas
    private static void mostrarCostoTortillas(Tortilla[] tortillas) {
        try {
            System.out.println("**********COSTO DE TODAS LAS TORTILLAS**********");
            for (Tortilla tortillaActual : tortillas) {
                System.out.println("La " + tortillaActual.getNombre() +
                        " tiene un costo de " + calcularPrecioTortilla(tortillaActual));
            }
        } catch (NullPointerException nex) {
            System.err.println("ERROR: El vector de tortillas esta vacio, por favor envie un vector lleno");
        } catch (Exception ex) {
            System.err.println("Error desconocido " + ex.getMessage());
        }
    }

    //Funcion para mostrar los nombres de los vegetales de las tortillas impares
    private static void mostrarVegetalesTortillasImpares(Tortilla[] tortillas) {
        try {
            System.out.println("**********LISTA DE VEGETALES TORTILLAS IMPARES**********");
            for (int i = 0; i <= tortillas.length; i += 2) {
                tortillas[i].verVegetalesTortilla();
            }
        } catch (NullPointerException nex) {
            System.err.println("ERROR: El vector de tortillas esta vacio, por favor envie un vector lleno");
        } catch (Exception ex) {
            System.err.println("Error desconocido " + ex.getMessage());
        }
    }

    //Ejemplo de entrada de elementos por pantalla con String
    private static void solicitarDatosPantallaString(Tortilla[] tortillas){
        boolean existeTortilla = false;
        try {
            System.out.println("***************************************************");
            System.out.println("**********SOLICITUD DE DATOS POR PANTALLA**********");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenido! Por favor escriba el nombre de la tortilla cuyo costo desea consultar:");
            String nombreABuscar = scanner.nextLine();

            for(Tortilla tortillaActual : tortillas){
                if(tortillaActual.getNombre().equalsIgnoreCase(nombreABuscar)){
                    System.out.format("El precio de la "+ tortillaActual.getNombre()
                            + " es $ %.2f", calcularPrecioTortilla(tortillaActual));
                    existeTortilla = true;
                    break;
                }
            }

        } catch (Exception ex) {
            System.err.println("Error desconocido " + ex.getMessage());
        } finally {
            if(!existeTortilla){
                System.out.println("No se ha encontrado una tortilla con ese nombre");
            }
        }
    }

    //Ejemplo de entrada de elementos por pantalla con Integer
    private static void solicitarDatosPantallaInteger(Tortilla[] tortillas){
        boolean existeTortilla = false;
        try {
            System.out.println("*************************************************************");
            System.out.println("**********SOLICITUD DE DATOS POR PANTALLA (Integer)**********");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bienvenido! Por favor escriba el id de la papa, que se usa en la tortilla que desea ver:");
            Integer idABuscar = scanner.nextInt();
            scanner.nextLine(); //Se ubica aqui para leer el salto de linea luego del enter
            System.out.println("Por favor escriba su nombre:");
            String nombreUsuario = scanner.nextLine();

            for(Tortilla tortillaActual : tortillas){
                if(tortillaActual.getPapa().obtenerIdPapa().equals(idABuscar)){
                    System.out.println(nombreUsuario +" la tortilla buscada es "+ tortillaActual);
                    tortillaActual.verVegetalesTortilla();
                    existeTortilla = true;
                    break;
                }
            }

        } catch (Exception ex) {
            System.err.println("Error desconocido " + ex.getMessage());
        } finally {
            if(!existeTortilla){
                System.out.println("No se ha encontrado una tortilla que tenga una papa con ese id");
            }
        }
    }

    private static Tortilla crearTortillaDesdePlano(){
        Tortilla tortilla = new Tortilla();
        //Creacion de huevos
        Huevo h1 = new Huevo(10, 80f);
        Huevo h2 = new Huevo(14, 60f);
        Huevo h3 = new Huevo(18, 120f);
        Huevo[] huevos = {h1, h2, h3};

        //Creacion de papa
        PapaPastusa papaPastusa = new PapaPastusa(300, 200.5f);

        try {
            System.out.println("*********************************************************");
            System.out.println("**********LECTURA DE DATOS DESDE ARCHIVO PLANO**********");
            File file = new File("/Users/jjaramillo/Documents/JAVA 2/RepasoP1/src/edu/repaso/tortilla.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String lineaActual = scanner.nextLine();
                tortilla = tortilla.procesarLineaArchivoPlano(lineaActual);
                tortilla.setHuevos(huevos);
                tortilla.setPapa(papaPastusa);
            }

        }catch (Exception ex) {
            System.err.println("Error desconocido " + ex.getMessage());
        }
        return tortilla;
    }
}
