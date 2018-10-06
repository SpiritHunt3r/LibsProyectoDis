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
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 
 */
public class DaoAlfabetos implements IValidable,ITransaccional{
    private Workbook workbook;
    private Sheet Alfabetos;
    private final String workingDir = System.getProperty("user.dir") + "\\src\\BD\\BD.xls";
    /**
     * Default constructor
     */
    public DaoAlfabetos() {
        
        refresh();
        
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea una instancia de DAO");
        System.out.println("******************************");
        
        
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
    
    

    @Override
    public boolean agregar(Object obj) {
        Alfabeto alfabeto = (Alfabeto) obj;
        Label Nombre = new Label (0,Alfabetos.getRows(),alfabeto.getNombre());
        Label Simbolos = new Label (1,Alfabetos.getRows(),alfabeto.getSimbolos());
        try {
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File(workingDir), workbook);
            WritableSheet excelSheet = writableWorkbook.getSheet(0);
            excelSheet.addCell(Nombre);
            excelSheet.addCell(Simbolos);
            writableWorkbook.write();
            writableWorkbook.close(); 
            
        } catch (IOException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (WriteException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean modificar(Object obj) {
        Alfabeto alfabeto = (Alfabeto) obj;
        if (alfabeto.getSimbolos().isEmpty()){
            return false;
        }
        else if(alfabeto.getNombre().isEmpty()){
            return false;
        }
        else if (checkUnique(alfabeto.getSimbolos())){
            return false;
        }
        else if(checkRules(alfabeto.getSimbolos())){
            return false;
        }
        Label Nombre = new Label (0,alfabeto.getId(),alfabeto.getNombre());
        Label Simbolos = new Label (1,alfabeto.getId(),alfabeto.getSimbolos());
        try {
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File(workingDir), workbook);
            WritableSheet excelSheet = writableWorkbook.getSheet(0);
            excelSheet.addCell(Nombre);
            excelSheet.addCell(Simbolos);
            writableWorkbook.write();
            writableWorkbook.close();
        } catch (IOException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    

    @Override
    public boolean eliminar(Object obj) {
        Alfabeto alfabeto = (Alfabeto) obj;
        try {
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File(workingDir), workbook);
            WritableSheet excelSheet = writableWorkbook.getSheet(0);
            excelSheet.removeRow(alfabeto.getId());
            writableWorkbook.write();
            writableWorkbook.close();
        } catch (IOException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }


    @Override
    public boolean validar(Object obj) {
        Alfabeto alfabeto = (Alfabeto) obj;
        List<Alfabeto> alfabetos = getAlfabetos();
        if (alfabeto.getSimbolos().isEmpty()){
            return false;
        }
        else if(alfabeto.getNombre().isEmpty()){
            return false;
        }
        else if (checkUnique(alfabeto.getSimbolos())){
            return false;
        }
        else if(checkRules(alfabeto.getSimbolos())){
            return false;
        }
        else{
            Alfabeto k;
            for (Object tmp:alfabetos){
                k = (Alfabeto) tmp;
                if (k.getSimbolos().equals(alfabeto.getSimbolos())){
                    return false;
                }
                
                if (k.getNombre().toUpperCase().equals(alfabeto.getNombre().toUpperCase())){
                    return false;
                }
                
            }
        }
        return true;
    }
    
    
    
    private static boolean checkUnique(CharSequence g) {
    for (int i = 0; i < g.length(); i++) {
        for (int j = i + 1; j < g.length(); j++) {
            if (g.charAt(i) == g.charAt(j)) {
                return true;
            }
        }
    }
    return false;
    }
    
    private static boolean checkRules(CharSequence g) {
    for (int i = 0; i < g.length(); i++) {
        if (Character.isWhitespace(g.charAt(i))) {
                return true;
        }
        if (g.charAt(i) == '*'){
            return true;
        }
    }
    return false;
    }
    
    public void refresh(){
        try{
            workbook.close();
        }
        catch (Exception e){
            
        }
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
    }
    
   

}