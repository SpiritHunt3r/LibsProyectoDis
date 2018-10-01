package Controlador;


import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class DTOAlgoritmos implements Serializable {

    /**
     * Default constructor
     */
    public DTOAlgoritmos() {
        DAOOperaciones data = new DAOOperaciones();
        this.lasSalidas = data.getSalidas();
        this.losAlgoritmos = data.getAlgoritmos();
        System.out.println();
        System.out.println("******************************");
        System.out.println("Se crea una instancia de DTO");
        System.out.println("******************************");
    }

    /**
     * 
     */
    private int elAlfabeto;

    /**
     * 
     */
    private String fraseOrigen;

    /**
     * 
     */
    private List<String> algoritmosSelec;

    /**
     * 
     */
    private List<String> salidasSelec;

    /**
     * 
     */
    private List<String> resultados;

    /**
     * 
     */
    private boolean modoCodificacion;
    private List<String> losAlgoritmos;
    private List<String> lasSalidas;
    private int cifra;
    private String palabraclave;

    public int getElAlfabeto() {
        return elAlfabeto;
    }

    public void setElAlfabeto(int elAlfabeto) {
        this.elAlfabeto = elAlfabeto;
    }

    public String getFraseOrigen() {
        return fraseOrigen;
    }

    public void setFraseOrigen(String fraseOrigen) {
        this.fraseOrigen = fraseOrigen;
    }

    public List<String> getAlgoritmosSelec() {
        return algoritmosSelec;
    }

    public void setAlgoritmosSelec(List<String> algoritmosSelec) {
        this.algoritmosSelec = algoritmosSelec;
    }

    public List<String> getSalidasSelec() {
        return salidasSelec;
    }

    public void setSalidasSelec(List<String> salidasSelec) {
        this.salidasSelec = salidasSelec;
    }

    public List<String> getResultados() {
        return resultados;
    }

    public void setResultados(List<String> resultados) {
        this.resultados = resultados;
    }


    public boolean isModoCodificacion() {
        return modoCodificacion;
    }

    public void setModoCodificacion(boolean modoCodificacion) {
        this.modoCodificacion = modoCodificacion;
    }

    public List<String> getLosAlgoritmos() {
        return losAlgoritmos;
    }

    public void setLosAlgoritmos(List<String> losAlgoritmos) {
        this.losAlgoritmos = losAlgoritmos;
    }

    public List<String> getLasSalidas() {
        return lasSalidas;
    }

    public void setLasSalidas(List<String> lasSalidas) {
        this.lasSalidas = lasSalidas;
    }

    public int getCifra() {
        return cifra;
    }

    public void setCifra(int cifra) {
        this.cifra = cifra;
    }

    public String getPalabraclave() {
        return palabraclave;
    }

    public void setPalabraclave(String palabraclave) {
        this.palabraclave = palabraclave;
    }
    
    
    

    
}