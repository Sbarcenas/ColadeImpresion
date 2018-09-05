/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estructura.colaimpresion.main;

import com.estructura.colaimpresion.controlador.Controlador;
import com.estructura.colaimpresion.vista.*;

/**
 *
 * @author Sjbárcenas
 */
public class Impresion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Vista view = new Vista();
        Controlador controler = new Controlador (view);
        
        controler.iniciar();
        
    }
    
}
