package Modelo;



import java.util.*;
import Controlador.DTOAlgoritmos;

/**
 * 
 */
public class EscritorTxT implements IEscritor {

    /**
     * Default constructor
     */
    public EscritorTxT() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea un escritor de TXT");
        System.out.println("******************************");
    }


    /**
     * @param dto 
     * @return
     */
    public boolean escribir(DTOAlgoritmos dto) {
        
        return true;
    }

}