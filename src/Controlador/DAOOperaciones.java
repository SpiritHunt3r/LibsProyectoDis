/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author juan_
 */
public class DAOOperaciones {
    private Workbook workbook;
    private Sheet Algoritmos,Salidas;
    private final String workingDir = System.getProperty("user.dir") + "\\src\\BD\\BD.xls";

    public DAOOperaciones() {
        refresh();
        
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
    this.Algoritmos = workbook.getSheet(1);
    this.Salidas = workbook.getSheet(2);
}

public List<String> getSalidas(){
     List<String> lista_salidas = new ArrayList<>();
        for (int line=0;line<this.Salidas.getRows();line++){
            lista_salidas.add(this.Salidas.getCell(0,line).getContents());
        }
        return lista_salidas;

}

public List<String> getAlgoritmos(){
     List<String> lista_algoritmos = new ArrayList<>();
        for (int line=0;line<this.Algoritmos.getRows();line++){
            lista_algoritmos.add(this.Algoritmos.getCell(0,line).getContents());
        }
        return lista_algoritmos;

}


public boolean agregarAlgoritmo(File fichero){
    String nombre = fichero.getName().substring(0, fichero.getName().length()-5);
    String dirAlgoritmos = System.getProperty("user.dir")+"\\src\\Modelo\\"+fichero.getName();
    if (validarAlgoritmo(nombre)){
        Label Nombre = new Label (0,Algoritmos.getRows(),nombre);
        try {
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File(workingDir), workbook);
            WritableSheet excelSheet = writableWorkbook.getSheet(1);
            excelSheet.addCell(Nombre);
            writableWorkbook.write();
            writableWorkbook.close(); 
            Path origenPath = FileSystems.getDefault().getPath(fichero.getPath());
            Path destinoPath = FileSystems.getDefault().getPath(dirAlgoritmos);
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (WriteException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    return false;
}


public boolean eliminarAlgoritmo(String nombre){
    if (!validarAlgoritmo(nombre)){
        int index = getIndexAlgoritmo(nombre);
        System.out.println(index);
        try {
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File(workingDir), workbook);
            WritableSheet excelSheet = writableWorkbook.getSheet(1);
            excelSheet.removeRow(index);
            writableWorkbook.write();
            writableWorkbook.close();
            String dirAlgoritmos = System.getProperty("user.dir")+"/src/Modelo/"+nombre+".java";
            File fichero = new File(dirAlgoritmos);
            if (!fichero.exists()) {
            System.out.println("El archivo java no existe.");
            return false;
            } else {
            fichero.delete();
            System.out.println("El archivo java fue eliminado.");
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (WriteException ex) {
            Logger.getLogger(DaoAlfabetos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    return false;
}

private boolean validarAlgoritmo(String nombre){
    for (int i=0;i<Algoritmos.getRows();i++){
        if(nombre.toUpperCase().equals(this.Algoritmos.getCell(0,i).getContents().toUpperCase())){
            return false;
        }
    }
    return true;
}

private int getIndexAlgoritmo(String nombre){
    for (int i=0;i<Algoritmos.getRows();i++){
        if(nombre.toUpperCase().equals(this.Algoritmos.getCell(0,i).getContents().toUpperCase())){
            return i;
        }
    }
    return -1;
}

}
