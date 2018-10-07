/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;


import Controlador.DTOAlgoritmos;
import java.io.Serializable;

/**
 *
 * @author ayma-93
 */
public class ObjetoComunicador implements Serializable{
    Object datoEntrada;
    TipoAccion accion;
    Object datoSalida;
    DTOAlgoritmos datos;

    public DTOAlgoritmos getDatos() {
        return datos;
    }

    public void setDatos(DTOAlgoritmos datos) {
        this.datos = datos;
    }

    public ObjetoComunicador(Object datoEntrada, TipoAccion accion) {
        this.datoEntrada = datoEntrada;
        this.accion = accion;
    }

    public TipoAccion getAccion() {
        return accion;
    }

    public void setAccion(TipoAccion accion) {
        this.accion = accion;
    }

    public Object getDatoEntrada() {
        return datoEntrada;
    }

    public void setDatoEntrada(Object datoEntrada) {
        this.datoEntrada = datoEntrada;
    }

    public Object getDatoSalida() {
        return datoSalida;
    }

    public void setDatoSalida(Object datoSalida) {
        this.datoSalida = datoSalida;
    }
    
}
