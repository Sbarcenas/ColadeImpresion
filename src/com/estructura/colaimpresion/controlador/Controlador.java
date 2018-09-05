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
import java.util.Timer;
import java.util.TimerTask;
import com.estructura.colaimpresion.vista.Simulacion;

/**
 *
 * @author Sjbárcenas
 */
public class Controlador implements ActionListener, Runnable {

  public Cola<Archivo> queueI = new Cola<>();
  private Vista view;
  public Timer timer;
  public Timer timers;
  Simulacion panel;
 
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
            view.btnIniciarSimulacion.setEnabled(true);
  }
  
    public void actualizar(){
    
    Nodo<Archivo> nodo = queueI.top;
    view.md.removeAllElements();

    while (nodo != null) {

    view.md.addElement(nodo.getValor().getId()+" . "+nodo.getValor().getNombre());

    nodo=nodo.getLink();
    }
    }
    
    public void timer(){
        
        timers = new Timer();
        int delay = 0;
        int period = 10000+(int)(queueI.top.getValor().getEspera()*1000);
        timers.scheduleAtFixedRate(new TimerTask() {
        Nodo<Archivo> node = queueI.top;
        int b=0;
        int ways = queueI.size;
        @Override
        
        public void run() {
            b++;
            if(queueI.top == null){
                view.btnIniciarSimulacion.setEnabled(true);
                timers.cancel();
            }else{
            one();
            }
            }
        }, delay, period);
      
    } 
    public void crearJdialog(){
    this.panel= new Simulacion(view, false);
    panel.setLocationRelativeTo(null);
    panel.setVisible(true);
    }
    
    public void one(){
       
    timer = new Timer();
        int delay = 0;
        int period = 1000;
        crearJdialog();
        timer.scheduleAtFixedRate(new TimerTask() {
        int rounds = (int) queueI.top.getValor().getEspera();
        int i = 0;
        int dec = (int) queueI.top.getValor().getEspera();
        
        @Override
        
        public void run() {
        
        i++;
        
        panel.setVisible(true);
        panel.lblArchivo.setText(queueI.top.getValor().getNombre().toString());
        panel.lblEspera.setText("Espere... " + dec--);
        System.out.println(i);
        
        if(rounds == i){
        queueI.dequeue();        
        actualizar(); 
        panel.setVisible(false);
        timer.cancel();      
        }
        
        }
        
        
        
        }, delay, period);
        
    }
                                       
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.btnCargarDatos == e.getSource()){
         cargar();
         actualizar();
        }else if(view.bntSalir ==e.getSource()){
        //Salir    
            
            System.exit(0);
            
        }
        else if(view.btnIniciarSimulacion ==e.getSource()){
           timer();
           view.btnIniciarSimulacion.setEnabled(false);
        }
    }

    @Override
    public void run() {
    one();
    }
       
  }

