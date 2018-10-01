package Controlador;



import Modelo.Alfabeto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 
 */
public class DaoAlfabetos {
    private Workbook workbook;
    private Sheet Alfabetos;
    private final String workingDir = System.getProperty("user.dir") + "\\src\\BD\\BD.xls";
    /**
     * Default constructor
     */
    public DaoAlfabetos() {
        
        try {
            BufferedReader file = new BufferedReader( new FileReader(workingDir), 1024);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.workbook = Workbook.getWorkbook(new File(workingDir));
        } catch (IOException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Alfabetos = workbook.getSheet(0);
        
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea una instancia de DAO");
        System.out.println("******************************");
        
        
    }



    /**
     * @param obj 
     * @return
     */
    public boolean validar(Object obj) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    
    public List<Alfabeto> getAlfabetos() {
        List<Alfabeto> lista_alfabetos = new ArrayList<>();
        for (int line=0;line<this.Alfabetos.getRows();line++){
            Alfabeto e = new Alfabeto(line,this.Alfabetos.getCell(0,line).getContents(),this.Alfabetos.getCell( 1,line).getContents());
            lista_alfabetos.add(e);
        }
        return lista_alfabetos;
    }

}