/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estructura.colaimpresion.controlador;

import com.estructura.colaimpresion.modelo.*;
import com.estructura.colaimpresion.modelo.ColaImpresion;
import com.estructura.colaimpresion.vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sjbárcenas
 */
public class Controlador implements ActionListener{

  private ColaImpresion queuImpresion;
  private Cola queue;
  private Nodo node;
  private Vista view;
  public ColaImpresion colaImpresion = new ColaImpresion();
  
  public Controlador(ColaImpresion queueImpresion, Vista view){
      this.view = view;
      this.queuImpresion = queueImpresion;
      this.view.btnCargarDatos.addActionListener(this);
      this.view.btnIniciarSimulacion.addActionListener(this);
      this.view.bntSalir.addActionListener(this);
  }
  
  public void iniciar(){
      view.setTitle("Cola de Impresión");
      view.setLocationRelativeTo(null);
      view.setVisible(true);
  }
  
    private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              
                                            
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.btnCargarDatos == e.getSource()){
            String[] divisor;
            String cadena;
            Cola<Archivo> archivos = new Cola();
            try {
                //Cargar Datos
                
                FileReader f = new FileReader("spool.txt");
                BufferedReader b = new BufferedReader(f);
                while((cadena = b.readLine())!=null) {
                divisor = cadena.split(",");
                colaImpresion.enqueue(new Archivo(divisor[0], Double.parseDouble(divisor[1])));
                
        }
        colaImpresion.display();
        b.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(view.bntSalir ==e.getSource()){
        //Salir    
        }
        else if(view.btnIniciarSimulacion ==e.getSource()){
        //Iniciar Simulación  
        }
        
    }
  }

