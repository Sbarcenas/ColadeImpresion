/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estructura.colaimpresion.modelo;

/**
 *
 * @author Sjbárcenas
 */
public class Archivo {
    public static int id = 0;
    public String nombre;
    public double espera;

    public Archivo(String nombre, double espera) {
        this.nombre = nombre;
        this.espera = espera;
        ++id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEspera() {
        return espera;
    }

    public void setEspera(double espera) {
        this.espera = espera;
    }
    
    
}
