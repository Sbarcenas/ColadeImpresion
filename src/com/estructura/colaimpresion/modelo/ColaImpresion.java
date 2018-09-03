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
public class ColaImpresion extends Cola{
    public Cola<Archivo> archivos = new Cola();
    public ColaImpresion(){
        
    }

    public Cola<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(Cola<Archivo> archivos) {
        this.archivos = archivos;
    }
  
    
    public static void countDown(){
        
    }
   
    @Override
    public void display(){
       
    }
    
}

