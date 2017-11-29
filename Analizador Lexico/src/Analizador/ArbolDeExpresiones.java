/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Pedro Gil
 */
public class ArbolDeExpresiones {
    String nodos="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolDeExpresiones a=new ArbolDeExpresiones();
        Scanner scan=new Scanner(System.in);
        System.out.print("Escribe una expresión aritmética solo puedes usar como operando las letras a, b, c\n");
        //String cad=scan.nextLine();
        ArrayList<String> cad=new ArrayList<String>();
        cad.add("1");
        cad.add("+");
        cad.add("1");
        a.crearArbol(cad, "z", 0);
        System.out.print(resultado);
    }
    public static double resultado=0;
    public String num1,num2;
    public void crearArbol(ArrayList<String> cadena,String papa,int pos){
        if(cadena.size()==1 && !(cadena.get(pos).equals("+") || cadena.get(pos).equals("-") || 
                cadena.get(pos).equals("*") || cadena.get(pos).equals("/")
                || cadena.get(pos).equals("(") || cadena.get(pos).equals(")"))){
            nodos+="Se insertó un nodo con valor "+cadena+", hijo de "+papa+"\n";
            if(num1!=null){
                num2=cadena.get(pos);
                switch(papa){
                    case "+":
                        resultado+=(Double.parseDouble(num1)+Double.parseDouble(num2));
                        break;
                    case "-":
                        resultado-=(Double.parseDouble(num1)+Double.parseDouble(num2));
                        break;
                    case "*":
                        resultado*=(Double.parseDouble(num1)+Double.parseDouble(num2));
                        break;
                    case "/":
                        resultado/=(Double.parseDouble(num1)+Double.parseDouble(num2));
                        break;
                }
                num1=num2=null;
            }
            if(num1==null){
                num1=cadena.get(pos);
            }
            return;
        }
        if(cadena.get(pos).equals("(")){
            if(!papa.equals("z")){
                //pos=buscarParentesis(cadena,0,0);
                cadena=reinsertar(cadena);
                if(verificarOp("+","-",pos,cadena," "," ") && verificarOp("*","/",pos,cadena,"+","-")){
                    crearArbol(reinsertar(cadena),papa,0);
                }else{
                    if(cadena.get(pos).equals("(")){
                        pos=buscarParentesisNoRestr(cadena,pos,0);
                    }crearArbol(cadena,papa,pos+1);
                }
            }else{
                pos=buscarParentesis(cadena,pos,0);
                crearArbol(cadena,papa,pos+1);
            }
        }else{
            if(cadena.get(pos).equals("+") || cadena.get(pos).equals("-")){
                if(verificarOp("+","-",pos+1,cadena," "," ")){
                    if(papa.equals("z")){
                            nodos+="Se insertó un nodo con valor "+cadena.get(pos)+" es raiz\n";
                        }else{
                            nodos+="Se insertó un nodo con valor "+cadena.get(pos)+", hijo de "+papa+"\n";
                        }
                    crearArbol(sacar(cadena,0,pos),cadena.get(pos),0);
                    crearArbol(sacar(cadena,pos+1,cadena.size()),cadena.get(pos),0);
                }else{
                    crearArbol(cadena,papa,pos+1);
                }
            }else{
                if(cadena.get(pos).equals("*") || cadena.get(pos).equals("/")){
                    if(verificarOp("*","/",pos+1,cadena,"+","-")){
                        if(papa.equals("z")){
                            nodos+="Se insertó un nodo con valor "+cadena.get(pos)+" es raiz\n";
                        }else{
                            nodos+="Se insertó un nodo con valor "+cadena.get(pos)+", hijo de "+papa+"\n";
                        }
                        crearArbol(reinsertar(cadena),cadena.get(pos),0);
                        crearArbol(reinsertar(cadena),cadena.get(pos),0);
                    }else{
                        crearArbol(cadena,papa,pos+1);
                    }
                }else{
                    crearArbol(cadena,papa,pos+1);
                }
            }
        }
    }
    public int buscarParentesis(ArrayList<String> cad, int pos,int counter){
        for(int i=pos+1;i<cad.size();i++){
            if(cad.get(i).equals(")") && counter==0){
                return i;
            }else{
                if(cad.get(i).equals("(")){
                    i=buscarParentesisNoRestr(cad,i,counter+1);
                }
            }
        }
        return -1;
    }
    public int buscarParentesisNoRestr(ArrayList<String> cad, int pos,int counter){
        for(int i=pos+1;i<cad.size();i++){
            if(cad.get(i).equals(")")){
                return i;
            }else{
                if(cad.get(i).equals("(")){
                    i=buscarParentesisNoRestr(cad,i,counter+1)+1;
                }
            }
        }
        return -1;
    }
    public boolean verificarOp(String op1,String op2,int pos,ArrayList<String> cad,String ex,String ex1){
        boolean aux=false;
        if(!ex.equals(" ") && !ex1.equals(" ")){
            aux=true;
        }
        for(int i=pos;i<cad.size();i++){
            if(cad.get(i).equals(op1) || cad.get(i).equals(op2)){
                return false;
            }
            if((cad.get(i).equals(ex) || cad.get(i).equals(ex1)) && aux){
                return false;
            }
            if(cad.get(i).equals("(")){
                i=buscarParentesis(cad,i,0);
            }
        }
        return true;
    }
    public ArrayList<String> reinsertar(ArrayList<String> cad){
        ArrayList<String> aux=new ArrayList<String>();
        for(int i=1;i<cad.size();i++){
            aux.add(cad.get(i));
        }
        return aux;
    }
    public ArrayList<String> sacar(ArrayList<String> arr,int posi,int posf){
        ArrayList<String> aux=new ArrayList<String>();
        for(;posi!=posf;posi++){
            aux.add(arr.get(posi));
        }
        return aux;
    }
}
