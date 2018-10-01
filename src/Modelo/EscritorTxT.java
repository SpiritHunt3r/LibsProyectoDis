package Modelo;



import java.util.*;
import Controlador.DTOAlgoritmos;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        try {
            String dir = System.getProperty("user.home") + "/Desktop/";
            PrintWriter writer = new PrintWriter(dir+"Resultados.txt", "UTF-8");
            writer.println("Fecha y Hora: "+dtf.format(now));
            writer.println("Frase de Origen: "+ dto.getFraseOrigen());
            writer.println("Cifra: "+String.valueOf(dto.getCifra()));
            writer.println("Palabra Clave: "+dto.getPalabraclave());
            writer.println("\n******************************\n");
            for (int i=0;i<dto.getAlgoritmosSelec().size();i++){
                writer.println(dto.getResultados().get(i));
                writer.println("\n******************************\n");
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscritorTxT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EscritorTxT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}