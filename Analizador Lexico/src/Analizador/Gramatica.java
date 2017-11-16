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
public class Gramatica {
    int i=0;
    public static String camino="";
    boolean resultado=true;
    public void programa(ArrayList<String> token){
        String aux=token.get(i);
        System.out.print(aux);
        if(aux.equals("FUNC")){
            i++;
            camino+="FUNC se va por programa\n";
            principal(token);
            if(i==token.size())return;
            if(token.get(i).equals("FUNC")){
                funciones(token);
            }
        }else{
            resultado=false;
        }
    }
    public void funciones(ArrayList<String>token){
        funcion(token);
        if(i==token.size())return;
        if(token.get(i).equals("FUNC")){
            funciones(token);
        }
    }
    public void funcion(ArrayList<String>token){
        camino+=token.get(i)+" se va por funcion\n";
        i++;
        if(token.get(i).equals("IDENTIFICADOR")){
            camino+=token.get(i)+" se va por funcion\n";
            i++;
            if(token.get(i).equals("(")){
                camino+=token.get(i)+" se va por funcion\n";
                i++;
                parametroSin(token);
                if(token.get(i).equals(")")){
                    camino+=token.get(i)+" se va por funcion\n";
                    i++;
                    if(token.get(i).equals(":")){
                        camino+=token.get(i)+" se va por funcion\n";
                        i++;
                        lineasCodigo(token);
                        if(token.get(i).equals(";")){
                            camino+=token.get(i)+" se va por funcion\n";
                            i++;
                            return;
                        }
                    }
                }
            }
        }
        resultado=false;
    }
    public void parametroSin(ArrayList<String> token){
        parametros(token);
    }
    public void parametros(ArrayList<String> token){
        if(token.get(i).equals("ENT")||token.get(i).equals("FLO")||token.get(i).equals("BOO")){
            camino+=token.get(i)+" se va por parametros";
            i++;
            if(token.get(i).equals("IDENTIFICADOR")){
                camino+=token.get(i)+" se va por parametros";
                i++;
                if(token.get(i).equals(",")){
                    camino+=token.get(i)+" se va por parametros";
                    i++;
                    parametros(token);
                }
            }
        }
    }
    public void principal(ArrayList<String> token){
        String aux=token.get(i);
        if(aux.equals("EFEC")){
            i++;
            camino+="EFEC se va por principal\n";
            aux=token.get(i);
            if(aux.equals(":")){
                i++;
                camino+=": se va por principal\n";
                lineasCodigo(token);
                aux=token.get(i);
                if(aux.equals(";")){
                    i++;
                    camino+="; se va por principal\n";
                    return;
                }else{
                    resultado=false;
                }
            }
        }
    }
    public void lineasCodigo(ArrayList<String> token){
        String aux=token.get(i);
        if(aux.equals(";") && token.size()==(i-1)){
            return;
        }else{
            lineaCodigo(token);
        }
    }
    //INCOMPLETO
    public void lineaCodigo(ArrayList<String> token){
        String aux=token.get(i);
        linea(token);
        if(token.get(i).equals("ENT")||token.get(i).equals("FLO")||token.get(i).equals("BOO")
                ||token.get(i).equals("COM")||token.get(i).equals("ACTM")
                ||token.get(i).equals("IDENTIFICADOR")
                ||token.get(i).equals("APG")||token.get(i).equals("CJT")||token.get(i).equals("CLX")
                    ||token.get(i).equals("DET")||token.get(i).equals("DETENTE")||token.get(i).equals("ECD")
                    ||token.get(i).equals("EXC")||token.get(i).equals("GIRAD")||token.get(i).equals("GIRAI")
                    ||token.get(i).equals("LUZ")||token.get(i).equals("MOVAD")||token.get(i).equals("MOVAT")
                    ||token.get(i).equals("SPD")){
            lineaCodigo(token);
        }
    }
    //INCOMPLETO
    public void linea(ArrayList<String> token){
        if(token.get(i).equals("APG")||token.get(i).equals("CJT")||token.get(i).equals("CLX")
                    ||token.get(i).equals("DET")||token.get(i).equals("DETENTE")||token.get(i).equals("ECD")
                    ||token.get(i).equals("EXC")||token.get(i).equals("GIRAD")||token.get(i).equals("GIRAI")
                    ||token.get(i).equals("LUZ")||token.get(i).equals("MOVAD")||token.get(i).equals("MOVAT")
                    ||token.get(i).equals("SPD")){
            camino+=token.get(i)+" se va por linea\n";    
            i++;
                if(token.get(i).equals("(")){
                    i++;
                    camino+="( se va por linea\n";
                    invocarMetodo(token);
                }
                if(token.get(i).equals("|")){
                    camino+="| se va por linea\n";
                    i++;
                }
            }
        if(token.get(i).equals("IDENTIFICADOR")){
            i++;
            switch(token.get(i)){
                case "(":
                        i++;
                        camino+="( se va por linea\n";
                        invocarMetodo(token);
                    break;
                case "=":
                        i++;
                        camino+="= se va por linea\n";
                        cambiarValor(token);
                    break;
            }
            if(token.get(i).equals("|")){
                i++;
                camino+="| se va por linea\n";
                return;
            }
        }
        if(token.get(i).equals("ENT")||token.get(i).equals("FLO")||token.get(i).equals("BOO")){
            crearVariable(token);
        }
        if(token.get(i).equals("COM")||token.get(i).equals("ACTM")){
            bucleCondicion(token);
        }
    }
    public void invocarMetodo(ArrayList<String> token){
        parametrosEnvio(token);
        if(token.get(i).equals(")")){
            i++;
            camino+=") se va por invocarMetodo\n";
            return;
        }else{
            resultado=false;
        }
    }
    //INCOMPLETO
    public void crearVariable(ArrayList<String> token){
        if(token.get(i).equals("ENT")||token.get(i).equals("FLO")||token.get(i).equals("BOO")){
            camino+=token.get(i)+" se va por crearVariable\n";
            i++;
            if(token.get(i).equals("IDENTIFICADOR")){
                camino+=token.get(i)+" se va por crearVariable\n";
                i++;
                switch(token.get(i)){
                    case "=":
                        camino+=token.get(i)+" se va por crearVariable\n";
                        i++;
                        expresion(token);
                        if(token.get(i).equals("|")){
                            camino+=token.get(i)+" se va por crearVariable\n";
                            i++;
                        }else{
                            resultado=false;
                        }
                    break;
                    case "|":
                        camino+=token.get(i)+" se va por crearVariable\n";
                        i++;
                        break;
                }
            }else{
                resultado=false;
            }
        }else{
            resultado=false;
        }
    }
    public void cambiarValor(ArrayList<String> token){
        cambValor(token);
    }
    //INCOMPLETO
    public void bucleCondicion(ArrayList<String> token){
        switch(token.get(i)){
            case "COM":
                condicionSi(token);
                break;
            case "ACTM":
                bucleWhile(token);
                break;
        }
    }
    public void bucleWhile(ArrayList<String> token){
        camino+=token.get(i)+" se va por bucleWhile";
        i++;
        if(token.get(i).equals("(")){
            camino+=token.get(i)+" se va por bucleWhile";
            i++;
            condicion(token);
            if(token.get(i).equals(")")){
                camino+=token.get(i)+" se va por bucleWhile";
                i++;
                if(token.get(i).equals(":")){
                    camino+=token.get(i)+" se va por bucleWhile";
                    i++;
                    lineasCodigo(token);
                    if(token.get(i).equals(";")){
                        camino+=token.get(i)+" se va por bucleWhile";
                        i++;
                        return;
                    }
                }
            }
        }
        resultado=false;
    }
    public void condicionSi(ArrayList<String> token){
        camino+="COM se va por condicionSi\n";
        i++;
        if(token.get(i).equals("(")){
            camino+="( se va por condicionSi\n";
            i++;
            condicion(token);
            if(token.get(i).equals(")")){
                camino+=token.get(i)+" se va por condicionSi\n";
                i++;
                if(token.get(i).equals(":")){
                    camino+=token.get(i)+" se va por condicionSi\n";
                    i++;
                    if(token.get(i).equals("S")){
                        camino+=token.get(i)+" se va por condicionSi\n";
                        i++;
                        if(token.get(i).equals(":")){
                            camino+=token.get(i)+" se va por condicionSi\n";
                            i++;
                            lineasCodigo(token);
                            if(token.get(i).equals(";")){
                                camino+=token.get(i)+" se va por condicionSi\n";
                                i++;
                                if(token.get(i).equals("SN")){
                                    camino+=token.get(i)+" se va por condicionSi\n";
                                    i++;
                                    if(token.get(i).equals(":")){
                                        camino+=token.get(i)+" se va por condicionSi\n";
                                        i++;
                                        lineasCodigo(token);
                                        if(token.get(i).equals(";")){
                                            camino+=token.get(i)+" se va por condicionSi\n";
                                            i++;
                                            if(token.get(i).equals(";")){
                                                camino+=token.get(i)+" se va por condicionSi\n";
                                                i++;
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            resultado=false;
        }
        resultado=false;
    }
    public void condicion(ArrayList<String> token){
        valor(token);
        condicional(token);
        valor(token);
    }
    public void condicional(ArrayList<String>token){
        if(token.get(i).equals("<")||token.get(i).equals(">")||token.get(i).equals("==")
                ||token.get(i).equals("<=")||token.get(i).equals(">=")||token.get(i).equals("!=")){
            camino+=token.get(i)+" se va por condicional\n";
            i++;
        }else{
            resultado=false;
        }
    }
    public void parametrosEnvio(ArrayList<String> token){
        if(token.get(i).equals(")")){
            return;
        }else{
            parEnvio(token);
        }
    }
    public void parEnvio(ArrayList<String> token){
        if(token.get(i).equals("IDENTIFICADOR")){
            camino+="IDENTIFICADOR se va por parEnvio\n";
            i++;
        }else{
            valor(token);
        }
        if(token.get(i).equals(",")){
            i++;
            parEnvio(token);
        }
    }
    public void valor(ArrayList<String> token){
        if(token.get(i).equals("NUM_FLOTANTE")||token.get(i).equals("NUM_ENTERO")||token.get(i).equals("IDENTIFICADOR")){
            camino+=token.get(i)+" se va por f\n";
            i++;
        }
        return;
    }
    public void cambValor(ArrayList<String> token){
        expresion(token);
    }
    public void expresion(ArrayList<String> token){
        if(token.get(i).equals("NUM_FLOTANTE")||token.get(i).equals("NUM_ENTERO")||token.get(i).equals("IDENTIFICADOR")){
            valor(token);
            if(token.get(i).equals("+")||token.get(i).equals("-")
                    || token.get(i).equals("*") || token.get(i).equals("/")){
                camino+=token.get(i)+" se va por epri\n";
                i++;
                epri(token);
            }else{
               
            }
            
        }
    }
    public void epri(ArrayList<String> token){
        if(token.get(i).equals("NUM_FLOTANTE")||token.get(i).equals("NUM_ENTERO")||token.get(i).equals("IDENTIFICADOR")){
            valor(token);
        }else{
            f(token);
        }
    }
    public void x(ArrayList<String> token){
        valor(token);
        if(token.get(i).equals("NUM_FLOTANTE")||token.get(i).equals("NUM_ENTERO")||token.get(i).equals("IDENTIFICADOR")){
            x(token);
        }else{
            f(token);
        }
    }
    public void f(ArrayList<String> token){
        if(token.get(i).equals("IDENTIFICADOR")){        
            i++;
        }else{
            if(token.get(i).equals("(")){
                camino+="( se va por f\n";
                expresion(token);
                if(token.get(i).equals(")")){
                    camino+=") se va por f\n";
                    i++;
                    return;
                }else{
                    resultado=false;
                }
            }
        }
    }
    public void asignValor(ArrayList<String> token){
        operAsignacion(token);
    }
    public void operAsignacion(ArrayList<String> token){
        switch(token.get(i)){
            case "IDENTIFICADOR":
                camino+=token.get(i)+" se va por crearVariable\n";
                i++;
                if(token.get(i).equals("(")){
                    invocarMetodo(token);
                }else{
                    expresion(token);
                }
                break;
            case "NUM_FLOTANTE":
                camino+=token.get(i)+" se va por crearVariable\n";
                expresion(token);
                break;
            case "NUM_ENTERO":
                camino+=token.get(i)+" se va por crearVariable\n";
                expresion(token);
                break;
            default: resultado=false;
        }
    }
}
