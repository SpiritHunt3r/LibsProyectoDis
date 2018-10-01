package Modelo;


import java.util.*;

/**
 * 
 */
public class Alfabeto {

    /**
     * Default constructor
     */
    public Alfabeto() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea una instancia de Alfabeto");
        System.out.println("******************************");
    }

    public Alfabeto(int id, String nombre, String simbolos) {
        this.id = id;
        this.nombre = nombre;
        this.simbolos = simbolos;
    }
    

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String simbolos;



    /**
     * @param s 
     * @return
     */
    public boolean validar(String s) {
        // TODO implement here
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(String simbolos) {
        this.simbolos = simbolos;
    }

    
    
}