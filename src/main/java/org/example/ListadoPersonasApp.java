package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        //Definimos el ciclo while
        List<Persona> personas = new ArrayList<>();
        var salir = false;
        while (!salir){
            Menu();
            try {
                salir = ejecutarOperacion(consola,personas);
            }catch (Exception e){
                System.out.println("ocurrio un error: "+e.getMessage());
            }

            System.out.println();

        }

    }
    private static void Menu(){
        //mostrar las opciones
        System.out.print("""
                **** listados personas app ***
                1. agregar
                2. listar 
                3. salir
                """);
        System.out.print("elije una opcion? ");


    }
    private static boolean ejecutarOperacion(Scanner consola,List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        //revisamos la opcion porporcionada
        switch (opcion){
            case 1 ->{
                agregarPersona(consola,personas);
            }// fin caso1

            case 2 -> {
                listarPersonas(personas);
            }
            case 3 ->{
                System.out.println("hasta pronto...");
                salir= true;
            }
            default -> System.out.println("opcion erronea"+ opcion);
        }//fin swich
        return salir;
    }

    private static void agregarPersona(Scanner consola,List<Persona> personas){
        //agregar persona a la lista
        System.out.print("Escribe el nombre: ");
        var nombre = consola.nextLine();
        System.out.print("dijita tu numero de telefono: ");
        var tel = consola.nextLine();
        System.out.print("escribe tu email: ");
        var email = consola.nextLine();
        //crear el objeto
        var persona = new Persona(nombre,tel,email);
        //lo agregamos a la lista
        personas.add(persona);
        System.out.println("la lista tiene: " +personas.size());
    }
    private  static  void listarPersonas(List<Persona> personas){
        System.out.println("listado de personas");
       // personas.forEach((persona -> System.out.println()));
        personas.forEach(System.out::println);
    }

}