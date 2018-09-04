/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estructura.colaimpresion.controlador;

import com.estructura.colaimpresion.modelo.*;
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

  private Cola<Archivo> queueI = new Cola<>();
  private Vista view;
  
  public Controlador(Vista view){
      this.view = view;
      this.view.btnCargarDatos.addActionListener(this);
      this.view.btnIniciarSimulacion.addActionListener(this);
      this.view.bntSalir.addActionListener(this);
       
       
  }
  
  public void iniciar(){
      view.setTitle("Cola de Impresión");
      view.setLocationRelativeTo(null);
      view.setVisible(true);
      
    
      
  }
  
  public void cargar(){
        /*CARGA DE ELEMENTOS*/
             String[] divisor;
            String cadena;
            FileReader f;
            BufferedReader b;
            Cola<Archivo> archivos = new Cola<Archivo>();
            try {
                //Cargar Datos
                
                f = new FileReader("spool.txt");
                b = new BufferedReader(f);
                
                while(( cadena = b.readLine())!= null) {
                
                divisor = cadena.split(",");
                queueI.enqueue(new Archivo(divisor[0], Double.parseDouble(divisor[1])));
                    System.out.println(queueI.top); 
                
                }
                b.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
      
  }
  
    public void actualizar(){
    
    Nodo<Archivo> nodo = queueI.top;
    view.md.removeAllElements();

    while (nodo != null) {

    System.out.println(nodo.getValor().getNombre());
    view.md.addElement(nodo.getValor().getNombre());

    nodo=nodo.getLink();
    }
    }

  
    private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }       
    
                                       
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.btnCargarDatos == e.getSource()){
          cargar();
         actualizar();
        }else if(view.bntSalir ==e.getSource()){
        //Salir    
            view.dispose();
        }
        else if(view.btnIniciarSimulacion ==e.getSource()){
        //Iniciar Simulación  
        }
        
    }
       
  }

