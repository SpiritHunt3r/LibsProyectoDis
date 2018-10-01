package Modelo;



import java.util.*;
import Controlador.DTOAlgoritmos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        String print = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        print += "Fecha y Hora: "+dtf.format(now)+"\n";
        print += "Frase de Origen: "+ dto.getFraseOrigen()+ "\n******************************\n";
        for (int i=0;i<dto.getResultados().size();i++){
            print += dto.getResultados().get(i) + "\n******************************\n";
        }
        System.out.println(print);
        return true;
    }

}