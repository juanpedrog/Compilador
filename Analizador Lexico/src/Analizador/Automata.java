/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;
import java.util.ArrayList;


/**
 *
 * @author pasto
 */
public class Automata {
    
    int contadorarr;
    int contadorp1;
    int contadorp2;
    int contadorpc1;
    int contadorpc2;
    boolean banderaux1;
    boolean banderaux2;
    boolean banderaux3;
    boolean banderaux4;
    boolean banderaux5;
    public static String camino="";
    public static boolean bandera=false;
    public static boolean errores=true;
    public Automata() {
        contadorarr=0;
        contadorp1=0;
        contadorp2=0;
        contadorpc1=0;
        contadorpc2=0;
        banderaux1=false;
        banderaux2=false;
        banderaux3=false;
        banderaux4=false;
        banderaux5=false;
        errores=true;
    }
    public String iniciar(ArrayList<String> lexers){
        camino="";
        contadorarr=0;
        contadorp1=0;
        contadorp2=0;
        contadorpc1=0;
        contadorpc2=0;
        banderaux1=false;
        banderaux2=false;
        banderaux3=false;
        banderaux4=false;
        bandera=false;
        errores=true;
        q0(lexers);
        return camino;
    }
    private void q0(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "FUNC":
                camino+="En q0 hacia q1 con FUNC \n";
                contadorarr++;
                q1(l);
                break;
            default:
                    camino+="Error en q0\n";
                    errores=false;
                break;
        }
    }
    private void q1(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "EFEC":
                camino+="En q1 hacia q2 con EFEC \n";
                contadorarr++;
                q2(l);
                break;
            default:
                    camino+="Error en q1\n";
                    errores=false;
                break;
        }
    }
    private void q2(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case ":":
                camino+="En q1 hacia q3 con : \n";
                contadorarr++;
                contadorpc1++;
                q3(l);
                break;
            default:
                    camino+="Error en q1\n";
                    errores=false;
                break;
        }
    }
    private void q3(ArrayList<String> l){
        if(contadorarr==l.size()){
            if(contadorpc1==contadorpc2 && contadorp1==contadorp2){
            bandera=true;
            return;
            }
            else if(contadorp1!=contadorp2){
                camino+="Error en q3 Faltan parentesis";
                errores=false;
                return;
            }
            else camino+="Error en q3 \" dos puntos \" y \" punto y coma \" concuerdan";
        }
        switch(l.get(contadorarr)){
            case ";":
                camino+="En q3 hacia q3 con ; \n";
                contadorarr++;
                contadorpc2++;
                q3(l);
                break;
            case "IDENTIFICADOR":
                camino+="En q3 hacia q4 con IDENTIFICADOR \n";
                contadorarr++;
                banderaux1=true;
                q4(l);
                break;
            case "APG":
                camino+="En q3 hacia q4 con APG \n";
                contadorarr++;
                q4(l);
                break;
            case "CJT":
                camino+="En q3 hacia q4 con CJT \n";
                contadorarr++;
                q4(l);
                break;
            case "CLX":
                camino+="En q3 hacia q4 con CLX \n";
                contadorarr++;
                q4(l);
                break;
            case "DET":
                camino+="En q3 hacia q4 con DET \n";
                contadorarr++;
                q4(l);
                break;
            case "ECD":
                camino+="En q3 hacia q4 con ECD \n";
                contadorarr++;
                q4(l);
                break;
            case "GIRAI":
                camino+="En q3 hacia q4 con GIRAI \n";
                contadorarr++;
                q4(l);
                break;
            case "GIRAD":
                camino+="En q3 hacia q4 con GIRAD \n";
                contadorarr++;
                q4(l);
                break;
            case "LUZ":
                camino+="En q3 hacia q4 con LUZ \n";
                contadorarr++;
                q4(l);
                break;
            case "MOVAD":
                camino+="En q3 hacia q4 con MOVAD \n";
                contadorarr++;
                q4(l);
                break;
            case "MOVAT":
                camino+="En q3 hacia q4 con MOVAT \n";
                contadorarr++;
                q4(l);
                break;
            case "EXC":
                camino+="En q3 hacia q4 con EXC \n";
                contadorarr++;
                q4(l);
                break;
            case "FUNC":
                if(contadorpc1==contadorpc2){
                    camino+="En q3 hacia q12 con FUNC \n";
                    contadorarr++;
                    q12(l);
                }
                else {
                    camino+="Error en q3 con FUNC, faltan ;";
                    errores=false;
                }
                break;
            case "ENT":
                camino+="En q3 hacia q17 con ENT \n";
                contadorarr++;
                q17(l);
                break;
            case "FLO":
                camino+="En q3 hacia q17 con FLO \n";
                contadorarr++;
                q17(l);
                break;
            case "BOO":
                camino+="En q3 hacia q17 con BOO \n";
                contadorarr++;
                q17(l);
                break;
            case "COM":
                camino+="En q3 hacia q25 con COM \n";
                banderaux2=true;
                contadorarr++;
                q25(l);
                break;
            case "ACTM":
                camino+="En q3 hacia q25 con ACTM";
                contadorarr++;
                q25(l);
                break;
            case "S" :
                if(banderaux2){
                    camino+="En q3 hacia q30 con S \n";
                    banderaux2=false;
                    banderaux3=true;
                    contadorarr++;
                    q30(l);
                }
                else { camino+="Error no hay COM anteriormente";
                    
                }
                break;
            case "SN":
                if(banderaux3){
                    camino+="En q3 hacia q30 con SN \n";
                    banderaux3=false;
                    contadorarr++;
                    q30(l);
                }
                else {
                    camino+="Error no hay S anteriormente";
                }
                break;
            
            default:
                    camino+="Error en q3\n";
                    errores=false;
                break;
        }
    }
    private void q4(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "=":
                if(banderaux1){
                    camino+="En q4 hacia q22 con = \n";
                    contadorarr++;
                    banderaux1=false;
                    q22(l);
                }
                else {
                    camino +="Error en q4 ";
                }
                break;
            case "(":
                camino+="En q4 hacia q5 con ( \n";
                contadorarr++;
                q5(l);
                break;
            default:
                    camino+="Error en q4\n";
                    errores=false;
                break;
        }
    }
    private void q5(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "IDENTIFICADOR":
                camino+="En q5 hacia q6 con IDENTIFICADOR";
                contadorarr++;
                q6(l);
                break;
            case "NUM_FLO":
                camino+="En q5 hacia q6 con NUM_FLO";
                contadorarr++;
                q6(l);
                break;
            case "NUM_ENT":
                camino+="En q5 hacia q6 con NUM_ENT";
                contadorarr++;
                q6(l);
                break;
            default:
                    camino+="Error en q5\n";
                    errores=false;
                break;
        }
    }
    private void q6(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case ")":
                camino+="En q6 hacia q8 con )";
                contadorarr++;
                q8(l);
                break;
            default:
                    camino+="Error en q6\n";
                    errores=false;
                break;
        } 
    }
    private void q7(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "IDENTIFICADOR":
                camino+="En q7 hacia q10 con IDENTIFICADOR";
                contadorarr++;
                q10(l);
                break;
            case "NUM_FLO":
                camino+="En q7 hacia q10 con NUM_FLO";
                contadorarr++;
                q10(l);
                break;
            case "NUM_ENT":
                camino+="En q7 hacia q10 con NUM_ENT";
                contadorarr++;
                q10(l);
                break;
            default:
                    camino+="Error en q7\n";
                    errores=false;
                break;
        }
    }
    private void q8(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "|":
                camino+="En q8 hacia q3 con |";
                contadorarr++;
                q3(l);
                break;
            default:
                    camino+="Error en q8\n";
                    errores=false;
                break;
        }
    }
    private void q10(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "|":
                camino+="En q10 hacia q3 con |";
                contadorarr++;
                q3(l);
                break;
            default:
                    camino+="Error en q10\n";
                    errores=false;
                break;
        }
    }
    private void q12(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "IDENTIFICADOR":
                    camino+="En q12 hacia q13 con IDENTIFICADOR\n";
                    contadorarr++;
                    q13(l);
                break;
            default:
                    camino+="Error en q12\n";
                    errores=false;
                break;
        }
    }
    private void q13(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "(":
                camino+="En q13 hacia q14 con ( \n";
                contadorarr++;
                q14(l);
                break;
            default:
                    camino+="Error en q13\n";
                    errores=false;
                break;
        }
    }
    private void q14(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "ENT":
                camino+="En q14 hacia q15 con ENT \n";
                contadorarr++;
                q15(l);
                break;
            case "BOO":
                camino+="En q14 hacia q15 con BOO \n";
                contadorarr++;
                q15(l);
                break;
            case "FLO":
                camino+="En q14 hacia q15 con FLO \n";
                contadorarr++;
                q15(l);
                break;
            case ")":
                camino+="En q14 hacia q16 con ) \n";
                contadorarr++;
                q16(l);
                break;
            default:
                    camino+="Error en q14\n";
                    errores=false;
                break;
        }
    }
    private void q15(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "IDENTIFICADOR":
                camino+="En q15 hacia q16 con IDENTIFICADOR \n";
                banderaux5=true;
                contadorarr++;
                q16(l);
                break;
            default:
                    camino+="Error en q15\n";
                    errores=false;
                break;
        }
    }
    private void q16(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case ",":
                if(banderaux5){
                camino+="En q16 hacia q14 con , \n";
                banderaux5=false;
                contadorarr++;
                q14(l);
                }
                else camino+="Error en q16 parametros mal establecidos";
                break;
            case ":":
                camino+="En q16 hacia q3 con : \n";
                contadorarr++;
                contadorpc1++;
                q3(l);
                break;
            default:
                    camino+="Error en q16\n";
                    errores=false;
                break;
        }
    }
    private void q17(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "IDENTIFICADOR":
                camino+="En q17 hacia q18 con IDENTIFICADOR \n";
                contadorarr++;
                banderaux4=true;
                q18(l);
                break;
            default:
                    camino+="Error en q17\n";
                    errores=false;
                break;
        }
    }
    private void q18(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "|":
                camino+="En q18 hacia q3 con | \n";
                contadorarr++;
                q3(l);
                break;
            case "=":
                if(banderaux4){
                    camino+="En q18 hacia q22 con = \n";
                    banderaux4=false;
                    contadorarr++;
                    q22(l);
                }else{
                    camino+="Error en q18 \n";
                    errores=false;
                }
                break;
            default:
                    camino+="Error en q18\n";
                    errores=false;
                break;
        }
    }
    private void q19(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "|":
                camino+="En q19 hacia q3 con | \n";
                contadorarr++;
                q3(l);
                break;
            case ")":
                camino+="En q19 hacia q19 con ) \n";
                contadorp2++;
                contadorarr++;
                q19(l);
                break;
            case "*":
                camino+="En q19 hacia q20 con * \n";
                contadorarr++;
                q20(l);
                break;
            case "/":
                camino+="En q19 hacia q20 con / \n";
                contadorarr++;
                q20(l);
                break;
            case "-":
                camino+="En q19 hacia q20 con - \n";
                contadorarr++;
                q20(l);
                break;
            case "+":
                camino+="En q19 hacia q20 con + \n";
                contadorarr++;
                q20(l);
                break;
            default:
                    camino+="Error en q18\n";
                    errores=false;
                break;
        }
    }
    private void q20(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "(":
                camino+="En q19 hacia q19 con ( \n";
                contadorp1++;
                contadorarr++;
                q22(l);
                break;
            case "IDENTIFICADOR":
                camino+="En q20 hacia q19 con IDENTIFICADOR \n";
                contadorarr++;
                q19(l);
                break;
            case "NUM_FLO":
                camino+="En q20 hacia q19 con NUM_FLO \n";
                contadorarr++;
                q19(l);
                break;
            case "NUM_ENT":
                camino+="En q20 hacia q19 con NUM_ENT \n";
                contadorarr++;
                q19(l);
                break;
            default:
                    camino+="Error en q18\n";
                    errores=false;
                break;
        }
    }
    private void q22(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "(":
                camino+="En q22 hacia q22 con ( \n";
                contadorp1++;
                contadorarr++;
                q22(l);
                break;
            case "NUM_FLO":
                camino+="En q22 hacia q19 con NUM_FLO \n";
                contadorarr++;
                q19(l);
                break;
            case "NUM_ENT":
                camino+="En q22 hacia q19 con NUM_ENT \n";
                contadorarr++;
                q19(l);
                break;
            case "IDENTIFICADOR":
                camino+="En q22 hacia q19 con IDENTIFICADOR \n";
                contadorarr++;
                q19(l);
                break;
            case "APG":
                camino+="En q22 hacia q4 con APG \n";
                contadorarr++;
                q4(l);
                break;
            case "CJT":
                camino+="En q22 hacia q4 con CJT \n";
                contadorarr++;
                q4(l);
                
                break;
            case "CLX":
                camino+="En q22 hacia q4 con CLX \n";
                contadorarr++;
                q4(l);
                break;
            case "DET":
                camino+="En q22 hacia q4 con DET \n";
                contadorarr++;
                q4(l);
                break;
            case "ECD":
                camino+="En q22 hacia q4 con ECD \n";
                contadorarr++;
                q4(l);
                break;
            case "GIRAI":
                camino+="En q22 hacia q4 con GIRAI \n";
                contadorarr++;
                q4(l);
                break;
            case "GIRAD":
                camino+="En q22 hacia q4 con GIRAD \n";
                contadorarr++;
                q4(l);
                break;
            case "LUZ":
                camino+="En q22 hacia q4 con LUZ \n";
                contadorarr++;
                q4(l);
                break;
            case "MOVAD":
                camino+="En q22 hacia q4 con MOVAD \n";
                contadorarr++;
                q4(l);
                break;
            case "MOVAT":
                camino+="En q22 hacia q4 con MOVAT \n";
                contadorarr++;
                q4(l);
                break;
            case "EXC":
                camino+="En q22 hacia q4 con EXC \n";
                contadorarr++;
                q4(l);
                break;
            default:
                    camino+="Error en q18\n";
                    errores=false;
                break;
        }
    }
    private void q25(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "(":
                camino+="En q25 hacia q26 con ( \n";
                contadorp1++;
                contadorarr++;
                q26(l);
                break;
            default:
                    camino+="Error en q25\n";
                    errores=false;
                break;
        }
    }
    private void q26(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "IDENTIFICADOR":
                camino+="En q26 hacia q27 con IDENTIFICADOR \n";
                contadorarr++;
                q27(l);
                break;
            case "NUM_FLO":
                camino+="En q26 hacia q27 con NUM_FLO \n";
                contadorarr++;
                q27(l);
                break;
            case "NUM_ENT":
                camino+="En q26 hacia q27 con NUM_ENT \n";
                contadorarr++;
                q27(l);
                break;
            default:
                    camino+="Error en q26\n";
                    errores=false;
                break;
        }
    }
    private void q27(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case "==":
                camino+="En q27 hacia q28 con == \n";
                contadorarr++;
                q28(l);
                break;
            case ">=":
                camino+="En q27 hacia q28 con >= \n";
                contadorarr++;
                q28(l);
                break;
            case "<=":
                camino+="En q27 hacia q28 con <= \n";
                contadorarr++;
                q28(l);
                break;
            case "!=":
                camino+="En q27 hacia q28 con != \n";
                contadorarr++;
                q28(l);
                break;
            case "<":
                camino+="En q27 hacia q28 con < \n";
                contadorarr++;
                q28(l);
                break;
            case ">":
                camino+="En q27 hacia q28 con > \n";
                contadorarr++;
                q28(l);
                break;
            default:
                    camino+="Error en q27\n";
                    errores=false;
                break;
        }
    }
    private void q28(ArrayList<String> l){
        switch (l.get(contadorarr)) {
            case "IDENTIFICADOR":
                camino += "En q28 hacia q29 con IDENTIFICADOR \n";
                contadorarr++;
                q29(l);
                break;
            case "NUM_FLO":
                camino += "En q28 hacia q29 con NUM_FLO \n";
                contadorarr++;
                q29(l);
                break;
            case "NUM_ENT":
                camino += "En q28 hacia q29 con NUM_ENT \n";
                contadorarr++;
                q29(l);
                break;
            default:
                camino += "Error en q28\n";
                break;
        }
    }
    private void q29(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case ")":
                camino+="En q29 hacia q30 con ) \n";
                contadorp2++;
                contadorarr++;
                q30(l);
                break;
            default:
                    camino+="Error en q29\n";
                    errores=false;
                break;
        }
    }
    private void q30(ArrayList<String> l){
        switch(l.get(contadorarr)){
            case ":":
                camino+="En q30 hacia q3 con : \n";
                contadorpc1++;
                contadorarr++;
                q3(l);
                break;
            default:
                    camino+="Error en q30\n";
                    errores=false;
                break;
        }
    }
}
