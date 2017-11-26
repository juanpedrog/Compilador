/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.util.ArrayList;

/**
 *
 * @author Juan Pedro Gil
 */
public class Tabla_Simbolos {
    ArrayList<String[]> tabla=new ArrayList<String[]>();
    boolean nuevoSimbolo(String[] simbolo){
        //posición 0=Nombre
        //posición 1=Tipo
        //posición 2=Número de linea
        //posición 3=valor
        //posición 4=funcion de posicion
        if(revisar(simbolo[0])){
            tabla.add(simbolo);
        }else{
            return false;
        }
        return true;
    }
    boolean revisar(String nombre){
        String[] aux;
        for(int i=0;i<tabla.size();i++){
            aux=tabla.get(i);
            if(aux[0].equals(nombre)){
                return false;
            }
        }
        return true;
    }
    String sacarValor(String nombre){
        String[] aux;
        for(int i=0;i<tabla.size();i++){
            aux=tabla.get(i);
            if(aux[0].equals(nombre)){
                return aux[3];
            }
        }
        return null;
    }
    String sacarFuncion(String nombre){
        String[] aux;
        for(int i=0;i<tabla.size();i++){
            aux=tabla.get(i);
            if(aux[0].equals(nombre)){
                return aux[4];
            }
        }
        return null;
    }
    String sacarTipo(String nombre){
        String[] aux;
        for(int i=0;i<tabla.size();i++){
            aux=tabla.get(i);
            if(aux[0].equals(nombre)){
                return aux[1];
            }
        }
        return null;
    }
    public void inicializar(){
        tabla=new ArrayList<String[]>();
    }
    boolean actualizar(String nombre,String valor){
        if(revisar(nombre)){
            return false;
        }
        String [] aux;
        for(int i=0;i<tabla.size();i++){
            aux=tabla.get(i);
            if(nombre.equals(aux[0])){
                aux[3]=valor;
                return true;
            }
        }
        return false;
    }
}
