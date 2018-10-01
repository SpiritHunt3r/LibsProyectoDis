package Modelo;


import java.util.*;
import Controlador.DTOAlgoritmos;

/**
 * 
 */
public class EscritorPDF implements IEscritor{

    /**
     * Default constructor
     */
    public EscritorPDF() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea un escritor de PDF");
        System.out.println("******************************");
    }


    /**
     * @param dto 
     * @return
     */
    public boolean escribir(DTOAlgoritmos dto) {
        // TODO implement here
        return true;
    }

}