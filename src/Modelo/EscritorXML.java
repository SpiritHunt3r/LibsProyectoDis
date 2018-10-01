package Modelo;



import java.util.*;
import Controlador.DTOAlgoritmos;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 
 */
public class EscritorXML implements IEscritor{

    /**
     * Default constructor
     */
    public EscritorXML() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea un escritor de XML");
        System.out.println("******************************");
    }


    /**
     * @param dto 
     * @return
     */
    public boolean escribir(DTOAlgoritmos dto) {
        String dir = System.getProperty("user.home") + "/Desktop/";
        String fileName = dir+"Resultados.xls";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        WritableWorkbook workbook;
        try {
            workbook = Workbook.createWorkbook(new File(fileName));
            WritableSheet writablesheet1 = workbook.createSheet("Sheet1", 0);
            int cell = 5;
            Label R;
            Label Fecha = new Label(0, 0, "Fecha y Hora: "+dtf.format(now));
            Label Frase = new Label(0,1,"Frase de Origen: "+ dto.getFraseOrigen());
            Label Cifra = new Label(0,2,"Cifra: "+String.valueOf(dto.getCifra()));
            Label Palabra = new Label (0,3,"Palabra Clave: "+dto.getPalabraclave());
            Label Separador = new Label (0,4,"******************************");
            writablesheet1.addCell(Fecha);
            writablesheet1.addCell(Frase);
            writablesheet1.addCell(Cifra);
            writablesheet1.addCell(Palabra);
            writablesheet1.addCell(Separador);
            for (int i=0;i<dto.getResultados().size();i++){
                R = new Label (0,cell,dto.getResultados().get(i));
                cell++;
                Separador = new Label (0,cell,"******************************");
                cell++;
                writablesheet1.addCell(R);
                writablesheet1.addCell(Separador);
            }
            workbook.write();
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(EscritorXML.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (WriteException ex) {
            Logger.getLogger(EscritorXML.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }

}