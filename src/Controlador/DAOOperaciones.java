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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author juan_
 */
public class DAOOperaciones {
    private Workbook workbook;
    private Sheet Algoritmos,Salidas;
    private final String workingDir = System.getProperty("user.dir") + "\\src\\BD\\BD.xls";

    public DAOOperaciones() {
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

}
