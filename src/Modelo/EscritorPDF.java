package Modelo;


import java.util.*;
import Controlador.DTOAlgoritmos;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;



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
        PdfWriter writer = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        try {
            String dir = System.getProperty("user.home") + "/Desktop/";
            String DEST = dir + "Resultados.pdf";
            File file = new File(DEST);
            file.getParentFile().mkdirs();
            writer = new PdfWriter(DEST);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph("Fecha y Hora: "+dtf.format(now)));
            document.add(new Paragraph("Frase de Origen: "+ dto.getFraseOrigen()));
            document.add(new Paragraph("Cifra: "+String.valueOf(dto.getCifra())));
            document.add(new Paragraph("Palabra Clave: "+dto.getPalabraclave()));
            document.add(new Paragraph("******************************"));
            for (int i=0;i<dto.getAlgoritmosSelec().size();i++){
                document.add(new Paragraph(dto.getResultados().get(i)));
                document.add(new Paragraph("******************************"));
            }
            document.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscritorPDF.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(EscritorPDF.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }
    
     

}