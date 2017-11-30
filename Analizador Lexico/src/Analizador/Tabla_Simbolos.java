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
    ArrayList<String[]> parametros=new ArrayList<String[]>();
    public Tabla_Simbolos(){
        nuevos_parametros(new String[]{"id","ENT",null,null,"DET"});
        //nuevos_parametros(new String[]{"id","FLO",null,null,"MOVAT"});
    }
    boolean nuevoSimbolo(String[] simbolo){
        //posición 0=Nombre
        //posición 1=Tipo
        //posición 2=Número de linea
        //posición 3=valor
        //posición 4=funcion de posicion
        //posición 5=id del arraylist de los parametros
        if(revisar(simbolo[0])){
            tabla.add(simbolo);
        }else{
            return false;
        }
        return true;
    }
    void nuevos_parametros(String[] arr){
        parametros.add(arr);
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
    boolean revisar_parametro(String nombre,String funcion){
        String[] aux;
        for(int i=0;i<parametros.size();i++){
            aux=parametros.get(i);
            if(aux[0].equals(nombre) && aux[4].equals(funcion)){
                return false;
            }
        }
        return true;
    }
    String sacarTipoParametro(String funcion,int index){
        String[] aux;
        int cont=0;
        for(int i=0;i<parametros.size();i++){
            aux=parametros.get(i);
            if(aux[4].equals(funcion)){
                if(cont==index){
                    return aux[1];
                }
                cont++;
            }
        }
        return null;
    }
    String sacarTipoParametro(String nombre,String funcion){
        String[] aux;
        int cont=0;
        for(int i=0;i<parametros.size();i++){
            aux=parametros.get(i);
            if(aux[4].equals(funcion) && aux[0].equals(nombre)){
                return aux[1];
            }
        }
        return null;
    }
    int contarParametros(String funcion){
        String[] aux;
        int cont=0;
        for(int i=0;i<parametros.size();i++){
            aux=parametros.get(i);
            if(aux[4].equals(funcion)){
                cont++;
            }
        }
        return cont;
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
    String sacarValorParametro(String nombre,String funcion){
        String[] aux;
        for(int i=0;i<parametros.size();i++){
            aux=parametros.get(i);
            if(aux[0].equals(nombre) && aux[4].equals(funcion)){
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
        return "";
    }
    boolean sacarFuncionParametro(String nombre,String funcion){
        String[] aux;
        for(int i=0;i<parametros.size();i++){
            aux=parametros.get(i);
            if(aux[0].equals(nombre) && aux[4].equals(funcion)){
                return true;
            }
        }
        return false;
    }
    String sacarTipo(String nombre){
        String[] aux;
        for(int i=0;i<tabla.size();i++){
            aux=tabla.get(i);
            if(aux[0].equals(nombre)){
                return aux[1];
            }
        }
        return "";
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
    boolean actualizar_parametro(String nombre,String valor){
        if(revisar(nombre)){
            return false;
        }
        String [] aux;
        for(int i=0;i<parametros.size();i++){
            aux=parametros.get(i);
            if(nombre.equals(aux[0])){
                aux[3]=valor;
                return true;
            }
        }
        return false;
    }
}
